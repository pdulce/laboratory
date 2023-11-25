package com.mylabs.pds.service;

import com.mylabs.pds.model.Configuracion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:test-application.yml")
public class MyTest {

    @Before
    public void setUp(){
        Configuracion propiedad = new Configuracion();
        propiedad.setCodigo("MY_KEY");
        configuracionService.createConfiguracion(propiedad);
    }
    @Autowired
    private ConfiguracionService configuracionService;

    @Test
    public void testQueryAll() {
        List<Configuracion> propiedades = configuracionService.getAllConfiguraciones();
        Assert.assertTrue(propiedades.size() > 0);
    }
}

