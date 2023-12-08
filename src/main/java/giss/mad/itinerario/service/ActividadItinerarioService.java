package giss.mad.itinerario.service;

import giss.mad.itinerario.exception.ValidationErrorMessage;
import giss.mad.itinerario.dto.ActividadItinerarioDto;
import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.ItinerarioCalidad;
import giss.mad.itinerario.model.volatilentities.ItinerarioPantalla;
import giss.mad.itinerario.model.volatilentities.ReplicaElementOEntrega;
import giss.mad.itinerario.model.volatilentities.ValorEje;
import giss.mad.itinerario.repository.itinerario.ActividadItinerarioRepository;
import giss.mad.itinerario.repository.itinerario.EjeHeredableRepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.ItinerarioCalidadRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;
import giss.mad.itinerario.repository.itinerario.SituacionItinerarioRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;
import giss.mad.itinerario.util.ValorEjeComparator;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ActividadItinerarioService {
    private static final double MAX_AVANCE = 100.0;
    @Autowired
    private ActividadItinerarioRepository actividadItinerarioRepository;

    @Autowired
    private ActividadQAService actividadQAService;

    @Autowired
    private EtapaPruebasRepository etapaPruebasRepository;

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private EjeHeredableRepository ejeHeredableRepository;

    @Autowired
    private SituacionItinerarioRepository situacionItinerarioRepository;

    @Autowired
    private UmbralActividadRepository umbralActividadRepository;

    @Autowired
    private ItinerarioCalidadRepository itinerarioCalidadRepo;

    @Autowired
    private UmbralPactadoService umbralPactadoService;

    public final void setActividadItinerarioRepository(
            final ActividadItinerarioRepository actividadItinerarioRepository) {
        this.actividadItinerarioRepository = actividadItinerarioRepository;
    }

    public final void setActividadQAService(final ActividadQAService actividadQAService) {
        this.actividadQAService = actividadQAService;
    }

    public final void setUmbralPactadoService(final UmbralPactadoService umbralPactadoService) {
        this.umbralPactadoService = umbralPactadoService;
    }

    public final void setEtapaPruebasRepository(final EtapaPruebasRepository etapaPruebasRepository) {
        this.etapaPruebasRepository = etapaPruebasRepository;
    }

    public final void setSituacionItinerarioRepository(final SituacionItinerarioRepository
                                                               situacionItinerarioRepository) {
        this.situacionItinerarioRepository = situacionItinerarioRepository;
    }

    public final void setPesoRepository(final PesoRepository pesoRepository) {
        this.pesoRepository = pesoRepository;
    }

    public final void setEjeHeredableRepository(final EjeHeredableRepository ejeHeredableRepository) {
        this.ejeHeredableRepository = ejeHeredableRepository;
    }

    public final void setUmbralActividadRepository(final UmbralActividadRepository umbralActividadRepository) {
        this.umbralActividadRepository = umbralActividadRepository;
    }

    public final void setItinerarioCalidadRepo(final ItinerarioCalidadRepository itinerarioCalidadRepo) {
        this.itinerarioCalidadRepo = itinerarioCalidadRepo;
    }

    @Transactional
    public final ActividadItinerario update(final ActividadItinerario actividadItinerario) {
        ActividadItinerario updatedObject = null;
        if (this.actividadItinerarioRepository.findByIdAndDeletedIsNull(actividadItinerario.getId()) != null) {
            updatedObject = this.actividadItinerarioRepository.save(actividadItinerario);
        }
        return updatedObject;
    }

    @Transactional
    public final ActividadItinerario updateProgress(final ActividadItinerarioDto actividadItinerario) throws Exception{
        Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        ActividadItinerario updatedObject = this.actividadItinerarioRepository.
                findByIdAndDeletedIsNull(actividadItinerario.getId());
        if (updatedObject != null) {
            if (actividadItinerario.getAvance() < 0 || actividadItinerario.getAvance() > MAX_AVANCE) {
                throw new Exception("Error de validación: Grado de avance permitido con valores en rango [0.00 - 100.0]");
            }
            updatedObject.setAvance(actividadItinerario.getAvance());
            if (actividadItinerario.getAgreedThreshold() != null) {
                umbralPactadoService.actualizarUmbralPactado(actividadItinerario.getId(),
                        actividadItinerario.getAgreedThreshold());
            }
            updatedObject.setHelp(actividadItinerario.getHelp());
            updatedObject.setUpdateDate(timeStamp);
            updatedObject = this.actividadItinerarioRepository.save(updatedObject);
        }
        return updatedObject;
    }

    @Transactional
    public final ActividadItinerario remove(final Integer idActividadItinerario) {
        ActividadItinerario removedObject = this.actividadItinerarioRepository.findByIdAndDeletedIsNull(
                idActividadItinerario);
        if (removedObject != null) {
            this.actividadItinerarioRepository.deleteById(removedObject.getId());
        }
        return removedObject;
    }

    @Transactional
    public final ActividadItinerario logicalRemove(final Integer idActividadItinerario) {
        ActividadItinerario actividadItinerario = this.actividadItinerarioRepository.findByIdAndDeletedIsNull(
                idActividadItinerario);
        if (actividadItinerario != null) {
            Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            actividadItinerario.setUpdateDate(timeStamp);
            actividadItinerario.setDeleted(1);
            actividadItinerario.setHelp(actividadItinerario.getHelp() + "[deleted at " + timeStamp.getTime() + "]");
            this.actividadItinerarioRepository.save(actividadItinerario);
        }
        return actividadItinerario;
    }

    public final List<ActividadItinerario> getItineraryActivitiesByParent(final Integer idItinerario) {
        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setQualityItineraryId(idItinerario);
        actividadItinerario.setIncludedInItinerary(null);
        return this.actividadItinerarioRepository.findAll(Example.of(actividadItinerario));
    }

    private ItinerarioPantalla getItinerarioPantalla(final ItinerarioCalidad itinerarioCalidad) {
        ItinerarioPantalla itinerario = new ItinerarioPantalla();
        itinerario.setId(Long.valueOf(itinerarioCalidad.getId()));
        itinerario.setCreationDate(itinerarioCalidad.getCreationDate());
        itinerario.setElementId(itinerarioCalidad.getCatalogueId());
        itinerario.setDelivery(itinerarioCalidad.getDelivery());
        itinerario.setAvance(itinerarioCalidad.getAvance());
        itinerario.setCurrent(itinerarioCalidad.getCurrent());
        itinerario.setSituacionId(itinerarioCalidad.getSituacionId());
        itinerario.setObservacionesAprobacion(itinerarioCalidad.getObservacionesAprobacion());
        return itinerario;
    }

    public final ItinerarioPantalla getItinerarioPantallaDetail(final Integer id) {
        ItinerarioCalidad itinerarioCalidad = itinerarioCalidadRepo.getByIdOfItinerary(id);
        return getItinerarioPantalla(itinerarioCalidad);
    }

    public final Map<ItinerarioPantalla, List<ValidationErrorMessage>>
    calculateItinerary(final ReplicaElementOEntrega elemOrDelivery) {
        Map<ItinerarioPantalla, List<ValidationErrorMessage>> retorno = new HashMap<>();
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> itinerarioDetalladoMap =
                calculateItinerario(elemOrDelivery);
        if (itinerarioDetalladoMap.values().iterator().next().isEmpty()) {
            ItinerarioCalidad itinerarioDetallado = salvarItinerario(itinerarioDetalladoMap.keySet().iterator().next());
            retorno.put(getItinerarioPantalla(itinerarioDetallado), new ArrayList<>());
        } else {
            retorno.put(null, itinerarioDetalladoMap.values().iterator().next());
        }
        return retorno;
    }

    private Map<List<ActividadItinerario>, List<ValidationErrorMessage>>
    lanzarItinCatalogElemParent(final ReplicaElementOEntrega elemOrDelivery, final Integer isDelivery) {

        Map<List<ActividadItinerario>, List<ValidationErrorMessage>> retorno = new HashMap<>();
        List<ActividadItinerario> listExclsACotejar = new ArrayList<>();
        // ver si ese typeID es inválido
        if (elemOrDelivery.getCatalogElementTypeId() == null
                || elemOrDelivery.getCatalogElementTypeId().intValue() > Constantes.NUMBER_4
                || elemOrDelivery.getCatalogElementTypeId().intValue() < Constantes.NUMBER_1) {
            List<ValidationErrorMessage> errorListInner = new ArrayList<>();
            ValidationErrorMessage errvalidationMsg = new ValidationErrorMessage(
                    "Entrada de datos no válida: Valor fuera de rango para el identificador de tipo de elemento "
                            + "de catálogo");
            errorListInner.add(errvalidationMsg);
            retorno.put(null, errorListInner);
        } else {
            if (isDelivery.intValue() == Constantes.NUMBER_1) {
                //cotejar actividades incluidas con la lista de actividades excludias de su corresp. elemen. catálogo
                ReplicaElementOEntrega elemDeCatalago = new ReplicaElementOEntrega();
                elemDeCatalago.setId(elemOrDelivery.getId());
                elemDeCatalago.setCatalogElementTypeId(elemOrDelivery.getCatalogElementTypeId());
                elemDeCatalago.setDelivery(Constantes.NUMBER_0);
                elemDeCatalago.setAttributeValuesCollection(elemOrDelivery.getAttributeValuesCollectionParent());
                Map<ItinerarioCalidad, List<ValidationErrorMessage>> mapItiAndErrorList =
                        calculateItinerario(elemDeCatalago);
                List<ValidationErrorMessage> errorListInner = mapItiAndErrorList.values().iterator().next();
                if (errorListInner.isEmpty()) {
                    ItinerarioCalidad itiDeCatalogo = mapItiAndErrorList.keySet().iterator().next();
                    for (ActividadItinerario act : itiDeCatalogo.getActividadesDeItinerario()) {
                        if (act.getIncludedInItinerary().intValue() == Constantes.NUMBER_0) {
                            listExclsACotejar.add(act);
                        }
                    }
                    retorno.put(listExclsACotejar, new ArrayList<>());
                } else {
                    retorno.put(new ArrayList<>(), errorListInner);
                }
            } else {
                retorno.put(new ArrayList<>(), new ArrayList<>());
            }
        }
        return retorno;
    }

    private ItinerarioCalidad instanciarItinerario(final ReplicaElementOEntrega elemOrDelivery) {
        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setCatalogueId(elemOrDelivery.getId());
        itinerarioCalidad.setDelivery(elemOrDelivery.getDelivery());
        Timestamp fecCreacion = new Timestamp(Calendar.getInstance().getTime().getTime());
        itinerarioCalidad.setCreationDate(fecCreacion);
        itinerarioCalidad.setUpdateDate(fecCreacion);
        itinerarioCalidad.setSituacionId(this.situacionItinerarioRepository.
                findByNameAndDeletedIsNull(Constantes.PTE_APROBAC).getId());
        return itinerarioCalidad;
    }

    private List<Integer> getDomainIdList(final ReplicaElementOEntrega elemOrDelivery) {
        List<Integer> domainValuesIdsOrderList = new ArrayList<>();
        Collections.sort(elemOrDelivery.getAttributeValuesCollection(), new ValorEjeComparator());
        elemOrDelivery.getAttributeValuesCollection().forEach((valorEje) -> {
            if (!(valorEje.getDomainValues() == null || valorEje.getDomainValues().isEmpty()
                    || valorEje.getDomainValues().iterator().next().getDomainValueId() == null)) {
                domainValuesIdsOrderList.add(valorEje.getDomainValues().iterator().next().getDomainValueId());
            }
        });
        return domainValuesIdsOrderList;
    }

    @Transactional
    public final Map<ItinerarioCalidad, List<ValidationErrorMessage>> calculateItinerario(
            final ReplicaElementOEntrega elemOrDelivery) {

        List<ValidationErrorMessage> errorList = new ArrayList<>();
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> retorno = new HashMap<>();

        Integer release = elemOrDelivery.getDelivery();
        Map<List<ActividadItinerario>, List<ValidationErrorMessage>> exclusionesMap =
                lanzarItinCatalogElemParent(elemOrDelivery, release);
        List<ActividadItinerario> listExclsACotejar = exclusionesMap.keySet().iterator().next();
        List<ValidationErrorMessage> errores = exclusionesMap.values().iterator().next();
        if (!errores.isEmpty()) { // han aparecido errores
            retorno.put(null, exclusionesMap.values().iterator().next());
        } else {
            final List<ActividadItinerario>[] listaActivAcumulative = new List[]{new ArrayList<>()};

            Map<Integer, ActividadItinerario> actividadSumaPesos = new HashMap<>();
            elemOrDelivery.getAttributeValuesCollection().forEach((valorEje) -> {
                listaActivAcumulative[0] = this.actividadItinerarioRepository.
                        calculateSumOfWeightsForEachAxis(elemOrDelivery.getCatalogElementTypeId(),
                                elemOrDelivery.getDelivery(), valorEje.getAxisAttributeId(),
                                valorEje.getDomainValues().iterator().next().getDomainValueId());
                listaActivAcumulative[0].forEach((activPorAxis) -> {
                    activPorAxis.setIncludedInItinerary(Constantes.NUMBER_1);
                });
                listaActivAcumulative[0].forEach((activPorAxis) -> {
                    if (release.intValue() == Constantes.NUMBER_1 && estaIncluida(activPorAxis, listExclsACotejar)) {
                        activPorAxis.setInferredThreshold("Actividad excluída por no pertenecer al itinerario "
                                + "global de su elemento de catálogo");
                        activPorAxis.setObservations(activPorAxis.getInferredThreshold());
                        activPorAxis.setIncludedInItinerary(Constantes.NUMBER_0);
                        actividadSumaPesos.put(activPorAxis.getActivityId(), activPorAxis);
                    } else  if (activPorAxis.getActivitSumOfAxes().intValue() == Constantes.NUMBER_MINUS_THREE) {
                        activPorAxis.setInferredThreshold(
                                "Actividad excluida; se realiza a nivel aplicación y superiores");
                        activPorAxis.setObservations(activPorAxis.getInferredThreshold());
                        activPorAxis.setIncludedInItinerary(Constantes.NUMBER_0);
                        actividadSumaPesos.put(activPorAxis.getActivityId(), activPorAxis);
                    } else if (activPorAxis.getActivitSumOfAxes().intValue() == Constantes.NUMBER_MINUS_TWO) {
                        activPorAxis.setInferredThreshold(
                                "Actividad excluida; se realiza a nivel elemento promocionable");
                        activPorAxis.setObservations(activPorAxis.getInferredThreshold());
                        activPorAxis.setIncludedInItinerary(Constantes.NUMBER_0);
                        actividadSumaPesos.put(activPorAxis.getActivityId(), activPorAxis);
                    } else if (activPorAxis.getActivitSumOfAxes().intValue() == Constantes.NUMBER_MINUS_ONE) {
                        activPorAxis.setInferredThreshold(
                                "Actividad no incluida; definido valor excluyente para un eje");
                        activPorAxis.setObservations(activPorAxis.getInferredThreshold());
                        activPorAxis.setIncludedInItinerary(Constantes.NUMBER_0);
                        actividadSumaPesos.put(activPorAxis.getActivityId(), activPorAxis);
                    } else {
                        if (actividadSumaPesos.get(activPorAxis.getActivityId()) == null) {
                            actividadSumaPesos.put(activPorAxis.getActivityId(), activPorAxis);
                        } else {
                            ActividadItinerario actItinerario = actividadSumaPesos.get(activPorAxis.getActivityId());
                            if (actItinerario.getIncludedInItinerary() == Constantes.NUMBER_1) {
                                actItinerario.setActivitSumOfAxes(
                                        actItinerario.getActivitSumOfAxes() + activPorAxis.getActivitSumOfAxes());
                            }
                        }
                    }
                });
            });

            Collection<ActividadItinerario> coleccionDeActividadesConSumaPesos = actividadSumaPesos.values();

            List<ActividadItinerario> actividadesItinerario = new ArrayList<>();
            AtomicInteger idActividad = new AtomicInteger();
            coleccionDeActividadesConSumaPesos.forEach((activ) -> {
                if (activ.getActivityId().intValue() != idActividad.intValue()) {
                    ActividadQA actQA = this.actividadQAService.get(activ.getActivityId());
                    ActividadItinerario actIesima = instanciarActividad(actQA,
                            new Timestamp(Calendar.getInstance().getTimeInMillis()), elemOrDelivery);
                    actIesima.setActivitSumOfAxes(activ.getActivitSumOfAxes());
                    if (actIesima.getIncludedInItinerary() == Constantes.NUMBER_1) {
                        // miramos si el sumatorio de pesos está en alguno de los dos umbrales:
                        if (activ.getActivitSumOfAxes().intValue() >= activ.getUmbralInferior().getLowerLimit()
                                && activ.getActivitSumOfAxes().intValue()
                                <= activ.getUmbralInferior().getUpperLimit()) {
                            StringBuilder observat = new StringBuilder();
                            observat.append("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
                            observat.append(activ.getActivitSumOfAxes().intValue());
                            observat.append(") ");
                            observat.append(" dentro del umbral inferior [");
                            observat.append(activ.getUmbralInferior().getLowerLimit());
                            observat.append(" , ");
                            observat.append(activ.getUmbralInferior().getUpperLimit());
                            observat.append("]");
                            actIesima.setInferredThreshold(activ.getUmbralInferior().getThreshold());
                            actIesima.setObservations(observat.toString());
                        } else if (activ.getActivitSumOfAxes().intValue()
                                >= activ.getUmbralSuperior().getLowerLimit()
                                && activ.getActivitSumOfAxes().intValue()
                                <= activ.getUmbralSuperior().getUpperLimit()) {
                            StringBuilder observat = new StringBuilder();
                            observat.append("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
                            observat.append(activ.getActivitSumOfAxes().intValue());
                            observat.append(") ");
                            observat.append(" dentro del umbral superior [");
                            observat.append(activ.getUmbralSuperior().getLowerLimit());
                            observat.append(" , ");
                            observat.append(activ.getUmbralSuperior().getUpperLimit());
                            observat.append("]");
                            actIesima.setObservations(observat.toString());
                            actIesima.setInferredThreshold(activ.getUmbralSuperior().getThreshold());
                        } else {
                            actIesima.setIncludedInItinerary(Constantes.NUMBER_0);
                            actIesima.setObservations("Actividad excluida; la suma de pesos obtenida no alcanza "
                                    + "el mínimo necesario para recomendar esta actividad");
                            actIesima.setInferredThreshold(actIesima.getObservations());
                        }
                    }
                    idActividad.set(actIesima.getActivityId().intValue());
                    actividadesItinerario.add(actIesima);
                }
            });
            ItinerarioCalidad itiQA = instanciarItinerario(elemOrDelivery);
            itiQA.setActividadesDeItinerario(actividadesItinerario);
            retorno.put(itiQA, errorList);
        }
        return retorno;
    }


    private ActividadItinerario instanciarActividad(final ActividadQA actividadQA,
                                                    final Timestamp fecCreacion,
                                                    final ReplicaElementOEntrega elemOrDelivery) {
        ActividadItinerario actividadItinerarioIesima = new ActividadItinerario();
        actividadItinerarioIesima.setHelp(actividadQA.getHelp());
        actividadItinerarioIesima.setCreationDate(fecCreacion);
        actividadItinerarioIesima.setActivityId(actividadQA.getId());
        actividadItinerarioIesima.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        //Se tienen en cuenta los casos especiales
        actividadItinerarioIesima = casosEspeciales(elemOrDelivery, actividadItinerarioIesima);

        return actividadItinerarioIesima;
    }

    public final ActividadItinerario casosEspeciales(final ReplicaElementOEntrega elemento,
                                                     final ActividadItinerario actividadItinerarioIn) {

        //Se comprueba que la actividad es Pruebas de Integración
        if (actividadItinerarioIn.getActivityId().intValue() == Constantes.NUMBER_9) {
            //Si es aplicación
            if (elemento.getCatalogElementTypeId().intValue() == Constantes.NUMBER_4
                    && elemento.getHijos() != null) {
                List<ReplicaElementOEntrega> listaHijos = elemento.getHijos();
                boolean hayEpsNoFront = false;
                boolean hayEpFront = false;
                boolean aplicaPesos = false;
                //Se comprueba si la aplicación contiene EPs Front y no-Front
                boolean hayEp = false;
                for (int i = 0; i < listaHijos.size() && !hayEp; i++) {
                    ReplicaElementOEntrega elemHijo = listaHijos.get(i);
                    List<ValorEje> hijoValorEjes = elemHijo.getAttributeValuesCollection();
                    int domainValueId = -1;
                    for (int j = 0; j < hijoValorEjes.size() && !hayEp; j++) {
                        ValorEje valorEje = hijoValorEjes.get(j);
                        if (valorEje.getAxisAttributeId().intValue() == Constantes.NUMBER_19) {
                            domainValueId = valorEje.getDomainValues().get(0).getDomainValueId().intValue();
                            if (domainValueId != Constantes.NUMBER_74) {
                                hayEpsNoFront = true;
                            } else {
                                hayEpFront = true;
                            }
                            hayEp = true;
                        }
                    }
                    if (hayEpsNoFront && domainValueId != Constantes.NUMBER_74) {
                        for (int j = 0; j < hijoValorEjes.size() && !aplicaPesos; j++) {
                            ValorEje valorEje = hijoValorEjes.get(j);
                            //Numero de dependencias (consumo de datos)
                            if (valorEje.getAxisAttributeId().intValue() == Constantes.NUMBER_14) {
                                domainValueId = valorEje.getDomainValues().get(0).getDomainValueId() != null
                                        ? valorEje.getDomainValues().get(0).getDomainValueId().intValue() : -1;
                                //Si es "Más de 5" o "De 1 a 5"
                                if ((domainValueId == Constantes.NUMBER_59 || domainValueId == Constantes.NUMBER_60)
                                        && domainValueId != -1) {
                                    aplicaPesos = true;
                                }
                            }
                        }
                    }
                } //for
                if (aplicaPesos) {
                    actividadItinerarioIn.setIncludedInItinerary(1);
                } else if (hayEpFront && !hayEpsNoFront) {
                    actividadItinerarioIn.setIncludedInItinerary(0);
                    actividadItinerarioIn.setObservations("Actividad excluida; cubierta con pruebas funcionales");
                    actividadItinerarioIn.setInferredThreshold(actividadItinerarioIn.getObservations());
                } else {
                    actividadItinerarioIn.setIncludedInItinerary(0);
                    actividadItinerarioIn.setObservations("Actividad excluida; no tiene dependencias de terceros");
                    actividadItinerarioIn.setInferredThreshold(actividadItinerarioIn.getObservations());
                }
            }
        }
        return actividadItinerarioIn;
    }

    private boolean estaIncluida(final ActividadItinerario actividadIti, final List<ActividadItinerario> lista) {
        boolean aparece = false;
        int i = 0;
        while (!aparece && i < lista.size()) {
            ActividadItinerario activ = lista.get(i++);
            if (activ.getActivityId().intValue() == actividadIti.getActivityId().intValue()) {
                aparece = true;
            }
        }
        return aparece;
    }

    public final ItinerarioCalidad salvarItinerario(final ItinerarioCalidad itiToSave) {
        List<ActividadItinerario> listaActNew = new ArrayList<>();
        List<ActividadItinerario> listaAct = itiToSave.getActividadesDeItinerario();
        itiToSave.setActividadesDeItinerario(null);
        ItinerarioCalidad newItiToSave = this.itinerarioCalidadRepo.save(itiToSave);
        for (final ActividadItinerario actividadItin : listaAct) {
            actividadItin.setQualityItineraryId(newItiToSave.getId());
            actividadItin.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            this.actividadItinerarioRepository.save(actividadItin);
            listaActNew.add(actividadItin);
        }
        newItiToSave.setActividadesDeItinerario(listaAct);
        newItiToSave = this.itinerarioCalidadRepo.saveAndFlush(itiToSave);
        return newItiToSave;
    }



}
