package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.volatilentities.PesoGraph;
import giss.mad.itinerario.repository.itinerario.EjeHeredableRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PesoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class PesoServiceDiffblueTest {
    @MockBean
    private EjeHeredableRepository ejeHeredableRepository;

    @MockBean
    private PesoRepository pesoRepository;

    @Autowired
    private PesoService pesoService;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PesoService#setEjeHeredableRepository(EjeHeredableRepository)}
     *   <li>{@link PesoService#setPesoRepository(PesoRepository)}
     * </ul>
     */
    @Test
    void testSetEjeHeredableRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     PesoService.ejeHeredableRepository
        //     PesoService.pesoRepository

        PesoService pesoService = new PesoService();
        pesoService.setEjeHeredableRepository(mock(EjeHeredableRepository.class));
        pesoService.setPesoRepository(mock(PesoRepository.class));
    }

    /**
     * Method under test: {@link PesoService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<Peso> pesoList = new ArrayList<>();
        when(pesoRepository.findAllByDeletedIsNull()).thenReturn(pesoList);
        Collection<Peso> actualAll = pesoService.getAll();
        verify(pesoRepository).findAllByDeletedIsNull();
        assertTrue(actualAll.isEmpty());
        assertSame(pesoList, actualAll);
    }

    /**
     * Method under test: {@link PesoService#getAllByElement(Integer, Integer)}
     */
    @Test
    void testGetAllByElement() {
        ArrayList<PesoGraph> pesoGraphList = new ArrayList<>();
        when(pesoRepository.filtrarPorTipoCatalogoYEntrega(Mockito.<Integer>any(), Mockito.<Integer>any()))
                .thenReturn(pesoGraphList);
        Collection<PesoGraph> actualAllByElement = pesoService.getAllByElement(1, 1);
        verify(pesoRepository).filtrarPorTipoCatalogoYEntrega(Mockito.<Integer>any(), Mockito.<Integer>any());
        assertTrue(actualAllByElement.isEmpty());
        assertSame(pesoGraphList, actualAllByElement);
    }

    /**
     * Method under test: {@link PesoService#get(Integer)}
     */
    @Test
    void testGet() {
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
        when(pesoRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(peso);
        Peso actualGetResult = pesoService.get(1);
        verify(pesoRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(peso, actualGetResult);
    }

    /**
     * Method under test: {@link PesoService#save(Peso)}
     */
    @Test
    void testSave() {
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
        when(pesoRepository.save(Mockito.<Peso>any())).thenReturn(peso);

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
        Peso actualSaveResult = pesoService.save(peso2);
        verify(pesoRepository).save(Mockito.<Peso>any());
        assertSame(peso, actualSaveResult);
    }

    /**
     * Method under test: {@link PesoService#update(Peso)}
     */
    @Test
    void testUpdate() {
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
        Optional<Peso> ofResult = Optional.of(peso);

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
        when(pesoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);

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
        Peso actualUpdateResult = pesoService.update(peso3);
        verify(pesoRepository).findById(Mockito.<Integer>any());
        verify(pesoRepository).save(Mockito.<Peso>any());
        assertSame(peso2, actualUpdateResult);
    }

    /**
     * Method under test: {@link PesoService#update(Peso)}
     */
    @Test
    void testUpdate2() {
        Optional<Peso> emptyResult = Optional.empty();
        when(pesoRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

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
        Peso actualUpdateResult = pesoService.update(peso);
        verify(pesoRepository).findById(Mockito.<Integer>any());
        assertNull(actualUpdateResult);
    }
}
