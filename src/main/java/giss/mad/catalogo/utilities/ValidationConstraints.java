package giss.mad.catalogo.utilities;

import giss.mad.catalogo.exception.ValidationErrorMessage;
import giss.mad.catalogo.model.ValorDominioDeAttrElemCat;
import giss.mad.catalogo.model.ValorDominioDeAttrEntrega;
import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;
import giss.mad.catalogo.model.ValoresEjesDeEntregaUsuario;
import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ValorDominio;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidationConstraints {

    private ValidationConstraints() {

    }
    public static String convertirANotacionPascal(final String input) {
        StringBuilder retorno = new StringBuilder();
        if (input != null && !input.isEmpty()) {
            // Convertir la primera letra a mayúscula y el resto a minúsculas
            retorno.append(input.substring(0, 1).toUpperCase());
            retorno.append(input.substring(1).toLowerCase());
        }
        return retorno.toString();
    }

    public static boolean isValidUserValue(final String userValue, final AtributoEje attribute) {
        String regex = "^".concat(attribute.getRegex().substring(1));
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(userValue);
        return matcher.matches();
    }

    public static boolean sonIguales(final List<Integer> attrIdsOfPeticion, final List<Integer> attrsForThisType) {
        List<Integer> attrIdsOfPeticionComparar = new ArrayList<>();
        attrIdsOfPeticionComparar.addAll(attrIdsOfPeticion);
        AtomicBoolean iguales = new AtomicBoolean(true);
        attrsForThisType.forEach((id) -> {
            if (!attrIdsOfPeticionComparar.contains(id)) {
                iguales.set(false);
                attrIdsOfPeticionComparar.clear();
            }
        });
        return iguales.get();
    }

    public static List<Integer> getAllIdsAttrOfCollection(
            final List<AtributoEje> atributos) {
        List<Integer> ids = new ArrayList<>();
        atributos.forEach((val) -> {
            ids.add(val.getId());
        });
        return ids;
    }

    public static List<ValidationErrorMessage> validateAttributeSelectedUserElemCat(
            final ValoresEjesDeElemenCatalogoUsuario value, final AtributoEje atributoEje) {

        List<ValidationErrorMessage> errorMessages = new ArrayList<>();
        if (value.getAxisAttributeId() == null) {
            errorMessages.add(new ValidationErrorMessage("Violación de integridad de datos en la petición "
                    + " en el campo [" + atributoEje.getName() + "], causa: valor de dominio sin id atributo"));
        } else if (atributoEje.getMandatory().intValue() == Constantes.NUMBER_1
                && ((value.getDomainValues() == null || value.getDomainValues().isEmpty()
                || value.getDomainValues().iterator().next().getDomainValueId() == null)
                && (value.getUserValue() == null || "".contentEquals(value.getUserValue().trim())))) {
            errorMessages.add(new ValidationErrorMessage("Violación de integridad de datos en la petición "
                    + " en el campo [" + atributoEje.getName() + "], causa: "
                    + (atributoEje.getValuesInDomain().intValue() == Constantes.NUMBER_1
                    ? "no viaja valor seleccionado" : "el valor para este no puede ser vacío")));
        }
        if (value.getUserValue() != null) { // compruebo el formato
            String valUsuario = value.getUserValue().trim();
            boolean wellFormatted = true;
            if (!"".contentEquals(valUsuario)) {
                wellFormatted = (atributoEje.getRegex() == null || "".contentEquals(atributoEje.getRegex()))
                        ? valUsuario.length() <= Constantes.NUMBER_250
                        : isValidUserValue(valUsuario, atributoEje);
            }
            if (!wellFormatted) {
                errorMessages.add(
                        new ValidationErrorMessage("Violación de integridad de datos en la petición en el campo ["
                                + atributoEje.getName() + "], causa: formato inválido de la entrada <"
                                + valUsuario + ">"));
            }
        } else {
            boolean notSelectedInComno = value.getDomainValues() == null || value.getDomainValues().isEmpty()
                    || value.getDomainValues().iterator().next().getDomainValueId() == null;
            if (!notSelectedInComno) {
                List<ValorDominioDeAttrElemCat> valoresCombo = value.getDomainValues();
                boolean checkedFailed = false;
                int idDomainUserForbidden = -1;
                int i = 0;
                while (!checkedFailed && i < valoresCombo.size()) {
                    //chequeamos que cada valor que viaja está en la lista valores aceptados para este atributo
                    ValorDominioDeAttrElemCat valDominioUserSelected = valoresCombo.get(i++);
                    boolean foundRealValue = false;
                    int j = 0;
                    while (!foundRealValue && j < atributoEje.getDomainValues().size()) {
                        ValorDominio valDominioInBBDD = atributoEje.getDomainValues().get(j++);
                        if (valDominioInBBDD.getId().intValue()
                                == valDominioUserSelected.getDomainValueId().intValue()) {
                            foundRealValue = true;
                        }
                    }
                    if (!foundRealValue) {
                        idDomainUserForbidden = valDominioUserSelected.getDomainValueId();
                        checkedFailed = true;
                    }
                }
                if (checkedFailed) {
                    errorMessages.add(new ValidationErrorMessage(
                            "Violación de integridad de datos en la petición en el campo ["
                                    + atributoEje.getName() + "], causa: se ha intentado grabar "
                                    + "el identificador (" + idDomainUserForbidden + ") no reconocido"));
                }
            }
        }
        return errorMessages;
    }


    public static List<ValidationErrorMessage> validateAttributeSelectedUserRelease(
            final ValoresEjesDeEntregaUsuario value, final AtributoEje atributoEje) {

        List<ValidationErrorMessage> errorMessages = new ArrayList<>();
        if (value.getAxisAttributeId() == null) {
            errorMessages.add(new ValidationErrorMessage("Violación de integridad de datos en la petición "
                    + " en el campo [" + atributoEje.getName() + "], causa: valor de dominio sin id atributo"));
        } else if (atributoEje.getMandatory().intValue() == Constantes.NUMBER_1
                && ((value.getDomainValues() == null || value.getDomainValues().isEmpty()
        || value.getDomainValues().iterator().next().getDomainValueId() == null)
                && (value.getUserValue() == null || "".contentEquals(value.getUserValue().trim())))) {
            errorMessages.add(new ValidationErrorMessage("Violación de integridad de datos en la petición "
                    + " en el campo [" + atributoEje.getName() + "], causa: "
                    + (atributoEje.getValuesInDomain().intValue() == Constantes.NUMBER_1
                    ? "no viaja valor seleccionado" : "el valor para este no puede ser vacío")));
        }
        if (atributoEje.getValuesInDomain().intValue() == Constantes.NUMBER_0) {
            String valUsuario = value.getUserValue() == null ? "" : value.getUserValue().trim();
            boolean wellFormatted = true;
            if (!"".contentEquals(valUsuario)) {
                wellFormatted = (atributoEje.getRegex() == null || "".contentEquals(atributoEje.getRegex()))
                        ? valUsuario.length() <= Constantes.NUMBER_250
                        : isValidUserValue(valUsuario, atributoEje);
            }
            if (!wellFormatted) {
                new ValidationErrorMessage("Violación de integridad de datos en la petición en el campo ["
                        + atributoEje.getName() + "], causa: formato inválido de la entrada <"
                        + valUsuario + ">");
            }
        } else {
            boolean notSelectedInComno = value.getDomainValues() == null
                    || value.getDomainValues().iterator().next().getDomainValueId() == null;
            if (!notSelectedInComno) {
                List<ValorDominioDeAttrEntrega> valoresCombo = value.getDomainValues();
                boolean checkedFailed = false;
                int idDomainUserForbidden = -1;
                int i = 0;
                while (!checkedFailed && i < valoresCombo.size()) {
                    //chequeamos que cada valor que viaja está en la lista valores aceptados para este atributo
                    ValorDominioDeAttrEntrega valDominioUserSelected = valoresCombo.get(i++);
                    boolean foundRealValue = false;
                    int j = 0;
                    while (!foundRealValue && j < atributoEje.getDomainValues().size()) {
                        ValorDominio valDominioInBBDD = atributoEje.getDomainValues().get(j++);
                        if (valDominioInBBDD.getId().intValue()
                                == valDominioUserSelected.getDomainValueId().intValue()) {
                            foundRealValue = true;
                        }
                    }
                    if (!foundRealValue) {
                        idDomainUserForbidden = valDominioUserSelected.getDomainValueId();
                        checkedFailed = true;
                    }
                }
                if (checkedFailed) {
                    errorMessages.add(new ValidationErrorMessage(
                            "Violación de integridad de datos en la petición en el campo ["
                                    + atributoEje.getName() + "], causa: se ha intentado grabar "
                            + "el identificador (" + idDomainUserForbidden + ") no reconocido"));
                }
            }
        }
        return errorMessages;
    }

    public static boolean isValidNameAndVersion(final String nameOfversion) {
        String regex = "^[A-Z0-9]{4,8}-\\d{1,2}\\.\\d{1,2}\\.\\d{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nameOfversion);
        return matcher.matches();
    }

}
