package giss.mad.itinerario.service;

import giss.mad.itinerario.model.filters.ItinerarioFilter;
import giss.mad.itinerario.model.itinerario.UmbralPactado;
import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.model.itinerario.ItinerarioCalidad;
import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.ActividadQAPantalla;
import giss.mad.itinerario.model.volatilentities.StagePantalla;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.ItinerarioCalidadRepository;
import giss.mad.itinerario.repository.itinerario.SituacionItinerarioRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;
import giss.mad.itinerario.util.ActivityItineraryComparator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service public class ItinerarioCalidadService {

    @Autowired
    private ItinerarioCalidadRepository itinerarioCalidadRepository;
    @Autowired
    private ActividadQAService actividadQAService;
    @Autowired
    private EtapaPruebasRepository etapaPruebasRepository;
    @Autowired
    private UmbralActividadRepository umbralActividadRepository;
    @Autowired
    private SituacionItinerarioRepository situacionItinerarioRepository;

    public final void setItinerarioCalidadRepository(final ItinerarioCalidadRepository itinerarioCalidadRepository) {
        this.itinerarioCalidadRepository = itinerarioCalidadRepository;
    }

    public final void setActividadQAService(final ActividadQAService actividadQAService) {
        this.actividadQAService = actividadQAService;
    }

    public final void setEtapaPruebasRepository(final EtapaPruebasRepository etapaPruebasRepository) {
        this.etapaPruebasRepository = etapaPruebasRepository;
    }

    public final void setSituacionItinerarioRepository(final SituacionItinerarioRepository
                                                               situacionItinerarioRepository) {
        this.situacionItinerarioRepository = situacionItinerarioRepository;
    }

    public final void setUmbralActividadRepository(final UmbralActividadRepository umbralActividadRepository) {
        this.umbralActividadRepository = umbralActividadRepository;
    }


    public final List<ItinerarioCalidad> getAll() {
        return this.itinerarioCalidadRepository.findAll();
    }

    public final Double getAvance(final Integer id) {
        return this.itinerarioCalidadRepository.getAvanceById(id);
    }
    public final Page<ItinerarioCalidad> getPageAllItinerariosByIdElement(final Pageable pageable,
                                                                          final Integer idElementoOrEntrega) {
        return this.itinerarioCalidadRepository.getItinerariesPagingByCatId(pageable, idElementoOrEntrega);
    }

    public final Page<ItinerarioCalidad> getPageAllItinerariosByIdElementOrEntrega(final Pageable pageable,
                                                                                   final Integer idElementoOrEntrega,
                                                                                     final Integer isDelivery) {
        return this.itinerarioCalidadRepository.getItinerariesPagingByCatAndDeliveryId(pageable, idElementoOrEntrega,
                isDelivery);
    }

    public final ItinerarioCalidad getItinerarioMasRecienteByIdElementOrEntrega(final Integer idElementoOrEntrega,
                                                                                final Integer isDelivery) {
        ItinerarioCalidad retorno = null;
        List<ItinerarioCalidad> itinerariosCalidad = this.itinerarioCalidadRepository.
                findAllByCatalogueIdAndDeliveryAndDeletedIsNull(idElementoOrEntrega, isDelivery,
                        Sort.by(Sort.Order.desc("creationDate")));
        if (itinerariosCalidad != null && !itinerariosCalidad.isEmpty()) {
            retorno = itinerariosCalidad.get(0);
        }
        return retorno;
    }

    public final ItinerarioCalidad getByIdItinerarioWithCurrentState(final Integer idItinerario) {
        return this.itinerarioCalidadRepository.getByIdOfItinerary(idItinerario);
    }

    public final ItinerarioCalidad getByIdItinerario(final Integer idItinerario) {
        return this.itinerarioCalidadRepository.findByIdAndDeletedIsNull(idItinerario);
    }

    public final boolean hasUnitTestingActivity(final Integer idItinerario) {
        boolean hasUnitActivity = false;
        ItinerarioCalidad iti = this.itinerarioCalidadRepository.findByIdAndDeletedIsNull(idItinerario);
        if (iti != null) {
            int i = 0;
            while (!hasUnitActivity && i < iti.getActividadesDeItinerario().size()) {
                Integer id = iti.getActividadesDeItinerario().get(i++).getActivityId();
                ActividadQA actQA = this.actividadQAService.get(id);
                if (actQA.getShortName().contentEquals("Unitarias")) {
                    hasUnitActivity = true;
                }
            }
        }
        return hasUnitActivity;
    }

    @Transactional
    public final Integer logicalDelete(final Integer idItinerario) {
        Integer retorno = -1;
        ItinerarioCalidad itinerarioCalidad = this.itinerarioCalidadRepository.findById(idItinerario).get();
        if (itinerarioCalidad != null) {
            itinerarioCalidad.setDeleted(1);
            this.itinerarioCalidadRepository.save(itinerarioCalidad);
            retorno = itinerarioCalidad.getId();
        }
        return retorno;
    }


    public final List<StagePantalla> getActivitiesByItineraryId(final Integer idItinerario,
                                                                final Integer included) {

        ItinerarioCalidad itinerarioCalidad = this.itinerarioCalidadRepository.findById(idItinerario).get();
        Map<Integer, Integer> minAndMax = getMinAndMax(itinerarioCalidad);
        Integer min = minAndMax.entrySet().iterator().next().getKey();
        Integer max = minAndMax.entrySet().iterator().next().getValue();
        Integer amplitud = max - min;

        List<ActividadItinerario> actividadesItinerario = new ArrayList<>();
        if (itinerarioCalidad != null && !itinerarioCalidad.getActividadesDeItinerario().isEmpty()) {
            for (ActividadItinerario actividadItinerario : itinerarioCalidad.getActividadesDeItinerario()) {
                if (actividadItinerario.getIncludedInItinerary().intValue() == included.intValue()) {
                    ActividadQA actividad = this.actividadQAService.get(actividadItinerario.getActivityId());
                    actividadItinerario.setName(actividad.getName());
                    actividadItinerario.setShortName(actividad.getShortName());
                    actividadItinerario.setTestingStageId(actividad.getTestingStageId());
                    actividadesItinerario.add(actividadItinerario);
                }
            }
        }
        Collections.sort(actividadesItinerario, new ActivityItineraryComparator());
        List<StagePantalla> stages = new ArrayList<>();
        Integer idtstage = -1;
        for (ActividadItinerario actividadItinerario : actividadesItinerario) {
            ActividadQAPantalla act4Screen = new ActividadQAPantalla();
            act4Screen.setId(actividadItinerario.getId());
            act4Screen.setSumOfWeights(actividadItinerario.getActivitSumOfAxes());
            act4Screen.setRealization(actividadItinerario.getInferredThreshold());
            act4Screen.setActivity(actividadItinerario.getName());
            act4Screen.setActivityShort(actividadItinerario.getShortName());
            act4Screen.setAvance(actividadItinerario.getAvance());

            if (actividadItinerario.getUmbralesPactados() != null
                    && !actividadItinerario.getUmbralesPactados().isEmpty()) {
                UmbralPactado umbralPactado = actividadItinerario.getUmbralesPactados()
                        .stream().filter(up -> up.getDischargeDate() == null)
                        .toList().get(0);
                act4Screen.setAgreedThreshold(umbralPactado.getValue());
            } else {
                act4Screen.setAgreedThreshold(null);
            }

            act4Screen.setHelp(actividadItinerario.getHelp());
            Double ponderado = included == Constantes.NUMBER_1
                    ? getValorNormalizado(actividadItinerario.getActivitSumOfAxes(), min, amplitud) : 0.0;
            DecimalFormat df = new DecimalFormat("#.##");
            double roundedNumber = Double.parseDouble(df.format(ponderado).replace(",", "."));
            act4Screen.setPonderado(roundedNumber);
            if (idtstage == actividadItinerario.getTestingStageId()) {
                stages.get(stages.size() - 1).getActivities().add(act4Screen);
            } else {
                EtapaPruebas etapaPruebas = this.etapaPruebasRepository.findByIdAndDeletedIsNull(
                        actividadItinerario.getTestingStageId());
                idtstage = etapaPruebas.getId();
                StagePantalla nuevoStage = new StagePantalla();
                nuevoStage.setStage(etapaPruebas.getName());
                List<ActividadQAPantalla> nuevaListaActs = new ArrayList<>();
                nuevaListaActs.add(act4Screen);
                nuevoStage.setActivities(nuevaListaActs);
                stages.add(nuevoStage);
            }
        }

        return stages;
    }

    private Map<Integer, Integer> getMinAndMax(final ItinerarioCalidad itinerarioCalidad) {
        Integer max = 0;
        Integer min = Integer.MAX_VALUE;
        Map<Integer, Integer> retorno = new HashMap<>();
        for (ActividadItinerario actividadItinerario : itinerarioCalidad.getActividadesDeItinerario()) {
            if (actividadItinerario.getActivitSumOfAxes() != null) {
                Integer newSumOfAxes = actividadItinerario.getActivitSumOfAxes() < 0
                        ? 0 : actividadItinerario.getActivitSumOfAxes();
                if (newSumOfAxes.doubleValue() < min.doubleValue()) {
                    min = newSumOfAxes;
                } else if (newSumOfAxes.doubleValue() > max.doubleValue()) {
                    max = actividadItinerario.getActivitSumOfAxes();
                }
            }
        }
        retorno.put(min, max); //valores minimo y maximo de sumas de ejes
        return retorno;
    }

    private Double getValorNormalizado(final Integer valorSumaIn, final Integer minInRange, final Integer amplitud) {
        Double min = Double.valueOf(minInRange);
        if (min < 0) {
            min = Double.valueOf(0);
        }
        Double valorNormalizado = ((Double.valueOf(valorSumaIn < 0 ? 0 : valorSumaIn) - min)
                / Double.valueOf(amplitud)) * Constantes.NUMBER_100;
        if (valorNormalizado.doubleValue() < 0.0) {
            valorNormalizado = 0.0;
        }
        return valorNormalizado;
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

    private Map<Integer, Integer> getMinAndMaxOfUmbrales(final ItinerarioCalidad itinerarioCalidad,
                                                         final Integer elemenTypeId,
                                                         final Map<Integer, Integer> minAndMax) {
        Integer min = Integer.MAX_VALUE;
        Map<Integer, Integer> retorno = new HashMap<>();
        for (ActividadItinerario actividadItinerario : itinerarioCalidad.getActividadesDeItinerario()) {
            if (actividadItinerario.getIncludedInItinerary() == Constantes.NUMBER_1) {
                List<UmbralActividad> umbrales = this.umbralActividadRepository.
                        findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(elemenTypeId,
                                actividadItinerario.getActivityId(), itinerarioCalidad.getDelivery(),
                                Sort.by(Sort.Order.asc("lowerLimit")));
                for (int i = 0; i < umbrales.size(); i++) {
                    UmbralActividad umbral = umbrales.get(i);
                    if (umbral.getLowerLimit().doubleValue() < min.doubleValue()) {
                        min = umbral.getLowerLimit();
                    }
                }
            }
        }
        retorno.put(min < 0 ? 0 : min, minAndMax.values().iterator().next());
        return retorno;
    }

    public final List<StagePantalla> getUmbralesPonderadosItiById(final Integer idItinerario,
                                                                        final Integer elemenTypeId,
                                                                        final Integer nivelUmbral) {
        ItinerarioCalidad itinerarioCalidad = this.itinerarioCalidadRepository.findByIdAndDeletedIsNull(idItinerario);
        Map<Integer, Integer> minAndMaxOfSumaPesos = getMinAndMax(itinerarioCalidad);
        Map<Integer, Integer> minAndMax = getMinAndMaxOfUmbrales(itinerarioCalidad, elemenTypeId, minAndMaxOfSumaPesos);
        Integer min = minAndMax.entrySet().iterator().next().getKey();
        Integer max = minAndMax.entrySet().iterator().next().getValue();
        Integer amplitud = (max - min);
        if (amplitud < 0) {
            amplitud = 0;
        }

        List<StagePantalla> stages4Bubles = new ArrayList<>();
        for (ActividadItinerario actividadItinerario : itinerarioCalidad.getActividadesDeItinerario()) {
            if (actividadItinerario.getIncludedInItinerary() == Constantes.NUMBER_1) {
                ActividadQA actividadQA = this.actividadQAService.get(actividadItinerario.getActivityId());
                ActividadQAPantalla actividadQAPantalla = new ActividadQAPantalla();
                //calculamos el umbral ponderado para esta suma de pesos de esta actividad:
                List<UmbralActividad> umbrales = this.umbralActividadRepository.
                        findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(elemenTypeId,
                                actividadQA.getId(), itinerarioCalidad.getDelivery(),
                                Sort.by(Sort.Order.asc("lowerLimit")));
                Integer umbralSeleccionado = Constantes.NUMBER_0;
                if (umbrales.size() == Constantes.NUMBER_2) {
                    if (nivelUmbral == Constantes.NUMBER_1) {
                        umbralSeleccionado = umbrales.get(0).getLowerLimit();
                    } else if (nivelUmbral == Constantes.NUMBER_2) {
                        if (umbrales.get(0).getLowerLimit().intValue() == umbrales.get(1).getLowerLimit().intValue()
                                && umbrales.get(0).getUpperLimit().intValue() == umbrales.get(1).getUpperLimit().
                                intValue()) {
                            //solo hay un umbral en realidad porque está repetido
                            umbralSeleccionado = umbrales.get(0).getLowerLimit();
                        } else {
                            umbralSeleccionado = umbrales.get(1).getLowerLimit();
                        }
                    } else if (nivelUmbral == Constantes.NUMBER_3) {
                        umbralSeleccionado = umbrales.get(1).getUpperLimit();
                    }
                }
                Double ponderado = getValorNormalizado(umbralSeleccionado, min, amplitud);
                ponderado = ponderado == 0 && umbralSeleccionado > 0 ? 1L : ponderado;
                ponderado = ponderado > Constantes.NUMBER_100 ? Constantes.NUMBER_100 : ponderado;
                DecimalFormat df = new DecimalFormat("#.##");
                double roundedNumber = Double.parseDouble(df.format(ponderado).replace(",", "."));
                actividadQAPantalla.setPonderado(roundedNumber);

                List<ActividadQAPantalla> actividadQAPantallas;
                StagePantalla stageBuble = search(stages4Bubles, actividadQA.getTestingStageId());
                if (stageBuble != null) {
                    actividadQAPantallas = stageBuble.getActivities();
                    actividadQAPantallas.add(actividadQAPantalla);
                } else {
                    stageBuble = new StagePantalla();
                    actividadQAPantallas = new ArrayList<>();
                    actividadQAPantallas.add(actividadQAPantalla);
                    stageBuble.setActivities(actividadQAPantallas);
                    stageBuble.setIdStage(actividadQA.getTestingStageId());
                    stageBuble.setStage(actividadQA.getStageQAName());
                    stages4Bubles.add(stageBuble);
                }
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


    @Transactional public final ItinerarioCalidad update(final ItinerarioCalidad itinerarioCalidad) {
        ItinerarioCalidad updatedObject = null;
        if (this.itinerarioCalidadRepository.findByIdAndDeletedIsNull(itinerarioCalidad.getId()) != null) {
            updatedObject = this.itinerarioCalidadRepository.save(itinerarioCalidad);
        }
        return updatedObject;
    }
    @Transactional
    public final ItinerarioCalidad setActiveItinerary(final Integer idOfItinerary) {
        ItinerarioCalidad itinerario = this.itinerarioCalidadRepository.findByIdAndDeletedIsNull(idOfItinerary);
        // ponemos el resto como obsoletos
        List<ItinerarioCalidad> allItinerarios = this.itinerarioCalidadRepository.
                findAllByCatalogueIdAndDeletedIsNull(itinerario.getCatalogueId());
        allItinerarios.forEach((iti) -> {
            if (iti.getId().intValue() != idOfItinerary) {
                iti.setCurrent(0);
                this.itinerarioCalidadRepository.save(iti);
            }
        });
        itinerario.setCurrent(1);
        itinerario.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        itinerario = this.itinerarioCalidadRepository.save(itinerario);
        itinerario.setSituacion(itinerario.getSituacionId() == null ? null
                : this.situacionItinerarioRepository.findById(itinerario.getSituacionId()).get().getName());
        return itinerario;
    }

    public final List<ItinerarioCalidad> getFilteredItineraries(final ItinerarioFilter filter) {
        Date startDate = filter.getStartDate();
        Date endDate = filter.getEndDate();
        Integer current = filter.getCurrent();
        Integer isDelivery = filter.getIsDelivery();
        Integer situationId = filter.getSituationId();
        List<Integer> elementsIds = filter.getElementsIds();
        List<ItinerarioCalidad> itinerarios = new ArrayList<>();

         if (!elementsIds.isEmpty() && elementsIds != null) {
            if (startDate == null && filter.getEndDate() != null) {
                startDate = new Date(Calendar.getInstance().getTime().getTime());
            }
            if (startDate != null) {
                endDate = filter.getEndDate() == null ? new Date(Calendar.getInstance().getTime().getTime())
                        : filter.getEndDate(); //sumamos un dia al final
                Calendar newEndDate = Calendar.getInstance();
                newEndDate.setTime(endDate);
                newEndDate.add(Calendar.DATE, 1);
                endDate = new Date(newEndDate.getTime().getTime());
            }

            Timestamp start = startDate == null ? null : new Timestamp(startDate.getTime());
            Timestamp end = endDate == null ? null : new Timestamp(endDate.getTime());

            int idsListsSize = Constantes.QUERY_LIST_MAX_SIZE;
            List<List<Integer>> listsOfElementsIds = new ArrayList<>();
            for (int i = 0; i < elementsIds.size(); i += idsListsSize) {
                int fin = Math.min(i + idsListsSize, elementsIds.size());
                List<Integer> ids = elementsIds.subList(i, fin);
                listsOfElementsIds.add(ids);
            }

            for (List<Integer> ids: listsOfElementsIds) {
                List<ItinerarioCalidad> itis = this.itinerarioCalidadRepository.getFilteredItineraries(
                        start, end, current, ids, isDelivery, situationId);
                itinerarios.addAll(itis);
            }
        }
        return itinerarios;
    }

}
