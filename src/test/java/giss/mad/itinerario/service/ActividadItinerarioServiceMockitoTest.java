package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.dto.ActividadItinerarioDto;
import giss.mad.itinerario.exception.ValidationErrorMessage;
import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.ItinerarioCalidad;
import giss.mad.itinerario.model.itinerario.SituacionItinerario;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.DomainValue;
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

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ActividadItinerarioService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ActividadItinerarioServiceMockitoTest {
    @MockBean
    private ActividadItinerarioRepository actividadItinerarioRepository;

    @Autowired
    private ActividadItinerarioService actividadItinerarioService;

    @MockBean
    private ActividadQAService actividadQAService;

    @MockBean
    private EjeHeredableRepository ejeHeredableRepository;

    @MockBean
    private EtapaPruebasRepository etapaPruebasRepository;

    @MockBean
    private ItinerarioCalidadRepository itinerarioCalidadRepository;

    @MockBean
    private PesoRepository pesoRepository;

    @MockBean
    private SituacionItinerarioRepository situacionItinerarioRepository;

    @MockBean
    private UmbralActividadRepository umbralActividadRepository;

    @MockBean
    private UmbralPactadoService umbralPactadoService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ActividadItinerarioService#setActividadItinerarioRepository(ActividadItinerarioRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setActividadQAService(ActividadQAService)}
     *   <li>
     * {@link ActividadItinerarioService#setEjeHeredableRepository(EjeHeredableRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setEtapaPruebasRepository(EtapaPruebasRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setItinerarioCalidadRepo(ItinerarioCalidadRepository)}
     *   <li>{@link ActividadItinerarioService#setPesoRepository(PesoRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setSituacionItinerarioRepository(SituacionItinerarioRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setUmbralActividadRepository(UmbralActividadRepository)}
     *   <li>
     * {@link ActividadItinerarioService#setUmbralPactadoService(UmbralPactadoService)}
     * </ul>
     */
    @Test
    void testSetActividadItinerarioRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ActividadItinerarioService.actividadItinerarioRepository
        //     ActividadItinerarioService.actividadQAService
        //     ActividadItinerarioService.ejeHeredableRepository
        //     ActividadItinerarioService.etapaPruebasRepository
        //     ActividadItinerarioService.itinerarioCalidadRepo
        //     ActividadItinerarioService.pesoRepository
        //     ActividadItinerarioService.situacionItinerarioRepository
        //     ActividadItinerarioService.umbralActividadRepository
        //     ActividadItinerarioService.umbralPactadoService

        ActividadItinerarioService actividadItinerarioService = new ActividadItinerarioService();
        actividadItinerarioService.setActividadItinerarioRepository(mock(ActividadItinerarioRepository.class));
        actividadItinerarioService.setActividadQAService(new ActividadQAService());
        actividadItinerarioService.setEjeHeredableRepository(mock(EjeHeredableRepository.class));
        actividadItinerarioService.setEtapaPruebasRepository(mock(EtapaPruebasRepository.class));
        actividadItinerarioService.setItinerarioCalidadRepo(mock(ItinerarioCalidadRepository.class));
        actividadItinerarioService.setPesoRepository(mock(PesoRepository.class));
        actividadItinerarioService.setSituacionItinerarioRepository(mock(SituacionItinerarioRepository.class));
        actividadItinerarioService.setUmbralActividadRepository(mock(UmbralActividadRepository.class));
        actividadItinerarioService.setUmbralPactadoService(new UmbralPactadoService());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#update(ActividadItinerario)}
     */
    @Test
    void testUpdate() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(1);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(1);
        actividadItinerario.setInferredThreshold("Inferred Threshold");
        actividadItinerario.setName("Name");
        actividadItinerario.setObservations("Observations");
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName("Short Name");
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(1);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(1);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Help");
        umbralInferior2.setId(1);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Threshold");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(1);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(1);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Help");
        umbralSuperior2.setId(1);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Threshold");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(1);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("Help");
        actividadItinerario2.setId(1);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("Inferred Threshold");
        actividadItinerario2.setName("Name");
        actividadItinerario2.setObservations("Observations");
        actividadItinerario2.setQualityItineraryId(1);
        actividadItinerario2.setShortName("Short Name");
        actividadItinerario2.setTestingStageId(1);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));
        when(actividadItinerarioRepository.save(Mockito.<ActividadItinerario>any())).thenReturn(actividadItinerario2);
        when(actividadItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(actividadItinerario);

        UmbralActividad umbralInferior3 = new UmbralActividad();
        umbralInferior3.setActivityId(1);
        umbralInferior3.setCreationDate(mock(Timestamp.class));
        umbralInferior3.setDeleted(1);
        umbralInferior3.setElementTypeId(1);
        umbralInferior3.setExcludeUnreachedThreshold(1);
        umbralInferior3.setForDelivery(1);
        umbralInferior3.setHelp("Help");
        umbralInferior3.setId(1);
        umbralInferior3.setLowerLimit(1);
        umbralInferior3.setThreshold("Threshold");
        umbralInferior3.setUpdateDate(mock(Timestamp.class));
        umbralInferior3.setUpperLimit(1);

        UmbralActividad umbralSuperior3 = new UmbralActividad();
        umbralSuperior3.setActivityId(1);
        umbralSuperior3.setCreationDate(mock(Timestamp.class));
        umbralSuperior3.setDeleted(1);
        umbralSuperior3.setElementTypeId(1);
        umbralSuperior3.setExcludeUnreachedThreshold(1);
        umbralSuperior3.setForDelivery(1);
        umbralSuperior3.setHelp("Help");
        umbralSuperior3.setId(1);
        umbralSuperior3.setLowerLimit(1);
        umbralSuperior3.setThreshold("Threshold");
        umbralSuperior3.setUpdateDate(mock(Timestamp.class));
        umbralSuperior3.setUpperLimit(1);

        ActividadItinerario actividadItinerario3 = new ActividadItinerario();
        actividadItinerario3.setActivitSumOfAxes(1);
        actividadItinerario3.setActivityId(1);
        actividadItinerario3.setAvance(10.0d);
        actividadItinerario3.setCreationDate(mock(Timestamp.class));
        actividadItinerario3.setDeleted(1);
        actividadItinerario3.setHelp("Help");
        actividadItinerario3.setId(1);
        actividadItinerario3.setIncludedInItinerary(1);
        actividadItinerario3.setInferredThreshold("Inferred Threshold");
        actividadItinerario3.setName("Name");
        actividadItinerario3.setObservations("Observations");
        actividadItinerario3.setQualityItineraryId(1);
        actividadItinerario3.setShortName("Short Name");
        actividadItinerario3.setTestingStageId(1);
        actividadItinerario3.setUmbralInferior(umbralInferior3);
        actividadItinerario3.setUmbralSuperior(umbralSuperior3);
        actividadItinerario3.setUmbralesPactados(new ArrayList<>());
        actividadItinerario3.setUpdateDate(mock(Timestamp.class));
        ActividadItinerario actualUpdateResult = actividadItinerarioService.update(actividadItinerario3);
        verify(actividadItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadItinerarioRepository).save(Mockito.<ActividadItinerario>any());
        assertSame(actividadItinerario2, actualUpdateResult);
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#updateProgress(ActividadItinerarioDto)}
     */
    @Test
    void testUpdateProgress() throws Exception {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(1);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(1);
        actividadItinerario.setInferredThreshold("Inferred Threshold");
        actividadItinerario.setName("Name");
        actividadItinerario.setObservations("Observations");
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName("Short Name");
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(1);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(1);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Help");
        umbralInferior2.setId(1);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Threshold");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(1);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(1);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Help");
        umbralSuperior2.setId(1);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Threshold");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(1);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("Help");
        actividadItinerario2.setId(1);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("Inferred Threshold");
        actividadItinerario2.setName("Name");
        actividadItinerario2.setObservations("Observations");
        actividadItinerario2.setQualityItineraryId(1);
        actividadItinerario2.setShortName("Short Name");
        actividadItinerario2.setTestingStageId(1);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));
        when(actividadItinerarioRepository.save(Mockito.<ActividadItinerario>any())).thenReturn(actividadItinerario2);
        when(actividadItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(actividadItinerario);
        doNothing().when(umbralPactadoService).actualizarUmbralPactado(Mockito.<Integer>any(), Mockito.<Double>any());

        UmbralActividad umbralInferior3 = new UmbralActividad();
        umbralInferior3.setActivityId(1);
        umbralInferior3.setCreationDate(mock(Timestamp.class));
        umbralInferior3.setDeleted(1);
        umbralInferior3.setElementTypeId(1);
        umbralInferior3.setExcludeUnreachedThreshold(1);
        umbralInferior3.setForDelivery(1);
        umbralInferior3.setHelp("Help");
        umbralInferior3.setId(1);
        umbralInferior3.setLowerLimit(1);
        umbralInferior3.setThreshold("Threshold");
        umbralInferior3.setUpdateDate(mock(Timestamp.class));
        umbralInferior3.setUpperLimit(1);

        UmbralActividad umbralSuperior3 = new UmbralActividad();
        umbralSuperior3.setActivityId(1);
        umbralSuperior3.setCreationDate(mock(Timestamp.class));
        umbralSuperior3.setDeleted(1);
        umbralSuperior3.setElementTypeId(1);
        umbralSuperior3.setExcludeUnreachedThreshold(1);
        umbralSuperior3.setForDelivery(1);
        umbralSuperior3.setHelp("Help");
        umbralSuperior3.setId(1);
        umbralSuperior3.setLowerLimit(1);
        umbralSuperior3.setThreshold("Threshold");
        umbralSuperior3.setUpdateDate(mock(Timestamp.class));
        umbralSuperior3.setUpperLimit(1);

        ActividadItinerarioDto actividadItinerario3 = new ActividadItinerarioDto();
        actividadItinerario3.setActivitSumOfAxes(1);
        actividadItinerario3.setActivityId(1);
        actividadItinerario3.setAgreedThreshold(10.0d);
        actividadItinerario3.setAvance(10.0d);
        actividadItinerario3.setCreationDate(mock(Timestamp.class));
        actividadItinerario3.setDeleted(1);
        actividadItinerario3.setHelp("Help");
        actividadItinerario3.setId(1);
        actividadItinerario3.setIncludedInItinerary(1);
        actividadItinerario3.setInferredThreshold("Inferred Threshold");
        actividadItinerario3.setName("Name");
        actividadItinerario3.setObservations("Observations");
        actividadItinerario3.setQualityItineraryId(1);
        actividadItinerario3.setShortName("Short Name");
        actividadItinerario3.setTestingStageId(1);
        actividadItinerario3.setUmbralInferior(umbralInferior3);
        actividadItinerario3.setUmbralSuperior(umbralSuperior3);
        actividadItinerario3.setUmbralesPactados(new ArrayList<>());
        actividadItinerario3.setUpdateDate(mock(Timestamp.class));
        ActividadItinerario actualUpdateProgressResult = actividadItinerarioService.updateProgress(actividadItinerario3);
        verify(actividadItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralPactadoService).actualizarUmbralPactado(Mockito.<Integer>any(), Mockito.<Double>any());
        verify(actividadItinerarioRepository).save(Mockito.<ActividadItinerario>any());
        assertSame(actividadItinerario2, actualUpdateProgressResult);
    }

    /**
     * Method under test: {@link ActividadItinerarioService#remove(Integer)}
     */
    @Test
    void testRemove() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(1);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(1);
        actividadItinerario.setInferredThreshold("Inferred Threshold");
        actividadItinerario.setName("Name");
        actividadItinerario.setObservations("Observations");
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName("Short Name");
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));
        doNothing().when(actividadItinerarioRepository).deleteById(Mockito.<Integer>any());
        when(actividadItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(actividadItinerario);
        ActividadItinerario actualRemoveResult = actividadItinerarioService.remove(1);
        verify(actividadItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadItinerarioRepository).deleteById(Mockito.<Integer>any());
        assertSame(actividadItinerario, actualRemoveResult);
    }

    /**
     * Method under test: {@link ActividadItinerarioService#logicalRemove(Integer)}
     */
    @Test
    void testLogicalRemove() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(1);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(1);
        actividadItinerario.setInferredThreshold("Inferred Threshold");
        actividadItinerario.setName("Name");
        actividadItinerario.setObservations("Observations");
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName("Short Name");
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(1);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(1);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Help");
        umbralInferior2.setId(1);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Threshold");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(1);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(1);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Help");
        umbralSuperior2.setId(1);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Threshold");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(1);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("Help");
        actividadItinerario2.setId(1);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("Inferred Threshold");
        actividadItinerario2.setName("Name");
        actividadItinerario2.setObservations("Observations");
        actividadItinerario2.setQualityItineraryId(1);
        actividadItinerario2.setShortName("Short Name");
        actividadItinerario2.setTestingStageId(1);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));
        when(actividadItinerarioRepository.save(Mockito.<ActividadItinerario>any())).thenReturn(actividadItinerario2);
        when(actividadItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(actividadItinerario);
        ActividadItinerario actualLogicalRemoveResult = actividadItinerarioService.logicalRemove(1);
        verify(actividadItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadItinerarioRepository).save(Mockito.<ActividadItinerario>any());
        assertEquals(1, actualLogicalRemoveResult.getDeleted().intValue());
        assertSame(actividadItinerario, actualLogicalRemoveResult);
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#getItineraryActivitiesByParent(Integer)}
     */
    @Test
    void testGetItineraryActivitiesByParent() {
        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        when(actividadItinerarioRepository.findAll(Mockito.<Example<ActividadItinerario>>any()))
                .thenReturn(actividadItinerarioList);
        List<ActividadItinerario> actualItineraryActivitiesByParent = actividadItinerarioService
                .getItineraryActivitiesByParent(1);
        verify(actividadItinerarioRepository).findAll(Mockito.<Example<ActividadItinerario>>any());
        assertTrue(actualItineraryActivitiesByParent.isEmpty());
        assertSame(actividadItinerarioList, actualItineraryActivitiesByParent);
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#getItinerarioPantallaDetail(Integer)}
     */
    @Test
    void testGetItinerarioPantallaDetail() {
        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad.setAvance(10.0d);
        itinerarioCalidad.setCatalogueId(1);
        itinerarioCalidad.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad.setCurrent(1);
        itinerarioCalidad.setDeleted(1);
        itinerarioCalidad.setDelivery(1);
        itinerarioCalidad.setId(1);
        itinerarioCalidad.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad.setReadOnly(1);
        itinerarioCalidad.setSituacion("Situacion");
        itinerarioCalidad.setSituacionId(1);
        itinerarioCalidad.setUpdateDate(mock(Timestamp.class));
        when(itinerarioCalidadRepository.getByIdOfItinerary(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        ItinerarioPantalla actualItinerarioPantallaDetail = actividadItinerarioService.getItinerarioPantallaDetail(1);
        verify(itinerarioCalidadRepository).getByIdOfItinerary(Mockito.<Integer>any());
        assertEquals("Observaciones Aprobacion", actualItinerarioPantallaDetail.getObservacionesAprobacion());
        assertEquals(0, actualItinerarioPantallaDetail.getReadOnly().intValue());
        assertEquals(1, actualItinerarioPantallaDetail.getCurrent().intValue());
        assertEquals(1, actualItinerarioPantallaDetail.getDelivery().intValue());
        assertEquals(1, actualItinerarioPantallaDetail.getElementId().intValue());
        assertEquals(1, actualItinerarioPantallaDetail.getSituacionId().intValue());
        assertEquals(10.0d, actualItinerarioPantallaDetail.getAvance().doubleValue());
        assertEquals(1L, actualItinerarioPantallaDetail.getId().longValue());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerary(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerary() {
        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad.setAvance(10.0d);
        itinerarioCalidad.setCatalogueId(1);
        itinerarioCalidad.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad.setCurrent(1);
        itinerarioCalidad.setDeleted(1);
        itinerarioCalidad.setDelivery(1);
        itinerarioCalidad.setId(1);
        itinerarioCalidad.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad.setReadOnly(1);
        itinerarioCalidad.setSituacion("Situacion");
        itinerarioCalidad.setSituacionId(1);
        itinerarioCalidad.setUpdateDate(mock(Timestamp.class));

        ItinerarioCalidad itinerarioCalidad2 = new ItinerarioCalidad();
        itinerarioCalidad2.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad2.setAvance(10.0d);
        itinerarioCalidad2.setCatalogueId(1);
        itinerarioCalidad2.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad2.setCurrent(1);
        itinerarioCalidad2.setDeleted(1);
        itinerarioCalidad2.setDelivery(1);
        itinerarioCalidad2.setId(1);
        itinerarioCalidad2.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad2.setReadOnly(1);
        itinerarioCalidad2.setSituacion("Situacion");
        itinerarioCalidad2.setSituacionId(1);
        itinerarioCalidad2.setUpdateDate(mock(Timestamp.class));
        when(itinerarioCalidadRepository.saveAndFlush(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(new ArrayList<>());
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioPantalla, List<ValidationErrorMessage>> actualCalculateItineraryResult = actividadItinerarioService
                .calculateItinerary(elemOrDelivery);
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        verify(itinerarioCalidadRepository).saveAndFlush(Mockito.<ItinerarioCalidad>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertEquals(1, actualCalculateItineraryResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario() {
        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(new ArrayList<>());
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario2() {
        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(new ArrayList<>());
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(5);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        assertEquals(1, actividadItinerarioService.calculateItinerario(elemOrDelivery).size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario3() {
        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(new ArrayList<>());
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(0);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        assertEquals(1, actividadItinerarioService.calculateItinerario(elemOrDelivery).size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario4() {
        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(new ArrayList<>());
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(null);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        assertEquals(1, actividadItinerarioService.calculateItinerario(elemOrDelivery).size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario5() {
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(new ArrayList<>());

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario6() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(4);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(4);
        umbralInferior.setForDelivery(4);
        umbralInferior.setHelp(Constantes.PTE_APROBAC);
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(4);
        umbralInferior.setThreshold(Constantes.PTE_APROBAC);
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(4);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(4);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(4);
        umbralSuperior.setForDelivery(4);
        umbralSuperior.setHelp(Constantes.PTE_APROBAC);
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(4);
        umbralSuperior.setThreshold(Constantes.PTE_APROBAC);
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(4);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(4);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(4);
        actividadItinerario.setHelp(Constantes.PTE_APROBAC);
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(4);
        actividadItinerario.setInferredThreshold(Constantes.PTE_APROBAC);
        actividadItinerario.setName(Constantes.PTE_APROBAC);
        actividadItinerario.setObservations(Constantes.PTE_APROBAC);
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName(Constantes.PTE_APROBAC);
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        actividadItinerarioList.add(actividadItinerario);
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(actividadItinerarioList);

        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("Help");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("Ideal Threshold");
        actividadQA.setName("Name");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("Short Name");
        actividadQA.setStageQAName("Stage QAName");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQAService.get(Mockito.<Integer>any())).thenReturn(actividadQA);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario7() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(4);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(4);
        umbralInferior.setForDelivery(4);
        umbralInferior.setHelp(Constantes.PTE_APROBAC);
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(4);
        umbralInferior.setThreshold(Constantes.PTE_APROBAC);
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(4);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(4);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(4);
        umbralSuperior.setForDelivery(4);
        umbralSuperior.setHelp(Constantes.PTE_APROBAC);
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(4);
        umbralSuperior.setThreshold(Constantes.PTE_APROBAC);
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(4);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(4);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(4);
        actividadItinerario.setHelp(Constantes.PTE_APROBAC);
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(4);
        actividadItinerario.setInferredThreshold(Constantes.PTE_APROBAC);
        actividadItinerario.setName(Constantes.PTE_APROBAC);
        actividadItinerario.setObservations(Constantes.PTE_APROBAC);
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName(Constantes.PTE_APROBAC);
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(0.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        actividadItinerario2.setName("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        actividadItinerario2.setObservations("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("Actividad INCLUIDA en itinerario; acumulado de pesos-ejes (");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        actividadItinerarioList.add(actividadItinerario2);
        actividadItinerarioList.add(actividadItinerario);
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(actividadItinerarioList);

        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("Help");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("Ideal Threshold");
        actividadQA.setName("Name");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("Short Name");
        actividadQA.setStageQAName("Stage QAName");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQAService.get(Mockito.<Integer>any())).thenReturn(actividadQA);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        verify(actividadQAService, atLeast(1)).get(Mockito.<Integer>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario8() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(4);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(4);
        umbralInferior.setForDelivery(4);
        umbralInferior.setHelp(Constantes.PTE_APROBAC);
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(4);
        umbralInferior.setThreshold(Constantes.PTE_APROBAC);
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(4);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(4);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(4);
        umbralSuperior.setForDelivery(4);
        umbralSuperior.setHelp(Constantes.PTE_APROBAC);
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(4);
        umbralSuperior.setThreshold(Constantes.PTE_APROBAC);
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(4);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(4);
        actividadItinerario.setHelp(Constantes.PTE_APROBAC);
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(4);
        actividadItinerario.setInferredThreshold(Constantes.PTE_APROBAC);
        actividadItinerario.setName(Constantes.PTE_APROBAC);
        actividadItinerario.setObservations(Constantes.PTE_APROBAC);
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName(Constantes.PTE_APROBAC);
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        actividadItinerarioList.add(actividadItinerario);
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(actividadItinerarioList);

        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("Help");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("Ideal Threshold");
        actividadQA.setName("Name");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("Short Name");
        actividadQA.setStageQAName("Stage QAName");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQAService.get(Mockito.<Integer>any())).thenReturn(actividadQA);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario9() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(4);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(4);
        umbralInferior.setForDelivery(4);
        umbralInferior.setHelp(Constantes.PTE_APROBAC);
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(4);
        umbralInferior.setThreshold(Constantes.PTE_APROBAC);
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(4);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(4);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(4);
        umbralSuperior.setForDelivery(4);
        umbralSuperior.setHelp(Constantes.PTE_APROBAC);
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(4);
        umbralSuperior.setThreshold(Constantes.PTE_APROBAC);
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(4);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(4);
        actividadItinerario.setHelp(Constantes.PTE_APROBAC);
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(4);
        actividadItinerario.setInferredThreshold(Constantes.PTE_APROBAC);
        actividadItinerario.setName(Constantes.PTE_APROBAC);
        actividadItinerario.setObservations(Constantes.PTE_APROBAC);
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName(Constantes.PTE_APROBAC);
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        actividadItinerarioList.add(actividadItinerario);
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(actividadItinerarioList);

        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("Help");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("Ideal Threshold");
        actividadQA.setName("Name");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("Short Name");
        actividadQA.setStageQAName("Stage QAName");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQAService.get(Mockito.<Integer>any())).thenReturn(actividadQA);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#calculateItinerario(ReplicaElementOEntrega)}
     */
    @Test
    void testCalculateItinerario10() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(4);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(4);
        umbralInferior.setForDelivery(4);
        umbralInferior.setHelp(Constantes.PTE_APROBAC);
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(4);
        umbralInferior.setThreshold(Constantes.PTE_APROBAC);
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(4);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(4);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(4);
        umbralSuperior.setForDelivery(4);
        umbralSuperior.setHelp(Constantes.PTE_APROBAC);
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(4);
        umbralSuperior.setThreshold(Constantes.PTE_APROBAC);
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(4);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(4);
        actividadItinerario.setActivityId(0);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(4);
        actividadItinerario.setHelp(Constantes.PTE_APROBAC);
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(4);
        actividadItinerario.setInferredThreshold(Constantes.PTE_APROBAC);
        actividadItinerario.setName(Constantes.PTE_APROBAC);
        actividadItinerario.setObservations(Constantes.PTE_APROBAC);
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName(Constantes.PTE_APROBAC);
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadItinerarioList = new ArrayList<>();
        actividadItinerarioList.add(actividadItinerario);
        when(actividadItinerarioRepository.calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(actividadItinerarioList);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByNameAndDeletedIsNull(Mockito.<String>any()))
                .thenReturn(situacionItinerario);

        DomainValue domainValue = new DomainValue();
        domainValue.setDomainValueId(1);

        ArrayList<DomainValue> domainValues = new ArrayList<>();
        domainValues.add(domainValue);

        ValorEje valorEje = new ValorEje();
        valorEje.setAxisAttributeId(1);
        valorEje.setDomainValues(domainValues);
        valorEje.setId(1L);

        ArrayList<ValorEje> attributeValuesCollection = new ArrayList<>();
        attributeValuesCollection.add(valorEje);

        ReplicaElementOEntrega elemOrDelivery = new ReplicaElementOEntrega();
        elemOrDelivery.setAttrValOnDemand("Attr Val On Demand");
        elemOrDelivery.setAttributeValuesCollection(attributeValuesCollection);
        elemOrDelivery.setAttributeValuesCollectionParent(new ArrayList<>());
        elemOrDelivery.setCappCode("Capp Code");
        elemOrDelivery.setCatalogElementTypeId(1);
        elemOrDelivery.setDelivery(1);
        elemOrDelivery.setHijos(new ArrayList<>());
        elemOrDelivery.setId(1);
        elemOrDelivery.setVersion("1.0.2");
        Map<ItinerarioCalidad, List<ValidationErrorMessage>> actualCalculateItinerarioResult = actividadItinerarioService
                .calculateItinerario(elemOrDelivery);
        verify(actividadItinerarioRepository).calculateSumOfWeightsForEachAxis(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(situacionItinerarioRepository, atLeast(1)).findByNameAndDeletedIsNull(Mockito.<String>any());
        assertEquals(1, actualCalculateItinerarioResult.size());
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#casosEspeciales(ReplicaElementOEntrega, ActividadItinerario)}
     */
    @Test
    void testCasosEspeciales() {
        ReplicaElementOEntrega elemento = new ReplicaElementOEntrega();
        elemento.setAttrValOnDemand("Attr Val On Demand");
        elemento.setAttributeValuesCollection(new ArrayList<>());
        elemento.setAttributeValuesCollectionParent(new ArrayList<>());
        elemento.setCappCode("Capp Code");
        elemento.setCatalogElementTypeId(1);
        elemento.setDelivery(1);
        elemento.setHijos(new ArrayList<>());
        elemento.setId(1);
        elemento.setVersion("1.0.2");

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerarioIn = new ActividadItinerario();
        actividadItinerarioIn.setActivitSumOfAxes(1);
        actividadItinerarioIn.setActivityId(1);
        actividadItinerarioIn.setAvance(10.0d);
        actividadItinerarioIn.setCreationDate(mock(Timestamp.class));
        actividadItinerarioIn.setDeleted(1);
        actividadItinerarioIn.setHelp("Help");
        actividadItinerarioIn.setId(1);
        actividadItinerarioIn.setIncludedInItinerary(1);
        actividadItinerarioIn.setInferredThreshold("Inferred Threshold");
        actividadItinerarioIn.setName("Name");
        actividadItinerarioIn.setObservations("Observations");
        actividadItinerarioIn.setQualityItineraryId(1);
        actividadItinerarioIn.setShortName("Short Name");
        actividadItinerarioIn.setTestingStageId(1);
        actividadItinerarioIn.setUmbralInferior(umbralInferior);
        actividadItinerarioIn.setUmbralSuperior(umbralSuperior);
        actividadItinerarioIn.setUmbralesPactados(new ArrayList<>());
        actividadItinerarioIn.setUpdateDate(mock(Timestamp.class));
        assertSame(actividadItinerarioIn, actividadItinerarioService.casosEspeciales(elemento, actividadItinerarioIn));
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#casosEspeciales(ReplicaElementOEntrega, ActividadItinerario)}
     */
    @Test
    void testCasosEspeciales2() {
        ReplicaElementOEntrega elemento = new ReplicaElementOEntrega();
        elemento.setAttrValOnDemand("Attr Val On Demand");
        elemento.setAttributeValuesCollection(new ArrayList<>());
        elemento.setAttributeValuesCollectionParent(new ArrayList<>());
        elemento.setCappCode("Capp Code");
        elemento.setCatalogElementTypeId(1);
        elemento.setDelivery(1);
        elemento.setHijos(new ArrayList<>());
        elemento.setId(1);
        elemento.setVersion("1.0.2");

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerarioIn = new ActividadItinerario();
        actividadItinerarioIn.setActivitSumOfAxes(1);
        actividadItinerarioIn.setActivityId(Constantes.NUMBER_9);
        actividadItinerarioIn.setAvance(10.0d);
        actividadItinerarioIn.setCreationDate(mock(Timestamp.class));
        actividadItinerarioIn.setDeleted(1);
        actividadItinerarioIn.setHelp("Help");
        actividadItinerarioIn.setId(1);
        actividadItinerarioIn.setIncludedInItinerary(1);
        actividadItinerarioIn.setInferredThreshold("Inferred Threshold");
        actividadItinerarioIn.setName("Name");
        actividadItinerarioIn.setObservations("Observations");
        actividadItinerarioIn.setQualityItineraryId(1);
        actividadItinerarioIn.setShortName("Short Name");
        actividadItinerarioIn.setTestingStageId(1);
        actividadItinerarioIn.setUmbralInferior(umbralInferior);
        actividadItinerarioIn.setUmbralSuperior(umbralSuperior);
        actividadItinerarioIn.setUmbralesPactados(new ArrayList<>());
        actividadItinerarioIn.setUpdateDate(mock(Timestamp.class));
        assertSame(actividadItinerarioIn, actividadItinerarioService.casosEspeciales(elemento, actividadItinerarioIn));
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#salvarItinerario(ItinerarioCalidad)}
     */
    @Test
    void testSalvarItinerario() {
        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad.setAvance(10.0d);
        itinerarioCalidad.setCatalogueId(1);
        itinerarioCalidad.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad.setCurrent(1);
        itinerarioCalidad.setDeleted(1);
        itinerarioCalidad.setDelivery(1);
        itinerarioCalidad.setId(1);
        itinerarioCalidad.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad.setReadOnly(1);
        itinerarioCalidad.setSituacion("Situacion");
        itinerarioCalidad.setSituacionId(1);
        itinerarioCalidad.setUpdateDate(mock(Timestamp.class));

        ItinerarioCalidad itinerarioCalidad2 = new ItinerarioCalidad();
        itinerarioCalidad2.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad2.setAvance(10.0d);
        itinerarioCalidad2.setCatalogueId(1);
        itinerarioCalidad2.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad2.setCurrent(1);
        itinerarioCalidad2.setDeleted(1);
        itinerarioCalidad2.setDelivery(1);
        itinerarioCalidad2.setId(1);
        itinerarioCalidad2.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad2.setReadOnly(1);
        itinerarioCalidad2.setSituacion("Situacion");
        itinerarioCalidad2.setSituacionId(1);
        itinerarioCalidad2.setUpdateDate(mock(Timestamp.class));
        when(itinerarioCalidadRepository.saveAndFlush(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad);

        ItinerarioCalidad itiToSave = new ItinerarioCalidad();
        itiToSave.setActividadesDeItinerario(new ArrayList<>());
        itiToSave.setAvance(10.0d);
        itiToSave.setCatalogueId(1);
        itiToSave.setCreationDate(mock(Timestamp.class));
        itiToSave.setCurrent(1);
        itiToSave.setDeleted(1);
        itiToSave.setDelivery(1);
        itiToSave.setId(1);
        itiToSave.setObservacionesAprobacion("Observaciones Aprobacion");
        itiToSave.setReadOnly(1);
        itiToSave.setSituacion("Situacion");
        itiToSave.setSituacionId(1);
        itiToSave.setUpdateDate(mock(Timestamp.class));
        ItinerarioCalidad actualSalvarItinerarioResult = actividadItinerarioService.salvarItinerario(itiToSave);
        verify(itinerarioCalidadRepository).saveAndFlush(Mockito.<ItinerarioCalidad>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertNull(itiToSave.getActividadesDeItinerario());
        assertSame(itinerarioCalidad2, actualSalvarItinerarioResult);
    }

    /**
     * Method under test:
     * {@link ActividadItinerarioService#salvarItinerario(ItinerarioCalidad)}
     */
    @Test
    void testSalvarItinerario2() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(1);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(1);
        umbralInferior.setForDelivery(1);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(1);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(1);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(1);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(1);
        umbralSuperior.setForDelivery(1);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(1);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(1);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(1);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(1);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(1);
        actividadItinerario.setInferredThreshold("Inferred Threshold");
        actividadItinerario.setName("Name");
        actividadItinerario.setObservations("Observations");
        actividadItinerario.setQualityItineraryId(1);
        actividadItinerario.setShortName("Short Name");
        actividadItinerario.setTestingStageId(1);
        actividadItinerario.setUmbralInferior(umbralInferior);
        actividadItinerario.setUmbralSuperior(umbralSuperior);
        actividadItinerario.setUmbralesPactados(new ArrayList<>());
        actividadItinerario.setUpdateDate(mock(Timestamp.class));
        when(actividadItinerarioRepository.save(Mockito.<ActividadItinerario>any())).thenReturn(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad.setAvance(10.0d);
        itinerarioCalidad.setCatalogueId(1);
        itinerarioCalidad.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad.setCurrent(1);
        itinerarioCalidad.setDeleted(1);
        itinerarioCalidad.setDelivery(1);
        itinerarioCalidad.setId(1);
        itinerarioCalidad.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad.setReadOnly(1);
        itinerarioCalidad.setSituacion("Situacion");
        itinerarioCalidad.setSituacionId(1);
        itinerarioCalidad.setUpdateDate(mock(Timestamp.class));

        ItinerarioCalidad itinerarioCalidad2 = new ItinerarioCalidad();
        itinerarioCalidad2.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad2.setAvance(10.0d);
        itinerarioCalidad2.setCatalogueId(1);
        itinerarioCalidad2.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad2.setCurrent(1);
        itinerarioCalidad2.setDeleted(1);
        itinerarioCalidad2.setDelivery(1);
        itinerarioCalidad2.setId(1);
        itinerarioCalidad2.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad2.setReadOnly(1);
        itinerarioCalidad2.setSituacion("Situacion");
        itinerarioCalidad2.setSituacionId(1);
        itinerarioCalidad2.setUpdateDate(mock(Timestamp.class));
        when(itinerarioCalidadRepository.saveAndFlush(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad);

        UmbralActividad umbralInferior2 = new UmbralActividad();
        umbralInferior2.setActivityId(1);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(1);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("Help");
        umbralInferior2.setId(1);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("Threshold");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(1);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(1);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("Help");
        umbralSuperior2.setId(1);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("Threshold");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(1);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("Help");
        actividadItinerario2.setId(1);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("Inferred Threshold");
        actividadItinerario2.setName("Name");
        actividadItinerario2.setObservations("Observations");
        actividadItinerario2.setQualityItineraryId(1);
        actividadItinerario2.setShortName("Short Name");
        actividadItinerario2.setTestingStageId(1);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);

        ItinerarioCalidad itiToSave = new ItinerarioCalidad();
        itiToSave.setActividadesDeItinerario(actividadesDeItinerario);
        itiToSave.setAvance(10.0d);
        itiToSave.setCatalogueId(1);
        itiToSave.setCreationDate(mock(Timestamp.class));
        itiToSave.setCurrent(1);
        itiToSave.setDeleted(1);
        itiToSave.setDelivery(1);
        itiToSave.setId(1);
        itiToSave.setObservacionesAprobacion("Observaciones Aprobacion");
        itiToSave.setReadOnly(1);
        itiToSave.setSituacion("Situacion");
        itiToSave.setSituacionId(1);
        itiToSave.setUpdateDate(mock(Timestamp.class));
        ItinerarioCalidad actualSalvarItinerarioResult = actividadItinerarioService.salvarItinerario(itiToSave);
        verify(itinerarioCalidadRepository).saveAndFlush(Mockito.<ItinerarioCalidad>any());
        verify(actividadItinerarioRepository).save(Mockito.<ActividadItinerario>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertNull(itiToSave.getActividadesDeItinerario());
        assertSame(itinerarioCalidad2, actualSalvarItinerarioResult);
    }
}
