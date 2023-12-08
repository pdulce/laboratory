package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.ActividadReduced;
import giss.mad.itinerario.repository.itinerario.ActividadQARepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;
import giss.mad.itinerario.util.PesoComparator;
import giss.mad.itinerario.util.UmbralComparator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Service
public class ActividadQAService {

    private static final String ACTIVIDADES_CACHE = "actividades-cache";
    @Autowired
    private ActividadQARepository actividadQARepository;

    @Autowired
    private UmbralActividadRepository umbralActividadRepository;

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private EtapaPruebasRepository etapaPruebasRepository;

    @Autowired
    private CacheManager cacheManager;

    public final void setCacheManager(final CacheManager cacheManager) {
        this.cacheManager = cacheManager;
        if (cacheManager != null && !cacheManager.getCacheNames().isEmpty()) { //for tests-compliance
            this.actividadQARepository.findInOrderActivitiesWithoutChildren(
                    Sort.by(Sort.Order.asc("testingStageId"))).forEach((act) -> {
                this.getCachedActivity(act.getId());
            });
        }
    }

    private ActividadQA getCachedActivity(final Integer idActivity) {
        ActividadQA activity;
        if (cacheManager == null || cacheManager.getCacheNames().isEmpty()) { //for tests-comp
            activity = this.actividadQARepository.findByIdWithoutChildren(idActivity);
        } else {
            Cache cacheActividades = this.cacheManager.getCache(ACTIVIDADES_CACHE);
            if (cacheActividades.get(idActivity) == null) {
                activity = this.actividadQARepository.findByIdWithoutChildren(idActivity);
                if (activity != null) {
                    cacheActividades.put(idActivity, activity);
                }
            } else {
                SimpleValueWrapper cachedVal = (SimpleValueWrapper) cacheActividades.get(idActivity);
                if (cachedVal != null) {
                    activity = (ActividadQA) cachedVal.get();
                } else {
                    activity = this.actividadQARepository.findByIdWithoutChildren(idActivity);
                    cacheActividades.put(idActivity, activity);
                }
            }
        }
        return activity;
    }
    public final void setActividadQARepository(final ActividadQARepository actividadQARepository) {
        this.actividadQARepository = actividadQARepository;
    }

    public final void setEtapaPruebasRepository(final EtapaPruebasRepository etapaPruebasRepository) {
        this.etapaPruebasRepository = etapaPruebasRepository;
    }

    public final void setPesoRepository(final PesoRepository pesoRepository) {
        this.pesoRepository = pesoRepository;
    }

    public final void setUmbralActividadRepository(final UmbralActividadRepository umbralActividadRepository) {
        this.umbralActividadRepository = umbralActividadRepository;
    }

    public final Collection<ActividadReduced> getIdAndNameOfActivities() {
        List<ActividadReduced> listaActividadesReduced = new ArrayList<>();
        List<ActividadQA> all = this.actividadQARepository.findInOrderActivitiesWithoutChildren(
                Sort.by("testingStageId", "id"));
        for (ActividadQA actividadQA : all) {
            ActividadReduced newAct = new ActividadReduced(actividadQA.getId(), actividadQA.getName());
            listaActividadesReduced.add(newAct);
        }
        return listaActividadesReduced;
    }
    public final List<ActividadQA> getAllInAdmonService() {
        return this.actividadQARepository.findInOrderActivitiesWithoutChildren(
                Sort.by("testingStageId", "id"));
    }
    public final ActividadQA getAllInfoById(final Integer idActividadQA) {
        ActividadQA activ = this.actividadQARepository.findByIdAndDeletedIsNull(idActividadQA);
        if (cacheManager != null) {
            activ.getPesos().sort(new PesoComparator());
            activ.getUmbrales().sort(new UmbralComparator());
        }
        return activ;
    }

    @Cacheable(cacheNames = "actividades-cache")
    public final ActividadQA get(final Integer idActividadQA) {
        return getCachedActivity(idActividadQA);
    }

    @Transactional
    public final ActividadQA borradoLogico(final Integer idActividadQA) {
        ActividadQA actividad = this.get(idActividadQA);
        if (actividad != null) {
            Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            actividad.setUpdateDate(timeStamp);
            actividad.setName(actividad.getName() + "[deleted at " + timeStamp.getTime() + "]");
            actividad.setDeleted(1);
            this.actividadQARepository.save(actividad);

            //borramos sus pesos y umbrales
            Peso pesoFilter = new Peso();
            pesoFilter.setActivityId(idActividadQA);
            Collection<Peso> pesos = this.pesoRepository.findAll(Example.of(pesoFilter));
            this.pesoRepository.deleteAll(pesos);

            UmbralActividad umbralFilter = new UmbralActividad();
            umbralFilter.setActivityId(idActividadQA);
            Collection<UmbralActividad> umbrales = this.umbralActividadRepository.findAll(Example.of(umbralFilter));
            this.umbralActividadRepository.deleteAll(umbrales);

            if (actividad != null && cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
                // for tests-compliance
                Cache cache = this.cacheManager.getCache(ACTIVIDADES_CACHE);
                cache.evict(idActividadQA);
            }
        }
        return actividad;
    }

    @Transactional
    public final ActividadQA insertar(final ActividadQA actividadQA) {
        actividadQA.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        String nameOfEtapa = "";
        if (actividadQA.getTestingStageId() != null) {
            nameOfEtapa = this.etapaPruebasRepository.findByIdAndDeletedIsNull(actividadQA.getTestingStageId())
                .getName();
        }
        actividadQA.setStageQAName(nameOfEtapa);
        ActividadQA actividadQAsaved = this.actividadQARepository.save(actividadQA);
        if (actividadQAsaved != null && cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
            // for tests-compliance
            Cache cache = this.cacheManager.getCache(ACTIVIDADES_CACHE);
            cache.put(actividadQAsaved.getId(), actividadQAsaved);
        }
        return actividadQAsaved;
    }

    @Transactional
    public final ActividadQA actualizar(final ActividadQA actividadQAInput) {
        ActividadQA updatedObject = this.actividadQARepository.findByIdAndDeletedIsNull(actividadQAInput.getId());
        if (updatedObject != null) {
            actividadQAInput.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            actividadQAInput.setCreationDate(updatedObject.getCreationDate());
            actividadQAInput.setUmbrales(updatedObject.getUmbrales());
            actividadQAInput.setPesos(updatedObject.getPesos());

            updatedObject = this.actividadQARepository.save(actividadQAInput);
            String nameOfEtapa = "";
            if (actividadQAInput.getTestingStageId() != null) {
                nameOfEtapa = this.etapaPruebasRepository.findByIdAndDeletedIsNull(updatedObject.getTestingStageId())
                    .getName();
            }
            updatedObject.setStageQAName(nameOfEtapa);
            if (updatedObject != null && cacheManager != null && !cacheManager.getCacheNames().isEmpty()) {
                // for tests-compliance
                Cache cache = this.cacheManager.getCache(ACTIVIDADES_CACHE);
                cache.evict(updatedObject.getId());
                cache.put(updatedObject.getId(), updatedObject);
            }
        }
        return updatedObject;
    }

    @Transactional
    public final ActividadQA actualizarPesos(final ActividadQA actividadQAInput) {
        ActividadQA updatedObject = this.actividadQARepository.findByIdAndDeletedIsNull(actividadQAInput.getId());
        if (updatedObject != null) {
            String nameOfEtapa = "";
            if (updatedObject.getTestingStageId() != null) {
                nameOfEtapa = this.etapaPruebasRepository.findByIdAndDeletedIsNull(updatedObject.getTestingStageId())
                    .getName();
            }
            updatedObject.setStageQAName(nameOfEtapa);
            //tomamos los pesos de la entrada
            for (Peso peso : actividadQAInput.getPesos()) {
                Peso pesoBBDD = this.pesoRepository.findByIdAndDeletedIsNull(peso.getId());
                pesoBBDD.setWeightValue(peso.getWeightValue());
                pesoBBDD.setForDelivery(peso.getForDelivery());
                pesoBBDD.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                this.pesoRepository.save(pesoBBDD);
            }
            updatedObject.getPesos().sort(new PesoComparator());
            updatedObject.getUmbrales().sort(new UmbralComparator());
        }

        return updatedObject;
    }

    @Transactional
    public final ActividadQA actualizarUmbrales(final ActividadQA actividadQAInput) {
        ActividadQA updatedObject = this.actividadQARepository.findByIdAndDeletedIsNull(actividadQAInput.getId());
        if (updatedObject != null) {
            String nameOfEtapa = "";
            if (updatedObject.getTestingStageId() != null) {
                nameOfEtapa = this.etapaPruebasRepository.findByIdAndDeletedIsNull(updatedObject.getTestingStageId())
                    .getName();
            }
            updatedObject.setStageQAName(nameOfEtapa);
            //tomamos los umbrales de la entrada
            for (UmbralActividad umbralActividad : actividadQAInput.getUmbrales()) {
                UmbralActividad umbralActividadBBDD = this.umbralActividadRepository.findByIdAndDeletedIsNull(
                    umbralActividad.getId());
                umbralActividadBBDD.setLowerLimit(umbralActividad.getLowerLimit());
                umbralActividadBBDD.setUpperLimit(umbralActividad.getUpperLimit());
                umbralActividadBBDD.setThreshold(umbralActividad.getThreshold());
                umbralActividadBBDD.setForDelivery(umbralActividad.getForDelivery());
                umbralActividadBBDD.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                this.umbralActividadRepository.save(umbralActividadBBDD);
            }
            updatedObject.getPesos().sort(new PesoComparator());
            updatedObject.getUmbrales().sort(new UmbralComparator());
        }

        return updatedObject;
    }
}
