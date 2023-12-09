package giss.mad.itinerario.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.itinerario.model.itinerario.Configuracion;
import giss.mad.itinerario.repository.itinerario.ConfiguracionRepository;

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

@ContextConfiguration(classes = {ConfiguracionService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ConfiguracionServiceDiffblueTest {
    @MockBean
    private ConfiguracionRepository configuracionRepository;

    @Autowired
    private ConfiguracionService configuracionService;

    /**
     * Method under test:
     * {@link ConfiguracionService#setConfiguracionRepository(ConfiguracionRepository)}
     */
    @Test
    void testSetConfiguracionRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ConfiguracionService.configuracionRepository

        (new ConfiguracionService()).setConfiguracionRepository(mock(ConfiguracionRepository.class));
    }

    /**
     * Method under test: {@link ConfiguracionService#getAll()}
     */
    @Test
    void testGetAll() {
        ArrayList<Configuracion> configuracionList = new ArrayList<>();
        when(configuracionRepository.findAllByDeletedIsNull()).thenReturn(configuracionList);
        List<Configuracion> actualAll = configuracionService.getAll();
        verify(configuracionRepository).findAllByDeletedIsNull();
        assertTrue(actualAll.isEmpty());
        assertSame(configuracionList, actualAll);
    }

    /**
     * Method under test: {@link ConfiguracionService#getById(Integer)}
     */
    @Test
    void testGetById() {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(configuracion);
        Configuracion actualById = configuracionService.getById(1);
        verify(configuracionRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        assertSame(configuracion, actualById);
    }

    /**
     * Method under test: {@link ConfiguracionService#getByKey(String)}
     */
    @Test
    void testGetByKey() {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.findByKeyAndDeletedIsNull(Mockito.<String>any())).thenReturn(configuracion);
        Configuracion actualByKey = configuracionService.getByKey("Name");
        verify(configuracionRepository).findByKeyAndDeletedIsNull(Mockito.<String>any());
        assertSame(configuracion, actualByKey);
    }

    /**
     * Method under test: {@link ConfiguracionService#insertar(Configuracion)}
     */
    @Test
    void testInsertar() {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.save(Mockito.<Configuracion>any())).thenReturn(configuracion);

        Configuracion configuracion2 = new Configuracion();
        configuracion2.setCreationDate(mock(Timestamp.class));
        configuracion2.setDeleted(1);
        configuracion2.setDescription("The characteristics of someone or something");
        configuracion2.setId(1);
        configuracion2.setKey("Key");
        configuracion2.setUpdateDate(mock(Timestamp.class));
        configuracion2.setValue("42");
        Configuracion actualInsertarResult = configuracionService.insertar(configuracion2);
        verify(configuracionRepository).save(Mockito.<Configuracion>any());
        assertSame(configuracion, actualInsertarResult);
    }

    /**
     * Method under test: {@link ConfiguracionService#actualizar(Configuracion)}
     */
    @Test
    void testActualizar() {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");
        when(configuracionRepository.save(Mockito.<Configuracion>any())).thenReturn(configuracion);

        Configuracion configuracion2 = new Configuracion();
        configuracion2.setCreationDate(mock(Timestamp.class));
        configuracion2.setDeleted(1);
        configuracion2.setDescription("The characteristics of someone or something");
        configuracion2.setId(1);
        configuracion2.setKey("Key");
        configuracion2.setUpdateDate(mock(Timestamp.class));
        configuracion2.setValue("42");
        Configuracion actualActualizarResult = configuracionService.actualizar(configuracion2);
        verify(configuracionRepository).save(Mockito.<Configuracion>any());
        assertSame(configuracion, actualActualizarResult);
    }

    /**
     * Method under test: {@link ConfiguracionService#borradoLogico(int)}
     */
    @Test
    void testBorradoLogico() {
        Configuracion configuracion = new Configuracion();
        configuracion.setCreationDate(mock(Timestamp.class));
        configuracion.setDeleted(1);
        configuracion.setDescription("The characteristics of someone or something");
        configuracion.setId(1);
        configuracion.setKey("Key");
        configuracion.setUpdateDate(mock(Timestamp.class));
        configuracion.setValue("42");

        Configuracion configuracion2 = new Configuracion();
        configuracion2.setCreationDate(mock(Timestamp.class));
        configuracion2.setDeleted(1);
        configuracion2.setDescription("The characteristics of someone or something");
        configuracion2.setId(1);
        configuracion2.setKey("Key");
        configuracion2.setUpdateDate(mock(Timestamp.class));
        configuracion2.setValue("42");
        when(configuracionRepository.save(Mockito.<Configuracion>any())).thenReturn(configuracion2);
        when(configuracionRepository.findByIdAndDeletedIsNull(Mockito.<Integer>any())).thenReturn(configuracion);
        Configuracion actualBorradoLogicoResult = configuracionService.borradoLogico(1);
        verify(configuracionRepository).findByIdAndDeletedIsNull(Mockito.<Integer>any());
        verify(configuracionRepository).save(Mockito.<Configuracion>any());
        assertSame(configuracion2, actualBorradoLogicoResult);
    }
}
