package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.ActividadQAPantalla;
import giss.mad.itinerario.model.volatilentities.StagePantalla;
import giss.mad.itinerario.model.volatilentities.UmbralGraph;
import giss.mad.itinerario.repository.itinerario.ActividadQARepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UmbralActividadService {

    public static final int[] AXE = {Constantes.NUMBER_0, Constantes.NUMBER_1, Constantes.NUMBER_2,
        Constantes.NUMBER_3, Constantes.NUMBER_4, Constantes.NUMBER_5, Constantes.NUMBER_6, Constantes.NUMBER_7,
        Constantes.NUMBER_8, Constantes.NUMBER_9, Constantes.NUMBER_10, Constantes.NUMBER_11, Constantes.NUMBER_12,
        Constantes.NUMBER_13, Constantes.NUMBER_14, Constantes.NUMBER_15, Constantes.NUMBER_16, Constantes.NUMBER_17,
        Constantes.NUMBER_18, Constantes.NUMBER_19, Constantes.NUMBER_20, Constantes.NUMBER_21, Constantes.NUMBER_22,
        Constantes.NUMBER_23 };

    @Autowired
    private UmbralActividadRepository umbralActividadRepository;
    @Autowired
    private EtapaPruebasRepository etapaPruebasRepository;
    @Autowired
    private ActividadQARepository actividadRepository;
    @Autowired
    private PesoRepository pesoRepository;

    public final void setUmbralActividadRepository(final UmbralActividadRepository umbralActividadRepository) {
        this.umbralActividadRepository = umbralActividadRepository;
    }

    public final void setEtapaPruebasRepository(final EtapaPruebasRepository etapaPruebasRepository) {
        this.etapaPruebasRepository = etapaPruebasRepository;
    }

    public final void setActividadRepository(final ActividadQARepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public final void setPesoRepository(final PesoRepository pesoRepository) {
        this.pesoRepository = pesoRepository;
    }

    public final List<UmbralActividad> getAll() {
        return this.umbralActividadRepository.findAllByDeletedIsNull();
    }

    public final List<UmbralGraph> getUmbralesByTypeOfElement(final Integer idElementType,
        final Integer isDelivery) {
        List<UmbralActividad> c = this.umbralActividadRepository
            .findAllByDeletedIsNullAndElementTypeIdAndForDelivery(idElementType, isDelivery);
        if (c == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<UmbralGraph> umbrales = new ArrayList<>();
        for (UmbralActividad umbral : c) {
            ActividadQA actividad = this.actividadRepository.findByIdWithoutChildren(umbral.getActivityId());
            EtapaPruebas etapaPruebas = this.etapaPruebasRepository.findByIdAndDeletedIsNull(
                actividad.getTestingStageId());
            UmbralGraph umbralGraph = new UmbralGraph(etapaPruebas.getName() + " - " + actividad.getName(),
                umbral.getActivityId(), umbral.getLowerLimit(),
                umbral.getUpperLimit(), umbral.getThreshold());
            umbrales.add(umbralGraph);
        }
        return umbrales;
    }

    @Transactional
    public final UmbralActividad removePhysical(final Integer idUmbral) {
        UmbralActividad umbral = this.get(idUmbral);
        this.umbralActividadRepository.delete(umbral);
        return umbral;
    }

    public final Collection<StagePantalla> getUmbralesByStage(final Integer idElementType, final Integer isDelivery) {
        Collection<UmbralActividad> c = this.umbralActividadRepository
            .findAllByDeletedIsNullAndElementTypeIdAndForDelivery(idElementType, isDelivery);
        if (c == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        List<StagePantalla> stages4Bubles = new ArrayList<>();
        for (UmbralActividad umbral : c) {
            ActividadQA actividadQA = this.actividadRepository.findByIdWithoutChildren(umbral.getActivityId());

            ActividadQAPantalla act4Screen = new ActividadQAPantalla();
            act4Screen.setId(actividadQA.getId());
            act4Screen.setActivity(actividadQA.getName());
            act4Screen.setActivityShort(actividadQA.getShortName());
            //act4Screen.setValue(umbral.getUpperLimit() - umbral.getLowerLimit());
            //act4Screen.setRealization(umbral.getThreshold());

            List<ActividadQAPantalla> actividadQAPantallas;
            String stageName = this.etapaPruebasRepository.findByIdAndDeletedIsNull(actividadQA.getTestingStageId())
                .getName();
            StagePantalla stageBuble = search(stages4Bubles, actividadQA.getTestingStageId());
            if (stageBuble != null) {
                actividadQAPantallas = stageBuble.getActivities();
                actividadQAPantallas.add(act4Screen);
            } else {
                stageBuble = new StagePantalla();
                actividadQAPantallas = new ArrayList<>();
                actividadQAPantallas.add(act4Screen);
                stageBuble.setActivities(actividadQAPantallas);
                stageBuble.setIdStage(actividadQA.getTestingStageId());
                stageBuble.setStage(stageName);
                stages4Bubles.add(stageBuble);
            }
        }
        stages4Bubles.sort((o1, o2) -> {
            int retorno = 0;
            if (o1.getIdStage() > o2.getIdStage()) {
                retorno = 1;
            } else if (o1.getIdStage() < o2.getIdStage()) {
                retorno = -1;
            }
            return retorno;
        });
        return stages4Bubles;
    }

    private StagePantalla search(final List<StagePantalla> stages4Bubles, final Integer stageId) {
        StagePantalla searched = null;
        int index = 0;
        while (searched == null && index < stages4Bubles.size()) {
            StagePantalla stageOflist = stages4Bubles.get(index++);
            if (stageOflist.getIdStage().intValue() == stageId.intValue()) {
                searched = stageOflist;
            }
        }
        return searched;
    }

    public final UmbralActividad get(final Integer idUmbral) {
        return this.umbralActividadRepository.findByIdAndDeletedIsNull(idUmbral);
    }

    @Transactional
    public final UmbralActividad save(final UmbralActividad umbralActividad) {
        return this.umbralActividadRepository.save(umbralActividad);
    }

    @Transactional
    public final UmbralActividad update(final UmbralActividad umbralActividad) {
        UmbralActividad updatedObject = null;
        if (this.umbralActividadRepository.findByIdAndDeletedIsNull(umbralActividad.getId()) != null) {
            updatedObject = this.umbralActividadRepository.save(umbralActividad);
        }
        return updatedObject;
    }

    private Integer maxOf(final List<Peso> pesosDeEje) {
        int max = Constantes.NUMBER_0;
        for (Peso peso : pesosDeEje) {
            if (max < peso.getWeightValue()) {
                max = peso.getWeightValue();
            }
        }
        return max;
    }

    public final Integer getMaximumOfWeigths(final Integer elementType, final Integer isDelivery,
        final Integer idActivity) {
        Integer sumaOfMaxAxisPesosForActivity = Constantes.NUMBER_0;
        for (int i = Constantes.NUMBER_1; i < AXE.length - Constantes.NUMBER_1; i++) {
            sumaOfMaxAxisPesosForActivity += maxOf(
                this.pesoRepository.
                        findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                    elementType, idActivity, AXE[i], isDelivery));
        }
        return sumaOfMaxAxisPesosForActivity;
    }

}
