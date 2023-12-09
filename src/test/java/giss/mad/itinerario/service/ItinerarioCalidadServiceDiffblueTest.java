package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.filters.ItinerarioFilter;
import giss.mad.itinerario.model.itinerario.ActividadItinerario;
import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.model.itinerario.ItinerarioCalidad;
import giss.mad.itinerario.model.itinerario.SituacionItinerario;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.StagePantalla;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.ItinerarioCalidadRepository;
import giss.mad.itinerario.repository.itinerario.SituacionItinerarioRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ItinerarioCalidadService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ItinerarioCalidadServiceDiffblueTest {
    @MockBean
    private ActividadQAService actividadQAService;

    @MockBean
    private EtapaPruebasRepository etapaPruebasRepository;

    @MockBean
    private ItinerarioCalidadRepository itinerarioCalidadRepository;

    @Autowired
    private ItinerarioCalidadService itinerarioCalidadService;

    @MockBean
    private SituacionItinerarioRepository situacionItinerarioRepository;

    @MockBean
    private UmbralActividadRepository umbralActividadRepository;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ItinerarioCalidadService#setActividadQAService(ActividadQAService)}
     *   <li>
     * {@link ItinerarioCalidadService#setEtapaPruebasRepository(EtapaPruebasRepository)}
     *   <li>
     * {@link ItinerarioCalidadService#setItinerarioCalidadRepository(ItinerarioCalidadRepository)}
     *   <li>
     * {@link ItinerarioCalidadService#setSituacionItinerarioRepository(SituacionItinerarioRepository)}
     *   <li>
     * {@link ItinerarioCalidadService#setUmbralActividadRepository(UmbralActividadRepository)}
     * </ul>
     */
    @Test
    void testSetActividadQAService() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ItinerarioCalidadService.actividadQAService
        //     ItinerarioCalidadService.etapaPruebasRepository
        //     ItinerarioCalidadService.itinerarioCalidadRepository
        //     ItinerarioCalidadService.situacionItinerarioRepository
        //     ItinerarioCalidadService.umbralActividadRepository

        ItinerarioCalidadService itinerarioCalidadService = new ItinerarioCalidadService();
        itinerarioCalidadService.setActividadQAService(new ActividadQAService());
        itinerarioCalidadService.setEtapaPruebasRepository(mock(EtapaPruebasRepository.class));
        itinerarioCalidadService.setItinerarioCalidadRepository(mock(ItinerarioCalidadRepository.class));
        itinerarioCalidadService.setSituacionItinerarioRepository(mock(SituacionItinerarioRepository.class));
        itinerarioCalidadService.setUmbralActividadRepository(mock(UmbralActividadRepository.class));
    }

    /**
     * Method under test: {@link ItinerarioCalidadService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<ItinerarioCalidad> itinerarioCalidadList = new ArrayList<>();
        when(itinerarioCalidadRepository.findAll()).thenReturn(itinerarioCalidadList);
        List<ItinerarioCalidad> actualAll = itinerarioCalidadService.getAll();
        verify(itinerarioCalidadRepository).findAll();
        assertTrue(actualAll.isEmpty());
        assertSame(itinerarioCalidadList, actualAll);
    }

    /**
     * Method under test: {@link ItinerarioCalidadService#getAvance(Integer)}
     */
    @Test
    void testGetAvance() {
        when(itinerarioCalidadRepository.getAvanceById(Mockito.<Integer>any())).thenReturn(10.0d);
        Double actualAvance = itinerarioCalidadService.getAvance(1);
        verify(itinerarioCalidadRepository).getAvanceById(Mockito.<Integer>any());
        assertEquals(10.0d, actualAvance.doubleValue());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getPageAllItinerariosByIdElement(Pageable, Integer)}
     */
    @Test
    void testGetPageAllItinerariosByIdElement() {
        PageImpl<ItinerarioCalidad> pageImpl = new PageImpl<>(new ArrayList<>());
        when(itinerarioCalidadRepository.getItinerariesPagingByCatId(Mockito.<Pageable>any(), Mockito.<Integer>any()))
                .thenReturn(pageImpl);
        Page<ItinerarioCalidad> actualPageAllItinerariosByIdElement = itinerarioCalidadService
                .getPageAllItinerariosByIdElement(null, 1);
        verify(itinerarioCalidadRepository).getItinerariesPagingByCatId(Mockito.<Pageable>any(), Mockito.<Integer>any());
        assertTrue(actualPageAllItinerariosByIdElement.toList().isEmpty());
        assertSame(pageImpl, actualPageAllItinerariosByIdElement);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getPageAllItinerariosByIdElementOrEntrega(Pageable, Integer, Integer)}
     */
    @Test
    void testGetPageAllItinerariosByIdElementOrEntrega() {
        PageImpl<ItinerarioCalidad> pageImpl = new PageImpl<>(new ArrayList<>());
        when(itinerarioCalidadRepository.getItinerariesPagingByCatAndDeliveryId(Mockito.<Pageable>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(pageImpl);
        Page<ItinerarioCalidad> actualPageAllItinerariosByIdElementOrEntrega = itinerarioCalidadService
                .getPageAllItinerariosByIdElementOrEntrega(null, 1, 1);
        verify(itinerarioCalidadRepository).getItinerariesPagingByCatAndDeliveryId(Mockito.<Pageable>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any());
        assertTrue(actualPageAllItinerariosByIdElementOrEntrega.toList().isEmpty());
        assertSame(pageImpl, actualPageAllItinerariosByIdElementOrEntrega);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getItinerarioMasRecienteByIdElementOrEntrega(Integer, Integer)}
     */
    @Test
    void testGetItinerarioMasRecienteByIdElementOrEntrega() {
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeliveryAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Sort>any())).thenReturn(new ArrayList<>());
        ItinerarioCalidad actualItinerarioMasRecienteByIdElementOrEntrega = itinerarioCalidadService
                .getItinerarioMasRecienteByIdElementOrEntrega(1, 1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeliveryAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Sort>any());
        assertNull(actualItinerarioMasRecienteByIdElementOrEntrega);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getItinerarioMasRecienteByIdElementOrEntrega(Integer, Integer)}
     */
    @Test
    void testGetItinerarioMasRecienteByIdElementOrEntrega2() {
        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad.setAvance(10.0d);
        itinerarioCalidad.setCatalogueId(1);
        itinerarioCalidad.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad.setCurrent(1);
        itinerarioCalidad.setDeleted(1);
        itinerarioCalidad.setDelivery(1);
        itinerarioCalidad.setId(1);
        itinerarioCalidad.setObservacionesAprobacion("creationDate");
        itinerarioCalidad.setReadOnly(1);
        itinerarioCalidad.setSituacion("creationDate");
        itinerarioCalidad.setSituacionId(1);
        itinerarioCalidad.setUpdateDate(mock(Timestamp.class));

        ArrayList<ItinerarioCalidad> itinerarioCalidadList = new ArrayList<>();
        itinerarioCalidadList.add(itinerarioCalidad);
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeliveryAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Sort>any())).thenReturn(itinerarioCalidadList);
        ItinerarioCalidad actualItinerarioMasRecienteByIdElementOrEntrega = itinerarioCalidadService
                .getItinerarioMasRecienteByIdElementOrEntrega(1, 1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeliveryAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<Integer>any(), Mockito.<Sort>any());
        assertSame(itinerarioCalidad, actualItinerarioMasRecienteByIdElementOrEntrega);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getByIdItinerarioWithCurrentState(Integer)}
     */
    @Test
    void testGetByIdItinerarioWithCurrentState() {
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
        ItinerarioCalidad actualByIdItinerarioWithCurrentState = itinerarioCalidadService
                .getByIdItinerarioWithCurrentState(1);
        verify(itinerarioCalidadRepository).getByIdOfItinerary(Mockito.<Integer>any());
        assertSame(itinerarioCalidad, actualByIdItinerarioWithCurrentState);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getByIdItinerario(Integer)}
     */
    @Test
    void testGetByIdItinerario() {
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        ItinerarioCalidad actualByIdItinerario = itinerarioCalidadService.getByIdItinerario(1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(itinerarioCalidad, actualByIdItinerario);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#hasUnitTestingActivity(Integer)}
     */
    @Test
    void testHasUnitTestingActivity() {
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        boolean actualHasUnitTestingActivityResult = itinerarioCalidadService.hasUnitTestingActivity(1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertFalse(actualHasUnitTestingActivityResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#hasUnitTestingActivity(Integer)}
     */
    @Test
    void testHasUnitTestingActivity2() {
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

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        boolean actualHasUnitTestingActivityResult = itinerarioCalidadService.hasUnitTestingActivity(1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertFalse(actualHasUnitTestingActivityResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#hasUnitTestingActivity(Integer)}
     */
    @Test
    void testHasUnitTestingActivity3() {
        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("Help");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("Ideal Threshold");
        actividadQA.setName("Name");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("Unitarias");
        actividadQA.setStageQAName("Stage QAName");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQAService.get(Mockito.<Integer>any())).thenReturn(actividadQA);

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

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        boolean actualHasUnitTestingActivityResult = itinerarioCalidadService.hasUnitTestingActivity(1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertTrue(actualHasUnitTestingActivityResult);
    }

    /**
     * Method under test: {@link ItinerarioCalidadService#logicalDelete(Integer)}
     */
    @Test
    void testLogicalDelete() {
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);

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
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Integer actualLogicalDeleteResult = itinerarioCalidadService.logicalDelete(1);
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertEquals(1, actualLogicalDeleteResult.intValue());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId() {
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertTrue(actualActivitiesByItineraryId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId2() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertTrue(actualActivitiesByItineraryId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId3() {
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

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualActivitiesByItineraryId.size());
        StagePantalla getResult = actualActivitiesByItineraryId.get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId4() {
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

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior3 = new UmbralActividad();
        umbralInferior3.setActivityId(3);
        umbralInferior3.setCreationDate(mock(Timestamp.class));
        umbralInferior3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setElementTypeId(3);
        umbralInferior3.setExcludeUnreachedThreshold(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setForDelivery(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setHelp(".");
        umbralInferior3.setId(3);
        umbralInferior3.setLowerLimit(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setThreshold(".");
        umbralInferior3.setUpdateDate(mock(Timestamp.class));
        umbralInferior3.setUpperLimit(Constantes.NUMBER_MINUS_ONE);

        UmbralActividad umbralSuperior3 = new UmbralActividad();
        umbralSuperior3.setActivityId(3);
        umbralSuperior3.setCreationDate(mock(Timestamp.class));
        umbralSuperior3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setElementTypeId(3);
        umbralSuperior3.setExcludeUnreachedThreshold(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setForDelivery(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setHelp(".");
        umbralSuperior3.setId(3);
        umbralSuperior3.setLowerLimit(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setThreshold(".");
        umbralSuperior3.setUpdateDate(mock(Timestamp.class));
        umbralSuperior3.setUpperLimit(Constantes.NUMBER_MINUS_ONE);

        ActividadItinerario actividadItinerario3 = new ActividadItinerario();
        actividadItinerario3.setActivitSumOfAxes(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setActivityId(3);
        actividadItinerario3.setAvance(100.0d);
        actividadItinerario3.setCreationDate(mock(Timestamp.class));
        actividadItinerario3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setHelp(".");
        actividadItinerario3.setId(3);
        actividadItinerario3.setIncludedInItinerary(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setInferredThreshold(".");
        actividadItinerario3.setName(".");
        actividadItinerario3.setObservations(".");
        actividadItinerario3.setQualityItineraryId(3);
        actividadItinerario3.setShortName(".");
        actividadItinerario3.setTestingStageId(3);
        actividadItinerario3.setUmbralInferior(umbralInferior3);
        actividadItinerario3.setUmbralSuperior(umbralSuperior3);
        actividadItinerario3.setUmbralesPactados(new ArrayList<>());
        actividadItinerario3.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario3);
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualActivitiesByItineraryId.size());
        StagePantalla getResult = actualActivitiesByItineraryId.get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId5() {
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

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualActivitiesByItineraryId.size());
        StagePantalla getResult = actualActivitiesByItineraryId.get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getActivitiesByItineraryId(Integer, Integer)}
     */
    @Test
    void testGetActivitiesByItineraryId6() {
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

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        Optional<ItinerarioCalidad> ofResult = Optional.of(itinerarioCalidad);
        when(itinerarioCalidadRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        List<StagePantalla> actualActivitiesByItineraryId = itinerarioCalidadService.getActivitiesByItineraryId(1, 1);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualActivitiesByItineraryId.size());
        StagePantalla getResult = actualActivitiesByItineraryId.get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById() {
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertTrue(actualUmbralesPonderadosItiById.isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById2() {
        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertTrue(actualUmbralesPonderadosItiById.isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById3() {
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

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository, atLeast(1)).findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualUmbralesPonderadosItiById.size());
        StagePantalla getResult = actualUmbralesPonderadosItiById.get(0);
        assertEquals("Stage QAName", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById4() {
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

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(1);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        UmbralActividad umbralInferior3 = new UmbralActividad();
        umbralInferior3.setActivityId(3);
        umbralInferior3.setCreationDate(mock(Timestamp.class));
        umbralInferior3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setElementTypeId(3);
        umbralInferior3.setExcludeUnreachedThreshold(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setForDelivery(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setHelp(",");
        umbralInferior3.setId(3);
        umbralInferior3.setLowerLimit(Constantes.NUMBER_MINUS_ONE);
        umbralInferior3.setThreshold(",");
        umbralInferior3.setUpdateDate(mock(Timestamp.class));
        umbralInferior3.setUpperLimit(Constantes.NUMBER_MINUS_ONE);

        UmbralActividad umbralSuperior3 = new UmbralActividad();
        umbralSuperior3.setActivityId(3);
        umbralSuperior3.setCreationDate(mock(Timestamp.class));
        umbralSuperior3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setElementTypeId(3);
        umbralSuperior3.setExcludeUnreachedThreshold(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setForDelivery(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setHelp(",");
        umbralSuperior3.setId(3);
        umbralSuperior3.setLowerLimit(Constantes.NUMBER_MINUS_ONE);
        umbralSuperior3.setThreshold(",");
        umbralSuperior3.setUpdateDate(mock(Timestamp.class));
        umbralSuperior3.setUpperLimit(Constantes.NUMBER_MINUS_ONE);

        ActividadItinerario actividadItinerario3 = new ActividadItinerario();
        actividadItinerario3.setActivitSumOfAxes(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setActivityId(3);
        actividadItinerario3.setAvance(100.0d);
        actividadItinerario3.setCreationDate(mock(Timestamp.class));
        actividadItinerario3.setDeleted(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setHelp(",");
        actividadItinerario3.setId(3);
        actividadItinerario3.setIncludedInItinerary(Constantes.NUMBER_MINUS_ONE);
        actividadItinerario3.setInferredThreshold(",");
        actividadItinerario3.setName(",");
        actividadItinerario3.setObservations(",");
        actividadItinerario3.setQualityItineraryId(3);
        actividadItinerario3.setShortName(",");
        actividadItinerario3.setTestingStageId(3);
        actividadItinerario3.setUmbralInferior(umbralInferior3);
        actividadItinerario3.setUmbralSuperior(umbralSuperior3);
        actividadItinerario3.setUmbralesPactados(new ArrayList<>());
        actividadItinerario3.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario3);
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository, atLeast(1)).findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualUmbralesPonderadosItiById.size());
        StagePantalla getResult = actualUmbralesPonderadosItiById.get(0);
        assertEquals("Stage QAName", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById5() {
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

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository, atLeast(1)).findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualUmbralesPonderadosItiById.size());
        StagePantalla getResult = actualUmbralesPonderadosItiById.get(0);
        assertEquals("Stage QAName", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getUmbralesPonderadosItiById(Integer, Integer, Integer)}
     */
    @Test
    void testGetUmbralesPonderadosItiById6() {
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

        UmbralActividad umbralInferior = new UmbralActividad();
        umbralInferior.setActivityId(1);
        umbralInferior.setCreationDate(mock(Timestamp.class));
        umbralInferior.setDeleted(Integer.MAX_VALUE);
        umbralInferior.setElementTypeId(1);
        umbralInferior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralInferior.setForDelivery(Integer.MAX_VALUE);
        umbralInferior.setHelp("Help");
        umbralInferior.setId(1);
        umbralInferior.setLowerLimit(Integer.MAX_VALUE);
        umbralInferior.setThreshold("Threshold");
        umbralInferior.setUpdateDate(mock(Timestamp.class));
        umbralInferior.setUpperLimit(Integer.MAX_VALUE);

        UmbralActividad umbralSuperior = new UmbralActividad();
        umbralSuperior.setActivityId(1);
        umbralSuperior.setCreationDate(mock(Timestamp.class));
        umbralSuperior.setDeleted(Integer.MAX_VALUE);
        umbralSuperior.setElementTypeId(1);
        umbralSuperior.setExcludeUnreachedThreshold(Integer.MAX_VALUE);
        umbralSuperior.setForDelivery(Integer.MAX_VALUE);
        umbralSuperior.setHelp("Help");
        umbralSuperior.setId(1);
        umbralSuperior.setLowerLimit(Integer.MAX_VALUE);
        umbralSuperior.setThreshold("Threshold");
        umbralSuperior.setUpdateDate(mock(Timestamp.class));
        umbralSuperior.setUpperLimit(Integer.MAX_VALUE);

        ActividadItinerario actividadItinerario = new ActividadItinerario();
        actividadItinerario.setActivitSumOfAxes(Integer.MAX_VALUE);
        actividadItinerario.setActivityId(1);
        actividadItinerario.setAvance(10.0d);
        actividadItinerario.setCreationDate(mock(Timestamp.class));
        actividadItinerario.setDeleted(Integer.MAX_VALUE);
        actividadItinerario.setHelp("Help");
        actividadItinerario.setId(1);
        actividadItinerario.setIncludedInItinerary(Integer.MAX_VALUE);
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
        umbralInferior2.setActivityId(2);
        umbralInferior2.setCreationDate(mock(Timestamp.class));
        umbralInferior2.setDeleted(1);
        umbralInferior2.setElementTypeId(2);
        umbralInferior2.setExcludeUnreachedThreshold(1);
        umbralInferior2.setForDelivery(1);
        umbralInferior2.setHelp("42");
        umbralInferior2.setId(2);
        umbralInferior2.setLowerLimit(1);
        umbralInferior2.setThreshold("42");
        umbralInferior2.setUpdateDate(mock(Timestamp.class));
        umbralInferior2.setUpperLimit(1);

        UmbralActividad umbralSuperior2 = new UmbralActividad();
        umbralSuperior2.setActivityId(2);
        umbralSuperior2.setCreationDate(mock(Timestamp.class));
        umbralSuperior2.setDeleted(1);
        umbralSuperior2.setElementTypeId(2);
        umbralSuperior2.setExcludeUnreachedThreshold(1);
        umbralSuperior2.setForDelivery(1);
        umbralSuperior2.setHelp("42");
        umbralSuperior2.setId(2);
        umbralSuperior2.setLowerLimit(1);
        umbralSuperior2.setThreshold("42");
        umbralSuperior2.setUpdateDate(mock(Timestamp.class));
        umbralSuperior2.setUpperLimit(1);

        ActividadItinerario actividadItinerario2 = new ActividadItinerario();
        actividadItinerario2.setActivitSumOfAxes(null);
        actividadItinerario2.setActivityId(2);
        actividadItinerario2.setAvance(10.0d);
        actividadItinerario2.setCreationDate(mock(Timestamp.class));
        actividadItinerario2.setDeleted(1);
        actividadItinerario2.setHelp("");
        actividadItinerario2.setId(2);
        actividadItinerario2.setIncludedInItinerary(1);
        actividadItinerario2.setInferredThreshold("");
        actividadItinerario2.setName("");
        actividadItinerario2.setObservations("");
        actividadItinerario2.setQualityItineraryId(2);
        actividadItinerario2.setShortName("");
        actividadItinerario2.setTestingStageId(2);
        actividadItinerario2.setUmbralInferior(umbralInferior2);
        actividadItinerario2.setUmbralSuperior(umbralSuperior2);
        actividadItinerario2.setUmbralesPactados(new ArrayList<>());
        actividadItinerario2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadItinerario> actividadesDeItinerario = new ArrayList<>();
        actividadesDeItinerario.add(actividadItinerario2);
        actividadesDeItinerario.add(actividadItinerario);

        ItinerarioCalidad itinerarioCalidad = new ItinerarioCalidad();
        itinerarioCalidad.setActividadesDeItinerario(actividadesDeItinerario);
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
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<StagePantalla> actualUmbralesPonderadosItiById = itinerarioCalidadService.getUmbralesPonderadosItiById(1, 1,
                1);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository, atLeast(1)).findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Sort>any());
        verify(actividadQAService).get(Mockito.<Integer>any());
        assertEquals(1, actualUmbralesPonderadosItiById.size());
        StagePantalla getResult = actualUmbralesPonderadosItiById.get(0);
        assertEquals("Stage QAName", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test: {@link ItinerarioCalidadService#update(ItinerarioCalidad)}
     */
    @Test
    void testUpdate() {
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
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);

        ItinerarioCalidad itinerarioCalidad3 = new ItinerarioCalidad();
        itinerarioCalidad3.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad3.setAvance(10.0d);
        itinerarioCalidad3.setCatalogueId(1);
        itinerarioCalidad3.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad3.setCurrent(1);
        itinerarioCalidad3.setDeleted(1);
        itinerarioCalidad3.setDelivery(1);
        itinerarioCalidad3.setId(1);
        itinerarioCalidad3.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad3.setReadOnly(1);
        itinerarioCalidad3.setSituacion("Situacion");
        itinerarioCalidad3.setSituacionId(1);
        itinerarioCalidad3.setUpdateDate(mock(Timestamp.class));
        ItinerarioCalidad actualUpdateResult = itinerarioCalidadService.update(itinerarioCalidad3);
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertSame(itinerarioCalidad2, actualUpdateResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#setActiveItinerary(Integer)}
     */
    @Test
    void testSetActiveItinerary() {
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
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        Optional<SituacionItinerario> ofResult = Optional.of(situacionItinerario);
        when(situacionItinerarioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        ItinerarioCalidad actualSetActiveItineraryResult = itinerarioCalidadService.setActiveItinerary(1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(situacionItinerarioRepository).findById(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertEquals("Name", actualSetActiveItineraryResult.getSituacion());
        assertSame(itinerarioCalidad2, actualSetActiveItineraryResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#setActiveItinerary(Integer)}
     */
    @Test
    void testSetActiveItinerary2() {
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
        itinerarioCalidad2.setSituacionId(null);
        itinerarioCalidad2.setUpdateDate(mock(Timestamp.class));
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);
        ItinerarioCalidad actualSetActiveItineraryResult = itinerarioCalidadService.setActiveItinerary(1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertNull(actualSetActiveItineraryResult.getSituacion());
        assertSame(itinerarioCalidad2, actualSetActiveItineraryResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#setActiveItinerary(Integer)}
     */
    @Test
    void testSetActiveItinerary3() {
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

        ItinerarioCalidad itinerarioCalidad3 = new ItinerarioCalidad();
        itinerarioCalidad3.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad3.setAvance(10.0d);
        itinerarioCalidad3.setCatalogueId(1);
        itinerarioCalidad3.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad3.setCurrent(1);
        itinerarioCalidad3.setDeleted(1);
        itinerarioCalidad3.setDelivery(1);
        itinerarioCalidad3.setId(1);
        itinerarioCalidad3.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad3.setReadOnly(1);
        itinerarioCalidad3.setSituacion("Situacion");
        itinerarioCalidad3.setSituacionId(1);
        itinerarioCalidad3.setUpdateDate(mock(Timestamp.class));

        ArrayList<ItinerarioCalidad> itinerarioCalidadList = new ArrayList<>();
        itinerarioCalidadList.add(itinerarioCalidad3);
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(itinerarioCalidadList);
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        Optional<SituacionItinerario> ofResult = Optional.of(situacionItinerario);
        when(situacionItinerarioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        ItinerarioCalidad actualSetActiveItineraryResult = itinerarioCalidadService.setActiveItinerary(1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(situacionItinerarioRepository).findById(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).save(Mockito.<ItinerarioCalidad>any());
        assertEquals("Name", actualSetActiveItineraryResult.getSituacion());
        assertSame(itinerarioCalidad2, actualSetActiveItineraryResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#setActiveItinerary(Integer)}
     */
    @Test
    void testSetActiveItinerary4() {
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

        ItinerarioCalidad itinerarioCalidad3 = new ItinerarioCalidad();
        itinerarioCalidad3.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad3.setAvance(10.0d);
        itinerarioCalidad3.setCatalogueId(1);
        itinerarioCalidad3.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad3.setCurrent(1);
        itinerarioCalidad3.setDeleted(1);
        itinerarioCalidad3.setDelivery(1);
        itinerarioCalidad3.setId(1);
        itinerarioCalidad3.setObservacionesAprobacion("Observaciones Aprobacion");
        itinerarioCalidad3.setReadOnly(1);
        itinerarioCalidad3.setSituacion("Situacion");
        itinerarioCalidad3.setSituacionId(1);
        itinerarioCalidad3.setUpdateDate(mock(Timestamp.class));

        ItinerarioCalidad itinerarioCalidad4 = new ItinerarioCalidad();
        itinerarioCalidad4.setActividadesDeItinerario(new ArrayList<>());
        itinerarioCalidad4.setAvance(1.0d);
        itinerarioCalidad4.setCatalogueId(2);
        itinerarioCalidad4.setCreationDate(mock(Timestamp.class));
        itinerarioCalidad4.setCurrent(0);
        itinerarioCalidad4.setDeleted(0);
        itinerarioCalidad4.setDelivery(0);
        itinerarioCalidad4.setId(2);
        itinerarioCalidad4.setObservacionesAprobacion("42");
        itinerarioCalidad4.setReadOnly(0);
        itinerarioCalidad4.setSituacion("42");
        itinerarioCalidad4.setSituacionId(2);
        itinerarioCalidad4.setUpdateDate(mock(Timestamp.class));

        ArrayList<ItinerarioCalidad> itinerarioCalidadList = new ArrayList<>();
        itinerarioCalidadList.add(itinerarioCalidad4);
        itinerarioCalidadList.add(itinerarioCalidad3);
        when(itinerarioCalidadRepository.save(Mockito.<ItinerarioCalidad>any())).thenReturn(itinerarioCalidad2);
        when(itinerarioCalidadRepository.findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(itinerarioCalidadList);
        when(itinerarioCalidadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(itinerarioCalidad);

        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        Optional<SituacionItinerario> ofResult = Optional.of(situacionItinerario);
        when(situacionItinerarioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        ItinerarioCalidad actualSetActiveItineraryResult = itinerarioCalidadService.setActiveItinerary(1);
        verify(itinerarioCalidadRepository).findAllByCatalogueIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(situacionItinerarioRepository).findById(Mockito.<Integer>any());
        verify(itinerarioCalidadRepository, atLeast(1)).save(Mockito.<ItinerarioCalidad>any());
        assertEquals("Name", actualSetActiveItineraryResult.getSituacion());
        assertSame(itinerarioCalidad2, actualSetActiveItineraryResult);
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getFilteredItineraries(ItinerarioFilter)}
     */
    @Test
    void testGetFilteredItineraries() {
        ItinerarioFilter filter = new ItinerarioFilter();
        filter.setElementsIds(new ArrayList<>());
        assertTrue(itinerarioCalidadService.getFilteredItineraries(filter).isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getFilteredItineraries(ItinerarioFilter)}
     */
    @Test
    void testGetFilteredItineraries2() {
        ItinerarioFilter filter = mock(ItinerarioFilter.class);
        when(filter.getCurrent()).thenReturn(1);
        when(filter.getIsDelivery()).thenReturn(1);
        when(filter.getSituationId()).thenReturn(1);
        when(filter.getEndDate()).thenReturn(mock(Date.class));
        when(filter.getStartDate()).thenReturn(mock(Date.class));
        when(filter.getElementsIds()).thenReturn(new ArrayList<>());
        List<ItinerarioCalidad> actualFilteredItineraries = itinerarioCalidadService.getFilteredItineraries(filter);
        verify(filter).getCurrent();
        verify(filter).getElementsIds();
        verify(filter).getEndDate();
        verify(filter).getIsDelivery();
        verify(filter).getSituationId();
        verify(filter).getStartDate();
        assertTrue(actualFilteredItineraries.isEmpty());
    }

    /**
     * Method under test:
     * {@link ItinerarioCalidadService#getFilteredItineraries(ItinerarioFilter)}
     */
    @Test
    void testGetFilteredItineraries3() {
        when(itinerarioCalidadRepository.getFilteredItineraries(Mockito.<Timestamp>any(), Mockito.<Timestamp>any(),
                Mockito.<Integer>any(), Mockito.<List<Integer>>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);

        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        ItinerarioFilter filter = mock(ItinerarioFilter.class);
        when(filter.getCurrent()).thenReturn(1);
        when(filter.getIsDelivery()).thenReturn(1);
        when(filter.getSituationId()).thenReturn(1);
        when(filter.getEndDate()).thenReturn(date);
        when(filter.getStartDate()).thenReturn(date2);
        when(filter.getElementsIds()).thenReturn(integerList);
        List<ItinerarioCalidad> actualFilteredItineraries = itinerarioCalidadService.getFilteredItineraries(filter);
        verify(filter).getCurrent();
        verify(filter).getElementsIds();
        verify(filter, atLeast(1)).getEndDate();
        verify(filter).getIsDelivery();
        verify(filter).getSituationId();
        verify(filter).getStartDate();
        verify(itinerarioCalidadRepository).getFilteredItineraries(Mockito.<Timestamp>any(), Mockito.<Timestamp>any(),
                Mockito.<Integer>any(), Mockito.<List<Integer>>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        verify(date).getTime();
        verify(date2).getTime();
        assertTrue(actualFilteredItineraries.isEmpty());
    }
}
