package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.auxejes.EjeReduced;
import giss.mad.catalogo.model.auxejes.TipoElementoReduced;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.TipoElementoCatalogoRepository;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {AtributoEjeService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class AtributoEjeServiceDiffblueTest {
    @MockBean
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @MockBean
    private AtributoEjeRepository atributoEjeRepository;

    @Autowired
    private AtributoEjeService atributoEjeService;

    @MockBean
    private CacheManager cacheManager;

    @MockBean
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;

    @MockBean
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    @MockBean
    private ValorDominioRepository valorDominioRepository;

    @MockBean
    private ValorDominioService valorDominioService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link AtributoEjeService#setValorDominioCondicionadoRepository(ValorDominioCondicionadoRepository)}
     *   <li>
     * {@link AtributoEjeService#setValorDominioRepository(ValorDominioRepository)}
     *   <li>{@link AtributoEjeService#setValorDominioService(ValorDominioService)}
     *   <li>
     * {@link AtributoEjeService#setAtributoEjePorTipoElementoRepository(AtributoEjePorTipoElementoRepository)}
     *   <li>
     * {@link AtributoEjeService#setAtributoEjeRepository(AtributoEjeRepository)}
     *   <li>
     * {@link AtributoEjeService#setTipoElementoCatalogoRepository(TipoElementoCatalogoRepository)}
     * </ul>
     */
    @Test
    void testSetValorDominioCondicionadoRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     AtributoEjeService.atributoEjePorTipoElementoRepository
        //     AtributoEjeService.atributoEjeRepository
        //     AtributoEjeService.cacheManager
        //     AtributoEjeService.pageable
        //     AtributoEjeService.tipoElementoCatalogoRepository
        //     AtributoEjeService.valorDominioCondicionadoRepository
        //     AtributoEjeService.valorDominioRepository
        //     AtributoEjeService.valorDominioService

        AtributoEjeService atributoEjeService = new AtributoEjeService();
        atributoEjeService.setValorDominioCondicionadoRepository(mock(ValorDominioCondicionadoRepository.class));
        atributoEjeService.setValorDominioRepository(mock(ValorDominioRepository.class));
        atributoEjeService.setValorDominioService(new ValorDominioService());
        atributoEjeService.setAtributoEjePorTipoElementoRepository(mock(AtributoEjePorTipoElementoRepository.class));
        atributoEjeService.setAtributoEjeRepository(mock(AtributoEjeRepository.class));
        atributoEjeService.setTipoElementoCatalogoRepository(mock(TipoElementoCatalogoRepository.class));
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager() {
        when(atributoEjeRepository.findAllAttributesIds()).thenReturn(new ArrayList<>());
        when(tipoElementoCatalogoRepository.findAllTypes()).thenReturn(new ArrayList<>());
        atributoEjeService.setCacheManager(cacheManager);
        verify(atributoEjeRepository).findAllAttributesIds();
        verify(tipoElementoCatalogoRepository).findAllTypes();
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager2() {
        when(tipoElementoCatalogoRepository.findAllTypes()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.setCacheManager(cacheManager));
        verify(tipoElementoCatalogoRepository).findAllTypes();
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager3() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(atributoEjeRepository.findAllAttributesIds()).thenReturn(integerList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(tipoElementoCatalogoRepository.findAllTypes()).thenReturn(new ArrayList<>());
        atributoEjeService.setCacheManager(cacheManager);
        verify(atributoEjeRepository).findAllAttributesIds();
        verify(atributoEjeRepository, atLeast(1)).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).findAllTypes();
        verify(cacheManager, atLeast(1)).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager4() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        when(atributoEjeRepository.findAllAttributesIds()).thenReturn(integerList);
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        when(tipoElementoCatalogoRepository.findAllTypes()).thenReturn(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> atributoEjeService.setCacheManager(cacheManager));
        verify(atributoEjeRepository).findAllAttributesIds();
        verify(tipoElementoCatalogoRepository).findAllTypes();
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager5() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(atributoEjeRepository.findAllAttributesIds()).thenReturn(integerList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(tipoElementoCatalogoRepository.findAllTypes()).thenReturn(new ArrayList<>());
        atributoEjeService.setCacheManager(cacheManager);
        verify(atributoEjeRepository).findAllAttributesIds();
        verify(atributoEjeRepository, atLeast(1)).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).findAllTypes();
        verify(cacheManager, atLeast(1)).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager6() {
        ArrayList<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        when(atributoEjeRepository.findAllAttributesIds()).thenReturn(integerList);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        when(tipoElementoCatalogoRepository.findAllTypes()).thenReturn(new ArrayList<>());

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(valorDominioService.buscarEnCache(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEje);
        atributoEjeService.setCacheManager(cacheManager);
        verify(atributoEjeRepository).findAllAttributesIds();
        verify(tipoElementoCatalogoRepository).findAllTypes();
        verify(valorDominioService, atLeast(1)).buscarEnCache(Mockito.<Integer>any(), anyBoolean());
        verify(cacheManager, atLeast(1)).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllActive()}
     */
    @Test
    void testGetAllActive() {
        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        when(atributoEjeRepository.findAllActive()).thenReturn(atributoEjeList);
        List<AtributoEje> actualAllActive = atributoEjeService.getAllActive();
        verify(atributoEjeRepository).findAllActive();
        assertTrue(actualAllActive.isEmpty());
        assertSame(atributoEjeList, actualAllActive);
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllActive()}
     */
    @Test
    void testGetAllActive2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findAllActive()).thenReturn(atributoEjeList);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllActive = atributoEjeService.getAllActive();
        verify(atributoEjeRepository).findAllActive();
        verify(valorDominioService).getByAttributeId(Mockito.<Integer>any());
        assertEquals(1, actualAllActive.size());
        assertSame(atributoEjeList, actualAllActive);
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllActive()}
     */
    @Test
    void testGetAllActive3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(0);
        atributoEje2.setAplicaAReleases(0);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(0);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("Default Value");
        atributoEje2.setDeleted(0);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(0);
        atributoEje2.setHelp("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(0);
        atributoEje2.setMandatory(0);
        atributoEje2.setMultiple(0);
        atributoEje2.setName("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setObservations("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setReadOnly(0);
        atributoEje2.setRegex("Regex");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findAllActive()).thenReturn(atributoEjeList);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllActive = atributoEjeService.getAllActive();
        verify(atributoEjeRepository).findAllActive();
        verify(valorDominioService, atLeast(1)).getByAttributeId(Mockito.<Integer>any());
        assertEquals(2, actualAllActive.size());
        assertSame(atributoEjeList, actualAllActive);
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllActive()}
     */
    @Test
    void testGetAllActive4() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findAllActive()).thenReturn(atributoEjeList);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getAllActive());
        verify(atributoEjeRepository).findAllActive();
        verify(valorDominioService).getByAttributeId(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllWithHistoric()}
     */
    @Test
    void testGetAllWithHistoric() {
        when(atributoEjeRepository.findAllWithoutDomainValues(Mockito.<Pageable>any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        List<AtributoEje> actualAllWithHistoric = atributoEjeService.getAllWithHistoric();
        verify(atributoEjeRepository).findAllWithoutDomainValues(Mockito.<Pageable>any());
        assertTrue(actualAllWithHistoric.isEmpty());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllWithHistoric()}
     */
    @Test
    void testGetAllWithHistoric2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> content = new ArrayList<>();
        content.add(atributoEje);
        PageImpl<AtributoEje> pageImpl = new PageImpl<>(content);
        when(atributoEjeRepository.findAllWithoutDomainValues(Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllWithHistoric = atributoEjeService.getAllWithHistoric();
        verify(atributoEjeRepository).findAllWithoutDomainValues(Mockito.<Pageable>any());
        verify(valorDominioService).getByAttributeId(Mockito.<Integer>any());
        assertEquals(1, actualAllWithHistoric.size());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllWithHistoric()}
     */
    @Test
    void testGetAllWithHistoric3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(0);
        atributoEje2.setAplicaAReleases(0);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(0);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("Default Value");
        atributoEje2.setDeleted(0);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(0);
        atributoEje2.setHelp("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(0);
        atributoEje2.setMandatory(0);
        atributoEje2.setMultiple(0);
        atributoEje2.setName("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setObservations("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setReadOnly(0);
        atributoEje2.setRegex("Regex");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> content = new ArrayList<>();
        content.add(atributoEje2);
        content.add(atributoEje);
        PageImpl<AtributoEje> pageImpl = new PageImpl<>(content);
        when(atributoEjeRepository.findAllWithoutDomainValues(Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllWithHistoric = atributoEjeService.getAllWithHistoric();
        verify(atributoEjeRepository).findAllWithoutDomainValues(Mockito.<Pageable>any());
        verify(valorDominioService, atLeast(1)).getByAttributeId(Mockito.<Integer>any());
        assertEquals(2, actualAllWithHistoric.size());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAllWithHistoric()}
     */
    @Test
    void testGetAllWithHistoric4() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> content = new ArrayList<>();
        content.add(atributoEje);
        PageImpl<AtributoEje> pageImpl = new PageImpl<>(content);
        when(atributoEjeRepository.findAllWithoutDomainValues(Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(valorDominioService.getByAttributeId(Mockito.<Integer>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getAllWithHistoric());
        verify(atributoEjeRepository).findAllWithoutDomainValues(Mockito.<Pageable>any());
        verify(valorDominioService).getByAttributeId(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllAttributesByTypeElement(Integer, boolean)}
     */
    @Test
    void testGetAllAttributesByTypeElement() {
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllAttributesByTypeElement = atributoEjeService.getAllAttributesByTypeElement(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllAttributesByTypeElement.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllAttributesByTypeElement(Integer, boolean)}
     */
    @Test
    void testGetAllAttributesByTypeElement2() {
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getAllAttributesByTypeElement(1, true));
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllAttributesByTypeElement(Integer, boolean)}
     */
    @Test
    void testGetAllAttributesByTypeElement3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllAttributesByTypeElement = atributoEjeService.getAllAttributesByTypeElement(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllAttributesByTypeElement.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllAttributesByTypeElement(Integer, boolean)}
     */
    @Test
    void testGetAllAttributesByTypeElement4() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(42);
        atributoEje2.setAplicaAReleases(42);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(42);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("Default Value");
        atributoEje2.setDeleted(42);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(42);
        atributoEje2.setHelp("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(42);
        atributoEje2.setMandatory(42);
        atributoEje2.setMultiple(42);
        atributoEje2.setName("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setObservations("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setReadOnly(42);
        atributoEje2.setRegex("Regex");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllAttributesByTypeElement = atributoEjeService.getAllAttributesByTypeElement(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllAttributesByTypeElement.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllAttributesByTypeElement(Integer, boolean)}
     */
    @Test
    void testGetAllAttributesByTypeElement5() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(0);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllAttributesByTypeElement = atributoEjeService.getAllAttributesByTypeElement(1, true);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertEquals(1, actualAllAttributesByTypeElement.size());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById() {
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<String> actualAxisNamesOrderedById = atributoEjeService.getAxisNamesOrderedById();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertTrue(actualAxisNamesOrderedById.isEmpty());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<String> actualAxisNamesOrderedById = atributoEjeService.getAxisNamesOrderedById();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualAxisNamesOrderedById.size());
        assertEquals("id", actualAxisNamesOrderedById.get(0));
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(2);
        atributoEje2.setAplicaAReleases(2);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(2);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("id");
        atributoEje2.setDeleted(2);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(2);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(2);
        atributoEje2.setMandatory(2);
        atributoEje2.setMultiple(2);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(2);
        atributoEje2.setRegex("id");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<String> actualAxisNamesOrderedById = atributoEjeService.getAxisNamesOrderedById();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualAxisNamesOrderedById.size());
        assertEquals("id", actualAxisNamesOrderedById.get(0));
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById4() {
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenThrow(new RuntimeException("id"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getAxisNamesOrderedById());
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById5() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("id");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("id");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues = new ArrayList<>();
        domainValues.add(valorDominio);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(domainValues);
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<String> actualAxisNamesOrderedById = atributoEjeService.getAxisNamesOrderedById();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualAxisNamesOrderedById.size());
        assertEquals("id", actualAxisNamesOrderedById.get(0));
    }

    /**
     * Method under test: {@link AtributoEjeService#getAxisNamesOrderedById()}
     */
    @Test
    void testGetAxisNamesOrderedById6() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(2);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(2);
        atributoEje2.setAplicaAReleases(2);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(2);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("id");
        atributoEje2.setDeleted(2);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(2);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(2);
        atributoEje2.setMandatory(2);
        atributoEje2.setMultiple(2);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(2);
        atributoEje2.setRegex("id");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<String> actualAxisNamesOrderedById = atributoEjeService.getAxisNamesOrderedById();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(2, actualAxisNamesOrderedById.size());
        assertEquals("", actualAxisNamesOrderedById.get(0));
        assertEquals("Name", actualAxisNamesOrderedById.get(1));
    }

    /**
     * Method under test: {@link AtributoEjeService#getEjesReduced()}
     */
    @Test
    void testGetEjesReduced() {
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<EjeReduced> actualEjesReduced = atributoEjeService.getEjesReduced();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertTrue(actualEjesReduced.isEmpty());
    }

    /**
     * Method under test: {@link AtributoEjeService#getEjesReduced()}
     */
    @Test
    void testGetEjesReduced2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<EjeReduced> actualEjesReduced = atributoEjeService.getEjesReduced();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualEjesReduced.size());
        EjeReduced getResult = actualEjesReduced.get(0);
        assertEquals("id", getResult.getEje());
        assertEquals(1, getResult.getNum().intValue());
    }

    /**
     * Method under test: {@link AtributoEjeService#getEjesReduced()}
     */
    @Test
    void testGetEjesReduced3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(0);
        atributoEje2.setAplicaAReleases(0);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(0);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("id");
        atributoEje2.setDeleted(0);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(0);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(0);
        atributoEje2.setMandatory(0);
        atributoEje2.setMultiple(0);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(0);
        atributoEje2.setRegex("id");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<EjeReduced> actualEjesReduced = atributoEjeService.getEjesReduced();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualEjesReduced.size());
        EjeReduced getResult = actualEjesReduced.get(0);
        assertEquals("id", getResult.getEje());
        assertEquals(1, getResult.getNum().intValue());
    }

    /**
     * Method under test: {@link AtributoEjeService#getEjesReduced()}
     */
    @Test
    void testGetEjesReduced4() {
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenThrow(new RuntimeException("id"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getEjesReduced());
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllCachedAtributos(Integer, boolean)}
     */
    @Test
    void testGetAllCachedAtributos() {
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllCachedAtributos = atributoEjeService.getAllCachedAtributos(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllCachedAtributos.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllCachedAtributos(Integer, boolean)}
     */
    @Test
    void testGetAllCachedAtributos2() {
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getAllCachedAtributos(1, true));
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllCachedAtributos(Integer, boolean)}
     */
    @Test
    void testGetAllCachedAtributos3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(-1);
        atributoEje.setAplicaAReleases(-1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(-1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(-1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(-1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(-1);
        atributoEje.setMandatory(-1);
        atributoEje.setMultiple(-1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(-1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllCachedAtributos = atributoEjeService.getAllCachedAtributos(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllCachedAtributos.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllCachedAtributos(Integer, boolean)}
     */
    @Test
    void testGetAllCachedAtributos4() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(-1);
        atributoEje.setAplicaAReleases(-1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(-1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(-1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(-1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(-1);
        atributoEje.setMandatory(-1);
        atributoEje.setMultiple(-1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(-1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("Default Value");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setObservations("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex("Regex");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(-1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllCachedAtributos = atributoEjeService.getAllCachedAtributos(1, true);
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualAllCachedAtributos.isEmpty());
    }

    /**
     * Method under test:
     * {@link AtributoEjeService#getAllCachedAtributos(Integer, boolean)}
     */
    @Test
    void testGetAllCachedAtributos5() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(-1);
        atributoEje.setAplicaAReleases(-1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(-1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(-1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(-1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(-1);
        atributoEje.setMandatory(-1);
        atributoEje.setMultiple(-1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(-1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(0);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(atributoEjePorTipoElementoRepository.getAtributosOrdenadosForDelivery(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<AtributoEje> actualAllCachedAtributos = atributoEjeService.getAllCachedAtributos(1, true);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjePorTipoElementoRepository).getAtributosOrdenadosForDelivery(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertEquals(1, actualAllCachedAtributos.size());
    }

    /**
     * Method under test: {@link AtributoEjeService#getSoloAtributos()}
     */
    @Test
    void testGetSoloAtributos() {
        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<AtributoEje> actualSoloAtributos = atributoEjeService.getSoloAtributos();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertTrue(actualSoloAtributos.isEmpty());
        assertSame(atributoEjeList, actualSoloAtributos);
    }

    /**
     * Method under test: {@link AtributoEjeService#getSoloAtributos()}
     */
    @Test
    void testGetSoloAtributos2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<AtributoEje> actualSoloAtributos = atributoEjeService.getSoloAtributos();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualSoloAtributos.size());
        assertSame(atributoEjeList, actualSoloAtributos);
    }

    /**
     * Method under test: {@link AtributoEjeService#getSoloAtributos()}
     */
    @Test
    void testGetSoloAtributos3() {
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenThrow(new RuntimeException("id"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getSoloAtributos());
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#getSoloAtributos()}
     */
    @Test
    void testGetSoloAtributos4() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("id");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("id");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues = new ArrayList<>();
        domainValues.add(valorDominio);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("id");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(domainValues);
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("id");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("id");
        atributoEje.setObservations("id");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeRepository.findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any()))
                .thenReturn(atributoEjeList);
        List<AtributoEje> actualSoloAtributos = atributoEjeService.getSoloAtributos();
        verify(atributoEjeRepository).findByAxisAndDeletedIsNull(Mockito.<Integer>any(), Mockito.<Sort>any());
        assertEquals(1, actualSoloAtributos.size());
        assertSame(atributoEjeList, actualSoloAtributos);
    }

    /**
     * Method under test: {@link AtributoEjeService#getFromDatabase(Integer)}
     */
    @Test
    void testGetFromDatabase() {
        ArrayList<AtributoEjePorTipoElemento> atributoEjePorTipoElementoList = new ArrayList<>();
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(atributoEjePorTipoElementoList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        AtributoEje actualFromDatabase = atributoEjeService.getFromDatabase(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualFromDatabase.getAplicaACatalogo().intValue());
        assertEquals(1, actualFromDatabase.getAplicaAReleases().intValue());
        assertEquals(atributoEjePorTipoElementoList, actualFromDatabase.getElementypes());
        assertSame(atributoEje, actualFromDatabase);
    }

    /**
     * Method under test: {@link AtributoEjeService#getFromDatabase(Integer)}
     */
    @Test
    void testGetFromDatabase2() {
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(RuntimeException.class, () -> atributoEjeService.getFromDatabase(1));
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#getFromDatabase(Integer)}
     */
    @Test
    void testGetFromDatabase3() {
        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributoEjePorTipoElementoList = new ArrayList<>();
        atributoEjePorTipoElementoList.add(atributoEjePorTipoElemento);
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(atributoEjePorTipoElementoList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributoEje.setAtributosAsociados(atributosAsociados);
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        AtributoEje actualFromDatabase = atributoEjeService.getFromDatabase(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualFromDatabase.getAplicaACatalogo().intValue());
        assertEquals(1, actualFromDatabase.getAplicaAReleases().intValue());
        assertEquals(atributosAsociados, actualFromDatabase.getElementypes());
        assertSame(atributoEje, actualFromDatabase);
    }

    /**
     * Method under test: {@link AtributoEjeService#getFromDatabase(Integer)}
     */
    @Test
    void testGetFromDatabase4() {
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

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

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(atributosAsociados);
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

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
        AtributoEje actualFromDatabase = atributoEjeService.getFromDatabase(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        List<TipoElementoReduced> elementypes = actualFromDatabase.getElementypes();
        assertEquals(1, elementypes.size());
        TipoElementoReduced getResult = elementypes.get(0);
        assertEquals("Name", getResult.getName());
        assertEquals(1, actualFromDatabase.getAplicaACatalogo().intValue());
        assertEquals(1, actualFromDatabase.getAplicaAReleases().intValue());
        assertEquals(1, getResult.getId().intValue());
        assertSame(atributoEje, actualFromDatabase);
    }

    /**
     * Method under test: {@link AtributoEjeService#getFromDatabase(Integer)}
     */
    @Test
    void testGetFromDatabase5() {
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        AtributoEjePorTipoElemento atributoEjePorTipoElemento2 = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento2.setAxisAttributeId(2);
        atributoEjePorTipoElemento2.setCatalogElementTypeId(2);
        atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento2.setDeleted(0);
        atributoEjePorTipoElemento2.setForCatalogue(0);
        atributoEjePorTipoElemento2.setForDelivery(0);
        atributoEjePorTipoElemento2.setId(2);
        atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributosAsociados.add(atributoEjePorTipoElemento2);
        atributosAsociados.add(atributoEjePorTipoElemento);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(atributosAsociados);
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

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
        AtributoEje actualFromDatabase = atributoEjeService.getFromDatabase(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(tipoElementoCatalogoRepository, atLeast(1)).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        List<TipoElementoReduced> elementypes = actualFromDatabase.getElementypes();
        assertEquals(2, elementypes.size());
        TipoElementoReduced getResult = elementypes.get(0);
        assertEquals("Name", getResult.getName());
        TipoElementoReduced getResult2 = elementypes.get(1);
        assertEquals("Name", getResult2.getName());
        assertEquals(1, actualFromDatabase.getAplicaACatalogo().intValue());
        assertEquals(1, actualFromDatabase.getAplicaAReleases().intValue());
        assertEquals(1, getResult2.getId().intValue());
        assertEquals(2, getResult.getId().intValue());
        assertSame(atributoEje, actualFromDatabase);
    }

    /**
     * Method under test: {@link AtributoEjeService#getForDelivery(Integer)}
     */
    @Test
    void testGetForDelivery() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        AtributoEje actualForDelivery = atributoEjeService.getForDelivery(1);
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertSame(atributoEje, actualForDelivery);
    }

    /**
     * Method under test: {@link AtributoEjeService#getForDelivery(Integer)}
     */
    @Test
    void testGetForDelivery2() {
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getForDelivery(1));
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#getForDelivery(Integer)}
     */
    @Test
    void testGetForDelivery3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(valorDominioService.buscarEnCache(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEje);
        AtributoEje actualForDelivery = atributoEjeService.getForDelivery(1);
        verify(valorDominioService).buscarEnCache(Mockito.<Integer>any(), anyBoolean());
        verify(cacheManager).getCacheNames();
        assertSame(atributoEje, actualForDelivery);
    }

    /**
     * Method under test: {@link AtributoEjeService#getForCatalogue(Integer)}
     */
    @Test
    void testGetForCatalogue() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        AtributoEje actualForCatalogue = atributoEjeService.getForCatalogue(1);
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertSame(atributoEje, actualForCatalogue);
    }

    /**
     * Method under test: {@link AtributoEjeService#getForCatalogue(Integer)}
     */
    @Test
    void testGetForCatalogue2() {
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.getForCatalogue(1));
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link AtributoEjeService#getForCatalogue(Integer)}
     */
    @Test
    void testGetForCatalogue3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(valorDominioService.buscarEnCache(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEje);
        AtributoEje actualForCatalogue = atributoEjeService.getForCatalogue(1);
        verify(valorDominioService).buscarEnCache(Mockito.<Integer>any(), anyBoolean());
        verify(cacheManager).getCacheNames();
        assertSame(atributoEje, actualForCatalogue);
    }

    /**
     * Method under test: {@link AtributoEjeService#insertar(AtributoEje)}
     */
    @Test
    void testInsertar() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributoEje.setAtributosAsociados(atributosAsociados);
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        AtributoEje attr = new AtributoEje();
        attr.setAplicaACatalogo(1);
        attr.setAplicaAReleases(1);
        attr.setAtributosAsociados(new ArrayList<>());
        attr.setAxis(1);
        attr.setAxisAttributeCollateralId(1);
        attr.setCode("Code");
        attr.setCreationDate(mock(Timestamp.class));
        attr.setDefaultValue("42");
        attr.setDeleted(1);
        attr.setDomainValues(new ArrayList<>());
        attr.setElementypes(new ArrayList<>());
        attr.setFromCapp(1);
        attr.setHelp("Help");
        attr.setHidden(1);
        attr.setId(1);
        attr.setLongDescription(1);
        attr.setMandatory(1);
        attr.setMultiple(1);
        attr.setName("Name");
        attr.setObservations("Observations");
        attr.setReadOnly(1);
        attr.setRegex(".*");
        attr.setUpdateDate(mock(Timestamp.class));
        attr.setValuesInDomain(42);
        AtributoEje actualInsertarResult = atributoEjeService.insertar(attr);
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository, atLeast(1)).save(Mockito.<AtributoEje>any());
        assertEquals(atributosAsociados, actualInsertarResult.getAtributosAsociados());
        assertEquals(atributosAsociados, actualInsertarResult.getDomainValues());
        assertEquals(atributosAsociados, actualInsertarResult.getElementypes());
        assertSame(atributoEje, actualInsertarResult);
    }

    /**
     * Method under test: {@link AtributoEjeService#insertar(AtributoEje)}
     */
    @Test
    void testInsertar2() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));

        AtributoEje attr = new AtributoEje();
        attr.setAplicaACatalogo(1);
        attr.setAplicaAReleases(1);
        attr.setAtributosAsociados(new ArrayList<>());
        attr.setAxis(1);
        attr.setAxisAttributeCollateralId(1);
        attr.setCode("Code");
        attr.setCreationDate(mock(Timestamp.class));
        attr.setDefaultValue("42");
        attr.setDeleted(1);
        attr.setDomainValues(new ArrayList<>());
        attr.setElementypes(new ArrayList<>());
        attr.setFromCapp(1);
        attr.setHelp("Help");
        attr.setHidden(1);
        attr.setId(1);
        attr.setLongDescription(1);
        attr.setMandatory(1);
        attr.setMultiple(1);
        attr.setName("Name");
        attr.setObservations("Observations");
        attr.setReadOnly(1);
        attr.setRegex(".*");
        attr.setUpdateDate(mock(Timestamp.class));
        attr.setValuesInDomain(42);
        assertThrows(RuntimeException.class, () -> atributoEjeService.insertar(attr));
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository, atLeast(1)).save(Mockito.<AtributoEje>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#insertar(AtributoEje)}
     */
    @Test
    void testInsertar3() {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributoEje.setAtributosAsociados(atributosAsociados);
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje);

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        AtributoEje attr = new AtributoEje();
        attr.setAplicaACatalogo(1);
        attr.setAplicaAReleases(1);
        attr.setAtributosAsociados(new ArrayList<>());
        attr.setAxis(1);
        attr.setAxisAttributeCollateralId(1);
        attr.setCode("Code");
        attr.setCreationDate(mock(Timestamp.class));
        attr.setDefaultValue("42");
        attr.setDeleted(1);
        attr.setDomainValues(new ArrayList<>());
        attr.setElementypes(new ArrayList<>());
        attr.setFromCapp(1);
        attr.setHelp("Help");
        attr.setHidden(1);
        attr.setId(1);
        attr.setLongDescription(1);
        attr.setMandatory(1);
        attr.setMultiple(1);
        attr.setName("Name");
        attr.setObservations("Observations");
        attr.setReadOnly(1);
        attr.setRegex(".*");
        attr.setUpdateDate(mock(Timestamp.class));
        attr.setValuesInDomain(42);
        AtributoEje actualInsertarResult = atributoEjeService.insertar(attr);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository, atLeast(1)).save(Mockito.<AtributoEje>any());
        assertEquals(atributosAsociados, actualInsertarResult.getAtributosAsociados());
        assertEquals(atributosAsociados, actualInsertarResult.getDomainValues());
        assertEquals(atributosAsociados, actualInsertarResult.getElementypes());
        assertSame(atributoEje, actualInsertarResult);
    }

    /**
     * Method under test: {@link AtributoEjeService#actualizar(AtributoEje)}
     */
    @Test
    void testActualizar() throws RuntimeException {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        ArrayList<AtributoEjePorTipoElemento> atributosAsociados = new ArrayList<>();
        atributoEje2.setAtributosAsociados(atributosAsociados);
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

        AtributoEje attr = new AtributoEje();
        attr.setAplicaACatalogo(1);
        attr.setAplicaAReleases(1);
        attr.setAtributosAsociados(new ArrayList<>());
        attr.setAxis(1);
        attr.setAxisAttributeCollateralId(1);
        attr.setCode("Code");
        attr.setCreationDate(mock(Timestamp.class));
        attr.setDefaultValue("42");
        attr.setDeleted(1);
        attr.setDomainValues(new ArrayList<>());
        attr.setElementypes(new ArrayList<>());
        attr.setFromCapp(1);
        attr.setHelp("Help");
        attr.setHidden(1);
        attr.setId(1);
        attr.setLongDescription(1);
        attr.setMandatory(1);
        attr.setMultiple(1);
        attr.setName("Name");
        attr.setObservations("Observations");
        attr.setReadOnly(1);
        attr.setRegex(".*");
        attr.setUpdateDate(mock(Timestamp.class));
        attr.setValuesInDomain(42);
        AtributoEje actualActualizarResult = atributoEjeService.actualizar(attr);
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        verify(atributoEjeRepository, atLeast(1)).save(Mockito.<AtributoEje>any());
        assertEquals(1, actualActualizarResult.getDeleted().intValue());
        assertEquals(atributosAsociados, actualActualizarResult.getDomainValues());
        assertSame(attr, actualActualizarResult);
    }

    /**
     * Method under test: {@link AtributoEjeService#actualizar(AtributoEje)}
     */
    @Test
    void testActualizar2() throws RuntimeException {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));

        AtributoEje attr = new AtributoEje();
        attr.setAplicaACatalogo(1);
        attr.setAplicaAReleases(1);
        attr.setAtributosAsociados(new ArrayList<>());
        attr.setAxis(1);
        attr.setAxisAttributeCollateralId(1);
        attr.setCode("Code");
        attr.setCreationDate(mock(Timestamp.class));
        attr.setDefaultValue("42");
        attr.setDeleted(1);
        attr.setDomainValues(new ArrayList<>());
        attr.setElementypes(new ArrayList<>());
        attr.setFromCapp(1);
        attr.setHelp("Help");
        attr.setHidden(1);
        attr.setId(1);
        attr.setLongDescription(1);
        attr.setMandatory(1);
        attr.setMultiple(1);
        attr.setName("Name");
        attr.setObservations("Observations");
        attr.setReadOnly(1);
        attr.setRegex(".*");
        attr.setUpdateDate(mock(Timestamp.class));
        attr.setValuesInDomain(42);
        assertThrows(RuntimeException.class, () -> atributoEjeService.actualizar(attr));
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        verify(atributoEjeRepository).save(Mockito.<AtributoEje>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico() {
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        AtributoEje actualBorradoLogicoResult = atributoEjeService.borradoLogico(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).save(Mockito.<AtributoEje>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(atributoEje, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link AtributoEjeService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico2() {
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> atributoEjeService.borradoLogico(1));
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).save(Mockito.<AtributoEje>any());
    }

    /**
     * Method under test: {@link AtributoEjeService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico3() {
        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributoEjePorTipoElementoList = new ArrayList<>();
        atributoEjePorTipoElementoList.add(atributoEjePorTipoElemento);
        doNothing().when(atributoEjePorTipoElementoRepository).delete(Mockito.<AtributoEjePorTipoElemento>any());
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(atributoEjePorTipoElementoList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        AtributoEje actualBorradoLogicoResult = atributoEjeService.borradoLogico(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjePorTipoElementoRepository).delete(Mockito.<AtributoEjePorTipoElemento>any());
        verify(atributoEjeRepository).save(Mockito.<AtributoEje>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(atributoEje, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link AtributoEjeService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico4() {
        AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento.setAxisAttributeId(1);
        atributoEjePorTipoElemento.setCatalogElementTypeId(1);
        atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento.setDeleted(1);
        atributoEjePorTipoElemento.setForCatalogue(1);
        atributoEjePorTipoElemento.setForDelivery(1);
        atributoEjePorTipoElemento.setId(1);
        atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));

        AtributoEjePorTipoElemento atributoEjePorTipoElemento2 = new AtributoEjePorTipoElemento();
        atributoEjePorTipoElemento2.setAxisAttributeId(2);
        atributoEjePorTipoElemento2.setCatalogElementTypeId(2);
        atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
        atributoEjePorTipoElemento2.setDeleted(0);
        atributoEjePorTipoElemento2.setForCatalogue(0);
        atributoEjePorTipoElemento2.setForDelivery(0);
        atributoEjePorTipoElemento2.setId(2);
        atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));

        ArrayList<AtributoEjePorTipoElemento> atributoEjePorTipoElementoList = new ArrayList<>();
        atributoEjePorTipoElementoList.add(atributoEjePorTipoElemento2);
        atributoEjePorTipoElementoList.add(atributoEjePorTipoElemento);
        doNothing().when(atributoEjePorTipoElementoRepository).delete(Mockito.<AtributoEjePorTipoElemento>any());
        when(atributoEjePorTipoElementoRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenReturn(atributoEjePorTipoElementoList);

        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("Code");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("Help");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("Code");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("Help");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("Name");
        atributoEje2.setObservations("Observations");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);
        when(atributoEjeRepository.save(Mockito.<AtributoEje>any())).thenReturn(atributoEje2);
        when(atributoEjeRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(atributoEje);
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        AtributoEje actualBorradoLogicoResult = atributoEjeService.borradoLogico(1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjePorTipoElementoRepository, atLeast(1)).delete(Mockito.<AtributoEjePorTipoElemento>any());
        verify(atributoEjeRepository).save(Mockito.<AtributoEje>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(atributoEje, actualBorradoLogicoResult);
    }
}
