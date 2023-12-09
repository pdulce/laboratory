package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.model.AtributoEjePorTipoElemento;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.ElementoCatalogoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;
import giss.mad.catalogo.repository.ValoresEjesDeElemenCatalogoUsuarioRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AtributoEjePorTipoElementoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class AtributoEjePorTipoElementoServiceDiffblueTest {
  @MockBean
  private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

  @Autowired
  private AtributoEjePorTipoElementoService atributoEjePorTipoElementoService;

  @MockBean
  private AtributoEjeRepository atributoEjeRepository;

  @MockBean
  private CacheManager cacheManager;

  @MockBean
  private ElementoCatalogoRepository elementoCatalogoRepository;

  @MockBean
  private ValorDominioRepository valorDominioRepository;

  @MockBean
  private ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository;

  /**
   * Methods under test:
   *
   * <ul>
   *   <li>{@link AtributoEjePorTipoElementoService#setCacheManager(CacheManager)}
   *   <li>
   * {@link AtributoEjePorTipoElementoService#setValorDominioRepository(ValorDominioRepository)}
   *   <li>
   * {@link AtributoEjePorTipoElementoService#setValoresEjesDeElemenCatalogoUsuarioRepository(ValoresEjesDeElemenCatalogoUsuarioRepository)}
   *   <li>
   * {@link AtributoEjePorTipoElementoService#setAtributoEjePorTipoElementoRepository(AtributoEjePorTipoElementoRepository)}
   *   <li>
   * {@link AtributoEjePorTipoElementoService#setAtributoEjeRepository(AtributoEjeRepository)}
   *   <li>
   * {@link AtributoEjePorTipoElementoService#setElementoCatalogoRepository(ElementoCatalogoRepository)}
   * </ul>
   */
  @Test
  void testSetCacheManager() {
    // TODO: Complete this test.
    //   Reason: R002 Missing observers.
    //   Diffblue Cover was unable to create an assertion.
    //   Add getters for the following fields or make them package-private:
    //     AtributoEjePorTipoElementoService.atributoEjePorTipoElementoRepository
    //     AtributoEjePorTipoElementoService.atributoEjeRepository
    //     AtributoEjePorTipoElementoService.cacheManager
    //     AtributoEjePorTipoElementoService.elementoCatalogoRepository
    //     AtributoEjePorTipoElementoService.valorDominioRepository
    //     AtributoEjePorTipoElementoService.valoresEjesDeElemenCatalogoUsuarioRepository

    AtributoEjePorTipoElementoService atributoEjePorTipoElementoService = new AtributoEjePorTipoElementoService();
    atributoEjePorTipoElementoService.setCacheManager(new ConcurrentMapCacheManager());
    atributoEjePorTipoElementoService.setValorDominioRepository(mock(ValorDominioRepository.class));
    atributoEjePorTipoElementoService
            .setValoresEjesDeElemenCatalogoUsuarioRepository(mock(ValoresEjesDeElemenCatalogoUsuarioRepository.class));
    atributoEjePorTipoElementoService
            .setAtributoEjePorTipoElementoRepository(mock(AtributoEjePorTipoElementoRepository.class));
    atributoEjePorTipoElementoService.setAtributoEjeRepository(mock(AtributoEjeRepository.class));
    atributoEjePorTipoElementoService.setElementoCatalogoRepository(mock(ElementoCatalogoRepository.class));
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#getAll()}
   */
  @Test
  void testGetAll() {
    ArrayList<AtributoEjePorTipoElemento> atributoEjePorTipoElementoList = new ArrayList<>();
    when(atributoEjePorTipoElementoRepository.findAllByDeletedIsNull()).thenReturn(atributoEjePorTipoElementoList);
    List<AtributoEjePorTipoElemento> actualAll = atributoEjePorTipoElementoService.getAll();
    verify(atributoEjePorTipoElementoRepository).findAllByDeletedIsNull();
    assertTrue(actualAll.isEmpty());
    assertSame(atributoEjePorTipoElementoList, actualAll);
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#getAll()}
   */
  @Test
  void testGetAll2() {
    when(atributoEjePorTipoElementoRepository.findAllByDeletedIsNull()).thenThrow(new IllegalArgumentException("foo"));
    assertThrows(IllegalArgumentException.class, () -> atributoEjePorTipoElementoService.getAll());
    verify(atributoEjePorTipoElementoRepository).findAllByDeletedIsNull();
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#get(Integer)}
   */
  @Test
  void testGet() {
    AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
    atributoEjePorTipoElemento.setAxisAttributeId(1);
    atributoEjePorTipoElemento.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento.setDeleted(1);
    atributoEjePorTipoElemento.setForCatalogue(1);
    atributoEjePorTipoElemento.setForDelivery(1);
    atributoEjePorTipoElemento.setId(1);
    atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenReturn(atributoEjePorTipoElemento);
    AtributoEjePorTipoElemento actualGetResult = atributoEjePorTipoElementoService.get(1);
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    assertSame(atributoEjePorTipoElemento, actualGetResult);
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#get(Integer)}
   */
  @Test
  void testGet2() {
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenThrow(new IllegalArgumentException("foo"));
    assertThrows(IllegalArgumentException.class, () -> atributoEjePorTipoElementoService.get(1));
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
  }

  /**
   * Method under test:
   * {@link AtributoEjePorTipoElementoService#insertar(AtributoEjePorTipoElemento)}
   */
  @Test
  void testInsertar() {
    AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
    atributoEjePorTipoElemento.setAxisAttributeId(1);
    atributoEjePorTipoElemento.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento.setDeleted(1);
    atributoEjePorTipoElemento.setForCatalogue(1);
    atributoEjePorTipoElemento.setForDelivery(1);
    atributoEjePorTipoElemento.setId(1);
    atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    AtributoEjePorTipoElemento attr = new AtributoEjePorTipoElemento();
    attr.setAxisAttributeId(1);
    attr.setCatalogElementTypeId(1);
    attr.setCreationDate(mock(Timestamp.class));
    attr.setDeleted(1);
    attr.setForCatalogue(1);
    attr.setForDelivery(1);
    attr.setId(1);
    attr.setUpdateDate(mock(Timestamp.class));
    AtributoEjePorTipoElemento actualInsertarResult = atributoEjePorTipoElementoService.insertar(attr);
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
    assertSame(atributoEjePorTipoElemento, actualInsertarResult);
  }

  /**
   * Method under test:
   * {@link AtributoEjePorTipoElementoService#insertar(AtributoEjePorTipoElemento)}
   */
  @Test
  void testInsertar2() {
    AtributoEjePorTipoElemento atributoEjePorTipoElemento = new AtributoEjePorTipoElemento();
    atributoEjePorTipoElemento.setAxisAttributeId(1);
    atributoEjePorTipoElemento.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento.setDeleted(1);
    atributoEjePorTipoElemento.setForCatalogue(1);
    atributoEjePorTipoElemento.setForDelivery(1);
    atributoEjePorTipoElemento.setId(1);
    atributoEjePorTipoElemento.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalArgumentException("atributos-cache"));

    AtributoEjePorTipoElemento attr = new AtributoEjePorTipoElemento();
    attr.setAxisAttributeId(1);
    attr.setCatalogElementTypeId(1);
    attr.setCreationDate(mock(Timestamp.class));
    attr.setDeleted(1);
    attr.setForCatalogue(1);
    attr.setForDelivery(1);
    attr.setId(1);
    attr.setUpdateDate(mock(Timestamp.class));
    assertThrows(IllegalArgumentException.class, () -> atributoEjePorTipoElementoService.insertar(attr));
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
  }

  /**
   * Method under test:
   * {@link AtributoEjePorTipoElementoService#update(AtributoEjePorTipoElemento)}
   */
  @Test
  void testUpdate() {
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
    atributoEjePorTipoElemento2.setAxisAttributeId(1);
    atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento2.setDeleted(1);
    atributoEjePorTipoElemento2.setForCatalogue(1);
    atributoEjePorTipoElemento2.setForDelivery(1);
    atributoEjePorTipoElemento2.setId(1);
    atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento2);
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));

    AtributoEjePorTipoElemento attr = new AtributoEjePorTipoElemento();
    attr.setAxisAttributeId(1);
    attr.setCatalogElementTypeId(1);
    attr.setCreationDate(mock(Timestamp.class));
    attr.setDeleted(1);
    attr.setForCatalogue(1);
    attr.setForDelivery(1);
    attr.setId(1);
    attr.setUpdateDate(mock(Timestamp.class));
    AtributoEjePorTipoElemento actualUpdateResult = atributoEjePorTipoElementoService.update(attr);
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
    assertSame(atributoEjePorTipoElemento2, actualUpdateResult);
  }

  /**
   * Method under test:
   * {@link AtributoEjePorTipoElementoService#update(AtributoEjePorTipoElemento)}
   */
  @Test
  void testUpdate2() {
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
    atributoEjePorTipoElemento2.setAxisAttributeId(1);
    atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento2.setDeleted(1);
    atributoEjePorTipoElemento2.setForCatalogue(1);
    atributoEjePorTipoElemento2.setForDelivery(1);
    atributoEjePorTipoElemento2.setId(1);
    atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento2);
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalArgumentException("atributos-cache"));

    AtributoEjePorTipoElemento attr = new AtributoEjePorTipoElemento();
    attr.setAxisAttributeId(1);
    attr.setCatalogElementTypeId(1);
    attr.setCreationDate(mock(Timestamp.class));
    attr.setDeleted(1);
    attr.setForCatalogue(1);
    attr.setForDelivery(1);
    attr.setId(1);
    attr.setUpdateDate(mock(Timestamp.class));
    assertThrows(IllegalArgumentException.class, () -> atributoEjePorTipoElementoService.update(attr));
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#remove(Integer)}
   */
  @Test
  void testRemove() {
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
    atributoEjePorTipoElemento2.setAxisAttributeId(1);
    atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento2.setDeleted(1);
    atributoEjePorTipoElemento2.setForCatalogue(1);
    atributoEjePorTipoElemento2.setForDelivery(1);
    atributoEjePorTipoElemento2.setId(1);
    atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento2);
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenReturn(new ConcurrentMapCache("Name"));
    AtributoEjePorTipoElemento actualRemoveResult = atributoEjePorTipoElementoService.remove(1);
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
    assertSame(atributoEjePorTipoElemento2, actualRemoveResult);
  }

  /**
   * Method under test: {@link AtributoEjePorTipoElementoService#remove(Integer)}
   */
  @Test
  void testRemove2() {
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
    atributoEjePorTipoElemento2.setAxisAttributeId(1);
    atributoEjePorTipoElemento2.setCatalogElementTypeId(1);
    atributoEjePorTipoElemento2.setCreationDate(mock(Timestamp.class));
    atributoEjePorTipoElemento2.setDeleted(1);
    atributoEjePorTipoElemento2.setForCatalogue(1);
    atributoEjePorTipoElemento2.setForDelivery(1);
    atributoEjePorTipoElemento2.setId(1);
    atributoEjePorTipoElemento2.setUpdateDate(mock(Timestamp.class));
    when(atributoEjePorTipoElementoRepository.save(Mockito.<AtributoEjePorTipoElemento>any()))
            .thenReturn(atributoEjePorTipoElemento2);
    when(atributoEjePorTipoElementoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
            .thenReturn(atributoEjePorTipoElemento);
    when(cacheManager.getCache(Mockito.<String>any())).thenThrow(new IllegalArgumentException("atributos-cache"));
    assertThrows(IllegalArgumentException.class, () -> atributoEjePorTipoElementoService.remove(1));
    verify(atributoEjePorTipoElementoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    verify(cacheManager).getCache(Mockito.<String>any());
    verify(atributoEjePorTipoElementoRepository).save(Mockito.<AtributoEjePorTipoElemento>any());
  }
}
