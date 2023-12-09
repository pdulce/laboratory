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
import giss.mad.itinerario.model.volatilentities.ActividadReduced;
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
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {ActividadQAService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ActividadQAServiceDiffblueTest {
    @MockBean
    private ActividadQARepository actividadQARepository;

    @Autowired
    private ActividadQAService actividadQAService;

    @MockBean
    private CacheManager cacheManager;

    @MockBean
    private EtapaPruebasRepository etapaPruebasRepository;

    @MockBean
    private PesoRepository pesoRepository;

    @MockBean
    private UmbralActividadRepository umbralActividadRepository;

    /**
     * Method under test: {@link ActividadQAService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        actividadQAService.setCacheManager(cacheManager);
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link ActividadQAService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager2() {
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(new ArrayList<>());

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        actividadQAService.setCacheManager(cacheManager);
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link ActividadQAService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager3() {
        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("testingStageId");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("testingStageId");
        actividadQA.setName("testingStageId");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("testingStageId");
        actividadQA.setStageQAName("testingStageId");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadQA> actividadQAList = new ArrayList<>();
        actividadQAList.add(actividadQA);

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA2);
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(actividadQAList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        actividadQAService.setCacheManager(cacheManager);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
    }

    /**
     * Method under test: {@link ActividadQAService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager4() {
        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(1);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("testingStageId");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("testingStageId");
        actividadQA.setName("testingStageId");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("testingStageId");
        actividadQA.setStageQAName("testingStageId");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(0);
        actividadQA2.setDescription("testingStageId");
        actividadQA2.setHelp("actividades-cache");
        actividadQA2.setId(2);
        actividadQA2.setIdealThreshold("actividades-cache");
        actividadQA2.setName("actividades-cache");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("actividades-cache");
        actividadQA2.setStageQAName("actividades-cache");
        actividadQA2.setTestingStageId(2);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadQA> actividadQAList = new ArrayList<>();
        actividadQAList.add(actividadQA2);
        actividadQAList.add(actividadQA);

        ActividadQA actividadQA3 = new ActividadQA();
        actividadQA3.setCreationDate(mock(Timestamp.class));
        actividadQA3.setDeleted(1);
        actividadQA3.setDescription("The characteristics of someone or something");
        actividadQA3.setHelp("Help");
        actividadQA3.setId(1);
        actividadQA3.setIdealThreshold("Ideal Threshold");
        actividadQA3.setName("Name");
        actividadQA3.setPesos(new ArrayList<>());
        actividadQA3.setShortName("Short Name");
        actividadQA3.setStageQAName("Stage QAName");
        actividadQA3.setTestingStageId(1);
        actividadQA3.setUmbrales(new ArrayList<>());
        actividadQA3.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA3);
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(actividadQAList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        actividadQAService.setCacheManager(cacheManager);
        verify(actividadQARepository, atLeast(1)).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ActividadQAService#setActividadQARepository(ActividadQARepository)}
     *   <li>
     * {@link ActividadQAService#setEtapaPruebasRepository(EtapaPruebasRepository)}
     *   <li>{@link ActividadQAService#setPesoRepository(PesoRepository)}
     *   <li>
     * {@link ActividadQAService#setUmbralActividadRepository(UmbralActividadRepository)}
     * </ul>
     */
    @Test
    void testSetActividadQARepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ActividadQAService.actividadQARepository
        //     ActividadQAService.cacheManager
        //     ActividadQAService.etapaPruebasRepository
        //     ActividadQAService.pesoRepository
        //     ActividadQAService.umbralActividadRepository

        ActividadQAService actividadQAService = new ActividadQAService();
        actividadQAService.setActividadQARepository(mock(ActividadQARepository.class));
        actividadQAService.setEtapaPruebasRepository(mock(EtapaPruebasRepository.class));
        actividadQAService.setPesoRepository(mock(PesoRepository.class));
        actividadQAService.setUmbralActividadRepository(mock(UmbralActividadRepository.class));
    }

    /**
     * Method under test: {@link ActividadQAService#getIdAndNameOfActivities()}
     */
    @Test
    void testGetIdAndNameOfActivities() {
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(new ArrayList<>());
        Collection<ActividadReduced> actualIdAndNameOfActivities = actividadQAService.getIdAndNameOfActivities();
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        assertTrue(actualIdAndNameOfActivities.isEmpty());
    }

    /**
     * Method under test: {@link ActividadQAService#getIdAndNameOfActivities()}
     */
    @Test
    void testGetIdAndNameOfActivities2() {
        ActividadQA actividadQA = new ActividadQA();
        actividadQA.setCreationDate(mock(Timestamp.class));
        actividadQA.setDeleted(2);
        actividadQA.setDescription("The characteristics of someone or something");
        actividadQA.setHelp("testingStageId");
        actividadQA.setId(1);
        actividadQA.setIdealThreshold("testingStageId");
        actividadQA.setName("testingStageId");
        actividadQA.setPesos(new ArrayList<>());
        actividadQA.setShortName("testingStageId");
        actividadQA.setStageQAName("testingStageId");
        actividadQA.setTestingStageId(1);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));

        ArrayList<ActividadQA> actividadQAList = new ArrayList<>();
        actividadQAList.add(actividadQA);
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(actividadQAList);
        Collection<ActividadReduced> actualIdAndNameOfActivities = actividadQAService.getIdAndNameOfActivities();
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        assertEquals(1, actualIdAndNameOfActivities.size());
        ActividadReduced getResult = ((List<ActividadReduced>) actualIdAndNameOfActivities).get(0);
        assertEquals("testingStageId", getResult.getActividad());
        assertEquals(1, getResult.getNum().intValue());
    }

    /**
     * Method under test: {@link ActividadQAService#getAllInAdmonService()}
     */
    @Test
    void testGetAllInAdmonService() {
        ArrayList<ActividadQA> actividadQAList = new ArrayList<>();
        when(actividadQARepository.findInOrderActivitiesWithoutChildren(Mockito.<Sort>any())).thenReturn(actividadQAList);
        List<ActividadQA> actualAllInAdmonService = actividadQAService.getAllInAdmonService();
        verify(actividadQARepository).findInOrderActivitiesWithoutChildren(Mockito.<Sort>any());
        assertTrue(actualAllInAdmonService.isEmpty());
        assertSame(actividadQAList, actualAllInAdmonService);
    }

    /**
     * Method under test: {@link ActividadQAService#getAllInfoById(Integer)}
     */
    @Test
    void testGetAllInfoById() {
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
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);
        ActividadQA actualAllInfoById = actividadQAService.getAllInfoById(1);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(actividadQA, actualAllInfoById);
    }

    /**
     * Method under test: {@link ActividadQAService#get(Integer)}
     */
    @Test
    void testGet() {
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
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        ActividadQA actualGetResult = actividadQAService.get(1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertSame(actividadQA, actualGetResult);
    }

    /**
     * Method under test: {@link ActividadQAService#get(Integer)}
     */
    @Test
    void testGet2() {
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

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        ActividadQA actualGetResult = actividadQAService.get(1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        assertSame(actividadQA, actualGetResult);
    }

    /**
     * Method under test: {@link ActividadQAService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico() {
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

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA2);
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(pesoRepository.findAll(Mockito.<Example<Peso>>any())).thenReturn(new ArrayList<>());
        doNothing().when(pesoRepository).deleteAll(Mockito.<Iterable<Peso>>any());
        when(umbralActividadRepository.findAll(Mockito.<Example<UmbralActividad>>any())).thenReturn(new ArrayList<>());
        doNothing().when(umbralActividadRepository).deleteAll(Mockito.<Iterable<UmbralActividad>>any());
        ActividadQA actualBorradoLogicoResult = actividadQAService.borradoLogico(1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
        verify(pesoRepository).findAll(Mockito.<Example<Peso>>any());
        verify(umbralActividadRepository).findAll(Mockito.<Example<UmbralActividad>>any());
        verify(pesoRepository).deleteAll(Mockito.<Iterable<Peso>>any());
        verify(umbralActividadRepository).deleteAll(Mockito.<Iterable<UmbralActividad>>any());
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(actividadQA, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link ActividadQAService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico2() {
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

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA2);
        when(actividadQARepository.findByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(actividadQA);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        when(pesoRepository.findAll(Mockito.<Example<Peso>>any())).thenReturn(new ArrayList<>());
        doNothing().when(pesoRepository).deleteAll(Mockito.<Iterable<Peso>>any());
        when(umbralActividadRepository.findAll(Mockito.<Example<UmbralActividad>>any())).thenReturn(new ArrayList<>());
        doNothing().when(umbralActividadRepository).deleteAll(Mockito.<Iterable<UmbralActividad>>any());
        ActividadQA actualBorradoLogicoResult = actividadQAService.borradoLogico(1);
        verify(actividadQARepository).findByIdWithoutChildren(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
        verify(pesoRepository).findAll(Mockito.<Example<Peso>>any());
        verify(umbralActividadRepository).findAll(Mockito.<Example<UmbralActividad>>any());
        verify(pesoRepository).deleteAll(Mockito.<Iterable<Peso>>any());
        verify(umbralActividadRepository).deleteAll(Mockito.<Iterable<UmbralActividad>>any());
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(actividadQA, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link ActividadQAService#insertar(ActividadQA)}
     */
    @Test
    void testInsertar() {
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
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualInsertarResult = actividadQAService.insertar(actividadQA2);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals("Name", actividadQA2.getStageQAName());
        assertSame(actividadQA, actualInsertarResult);
    }

    /**
     * Method under test: {@link ActividadQAService#insertar(ActividadQA)}
     */
    @Test
    void testInsertar2() {
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
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualInsertarResult = actividadQAService.insertar(actividadQA2);
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals("Name", actividadQA2.getStageQAName());
        assertSame(actividadQA, actualInsertarResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizar(ActividadQA)}
     */
    @Test
    void testActualizar() {
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

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA2);
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarResult = actividadQAService.actualizar(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals("Name", actualActualizarResult.getStageQAName());
        List<Peso> pesos = actualActualizarResult.getPesos();
        assertEquals(pesos, actividadQAInput.getPesos());
        assertEquals(pesos, actividadQAInput.getUmbrales());
        assertSame(actividadQA2, actualActualizarResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizar(ActividadQA)}
     */
    @Test
    void testActualizar2() {
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

        ActividadQA actividadQA2 = new ActividadQA();
        actividadQA2.setCreationDate(mock(Timestamp.class));
        actividadQA2.setDeleted(1);
        actividadQA2.setDescription("The characteristics of someone or something");
        actividadQA2.setHelp("Help");
        actividadQA2.setId(1);
        actividadQA2.setIdealThreshold("Ideal Threshold");
        actividadQA2.setName("Name");
        actividadQA2.setPesos(new ArrayList<>());
        actividadQA2.setShortName("Short Name");
        actividadQA2.setStageQAName("Stage QAName");
        actividadQA2.setTestingStageId(1);
        actividadQA2.setUmbrales(new ArrayList<>());
        actividadQA2.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.save(Mockito.<ActividadQA>any())).thenReturn(actividadQA2);
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarResult = actividadQAService.actualizar(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(actividadQARepository).save(Mockito.<ActividadQA>any());
        assertEquals("Name", actualActualizarResult.getStageQAName());
        List<Peso> pesos = actualActualizarResult.getPesos();
        assertEquals(pesos, actividadQAInput.getPesos());
        assertEquals(pesos, actividadQAInput.getUmbrales());
        assertSame(actividadQA2, actualActualizarResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarPesos(ActividadQA)}
     */
    @Test
    void testActualizarPesos() {
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
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarPesosResult = actividadQAService.actualizarPesos(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertEquals("Name", actualActualizarPesosResult.getStageQAName());
        assertTrue(actualActualizarPesosResult.getPesos().isEmpty());
        assertTrue(actualActualizarPesosResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarPesosResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarPesos(ActividadQA)}
     */
    @Test
    void testActualizarPesos2() {
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
        actividadQA.setTestingStageId(null);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarPesosResult = actividadQAService.actualizarPesos(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertEquals("", actualActualizarPesosResult.getStageQAName());
        assertTrue(actualActualizarPesosResult.getPesos().isEmpty());
        assertTrue(actualActualizarPesosResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarPesosResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarPesos(ActividadQA)}
     */
    @Test
    void testActualizarPesos3() {
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
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

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
        peso2.setActivityId(1);
        peso2.setAxisAttributeId(1);
        peso2.setCreationDate(mock(Timestamp.class));
        peso2.setDeleted(1);
        peso2.setDomainValueId(1);
        peso2.setElementTypeId(1);
        peso2.setForDelivery(1);
        peso2.setId(1);
        peso2.setUpdateDate(mock(Timestamp.class));
        peso2.setWeightValue(3);
        when(pesoRepository.save(Mockito.<Peso>any())).thenReturn(peso2);
        when(pesoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(peso);

        Peso peso3 = new Peso();
        peso3.setActivityId(1);
        peso3.setAxisAttributeId(1);
        peso3.setCreationDate(mock(Timestamp.class));
        peso3.setDeleted(1);
        peso3.setDomainValueId(1);
        peso3.setElementTypeId(1);
        peso3.setForDelivery(1);
        peso3.setId(1);
        peso3.setUpdateDate(mock(Timestamp.class));
        peso3.setWeightValue(3);

        ArrayList<Peso> pesos = new ArrayList<>();
        pesos.add(peso3);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(pesos);
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarPesosResult = actividadQAService.actualizarPesos(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(pesoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(pesoRepository).save(Mockito.<Peso>any());
        assertEquals("Name", actualActualizarPesosResult.getStageQAName());
        assertTrue(actualActualizarPesosResult.getPesos().isEmpty());
        assertTrue(actualActualizarPesosResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarPesosResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarUmbrales(ActividadQA)}
     */
    @Test
    void testActualizarUmbrales() {
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
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarUmbralesResult = actividadQAService.actualizarUmbrales(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertEquals("Name", actualActualizarUmbralesResult.getStageQAName());
        assertTrue(actualActualizarUmbralesResult.getPesos().isEmpty());
        assertTrue(actualActualizarUmbralesResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarUmbralesResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarUmbrales(ActividadQA)}
     */
    @Test
    void testActualizarUmbrales2() {
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
        actividadQA.setTestingStageId(null);
        actividadQA.setUmbrales(new ArrayList<>());
        actividadQA.setUpdateDate(mock(Timestamp.class));
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(new ArrayList<>());
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarUmbralesResult = actividadQAService.actualizarUmbrales(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertEquals("", actualActualizarUmbralesResult.getStageQAName());
        assertTrue(actualActualizarUmbralesResult.getPesos().isEmpty());
        assertTrue(actualActualizarUmbralesResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarUmbralesResult);
    }

    /**
     * Method under test: {@link ActividadQAService#actualizarUmbrales(ActividadQA)}
     */
    @Test
    void testActualizarUmbrales3() {
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
        when(actividadQARepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(actividadQA);

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

        ArrayList<UmbralActividad> umbrales = new ArrayList<>();
        umbrales.add(umbralActividad3);

        ActividadQA actividadQAInput = new ActividadQA();
        actividadQAInput.setCreationDate(mock(Timestamp.class));
        actividadQAInput.setDeleted(1);
        actividadQAInput.setDescription("The characteristics of someone or something");
        actividadQAInput.setHelp("Help");
        actividadQAInput.setId(1);
        actividadQAInput.setIdealThreshold("Ideal Threshold");
        actividadQAInput.setName("Name");
        actividadQAInput.setPesos(new ArrayList<>());
        actividadQAInput.setShortName("Short Name");
        actividadQAInput.setStageQAName("Stage QAName");
        actividadQAInput.setTestingStageId(1);
        actividadQAInput.setUmbrales(umbrales);
        actividadQAInput.setUpdateDate(mock(Timestamp.class));
        ActividadQA actualActualizarUmbralesResult = actividadQAService.actualizarUmbrales(actividadQAInput);
        verify(actividadQARepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralActividadRepository).save(Mockito.<UmbralActividad>any());
        assertEquals("Name", actualActualizarUmbralesResult.getStageQAName());
        assertTrue(actualActualizarUmbralesResult.getPesos().isEmpty());
        assertTrue(actualActualizarUmbralesResult.getUmbrales().isEmpty());
        assertSame(actividadQA, actualActualizarUmbralesResult);
    }
}
