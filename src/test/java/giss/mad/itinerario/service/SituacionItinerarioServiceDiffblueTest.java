package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.SituacionItinerario;
import giss.mad.itinerario.repository.itinerario.SituacionItinerarioRepository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SituacionItinerarioService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class SituacionItinerarioServiceDiffblueTest {
    @MockBean
    private SituacionItinerarioRepository situacionItinerarioRepository;

    @Autowired
    private SituacionItinerarioService situacionItinerarioService;

    /**
     * Method under test:
     * {@link SituacionItinerarioService#setSituacionItinerarioRepository(SituacionItinerarioRepository)}
     */
    @Test
    void testSetSituacionItinerarioRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     SituacionItinerarioService.situacionItinerarioRepository

        (new SituacionItinerarioService()).setSituacionItinerarioRepository(mock(SituacionItinerarioRepository.class));
    }

    /**
     * Method under test: {@link SituacionItinerarioService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<SituacionItinerario> situacionItinerarioList = new ArrayList<>();
        when(situacionItinerarioRepository.findAllByDeletedIsNull()).thenReturn(situacionItinerarioList);
        List<SituacionItinerario> actualAll = situacionItinerarioService.getAll();
        verify(situacionItinerarioRepository).findAllByDeletedIsNull();
        assertTrue(actualAll.isEmpty());
        assertSame(situacionItinerarioList, actualAll);
    }

    /**
     * Method under test: {@link SituacionItinerarioService#get(Integer)}
     */
    @Test
    void testGet() {
        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(situacionItinerario);
        SituacionItinerario actualGetResult = situacionItinerarioService.get(1);
        verify(situacionItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(situacionItinerario, actualGetResult);
    }

    /**
     * Method under test:
     * {@link SituacionItinerarioService#insertar(SituacionItinerario)}
     */
    @Test
    void testInsertar() {
        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.save(Mockito.<SituacionItinerario>any())).thenReturn(situacionItinerario);

        SituacionItinerario situacion = new SituacionItinerario();
        situacion.setCreationDate(mock(Timestamp.class));
        situacion.setDeleted(1);
        situacion.setDescription("The characteristics of someone or something");
        situacion.setId(1);
        situacion.setItinerarios(new ArrayList<>());
        situacion.setName("Name");
        situacion.setUpdateDate(mock(Timestamp.class));
        SituacionItinerario actualInsertarResult = situacionItinerarioService.insertar(situacion);
        verify(situacionItinerarioRepository).save(Mockito.<SituacionItinerario>any());
        assertSame(situacionItinerario, actualInsertarResult);
    }

    /**
     * Method under test:
     * {@link SituacionItinerarioService#actualizar(SituacionItinerario)}
     */
    @Test
    void testActualizar() {
        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));

        SituacionItinerario situacionItinerario2 = new SituacionItinerario();
        situacionItinerario2.setCreationDate(mock(Timestamp.class));
        situacionItinerario2.setDeleted(1);
        situacionItinerario2.setDescription("The characteristics of someone or something");
        situacionItinerario2.setId(1);
        situacionItinerario2.setItinerarios(new ArrayList<>());
        situacionItinerario2.setName("Name");
        situacionItinerario2.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.save(Mockito.<SituacionItinerario>any())).thenReturn(situacionItinerario2);
        when(situacionItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(situacionItinerario);

        SituacionItinerario situacion = new SituacionItinerario();
        situacion.setCreationDate(mock(Timestamp.class));
        situacion.setDeleted(1);
        situacion.setDescription("The characteristics of someone or something");
        situacion.setId(1);
        situacion.setItinerarios(new ArrayList<>());
        situacion.setName("Name");
        situacion.setUpdateDate(mock(Timestamp.class));
        SituacionItinerario actualActualizarResult = situacionItinerarioService.actualizar(situacion);
        verify(situacionItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(situacionItinerarioRepository).save(Mockito.<SituacionItinerario>any());
        assertSame(situacionItinerario2, actualActualizarResult);
    }

    /**
     * Method under test: {@link SituacionItinerarioService#borradoLogico(int)}
     */
    @Test
    void testBorradoLogico() {
        SituacionItinerario situacionItinerario = new SituacionItinerario();
        situacionItinerario.setCreationDate(mock(Timestamp.class));
        situacionItinerario.setDeleted(1);
        situacionItinerario.setDescription("The characteristics of someone or something");
        situacionItinerario.setId(1);
        situacionItinerario.setItinerarios(new ArrayList<>());
        situacionItinerario.setName("Name");
        situacionItinerario.setUpdateDate(mock(Timestamp.class));

        SituacionItinerario situacionItinerario2 = new SituacionItinerario();
        situacionItinerario2.setCreationDate(mock(Timestamp.class));
        situacionItinerario2.setDeleted(1);
        situacionItinerario2.setDescription("The characteristics of someone or something");
        situacionItinerario2.setId(1);
        situacionItinerario2.setItinerarios(new ArrayList<>());
        situacionItinerario2.setName("Name");
        situacionItinerario2.setUpdateDate(mock(Timestamp.class));
        when(situacionItinerarioRepository.save(Mockito.<SituacionItinerario>any())).thenReturn(situacionItinerario2);
        when(situacionItinerarioRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any()))
                .thenReturn(situacionItinerario);
        SituacionItinerario actualBorradoLogicoResult = situacionItinerarioService.borradoLogico(1);
        verify(situacionItinerarioRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(situacionItinerarioRepository).save(Mockito.<SituacionItinerario>any());
        assertSame(situacionItinerario2, actualBorradoLogicoResult);
    }
}
