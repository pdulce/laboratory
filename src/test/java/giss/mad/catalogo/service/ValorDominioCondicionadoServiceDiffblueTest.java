package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.model.ValorDominioCondicionadoPor;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValorDominioRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ValorDominioCondicionadoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ValorDominioCondicionadoServiceDiffblueTest {
    @MockBean
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    @Autowired
    private ValorDominioCondicionadoService valorDominioCondicionadoService;

    @MockBean
    private ValorDominioRepository valorDominioRepository;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ValorDominioCondicionadoService#setValorDominioCondicionadoRepository(ValorDominioCondicionadoRepository)}
     *   <li>
     * {@link ValorDominioCondicionadoService#setValorDominioRepository(ValorDominioRepository)}
     * </ul>
     */
    @Test
    void testSetValorDominioCondicionadoRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ValorDominioCondicionadoService.valorDominioCondicionadoRepository
        //     ValorDominioCondicionadoService.valorDominioRepository

        ValorDominioCondicionadoService valorDominioCondicionadoService = new ValorDominioCondicionadoService();
        valorDominioCondicionadoService
                .setValorDominioCondicionadoRepository(mock(ValorDominioCondicionadoRepository.class));
        valorDominioCondicionadoService.setValorDominioRepository(mock(ValorDominioRepository.class));
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<ValorDominioCondicionadoPor> valorDominioCondicionadoPorList = new ArrayList<>();
        when(valorDominioCondicionadoRepository.findAllByDeletedIsNull()).thenReturn(valorDominioCondicionadoPorList);
        Collection<ValorDominioCondicionadoPor> actualAll = valorDominioCondicionadoService.getAll();
        verify(valorDominioCondicionadoRepository).findAllByDeletedIsNull();
        assertTrue(actualAll.isEmpty());
        assertSame(valorDominioCondicionadoPorList, actualAll);
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#getAll()}
     */
    @Test
    void testGetAll2() {
        when(valorDominioCondicionadoRepository.findAllByDeletedIsNull()).thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioCondicionadoService.getAll());
        verify(valorDominioCondicionadoRepository).findAllByDeletedIsNull();
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#get(Integer)}
     */
    @Test
    void testGet() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(valorDominioCondicionadoPor);
        ValorDominioCondicionadoPor actualGetResult = valorDominioCondicionadoService.get(1);
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(valorDominioCondicionadoPor, actualGetResult);
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#get(Integer)}
     */
    @Test
    void testGet2() {
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        assertThrows(IllegalArgumentException.class, () -> valorDominioCondicionadoService.get(1));
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ValorDominioCondicionadoService#insertar(ValorDominioCondicionadoPor)}
     */
    @Test
    void testInsertar() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenReturn(valorDominioCondicionadoPor);

        ValorDominioCondicionadoPor valorDominioCondicionadoPor2 = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor2.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor2.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor2.setDeleted(1);
        valorDominioCondicionadoPor2.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor2.setDomainValueId(1);
        valorDominioCondicionadoPor2.setId(1);
        valorDominioCondicionadoPor2.setName("Name");
        valorDominioCondicionadoPor2.setUpdateDate(mock(Timestamp.class));
        ValorDominioCondicionadoPor actualInsertarResult = valorDominioCondicionadoService
                .insertar(valorDominioCondicionadoPor2);
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
        assertSame(valorDominioCondicionadoPor, actualInsertarResult);
    }

    /**
     * Method under test:
     * {@link ValorDominioCondicionadoService#insertar(ValorDominioCondicionadoPor)}
     */
    @Test
    void testInsertar2() {
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenThrow(new IllegalArgumentException("foo"));

        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class,
                () -> valorDominioCondicionadoService.insertar(valorDominioCondicionadoPor));
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
    }

    /**
     * Method under test:
     * {@link ValorDominioCondicionadoService#update(ValorDominioCondicionadoPor)}
     */
    @Test
    void testUpdate() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));

        ValorDominioCondicionadoPor valorDominioCondicionadoPor2 = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor2.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor2.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor2.setDeleted(1);
        valorDominioCondicionadoPor2.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor2.setDomainValueId(1);
        valorDominioCondicionadoPor2.setId(1);
        valorDominioCondicionadoPor2.setName("Name");
        valorDominioCondicionadoPor2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenReturn(valorDominioCondicionadoPor2);
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(valorDominioCondicionadoPor);

        ValorDominioCondicionadoPor valorDominioConditionated = new ValorDominioCondicionadoPor();
        valorDominioConditionated.setAttributeName("Attribute Name");
        valorDominioConditionated.setCreationDate(mock(Timestamp.class));
        valorDominioConditionated.setDeleted(1);
        valorDominioConditionated.setDomainValueCollateralId(1);
        valorDominioConditionated.setDomainValueId(1);
        valorDominioConditionated.setId(1);
        valorDominioConditionated.setName("Name");
        valorDominioConditionated.setUpdateDate(mock(Timestamp.class));
        ValorDominioCondicionadoPor actualUpdateResult = valorDominioCondicionadoService.update(valorDominioConditionated);
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
        assertSame(valorDominioCondicionadoPor2, actualUpdateResult);
    }

    /**
     * Method under test:
     * {@link ValorDominioCondicionadoService#update(ValorDominioCondicionadoPor)}
     */
    @Test
    void testUpdate2() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(valorDominioCondicionadoPor);

        ValorDominioCondicionadoPor valorDominioConditionated = new ValorDominioCondicionadoPor();
        valorDominioConditionated.setAttributeName("Attribute Name");
        valorDominioConditionated.setCreationDate(mock(Timestamp.class));
        valorDominioConditionated.setDeleted(1);
        valorDominioConditionated.setDomainValueCollateralId(1);
        valorDominioConditionated.setDomainValueId(1);
        valorDominioConditionated.setId(1);
        valorDominioConditionated.setName("Name");
        valorDominioConditionated.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class,
                () -> valorDominioCondicionadoService.update(valorDominioConditionated));
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
    }

    /**
     * Method under test:
     * {@link ValorDominioCondicionadoService#update(ValorDominioCondicionadoPor)}
     */
    @Test
    void testUpdate3() {
        ValorDominioCondicionadoPor valorDominioConditionated = new ValorDominioCondicionadoPor();
        valorDominioConditionated.setAttributeName("Attribute Name");
        valorDominioConditionated.setCreationDate(mock(Timestamp.class));
        valorDominioConditionated.setDeleted(1);
        valorDominioConditionated.setDomainValueCollateralId(1);
        valorDominioConditionated.setDomainValueId(1);
        valorDominioConditionated.setId(null);
        valorDominioConditionated.setName("Name");
        valorDominioConditionated.setUpdateDate(mock(Timestamp.class));
        assertThrows(IllegalArgumentException.class,
                () -> valorDominioCondicionadoService.update(valorDominioConditionated));
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#remove(Integer)}
     */
    @Test
    void testRemove() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));

        ValorDominioCondicionadoPor valorDominioCondicionadoPor2 = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor2.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor2.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor2.setDeleted(1);
        valorDominioCondicionadoPor2.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor2.setDomainValueId(1);
        valorDominioCondicionadoPor2.setId(1);
        valorDominioCondicionadoPor2.setName("Name");
        valorDominioCondicionadoPor2.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenReturn(valorDominioCondicionadoPor2);
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(valorDominioCondicionadoPor);
        ValorDominioCondicionadoPor actualRemoveResult = valorDominioCondicionadoService.remove(1);
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
        assertSame(valorDominioCondicionadoPor2, actualRemoveResult);
    }

    /**
     * Method under test: {@link ValorDominioCondicionadoService#remove(Integer)}
     */
    @Test
    void testRemove2() {
        ValorDominioCondicionadoPor valorDominioCondicionadoPor = new ValorDominioCondicionadoPor();
        valorDominioCondicionadoPor.setAttributeName("Attribute Name");
        valorDominioCondicionadoPor.setCreationDate(mock(Timestamp.class));
        valorDominioCondicionadoPor.setDeleted(1);
        valorDominioCondicionadoPor.setDomainValueCollateralId(1);
        valorDominioCondicionadoPor.setDomainValueId(1);
        valorDominioCondicionadoPor.setId(1);
        valorDominioCondicionadoPor.setName("Name");
        valorDominioCondicionadoPor.setUpdateDate(mock(Timestamp.class));
        when(valorDominioCondicionadoRepository.save(Mockito.<ValorDominioCondicionadoPor>any()))
                .thenThrow(new IllegalArgumentException("foo"));
        when(valorDominioCondicionadoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(valorDominioCondicionadoPor);
        assertThrows(IllegalArgumentException.class, () -> valorDominioCondicionadoService.remove(1));
        verify(valorDominioCondicionadoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(valorDominioCondicionadoRepository).save(Mockito.<ValorDominioCondicionadoPor>any());
    }
}
