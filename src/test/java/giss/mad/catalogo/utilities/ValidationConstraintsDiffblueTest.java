package giss.mad.catalogo.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.ValorDominioDeAttrElemCat;
import giss.mad.catalogo.model.ValorDominioDeAttrEntrega;
import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;
import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ValidationConstraintsDiffblueTest {
    /**
     * Method under test:
     * {@link ValidationConstraints#convertirANotacionPascal(String)}
     */
    @Test
    void testConvertirANotacionPascal() {
        assertEquals("Input", ValidationConstraints.convertirANotacionPascal("Input"));
        assertEquals("", ValidationConstraints.convertirANotacionPascal(null));
        assertEquals("", ValidationConstraints.convertirANotacionPascal(""));
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#isValidUserValue(String, AtributoEje)}
     */
    @Test
    void testIsValidUserValue() {
        AtributoEje attribute = new AtributoEje();
        attribute.setAplicaACatalogo(1);
        attribute.setAplicaAReleases(1);
        attribute.setAtributosAsociados(new ArrayList<>());
        attribute.setAxis(1);
        attribute.setAxisAttributeCollateralId(1);
        attribute.setCode("Code");
        attribute.setCreationDate(mock(Timestamp.class));
        attribute.setDefaultValue("42");
        attribute.setDeleted(1);
        attribute.setDomainValues(new ArrayList<>());
        attribute.setElementypes(new ArrayList<>());
        attribute.setFromCapp(1);
        attribute.setHelp("Help");
        attribute.setHidden(1);
        attribute.setId(1);
        attribute.setLongDescription(1);
        attribute.setMandatory(1);
        attribute.setMultiple(1);
        attribute.setName("Name");
        attribute.setObservations("Observations");
        attribute.setReadOnly(1);
        attribute.setRegex(".*");
        attribute.setUpdateDate(mock(Timestamp.class));
        attribute.setValuesInDomain(42);
        assertFalse(ValidationConstraints.isValidUserValue("42", attribute));
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#isValidUserValue(String, AtributoEje)}
     */
    @Test
    void testIsValidUserValue2() {
        AtributoEje attribute = new AtributoEje();
        attribute.setAplicaACatalogo(1);
        attribute.setAplicaAReleases(1);
        attribute.setAtributosAsociados(new ArrayList<>());
        attribute.setAxis(1);
        attribute.setAxisAttributeCollateralId(1);
        attribute.setCode("Code");
        attribute.setCreationDate(mock(Timestamp.class));
        attribute.setDefaultValue("42");
        attribute.setDeleted(1);
        attribute.setDomainValues(new ArrayList<>());
        attribute.setElementypes(new ArrayList<>());
        attribute.setFromCapp(1);
        attribute.setHelp("Help");
        attribute.setHidden(1);
        attribute.setId(1);
        attribute.setLongDescription(1);
        attribute.setMandatory(1);
        attribute.setMultiple(1);
        attribute.setName("Name");
        attribute.setObservations("Observations");
        attribute.setReadOnly(1);
        attribute.setRegex(".*");
        attribute.setUpdateDate(mock(Timestamp.class));
        attribute.setValuesInDomain(42);
        assertTrue(ValidationConstraints.isValidUserValue("", attribute));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();
        assertTrue(ValidationConstraints.sonIguales(attrIdsOfPeticion, new ArrayList<>()));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales2() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();
        attrIdsOfPeticion.add(2);
        assertTrue(ValidationConstraints.sonIguales(attrIdsOfPeticion, new ArrayList<>()));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales3() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();
        attrIdsOfPeticion.add(1);
        attrIdsOfPeticion.add(2);
        assertTrue(ValidationConstraints.sonIguales(attrIdsOfPeticion, new ArrayList<>()));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales4() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();

        ArrayList<Integer> attrsForThisType = new ArrayList<>();
        attrsForThisType.add(2);
        assertFalse(ValidationConstraints.sonIguales(attrIdsOfPeticion, attrsForThisType));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales5() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();

        ArrayList<Integer> attrsForThisType = new ArrayList<>();
        attrsForThisType.add(1);
        attrsForThisType.add(2);
        assertFalse(ValidationConstraints.sonIguales(attrIdsOfPeticion, attrsForThisType));
    }

    /**
     * Method under test: {@link ValidationConstraints#sonIguales(List, List)}
     */
    @Test
    void testSonIguales6() {
        ArrayList<Integer> attrIdsOfPeticion = new ArrayList<>();
        attrIdsOfPeticion.add(2);

        ArrayList<Integer> attrsForThisType = new ArrayList<>();
        attrsForThisType.add(2);
        assertTrue(ValidationConstraints.sonIguales(attrIdsOfPeticion, attrsForThisType));
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#getAllIdsAttrOfCollection(List)}
     */
    @Test
    void testGetAllIdsAttrOfCollection() {
        List<Integer> actualAllIdsAttrOfCollection = ValidationConstraints.getAllIdsAttrOfCollection(new ArrayList<>());
        assertTrue(actualAllIdsAttrOfCollection.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#getAllIdsAttrOfCollection(List)}
     */
    @Test
    void testGetAllIdsAttrOfCollection2() {
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

        ArrayList<AtributoEje> atributos = new ArrayList<>();
        atributos.add(atributoEje);
        List<Integer> actualAllIdsAttrOfCollection = ValidationConstraints.getAllIdsAttrOfCollection(atributos);
        assertEquals(1, actualAllIdsAttrOfCollection.size());
        assertEquals(1, actualAllIdsAttrOfCollection.get(0));
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#getAllIdsAttrOfCollection(List)}
     */
    @Test
    void testGetAllIdsAttrOfCollection3() {
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

        AtributoEje atributoEje2 = new AtributoEje();
        atributoEje2.setAplicaACatalogo(0);
        atributoEje2.setAplicaAReleases(0);
        atributoEje2.setAtributosAsociados(new ArrayList<>());
        atributoEje2.setAxis(0);
        atributoEje2.setAxisAttributeCollateralId(2);
        atributoEje2.setCode("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setCreationDate(mock(Timestamp.class));
        atributoEje2.setDefaultValue("Default Value");
        atributoEje2.setDeleted(0);
        atributoEje2.setDomainValues(new ArrayList<>());
        atributoEje2.setElementypes(new ArrayList<>());
        atributoEje2.setFromCapp(0);
        atributoEje2.setHelp("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setHidden(2);
        atributoEje2.setId(2);
        atributoEje2.setLongDescription(0);
        atributoEje2.setMandatory(0);
        atributoEje2.setMultiple(0);
        atributoEje2.setName("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setObservations("giss.mad.catalogo.model.AtributoEje");
        atributoEje2.setReadOnly(0);
        atributoEje2.setRegex("Regex");
        atributoEje2.setUpdateDate(mock(Timestamp.class));
        atributoEje2.setValuesInDomain(1);

        ArrayList<AtributoEje> atributos = new ArrayList<>();
        atributos.add(atributoEje2);
        atributos.add(atributoEje);
        List<Integer> actualAllIdsAttrOfCollection = ValidationConstraints.getAllIdsAttrOfCollection(atributos);
        assertEquals(2, actualAllIdsAttrOfCollection.size());
        assertEquals(1, actualAllIdsAttrOfCollection.get(1));
        assertEquals(2, actualAllIdsAttrOfCollection.get(0));
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: formato inválido de la"
                + " entrada <42>", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat2() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setDomainValues(null);
        value.setAxisAttributeId(null);
        value.setUserValue(null);

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio4 = new ValorDominio();
        valorDominio4.setAttributeName("Attribute Name");
        valorDominio4.setAxisAttributeId(1);
        valorDominio4.setCreationDate(mock(Timestamp.class));
        valorDominio4.setDeleted(1);
        valorDominio4.setDeliveryDomainValues(new ArrayList<>());
        valorDominio4.setElementDomainValues(new ArrayList<>());
        valorDominio4.setForCatalogue(1);
        valorDominio4.setForDelivery(1);
        valorDominio4.setId(1);
        valorDominio4.setMasterDomainValues(new ArrayList<>());
        valorDominio4.setName("Name");
        valorDominio4.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio5 = new ValorDominio();
        valorDominio5.setAttributeName("Attribute Name");
        valorDominio5.setAxisAttributeId(1);
        valorDominio5.setCreationDate(mock(Timestamp.class));
        valorDominio5.setDeleted(1);
        valorDominio5.setDeliveryDomainValues(new ArrayList<>());
        valorDominio5.setElementDomainValues(new ArrayList<>());
        valorDominio5.setForCatalogue(1);
        valorDominio5.setForDelivery(1);
        valorDominio5.setId(1);
        valorDominio5.setMasterDomainValues(new ArrayList<>());
        valorDominio5.setName("Name");
        valorDominio5.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio6 = new ValorDominio();
        valorDominio6.setAttributeName("Attribute Name");
        valorDominio6.setAxisAttributeId(1);
        valorDominio6.setCreationDate(mock(Timestamp.class));
        valorDominio6.setDeleted(1);
        valorDominio6.setDeliveryDomainValues(new ArrayList<>());
        valorDominio6.setElementDomainValues(new ArrayList<>());
        valorDominio6.setForCatalogue(1);
        valorDominio6.setForDelivery(1);
        valorDominio6.setId(1);
        valorDominio6.setMasterDomainValues(new ArrayList<>());
        valorDominio6.setName("Name");
        valorDominio6.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio7 = new ValorDominio();
        valorDominio7.setAttributeName("Attribute Name");
        valorDominio7.setAxisAttributeId(1);
        valorDominio7.setCreationDate(mock(Timestamp.class));
        valorDominio7.setDeleted(1);
        valorDominio7.setDeliveryDomainValues(new ArrayList<>());
        valorDominio7.setElementDomainValues(new ArrayList<>());
        valorDominio7.setForCatalogue(1);
        valorDominio7.setForDelivery(1);
        valorDominio7.setId(1);
        valorDominio7.setMasterDomainValues(new ArrayList<>());
        valorDominio7.setName("Name");
        valorDominio7.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio8 = new ValorDominio();
        valorDominio8.setAttributeName("Attribute Name");
        valorDominio8.setAxisAttributeId(1);
        valorDominio8.setCreationDate(mock(Timestamp.class));
        valorDominio8.setDeleted(1);
        valorDominio8.setDeliveryDomainValues(new ArrayList<>());
        valorDominio8.setElementDomainValues(new ArrayList<>());
        valorDominio8.setForCatalogue(1);
        valorDominio8.setForDelivery(1);
        valorDominio8.setId(1);
        valorDominio8.setMasterDomainValues(new ArrayList<>());
        valorDominio8.setName("Name");
        valorDominio8.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio9 = new ValorDominio();
        valorDominio9.setAttributeName("Attribute Name");
        valorDominio9.setAxisAttributeId(1);
        valorDominio9.setCreationDate(mock(Timestamp.class));
        valorDominio9.setDeleted(1);
        valorDominio9.setDeliveryDomainValues(new ArrayList<>());
        valorDominio9.setElementDomainValues(new ArrayList<>());
        valorDominio9.setForCatalogue(1);
        valorDominio9.setForDelivery(1);
        valorDominio9.setId(1);
        valorDominio9.setMasterDomainValues(new ArrayList<>());
        valorDominio9.setName("Name");
        valorDominio9.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio10 = new ValorDominio();
        valorDominio10.setAttributeName("Attribute Name");
        valorDominio10.setAxisAttributeId(1);
        valorDominio10.setCreationDate(mock(Timestamp.class));
        valorDominio10.setDeleted(1);
        valorDominio10.setDeliveryDomainValues(new ArrayList<>());
        valorDominio10.setElementDomainValues(new ArrayList<>());
        valorDominio10.setForCatalogue(1);
        valorDominio10.setForDelivery(1);
        valorDominio10.setId(1);
        valorDominio10.setMasterDomainValues(new ArrayList<>());
        valorDominio10.setName("Name");
        valorDominio10.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio11 = new ValorDominio();
        valorDominio11.setAttributeName("Attribute Name");
        valorDominio11.setAxisAttributeId(1);
        valorDominio11.setCreationDate(mock(Timestamp.class));
        valorDominio11.setDeleted(1);
        valorDominio11.setDeliveryDomainValues(new ArrayList<>());
        valorDominio11.setElementDomainValues(new ArrayList<>());
        valorDominio11.setForCatalogue(1);
        valorDominio11.setForDelivery(1);
        valorDominio11.setId(1);
        valorDominio11.setMasterDomainValues(new ArrayList<>());
        valorDominio11.setName("Name");
        valorDominio11.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio12 = new ValorDominio();
        valorDominio12.setAttributeName("Attribute Name");
        valorDominio12.setAxisAttributeId(1);
        valorDominio12.setCreationDate(mock(Timestamp.class));
        valorDominio12.setDeleted(1);
        valorDominio12.setDeliveryDomainValues(new ArrayList<>());
        valorDominio12.setElementDomainValues(new ArrayList<>());
        valorDominio12.setForCatalogue(1);
        valorDominio12.setForDelivery(1);
        valorDominio12.setId(1);
        valorDominio12.setMasterDomainValues(new ArrayList<>());
        valorDominio12.setName("Name");
        valorDominio12.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio13 = new ValorDominio();
        valorDominio13.setAttributeName("Attribute Name");
        valorDominio13.setAxisAttributeId(1);
        valorDominio13.setCreationDate(mock(Timestamp.class));
        valorDominio13.setDeleted(1);
        valorDominio13.setDeliveryDomainValues(new ArrayList<>());
        valorDominio13.setElementDomainValues(new ArrayList<>());
        valorDominio13.setForCatalogue(1);
        valorDominio13.setForDelivery(1);
        valorDominio13.setId(1);
        valorDominio13.setMasterDomainValues(new ArrayList<>());
        valorDominio13.setName("Name");
        valorDominio13.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio14 = new ValorDominio();
        valorDominio14.setAttributeName("Attribute Name");
        valorDominio14.setAxisAttributeId(1);
        valorDominio14.setCreationDate(mock(Timestamp.class));
        valorDominio14.setDeleted(1);
        valorDominio14.setDeliveryDomainValues(new ArrayList<>());
        valorDominio14.setElementDomainValues(new ArrayList<>());
        valorDominio14.setForCatalogue(1);
        valorDominio14.setForDelivery(1);
        valorDominio14.setId(1);
        valorDominio14.setMasterDomainValues(new ArrayList<>());
        valorDominio14.setName("Name");
        valorDominio14.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio15 = new ValorDominio();
        valorDominio15.setAttributeName("Attribute Name");
        valorDominio15.setAxisAttributeId(1);
        valorDominio15.setCreationDate(mock(Timestamp.class));
        valorDominio15.setDeleted(1);
        valorDominio15.setDeliveryDomainValues(new ArrayList<>());
        valorDominio15.setElementDomainValues(new ArrayList<>());
        valorDominio15.setForCatalogue(1);
        valorDominio15.setForDelivery(1);
        valorDominio15.setId(1);
        valorDominio15.setMasterDomainValues(new ArrayList<>());
        valorDominio15.setName("Name");
        valorDominio15.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio16 = new ValorDominio();
        valorDominio16.setAttributeName("Attribute Name");
        valorDominio16.setAxisAttributeId(1);
        valorDominio16.setCreationDate(mock(Timestamp.class));
        valorDominio16.setDeleted(1);
        valorDominio16.setDeliveryDomainValues(new ArrayList<>());
        valorDominio16.setElementDomainValues(new ArrayList<>());
        valorDominio16.setForCatalogue(1);
        valorDominio16.setForDelivery(1);
        valorDominio16.setId(1);
        valorDominio16.setMasterDomainValues(new ArrayList<>());
        valorDominio16.setName("Name");
        valorDominio16.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio17 = new ValorDominio();
        valorDominio17.setAttributeName("Attribute Name");
        valorDominio17.setAxisAttributeId(1);
        valorDominio17.setCreationDate(mock(Timestamp.class));
        valorDominio17.setDeleted(1);
        valorDominio17.setDeliveryDomainValues(new ArrayList<>());
        valorDominio17.setElementDomainValues(new ArrayList<>());
        valorDominio17.setForCatalogue(1);
        valorDominio17.setForDelivery(1);
        valorDominio17.setId(1);
        valorDominio17.setMasterDomainValues(new ArrayList<>());
        valorDominio17.setName("Name");
        valorDominio17.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio18 = new ValorDominio();
        valorDominio18.setAttributeName("Attribute Name");
        valorDominio18.setAxisAttributeId(1);
        valorDominio18.setCreationDate(mock(Timestamp.class));
        valorDominio18.setDeleted(1);
        valorDominio18.setDeliveryDomainValues(new ArrayList<>());
        valorDominio18.setElementDomainValues(new ArrayList<>());
        valorDominio18.setForCatalogue(1);
        valorDominio18.setForDelivery(1);
        valorDominio18.setId(1);
        valorDominio18.setMasterDomainValues(new ArrayList<>());
        valorDominio18.setName("Name");
        valorDominio18.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues = new ArrayList<>();
        domainValues.add(valorDominio);
        domainValues.add(valorDominio2);
        domainValues.add(valorDominio3);
        domainValues.add(valorDominio4);
        domainValues.add(valorDominio5);
        domainValues.add(valorDominio6);
        domainValues.add(valorDominio7);
        domainValues.add(valorDominio8);
        domainValues.add(valorDominio9);
        domainValues.add(valorDominio10);
        domainValues.add(valorDominio11);
        domainValues.add(valorDominio12);
        domainValues.add(valorDominio13);
        domainValues.add(valorDominio14);
        domainValues.add(valorDominio15);
        domainValues.add(valorDominio16);
        domainValues.add(valorDominio17);
        domainValues.add(valorDominio18);

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
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        atributoEje.setRegex(null);
        atributoEje.setDomainValues(domainValues);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición  en el campo [Name], causa: valor de dominio sin id"
                + " atributo", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat3() {
        ValorDominioDeAttrElemCat valorDominioDeAttrElemCat = new ValorDominioDeAttrElemCat();
        valorDominioDeAttrElemCat.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setDeleted(1);
        valorDominioDeAttrElemCat.setDomainValueId(1);
        valorDominioDeAttrElemCat.setId(1);
        valorDominioDeAttrElemCat.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setValorEjeElemCatId(1);

        ArrayList<ValorDominioDeAttrElemCat> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrElemCat);

        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: formato inválido de la"
                + " entrada <42>", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat4() {
        ValorDominioDeAttrElemCat valorDominioDeAttrElemCat = new ValorDominioDeAttrElemCat();
        valorDominioDeAttrElemCat.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setDeleted(1);
        valorDominioDeAttrElemCat.setDomainValueId(null);
        valorDominioDeAttrElemCat.setId(1);
        valorDominioDeAttrElemCat.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setValorEjeElemCatId(1);

        ArrayList<ValorDominioDeAttrElemCat> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrElemCat);

        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: formato inválido de la"
                + " entrada <42>", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat5() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals(
                "Violación de integridad de datos en la petición  en el campo [Name], causa: el valor para este no puede"
                        + " ser vacío",
                actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat6() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue(null);

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals(
                "Violación de integridad de datos en la petición  en el campo [Name], causa: el valor para este no puede"
                        + " ser vacío",
                actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat7() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        atributoEje.setMandatory(17);
        atributoEje.setMultiple(1);
        atributoEje.setName("Name");
        atributoEje.setObservations("Observations");
        atributoEje.setReadOnly(1);
        atributoEje.setRegex(".*");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: formato inválido de la"
                + " entrada <42>", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat8() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        atributoEje.setRegex("");
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertTrue(actualValidateAttributeSelectedUserElemCatResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat9() {
        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        atributoEje.setRegex(null);
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertTrue(actualValidateAttributeSelectedUserElemCatResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserElemCat(ValoresEjesDeElemenCatalogoUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserElemCat10() {
        ValorDominioDeAttrElemCat valorDominioDeAttrElemCat = new ValorDominioDeAttrElemCat();
        valorDominioDeAttrElemCat.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setDeleted(1);
        valorDominioDeAttrElemCat.setDomainValueId(1);
        valorDominioDeAttrElemCat.setId(1);
        valorDominioDeAttrElemCat.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrElemCat.setValorEjeElemCatId(1);

        ArrayList<ValorDominioDeAttrElemCat> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrElemCat);

        ValoresEjesDeElemenCatalogoUsuario value = new ValoresEjesDeElemenCatalogoUsuario();
        value.setAxisAttributeId(1);
        value.setCatalogElementId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue(null);

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserElemCatResult = ValidationConstraints
                .validateAttributeSelectedUserElemCat(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserElemCatResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: se ha intentado grabar el"
                + " identificador (1) no reconocido", actualValidateAttributeSelectedUserElemCatResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease() {
        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setDomainValues(null);
        value.setAxisAttributeId(null);
        value.setUserValue(null);

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("Attribute Name");
        valorDominio.setAxisAttributeId(1);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(1);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(1);
        valorDominio.setForDelivery(1);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("Name");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio2 = new ValorDominio();
        valorDominio2.setAttributeName("Attribute Name");
        valorDominio2.setAxisAttributeId(1);
        valorDominio2.setCreationDate(mock(Timestamp.class));
        valorDominio2.setDeleted(1);
        valorDominio2.setDeliveryDomainValues(new ArrayList<>());
        valorDominio2.setElementDomainValues(new ArrayList<>());
        valorDominio2.setForCatalogue(1);
        valorDominio2.setForDelivery(1);
        valorDominio2.setId(1);
        valorDominio2.setMasterDomainValues(new ArrayList<>());
        valorDominio2.setName("Name");
        valorDominio2.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio3 = new ValorDominio();
        valorDominio3.setAttributeName("Attribute Name");
        valorDominio3.setAxisAttributeId(1);
        valorDominio3.setCreationDate(mock(Timestamp.class));
        valorDominio3.setDeleted(1);
        valorDominio3.setDeliveryDomainValues(new ArrayList<>());
        valorDominio3.setElementDomainValues(new ArrayList<>());
        valorDominio3.setForCatalogue(1);
        valorDominio3.setForDelivery(1);
        valorDominio3.setId(1);
        valorDominio3.setMasterDomainValues(new ArrayList<>());
        valorDominio3.setName("Name");
        valorDominio3.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio4 = new ValorDominio();
        valorDominio4.setAttributeName("Attribute Name");
        valorDominio4.setAxisAttributeId(1);
        valorDominio4.setCreationDate(mock(Timestamp.class));
        valorDominio4.setDeleted(1);
        valorDominio4.setDeliveryDomainValues(new ArrayList<>());
        valorDominio4.setElementDomainValues(new ArrayList<>());
        valorDominio4.setForCatalogue(1);
        valorDominio4.setForDelivery(1);
        valorDominio4.setId(1);
        valorDominio4.setMasterDomainValues(new ArrayList<>());
        valorDominio4.setName("Name");
        valorDominio4.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio5 = new ValorDominio();
        valorDominio5.setAttributeName("Attribute Name");
        valorDominio5.setAxisAttributeId(1);
        valorDominio5.setCreationDate(mock(Timestamp.class));
        valorDominio5.setDeleted(1);
        valorDominio5.setDeliveryDomainValues(new ArrayList<>());
        valorDominio5.setElementDomainValues(new ArrayList<>());
        valorDominio5.setForCatalogue(1);
        valorDominio5.setForDelivery(1);
        valorDominio5.setId(1);
        valorDominio5.setMasterDomainValues(new ArrayList<>());
        valorDominio5.setName("Name");
        valorDominio5.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio6 = new ValorDominio();
        valorDominio6.setAttributeName("Attribute Name");
        valorDominio6.setAxisAttributeId(1);
        valorDominio6.setCreationDate(mock(Timestamp.class));
        valorDominio6.setDeleted(1);
        valorDominio6.setDeliveryDomainValues(new ArrayList<>());
        valorDominio6.setElementDomainValues(new ArrayList<>());
        valorDominio6.setForCatalogue(1);
        valorDominio6.setForDelivery(1);
        valorDominio6.setId(1);
        valorDominio6.setMasterDomainValues(new ArrayList<>());
        valorDominio6.setName("Name");
        valorDominio6.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio7 = new ValorDominio();
        valorDominio7.setAttributeName("Attribute Name");
        valorDominio7.setAxisAttributeId(1);
        valorDominio7.setCreationDate(mock(Timestamp.class));
        valorDominio7.setDeleted(1);
        valorDominio7.setDeliveryDomainValues(new ArrayList<>());
        valorDominio7.setElementDomainValues(new ArrayList<>());
        valorDominio7.setForCatalogue(1);
        valorDominio7.setForDelivery(1);
        valorDominio7.setId(1);
        valorDominio7.setMasterDomainValues(new ArrayList<>());
        valorDominio7.setName("Name");
        valorDominio7.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio8 = new ValorDominio();
        valorDominio8.setAttributeName("Attribute Name");
        valorDominio8.setAxisAttributeId(1);
        valorDominio8.setCreationDate(mock(Timestamp.class));
        valorDominio8.setDeleted(1);
        valorDominio8.setDeliveryDomainValues(new ArrayList<>());
        valorDominio8.setElementDomainValues(new ArrayList<>());
        valorDominio8.setForCatalogue(1);
        valorDominio8.setForDelivery(1);
        valorDominio8.setId(1);
        valorDominio8.setMasterDomainValues(new ArrayList<>());
        valorDominio8.setName("Name");
        valorDominio8.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio9 = new ValorDominio();
        valorDominio9.setAttributeName("Attribute Name");
        valorDominio9.setAxisAttributeId(1);
        valorDominio9.setCreationDate(mock(Timestamp.class));
        valorDominio9.setDeleted(1);
        valorDominio9.setDeliveryDomainValues(new ArrayList<>());
        valorDominio9.setElementDomainValues(new ArrayList<>());
        valorDominio9.setForCatalogue(1);
        valorDominio9.setForDelivery(1);
        valorDominio9.setId(1);
        valorDominio9.setMasterDomainValues(new ArrayList<>());
        valorDominio9.setName("Name");
        valorDominio9.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio10 = new ValorDominio();
        valorDominio10.setAttributeName("Attribute Name");
        valorDominio10.setAxisAttributeId(1);
        valorDominio10.setCreationDate(mock(Timestamp.class));
        valorDominio10.setDeleted(1);
        valorDominio10.setDeliveryDomainValues(new ArrayList<>());
        valorDominio10.setElementDomainValues(new ArrayList<>());
        valorDominio10.setForCatalogue(1);
        valorDominio10.setForDelivery(1);
        valorDominio10.setId(1);
        valorDominio10.setMasterDomainValues(new ArrayList<>());
        valorDominio10.setName("Name");
        valorDominio10.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio11 = new ValorDominio();
        valorDominio11.setAttributeName("Attribute Name");
        valorDominio11.setAxisAttributeId(1);
        valorDominio11.setCreationDate(mock(Timestamp.class));
        valorDominio11.setDeleted(1);
        valorDominio11.setDeliveryDomainValues(new ArrayList<>());
        valorDominio11.setElementDomainValues(new ArrayList<>());
        valorDominio11.setForCatalogue(1);
        valorDominio11.setForDelivery(1);
        valorDominio11.setId(1);
        valorDominio11.setMasterDomainValues(new ArrayList<>());
        valorDominio11.setName("Name");
        valorDominio11.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio12 = new ValorDominio();
        valorDominio12.setAttributeName("Attribute Name");
        valorDominio12.setAxisAttributeId(1);
        valorDominio12.setCreationDate(mock(Timestamp.class));
        valorDominio12.setDeleted(1);
        valorDominio12.setDeliveryDomainValues(new ArrayList<>());
        valorDominio12.setElementDomainValues(new ArrayList<>());
        valorDominio12.setForCatalogue(1);
        valorDominio12.setForDelivery(1);
        valorDominio12.setId(1);
        valorDominio12.setMasterDomainValues(new ArrayList<>());
        valorDominio12.setName("Name");
        valorDominio12.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio13 = new ValorDominio();
        valorDominio13.setAttributeName("Attribute Name");
        valorDominio13.setAxisAttributeId(1);
        valorDominio13.setCreationDate(mock(Timestamp.class));
        valorDominio13.setDeleted(1);
        valorDominio13.setDeliveryDomainValues(new ArrayList<>());
        valorDominio13.setElementDomainValues(new ArrayList<>());
        valorDominio13.setForCatalogue(1);
        valorDominio13.setForDelivery(1);
        valorDominio13.setId(1);
        valorDominio13.setMasterDomainValues(new ArrayList<>());
        valorDominio13.setName("Name");
        valorDominio13.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio14 = new ValorDominio();
        valorDominio14.setAttributeName("Attribute Name");
        valorDominio14.setAxisAttributeId(1);
        valorDominio14.setCreationDate(mock(Timestamp.class));
        valorDominio14.setDeleted(1);
        valorDominio14.setDeliveryDomainValues(new ArrayList<>());
        valorDominio14.setElementDomainValues(new ArrayList<>());
        valorDominio14.setForCatalogue(1);
        valorDominio14.setForDelivery(1);
        valorDominio14.setId(1);
        valorDominio14.setMasterDomainValues(new ArrayList<>());
        valorDominio14.setName("Name");
        valorDominio14.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio15 = new ValorDominio();
        valorDominio15.setAttributeName("Attribute Name");
        valorDominio15.setAxisAttributeId(1);
        valorDominio15.setCreationDate(mock(Timestamp.class));
        valorDominio15.setDeleted(1);
        valorDominio15.setDeliveryDomainValues(new ArrayList<>());
        valorDominio15.setElementDomainValues(new ArrayList<>());
        valorDominio15.setForCatalogue(1);
        valorDominio15.setForDelivery(1);
        valorDominio15.setId(1);
        valorDominio15.setMasterDomainValues(new ArrayList<>());
        valorDominio15.setName("Name");
        valorDominio15.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio16 = new ValorDominio();
        valorDominio16.setAttributeName("Attribute Name");
        valorDominio16.setAxisAttributeId(1);
        valorDominio16.setCreationDate(mock(Timestamp.class));
        valorDominio16.setDeleted(1);
        valorDominio16.setDeliveryDomainValues(new ArrayList<>());
        valorDominio16.setElementDomainValues(new ArrayList<>());
        valorDominio16.setForCatalogue(1);
        valorDominio16.setForDelivery(1);
        valorDominio16.setId(1);
        valorDominio16.setMasterDomainValues(new ArrayList<>());
        valorDominio16.setName("Name");
        valorDominio16.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio17 = new ValorDominio();
        valorDominio17.setAttributeName("Attribute Name");
        valorDominio17.setAxisAttributeId(1);
        valorDominio17.setCreationDate(mock(Timestamp.class));
        valorDominio17.setDeleted(1);
        valorDominio17.setDeliveryDomainValues(new ArrayList<>());
        valorDominio17.setElementDomainValues(new ArrayList<>());
        valorDominio17.setForCatalogue(1);
        valorDominio17.setForDelivery(1);
        valorDominio17.setId(1);
        valorDominio17.setMasterDomainValues(new ArrayList<>());
        valorDominio17.setName("Name");
        valorDominio17.setUpdateDate(mock(Timestamp.class));

        ValorDominio valorDominio18 = new ValorDominio();
        valorDominio18.setAttributeName("Attribute Name");
        valorDominio18.setAxisAttributeId(1);
        valorDominio18.setCreationDate(mock(Timestamp.class));
        valorDominio18.setDeleted(1);
        valorDominio18.setDeliveryDomainValues(new ArrayList<>());
        valorDominio18.setElementDomainValues(new ArrayList<>());
        valorDominio18.setForCatalogue(1);
        valorDominio18.setForDelivery(1);
        valorDominio18.setId(1);
        valorDominio18.setMasterDomainValues(new ArrayList<>());
        valorDominio18.setName("Name");
        valorDominio18.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues = new ArrayList<>();
        domainValues.add(valorDominio);
        domainValues.add(valorDominio2);
        domainValues.add(valorDominio3);
        domainValues.add(valorDominio4);
        domainValues.add(valorDominio5);
        domainValues.add(valorDominio6);
        domainValues.add(valorDominio7);
        domainValues.add(valorDominio8);
        domainValues.add(valorDominio9);
        domainValues.add(valorDominio10);
        domainValues.add(valorDominio11);
        domainValues.add(valorDominio12);
        domainValues.add(valorDominio13);
        domainValues.add(valorDominio14);
        domainValues.add(valorDominio15);
        domainValues.add(valorDominio16);
        domainValues.add(valorDominio17);
        domainValues.add(valorDominio18);

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
        atributoEje.setUpdateDate(mock(Timestamp.class));
        atributoEje.setValuesInDomain(42);
        atributoEje.setRegex(null);
        atributoEje.setDomainValues(domainValues);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserReleaseResult.size());
        assertEquals("Violación de integridad de datos en la petición  en el campo [Name], causa: valor de dominio sin id"
                + " atributo", actualValidateAttributeSelectedUserReleaseResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease2() {
        ValorDominioDeAttrEntrega valorDominioDeAttrEntrega = new ValorDominioDeAttrEntrega();
        valorDominioDeAttrEntrega.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setDeleted(1);
        valorDominioDeAttrEntrega.setDomainValueId(1);
        valorDominioDeAttrEntrega.setId(1);
        valorDominioDeAttrEntrega.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setValorEjeEntregaId(1);

        ArrayList<ValorDominioDeAttrEntrega> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrEntrega);

        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setAxisAttributeId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserReleaseResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: se ha intentado grabar el"
                + " identificador (1) no reconocido", actualValidateAttributeSelectedUserReleaseResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease3() {
        ValorDominioDeAttrEntrega valorDominioDeAttrEntrega = new ValorDominioDeAttrEntrega();
        valorDominioDeAttrEntrega.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setDeleted(1);
        valorDominioDeAttrEntrega.setDomainValueId(null);
        valorDominioDeAttrEntrega.setId(1);
        valorDominioDeAttrEntrega.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setValorEjeEntregaId(1);

        ArrayList<ValorDominioDeAttrEntrega> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrEntrega);

        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setAxisAttributeId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertTrue(actualValidateAttributeSelectedUserReleaseResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease4() {
        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setAxisAttributeId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setDomainValues(new ArrayList<>());
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

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
        atributoEje.setValuesInDomain(0);
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertTrue(actualValidateAttributeSelectedUserReleaseResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease5() {
        ValorDominioDeAttrEntrega valorDominioDeAttrEntrega = new ValorDominioDeAttrEntrega();
        valorDominioDeAttrEntrega.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setDeleted(1);
        valorDominioDeAttrEntrega.setDomainValueId(1);
        valorDominioDeAttrEntrega.setId(1);
        valorDominioDeAttrEntrega.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setValorEjeEntregaId(1);

        ArrayList<ValorDominioDeAttrEntrega> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrEntrega);

        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setAxisAttributeId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("giss.mad.catalogo.model.ValorDominio");
        valorDominio.setAxisAttributeId(2);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(42);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(42);
        valorDominio.setForDelivery(42);
        valorDominio.setId(2);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("giss.mad.catalogo.model.ValorDominio");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues2 = new ArrayList<>();
        domainValues2.add(valorDominio);

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
        atributoEje.setDomainValues(domainValues2);
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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertEquals(1, actualValidateAttributeSelectedUserReleaseResult.size());
        assertEquals("Violación de integridad de datos en la petición en el campo [Name], causa: se ha intentado grabar el"
                + " identificador (1) no reconocido", actualValidateAttributeSelectedUserReleaseResult.get(0).getMessage());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#validateAttributeSelectedUserRelease(ValoresEjesDeEntregaUsuario, AtributoEje)}
     */
    @Test
    void testValidateAttributeSelectedUserRelease6() {
        ValorDominioDeAttrEntrega valorDominioDeAttrEntrega = new ValorDominioDeAttrEntrega();
        valorDominioDeAttrEntrega.setCreationDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setDeleted(1);
        valorDominioDeAttrEntrega.setDomainValueId(1);
        valorDominioDeAttrEntrega.setId(1);
        valorDominioDeAttrEntrega.setUpdateDate(mock(Timestamp.class));
        valorDominioDeAttrEntrega.setValorEjeEntregaId(1);

        ArrayList<ValorDominioDeAttrEntrega> domainValues = new ArrayList<>();
        domainValues.add(valorDominioDeAttrEntrega);

        ValoresEjesDeEntregaUsuario value = new ValoresEjesDeEntregaUsuario();
        value.setAxisAttributeId(1);
        value.setCreationDate(mock(Timestamp.class));
        value.setDeleted(1);
        value.setDeliveryCatalogElementId(1);
        value.setDomainValues(domainValues);
        value.setId(1);
        value.setUpdateDate(mock(Timestamp.class));
        value.setUserValue("42");

        ValorDominio valorDominio = new ValorDominio();
        valorDominio.setAttributeName("giss.mad.catalogo.model.ValorDominio");
        valorDominio.setAxisAttributeId(2);
        valorDominio.setCreationDate(mock(Timestamp.class));
        valorDominio.setDeleted(42);
        valorDominio.setDeliveryDomainValues(new ArrayList<>());
        valorDominio.setElementDomainValues(new ArrayList<>());
        valorDominio.setForCatalogue(42);
        valorDominio.setForDelivery(42);
        valorDominio.setId(1);
        valorDominio.setMasterDomainValues(new ArrayList<>());
        valorDominio.setName("giss.mad.catalogo.model.ValorDominio");
        valorDominio.setUpdateDate(mock(Timestamp.class));

        ArrayList<ValorDominio> domainValues2 = new ArrayList<>();
        domainValues2.add(valorDominio);

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
        atributoEje.setDomainValues(domainValues2);
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
        List<ValidationErrorMessage> actualValidateAttributeSelectedUserReleaseResult = ValidationConstraints
                .validateAttributeSelectedUserRelease(value, atributoEje);
        assertTrue(actualValidateAttributeSelectedUserReleaseResult.isEmpty());
    }

    /**
     * Method under test:
     * {@link ValidationConstraints#isValidNameAndVersion(String)}
     */
    @Test
    void testIsValidNameAndVersion() {
        assertFalse(ValidationConstraints.isValidNameAndVersion("1.0.2"));
        assertTrue(ValidationConstraints.isValidNameAndVersion("UUUUUU-99.99.99"));
    }
}
