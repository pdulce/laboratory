package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.repository.itinerario.ActividadQARepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EtapaPruebasService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class EtapaPruebasServiceDiffblueTest {
    @MockBean
    private ActividadQARepository actividadQARepository;

    @MockBean
    private EtapaPruebasRepository etapaPruebasRepository;

    @Autowired
    private EtapaPruebasService etapaPruebasService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link EtapaPruebasService#setActividadQARepository(ActividadQARepository)}
     *   <li>
     * {@link EtapaPruebasService#setEtapaPruebasRepository(EtapaPruebasRepository)}
     * </ul>
     */
    @Test
    void testSetActividadQARepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     EtapaPruebasService.actividadQARepository
        //     EtapaPruebasService.etapaPruebasRepository

        EtapaPruebasService etapaPruebasService = new EtapaPruebasService();
        etapaPruebasService.setActividadQARepository(mock(ActividadQARepository.class));
        etapaPruebasService.setEtapaPruebasRepository(mock(EtapaPruebasRepository.class));
    }

    /**
     * Method under test: {@link EtapaPruebasService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<EtapaPruebas> etapaPruebasList = new ArrayList<>();
        when(etapaPruebasRepository.findAllByDeletedIsNull(Mockito.<Sort>any())).thenReturn(etapaPruebasList);
        List<EtapaPruebas> actualAll = etapaPruebasService.getAll();
        verify(etapaPruebasRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
        assertTrue(actualAll.isEmpty());
        assertSame(etapaPruebasList, actualAll);
    }

    /**
     * Method under test: {@link EtapaPruebasService#get(Integer)}
     */
    @Test
    void testGet() {
        when(actividadQARepository.getAllFilteredByStageId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);
        EtapaPruebas actualGetResult = etapaPruebasService.get(1);
        verify(actividadQARepository).getAllFilteredByStageId(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertTrue(actualGetResult.getActividadesQA().isEmpty());
        assertSame(etapaPruebas, actualGetResult);
    }

    /**
     * Method under test: {@link EtapaPruebasService#insertar(EtapaPruebas)}
     */
    @Test
    void testInsertar() {
        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.save(Mockito.<EtapaPruebas>any())).thenReturn(etapaPruebas);

        EtapaPruebas etapaPruebas2 = new EtapaPruebas();
        etapaPruebas2.setActividadesQA(new ArrayList<>());
        etapaPruebas2.setCreationDate(mock(Timestamp.class));
        etapaPruebas2.setDeleted(1);
        etapaPruebas2.setDescription("The characteristics of someone or something");
        etapaPruebas2.setId(1);
        etapaPruebas2.setName("Name");
        etapaPruebas2.setUpdateDate(mock(Timestamp.class));
        EtapaPruebas actualInsertarResult = etapaPruebasService.insertar(etapaPruebas2);
        verify(etapaPruebasRepository).save(Mockito.<EtapaPruebas>any());
        assertSame(etapaPruebas, actualInsertarResult);
    }

    /**
     * Method under test: {@link EtapaPruebasService#actualizar(EtapaPruebas)}
     */
    @Test
    void testActualizar() {
        when(actividadQARepository.findAllByTestingStageIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));

        EtapaPruebas etapaPruebas2 = new EtapaPruebas();
        etapaPruebas2.setActividadesQA(new ArrayList<>());
        etapaPruebas2.setCreationDate(mock(Timestamp.class));
        etapaPruebas2.setDeleted(1);
        etapaPruebas2.setDescription("The characteristics of someone or something");
        etapaPruebas2.setId(1);
        etapaPruebas2.setName("Name");
        etapaPruebas2.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.save(Mockito.<EtapaPruebas>any())).thenReturn(etapaPruebas2);
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);

        EtapaPruebas etapaPruebas3 = new EtapaPruebas();
        etapaPruebas3.setActividadesQA(new ArrayList<>());
        etapaPruebas3.setCreationDate(mock(Timestamp.class));
        etapaPruebas3.setDeleted(1);
        etapaPruebas3.setDescription("The characteristics of someone or something");
        etapaPruebas3.setId(1);
        etapaPruebas3.setName("Name");
        etapaPruebas3.setUpdateDate(mock(Timestamp.class));
        EtapaPruebas actualActualizarResult = etapaPruebasService.actualizar(etapaPruebas3);
        verify(actividadQARepository).findAllByTestingStageIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).save(Mockito.<EtapaPruebas>any());
        assertSame(etapaPruebas2, actualActualizarResult);
    }

    /**
     * Method under test: {@link EtapaPruebasService#borradoLogico(int)}
     */
    @Test
    void testBorradoLogico() {
        when(actividadQARepository.getAllFilteredByStageId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));

        EtapaPruebas etapaPruebas2 = new EtapaPruebas();
        etapaPruebas2.setActividadesQA(new ArrayList<>());
        etapaPruebas2.setCreationDate(mock(Timestamp.class));
        etapaPruebas2.setDeleted(1);
        etapaPruebas2.setDescription("The characteristics of someone or something");
        etapaPruebas2.setId(1);
        etapaPruebas2.setName("Name");
        etapaPruebas2.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.save(Mockito.<EtapaPruebas>any())).thenReturn(etapaPruebas2);
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);
        EtapaPruebas actualBorradoLogicoResult = etapaPruebasService.borradoLogico(1);
        verify(actividadQARepository).getAllFilteredByStageId(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(etapaPruebasRepository).save(Mockito.<EtapaPruebas>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(etapaPruebas, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link EtapaPruebasService#borradoLogico(int)}
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

        ArrayList<ActividadQA> actividadQAList = new ArrayList<>();
        actividadQAList.add(actividadQA);
        when(actividadQARepository.getAllFilteredByStageId(Mockito.<Integer>any())).thenReturn(actividadQAList);

        EtapaPruebas etapaPruebas = new EtapaPruebas();
        etapaPruebas.setActividadesQA(new ArrayList<>());
        etapaPruebas.setCreationDate(mock(Timestamp.class));
        etapaPruebas.setDeleted(1);
        etapaPruebas.setDescription("The characteristics of someone or something");
        etapaPruebas.setId(1);
        etapaPruebas.setName("Name");
        etapaPruebas.setUpdateDate(mock(Timestamp.class));
        when(etapaPruebasRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(etapaPruebas);
        EtapaPruebas actualBorradoLogicoResult = etapaPruebasService.borradoLogico(1);
        verify(actividadQARepository).getAllFilteredByStageId(Mockito.<Integer>any());
        verify(etapaPruebasRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertNull(actualBorradoLogicoResult);
    }
}
