package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.model.filters.UnidadOrganizativaMinimal;
import giss.mad.catalogo.repository.ElementoCatalogoRepository;
import giss.mad.catalogo.repository.EntregaElementoCatalogoRepository;
import giss.mad.catalogo.repository.GrupoRepository;

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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {GrupoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class GrupoServiceMockitoTestOneFail {
    @MockBean
    private CacheManager cacheManager;

    @MockBean
    private ElementoCatalogoRepository elementoCatalogoRepository;

    @MockBean
    private EntregaElementoCatalogoRepository entregaElementoCatalogoRepository;

    @MockBean
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoService grupoService;

    /**
     * Method under test: {@link GrupoService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager() {
        when(grupoRepository.findAllActiveGroups()).thenReturn(new ArrayList<>());
        grupoService.setCacheManager(cacheManager);
        verify(grupoRepository).findAllActiveGroups();
        assertSame(cacheManager, grupoService.getCacheManager());
    }

    /**
     * Method under test: {@link GrupoService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager2() {
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));

        ArrayList<Grupo> grupoList = new ArrayList<>();
        grupoList.add(grupo);
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(grupoRepository.findAllActiveGroups()).thenReturn(grupoList);
        grupoService.setCacheManager(cacheManager);
        verify(grupoRepository).findAllActiveGroups();
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        assertSame(cacheManager, grupoService.getCacheManager());
    }

    /**
     * Method under test: {@link GrupoService#setCacheManager(CacheManager)}
     */
    @Test
    void testSetCacheManager3() {
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));

        ArrayList<Grupo> grupoList = new ArrayList<>();
        grupoList.add(grupo);
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("gruposorg-cache"));
        when(grupoRepository.findAllActiveGroups()).thenReturn(grupoList);
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        assertThrows(IllegalArgumentException.class, () -> grupoService.setCacheManager(cacheManager));
        verify(grupoRepository).findAllActiveGroups();
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link GrupoService#setGrupoRepository(GrupoRepository)}
     *   <li>
     * {@link GrupoService#setElementoCatalogoRepository(ElementoCatalogoRepository)}
     *   <li>
     * {@link GrupoService#setEntregaElementoCatalogoRepository(EntregaElementoCatalogoRepository)}
     *   <li>{@link GrupoService#getCacheManager()}
     * </ul>
     */
    @Test
    void testSetGrupoRepository() {
        GrupoService grupoService = new GrupoService();
        grupoService.setGrupoRepository(mock(GrupoRepository.class));
        grupoService.setElementoCatalogoRepository(mock(ElementoCatalogoRepository.class));
        grupoService.setEntregaElementoCatalogoRepository(mock(EntregaElementoCatalogoRepository.class));
        assertNull(grupoService.getCacheManager());
    }

    /**
     * Method under test: {@link GrupoService#getByCode(String)}
     */
    @Test
    void testGetByCode() {
        ArrayList<String> stringList = new ArrayList<>();
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        Grupo actualByCode = grupoService.getByCode("Code");
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        assertEquals(stringList, actualByCode.getChildrenIds());
        assertSame(grupo, actualByCode);
    }

    /**
     * Method under test: {@link GrupoService#getByCode(String)}
     */
    @Test
    void testGetByCode2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getByCode("Code"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getByCode(String)}
     */
    @Test
    void testGetByCode3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        Grupo actualByCode = grupoService.getByCode("Code");
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        assertTrue(actualByCode.getChildrenIds().isEmpty());
        assertSame(grupo, actualByCode);
    }

    /**
     * Method under test: {@link GrupoService#getById(Integer)}
     */
    @Test
    void testGetById() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Grupo actualById = grupoService.getById(1);
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertSame(grupo, actualById);
    }

    /**
     * Method under test: {@link GrupoService#getById(Integer)}
     */
    @Test
    void testGetById2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(grupoRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> grupoService.getById(1));
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#getById(Integer)}
     */
    @Test
    void testGetById3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Grupo actualById = grupoService.getById(1);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertSame(grupo, actualById);
    }

    /**
     * Method under test: {@link GrupoService#getGruposIds(Integer)}
     */
    @Test
    void testGetGruposIds() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo2);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getGruposIds(1));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#getAllActiveGroups()}
     */
    @Test
    void testGetAllActiveGroups() {
        ArrayList<Grupo> grupoList = new ArrayList<>();
        when(grupoRepository.findAllActiveGroups()).thenReturn(grupoList);
        List<Grupo> actualAllActiveGroups = grupoService.getAllActiveGroups();
        verify(grupoRepository).findAllActiveGroups();
        assertTrue(actualAllActiveGroups.isEmpty());
        assertSame(grupoList, actualAllActiveGroups);
    }

    /**
     * Method under test: {@link GrupoService#getAllActiveGroups()}
     */
    @Test
    void testGetAllActiveGroups2() {
        when(grupoRepository.findAllActiveGroups()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> grupoService.getAllActiveGroups());
        verify(grupoRepository).findAllActiveGroups();
    }

    /**
     * Method under test: {@link GrupoService#getAll(Pageable)}
     */
    @Test
    void testGetAll() {
        PageImpl<Grupo> pageImpl = new PageImpl<>(new ArrayList<>());
        when(grupoRepository.findAllWithoutChildren(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<Grupo> actualAll = grupoService.getAll(null);
        verify(grupoRepository).findAllWithoutChildren(Mockito.<Pageable>any());
        assertTrue(actualAll.toList().isEmpty());
        assertSame(pageImpl, actualAll);
    }

    /**
     * Method under test: {@link GrupoService#getAll(Pageable)}
     */
    @Test
    void testGetAll2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));

        ArrayList<Grupo> content = new ArrayList<>();
        content.add(grupo);
        PageImpl<Grupo> pageImpl = new PageImpl<>(content);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo2);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(grupoRepository.findAllWithoutChildren(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<Grupo> actualAll = grupoService.getAll(null);
        verify(grupoRepository).findAllWithoutChildren(Mockito.<Pageable>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualAll.toList().size());
        assertSame(pageImpl, actualAll);
    }

    /**
     * Method under test: {@link GrupoService#getAll(Pageable)}
     */
    @Test
    void testGetAll3() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));

        ArrayList<Grupo> content = new ArrayList<>();
        content.add(grupo);
        PageImpl<Grupo> pageImpl = new PageImpl<>(content);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findAllWithoutChildren(Mockito.<Pageable>any())).thenReturn(pageImpl);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getAll(null));
        verify(grupoRepository).findAllWithoutChildren(Mockito.<Pageable>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#getAll(Pageable)}
     */
    @Test
    void testGetAll4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));

        ArrayList<Grupo> content = new ArrayList<>();
        content.add(grupo);
        PageImpl<Grupo> pageImpl = new PageImpl<>(content);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo2);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        when(grupoRepository.findAllWithoutChildren(Mockito.<Pageable>any())).thenReturn(pageImpl);
        Page<Grupo> actualAll = grupoService.getAll(null);
        verify(grupoRepository).findAllWithoutChildren(Mockito.<Pageable>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualAll.toList().size());
        assertSame(pageImpl, actualAll);
    }

    /**
     * Method under test: {@link GrupoService#getByIdWithoutChildren(Integer)}
     */
    @Test
    void testGetByIdWithoutChildren() {
        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getByIdWithoutChildren(Mockito.<Integer>any())).thenReturn(grupo);
        Grupo actualByIdWithoutChildren = grupoService.getByIdWithoutChildren(1);
        verify(grupoRepository).getByIdWithoutChildren(Mockito.<Integer>any());
        assertSame(grupo, actualByIdWithoutChildren);
    }

    /**
     * Method under test: {@link GrupoService#getByIdWithoutChildren(Integer)}
     */
    @Test
    void testGetByIdWithoutChildren2() {
        when(grupoRepository.getByIdWithoutChildren(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> grupoService.getByIdWithoutChildren(1));
        verify(grupoRepository).getByIdWithoutChildren(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#getGruposInferiorByCode(String)}
     */
    @Test
    void testGetGruposInferiorByCode() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getGruposInferiorByCode("Code"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getGruposInferiorByCode(String)}
     */
    @Test
    void testGetGruposInferiorByCode2() {
        assertTrue(grupoService.getGruposInferiorByCode(null).isEmpty());
    }

    /**
     * Method under test: {@link GrupoService#getGrupos(Grupo)}
     */
    @Test
    void testGetGrupos() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);

        Grupo userGroup = new Grupo();
        userGroup.setChildrenIds(new ArrayList<>());
        userGroup.setCodigo("Codigo");
        userGroup.setCreationDate(mock(Timestamp.class));
        userGroup.setDeleted(1);
        userGroup.setId(1);
        userGroup.setName("Name");
        userGroup.setParentGroupId(1);
        userGroup.setParentGroupName("Parent Group Name");
        userGroup.setTipo("Tipo");
        userGroup.setTipoId(1);
        userGroup.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.getGrupos(userGroup));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getHierarchyUntilOrganismo(String)}
     */
    @Test
    void testGetHierarchyUntilOrganismo() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getHierarchyUntilOrganismo("Codigo"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getHierarchyUntilOrganismo(String)}
     */
    @Test
    void testGetHierarchyUntilOrganismo2() {
        assertTrue(grupoService.getHierarchyUntilOrganismo(null).isEmpty());
    }

    /**
     * Method under test: {@link GrupoService#getGruposOfCenter(String)}
     */
    @Test
    void testGetGruposOfCenter() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("*"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getGruposOfCenter("alice.liddell@example.org"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getGruposOfCenter(String)}
     */
    @Test
    void testGetGruposOfCenter2() {
        ArrayList<UnidadOrganizativaMinimal> unidadOrganizativaMinimalList = new ArrayList<>();
        when(grupoRepository.findAllGroups(Mockito.<String>any(), Mockito.<String>any()))
                .thenReturn(unidadOrganizativaMinimalList);
        List<UnidadOrganizativaMinimal> actualGruposOfCenter = grupoService.getGruposOfCenter("*");
        verify(grupoRepository).findAllGroups(Mockito.<String>any(), Mockito.<String>any());
        assertTrue(actualGruposOfCenter.isEmpty());
        assertSame(unidadOrganizativaMinimalList, actualGruposOfCenter);
    }

    /**
     * Method under test: {@link GrupoService#getOrganismo(String)}
     */
    @Test
    void testGetOrganismo() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getOrganismo("alice.liddell@example.org"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getCentroSuperior(String)}
     */
    @Test
    void testGetCentroSuperior() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getCentroSuperior("alice.liddell@example.org"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#getAreaSuperior(String)}
     */
    @Test
    void testGetAreaSuperior() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.getAllChildrenIdsByParent(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findByCodigoAndDeletedIsNull(Mockito.<String>any())).thenReturn(grupo);
        assertThrows(IllegalArgumentException.class, () -> grupoService.getAreaSuperior("alice.liddell@example.org"));
        verify(grupoRepository).findByCodigoAndDeletedIsNull(Mockito.<String>any());
        verify(grupoRepository).getAllChildrenIdsByParent(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
    }

    /**
     * Method under test: {@link GrupoService#alta(Grupo)}
     */
    @Test
    void testAlta() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        Grupo actualAltaResult = grupoService.alta(grupo2);
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo, actualAltaResult);
    }

    /**
     * Method under test: {@link GrupoService#alta(Grupo)}
     */
    @Test
    void testAlta2() {
        when(cacheManager.getCacheNames()).thenThrow(new IllegalArgumentException("foo"));

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.alta(grupo2));
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).save(Mockito.<Grupo>any());
    }

    /**
     * Method under test: {@link GrupoService#alta(Grupo)}
     */
    @Test
    void testAlta3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        Grupo actualAltaResult = grupoService.alta(grupo2);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo, actualAltaResult);
    }

    /**
     * Method under test: {@link GrupoService#alta(Grupo)}
     */
    @Test
    void testAlta4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalArgumentException("gruposorg-cache"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.alta(grupo2));
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).save(Mockito.<Grupo>any());
    }

    /**
     * Method under test: {@link GrupoService#update(Grupo)}
     */
    @Test
    void testUpdate() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo2);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo grupo3 = new Grupo();
        grupo3.setChildrenIds(new ArrayList<>());
        grupo3.setCodigo("Codigo");
        grupo3.setCreationDate(mock(Timestamp.class));
        grupo3.setDeleted(1);
        grupo3.setId(1);
        grupo3.setName("Name");
        grupo3.setParentGroupId(1);
        grupo3.setParentGroupName("Parent Group Name");
        grupo3.setTipo("Tipo");
        grupo3.setTipoId(1);
        grupo3.setUpdateDate(mock(Timestamp.class));
        Grupo actualUpdateResult = grupoService.update(grupo3);
        verify(cacheManager, atLeast(1)).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo2, actualUpdateResult);
    }

    /**
     * Method under test: {@link GrupoService#update(Grupo)}
     */
    @Test
    void testUpdate2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.save(Mockito.<Grupo>any())).thenThrow(new IllegalArgumentException("foo"));
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.update(grupo2));
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        verify(grupoRepository).save(Mockito.<Grupo>any());
    }

    /**
     * Method under test: {@link GrupoService#update(Grupo)}
     */
    @Test
    void testUpdate3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setChildrenIds(new ArrayList<>());
        grupo2.setCodigo("Codigo");
        grupo2.setCreationDate(mock(Timestamp.class));
        grupo2.setDeleted(1);
        grupo2.setId(1);
        grupo2.setName("Name");
        grupo2.setParentGroupId(1);
        grupo2.setParentGroupName("Parent Group Name");
        grupo2.setTipo("Tipo");
        grupo2.setTipoId(1);
        grupo2.setUpdateDate(mock(Timestamp.class));
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo2);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo grupo3 = new Grupo();
        grupo3.setChildrenIds(new ArrayList<>());
        grupo3.setCodigo("Codigo");
        grupo3.setCreationDate(mock(Timestamp.class));
        grupo3.setDeleted(1);
        grupo3.setId(1);
        grupo3.setName("Name");
        grupo3.setParentGroupId(1);
        grupo3.setParentGroupName("Parent Group Name");
        grupo3.setTipo("Tipo");
        grupo3.setTipoId(1);
        grupo3.setUpdateDate(mock(Timestamp.class));
        Grupo actualUpdateResult = grupoService.update(grupo3);
        verify(cacheManager, atLeast(1)).getCache(Mockito.<String>any());
        verify(cacheManager, atLeast(1)).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo2, actualUpdateResult);
    }

    /**
     * Method under test: {@link GrupoService#remove(Integer)}
     */
    @Test
    void testRemove() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(1L);
        when(entregaElementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(1L);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Map<Grupo, List<ValidationErrorMessage>> actualRemoveResult = grupoService.remove(1);
        verify(elementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(entregaElementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualRemoveResult.size());
    }

    /**
     * Method under test: {@link GrupoService#remove(Integer)}
     */
    @Test
    void testRemove2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(1L);
        when(entregaElementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenThrow(
                new IllegalArgumentException("Debe eliminar antes los elementos de catálogo asociados a este grupo"));

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        assertThrows(IllegalArgumentException.class, () -> grupoService.remove(1));
        verify(elementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(entregaElementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#remove(Integer)}
     */
    @Test
    void testRemove3() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("Debe eliminar antes los elementos de catálogo asociados a este grupo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);
        when(elementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(1L);
        when(entregaElementoCatalogoRepository.countByGroupIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(1L);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Map<Grupo, List<ValidationErrorMessage>> actualRemoveResult = grupoService.remove(1);
        verify(elementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(entregaElementoCatalogoRepository).countByGroupIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertEquals(1, actualRemoveResult.size());
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido() {
        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(1);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(1);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        assertTrue(grupoService.estaContenido(candidatoDescendent, grupoSuperior));
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(1);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        boolean actualEstaContenidoResult = grupoService.estaContenido(candidatoDescendent, grupoSuperior);
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertTrue(actualEstaContenidoResult);
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido3() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(grupoRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(1);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.estaContenido(candidatoDescendent, grupoSuperior));
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(1);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        boolean actualEstaContenidoResult = grupoService.estaContenido(candidatoDescendent, grupoSuperior);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertTrue(actualEstaContenidoResult);
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido5() {
        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(null);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(1);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        assertFalse(grupoService.estaContenido(candidatoDescendent, grupoSuperior));
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido6() {
        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(2);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        assertFalse(grupoService.estaContenido(candidatoDescendent, grupoSuperior));
    }

    /**
     * Method under test: {@link GrupoService#estaContenido(Grupo, Grupo)}
     */
    @Test
    void testEstaContenido7() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo candidatoDescendent = new Grupo();
        candidatoDescendent.setChildrenIds(new ArrayList<>());
        candidatoDescendent.setCodigo("Codigo");
        candidatoDescendent.setCreationDate(mock(Timestamp.class));
        candidatoDescendent.setDeleted(1);
        candidatoDescendent.setId(2);
        candidatoDescendent.setName("Name");
        candidatoDescendent.setParentGroupId(1);
        candidatoDescendent.setParentGroupName("Parent Group Name");
        candidatoDescendent.setTipo("Tipo");
        candidatoDescendent.setTipoId(null);
        candidatoDescendent.setUpdateDate(mock(Timestamp.class));

        Grupo grupoSuperior = new Grupo();
        grupoSuperior.setChildrenIds(new ArrayList<>());
        grupoSuperior.setCodigo("Codigo");
        grupoSuperior.setCreationDate(mock(Timestamp.class));
        grupoSuperior.setDeleted(1);
        grupoSuperior.setId(1);
        grupoSuperior.setName("Name");
        grupoSuperior.setParentGroupId(1);
        grupoSuperior.setParentGroupName("Parent Group Name");
        grupoSuperior.setTipo("Tipo");
        grupoSuperior.setTipoId(1);
        grupoSuperior.setUpdateDate(mock(Timestamp.class));
        boolean actualEstaContenidoResult = grupoService.estaContenido(candidatoDescendent, grupoSuperior);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertTrue(actualEstaContenidoResult);
    }

    /**
     * Method under test: {@link GrupoService#searchUnidadSuperior(Grupo, Grupo)}
     */
    @Test
    void testSearchUnidadSuperior() {
        Grupo candidatoHijo = new Grupo();
        candidatoHijo.setChildrenIds(new ArrayList<>());
        candidatoHijo.setCodigo("Codigo");
        candidatoHijo.setCreationDate(mock(Timestamp.class));
        candidatoHijo.setDeleted(1);
        candidatoHijo.setId(1);
        candidatoHijo.setName("Name");
        candidatoHijo.setParentGroupId(1);
        candidatoHijo.setParentGroupName("Parent Group Name");
        candidatoHijo.setTipo("Tipo");
        candidatoHijo.setTipoId(1);
        candidatoHijo.setUpdateDate(mock(Timestamp.class));

        Grupo searched = new Grupo();
        searched.setChildrenIds(new ArrayList<>());
        searched.setCodigo("Codigo");
        searched.setCreationDate(mock(Timestamp.class));
        searched.setDeleted(1);
        searched.setId(1);
        searched.setName("Name");
        searched.setParentGroupId(1);
        searched.setParentGroupName("Parent Group Name");
        searched.setTipo("Tipo");
        searched.setTipoId(1);
        searched.setUpdateDate(mock(Timestamp.class));
        assertTrue(grupoService.searchUnidadSuperior(candidatoHijo, searched));
    }

    /**
     * Method under test: {@link GrupoService#searchUnidadSuperior(Grupo, Grupo)}
     */
    @Test
    void testSearchUnidadSuperior2() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo candidatoHijo = new Grupo();
        candidatoHijo.setChildrenIds(new ArrayList<>());
        candidatoHijo.setCodigo("Codigo");
        candidatoHijo.setCreationDate(mock(Timestamp.class));
        candidatoHijo.setDeleted(1);
        candidatoHijo.setId(2);
        candidatoHijo.setName("Name");
        candidatoHijo.setParentGroupId(1);
        candidatoHijo.setParentGroupName("Parent Group Name");
        candidatoHijo.setTipo("Tipo");
        candidatoHijo.setTipoId(1);
        candidatoHijo.setUpdateDate(mock(Timestamp.class));

        Grupo searched = new Grupo();
        searched.setChildrenIds(new ArrayList<>());
        searched.setCodigo("Codigo");
        searched.setCreationDate(mock(Timestamp.class));
        searched.setDeleted(1);
        searched.setId(1);
        searched.setName("Name");
        searched.setParentGroupId(1);
        searched.setParentGroupName("Parent Group Name");
        searched.setTipo("Tipo");
        searched.setTipoId(1);
        searched.setUpdateDate(mock(Timestamp.class));
        boolean actualSearchUnidadSuperiorResult = grupoService.searchUnidadSuperior(candidatoHijo, searched);
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertTrue(actualSearchUnidadSuperiorResult);
    }

    /**
     * Method under test: {@link GrupoService#searchUnidadSuperior(Grupo, Grupo)}
     */
    @Test
    void testSearchUnidadSuperior3() {
        when(cacheManager.getCacheNames()).thenReturn(new ArrayList<>());
        when(grupoRepository.findById(Mockito.<Integer>any())).thenThrow(new IllegalArgumentException("foo"));

        Grupo candidatoHijo = new Grupo();
        candidatoHijo.setChildrenIds(new ArrayList<>());
        candidatoHijo.setCodigo("Codigo");
        candidatoHijo.setCreationDate(mock(Timestamp.class));
        candidatoHijo.setDeleted(1);
        candidatoHijo.setId(2);
        candidatoHijo.setName("Name");
        candidatoHijo.setParentGroupId(1);
        candidatoHijo.setParentGroupName("Parent Group Name");
        candidatoHijo.setTipo("Tipo");
        candidatoHijo.setTipoId(1);
        candidatoHijo.setUpdateDate(mock(Timestamp.class));

        Grupo searched = new Grupo();
        searched.setChildrenIds(new ArrayList<>());
        searched.setCodigo("Codigo");
        searched.setCreationDate(mock(Timestamp.class));
        searched.setDeleted(1);
        searched.setId(1);
        searched.setName("Name");
        searched.setParentGroupId(1);
        searched.setParentGroupName("Parent Group Name");
        searched.setTipo("Tipo");
        searched.setTipoId(1);
        searched.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class, () -> grupoService.searchUnidadSuperior(candidatoHijo, searched));
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link GrupoService#searchUnidadSuperior(Grupo, Grupo)}
     */
    @Test
    void testSearchUnidadSuperior4() {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("foo");
        when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
        when(cacheManager.getCacheNames()).thenReturn(stringList);

        Grupo grupo = new Grupo();
        grupo.setChildrenIds(new ArrayList<>());
        grupo.setCodigo("Codigo");
        grupo.setCreationDate(mock(Timestamp.class));
        grupo.setDeleted(1);
        grupo.setId(1);
        grupo.setName("Name");
        grupo.setParentGroupId(1);
        grupo.setParentGroupName("Parent Group Name");
        grupo.setTipo("Tipo");
        grupo.setTipoId(1);
        grupo.setUpdateDate(mock(Timestamp.class));
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

        Grupo candidatoHijo = new Grupo();
        candidatoHijo.setChildrenIds(new ArrayList<>());
        candidatoHijo.setCodigo("Codigo");
        candidatoHijo.setCreationDate(mock(Timestamp.class));
        candidatoHijo.setDeleted(1);
        candidatoHijo.setId(2);
        candidatoHijo.setName("Name");
        candidatoHijo.setParentGroupId(1);
        candidatoHijo.setParentGroupName("Parent Group Name");
        candidatoHijo.setTipo("Tipo");
        candidatoHijo.setTipoId(1);
        candidatoHijo.setUpdateDate(mock(Timestamp.class));

        Grupo searched = new Grupo();
        searched.setChildrenIds(new ArrayList<>());
        searched.setCodigo("Codigo");
        searched.setCreationDate(mock(Timestamp.class));
        searched.setDeleted(1);
        searched.setId(1);
        searched.setName("Name");
        searched.setParentGroupId(1);
        searched.setParentGroupName("Parent Group Name");
        searched.setTipo("Tipo");
        searched.setTipoId(1);
        searched.setUpdateDate(mock(Timestamp.class));
        boolean actualSearchUnidadSuperiorResult = grupoService.searchUnidadSuperior(candidatoHijo, searched);
        verify(cacheManager).getCache(Mockito.<String>any());
        verify(cacheManager).getCacheNames();
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertTrue(actualSearchUnidadSuperiorResult);
    }
}
