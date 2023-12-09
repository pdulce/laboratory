package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.UmbralPactado;
import giss.mad.itinerario.repository.itinerario.UmbralPactadoRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UmbralPactadoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class UmbralPactadoServiceDiffblueTest {
    @MockBean
    private UmbralPactadoRepository umbralPactadoRepository;

    @Autowired
    private UmbralPactadoService umbralPactadoService;

    /**
     * Method under test:
     * {@link UmbralPactadoService#setUmbralPactadoRepository(UmbralPactadoRepository)}
     */
    @Test
    void testSetUmbralPactadoRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     UmbralPactadoService.umbralPactadoRepository

        (new UmbralPactadoService()).setUmbralPactadoRepository(mock(UmbralPactadoRepository.class));
    }

    /**
     * Method under test:
     * {@link UmbralPactadoService#getAllByActividadItinerarioId(Integer)}
     */
    @Test
    void testGetAllByActividadItinerarioId() {
        ArrayList<UmbralPactado> umbralPactadoList = new ArrayList<>();
        when(umbralPactadoRepository.findByActivityItineraryIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(umbralPactadoList);
        List<UmbralPactado> actualAllByActividadItinerarioId = umbralPactadoService.getAllByActividadItinerarioId(1);
        verify(umbralPactadoRepository).findByActivityItineraryIdAndDeletedIsNull(Mockito.<Integer>any());
        assertTrue(actualAllByActividadItinerarioId.isEmpty());
        assertSame(umbralPactadoList, actualAllByActividadItinerarioId);
    }

    /**
     * Method under test:
     * {@link UmbralPactadoService#actualizarUmbralPactado(Integer, Double)}
     */
    @Test
    void testActualizarUmbralPactado() {
        UmbralPactado umbralPactado = new UmbralPactado();
        umbralPactado.setActivityItineraryId(1);
        umbralPactado.setCreationDate(mock(Timestamp.class));
        umbralPactado.setDeleted(1);
        umbralPactado.setDischargeDate(mock(Timestamp.class));
        umbralPactado.setId(1);
        umbralPactado.setUpdateDate(mock(Timestamp.class));
        umbralPactado.setValue(10.0d);
        Optional<UmbralPactado> ofResult = Optional.of(umbralPactado);
        when(
                umbralPactadoRepository.findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(ofResult);
        umbralPactadoService.actualizarUmbralPactado(1, 10.0d);
        verify(umbralPactadoRepository)
                .findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link UmbralPactadoService#actualizarUmbralPactado(Integer, Double)}
     */
    @Test
    void testActualizarUmbralPactado2() {
        UmbralPactado umbralPactado = new UmbralPactado();
        umbralPactado.setActivityItineraryId(1);
        umbralPactado.setCreationDate(mock(Timestamp.class));
        umbralPactado.setDeleted(1);
        umbralPactado.setDischargeDate(mock(Timestamp.class));
        umbralPactado.setId(1);
        umbralPactado.setUpdateDate(mock(Timestamp.class));
        umbralPactado.setValue(10.0d);

        UmbralPactado umbralPactado2 = new UmbralPactado();
        umbralPactado2.setActivityItineraryId(1);
        umbralPactado2.setCreationDate(mock(Timestamp.class));
        umbralPactado2.setDeleted(1);
        umbralPactado2.setDischargeDate(mock(Timestamp.class));
        umbralPactado2.setId(1);
        umbralPactado2.setUpdateDate(mock(Timestamp.class));
        umbralPactado2.setValue(0.5d);
        Optional<UmbralPactado> ofResult = Optional.of(umbralPactado2);
        when(umbralPactadoRepository.save(Mockito.<UmbralPactado>any())).thenReturn(umbralPactado);
        when(
                umbralPactadoRepository.findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(ofResult);
        umbralPactadoService.actualizarUmbralPactado(1, 10.0d);
        verify(umbralPactadoRepository)
                .findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralPactadoRepository, atLeast(1)).save(Mockito.<UmbralPactado>any());
    }

    /**
     * Method under test:
     * {@link UmbralPactadoService#actualizarUmbralPactado(Integer, Double)}
     */
    @Test
    void testActualizarUmbralPactado3() {
        UmbralPactado umbralPactado = new UmbralPactado();
        umbralPactado.setActivityItineraryId(1);
        umbralPactado.setCreationDate(mock(Timestamp.class));
        umbralPactado.setDeleted(1);
        umbralPactado.setDischargeDate(mock(Timestamp.class));
        umbralPactado.setId(1);
        umbralPactado.setUpdateDate(mock(Timestamp.class));
        umbralPactado.setValue(Double.NaN);
        Optional<UmbralPactado> ofResult = Optional.of(umbralPactado);
        when(
                umbralPactadoRepository.findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(ofResult);
        umbralPactadoService.actualizarUmbralPactado(1, 10.0d);
        verify(umbralPactadoRepository)
                .findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link UmbralPactadoService#actualizarUmbralPactado(Integer, Double)}
     */
    @Test
    void testActualizarUmbralPactado4() {
        UmbralPactado umbralPactado = new UmbralPactado();
        umbralPactado.setActivityItineraryId(1);
        umbralPactado.setCreationDate(mock(Timestamp.class));
        umbralPactado.setDeleted(1);
        umbralPactado.setDischargeDate(mock(Timestamp.class));
        umbralPactado.setId(1);
        umbralPactado.setUpdateDate(mock(Timestamp.class));
        umbralPactado.setValue(10.0d);
        when(umbralPactadoRepository.save(Mockito.<UmbralPactado>any())).thenReturn(umbralPactado);
        Optional<UmbralPactado> emptyResult = Optional.empty();
        when(
                umbralPactadoRepository.findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(emptyResult);
        umbralPactadoService.actualizarUmbralPactado(1, 10.0d);
        verify(umbralPactadoRepository)
                .findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(Mockito.<Integer>any());
        verify(umbralPactadoRepository).save(Mockito.<UmbralPactado>any());
    }
}
