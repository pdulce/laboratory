package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.ValorDominioCondicionadoPor;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ValorDominioService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ValorDominioServiceDiffblueTest {
    @MockBean
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @MockBean
    private AtributoEjeRepository atributoEjeRepository;

    @MockBean
    private CacheManager cacheManager;

    @MockBean
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    @MockBean
    private ValorDominioRepository valorDominioRepository;

    @Autowired
    private ValorDominioService valorDominioService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link ValorDominioService#setCacheManager(CacheManager)}
     *   <li>
     * {@link ValorDominioService#setValorDominioCondicionadoRepository(ValorDominioCondicionadoRepository)}
     *   <li>
     * {@link ValorDominioService#setValorDominioRepository(ValorDominioRepository)}
     *   <li>
     * {@link ValorDominioService#setAtributoEjePorTipoElementoRepository(AtributoEjePorTipoElementoRepository)}
     *   <li>
     * {@link ValorDominioService#setAtributoEjeRepository(AtributoEjeRepository)}
     * </ul>
     */
    @Test
    void testSetCacheManager() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ValorDominioService.atributoEjePorTipoElementoRepository
        //     ValorDominioService.atributoEjeRepository
        //     ValorDominioService.cacheManager
        //     ValorDominioService.valorDominioCondicionadoRepository
        //     ValorDominioService.valorDominioRepository

        ValorDominioService valorDominioService = new ValorDominioService();
        valorDominioService.setCacheManager(new ConcurrentMapCacheManager());
        valorDominioService.setValorDominioCondicionadoRepository(mock(ValorDominioCondicionadoRepository.class));
        valorDominioService.setValorDominioRepository(mock(ValorDominioRepository.class));
        valorDominioService.setAtributoEjePorTipoElementoRepository(mock(AtributoEjePorTipoElementoRepository.class));
        valorDominioService.setAtributoEjeRepository(mock(AtributoEjeRepository.class));
    }

    /**
     * Method under test:
     * {@link ValorDominioService#buscarEnCache(Integer, boolean)}
     */
    @Test
    void testBuscarEnCache() {
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        AtributoEje actualBuscarEnCacheResult = valorDominioService.buscarEnCache(1, true);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertTrue(actualBuscarEnCacheResult.getAtributosAsociados().isEmpty());
        assertEquals(atributoEjePorTipoElementoList, actualBuscarEnCacheResult.getDomainValues());
        assertSame(atributoEje, actualBuscarEnCacheResult);
    }

    /**
     * Method under test:
     * {@link ValorDominioService#buscarEnCache(Integer, boolean)}
     */
    @Test
    void testBuscarEnCache2() {
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("atributos-cache"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.buscarEnCache(1, true));
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ValorDominioService#buscarEnCache(Integer, boolean)}
     */
    @Test
    void testBuscarEnCache3() {
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
        atributoEje.setDeleted(null);
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        AtributoEje actualBuscarEnCacheResult = valorDominioService.buscarEnCache(1, true);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertTrue(actualBuscarEnCacheResult.getAtributosAsociados().isEmpty());
        List<ValorDominio> domainValues = actualBuscarEnCacheResult.getDomainValues();
        assertTrue(domainValues.isEmpty());
        assertEquals(atributoEjePorTipoElementoList, domainValues);
        assertSame(atributoEje, actualBuscarEnCacheResult);
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getAllHistoric(Pageable, String)}
     */
    @Test
    void testGetAllHistoric() {
        PageImpl<ValorDominio> pageImpl = new PageImpl<>(new ArrayList<>());
        when(valorDominioRepository.findAllHistoric(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<ValorDominio> actualAllHistoric = valorDominioService.getAllHistoric(null, "Name Filter");
        verify(valorDominioRepository).findAllHistoric(Mockito.<String>any(), Mockito.<Pageable>any());
        assertTrue(actualAllHistoric.toList().isEmpty());
        assertSame(pageImpl, actualAllHistoric);
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getAllHistoric(Pageable, String)}
     */
    @Test
    void testGetAllHistoric2() {
        when(valorDominioRepository.findAllHistoric(Mockito.<String>any(), Mockito.<Pageable>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.getAllHistoric(null, "Name Filter"));
        verify(valorDominioRepository).findAllHistoric(Mockito.<String>any(), Mockito.<Pageable>any());
    }

    /**
     * Method under test: {@link ValorDominioService#getlabelsOrderById()}
     */
    @Test
    void testGetlabelsOrderById() {
        when(valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(new ArrayList<>());
        List<String> actualGetlabelsOrderByIdResult = valorDominioService.getlabelsOrderById();
        verify(valorDominioRepository).findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any());
        assertTrue(actualGetlabelsOrderByIdResult.isEmpty());
    }

    /**
     * Method under test: {@link ValorDominioService#getlabelsOrderById()}
     */
    @Test
    void testGetlabelsOrderById2() {
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

        ArrayList<ValorDominio> valorDominioList = new ArrayList<>();
        valorDominioList.add(valorDominio);
        when(valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(valorDominioList);
        List<String> actualGetlabelsOrderByIdResult = valorDominioService.getlabelsOrderById();
        verify(valorDominioRepository).findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any());
        assertEquals(1, actualGetlabelsOrderByIdResult.size());
        assertEquals("id", actualGetlabelsOrderByIdResult.get(0));
    }

    /**
     * Method under test: {@link ValorDominioService#getlabelsOrderById()}
     */
    @Test
    void testGetlabelsOrderById3() {
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

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(2);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(2);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(2);
        valorDominio2.setForDelivery(2);
        valorDominio2.setId(2);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> valorDominioList = new ArrayList<>();
        valorDominioList.add(valorDominio2);
        valorDominioList.add(valorDominio);
        when(valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(valorDominioList);
        List<String> actualGetlabelsOrderByIdResult = valorDominioService.getlabelsOrderById();
        verify(valorDominioRepository).findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any());
        assertEquals(1, actualGetlabelsOrderByIdResult.size());
        assertEquals("id", actualGetlabelsOrderByIdResult.get(0));
    }

    /**
     * Method under test: {@link ValorDominioService#getlabelsOrderById()}
     */
    @Test
    void testGetlabelsOrderById4() {
        when(valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any()))
                .thenThrow(new IllegalArgumentException("id"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.getlabelsOrderById());
        verify(valorDominioRepository).findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any());
    }

    /**
     * Method under test: {@link ValorDominioService#getlabelsOrderById()}
     */
    @Test
    void testGetlabelsOrderById5() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("id");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(2);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("id");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(2);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(2);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(2);
        valorDominio2.setForDelivery(2);
        valorDominio2.setId(2);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> valorDominioList = new ArrayList<>();
        valorDominioList.add(valorDominio2);
        valorDominioList.add(valorDominio);
        when(valorDominioRepository.findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any()))
                .thenReturn(valorDominioList);
        List<String> actualGetlabelsOrderByIdResult = valorDominioService.getlabelsOrderById();
        verify(valorDominioRepository).findAllByNameIsNotNullAndDeletedIsNull(Mockito.<Sort>any());
        assertEquals(2, actualGetlabelsOrderByIdResult.size());
        assertEquals("", actualGetlabelsOrderByIdResult.get(0));
        assertEquals("Name", actualGetlabelsOrderByIdResult.get(1));
    }

    /**
     * Method under test: {@link ValorDominioService#get(Integer)}
     */
    @Test
    void testGet() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.findByIdAndNameIsNotNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        ValorDominio actualGetResult = valorDominioService.get(1);
        verify(valorDominioRepository).findByIdAndNameIsNotNull(Mockito.<Integer>any());
        assertSame(valorDominio, actualGetResult);
    }

    /**
     * Method under test: {@link ValorDominioService#get(Integer)}
     */
    @Test
    void testGet2() {
        when(valorDominioRepository.findByIdAndNameIsNotNull(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.get(1));
        verify(valorDominioRepository).findByIdAndNameIsNotNull(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ValorDominioService#getByAttributeId(Integer)}
     */
    @Test
    void testGetByAttributeId() {
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
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<ValorDominio> actualByAttributeId = valorDominioService.getByAttributeId(1);
        verify(atributoEjePorTipoElementoRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(atributoEjeRepository, atLeast(1)).findById(Mockito.<Integer>any());
        assertTrue(actualByAttributeId.isEmpty());
    }

    /**
     * Method under test: {@link ValorDominioService#getByAttributeId(Integer)}
     */
    @Test
    void testGetByAttributeId2() {
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("atributos-cache"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.getByAttributeId(1));
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ValorDominioService#getByAttributeId(Integer)}
     */
    @Test
    void testGetByAttributeId3() {
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
        atributoEje.setDeleted(null);
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        List<ValorDominio> actualByAttributeId = valorDominioService.getByAttributeId(1);
        verify(atributoEjePorTipoElementoRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository, atLeast(1)).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(atributoEjeRepository, atLeast(1)).findById(Mockito.<Integer>any());
        assertTrue(actualByAttributeId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getDependentsOfAttrCodeAndValueMasterId(Integer, Integer)}
     */
    @Test
    void testGetDependentsOfAttrCodeAndValueMasterId() {
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
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);
        when(atributoEjeRepository.findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        Map<Integer, List<ValorDominio>> actualDependentsOfAttrCodeAndValueMasterId = valorDominioService
                .getDependentsOfAttrCodeAndValueMasterId(1, 1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertTrue(actualDependentsOfAttrCodeAndValueMasterId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getDependentsOfAttrCodeAndValueMasterId(Integer, Integer)}
     */
    @Test
    void testGetDependentsOfAttrCodeAndValueMasterId2() {
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
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("atributos-cache"));
        assertThrows(IllegalArgumentException.class,
                () -> valorDominioService.getDependentsOfAttrCodeAndValueMasterId(1, 1));
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getDependentsOfAttrCodeAndValueMasterId(Integer, Integer)}
     */
    @Test
    void testGetDependentsOfAttrCodeAndValueMasterId3() {
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
        Optional<AtributoEje> ofResult = Optional.of(atributoEje);

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(1);
        atributoEje2.setAplicaAReleases(1);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(1);
        atributoEje2.setAxisAttributeCollateralId(1);
        atributoEje2.setCode("atributos-cache");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("42");
        atributoEje2.setDeleted(1);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(1);
        atributoEje2.setHelp("atributos-cache");
        atributoEje2.setHidden(1);
        atributoEje2.setId(1);
        atributoEje2.setLongDescription(1);
        atributoEje2.setMandatory(1);
        atributoEje2.setMultiple(1);
        atributoEje2.setName("atributos-cache");
        atributoEje2.setObservations("atributos-cache");
        atributoEje2.setReadOnly(1);
        atributoEje2.setRegex(".*");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje2);
        when(atributoEjeRepository.findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(atributoEjeList);
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        Map<Integer, List<ValorDominio>> actualDependentsOfAttrCodeAndValueMasterId = valorDominioService
                .getDependentsOfAttrCodeAndValueMasterId(1, 1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualDependentsOfAttrCodeAndValueMasterId.size());
    }

    /**
     * Method under test:
     * {@link ValorDominioService#getDependentsOfAttrCodeAndValueMasterId(Integer, Integer)}
     */
    @Test
    void testGetDependentsOfAttrCodeAndValueMasterId4() {
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
        atributoEje.setDeleted(null);
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
        when(atributoEjeRepository.findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        when(atributoEjeRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        Map<Integer, List<ValorDominio>> actualDependentsOfAttrCodeAndValueMasterId = valorDominioService
                .getDependentsOfAttrCodeAndValueMasterId(1, 1);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(atributoEjeRepository).findAllByAxisAttributeCollateralIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        assertTrue(actualDependentsOfAttrCodeAndValueMasterId.isEmpty());
    }

    /**
     * Method under test: {@link ValorDominioService#getByName(String)}
     */
    @Test
    void testGetByName() {
        ArrayList<ValorDominio> valorDominioList = new ArrayList<>();
        when(valorDominioRepository.findByName(Mockito.<String>any())).thenReturn(valorDominioList);
        List<ValorDominio> actualByName = valorDominioService.getByName("Name");
        verify(valorDominioRepository).findByName(Mockito.<String>any());
        assertTrue(actualByName.isEmpty());
        assertSame(valorDominioList, actualByName);
    }

    /**
     * Method under test: {@link ValorDominioService#getByName(String)}
     */
    @Test
    void testGetByName2() {
        when(valorDominioRepository.findByName(Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.getByName("Name"));
        verify(valorDominioRepository).findByName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link ValorDominioService#insertar(ValorDominio)}
     */
    @Test
    void testInsertar() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(valorDominio);

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        Map<ValorDominio, List<ValidationErrorMessage>> actualInsertarResult = valorDominioService.insertar(valorDominio2);
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
        assertEquals(1, actualInsertarResult.size());
    }

    /**
     * Method under test: {@link ValorDominioService#insertar(ValorDominio)}
     */
    @Test
    void testInsertar2() {
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenThrow(new IllegalArgumentException("foo"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.insertar(valorDominio));
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
    }

    /**
     * Method under test: {@link ValorDominioService#actualizar(ValorDominio)}
     */
    @Test
    void testActualizar() {
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
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        Optional<ValorDominio> ofResult2 = Optional.of(valorDominio2);

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio3);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        ValorDominio valorDominio4 = new ValorDominio();
        valorDominio4.setAttributeName("Attribute Name");
        valorDominio4.setAxisAttributeId(1);
        valorDominio4.setCreationDate(mock(Timestamp.class));
        valorDominio4.setDeleted(1);
        valorDominio4.setDeliveryDomainValues(new ArrayList<>());
        valorDominio4.setElementDomainValues(new ArrayList<>());
        valorDominio4.setForCatalogue(1);
        valorDominio4.setForDelivery(1);
        valorDominio4.setId(1);
        valorDominio4.setMasterDomainValues(new ArrayList<>());
        valorDominio4.setName("Name");
        valorDominio4.setUpdateDate(mock(Timestamp.class));
        Map<ValorDominio, List<ValidationErrorMessage>> actualActualizarResult = valorDominioService
                .actualizar(valorDominio4);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals("(Code) Name", valorDominio4.getAttributeName());
        assertEquals(1, actualActualizarResult.size());
        List<ValorDominioCondicionadoPor> masterDomainValues = valorDominio4.getMasterDomainValues();
        assertTrue(masterDomainValues.isEmpty());
        assertEquals(atributoEjePorTipoElementoList, masterDomainValues);
    }

    /**
     * Method under test: {@link ValorDominioService#actualizar(ValorDominio)}
     */
    @Test
    void testActualizar2() {
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

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        Optional<ValorDominio> ofResult2 = Optional.of(valorDominio2);
        when(valorDominioRepository.save(Mockito.<ValorDominio>any()))
                .thenThrow(new IllegalArgumentException("atributos-cache"));
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.actualizar(valorDominio3));
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
        verify(valorDominioRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
    }

    /**
     * Method under test: {@link ValorDominioService#actualizar(ValorDominio)}
     */
    @Test
    void testActualizar3() {
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
        atributoEje.setDeleted(null);
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
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        Optional<ValorDominio> ofResult2 = Optional.of(valorDominio2);

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio3);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        ValorDominio valorDominio4 = new ValorDominio();
        valorDominio4.setAttributeName("Attribute Name");
        valorDominio4.setAxisAttributeId(1);
        valorDominio4.setCreationDate(mock(Timestamp.class));
        valorDominio4.setDeleted(1);
        valorDominio4.setDeliveryDomainValues(new ArrayList<>());
        valorDominio4.setElementDomainValues(new ArrayList<>());
        valorDominio4.setForCatalogue(1);
        valorDominio4.setForDelivery(1);
        valorDominio4.setId(1);
        valorDominio4.setMasterDomainValues(new ArrayList<>());
        valorDominio4.setName("Name");
        valorDominio4.setUpdateDate(mock(Timestamp.class));
        Map<ValorDominio, List<ValidationErrorMessage>> actualActualizarResult = valorDominioService
                .actualizar(valorDominio4);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals("(Code) Name", valorDominio4.getAttributeName());
        assertEquals(1, actualActualizarResult.size());
        List<ValorDominioCondicionadoPor> masterDomainValues = valorDominio4.getMasterDomainValues();
        assertTrue(masterDomainValues.isEmpty());
        assertEquals(atributoEjePorTipoElementoList, masterDomainValues);
    }

    /**
     * Method under test: {@link ValorDominioService#actualizar(ValorDominio)}
     */
    @Test
    void testActualizar4() {
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

        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("atributos-cache");
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        Optional<ValorDominio> ofResult2 = Optional.of(valorDominio2);

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio3);
        when(valorDominioRepository.findAllByAxisAttributeId(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valorDominioRepository.findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(valorDominio);
        when(valorDominioRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult2);

        ValorDominio valorDominio4 = new ValorDominio();
        valorDominio4.setAttributeName("Attribute Name");
        valorDominio4.setAxisAttributeId(1);
        valorDominio4.setCreationDate(mock(Timestamp.class));
        valorDominio4.setDeleted(1);
        valorDominio4.setDeliveryDomainValues(new ArrayList<>());
        valorDominio4.setElementDomainValues(new ArrayList<>());
        valorDominio4.setForCatalogue(1);
        valorDominio4.setForDelivery(1);
        valorDominio4.setId(1);
        valorDominio4.setMasterDomainValues(new ArrayList<>());
        valorDominio4.setName("Name");
        valorDominio4.setUpdateDate(mock(Timestamp.class));
        Map<ValorDominio, List<ValidationErrorMessage>> actualActualizarResult = valorDominioService
                .actualizar(valorDominio4);
        verify(atributoEjePorTipoElementoRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findAllByAxisAttributeId(Mockito.<Integer>any());
        verify(valorDominioRepository).findByAxisAttributeIdAndNameAndDeletedIsNull(Mockito.<Integer>any(),
                Mockito.<String>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(atributoEjeRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).findById(Mockito.<Integer>any());
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals("(Code) Name", valorDominio4.getAttributeName());
        assertEquals(1, actualActualizarResult.size());
        List<ValorDominioCondicionadoPor> masterDomainValues = valorDominio4.getMasterDomainValues();
        assertTrue(masterDomainValues.isEmpty());
        assertEquals(atributoEjePorTipoElementoList, masterDomainValues);
    }

    /**
     * Method under test: {@link ValorDominioService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio2);
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        ValorDominio actualBorradoLogicoResult = valorDominioService.borradoLogico(1);
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(valorDominio, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link ValorDominioService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico2() {
        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenThrow(new IllegalArgumentException("foo"));
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.borradoLogico(1));
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
    }

    /**
     * Method under test: {@link ValorDominioService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio2);
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        ValorDominio actualBorradoLogicoResult = valorDominioService.borradoLogico(1);
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(valorDominio, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link ValorDominioService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("atributos-cache");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("atributos-cache");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominioCondicionadoPor> masterDomainValues = new ArrayList<>();
        masterDomainValues.add(valorDominioCondicionadoPor);

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(masterDomainValues);
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio2);
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        ValorDominio actualBorradoLogicoResult = valorDominioService.borradoLogico(1);
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
        assertEquals(1, actualBorradoLogicoResult.getDeleted().intValue());
        assertSame(valorDominio, actualBorradoLogicoResult);
    }

    /**
     * Method under test: {@link ValorDominioService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico5() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalArgumentException("atributos-cache"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioRepository.save(Mockito.<ValorDominio>any())).thenReturn(valorDominio2);
        when(valorDominioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(valorDominio);
        assertThrows(IllegalArgumentException.class, () -> valorDominioService.borradoLogico(1));
        verify(valorDominioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(valorDominioRepository).save(Mockito.<ValorDominio>any());
    }
}
