package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.itinerario.UmbralActividad;
import giss.mad.itinerario.model.volatilentities.StagePantalla;
import giss.mad.itinerario.model.volatilentities.UmbralGraph;
import giss.mad.itinerario.repository.itinerario.ActividadQARepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;
import giss.mad.itinerario.repository.itinerario.UmbralActividadRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UmbralActividadService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class UmbralActividadServiceDiffblueTest {
    @MockBean
    private ActividadQARepository actividadQARepository;

    @MockBean
    private EtapaPruebasRepository etapaPruebasRepository;

    @MockBean
    private PesoRepository pesoRepository;

    @MockBean
    private UmbralActividadRepository umbralActividadRepository;

    @Autowired
    private UmbralActividadService umbralActividadService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link UmbralActividadService#setActividadRepository(ActividadQARepository)}
     *   <li>
     * {@link UmbralActividadService#setEtapaPruebasRepository(EtapaPruebasRepository)}
     *   <li>{@link UmbralActividadService#setPesoRepository(PesoRepository)}
     *   <li>
     * {@link UmbralActividadService#setUmbralActividadRepository(UmbralActividadRepository)}
     * </ul>
     */
    @Test
    void testSetActividadRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     UmbralActividadService.actividadRepository
        //     UmbralActividadService.etapaPruebasRepository
        //     UmbralActividadService.pesoRepository
        //     UmbralActividadService.umbralActividadRepository

        UmbralActividadService umbralActividadService = new UmbralActividadService();
        umbralActividadService.setActividadRepository(mock(ActividadQARepository.class));
        umbralActividadService.setEtapaPruebasRepository(mock(EtapaPruebasRepository.class));
        umbralActividadService.setPesoRepository(mock(PesoRepository.class));
        umbralActividadService.setUmbralActividadRepository(mock(UmbralActividadRepository.class));
    }

    /**
     * Method under test: {@link UmbralActividadService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        when(umbralActividadRepository.findAllByDeletedIsNull()).thenReturn(umbralActividadList);
        List<UmbralActividad> actualAll = umbralActividadService.getAll();
        verify(umbralActividadRepository).findAllByDeletedIsNull();
        assertTrue(actualAll.isEmpty());
        assertSame(umbralActividadList, actualAll);
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement() {
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertTrue(actualUmbralesByTypeOfElement.isEmpty());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement2() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByTypeOfElement.size());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement3() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        UmbralActividad umbralActividad2 = new UmbralActividad();
        umbralActividad2.setActivityId(2);
        umbralActividad2.setCreationDate(mock(Timestamp.class));
        umbralActividad2.setDeleted(Constantes.NUMBER_9999);
        umbralActividad2.setElementTypeId(2);
        umbralActividad2.setExcludeUnreachedThreshold(Constantes.NUMBER_9999);
        umbralActividad2.setForDelivery(Constantes.NUMBER_9999);
        umbralActividad2.setHelp("9");
        umbralActividad2.setId(2);
        umbralActividad2.setLowerLimit(Constantes.NUMBER_9999);
        umbralActividad2.setThreshold("9");
        umbralActividad2.setUpdateDate(mock(Timestamp.class));
        umbralActividad2.setUpperLimit(Constantes.NUMBER_9999);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad2);
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(actividadQARepository, atLeast(1)).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository, atLeast(1)).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(2, actualUmbralesByTypeOfElement.size());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement4() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(Constantes.NUMBER_9999);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByTypeOfElement.size());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement5() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(Constantes.NUMBER_9999);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByTypeOfElement.size());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByTypeOfElement(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByTypeOfElement6() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(2);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        List<UmbralGraph> actualUmbralesByTypeOfElement = umbralActividadService.getUmbralesByTypeOfElement(1, 1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByTypeOfElement.size());
    }

    /**
     * Method under test: {@link UmbralActividadService#removePhysical(Integer)}
     */
    @Test
    void testRemovePhysical() {
        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);
        when(umbralActividadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(umbralActividad);
        doNothing().when(umbralActividadRepository).delete(Mockito.<UmbralActividad>any());
        UmbralActividad actualRemovePhysicalResult = umbralActividadService.removePhysical(1);
        verify(umbralActividadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).delete(Mockito.<UmbralActividad>any());
        assertSame(umbralActividad, actualRemovePhysicalResult);
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByStage(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByStage() {
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        Collection<StagePantalla> actualUmbralesByStage = umbralActividadService.getUmbralesByStage(1, 1);
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertTrue(actualUmbralesByStage.isEmpty());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByStage(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByStage2() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        Collection<StagePantalla> actualUmbralesByStage = umbralActividadService.getUmbralesByStage(1, 1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByStage.size());
        StagePantalla getResult = ((List<StagePantalla>) actualUmbralesByStage).get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(1, getResult.getActivities().size());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getUmbralesByStage(Integer, Integer)}
     */
    @Test
    void testGetUmbralesByStage3() {
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
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        UmbralActividad umbralActividad2 = new UmbralActividad();
        umbralActividad2.setActivityId(2);
        umbralActividad2.setCreationDate(mock(Timestamp.class));
        umbralActividad2.setDeleted(0);
        umbralActividad2.setElementTypeId(2);
        umbralActividad2.setExcludeUnreachedThreshold(0);
        umbralActividad2.setForDelivery(0);
        umbralActividad2.setHelp("42");
        umbralActividad2.setId(2);
        umbralActividad2.setLowerLimit(0);
        umbralActividad2.setThreshold("42");
        umbralActividad2.setUpdateDate(mock(Timestamp.class));
        umbralActividad2.setUpperLimit(0);

        ArrayList<UmbralActividad> umbralActividadList = new ArrayList<>();
        umbralActividadList.add(umbralActividad2);
        umbralActividadList.add(umbralActividad);
        when(umbralActividadRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(umbralActividadList);
        Collection<StagePantalla> actualUmbralesByStage = umbralActividadService.getUmbralesByStage(1, 1);
        verify(actividadQARepository, atLeast(1)).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(etapaPruebasRepository, atLeast(1)).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findAllByDeletedIsNullAndElementTypeIdAndForDelivery(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        assertEquals(1, actualUmbralesByStage.size());
        StagePantalla getResult = ((List<StagePantalla>) actualUmbralesByStage).get(0);
        assertEquals("Name", getResult.getStage());
        assertEquals(1, getResult.getIdStage().intValue());
        assertEquals(2, getResult.getActivities().size());
    }

    /**
     * Method under test: {@link UmbralActividadService#get(Integer)}
     */
    @Test
    void testGet() {
        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);
        when(umbralActividadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(umbralActividad);
        UmbralActividad actualGetResult = umbralActividadService.get(1);
        verify(umbralActividadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(umbralActividad, actualGetResult);
    }

    /**
     * Method under test: {@link UmbralActividadService#save(UmbralActividad)}
     */
    @Test
    void testSave() {
        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);
        when(umbralActividadRepository.save(Mockito.<UmbralActividad>any())).thenReturn(umbralActividad);

        UmbralActividad umbralActividad2 = new UmbralActividad();
        umbralActividad2.setActivityId(1);
        umbralActividad2.setCreationDate(mock(Timestamp.class));
        umbralActividad2.setDeleted(1);
        umbralActividad2.setElementTypeId(1);
        umbralActividad2.setExcludeUnreachedThreshold(1);
        umbralActividad2.setForDelivery(1);
        umbralActividad2.setHelp("Help");
        umbralActividad2.setId(1);
        umbralActividad2.setLowerLimit(1);
        umbralActividad2.setThreshold("Threshold");
        umbralActividad2.setUpdateDate(mock(Timestamp.class));
        umbralActividad2.setUpperLimit(1);
        UmbralActividad actualSaveResult = umbralActividadService.save(umbralActividad2);
        verify(umbralActividadRepository).save(Mockito.<UmbralActividad>any());
        assertSame(umbralActividad, actualSaveResult);
    }

    /**
     * Method under test: {@link UmbralActividadService#update(UmbralActividad)}
     */
    @Test
    void testUpdate() {
        UmbralActividad umbralActividad = new UmbralActividad();
        umbralActividad.setActivityId(1);
        umbralActividad.setCreationDate(mock(Timestamp.class));
        umbralActividad.setDeleted(1);
        umbralActividad.setElementTypeId(1);
        umbralActividad.setExcludeUnreachedThreshold(1);
        umbralActividad.setForDelivery(1);
        umbralActividad.setHelp("Help");
        umbralActividad.setId(1);
        umbralActividad.setLowerLimit(1);
        umbralActividad.setThreshold("Threshold");
        umbralActividad.setUpdateDate(mock(Timestamp.class));
        umbralActividad.setUpperLimit(1);

        UmbralActividad umbralActividad2 = new UmbralActividad();
        umbralActividad2.setActivityId(1);
        umbralActividad2.setCreationDate(mock(Timestamp.class));
        umbralActividad2.setDeleted(1);
        umbralActividad2.setElementTypeId(1);
        umbralActividad2.setExcludeUnreachedThreshold(1);
        umbralActividad2.setForDelivery(1);
        umbralActividad2.setHelp("Help");
        umbralActividad2.setId(1);
        umbralActividad2.setLowerLimit(1);
        umbralActividad2.setThreshold("Threshold");
        umbralActividad2.setUpdateDate(mock(Timestamp.class));
        umbralActividad2.setUpperLimit(1);
        when(umbralActividadRepository.save(Mockito.<UmbralActividad>any())).thenReturn(umbralActividad2);
        when(umbralActividadRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(umbralActividad);

        UmbralActividad umbralActividad3 = new UmbralActividad();
        umbralActividad3.setActivityId(1);
        umbralActividad3.setCreationDate(mock(Timestamp.class));
        umbralActividad3.setDeleted(1);
        umbralActividad3.setElementTypeId(1);
        umbralActividad3.setExcludeUnreachedThreshold(1);
        umbralActividad3.setForDelivery(1);
        umbralActividad3.setHelp("Help");
        umbralActividad3.setId(1);
        umbralActividad3.setLowerLimit(1);
        umbralActividad3.setThreshold("Threshold");
        umbralActividad3.setUpdateDate(mock(Timestamp.class));
        umbralActividad3.setUpperLimit(1);
        UmbralActividad actualUpdateResult = umbralActividadService.update(umbralActividad3);
        verify(umbralActividadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).save(Mockito.<UmbralActividad>any());
        assertSame(umbralActividad2, actualUpdateResult);
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths() {
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(3, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(0, actualMaximumOfWeigths.intValue());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths2() {
        Peso peso = new Peso();
        peso.setActivityId(1);
        peso.setAxisAttributeId(1);
        peso.setCreationDate(mock(Timestamp.class));
        peso.setDeleted(1);
        peso.setDomainValueId(1);
        peso.setElementTypeId(1);
        peso.setForDelivery(1);
        peso.setId(1);
        peso.setUpdateDate(mock(Timestamp.class));
        peso.setWeightValue(3);

        ArrayList<Peso> pesoList = new ArrayList<>();
        pesoList.add(peso);
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(pesoList);
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(3, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(Constantes.NUMBER_66, actualMaximumOfWeigths.intValue());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths3() {
        Peso peso = new Peso();
        peso.setActivityId(1);
        peso.setAxisAttributeId(1);
        peso.setCreationDate(mock(Timestamp.class));
        peso.setDeleted(1);
        peso.setDomainValueId(1);
        peso.setElementTypeId(1);
        peso.setForDelivery(1);
        peso.setId(1);
        peso.setUpdateDate(mock(Timestamp.class));
        peso.setWeightValue(3);

        Peso peso2 = new Peso();
        peso2.setActivityId(2);
        peso2.setAxisAttributeId(2);
        peso2.setCreationDate(mock(Timestamp.class));
        peso2.setDeleted(Constantes.NUMBER_23);
        peso2.setDomainValueId(2);
        peso2.setElementTypeId(2);
        peso2.setForDelivery(Constantes.NUMBER_23);
        peso2.setId(2);
        peso2.setUpdateDate(mock(Timestamp.class));
        peso2.setWeightValue(Constantes.NUMBER_42);

        ArrayList<Peso> pesoList = new ArrayList<>();
        pesoList.add(peso2);
        pesoList.add(peso);
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(pesoList);
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(3, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(924, actualMaximumOfWeigths.intValue());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths4() {
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(Constantes.NUMBER_23, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(0, actualMaximumOfWeigths.intValue());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths5() {
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(2, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(0, actualMaximumOfWeigths.intValue());
    }

    /**
     * Method under test:
     * {@link UmbralActividadService#getMaximumOfWeigths(Integer, Integer, Integer)}
     */
    @Test
    void testGetMaximumOfWeigths6() {
        when(pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Integer actualMaximumOfWeigths = umbralActividadService.getMaximumOfWeigths(4, 3, 1);
        verify(pesoRepository, atLeast(1))
                .findAllByDeletedIsNullAndElementTypeIdAndActivityIdAndAxisAttributeIdAndForDelivery(Mockito.<Integer>any(),
                        Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertEquals(0, actualMaximumOfWeigths.intValue());
    }
}
