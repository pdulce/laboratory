package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ElementOrEntregaInterface;
import giss.mad.catalogo.model.ElementoCatalogo;
import giss.mad.catalogo.model.EntregaElementoCatalogo;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.repository.GrupoRepository;
import giss.mad.catalogo.service.ElementOrReleaseServiceInterface;
import giss.mad.catalogo.service.GrupoService;
import giss.mad.catalogo.service.ValorDominioService;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ExcelGeneratorMockitoTest {
    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();

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

        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        listaAtributos.add(atributoEje);
        assertNull(ExcelGenerator.generateExcelSummarized(elementos, elementoCatalogoService, grupoService, listaAtributos,
                new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        EntregaElementoCatalogo entregaElementoCatalogo = new EntregaElementoCatalogo();
        entregaElementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        entregaElementoCatalogo.setCappCode("U/U");
        entregaElementoCatalogo.setCatalogElementId(1);
        entregaElementoCatalogo.setCatalogElementTypeId(1);
        entregaElementoCatalogo.setCreationDate(mock(Timestamp.class));
        entregaElementoCatalogo.setDeleted(1);
        entregaElementoCatalogo.setDeliveryCatalogElementCollateralId(1);
        entregaElementoCatalogo.setGroup("U/U");
        entregaElementoCatalogo.setGroupId(1);
        entregaElementoCatalogo.setId(1);
        entregaElementoCatalogo.setName("U/U");
        entregaElementoCatalogo.setProductionDeliveryDate(mock(Timestamp.class));
        entregaElementoCatalogo.setReadOnly(1);
        entregaElementoCatalogo.setSubElements(new ArrayList<>());
        entregaElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(entregaElementoCatalogo);
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();

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

        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        listaAtributos.add(atributoEje);
        assertNull(ExcelGenerator.generateExcelSummarized(elementos, elementoCatalogoService, grupoService, listaAtributos,
                new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(null);
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();

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

        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        listaAtributos.add(atributoEje);
        assertNull(ExcelGenerator.generateExcelSummarized(elementos, elementoCatalogoService, grupoService, listaAtributos,
                new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized4() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(new ElementoCatalogo());
        elementos.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelSummarized(elementos, elementoCatalogoService, grupoService, listaAtributos,
                new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized5() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(new ElementoCatalogo());
        elementos.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelSummarized(elementos, elementoCatalogoService, null, listaAtributos,
                new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelSummarized(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelSummarized6() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementos = new ArrayList<>();
        elementos.add(new ElementoCatalogo());
        elementos.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoRepository grupoRepository = mock(GrupoRepository.class);
        Optional<Grupo> emptyResult = Optional.empty();
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(emptyResult);

        GrupoService grupoService = new GrupoService();
        grupoService.setGrupoRepository(grupoRepository);
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        byte[] actualGenerateExcelSummarizedResult = ExcelGenerator.generateExcelSummarized(elementos,
                elementoCatalogoService, grupoService, listaAtributos, new ValorDominioService());
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertNull(actualGenerateExcelSummarizedResult);
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelExtended(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelExtended() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementosOrEntregas = new ArrayList<>();
        elementosOrEntregas.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelExtended(elementosOrEntregas, elementoCatalogoService, grupoService,
                listaAtributos, new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelExtended(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelExtended2() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementosOrEntregas = new ArrayList<>();
        elementosOrEntregas.add(new ElementoCatalogo());
        elementosOrEntregas.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelExtended(elementosOrEntregas, elementoCatalogoService, grupoService,
                listaAtributos, new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelExtended(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelExtended3() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        EntregaElementoCatalogo entregaElementoCatalogo = new EntregaElementoCatalogo();
        entregaElementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        entregaElementoCatalogo.setCappCode("U/U");
        entregaElementoCatalogo.setCatalogElementId(1);
        entregaElementoCatalogo.setCatalogElementTypeId(1);
        entregaElementoCatalogo.setCreationDate(mock(Timestamp.class));
        entregaElementoCatalogo.setDeleted(1);
        entregaElementoCatalogo.setDeliveryCatalogElementCollateralId(1);
        entregaElementoCatalogo.setGroup("U/U");
        entregaElementoCatalogo.setGroupId(1);
        entregaElementoCatalogo.setId(1);
        entregaElementoCatalogo.setName("U/U");
        entregaElementoCatalogo.setProductionDeliveryDate(mock(Timestamp.class));
        entregaElementoCatalogo.setReadOnly(1);
        entregaElementoCatalogo.setSubElements(new ArrayList<>());
        entregaElementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementOrEntregaInterface> elementosOrEntregas = new ArrayList<>();
        elementosOrEntregas.add(entregaElementoCatalogo);
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelExtended(elementosOrEntregas, elementoCatalogoService, grupoService,
                listaAtributos, new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelExtended(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelExtended4() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementosOrEntregas = new ArrayList<>();
        elementosOrEntregas.add(null);
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        GrupoService grupoService = new GrupoService();
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelExtended(elementosOrEntregas, elementoCatalogoService, grupoService,
                listaAtributos, new ValorDominioService()));
    }

    /**
     * Method under test:
     * {@link ExcelGenerator#generateExcelExtended(List, ElementOrReleaseServiceInterface, GrupoService, List, ValorDominioService)}
     */
    @Test
    void testGenerateExcelExtended5() throws IOException {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R027 Missing beans when creating Spring context.
        //   Failed to create Spring context due to missing beans
        //   in the current Spring profile:
        //       org.springframework.cache.CacheManager
        //   See https://diff.blue/R027 to resolve this issue.

        ArrayList<ElementOrEntregaInterface> elementosOrEntregas = new ArrayList<>();
        elementosOrEntregas.add(new ElementoCatalogo());
        ElementOrReleaseServiceInterface elementoCatalogoService = mock(ElementOrReleaseServiceInterface.class);
        ArrayList<AtributoEje> listaAtributos = new ArrayList<>();
        assertNull(ExcelGenerator.generateExcelExtended(elementosOrEntregas, elementoCatalogoService, null, listaAtributos,
                new ValorDominioService()));
    }
}
