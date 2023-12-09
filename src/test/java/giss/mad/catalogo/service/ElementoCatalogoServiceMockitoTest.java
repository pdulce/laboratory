package giss.mad.catalogo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ElementoCatalogo;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;
import giss.mad.catalogo.model.auxejes.AttributeValDomain;
import giss.mad.catalogo.model.auxejes.AxisValDomain;
import giss.mad.catalogo.model.auxejes.SimplifiedAttribute;
import giss.mad.catalogo.model.filters.CodigoList;
import giss.mad.catalogo.model.filters.ElementoCatalogoFilter;
import giss.mad.catalogo.model.filters.ElementoCatalogoMinimal;
import giss.mad.catalogo.model.filters.SimplifiedElement;
import giss.mad.catalogo.repository.AtributoEjePorTipoElementoRepository;
import giss.mad.catalogo.repository.AtributoEjeRepository;
import giss.mad.catalogo.repository.ElementoCatalogoRepository;
import giss.mad.catalogo.repository.EntregaElementoCatalogoRepository;
import giss.mad.catalogo.repository.TipoElementoCatalogoRepository;
import giss.mad.catalogo.repository.ValorDominioCondicionadoRepository;
import giss.mad.catalogo.repository.ValoresEjesDeElemenCatalogoUsuarioRepository;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ElementoCatalogoService.class})
@ActiveProfiles({"test"})
@ExtendWith(SpringExtension.class)
class ElementoCatalogoServiceMockitoTest {
    @MockBean
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @MockBean
    private AtributoEjeRepository atributoEjeRepository;

    @MockBean
    private AtributoEjeService atributoEjeService;

    @MockBean
    private ElementoCatalogoRepository elementoCatalogoRepository;

    @Autowired
    private ElementoCatalogoService elementoCatalogoService;

    @MockBean
    private EntregaElementoCatalogoRepository entregaElementoCatalogoRepository;

    @MockBean
    private GrupoService grupoService;

    @MockBean
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;

    @MockBean
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    @MockBean
    private ValorDominioService valorDominioService;

    @MockBean
    private ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository;

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>
     * {@link ElementoCatalogoService#setElemenCatalogoRepository(ElementoCatalogoRepository)}
     *   <li>{@link ElementoCatalogoService#setGrupoService(GrupoService)}
     *   <li>
     * {@link ElementoCatalogoService#setValorDominioCondicionadoRepository(ValorDominioCondicionadoRepository)}
     *   <li>
     * {@link ElementoCatalogoService#setValorDominioService(ValorDominioService)}
     *   <li>
     * {@link ElementoCatalogoService#setValoresEjesDeElemenCatalogoUsuarioRepository(ValoresEjesDeElemenCatalogoUsuarioRepository)}
     *   <li>
     * {@link ElementoCatalogoService#setAtributoEjePorTipoElementoRepository(AtributoEjePorTipoElementoRepository)}
     *   <li>
     * {@link ElementoCatalogoService#setAtributoEjeRepository(AtributoEjeRepository)}
     *   <li>{@link ElementoCatalogoService#setAtributoEjeService(AtributoEjeService)}
     *   <li>
     * {@link ElementoCatalogoService#setEntregaElementoCatalogoRepository(EntregaElementoCatalogoRepository)}
     *   <li>
     * {@link ElementoCatalogoService#setTipoElementoCatalogoRepository(TipoElementoCatalogoRepository)}
     * </ul>
     */
    @Test
    void testSetElemenCatalogoRepository() {
        // TODO: Complete this test.
        //   Reason: R002 Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     ElementoCatalogoService.atributoEjePorTipoElementoRepository
        //     ElementoCatalogoService.atributoEjeRepository
        //     ElementoCatalogoService.atributoEjeService
        //     ElementoCatalogoService.elemenCatalogoRepository
        //     ElementoCatalogoService.entregaElementoCatalogoRepository
        //     ElementoCatalogoService.grupoService
        //     ElementoCatalogoService.tipoElementoCatalogoRepository
        //     ElementoCatalogoService.valorDominioCondicionadoRepository
        //     ElementoCatalogoService.valorDominioService
        //     ElementoCatalogoService.valoresEjesDeElemenCatalogoUsuarioRepository

        ElementoCatalogoService elementoCatalogoService = new ElementoCatalogoService();
        elementoCatalogoService.setElemenCatalogoRepository(mock(ElementoCatalogoRepository.class));
        elementoCatalogoService.setGrupoService(new GrupoService());
        elementoCatalogoService.setValorDominioCondicionadoRepository(mock(ValorDominioCondicionadoRepository.class));
        elementoCatalogoService.setValorDominioService(new ValorDominioService());
        elementoCatalogoService
                .setValoresEjesDeElemenCatalogoUsuarioRepository(mock(ValoresEjesDeElemenCatalogoUsuarioRepository.class));
        elementoCatalogoService.setAtributoEjePorTipoElementoRepository(mock(AtributoEjePorTipoElementoRepository.class));
        elementoCatalogoService.setAtributoEjeRepository(mock(AtributoEjeRepository.class));
        elementoCatalogoService.setAtributoEjeService(new AtributoEjeService());
        elementoCatalogoService.setEntregaElementoCatalogoRepository(mock(EntregaElementoCatalogoRepository.class));
        elementoCatalogoService.setTipoElementoCatalogoRepository(mock(TipoElementoCatalogoRepository.class));
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getById(Integer)}
     */
    @Test
    void testGetById() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        ArrayList<ElementoCatalogoMinimal> elementoCatalogoMinimalList = new ArrayList<>();
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any()))
                .thenReturn(elementoCatalogoMinimalList);
        when(elementoCatalogoRepository.getByIdWithHistoric(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        ElementoCatalogo actualById = elementoCatalogoService.getById(1);
        verify(elementoCatalogoRepository).getByIdWithHistoric(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertEquals(elementoCatalogoMinimalList, actualById.getAttributeValuesCollection());
        assertEquals(elementoCatalogoMinimalList, actualById.getSubElements());
        assertSame(elementoCatalogo, actualById);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getById(Integer)}
     */
    @Test
    void testGetById2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdWithHistoric(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getById(1));
        verify(elementoCatalogoRepository).getByIdWithHistoric(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getById(Integer)}
     */
    @Test
    void testGetById3() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogoMinimal> elementoCatalogoMinimalList = new ArrayList<>();
        elementoCatalogoMinimalList.add(new ElementoCatalogoMinimal());

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(new ElementoCatalogo());
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement8 = new ElementoCatalogo();
        parentElement8.setAttributeValuesCollection(new ArrayList<>());
        parentElement8.setCappCode("Capp Code");
        parentElement8.setCatalogElementCollateralId(1);
        parentElement8.setCatalogElementTypeId(1);
        parentElement8.setCreationDate(mock(Timestamp.class));
        parentElement8.setDeleted(1);
        parentElement8.setDeliveryCollection(new ArrayList<>());
        parentElement8.setGroupId(1);
        parentElement8.setId(1);
        parentElement8.setIncomplete(1);
        parentElement8.setName("Name");
        parentElement8.setParentElement(parentElement7);
        parentElement8.setReadOnly(1);
        parentElement8.setRespDevelopmentId(1);
        parentElement8.setRespManagementId(1);
        parentElement8.setResponsableTto("alice.liddell@example.org");
        parentElement8.setSubElements(new ArrayList<>());
        parentElement8.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        ArrayList<ValoresEjesDeElemenCatalogoUsuario> attributeValuesCollection = new ArrayList<>();
        elementoCatalogo2.setAttributeValuesCollection(attributeValuesCollection);
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(null);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement8);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any()))
                .thenReturn(elementoCatalogoMinimalList);
        when(elementoCatalogoRepository.getByIdWithHistoric(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        ElementoCatalogo actualById = elementoCatalogoService.getById(1);
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getByIdWithHistoric(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertEquals(1, actualById.getSubElements().size());
        assertEquals(attributeValuesCollection, actualById.getAttributeValuesCollection());
        assertSame(elementoCatalogo, actualById);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getDescripcionElemento(String)}
     */
    @Test
    void testGetDescripcionElemento() {
        SimplifiedAttribute simplifiedAttribute = new SimplifiedAttribute("Capp Code", "Attr Name", "42");

        when(elementoCatalogoRepository.getUserValueOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenReturn(simplifiedAttribute);
        SimplifiedAttribute actualDescripcionElemento = elementoCatalogoService.getDescripcionElemento("Codigo");
        verify(elementoCatalogoRepository).getUserValueOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
        assertSame(simplifiedAttribute, actualDescripcionElemento);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getDescripcionElemento(String)}
     */
    @Test
    void testGetDescripcionElemento2() {
        when(elementoCatalogoRepository.getUserValueOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getDescripcionElemento("Codigo"));
        verify(elementoCatalogoRepository).getUserValueOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getCircuitoVidaElementoEP(String)}
     */
    @Test
    void testGetCircuitoVidaElementoEP() {
        SimplifiedAttribute simplifiedAttribute = new SimplifiedAttribute("Capp Code", "Attr Name", "42");

        when(elementoCatalogoRepository.getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenReturn(simplifiedAttribute);
        SimplifiedAttribute actualCircuitoVidaElementoEP = elementoCatalogoService.getCircuitoVidaElementoEP("Codigo");
        verify(elementoCatalogoRepository).getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
        assertSame(simplifiedAttribute, actualCircuitoVidaElementoEP);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getCircuitoVidaElementoEP(String)}
     */
    @Test
    void testGetCircuitoVidaElementoEP2() {
        when(elementoCatalogoRepository.getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getCircuitoVidaElementoEP("Codigo"));
        verify(elementoCatalogoRepository).getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getComponentFormedWith(String)}
     */
    @Test
    void testGetComponentFormedWith() {
        SimplifiedAttribute simplifiedAttribute = new SimplifiedAttribute("Capp Code", "Attr Name", "42");

        when(elementoCatalogoRepository.getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenReturn(simplifiedAttribute);
        SimplifiedAttribute actualComponentFormedWith = elementoCatalogoService.getComponentFormedWith("Codigo");
        verify(elementoCatalogoRepository).getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
        assertSame(simplifiedAttribute, actualComponentFormedWith);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getComponentFormedWith(String)}
     */
    @Test
    void testGetComponentFormedWith2() {
        when(elementoCatalogoRepository.getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getComponentFormedWith("Codigo"));
        verify(elementoCatalogoRepository).getValDominioOfAttr(Mockito.<String>any(), Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByName(String)}
     */
    @Test
    void testGetByName() {
        when(elementoCatalogoRepository.getByNameOptimized(Mockito.<String>any())).thenReturn(new ArrayList<>());
        ElementoCatalogo actualByName = elementoCatalogoService.getByName("Name Of Elemen Cat");
        verify(elementoCatalogoRepository).getByNameOptimized(Mockito.<String>any());
        assertNull(actualByName);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByName(String)}
     */
    @Test
    void testGetByName2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);
        when(elementoCatalogoRepository.getByNameOptimized(Mockito.<String>any())).thenReturn(elementoCatalogoList);
        ElementoCatalogo actualByName = elementoCatalogoService.getByName("Name Of Elemen Cat");
        verify(elementoCatalogoRepository).getByNameOptimized(Mockito.<String>any());
        assertSame(elementoCatalogo, actualByName);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByName(String)}
     */
    @Test
    void testGetByName3() {
        when(elementoCatalogoRepository.getByNameOptimized(Mockito.<String>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getByName("Name Of Elemen Cat"));
        verify(elementoCatalogoRepository).getByNameOptimized(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByCollateralId(Pageable, Integer)}
     */
    @Test
    void testGetByCollateralId() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(new ArrayList<>());
        when(elementoCatalogoRepository.getByDeletedIsNullAndCatalogElementCollateralIdPag(Mockito.<Integer>any(),
                Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Page<ElementoCatalogo> actualByCollateralId = elementoCatalogoService.getByCollateralId(null, 1);
        verify(elementoCatalogoRepository).getByDeletedIsNullAndCatalogElementCollateralIdPag(Mockito.<Integer>any(),
                Mockito.<Pageable>any());
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertTrue(actualByCollateralId.toList().isEmpty());
        assertSame(pageImpl, actualByCollateralId);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByCollateralId(Pageable, Integer)}
     */
    @Test
    void testGetByCollateralId2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getByCollateralId(null, 1));
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByCollateralId(Pageable, Integer)}
     */
    @Test
    void testGetByCollateralId3() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(new ElementoCatalogo());
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> content = new ArrayList<>();
        content.add(elementoCatalogo2);
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(content);

        ElementoCatalogo parentElement8 = new ElementoCatalogo();
        parentElement8.setAttributeValuesCollection(new ArrayList<>());
        parentElement8.setCappCode("Capp Code");
        parentElement8.setCatalogElementCollateralId(1);
        parentElement8.setCatalogElementTypeId(1);
        parentElement8.setCreationDate(mock(Timestamp.class));
        parentElement8.setDeleted(1);
        parentElement8.setDeliveryCollection(new ArrayList<>());
        parentElement8.setGroupId(1);
        parentElement8.setId(1);
        parentElement8.setIncomplete(1);
        parentElement8.setName("Name");
        parentElement8.setParentElement(new ElementoCatalogo());
        parentElement8.setReadOnly(1);
        parentElement8.setRespDevelopmentId(1);
        parentElement8.setRespManagementId(1);
        parentElement8.setResponsableTto("alice.liddell@example.org");
        parentElement8.setSubElements(new ArrayList<>());
        parentElement8.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement9 = new ElementoCatalogo();
        parentElement9.setAttributeValuesCollection(new ArrayList<>());
        parentElement9.setCappCode("Capp Code");
        parentElement9.setCatalogElementCollateralId(1);
        parentElement9.setCatalogElementTypeId(1);
        parentElement9.setCreationDate(mock(Timestamp.class));
        parentElement9.setDeleted(1);
        parentElement9.setDeliveryCollection(new ArrayList<>());
        parentElement9.setGroupId(1);
        parentElement9.setId(1);
        parentElement9.setIncomplete(1);
        parentElement9.setName("Name");
        parentElement9.setParentElement(parentElement8);
        parentElement9.setReadOnly(1);
        parentElement9.setRespDevelopmentId(1);
        parentElement9.setRespManagementId(1);
        parentElement9.setResponsableTto("alice.liddell@example.org");
        parentElement9.setSubElements(new ArrayList<>());
        parentElement9.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement10 = new ElementoCatalogo();
        parentElement10.setAttributeValuesCollection(new ArrayList<>());
        parentElement10.setCappCode("Capp Code");
        parentElement10.setCatalogElementCollateralId(1);
        parentElement10.setCatalogElementTypeId(1);
        parentElement10.setCreationDate(mock(Timestamp.class));
        parentElement10.setDeleted(1);
        parentElement10.setDeliveryCollection(new ArrayList<>());
        parentElement10.setGroupId(1);
        parentElement10.setId(1);
        parentElement10.setIncomplete(1);
        parentElement10.setName("Name");
        parentElement10.setParentElement(parentElement9);
        parentElement10.setReadOnly(1);
        parentElement10.setRespDevelopmentId(1);
        parentElement10.setRespManagementId(1);
        parentElement10.setResponsableTto("alice.liddell@example.org");
        parentElement10.setSubElements(new ArrayList<>());
        parentElement10.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement11 = new ElementoCatalogo();
        parentElement11.setAttributeValuesCollection(new ArrayList<>());
        parentElement11.setCappCode("Capp Code");
        parentElement11.setCatalogElementCollateralId(1);
        parentElement11.setCatalogElementTypeId(1);
        parentElement11.setCreationDate(mock(Timestamp.class));
        parentElement11.setDeleted(1);
        parentElement11.setDeliveryCollection(new ArrayList<>());
        parentElement11.setGroupId(1);
        parentElement11.setId(1);
        parentElement11.setIncomplete(1);
        parentElement11.setName("Name");
        parentElement11.setParentElement(parentElement10);
        parentElement11.setReadOnly(1);
        parentElement11.setRespDevelopmentId(1);
        parentElement11.setRespManagementId(1);
        parentElement11.setResponsableTto("alice.liddell@example.org");
        parentElement11.setSubElements(new ArrayList<>());
        parentElement11.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo3 = new ElementoCatalogo();
        elementoCatalogo3.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo3.setCappCode("Capp Code");
        elementoCatalogo3.setCatalogElementCollateralId(1);
        elementoCatalogo3.setCatalogElementTypeId(1);
        elementoCatalogo3.setCreationDate(mock(Timestamp.class));
        elementoCatalogo3.setDeleted(1);
        elementoCatalogo3.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo3.setGroupId(1);
        elementoCatalogo3.setId(1);
        elementoCatalogo3.setIncomplete(1);
        elementoCatalogo3.setName("Name");
        elementoCatalogo3.setParentElement(parentElement11);
        elementoCatalogo3.setReadOnly(1);
        elementoCatalogo3.setRespDevelopmentId(1);
        elementoCatalogo3.setRespManagementId(1);
        elementoCatalogo3.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo3.setSubElements(new ArrayList<>());
        elementoCatalogo3.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo3);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByDeletedIsNullAndCatalogElementCollateralIdPag(Mockito.<Integer>any(),
                Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Page<ElementoCatalogo> actualByCollateralId = elementoCatalogoService.getByCollateralId(null, 1);
        verify(elementoCatalogoRepository).getByDeletedIsNullAndCatalogElementCollateralIdPag(Mockito.<Integer>any(),
                Mockito.<Pageable>any());
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertEquals(1, actualByCollateralId.toList().size());
        assertSame(pageImpl, actualByCollateralId);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAllByGroupAndType(Grupo, Integer)}
     */
    @Test
    void testGetAllByGroupAndType() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findElementsFromGroupInHierarchy(Mockito.<List<Integer>>any(),
                Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any())).thenReturn(simplifiedElementList);
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());

        Grupo group = new Grupo();
        group.setChildrenIds(new ArrayList<>());
        group.setCodigo("Codigo");
        group.setCreationDate(mock(Timestamp.class));
        group.setDeleted(1);
        group.setId(1);
        group.setName("Name");
        group.setParentGroupId(1);
        group.setParentGroupName("Parent Group Name");
        group.setTipo("Tipo");
        group.setTipoId(1);
        group.setUpdateDate(mock(Timestamp.class));
        List<SimplifiedElement> actualAllByGroupAndType = elementoCatalogoService.getAllByGroupAndType(group, 1);
        verify(elementoCatalogoRepository).findElementsFromGroupInHierarchy(Mockito.<List<Integer>>any(),
                Mockito.<Integer>any(), Mockito.<String>any(), Mockito.<String>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
        assertTrue(actualAllByGroupAndType.isEmpty());
        assertSame(simplifiedElementList, actualAllByGroupAndType);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAllByGroupAndType(Grupo, Integer)}
     */
    @Test
    void testGetAllByGroupAndType2() {
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenThrow(new RuntimeException("cappCode"));

        Grupo group = new Grupo();
        group.setChildrenIds(new ArrayList<>());
        group.setCodigo("Codigo");
        group.setCreationDate(mock(Timestamp.class));
        group.setDeleted(1);
        group.setId(1);
        group.setName("Name");
        group.setParentGroupId(1);
        group.setParentGroupName("Parent Group Name");
        group.setTipo("Tipo");
        group.setTipoId(1);
        group.setUpdateDate(mock(Timestamp.class));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getAllByGroupAndType(group, 1));
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(Pageable, Grupo, List)}
     */
    @Test
    void testGetFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId() {
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(new ArrayList<>());
        when(elementoCatalogoRepository.getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valoresEjesDeElemenCatalogoUsuarioRepository
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any())).thenReturn(10);

        Grupo groupUser = new Grupo();
        groupUser.setChildrenIds(new ArrayList<>());
        groupUser.setCodigo("Codigo");
        groupUser.setCreationDate(mock(Timestamp.class));
        groupUser.setDeleted(1);
        groupUser.setId(1);
        groupUser.setName("Name");
        groupUser.setParentGroupId(1);
        groupUser.setParentGroupName("Parent Group Name");
        groupUser.setTipo("Tipo");
        groupUser.setTipoId(1);
        groupUser.setUpdateDate(mock(Timestamp.class));

        ArrayList<Integer> idsOfTypes = new ArrayList<>();
        idsOfTypes.add(2);
        Page<ElementoCatalogo> actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId = elementoCatalogoService
                .getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(null, groupUser, idsOfTypes);
        verify(elementoCatalogoRepository).getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository)
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
        assertTrue(actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId.toList().isEmpty());
        assertSame(pageImpl, actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(Pageable, Grupo, List)}
     */
    @Test
    void testGetFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId2() {
        when(elementoCatalogoRepository.getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any()))
                .thenReturn(new PageImpl<>(new ArrayList<>()));
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valoresEjesDeElemenCatalogoUsuarioRepository
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("typeId"));

        Grupo groupUser = new Grupo();
        groupUser.setChildrenIds(new ArrayList<>());
        groupUser.setCodigo("Codigo");
        groupUser.setCreationDate(mock(Timestamp.class));
        groupUser.setDeleted(1);
        groupUser.setId(1);
        groupUser.setName("Name");
        groupUser.setParentGroupId(1);
        groupUser.setParentGroupName("Parent Group Name");
        groupUser.setTipo("Tipo");
        groupUser.setTipoId(1);
        groupUser.setUpdateDate(mock(Timestamp.class));

        ArrayList<Integer> idsOfTypes = new ArrayList<>();
        idsOfTypes.add(2);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService
                .getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(null, groupUser, idsOfTypes));
        verify(elementoCatalogoRepository).getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository)
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(Pageable, Grupo, List)}
     */
    @Test
    void testGetFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId3() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("typeId");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("typeId");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("typeId");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("typeId");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("typeId");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("typeId");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("typeId");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("typeId");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> content = new ArrayList<>();
        content.add(elementoCatalogo);
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(content);
        when(elementoCatalogoRepository.getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

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
        when(grupoService.estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any())).thenReturn(true);
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(1);
        when(valoresEjesDeElemenCatalogoUsuarioRepository
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any())).thenReturn(10);

        Grupo groupUser = new Grupo();
        groupUser.setChildrenIds(new ArrayList<>());
        groupUser.setCodigo("Codigo");
        groupUser.setCreationDate(mock(Timestamp.class));
        groupUser.setDeleted(1);
        groupUser.setId(1);
        groupUser.setName("Name");
        groupUser.setParentGroupId(1);
        groupUser.setParentGroupName("Parent Group Name");
        groupUser.setTipo("Tipo");
        groupUser.setTipoId(1);
        groupUser.setUpdateDate(mock(Timestamp.class));

        ArrayList<Integer> idsOfTypes = new ArrayList<>();
        idsOfTypes.add(2);
        Page<ElementoCatalogo> actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId = elementoCatalogoService
                .getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(null, groupUser, idsOfTypes);
        verify(elementoCatalogoRepository).getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository)
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any());
        verify(grupoService).estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any());
        verify(grupoService).getById(Mockito.<Integer>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
        assertEquals(1, actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId.toList().size());
        assertSame(pageImpl, actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(Pageable, Grupo, List)}
     */
    @Test
    void testGetFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId4() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("typeId");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("typeId");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("typeId");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("typeId");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("typeId");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("typeId");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("typeId");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("typeId");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> content = new ArrayList<>();
        content.add(elementoCatalogo);
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(content);
        when(elementoCatalogoRepository.getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenThrow(new RuntimeException("typeId"));
        when(valoresEjesDeElemenCatalogoUsuarioRepository
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any())).thenReturn(10);

        Grupo groupUser = new Grupo();
        groupUser.setChildrenIds(new ArrayList<>());
        groupUser.setCodigo("Codigo");
        groupUser.setCreationDate(mock(Timestamp.class));
        groupUser.setDeleted(1);
        groupUser.setId(1);
        groupUser.setName("Name");
        groupUser.setParentGroupId(1);
        groupUser.setParentGroupName("Parent Group Name");
        groupUser.setTipo("Tipo");
        groupUser.setTipoId(1);
        groupUser.setUpdateDate(mock(Timestamp.class));

        ArrayList<Integer> idsOfTypes = new ArrayList<>();
        idsOfTypes.add(2);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService
                .getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(null, groupUser, idsOfTypes));
        verify(elementoCatalogoRepository).getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository)
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(Pageable, Grupo, List)}
     */
    @Test
    void testGetFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId5() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("typeId");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("typeId");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("typeId");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("typeId");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("typeId");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("typeId");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("typeId");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("typeId");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("groupsId");
        parentElement4.setCatalogElementCollateralId(2);
        parentElement4.setCatalogElementTypeId(2);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(0);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(2);
        parentElement4.setId(2);
        parentElement4.setIncomplete(0);
        parentElement4.setName("groupsId");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(0);
        parentElement4.setRespDevelopmentId(2);
        parentElement4.setRespManagementId(2);
        parentElement4.setResponsableTto("typeId");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("groupsId");
        parentElement5.setCatalogElementCollateralId(2);
        parentElement5.setCatalogElementTypeId(2);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(0);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(2);
        parentElement5.setId(2);
        parentElement5.setIncomplete(0);
        parentElement5.setName("groupsId");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(0);
        parentElement5.setRespDevelopmentId(2);
        parentElement5.setRespManagementId(2);
        parentElement5.setResponsableTto("typeId");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("groupsId");
        parentElement6.setCatalogElementCollateralId(2);
        parentElement6.setCatalogElementTypeId(2);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(0);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(2);
        parentElement6.setId(2);
        parentElement6.setIncomplete(0);
        parentElement6.setName("groupsId");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(0);
        parentElement6.setRespDevelopmentId(2);
        parentElement6.setRespManagementId(2);
        parentElement6.setResponsableTto("typeId");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("groupsId");
        elementoCatalogo2.setCatalogElementCollateralId(2);
        elementoCatalogo2.setCatalogElementTypeId(2);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(0);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(2);
        elementoCatalogo2.setId(2);
        elementoCatalogo2.setIncomplete(0);
        elementoCatalogo2.setName("groupsId");
        elementoCatalogo2.setParentElement(parentElement6);
        elementoCatalogo2.setReadOnly(0);
        elementoCatalogo2.setRespDevelopmentId(2);
        elementoCatalogo2.setRespManagementId(2);
        elementoCatalogo2.setResponsableTto("typeId");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> content = new ArrayList<>();
        content.add(elementoCatalogo2);
        content.add(elementoCatalogo);
        PageImpl<ElementoCatalogo> pageImpl = new PageImpl<>(content);
        when(elementoCatalogoRepository.getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

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
        when(grupoService.estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any())).thenReturn(true);
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(grupoService.getGruposIds(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any())).thenReturn(1);
        when(valoresEjesDeElemenCatalogoUsuarioRepository
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any())).thenReturn(10);

        Grupo groupUser = new Grupo();
        groupUser.setChildrenIds(new ArrayList<>());
        groupUser.setCodigo("Codigo");
        groupUser.setCreationDate(mock(Timestamp.class));
        groupUser.setDeleted(1);
        groupUser.setId(1);
        groupUser.setName("Name");
        groupUser.setParentGroupId(1);
        groupUser.setParentGroupName("Parent Group Name");
        groupUser.setTipo("Tipo");
        groupUser.setTipoId(1);
        groupUser.setUpdateDate(mock(Timestamp.class));

        ArrayList<Integer> idsOfTypes = new ArrayList<>();
        idsOfTypes.add(2);
        Page<ElementoCatalogo> actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId = elementoCatalogoService
                .getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(null, groupUser, idsOfTypes);
        verify(elementoCatalogoRepository).getMinimalInfoForListingForGroups(Mockito.<Map<String, Object>>any(),
                Mockito.<Date>any(), Mockito.<Date>any(), Mockito.<Pageable>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository, atLeast(1)).getMandatoryAttrsIds(Mockito.<Integer>any(),
                Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository)
                .getNumberOfAttrsMandatoryOfThisTypeOfElement(Mockito.<Integer>any());
        verify(grupoService, atLeast(1)).estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any());
        verify(grupoService, atLeast(1)).getById(Mockito.<Integer>any());
        verify(grupoService).getGruposIds(Mockito.<Integer>any());
        assertEquals(2, actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId.toList().size());
        assertSame(pageImpl, actualFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getElementTop(ElementoCatalogo)}
     */
    @Test
    void testGetElementTop() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdWithHistoric(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(new ElementoCatalogo());
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elemCatalogo = new ElementoCatalogo();
        elemCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elemCatalogo.setCappCode("Capp Code");
        elemCatalogo.setCatalogElementCollateralId(1);
        elemCatalogo.setCatalogElementTypeId(1);
        elemCatalogo.setCreationDate(mock(Timestamp.class));
        elemCatalogo.setDeleted(1);
        elemCatalogo.setDeliveryCollection(new ArrayList<>());
        elemCatalogo.setGroupId(1);
        elemCatalogo.setId(1);
        elemCatalogo.setIncomplete(1);
        elemCatalogo.setName("Name");
        elemCatalogo.setParentElement(parentElement7);
        elemCatalogo.setReadOnly(1);
        elemCatalogo.setRespDevelopmentId(1);
        elemCatalogo.setRespManagementId(1);
        elemCatalogo.setResponsableTto("alice.liddell@example.org");
        elemCatalogo.setSubElements(new ArrayList<>());
        elemCatalogo.setUpdateDate(mock(Timestamp.class));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getElementTop(elemCatalogo));
        verify(elementoCatalogoRepository).getByIdWithHistoric(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#actualizar(ElementoCatalogo, Grupo, Grupo)}
     */
    @Test
    void testActualizar() {
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
        when(grupoService.estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any())).thenReturn(true);
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elemenInput = new ElementoCatalogo();
        elemenInput.setAttributeValuesCollection(new ArrayList<>());
        elemenInput.setCappCode("Capp Code");
        elemenInput.setCatalogElementCollateralId(1);
        elemenInput.setCatalogElementTypeId(1);
        elemenInput.setCreationDate(mock(Timestamp.class));
        elemenInput.setDeleted(1);
        elemenInput.setDeliveryCollection(new ArrayList<>());
        elemenInput.setGroupId(1);
        elemenInput.setId(1);
        elemenInput.setIncomplete(1);
        elemenInput.setName("Name");
        elemenInput.setParentElement(parentElement3);
        elemenInput.setReadOnly(1);
        elemenInput.setRespDevelopmentId(1);
        elemenInput.setRespManagementId(1);
        elemenInput.setResponsableTto("alice.liddell@example.org");
        elemenInput.setSubElements(new ArrayList<>());
        elemenInput.setUpdateDate(mock(Timestamp.class));

        Grupo grupoDpto = new Grupo();
        grupoDpto.setChildrenIds(new ArrayList<>());
        grupoDpto.setCodigo("Codigo");
        grupoDpto.setCreationDate(mock(Timestamp.class));
        grupoDpto.setDeleted(1);
        grupoDpto.setId(1);
        grupoDpto.setName("Name");
        grupoDpto.setParentGroupId(1);
        grupoDpto.setParentGroupName("Parent Group Name");
        grupoDpto.setTipo("Tipo");
        grupoDpto.setTipoId(1);
        grupoDpto.setUpdateDate(mock(Timestamp.class));

        Grupo grupoCentroSup = new Grupo();
        grupoCentroSup.setChildrenIds(new ArrayList<>());
        grupoCentroSup.setCodigo("Codigo");
        grupoCentroSup.setCreationDate(mock(Timestamp.class));
        grupoCentroSup.setDeleted(1);
        grupoCentroSup.setId(1);
        grupoCentroSup.setName("Name");
        grupoCentroSup.setParentGroupId(1);
        grupoCentroSup.setParentGroupName("Parent Group Name");
        grupoCentroSup.setTipo("Tipo");
        grupoCentroSup.setTipoId(1);
        grupoCentroSup.setUpdateDate(mock(Timestamp.class));
        Map<ElementoCatalogo, List<ValidationErrorMessage>> actualActualizarResult = elementoCatalogoService
                .actualizar(elemenInput, grupoDpto, grupoCentroSup);
        verify(grupoService, atLeast(1)).estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any());
        verify(grupoService, atLeast(1)).getById(Mockito.<Integer>any());
        assertEquals(1, actualActualizarResult.size());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#actualizar(ElementoCatalogo, Grupo, Grupo)}
     */
    @Test
    void testActualizar2() {
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
        when(grupoService.estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any())).thenReturn(false);
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elemenInput = new ElementoCatalogo();
        elemenInput.setAttributeValuesCollection(new ArrayList<>());
        elemenInput.setCappCode("Capp Code");
        elemenInput.setCatalogElementCollateralId(1);
        elemenInput.setCatalogElementTypeId(1);
        elemenInput.setCreationDate(mock(Timestamp.class));
        elemenInput.setDeleted(1);
        elemenInput.setDeliveryCollection(new ArrayList<>());
        elemenInput.setGroupId(1);
        elemenInput.setId(1);
        elemenInput.setIncomplete(1);
        elemenInput.setName("Name");
        elemenInput.setParentElement(parentElement3);
        elemenInput.setReadOnly(1);
        elemenInput.setRespDevelopmentId(1);
        elemenInput.setRespManagementId(1);
        elemenInput.setResponsableTto("alice.liddell@example.org");
        elemenInput.setSubElements(new ArrayList<>());
        elemenInput.setUpdateDate(mock(Timestamp.class));

        Grupo grupoDpto = new Grupo();
        grupoDpto.setChildrenIds(new ArrayList<>());
        grupoDpto.setCodigo("Codigo");
        grupoDpto.setCreationDate(mock(Timestamp.class));
        grupoDpto.setDeleted(1);
        grupoDpto.setId(1);
        grupoDpto.setName("Name");
        grupoDpto.setParentGroupId(1);
        grupoDpto.setParentGroupName("Parent Group Name");
        grupoDpto.setTipo("Tipo");
        grupoDpto.setTipoId(1);
        grupoDpto.setUpdateDate(mock(Timestamp.class));

        Grupo grupoCentroSup = new Grupo();
        grupoCentroSup.setChildrenIds(new ArrayList<>());
        grupoCentroSup.setCodigo("Codigo");
        grupoCentroSup.setCreationDate(mock(Timestamp.class));
        grupoCentroSup.setDeleted(1);
        grupoCentroSup.setId(1);
        grupoCentroSup.setName("Name");
        grupoCentroSup.setParentGroupId(1);
        grupoCentroSup.setParentGroupName("Parent Group Name");
        grupoCentroSup.setTipo("Tipo");
        grupoCentroSup.setTipoId(1);
        grupoCentroSup.setUpdateDate(mock(Timestamp.class));
        Map<ElementoCatalogo, List<ValidationErrorMessage>> actualActualizarResult = elementoCatalogoService
                .actualizar(elemenInput, grupoDpto, grupoCentroSup);
        verify(grupoService, atLeast(1)).estaContenido(Mockito.<Grupo>any(), Mockito.<Grupo>any());
        verify(grupoService, atLeast(1)).getById(Mockito.<Integer>any());
        assertEquals(1, actualActualizarResult.size());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findSimplifiedElements()).thenReturn(simplifiedElementList);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(new ElementoCatalogoFilter());
        verify(elementoCatalogoRepository).findSimplifiedElements();
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements2() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findFilteredSimplifiedElements(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(simplifiedElementList);

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setIdOfCatalogueElementType(1);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(filter);
        verify(elementoCatalogoRepository).findFilteredSimplifiedElements(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any());
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements3() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findFilteredSimplifiedElements(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any())).thenReturn(simplifiedElementList);

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setCode("Code");
        filter.setIdOfCatalogueElementType(1);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(filter);
        verify(elementoCatalogoRepository).findFilteredSimplifiedElements(Mockito.<Integer>any(), Mockito.<Integer>any(),
                Mockito.<String>any());
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements4() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(simplifiedElementList);

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setComputerProcessingId(1);
        filter.setIdOfCatalogueElementType(1);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(filter);
        verify(elementoCatalogoRepository).findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements5() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(simplifiedElementList);

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setComputerProcessingId(1);
        filter.setIdOfCatalogueElementType(null);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(filter);
        verify(elementoCatalogoRepository).findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements6() {
        ArrayList<SimplifiedElement> simplifiedElementList = new ArrayList<>();
        when(elementoCatalogoRepository.findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any())).thenReturn(simplifiedElementList);

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setGroupId(1);
        filter.setComputerProcessingId(1);
        filter.setIdOfCatalogueElementType(1);
        List<SimplifiedElement> actualFilteredSimplifiedElements = elementoCatalogoService
                .getFilteredSimplifiedElements(filter);
        verify(elementoCatalogoRepository).findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
        assertTrue(actualFilteredSimplifiedElements.isEmpty());
        assertSame(simplifiedElementList, actualFilteredSimplifiedElements);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getFilteredSimplifiedElements(ElementoCatalogoFilter)}
     */
    @Test
    void testGetFilteredSimplifiedElements7() {
        when(elementoCatalogoRepository.findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any())).thenThrow(new RuntimeException("foo"));

        ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setComputerProcessingId(1);
        filter.setIdOfCatalogueElementType(1);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getFilteredSimplifiedElements(filter));
        verify(elementoCatalogoRepository).findFilteredSimplifiedElementsCompProcessing(Mockito.<String>any(),
                Mockito.<Integer>any(), Mockito.<Integer>any(), Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(new ElementoCatalogo());
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement8 = new ElementoCatalogo();
        parentElement8.setAttributeValuesCollection(new ArrayList<>());
        parentElement8.setCappCode("Capp Code");
        parentElement8.setCatalogElementCollateralId(1);
        parentElement8.setCatalogElementTypeId(1);
        parentElement8.setCreationDate(mock(Timestamp.class));
        parentElement8.setDeleted(1);
        parentElement8.setDeliveryCollection(new ArrayList<>());
        parentElement8.setGroupId(1);
        parentElement8.setId(1);
        parentElement8.setIncomplete(1);
        parentElement8.setName("Name");
        parentElement8.setParentElement(parentElement7);
        parentElement8.setReadOnly(1);
        parentElement8.setRespDevelopmentId(1);
        parentElement8.setRespManagementId(1);
        parentElement8.setResponsableTto("alice.liddell@example.org");
        parentElement8.setSubElements(new ArrayList<>());
        parentElement8.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement8);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.save(Mockito.<ElementoCatalogo>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        Map<ElementoCatalogo, List<ValidationErrorMessage>> actualBorradoLogicoResult = elementoCatalogoService
                .borradoLogico(1);
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).save(Mockito.<ElementoCatalogo>any());
        assertEquals(1, actualBorradoLogicoResult.size());
    }

    /**
     * Method under test: {@link ElementoCatalogoService#borradoLogico(Integer)}
     */
    @Test
    void testBorradoLogico2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.borradoLogico(1));
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAxisByElementId(Integer)}
     */
    @Test
    void testGetAxisByElementId() {
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAxisListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        List<ValoresEjesDeElemenCatalogoUsuario> actualAxisByElementId = elementoCatalogoService.getAxisByElementId(1);
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAxisListByIdOfElement(Mockito.<Integer>any());
        assertTrue(actualAxisByElementId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAxisByElementId(Integer)}
     */
    @Test
    void testGetAxisByElementId2() {
        ArrayList<AxisValDomain> axisValDomainList = new ArrayList<>();
        axisValDomainList.add(new AxisValDomain());
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAxisListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(axisValDomainList);
        List<ValoresEjesDeElemenCatalogoUsuario> actualAxisByElementId = elementoCatalogoService.getAxisByElementId(1);
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAxisListByIdOfElement(Mockito.<Integer>any());
        assertEquals(1, actualAxisByElementId.size());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAxisByElementId(Integer)}
     */
    @Test
    void testGetAxisByElementId3() {
        ArrayList<AxisValDomain> axisValDomainList = new ArrayList<>();
        axisValDomainList.add(new AxisValDomain());
        axisValDomainList.add(new AxisValDomain());
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAxisListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(axisValDomainList);
        List<ValoresEjesDeElemenCatalogoUsuario> actualAxisByElementId = elementoCatalogoService.getAxisByElementId(1);
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAxisListByIdOfElement(Mockito.<Integer>any());
        assertEquals(2, actualAxisByElementId.size());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAxisByElementId(Integer)}
     */
    @Test
    void testGetAxisByElementId4() {
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAxisListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getAxisByElementId(1));
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAxisListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAttributesByElementId(Integer)}
     */
    @Test
    void testGetAttributesByElementId() {
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        List<ValoresEjesDeElemenCatalogoUsuario> actualAttributesByElementId = elementoCatalogoService
                .getAttributesByElementId(1);
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertTrue(actualAttributesByElementId.isEmpty());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAttributesByElementId(Integer)}
     */
    @Test
    void testGetAttributesByElementId2() {
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getAttributesByElementId(1));
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getAttributesByElementId(Integer)}
     */
    @Test
    void testGetAttributesByElementId3() {
        AttributeValDomain attributeValDomain = new AttributeValDomain();
        attributeValDomain.setIdAttr(1);

        ArrayList<AttributeValDomain> attributeValDomainList = new ArrayList<>();
        attributeValDomainList.add(attributeValDomain);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(attributeValDomainList);
        List<ValoresEjesDeElemenCatalogoUsuario> actualAttributesByElementId = elementoCatalogoService
                .getAttributesByElementId(1);
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertEquals(1, actualAttributesByElementId.size());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByIdAndDeletedIsNull(Integer)}
     */
    @Test
    void testGetByIdAndDeletedIsNull() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        ArrayList<ElementoCatalogoMinimal> elementoCatalogoMinimalList = new ArrayList<>();
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any()))
                .thenReturn(elementoCatalogoMinimalList);
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        ElementoCatalogo actualByIdAndDeletedIsNull = elementoCatalogoService.getByIdAndDeletedIsNull(1);
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertEquals(elementoCatalogoMinimalList, actualByIdAndDeletedIsNull.getAttributeValuesCollection());
        assertEquals(elementoCatalogoMinimalList, actualByIdAndDeletedIsNull.getSubElements());
        assertSame(elementoCatalogo, actualByIdAndDeletedIsNull);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByIdAndDeletedIsNull(Integer)}
     */
    @Test
    void testGetByIdAndDeletedIsNull2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getByIdAndDeletedIsNull(1));
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#getByIdAndDeletedIsNull(Integer)}
     */
    @Test
    void testGetByIdAndDeletedIsNull3() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(parentElement3);
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(null);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement4);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getByIdAndNotNull(Mockito.<Integer>any())).thenReturn(elementoCatalogo);
        ElementoCatalogo actualByIdAndDeletedIsNull = elementoCatalogoService.getByIdAndDeletedIsNull(1);
        verify(elementoCatalogoRepository).getByIdAndNotNull(Mockito.<Integer>any());
        assertSame(elementoCatalogo, actualByIdAndDeletedIsNull);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByCappCode(String)}
     */
    @Test
    void testGetByCappCode() {
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(new ArrayList<>());
        ElementoCatalogo actualByCappCode = elementoCatalogoService.getByCappCode("Capp Code");
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        assertNull(actualByCappCode);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByCappCode(String)}
     */
    @Test
    void testGetByCappCode2() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        ArrayList<ValoresEjesDeElemenCatalogoUsuario> attributeValuesCollection = new ArrayList<>();
        elementoCatalogo2.setAttributeValuesCollection(attributeValuesCollection);
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());
        ElementoCatalogo actualByCappCode = elementoCatalogoService.getByCappCode("Capp Code");
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        assertNull(actualByCappCode.getDeliveryCollection());
        assertEquals(attributeValuesCollection, actualByCappCode.getAttributeValuesCollection());
        assertEquals(attributeValuesCollection, actualByCappCode.getSubElements());
        assertSame(elementoCatalogo2, actualByCappCode.getParentElement());
        assertSame(elementoCatalogo, actualByCappCode);
    }

    /**
     * Method under test: {@link ElementoCatalogoService#getByCappCode(String)}
     */
    @Test
    void testGetByCappCode3() {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("Capp Code");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("Name");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("Capp Code");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("Name");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("Capp Code");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("Name");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("Capp Code");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("Name");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.getByCappCode("Capp Code"));
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended() throws UnsupportedEncodingException {
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelExtended(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        assertNull(elementFilter.getExcelExtended());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended2() throws UnsupportedEncodingException {
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenThrow(new RuntimeException("U/U"));

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.generateExcelExtended(elementFilter, true));
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended3() throws UnsupportedEncodingException {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(1);
        atributoEje.setAplicaAReleases(1);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(1);
        atributoEje.setAxisAttributeCollateralId(1);
        atributoEje.setCode("U/U");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("42");
        atributoEje.setDeleted(1);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(1);
        atributoEje.setHelp("U/U");
        atributoEje.setHidden(1);
        atributoEje.setId(1);
        atributoEje.setLongDescription(1);
        atributoEje.setMandatory(1);
        atributoEje.setMultiple(1);
        atributoEje.setName("U/U");
        atributoEje.setObservations("U/U");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEjeList);
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelExtended(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        assertNull(elementFilter.getExcelExtended());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended4() throws UnsupportedEncodingException {
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(new ArrayList<>());

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);

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
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelExtended(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        verify(grupoService).getById(Mockito.<Integer>any());
        assertEquals('P', elementFilter.getExcelExtended()[0]);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended5() throws UnsupportedEncodingException {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("U/U"));

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.generateExcelExtended(elementFilter, true));
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelExtended(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelExtended6() throws UnsupportedEncodingException {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(3);
        atributoEje.setAplicaAReleases(3);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(3);
        atributoEje.setAxisAttributeCollateralId(3);
        atributoEje.setCode("\\U");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("/");
        atributoEje.setDeleted(3);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(3);
        atributoEje.setHelp("\\U");
        atributoEje.setHidden(3);
        atributoEje.setId(3);
        atributoEje.setLongDescription(3);
        atributoEje.setMandatory(3);
        atributoEje.setMultiple(3);
        atributoEje.setName("\\U");
        atributoEje.setObservations("\\U");
        atributoEje.setReadOnly(3);
        atributoEje.setRegex("/");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(2);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEjeList);

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);

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
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelExtended(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        verify(grupoService).getById(Mockito.<Integer>any());
        assertEquals('P', elementFilter.getExcelExtended()[0]);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelSummarized(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelSummarized() throws UnsupportedEncodingException {
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelSummarized(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        assertNull(elementFilter.getExcelExtended());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelSummarized(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelSummarized2() throws UnsupportedEncodingException {
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenThrow(new RuntimeException("U/U"));

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.generateExcelSummarized(elementFilter, true));
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelSummarized(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelSummarized3() throws UnsupportedEncodingException {
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(new ArrayList<>());

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);

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
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelSummarized(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        verify(grupoService).getById(Mockito.<Integer>any());
        assertEquals('P', elementFilter.getExcelExtended()[0]);
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelSummarized(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelSummarized4() throws UnsupportedEncodingException {
        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenThrow(new RuntimeException("U/U"));

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        assertThrows(RuntimeException.class, () -> elementoCatalogoService.generateExcelSummarized(elementFilter, true));
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
    }

    /**
     * Method under test:
     * {@link ElementoCatalogoService#generateExcelSummarized(CodigoList, boolean)}
     */
    @Test
    void testGenerateExcelSummarized5() throws UnsupportedEncodingException {
        AtributoEje atributoEje = new AtributoEje();
        atributoEje.setAplicaACatalogo(2);
        atributoEje.setAplicaAReleases(2);
        atributoEje.setAtributosAsociados(new ArrayList<>());
        atributoEje.setAxis(2);
        atributoEje.setAxisAttributeCollateralId(2);
        atributoEje.setCode("/");
        atributoEje.setCreationDate(mock(Timestamp.class));
        atributoEje.setDefaultValue("U/U");
        atributoEje.setDeleted(2);
        atributoEje.setDomainValues(new ArrayList<>());
        atributoEje.setElementypes(new ArrayList<>());
        atributoEje.setFromCapp(2);
        atributoEje.setHelp("/");
        atributoEje.setHidden(2);
        atributoEje.setId(2);
        atributoEje.setLongDescription(2);
        atributoEje.setMandatory(2);
        atributoEje.setMultiple(2);
        atributoEje.setName("/");
        atributoEje.setObservations("/");
        atributoEje.setReadOnly(2);
        atributoEje.setRegex("U/U");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(1);

        ArrayList<AtributoEje> atributoEjeList = new ArrayList<>();
        atributoEjeList.add(atributoEje);
        when(atributoEjeService.getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean())).thenReturn(atributoEjeList);

        ElementoCatalogo parentElement = new ElementoCatalogo();
        parentElement.setAttributeValuesCollection(new ArrayList<>());
        parentElement.setCappCode("U/U");
        parentElement.setCatalogElementCollateralId(1);
        parentElement.setCatalogElementTypeId(1);
        parentElement.setCreationDate(mock(Timestamp.class));
        parentElement.setDeleted(1);
        parentElement.setDeliveryCollection(new ArrayList<>());
        parentElement.setGroupId(1);
        parentElement.setId(1);
        parentElement.setIncomplete(1);
        parentElement.setName("U/U");
        parentElement.setParentElement(new ElementoCatalogo());
        parentElement.setReadOnly(1);
        parentElement.setRespDevelopmentId(1);
        parentElement.setRespManagementId(1);
        parentElement.setResponsableTto("alice.liddell@example.org");
        parentElement.setSubElements(new ArrayList<>());
        parentElement.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement2 = new ElementoCatalogo();
        parentElement2.setAttributeValuesCollection(new ArrayList<>());
        parentElement2.setCappCode("U/U");
        parentElement2.setCatalogElementCollateralId(1);
        parentElement2.setCatalogElementTypeId(1);
        parentElement2.setCreationDate(mock(Timestamp.class));
        parentElement2.setDeleted(1);
        parentElement2.setDeliveryCollection(new ArrayList<>());
        parentElement2.setGroupId(1);
        parentElement2.setId(1);
        parentElement2.setIncomplete(1);
        parentElement2.setName("U/U");
        parentElement2.setParentElement(parentElement);
        parentElement2.setReadOnly(1);
        parentElement2.setRespDevelopmentId(1);
        parentElement2.setRespManagementId(1);
        parentElement2.setResponsableTto("alice.liddell@example.org");
        parentElement2.setSubElements(new ArrayList<>());
        parentElement2.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement3 = new ElementoCatalogo();
        parentElement3.setAttributeValuesCollection(new ArrayList<>());
        parentElement3.setCappCode("U/U");
        parentElement3.setCatalogElementCollateralId(1);
        parentElement3.setCatalogElementTypeId(1);
        parentElement3.setCreationDate(mock(Timestamp.class));
        parentElement3.setDeleted(1);
        parentElement3.setDeliveryCollection(new ArrayList<>());
        parentElement3.setGroupId(1);
        parentElement3.setId(1);
        parentElement3.setIncomplete(1);
        parentElement3.setName("U/U");
        parentElement3.setParentElement(parentElement2);
        parentElement3.setReadOnly(1);
        parentElement3.setRespDevelopmentId(1);
        parentElement3.setRespManagementId(1);
        parentElement3.setResponsableTto("alice.liddell@example.org");
        parentElement3.setSubElements(new ArrayList<>());
        parentElement3.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo = new ElementoCatalogo();
        elementoCatalogo.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo.setCappCode("U/U");
        elementoCatalogo.setCatalogElementCollateralId(1);
        elementoCatalogo.setCatalogElementTypeId(1);
        elementoCatalogo.setCreationDate(mock(Timestamp.class));
        elementoCatalogo.setDeleted(1);
        elementoCatalogo.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo.setGroupId(1);
        elementoCatalogo.setId(1);
        elementoCatalogo.setIncomplete(1);
        elementoCatalogo.setName("U/U");
        elementoCatalogo.setParentElement(parentElement3);
        elementoCatalogo.setReadOnly(1);
        elementoCatalogo.setRespDevelopmentId(1);
        elementoCatalogo.setRespManagementId(1);
        elementoCatalogo.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo.setSubElements(new ArrayList<>());
        elementoCatalogo.setUpdateDate(mock(Timestamp.class));

        ArrayList<ElementoCatalogo> elementoCatalogoList = new ArrayList<>();
        elementoCatalogoList.add(elementoCatalogo);

        ElementoCatalogo parentElement4 = new ElementoCatalogo();
        parentElement4.setAttributeValuesCollection(new ArrayList<>());
        parentElement4.setCappCode("Capp Code");
        parentElement4.setCatalogElementCollateralId(1);
        parentElement4.setCatalogElementTypeId(1);
        parentElement4.setCreationDate(mock(Timestamp.class));
        parentElement4.setDeleted(1);
        parentElement4.setDeliveryCollection(new ArrayList<>());
        parentElement4.setGroupId(1);
        parentElement4.setId(1);
        parentElement4.setIncomplete(1);
        parentElement4.setName("Name");
        parentElement4.setParentElement(new ElementoCatalogo());
        parentElement4.setReadOnly(1);
        parentElement4.setRespDevelopmentId(1);
        parentElement4.setRespManagementId(1);
        parentElement4.setResponsableTto("alice.liddell@example.org");
        parentElement4.setSubElements(new ArrayList<>());
        parentElement4.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement5 = new ElementoCatalogo();
        parentElement5.setAttributeValuesCollection(new ArrayList<>());
        parentElement5.setCappCode("Capp Code");
        parentElement5.setCatalogElementCollateralId(1);
        parentElement5.setCatalogElementTypeId(1);
        parentElement5.setCreationDate(mock(Timestamp.class));
        parentElement5.setDeleted(1);
        parentElement5.setDeliveryCollection(new ArrayList<>());
        parentElement5.setGroupId(1);
        parentElement5.setId(1);
        parentElement5.setIncomplete(1);
        parentElement5.setName("Name");
        parentElement5.setParentElement(parentElement4);
        parentElement5.setReadOnly(1);
        parentElement5.setRespDevelopmentId(1);
        parentElement5.setRespManagementId(1);
        parentElement5.setResponsableTto("alice.liddell@example.org");
        parentElement5.setSubElements(new ArrayList<>());
        parentElement5.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement6 = new ElementoCatalogo();
        parentElement6.setAttributeValuesCollection(new ArrayList<>());
        parentElement6.setCappCode("Capp Code");
        parentElement6.setCatalogElementCollateralId(1);
        parentElement6.setCatalogElementTypeId(1);
        parentElement6.setCreationDate(mock(Timestamp.class));
        parentElement6.setDeleted(1);
        parentElement6.setDeliveryCollection(new ArrayList<>());
        parentElement6.setGroupId(1);
        parentElement6.setId(1);
        parentElement6.setIncomplete(1);
        parentElement6.setName("Name");
        parentElement6.setParentElement(parentElement5);
        parentElement6.setReadOnly(1);
        parentElement6.setRespDevelopmentId(1);
        parentElement6.setRespManagementId(1);
        parentElement6.setResponsableTto("alice.liddell@example.org");
        parentElement6.setSubElements(new ArrayList<>());
        parentElement6.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo parentElement7 = new ElementoCatalogo();
        parentElement7.setAttributeValuesCollection(new ArrayList<>());
        parentElement7.setCappCode("Capp Code");
        parentElement7.setCatalogElementCollateralId(1);
        parentElement7.setCatalogElementTypeId(1);
        parentElement7.setCreationDate(mock(Timestamp.class));
        parentElement7.setDeleted(1);
        parentElement7.setDeliveryCollection(new ArrayList<>());
        parentElement7.setGroupId(1);
        parentElement7.setId(1);
        parentElement7.setIncomplete(1);
        parentElement7.setName("Name");
        parentElement7.setParentElement(parentElement6);
        parentElement7.setReadOnly(1);
        parentElement7.setRespDevelopmentId(1);
        parentElement7.setRespManagementId(1);
        parentElement7.setResponsableTto("alice.liddell@example.org");
        parentElement7.setSubElements(new ArrayList<>());
        parentElement7.setUpdateDate(mock(Timestamp.class));

        ElementoCatalogo elementoCatalogo2 = new ElementoCatalogo();
        elementoCatalogo2.setAttributeValuesCollection(new ArrayList<>());
        elementoCatalogo2.setCappCode("Capp Code");
        elementoCatalogo2.setCatalogElementCollateralId(1);
        elementoCatalogo2.setCatalogElementTypeId(1);
        elementoCatalogo2.setCreationDate(mock(Timestamp.class));
        elementoCatalogo2.setDeleted(1);
        elementoCatalogo2.setDeliveryCollection(new ArrayList<>());
        elementoCatalogo2.setGroupId(1);
        elementoCatalogo2.setId(1);
        elementoCatalogo2.setIncomplete(1);
        elementoCatalogo2.setName("Name");
        elementoCatalogo2.setParentElement(parentElement7);
        elementoCatalogo2.setReadOnly(1);
        elementoCatalogo2.setRespDevelopmentId(1);
        elementoCatalogo2.setRespManagementId(1);
        elementoCatalogo2.setResponsableTto("alice.liddell@example.org");
        elementoCatalogo2.setSubElements(new ArrayList<>());
        elementoCatalogo2.setUpdateDate(mock(Timestamp.class));
        when(elementoCatalogoRepository.getMinimalInfoOfElement(Mockito.<Integer>any())).thenReturn(elementoCatalogo2);
        when(elementoCatalogoRepository.getChildrenOfIdParent(Mockito.<Integer>any())).thenReturn(new ArrayList<>());
        when(elementoCatalogoRepository.getByCappCodeEquals(Mockito.<String>any())).thenReturn(elementoCatalogoList);

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
        when(grupoService.getById(Mockito.<Integer>any())).thenReturn(grupo);
        when(valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(Mockito.<Integer>any()))
                .thenReturn(new ArrayList<>());

        CodigoList elementFilter = new CodigoList();
        elementFilter.setCodigos(new String[]{"Codigos"});
        elementFilter.setExcelExtended("AXAXAXAX".getBytes("UTF-8"));
        elementFilter.setNivelOfCatalogue(1);
        elementoCatalogoService.generateExcelSummarized(elementFilter, true);
        verify(elementoCatalogoRepository).getByCappCodeEquals(Mockito.<String>any());
        verify(elementoCatalogoRepository).getChildrenOfIdParent(Mockito.<Integer>any());
        verify(elementoCatalogoRepository).getMinimalInfoOfElement(Mockito.<Integer>any());
        verify(valoresEjesDeElemenCatalogoUsuarioRepository).getAttributesListByIdOfElement(Mockito.<Integer>any());
        verify(atributoEjeService).getAllCachedAtributos(Mockito.<Integer>any(), anyBoolean());
        verify(grupoService).getById(Mockito.<Integer>any());
        assertEquals('P', elementFilter.getExcelExtended()[0]);
    }
}
