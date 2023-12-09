package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.TipoElementoCatalogoRepository;

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

@ContextConfiguration(classes = {TipoElementoCatalogoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class TipoElementoCatalogoServiceMockitoTest {
    @MockBean
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @MockBean
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;

    @Autowired
    private TipoElementoCatalogoService tipoElementoCatalogoService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link TipoElementoCatalogoService#setAtributoEjePorTipoElementoRepository(AtributoEjePorTipoElementoRepository)}
     *   <li>
     * {@link TipoElementoCatalogoService#setTipoElementoCatalogoRepository(TipoElementoCatalogoRepository)}
     * </ul>
     */
    @Test
    void testSetAtributoEjePorTipoElementoRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     TipoElementoCatalogoService.atributoEjePorTipoElementoRepository
        //     TipoElementoCatalogoService.tipoElementoCatalogoRepository

        TipoElementoCatalogoService tipoElementoCatalogoService = new TipoElementoCatalogoService();
        tipoElementoCatalogoService
                .setAtributoEjePorTipoElementoRepository(mock(AtributoEjePorTipoElementoRepository.class));
        tipoElementoCatalogoService.setTipoElementoCatalogoRepository(mock(TipoElementoCatalogoRepository.class));
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#findOnlyTypes()}
     */
    @Test
    void testFindOnlyTypes() {
        ArrayList<TipoElementoCatalogo> tipoElementoCatalogoList = new ArrayList<>();
        when(tipoElementoCatalogoRepository.findOnlyTypes()).thenReturn(tipoElementoCatalogoList);
        List<TipoElementoCatalogo> actualFindOnlyTypesResult = tipoElementoCatalogoService.findOnlyTypes();
        verify(tipoElementoCatalogoRepository).findOnlyTypes();
        assertTrue(actualFindOnlyTypesResult.isEmpty());
        assertSame(tipoElementoCatalogoList, actualFindOnlyTypesResult);
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#findOnlyTypes()}
     */
    @Test
    void testFindOnlyTypes2() {
        when(tipoElementoCatalogoRepository.findOnlyTypes()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.findOnlyTypes());
        verify(tipoElementoCatalogoRepository).findOnlyTypes();
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#getLabelsOrdered()}
     */
    @Test
    void testGetLabelsOrdered() {
        when(tipoElementoCatalogoRepository.findAllByDeletedIsNull(Mockito.<Sort>any())).thenReturn(new ArrayList<>());
        List<String> actualLabelsOrdered = tipoElementoCatalogoService.getLabelsOrdered();
        verify(tipoElementoCatalogoRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
        assertTrue(actualLabelsOrdered.isEmpty());
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#getLabelsOrdered()}
     */
    @Test
    void testGetLabelsOrdered2() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("id");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<TipoElementoCatalogo> tipoElementoCatalogoList = new ArrayList<>();
        tipoElementoCatalogoList.add(tipoElementoCatalogo);
        when(tipoElementoCatalogoRepository.findAllByDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(tipoElementoCatalogoList);
        List<String> actualLabelsOrdered = tipoElementoCatalogoService.getLabelsOrdered();
        verify(tipoElementoCatalogoRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
        assertEquals(1, actualLabelsOrdered.size());
        assertEquals("id", actualLabelsOrdered.get(0));
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#getLabelsOrdered()}
     */
    @Test
    void testGetLabelsOrdered3() {
        when(tipoElementoCatalogoRepository.findAllByDeletedIsNull(Mockito.<Sort>any()))
                .thenThrow(new IllegalArgumentException("id"));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.getLabelsOrdered());
        verify(tipoElementoCatalogoRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#get(Integer)}
     */
    @Test
    void testGet() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);
        TipoElementoCatalogo actualGetResult = tipoElementoCatalogoService.get(1);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(tipoElementoCatalogo, actualGetResult);
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#get(Integer)}
     */
    @Test
    void testGet2() {
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.get(1));
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#getAllWithInfo()}
     */
    @Test
    void testGetAllWithInfo() {
        ArrayList<TipoElementoCatalogo> tipoElementoCatalogoList = new ArrayList<>();
        when(tipoElementoCatalogoRepository.findAllByDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(tipoElementoCatalogoList);
        List<TipoElementoCatalogo> actualAllWithInfo = tipoElementoCatalogoService.getAllWithInfo();
        verify(tipoElementoCatalogoRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
        assertTrue(actualAllWithInfo.isEmpty());
        assertSame(tipoElementoCatalogoList, actualAllWithInfo);
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#getAllWithInfo()}
     */
    @Test
    void testGetAllWithInfo2() {
        when(tipoElementoCatalogoRepository.findAllByDeletedIsNull(Mockito.<Sort>any()))
                .thenThrow(new IllegalArgumentException("hierarchyLevel"));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.getAllWithInfo());
        verify(tipoElementoCatalogoRepository).findAllByDeletedIsNull(Mockito.<Sort>any());
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#insertar(TipoElementoCatalogo)}
     */
    @Test
    void testInsertar() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualInsertarResult = tipoElementoCatalogoService.insertar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository, atLeast(1)).save(Mockito.<TipoElementoCatalogo>any());
        List<AtributoEjePorTipoElemento> expectedAtributosAsociados = actualInsertarResult.getAtributosAsociados();
        assertEquals(expectedAtributosAsociados, tipoElementoCat.getAtributosAsociados());
        assertSame(tipoElementoCatalogo, actualInsertarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#insertar(TipoElementoCatalogo)}
     */
    @Test
    void testInsertar2() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo);

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(atributosAsociados);
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualInsertarResult = tipoElementoCatalogoService.insertar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository, atLeast(1)).save(Mockito.<TipoElementoCatalogo>any());
        assertEquals(atributosAsociados, tipoElementoCat.getAtributosAsociados());
        assertSame(tipoElementoCatalogo, actualInsertarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#insertar(TipoElementoCatalogo)}
     */
    @Test
    void testInsertar3() {
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any()))
                .thenThrow(new IllegalArgumentException("foo"));

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.insertar(tipoElementoCat));
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        tipoElementoCatalogo2.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualActualizarResult = tipoElementoCatalogoService.actualizar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertEquals(1, actualActualizarResult.getHierarchyLevel().intValue());
        assertEquals(atributosAsociados, actualActualizarResult.getAtributosAsociados());
        assertSame(tipoElementoCat, actualActualizarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar2() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.actualizar(tipoElementoCat));
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar3() {
        doNothing().when(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados2 = new ArrayList<>();
        tipoElementoCatalogo2.setAtributosAsociados(atributosAsociados2);
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualActualizarResult = tipoElementoCatalogoService.actualizar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertEquals(1, actualActualizarResult.getHierarchyLevel().intValue());
        assertEquals(atributosAsociados2, actualActualizarResult.getAtributosAsociados());
        assertSame(tipoElementoCat, actualActualizarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar4() {
        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        AtributoEjePorTipoElemento atributoEjePorTipoElemento2 = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento2.setAxisAttributeId(1);
        atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento2.setDeleted(1);
        atributoEjePorTipoElemento2.setForCatalogue(1);
        atributoEjePorTipoElemento2.setForDelivery(1);
        atributoEjePorTipoElemento2.setId(1);
        atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados2 = new ArrayList<>();
        atributosAsociados2.add(atributoEjePorTipoElemento2);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(atributosAsociados2);
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualActualizarResult = tipoElementoCatalogoService.actualizar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertEquals(1, actualActualizarResult.getHierarchyLevel().intValue());
        assertEquals(atributosAsociados2, actualActualizarResult.getAtributosAsociados());
        assertSame(tipoElementoCat, actualActualizarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar5() {
        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        AtributoEjePorTipoElemento atributoEjePorTipoElemento2 = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento2.setAxisAttributeId(1);
        atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento2.setDeleted(1);
        atributoEjePorTipoElemento2.setForCatalogue(1);
        atributoEjePorTipoElemento2.setForDelivery(1);
        atributoEjePorTipoElemento2.setId(1);
        atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));

        AtributoEjePorTipoElemento atributoEjePorTipoElemento3 = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento3.setAxisAttributeId(2);
        atributoEjePorTipoElemento3.setCatalogElementTypeId(2);
        atributoEjePorTipoElemento3.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento3.setDeleted(0);
        atributoEjePorTipoElemento3.setForCatalogue(0);
        atributoEjePorTipoElemento3.setForDelivery(0);
        atributoEjePorTipoElemento3.setId(2);
        atributoEjePorTipoElemento3.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados2 = new ArrayList<>();
        atributosAsociados2.add(atributoEjePorTipoElemento3);
        atributosAsociados2.add(atributoEjePorTipoElemento2);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(atributosAsociados2);
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        TipoElementoCatalogo actualActualizarResult = tipoElementoCatalogoService.actualizar(tipoElementoCat);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertEquals(1, actualActualizarResult.getHierarchyLevel().intValue());
        assertEquals(atributosAsociados2, actualActualizarResult.getAtributosAsociados());
        assertSame(tipoElementoCat, actualActualizarResult);
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar6() {
        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(null);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.actualizar(tipoElementoCat));
    }

    /**
     * Method under test:
     * {@link TipoElementoCatalogoService#actualizar(TipoElementoCatalogo)}
     */
    @Test
    void testActualizar7() {
        doThrow(new IllegalArgumentException("foo")).when(atributoEjePorTipoElementoRepository)
                .deleteById(Mockito.<Integer>any());

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);

        TipoElementoCatalogo tipoElementoCat = new TipoElementoCatalogo();
        tipoElementoCat.setAtributosAsociados(new ArrayList<>());
        tipoElementoCat.setCreationDate(mock(Timestamp.class));
        tipoElementoCat.setDeleted(1);
        tipoElementoCat.setHierarchyLevel(1);
        tipoElementoCat.setId(1);
        tipoElementoCat.setName("Name");
        tipoElementoCat.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.actualizar(tipoElementoCat));
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);
        TipoElementoCatalogo actualBorradoLogicoResult = tipoElementoCatalogoService.borradoLogico(1);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertSame(tipoElementoCatalogo2, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico2() {
        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.borradoLogico(1));
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico3() {
        doNothing().when(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);
        TipoElementoCatalogo actualBorradoLogicoResult = tipoElementoCatalogoService.borradoLogico(1);
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
        assertSame(tipoElementoCatalogo2, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link TipoElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico4() {
        doThrow(new IllegalArgumentException("foo")).when(atributoEjePorTipoElementoRepository)
                .deleteById(Mockito.<Integer>any());

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento);

        TipoElementoCatalogo tipoElementoCatalogo = new TipoElementoCatalogo();
        tipoElementoCatalogo.setAtributosAsociados(atributosAsociados);
        tipoElementoCatalogo.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo.setDeleted(1);
        tipoElementoCatalogo.setHierarchyLevel(1);
        tipoElementoCatalogo.setId(1);
        tipoElementoCatalogo.setName("Name");
        tipoElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        TipoElementoCatalogo tipoElementoCatalogo2 = new TipoElementoCatalogo();
        tipoElementoCatalogo2.setAtributosAsociados(new ArrayList<>());
        tipoElementoCatalogo2.setCreationDate(mock(Timestamp.class));
        tipoElementoCatalogo2.setDeleted(1);
        tipoElementoCatalogo2.setHierarchyLevel(1);
        tipoElementoCatalogo2.setId(1);
        tipoElementoCatalogo2.setName("Name");
        tipoElementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(tipoElementoCatalogoRepository.save(Mockito.<TipoElementoCatalogo>any())).thenReturn(tipoElementoCatalogo2);
        when(tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(tipoElementoCatalogo);
        assertThrows(IllegalArgumentException.class, () -> tipoElementoCatalogoService.borradoLogico(1));
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).deleteById(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).save(Mockito.<TipoElementoCatalogo>any());
    }
}
