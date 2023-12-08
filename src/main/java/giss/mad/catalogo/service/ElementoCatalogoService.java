package giss.mad.catalogo.service;

import giss.mad.catalogo.exception.ValidationErrorMessage;

import giss.mad.catalogo.model.AtributoEje;
import giss.mad.catalogo.model.ElementOrEntregaInterface;
import giss.mad.catalogo.model.ElementoCatalogo;
import giss.mad.catalogo.model.Grupo;
import giss.mad.catalogo.model.TipoElementoCatalogo;
import giss.mad.catalogo.model.ValorDominio;
import giss.mad.catalogo.model.ValorDominioCondicionadoPor;
import giss.mad.catalogo.model.ValorDominioDeAttrElemCat;
import giss.mad.catalogo.model.ValoresEjesDeElemenCatalogoUsuario;
import giss.mad.catalogo.model.auxejes.AttributeValDomain;
import giss.mad.catalogo.model.auxejes.AxisValDomain;
import giss.mad.catalogo.model.auxejes.CatalogueNode;
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
import giss.mad.catalogo.utilities.Constantes;
import giss.mad.catalogo.utilities.ExcelGenerator;
import giss.mad.catalogo.utilities.ValidationConstraints;

import giss.mad.catalogo.utilities.ValoresAttrComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class ElementoCatalogoService implements ElementOrReleaseServiceInterface {

    @Autowired
    private ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository;

    @Autowired
    private AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository;

    @Autowired
    private EntregaElementoCatalogoRepository entregaElementoCatalogoRepository;
    @Autowired
    private ElementoCatalogoRepository elemenCatalogoRepository;

    @Autowired
    private TipoElementoCatalogoRepository tipoElementoCatalogoRepository;
    @Autowired
    private GrupoService grupoService;

    @Autowired
    private AtributoEjeService atributoEjeService;
    @Autowired
    private AtributoEjeRepository atributoEjeRepository;
    @Autowired
    private ValorDominioService valorDominioService;
    @Autowired
    private ValorDominioCondicionadoRepository valorDominioCondicionadoRepository;

    public final void setValoresEjesDeElemenCatalogoUsuarioRepository(
            final ValoresEjesDeElemenCatalogoUsuarioRepository valoresEjesDeElemenCatalogoUsuarioRepository) {
        this.valoresEjesDeElemenCatalogoUsuarioRepository = valoresEjesDeElemenCatalogoUsuarioRepository;
    }

    public final void setEntregaElementoCatalogoRepository(final EntregaElementoCatalogoRepository
                                                                   entregaElementoCatalogoRepository) {
        this.entregaElementoCatalogoRepository = entregaElementoCatalogoRepository;
    }

    public final void setElemenCatalogoRepository(final ElementoCatalogoRepository elemenCatalogoRepository) {
        this.elemenCatalogoRepository = elemenCatalogoRepository;
    }

    public final void setValorDominioService(final ValorDominioService valorDominioService) {
        this.valorDominioService = valorDominioService;
    }
    public final void setGrupoService(final GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    public final void setAtributoEjeService(final AtributoEjeService atributoEjeService) {
        this.atributoEjeService = atributoEjeService;
    }

    public final void setTipoElementoCatalogoRepository(
            final TipoElementoCatalogoRepository tipoElementoCatalogoRepository) {
        this.tipoElementoCatalogoRepository = tipoElementoCatalogoRepository;
    }

    public final void setAtributoEjeRepository(final AtributoEjeRepository atributoEjeRepository) {
        this.atributoEjeRepository = atributoEjeRepository;
    }

    public final void setAtributoEjePorTipoElementoRepository(
            final AtributoEjePorTipoElementoRepository atributoEjePorTipoElementoRepository) {
        this.atributoEjePorTipoElementoRepository = atributoEjePorTipoElementoRepository;
    }

    public final void setValorDominioCondicionadoRepository(
            final ValorDominioCondicionadoRepository valorDominioCondicionadoRepository) {
        this.valorDominioCondicionadoRepository = valorDominioCondicionadoRepository;
    }

    public final ElementoCatalogo getById(final Integer id) {
        ElementoCatalogo ele = this.elemenCatalogoRepository.getByIdWithHistoric(id);
        if (ele != null && ele.getId() != null) {
            ele.setAttributeValuesCollection(getAttributesByElementId(ele.getId()));
            List<ElementoCatalogo> childrenElements = new ArrayList<>();
            List<ElementoCatalogoMinimal> childrenOfMe = this.elemenCatalogoRepository.getChildrenOfIdParent(id);
            childrenOfMe.forEach((child) -> {
                childrenElements.add(getByIdAndDeletedIsNull(child.getId()));
            });
            ele.setSubElements(childrenElements);
        }
        return ele;
    }

    public final SimplifiedAttribute getDescripcionElemento(final String codigo) {
        return this.elemenCatalogoRepository.getUserValueOfAttr(codigo,
                Constantes.DESCRIPCION_ATTR_ID);
    }
    public final SimplifiedAttribute getTipologiaElementoEP(final String codigo) {
        return this.elemenCatalogoRepository.getValDominioOfAttr(codigo,
                Constantes.COMPUTER_PROCESSING_ATTR_ID);
    }

    public final SimplifiedAttribute getCircuitoVidaElementoEP(final String codigo) {
        return this.elemenCatalogoRepository.getValDominioOfAttr(codigo,
                Constantes.CIRCUITO_CICLO_VIDA_ATTR_ID);
    }

    public final SimplifiedAttribute getTechnology(final String codigo) {
        return this.elemenCatalogoRepository.getValDominioOfAttr(codigo, Constantes.GRUPO_TECHNOLOGY_ID);
    }

    public final SimplifiedAttribute getComponentFormedWith(final String codigo) {
        return this.elemenCatalogoRepository.getValDominioOfAttr(codigo, Constantes.COMPONENTE_QUE_DESARROLLA_ID);
    }

    public final SimplifiedElement getSimplifiedById(final Integer idElementoCat, final Grupo grupoUser) {
        SimplifiedElement simplified = this.elemenCatalogoRepository.getSimplifiedElement(idElementoCat);
        if (grupoUser != null
                && !this.grupoService.estaContenido(this.grupoService.getById(simplified.getGroupId()), grupoUser)) {
            //activamos modo read-only, y extraemos los literales de cada un. organizativa
            simplified.setReadOnly(1);
            Grupo respTto = this.grupoService.getById(simplified.getGroupId());
            Grupo respDesa = null;
            if (simplified.getRespDevelopmentId() != null) {
                respDesa = this.grupoService.getById(simplified.getRespDevelopmentId());
            }
            Grupo respAdmon = null;
            if (simplified.getRespManagementId() != null) {
                respAdmon = this.grupoService.getById(simplified.getRespManagementId());
            }
            simplified.setRespTtoLiteral(respTto == null ? ""
                    : respTto.getCodigo().concat(" - ").concat(respTto.getName()));
            simplified.setRespDesaLiteral(respDesa == null ? ""
                    : respDesa.getCodigo().concat(" - ").concat(respDesa.getName()));
            simplified.setRespAdmonLiteral(respAdmon == null ? ""
                    : respAdmon.getCodigo().concat(" - ").concat(respAdmon.getName()));
        }
        return simplified;
    }

    public final ElementoCatalogo getByName(final String nameOfElemenCat) {
        ElementoCatalogo retorno = null;
        List<ElementoCatalogo> elems = this.elemenCatalogoRepository.getByNameOptimized(nameOfElemenCat);
        if (elems != null && elems.size() == 1) {
            retorno = elems.get(0);
        }
        return retorno;
    }

    public final Page<ElementoCatalogo> getByCollateralId(final Pageable pageable, final Integer idParent) {
        ElementoCatalogo parent = this.getByIdAndDeletedIsNull(idParent);
        Page<ElementoCatalogo> elementosPaginados = null;
        if (parent != null) {
            elementosPaginados = this.elemenCatalogoRepository.
                    getByDeletedIsNullAndCatalogElementCollateralIdPag(parent.getId(), pageable);
            for (ElementoCatalogo elem : elementosPaginados) {
                if (elem.getCatalogElementCollateralId() != null) {
                    ElementoCatalogo parentEl = this.elemenCatalogoRepository.getMinimalInfoOfElement(
                            elem.getCatalogElementCollateralId());
                    elem.setParentElement(parentEl);
                }
            }
        }
        return elementosPaginados;
    }

    /***
     * Method for accessing by anothers applications
     * @param group
     * @param typeOfElm
     * @return
     */
    public final List<SimplifiedElement> getAllByGroupAndType(final Grupo group, final Integer typeOfElm) {
        String order = "cappCode";
        String direction = "ASC";
        return this.elemenCatalogoRepository.
                findElementsFromGroupInHierarchy(this.grupoService.getGruposIds(group.getId()),
                        typeOfElm, order, direction);
    }
    public final Page<ElementoCatalogoFilter> searchByFilterForListHome(final Pageable pageable,
                                                                        final ElementoCatalogoFilter filter) {

        String nameOfElement = filter.getName() != null && !"".contentEquals(filter.getName().trim())
                ? filter.getName().trim() : null;
        String cappCode = filter.getCode() != null && !"".contentEquals(filter.getCode().trim())
                ? filter.getCode().trim() : null;
        String responsible = filter.getResponsible() != null && !"".contentEquals(filter.getResponsible().trim())
                ? filter.getResponsible().trim() : null;

        Integer groupId = filter.getGroupId() != null ? filter.getGroupId() : 0;
        Integer idTypeElem = filter.getIdOfCatalogueElementType() != null
                ? filter.getIdOfCatalogueElementType() : 0;
        Integer functionalAreaId = filter.getFunctionalAreaId() != null
                ? filter.getFunctionalAreaId() : 0;
        Integer computerProcessingId = filter.getComputerProcessingId() != null
                ? filter.getComputerProcessingId() : 0;
        Integer situationId = filter.getSituationId() != null ? filter.getSituationId() : null;

        String groupIdAndType = groupId + "-" + idTypeElem;
        String funcAreaIdAndComputerProcIds = functionalAreaId + "-" + computerProcessingId;
        return this.elemenCatalogoRepository.getMinimalInfoByFilter(groupIdAndType, funcAreaIdAndComputerProcIds,
                situationId, cappCode, nameOfElement, responsible, pageable);
    }

    /**
     * Método de búsqueda usado desde los escenarios de listados de elementos de catálogo
     *
     * @param pageable
     * @param filter
     * @param grupoUser
     * @return
     */
    public final Page<ElementoCatalogo> searchByFilterForList(final Pageable pageable,
                                                              final ElementoCatalogoFilter filter,
                                                              final Grupo grupoUser) {
        Integer idGroup = null;
        if (grupoUser != null) {
            idGroup = grupoUser.getId();
        }

        String cappCodeFilter = filter.getCode() == null || "".contentEquals(filter.getCode())
                ? null : filter.getCode().toUpperCase();
        String nameFilter = filter.getName() == null || "".contentEquals(filter.getName())
                ? null : filter.getName().toUpperCase();
        String groupFilter = filter.getGroup() == null || "".contentEquals(filter.getGroup())
                ? null : filter.getGroup().toUpperCase();
        String descriptionFilter = filter.getDescription() == null || "".contentEquals(filter.getDescription())
                ? null : filter.getDescription().toUpperCase();
        Integer axisAttributeFilter = filter.getAxisAttribute() == null ? null : filter.getAxisAttribute();
        Integer domainValueFilter = filter.getDomainValue() == null ? null : filter.getDomainValue();
        Date startDate = filter.getStartDate();
        Date endDate = filter.getEndDate();
        if (startDate == null && filter.getEndDate() != null) {
            startDate = new Date(Calendar.getInstance().getTime().getTime());
        }
        if (startDate != null) {
            endDate = filter.getEndDate() == null ? new Date(Calendar.getInstance().getTime().getTime())
                    : filter.getEndDate(); //sumamos un dia al final
            Calendar newEndDate = Calendar.getInstance();
            newEndDate.setTime(endDate);
            newEndDate.add(Calendar.DATE, 1);
            endDate = new java.sql.Date(newEndDate.getTime().getTime());
        }

        Page<ElementoCatalogo> candidatos;
        if (cappCodeFilter == null && nameFilter == null && (groupFilter == null || "*".contentEquals(groupFilter))
                && descriptionFilter == null && startDate == null && endDate == null && axisAttributeFilter == null
                && domainValueFilter == null) {
            if (idGroup == null || (groupFilter != null && "*".contentEquals(groupFilter))) {
                Map<String, Object> concatenated = new HashMap<>();
                concatenated.put("typeId", filter.getIdOfCatalogueElementType());
                concatenated.put("axisAttribute", axisAttributeFilter);
                concatenated.put("domainValue", domainValueFilter);

                candidatos = this.elemenCatalogoRepository.getMinimalInfoForListing(concatenated, startDate,
                        endDate, pageable);
            } else { // si es prop.catalogo o DelegadoCentro se le muestra el listado por defecto al entrar
                Map<String, Object> concatenated = new HashMap<>();
                concatenated.put("typeId", filter.getIdOfCatalogueElementType());
                concatenated.put("groupsId", this.grupoService.getGruposIds(idGroup));
                concatenated.put("axisAttribute", axisAttributeFilter);
                concatenated.put("domainValue", domainValueFilter);

                candidatos = this.elemenCatalogoRepository.getMinimalInfoForListingForGroups(concatenated, startDate,
                        endDate, pageable);
            }
        } else { // aqui entra si han metido algún campo del filtro de búsqueda
            if (groupFilter == null || "*".contentEquals(groupFilter)) {
                Map<String, Object> concatenated = new HashMap<>();
                concatenated.put("typeId", filter.getIdOfCatalogueElementType());
                concatenated.put("groupId", groupFilter);
                concatenated.put("description", descriptionFilter);
                concatenated.put("cappCode", cappCodeFilter);
                concatenated.put("name", nameFilter);
                concatenated.put("axisAttribute", axisAttributeFilter);
                concatenated.put("domainValue", domainValueFilter);

                candidatos = this.elemenCatalogoRepository.getMinimalInfoForListingWithCappOrName(concatenated,
                        startDate, endDate, pageable);
            } else {
                Map<String, Object> concatenated = new HashMap<>();
                concatenated.put("typeId", filter.getIdOfCatalogueElementType());
                concatenated.put("groupsId", this.grupoService.getGruposIds(idGroup));
                concatenated.put("cappCode", cappCodeFilter);
                concatenated.put("name", nameFilter);
                concatenated.put("axisAttribute", axisAttributeFilter);
                concatenated.put("domainValue", domainValueFilter);

                candidatos = this.elemenCatalogoRepository.getMinimalInfoForListingForGroupsWithCappOrName(concatenated,
                        startDate, endDate, pageable);
            }
        }

        Integer numberOfAttrsMandatoryOfThisTypeOfElement = this.valoresEjesDeElemenCatalogoUsuarioRepository.
                getNumberOfAttrsMandatoryOfThisTypeOfElement(filter.getIdOfCatalogueElementType());
        candidatos.getContent().forEach((elem) -> {
            Integer numberOfAttributosCompletados = this.valoresEjesDeElemenCatalogoUsuarioRepository.
                    getMandatoryAttrsIds(elem.getId(), filter.getIdOfCatalogueElementType());
            elem.setIncomplete(numberOfAttributosCompletados == numberOfAttrsMandatoryOfThisTypeOfElement ? 0 : 1);
            Grupo grupo = this.grupoService.getById(elem.getGroupId());
            if (grupoUser != null && !this.grupoService.estaContenido(grupo, grupoUser)) {
                elem.setReadOnly(1);
            }
            elem.setResponsableTto(grupo.getCodigo().concat(" - ").concat(grupo.getName()));
        });

        return candidatos;
    }

    public final ElementoCatalogoMinimal getMyParentElement(final Integer elementId) {
        ElementoCatalogo child = getById(elementId);
        ElementoCatalogoMinimal parent = new ElementoCatalogoMinimal();
        if (child.getCatalogElementCollateralId() != null) {
            ElementoCatalogo parentOriginal = this.getByIdAndDeletedIsNull(child.getCatalogElementCollateralId());
            if (parentOriginal != null) {
                parent.setId(parentOriginal.getId());
                parent.setName(parentOriginal.getName());
                parent.setCappCode(parentOriginal.getCappCode());
            }
        }
        return parent;
    }

    public final List<ElementoCatalogoMinimal> getMinimalInfoOfElement(final String group,
                                                                       final List<Integer> idsOfTypes,
                                                                       final boolean onlyFree) {
        Integer idGroup = null;
        if (!group.contentEquals("*")) {
            idGroup = Integer.parseInt(group);
        }
        List<ElementoCatalogoMinimal> elements;
        if (onlyFree) {
            elements = group.contentEquals("*")
                    ? this.elemenCatalogoRepository.getFreeElementNameAndCapp(idsOfTypes)
                    : this.elemenCatalogoRepository.getFreeElementNameAndCappByGroup(idsOfTypes,
                    this.grupoService.getGruposIds(idGroup));
        } else {
            elements = group.contentEquals("*")
                    ? this.elemenCatalogoRepository.getElementNameAndCapp(idsOfTypes)
                    : this.elemenCatalogoRepository.getElementNameAndCappByGroup(idsOfTypes,
                    this.grupoService.getGruposIds(idGroup));
        }

        return elements;
    }



    public final List<ElementoCatalogoMinimal> getPrimerNivelInferior(final Integer idPEl) {

        ElementoCatalogo parentElement = this.getById(idPEl);
        List<ElementoCatalogoMinimal> subListMinimal = new ArrayList<>();
        if (parentElement != null && parentElement.getSubElements() != null) {
            for (ElementoCatalogo childElement : parentElement.getSubElements()) {
                ElementoCatalogoMinimal minimal = new ElementoCatalogoMinimal();
                minimal.setId(childElement.getId());
                minimal.setCappCode(childElement.getCappCode());
                minimal.setName(childElement.getName());
                subListMinimal.add(minimal);
            }
        }
        return subListMinimal;
    }



    private List<ValoresEjesDeElemenCatalogoUsuario> atributosCasosEspeciales(
            final List<ValoresEjesDeElemenCatalogoUsuario> atributosIn) {
        //Quita de la lista de atributos aquellos que no sean necesarios para los casos especiales
        Iterator<ValoresEjesDeElemenCatalogoUsuario> iterator = atributosIn.iterator();
        while (iterator.hasNext()) {
            int axisAttributeId = iterator.next().getAxisAttributeId().intValue();
            if (axisAttributeId != Constantes.NUMBER_14 && axisAttributeId != Constantes.NUMBER_19) {
                iterator.remove();
            }
        }

        return atributosIn;
    }

    public final Page<ElementoCatalogo> getFreeAndNotFreeElementsByUserGroupIdAndCatalogueTypeId(
            final Pageable pageable, final Grupo groupUser, final List<Integer> idsOfTypes) {

        final ElementoCatalogoFilter filter = new ElementoCatalogoFilter();
        filter.setIdOfCatalogueElementType(idsOfTypes.iterator().next());
        return searchByFilterForList(pageable, filter, groupUser);
    }

    public final Page<ElementoCatalogo>
    getFreeElementsByUserGroupIdAndCatalogueTypeId(final Pageable pageable, final String group,
                                                   final List<Integer> idsparentCatalogueType) {
        Integer idGroup = null;
        if (!group.contentEquals("*")) {
            idGroup = Integer.parseInt(group);
        }
        Page<ElementoCatalogo> elementosPaginados;
        if (group.contentEquals("*")) {
            elementosPaginados = this.elemenCatalogoRepository.
                    findByDeletedIsNullAndCatalogElementCollateralIdIsNullAndCatalogElementTypeIdIn(
                            idsparentCatalogueType, pageable);
        } else {
            elementosPaginados = this.elemenCatalogoRepository.
                    findByDeletedIsNullAndGroupIdInAndCatalogElementTypeIdIn(this.grupoService.getGruposIds(idGroup),
                            idsparentCatalogueType, pageable);
        }

        for (ElementoCatalogo elementoCatalogo : elementosPaginados) {
            elementoCatalogo.setDeliveryCollection(
                    this.entregaElementoCatalogoRepository.getAllWithCatalogElementIdAndDeletedIsNull(
                            elementoCatalogo.getId(), Sort.by(Sort.Order.desc("id"))));
            Page<ElementoCatalogo> pagingResults = this.elemenCatalogoRepository.
                    getByDeletedIsNullAndCatalogElementCollateralIdPag(elementoCatalogo.getId(), pageable);
            List<ElementoCatalogo> subElementList = new ArrayList<>();
            for (ElementoCatalogo subElement : pagingResults) {
                subElementList.add(subElement);
            }
            elementoCatalogo.setSubElements(subElementList);
        }
        return elementosPaginados;
    }

    protected final ElementoCatalogo getElementTop(final ElementoCatalogo elemCatalogo) {
        ElementoCatalogo searchTop = elemCatalogo;
        while (searchTop.getCatalogElementCollateralId() != null) {
            searchTop = getById(searchTop.getCatalogElementCollateralId());
        }
        List<ElementoCatalogo> l = this.elemenCatalogoRepository.
                getByDeletedIsNullAndCatalogElementCollateralId(searchTop.getId());
        searchTop.setSubElements(l);
        return searchTop;
    }

    public final List<CatalogueNode> getHierarchyById(final Integer idOfElement) {
        ElementoCatalogo elementRoot = getElementTop(this.getByIdAndDeletedIsNull(idOfElement));
        List<CatalogueNode> listOfNodes = new ArrayList<>();
        recursiveHierarchy(listOfNodes, elementRoot, idOfElement);

        return listOfNodes;
    }

    protected final void recursiveHierarchy(final List<CatalogueNode> listaOut, final ElementoCatalogo elemCatalogo,
                                            final Integer seachById) {

        CatalogueNode hierarchyLevel0 = new CatalogueNode();
        hierarchyLevel0.setId(elemCatalogo.getId());
        String preffix = elemCatalogo.getId().intValue() == seachById.intValue() ? "[*]" : "";
        hierarchyLevel0.setLevel(this.tipoElementoCatalogoRepository.findByIdAndDeletedIsNull(elemCatalogo.
                getCatalogElementTypeId()).getName());
        hierarchyLevel0.setCappCode(elemCatalogo.getCappCode());
        hierarchyLevel0.setName(preffix.concat(elemCatalogo.getName()));
        SimplifiedAttribute simplified = this.getDescripcionElemento(elemCatalogo.getCappCode());
        hierarchyLevel0.setDescripcion(simplified == null ? "" : simplified.getUserValue());
        hierarchyLevel0.setCreationDate(elemCatalogo.getCreationDate());
        hierarchyLevel0.setGroup(this.grupoService.getById(elemCatalogo.getGroupId()).getName());

        if (elemCatalogo.getSubElements() != null && !elemCatalogo.getSubElements().isEmpty()) {
            List<CatalogueNode> children = new ArrayList<>();
            for (ElementoCatalogo subElement : elemCatalogo.getSubElements()) {
                if (subElement.getDeleted() == null || subElement.getDeleted().intValue() == Constantes.NUMBER_0) {
                    subElement.setSubElements(this.elemenCatalogoRepository.
                            getByDeletedIsNullAndCatalogElementCollateralId(subElement.getId()));
                    recursiveHierarchy(children, subElement, seachById);
                }
            }
            hierarchyLevel0.setChildren(children);
        }

        listaOut.add(hierarchyLevel0);

    }

    private boolean esPadreDeNivelInferior(final ElementoCatalogo candidatoParent,
                                           final ElementoCatalogo elementoCatIn) {

        boolean padreDeNivelIgualOInferior = false;
        if (candidatoParent != null) {
            switch (candidatoParent.getCatalogElementTypeId().intValue()) {
                case TipoElementoCatalogo.APLICACION:
                    padreDeNivelIgualOInferior = elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.APLICACION
                            || elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.PROYECTO
                            || elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.AGRUPACION_FUNCIONAL;
                    break;
                case TipoElementoCatalogo.AGRUPACION_FUNCIONAL:
                    padreDeNivelIgualOInferior = elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.PROYECTO
                            || elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.AGRUPACION_FUNCIONAL;
                    break;
                case TipoElementoCatalogo.PROYECTO:
                    padreDeNivelIgualOInferior = elementoCatIn.getCatalogElementTypeId().intValue()
                            == TipoElementoCatalogo.PROYECTO;
                    break;
                default:
                    //TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE
                    padreDeNivelIgualOInferior = true;
            }
        }

        return padreDeNivelIgualOInferior;
    }

    private ElementoCatalogo esHijoDelActual(final ElementoCatalogo candidatoParent,
                                             final ElementoCatalogo elementoCatIn) {
        ElementoCatalogo hijoFound = null;
        if (candidatoParent != null) {
            if (elementoCatIn.getId() != null
                    && candidatoParent.getId().intValue() == elementoCatIn.getId().intValue()) {
                hijoFound = elementoCatIn;
            } else if (elementoCatIn.getSubElements() != null && !elementoCatIn.getSubElements().isEmpty()) {
                for (int i = 0; i < elementoCatIn.getSubElements().size(); i++) {
                    hijoFound = esHijoDelActual(candidatoParent, elementoCatIn.getSubElements().get(i));
                }
            }
        }
        return hijoFound;
    }

    private List<Integer> getAllIdsAttrOfAttrsOfElement(
            final List<ValoresEjesDeElemenCatalogoUsuario> valoresAttrsPeticion) {
        List<Integer> ids = new ArrayList<>();
        valoresAttrsPeticion.forEach((val) -> {
            ids.add(val.getAxisAttributeId());
        });
        return ids;
    }



    private List<ValidationErrorMessage> validateCAPPInParent(final ElementoCatalogo child,
                                                              final ElementoCatalogo parent) {
        List<ValidationErrorMessage> errors = new ArrayList<>();
        if (!child.getCappCode().startsWith(parent.getCappCode())) {
            errors.add(new ValidationErrorMessage(
                    "El código CAPP <" + child.getCappCode() + "> de este EP no viene prefijado por los primeros 4 "
                            + "caracteres de su elemento padre, la aplicación <" + parent.getCappCode() + ">"));
        }
        return errors;
    }

    private List<ValidationErrorMessage> validateCAPPLength(final ElementoCatalogo child) {
        List<ValidationErrorMessage> errors = new ArrayList<>();
        switch (child.getCatalogElementTypeId().intValue()) {
            case TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE:
                if (child.getCappCode().length() != Constantes.NUMBER_8) {
                    errors.add(new ValidationErrorMessage("El código CAPP <" + child.getCappCode()
                            + "> de un Elemento Promocionable debe tener exactamente longitud 8"));
                }
                break;
            case TipoElementoCatalogo.APLICACION:
                if (child.getCappCode().length() != Constantes.NUMBER_4) {
                    errors.add(new ValidationErrorMessage("El código CAPP <" + child.getCappCode()
                            + "> de una Aplicación debe tener exactamente longitud 4"));
                }
                break;
            case TipoElementoCatalogo.AGRUPACION_FUNCIONAL:
                if (child.getCappCode().length() != Constantes.NUMBER_8) {
                    errors.add(new ValidationErrorMessage("El código CAPP <" + child.getCappCode()
                            + "> de una Agrupación Funcional debe tener exactamente longitud 8"));
                }
                break;
            case TipoElementoCatalogo.PROYECTO:
                if (child.getCappCode().length() != Constantes.NUMBER_6) {
                    errors.add(new ValidationErrorMessage("El código CAPP <" + child.getCappCode()
                            + "> de un Proyecto debe tener exactamente longitud 6"));
                }
                break;
            default:
                errors.add(new ValidationErrorMessage("Tipo de Elemento de Catálogo <"
                        + child.getCatalogElementTypeId().intValue() + "> desconocido"));
        }
        return errors;
    }

    private ValorDominio buscarValorDominioEnCache(final ValoresEjesDeElemenCatalogoUsuario valAttr,
                                                   final AtributoEje attributoEjeCached) {
        ValorDominio returned = null;
        if (valAttr.getDomainValues() != null) {
            boolean found = false;
            int i = 0;
            while (!found && i < valAttr.getDomainValues().size()) {
                ValorDominioDeAttrElemCat valDominioUser = valAttr.getDomainValues().get(i++);
                if (valDominioUser.getDomainValueId() == null) {
                    found = true;
                } else {
                    int j = 0;
                    while (!found && j < attributoEjeCached.getDomainValues().size()) {
                        ValorDominio cand = attributoEjeCached.getDomainValues().get(j++);
                        if (valDominioUser.getDomainValueId().intValue() == cand.getId().intValue()) {
                            returned = cand;
                            found = true;
                        }
                    }
                }
            }
        }
        return returned;
    }

    private String getUserValueFromAttributeId(final Integer idAttr, final ElementoCatalogo elemIn) {
        String userValue = null;
        int i = 0;
        boolean found = false;
        while (!found && i < elemIn.getAttributeValuesCollection().size()) {
            ValoresEjesDeElemenCatalogoUsuario valAttr = elemIn.getAttributeValuesCollection().get(i++);
            if (valAttr.getAxisAttributeId().intValue() == idAttr.intValue()) {
                userValue = valAttr.getUserValue();
                found = true;
            }
        }

        return userValue;
    }

    private Integer getSelectedValueFromAttributeId(final Integer idAttr, final ElementoCatalogo elemIn) {
        Integer idOfvalDomain = null;
        int i = 0;
        boolean found = false;
        while (!found && i < elemIn.getAttributeValuesCollection().size()) {
            ValoresEjesDeElemenCatalogoUsuario valAttr = elemIn.getAttributeValuesCollection().get(i++);
            if (valAttr.getAxisAttributeId().intValue() == idAttr.intValue()) {
                found = true;
                idOfvalDomain = valAttr.getDomainValues().isEmpty() ? null
                : valAttr.getDomainValues().iterator().next().getDomainValueId();
            }
        }
        return idOfvalDomain;
    }

    /**
     * Método que evalua si llega el atributo esperado en función del atrib. maestro
     * @return List<ValidationErrorMessage>
     */
    private List<ValidationErrorMessage> procesarRestricciones(final ElementoCatalogo elemIn) {
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        /*** Sensibilidad de los datos manejados:::Nivel de seguridad ***/
        Integer selectedId = getSelectedValueFromAttributeId(Constantes.SENSIBILIDAD_DATOS_ATTRID, elemIn);
        if (selectedId != null && selectedId == Constantes.SENSIBILIDAD_DATOS_SI_VALDOM_ID
                && getSelectedValueFromAttributeId(Constantes.NIVEL_SEGURIDAD_ATTRID, elemIn) == null) {
            errMsgs.add(new ValidationErrorMessage("El atributo 'Nivel de seguridad' debe ser consignado "
                + "cuando el valor del atributo 'Sensibilidad de los datos manejados' sea 'Sí'"));
        }
        /*** Actualización requerida:::PERIODICIDAD ***/
        selectedId = getSelectedValueFromAttributeId(Constantes.ACTUALIZACION_REQUERIDA_ATTRID, elemIn);
        if (selectedId != null && selectedId == Constantes.ACTUALIZACION_REQ_SI_VALDOM_ID
            && getSelectedValueFromAttributeId(Constantes.PERIODICIDAD_ATTRID, elemIn) == null) {
            errMsgs.add(new ValidationErrorMessage("El atributo 'Periodicidad' debe ser consignado "
                + "cuando el valor del atributo 'Actualización requerida' sea 'Sí'"));
        }
        /*** Arquitectura de despliegue::Servidor de aplicaciones y Servidor Web ***/
        selectedId = getSelectedValueFromAttributeId(Constantes.ARQUITECTURA_DESPLIEGUE_ATTRID, elemIn);
        if (selectedId != null) {
            if (selectedId !=  Constantes.ARQ_DESPLIEGUE_CLI_WEB_VALDOM_ID
                && getSelectedValueFromAttributeId(Constantes.SERVIDOR_WEB_ATTRID, elemIn) != null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Servidor Web' solo puede ser consignado "
                   + "cuando el valor del atributo 'Arquitectura de despliegue' sea 'Cliente Web/Servidor'"));
            }
            if (selectedId !=  Constantes.ARQ_DESPLIEGUE_CLI_PESADO_VALDOM_ID
               && getSelectedValueFromAttributeId(Constantes.SERVIDOR_APLICACIONES_ATTRID, elemIn) != null) {
               errMsgs.add(new ValidationErrorMessage("El atributo 'Servidor de aplicaciones' solo puede ser "
                       + "consignado cuando el valor del atributo 'Arquitectura de despliegue' "
                       + "sea 'Cliente pesado/Servidor'"));
            }
        }
		/**
		 *	56::“Código SILCON intranet” Solo se puede informar si el campo 55::“Estado” toma el valor
         *  164::"EN FASE DE DESPLIEGUE" o 167::"SERVICIO".
		 *	57:::“Fecha de entrada en servicio” de 55:::“Estado”:
			Solo se puede informar si el campo “Estado” = “SERVICIO”. Se habilita como obligatorio.
		 *	58::“Fecha de salida de servicio” de 55::“Estado”:
         *	Solo se puede informar si el campo “Estado” = 165:: “FUERA DE SERVICIO”. Se habilita como obligatorio.
         ***/
        selectedId = getSelectedValueFromAttributeId(Constantes.ESTADO_ATTRID, elemIn);
        if (selectedId != null) {
            if (selectedId != Constantes.ESTADO_FASE_DESPLIEGUE_VALDOM_ID
                && selectedId != Constantes.ESTADO_EN_SERVICIO_VALDOM_ID
                && getUserValueFromAttributeId(Constantes.CODIGO_SILCON_INTRANET_ATTRID, elemIn) != null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Código SILCON intranet' "
                + "solo puede ser consignado cuando el valor del atributo 'Estado' sea 'EN FASE DE DESPLIEGUE' o "
                + "en 'SERVICIO'"));
            }
            if (selectedId == Constantes.ESTADO_EN_SERVICIO_VALDOM_ID
                && getUserValueFromAttributeId(Constantes.FECHA_ENTRADA_SERVICIO_ATTRID, elemIn) == null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Fecha de entrada en servicio' "
                + "debe ser consignado cuando el valor del atributo 'Estado' sea 'SERVICIO'"));
            }
            if (selectedId == Constantes.ESTADO_FUERA_DE_SERVICIO_VALDOM_ID
                && getUserValueFromAttributeId(Constantes.FECHA_SALIDA_SERVICIO_ATTRID, elemIn) == null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Fecha de salida de servicio' "
                + "debe ser consignado cuando el valor del atributo 'Estado' sea 'FUERA DE SERVICIO'"));
            }
        }
        String respManagementCode = elemIn.getRespManagementId() == null
               ? "" : this.grupoService.getById(elemIn.getRespManagementId()).getCodigo();
        if (respManagementCode.startsWith("G90")) {
            if (getSelectedValueFromAttributeId(Constantes.PREMIO_MEJOR_PRACTICA_ATTRID, elemIn) != null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Premio mejor práctica' solo puede ser "
                  + "consignado cuando Responsable de Administración de este elemento sea una Unidad Provincial"));
            } else if (getSelectedValueFromAttributeId(Constantes.NORMALIZADO_ATTRID, elemIn) != null) {
                errMsgs.add(new ValidationErrorMessage("El atributo 'Normalizada' solo puede ser consignado "
                  + "cuando Responsable de Administración de este elemento sea una Unidad Provincial"));
            }
        }
        return errMsgs;
    }

    private List<ValidationErrorMessage> evaluateBusinessRules(final ElementoCatalogo elemIn,
                                                               final boolean creation, final boolean esRolAdmin) {
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        List<ElementoCatalogo> elemsByCappCode = this.elemenCatalogoRepository.
                getByCappCodeOptimized(elemIn.getCappCode());
        if ((creation && elemsByCappCode != null && elemsByCappCode.size() > 0)
                || (!creation && elemsByCappCode != null && elemsByCappCode.size() > 0
                && elemsByCappCode.get(0).getId().intValue() != elemIn.getId().intValue())) {
            errMsgs.add(new ValidationErrorMessage("El código CAPP <" + elemIn.getCappCode()
                    + "> ya existe en el Catálogo"));
        }
        if (creation && elemIn.getCatalogElementTypeId() == TipoElementoCatalogo.APLICACION && !esRolAdmin) {

        }
        errMsgs.addAll(validateCAPPLength(elemIn));
        errMsgs.addAll(procesarRestricciones(elemIn));
        if (elemIn.getCatalogElementCollateralId() != null) { /***evaluamos coherencia en la jerarquía:  ***/
            if (elemIn.getParentElement() == null) {
                errMsgs.add(new ValidationErrorMessage("El ID del Elemento Superior en la jeraraquía no existe"));
            } else {
                if (elemIn.getCatalogElementTypeId().intValue() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE) {
                    errMsgs.addAll(validateCAPPInParent(elemIn, elemIn.getParentElement()));
                }
                if (!creation && elemIn.getParentElement().getId().intValue() == elemIn.getId().intValue()) {
                    errMsgs.add(new ValidationErrorMessage("Violación de consistencia de datos en jerarquía:"
                            + " el ID-PARENT_ID no puede coincidir con el ID del Elemento hijo en esta jerarquía"));
                } else if (esHijoDelActual(elemIn.getParentElement(), elemIn) != null) { //Violation 2
                    errMsgs.add(new ValidationErrorMessage("Violación de consistencia de datos en jerarquía:"
                            + " el ID-PARENT_ID figura como hijo del Elemento actual a modificar"));
                } else if (esPadreDeNivelInferior(elemIn.getParentElement(), elemIn)) { //Violation 3
                    errMsgs.add(new ValidationErrorMessage("Violación de consistencia de datos en jerarquía:"
                    + " el elemento padre no puede pertenecer a un nivel jerárquico igual o inferior al del actual"));
                }
                if (elemIn.getGroupId().intValue() != elemIn.getParentElement().getGroupId().intValue()) {
                    Integer centroHijo = this.grupoService.getCentroSuperior(
                            this.grupoService.getById(elemIn.getGroupId()).getCodigo()).getId();
                    Integer centroPadre = this.grupoService.getCentroSuperior(this.grupoService.getById(elemIn.
                            getParentElement().getGroupId()).getCodigo()).getId();
                    if (centroHijo.intValue() != centroPadre.intValue()) {
                        errMsgs.add(new ValidationErrorMessage(
                                "Error de validación: elemento padre e hijo no pertenecen al mismo centro"));
                    }
                }
            }
        }
        List<ElementoCatalogo> elemsByName = this.elemenCatalogoRepository.getByNameOptimized(elemIn.getName());
        if ((creation && elemsByName != null && elemsByName.size() > 0)
                || (!creation && elemsByName != null && elemsByName.size() > 0
                && elemsByName.get(0).getId().intValue() != elemIn.getId().intValue())) {
            errMsgs.add(new ValidationErrorMessage("El nombre <" + elemIn.getName() + "> ya existe en Catálogo"));
        }
        if (elemIn.getCatalogElementTypeId() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE
                && elemIn.getCatalogElementCollateralId() == null) {
            errMsgs.add(new ValidationErrorMessage("Violación de consistencia de datos: se requiere una "
                    + "aplicación madre de este elemento promocionable <" + elemIn.getCappCode() + ">"));
        }
        if (elemIn.getAttributeValuesCollection() == null || elemIn.getAttributeValuesCollection().isEmpty()) {
            errMsgs.add(new ValidationErrorMessage("Violación de consistencia de datos: no figuran atributos "
                    + "en la petición para el elemento de catálogo <" + elemIn.getCappCode() + ">"));
        }
        if (creation) {
            List<Integer> attrIdsOfPeticion = getAllIdsAttrOfAttrsOfElement(elemIn.getAttributeValuesCollection());
            List<Integer> attrsForThisType = ValidationConstraints.getAllIdsAttrOfCollection(
              this.atributoEjeService.getAllAttributesByTypeElement(elemIn.getCatalogElementTypeId(), false));
            if (!ValidationConstraints.sonIguales(attrIdsOfPeticion, attrsForThisType)) {
                errMsgs.add(new ValidationErrorMessage("Violación de integridad de datos: "
                        + "el conjunto de atributos que corresponde en base de datos con este tipo de elemento no "
                        + "coincide con el conjunto de atributos que viajan en la petición"));
            }
        }
        if (errMsgs.isEmpty()) {
            int i = 0;
            while (errMsgs.isEmpty() && i < elemIn.getAttributeValuesCollection().size()) {
                ValoresEjesDeElemenCatalogoUsuario valAttr = elemIn.getAttributeValuesCollection().get(i++);
                AtributoEje attrSlaveC = null;
                if (valAttr == null || valAttr.getAxisAttributeId() == null) {
                    errMsgs.add(new ValidationErrorMessage("El Identificador de atributo es nulo"));
                } else {
                    attrSlaveC = this.atributoEjeService.getForCatalogue(valAttr.getAxisAttributeId());
                }
                if (attrSlaveC == null) {
                    errMsgs.add(new ValidationErrorMessage("Atrib. " + valAttr.getAxisAttributeId()
                            + "desconocido"));
                } else {
                    errMsgs.addAll(ValidationConstraints.validateAttributeSelectedUserElemCat(valAttr, attrSlaveC));
                    if (attrSlaveC != null && attrSlaveC.getAxisAttributeCollateralId() != null) {
                        ValorDominio valorDominioSlave = buscarValorDominioEnCache(valAttr, attrSlaveC);
                        if (valorDominioSlave != null) {
                            String valorSelectedSlave = "";
                            if (valAttr.getUserValue() != null && (valAttr.getDomainValues() == null
                                    || valAttr.getDomainValues().isEmpty())) {
                                valorSelectedSlave = valAttr.getUserValue();
                            } else {
                                valorSelectedSlave = valorDominioSlave.getName();
                            }
                            Map<ValoresEjesDeElemenCatalogoUsuario, ValidationErrorMessage>
                                    valorMasterObjectMap = buscarValorByAttributeId(
                                    attrSlaveC.getAxisAttributeCollateralId(), elemIn.getAttributeValuesCollection());
                            ValidationErrorMessage errMsg = valorMasterObjectMap.values().iterator().next();
                            if (errMsg != null) {
                                errMsgs.add(errMsg);
                            } else {
                                ValoresEjesDeElemenCatalogoUsuario valorMasterObject = valorMasterObjectMap.keySet().
                                        iterator().next();
                                AtributoEje masterAtribute = this.atributoEjeService.
                                        getForCatalogue(attrSlaveC.getAxisAttributeCollateralId());
                                ValorDominio valorDominioMasterSelected =
                                        buscarValorDominioEnCache(valorMasterObject, masterAtribute);
                                String valorSelectedMaster = "";
                                if (valorMasterObject.getUserValue() != null
                                        && (valorMasterObject.getDomainValues() == null
                                        || valorMasterObject.getDomainValues().isEmpty())) {
                                    valorSelectedMaster = valorMasterObject.getUserValue();
                                } else {
                                    valorSelectedMaster = valorDominioMasterSelected.getName();
                                }
                                List<ValorDominioCondicionadoPor> valoresCondicionadosDeSlave = this.
                                        valorDominioCondicionadoRepository.findAllByDeletedIsNullAndDomainValueId(
                                                valorDominioSlave.getId());
                                boolean foundRelationship = valoresCondicionadosDeSlave.isEmpty();
                                int r = 0;
                                while (!foundRelationship && r < valoresCondicionadosDeSlave.size()) {
                                    ValorDominioCondicionadoPor valorCondicionadoDeSlave =
                                            valoresCondicionadosDeSlave.get(r++);
                                    if (valorCondicionadoDeSlave.getDomainValueCollateralId().intValue()
                                            == valorDominioMasterSelected.getId().intValue()
                                            && valorCondicionadoDeSlave.getDomainValueId().intValue()
                                            == valorDominioSlave.getId().intValue()) {
                                        foundRelationship = true;
                                    }
                                }
                                if (!foundRelationship) {
                                    String nombreAtribSlave = attrSlaveC.getName();
                                    String nombreAtribMaster = this.atributoEjeService.getForCatalogue(attrSlaveC.
                                            getAxisAttributeCollateralId()).getName();
                                    errMsgs.add(new ValidationErrorMessage("El valor <" + valorSelectedSlave
                                            + "> del atributo " + nombreAtribSlave + " no está permitido para el "
                                            + "valor <" + valorSelectedMaster + "> del atrib. " + nombreAtribMaster));
                                }
                            }
                        }
                    }
                }
            }
        }
        return errMsgs;
    }



    private Map<ValoresEjesDeElemenCatalogoUsuario, ValidationErrorMessage>
    buscarValorByAttributeId(final Integer idAttr, final List<ValoresEjesDeElemenCatalogoUsuario> listaValoresAttrs) {
        Map<ValoresEjesDeElemenCatalogoUsuario, ValidationErrorMessage> retorno = new HashMap<>();
        ValidationErrorMessage errMsg = null;
        ValoresEjesDeElemenCatalogoUsuario valSearched = null;
        for (ValoresEjesDeElemenCatalogoUsuario val : listaValoresAttrs) {
            if (val.getAxisAttributeId() == null) {
                errMsg = new ValidationErrorMessage("Error de integridad de datos: El identificador "
                        + "de atributo es nulo");
            }
            if (val.getAxisAttributeId().intValue() == idAttr.intValue()) {
                valSearched = val;
            }
        }
        if (valSearched == null) {
            errMsg = new ValidationErrorMessage("Error de integridad de datos: El identificador de "
                    + "atributo (" + idAttr.intValue() + ") no existe en Base de Datos");
        }
        retorno.put(valSearched, errMsg);
        return retorno;
    }

    private List<ValidationErrorMessage> validarUnidadesOrganizativas(final ElementoCatalogo elemenInput,
                                                                      final Grupo grupoDptoUser,
                                                                      final Grupo grupoCentroSupUser) {
        List<ValidationErrorMessage> errorMessageList = new ArrayList<>();
        if (elemenInput.getGroupId() == null) {
            errorMessageList.add(new ValidationErrorMessage("Violation constraint: "
                    + "El campo Responsable de Tratamiento no puede ser vacío"));
        } else {
            // control de comprobación de existencia en tabla GRUPO de los IDs de responsables que llegan
            Grupo grupoOrgTto = this.grupoService.getById(elemenInput.getGroupId());
            if (grupoOrgTto == null) {
                errorMessageList.add(new ValidationErrorMessage(
                        "Violation constraint: no existe el Responsable de Tratamiento con ID "
                                + elemenInput.getGroupId()));
            } else if (grupoOrgTto.getDeleted() != null && grupoOrgTto.getDeleted().intValue() == Constantes.NUMBER_1) {
                errorMessageList.add(new ValidationErrorMessage("No puede grabar un elemento de catálogo estando"
                        + " su unidad Responsable de Tratamiento de baja ("
                        + (grupoOrgTto != null ? grupoOrgTto.getName() : "") + ") en situación de baja"));
            } else if (grupoOrgTto.getDeleted() == null) {
                //Buscamos la pertenencia del grupoOrgTto con el dpto. del usuario: 1o. de debajo del segundo
                if (grupoCentroSupUser != null && !this.grupoService.estaContenido(grupoOrgTto, grupoDptoUser)) {
                    errorMessageList.add(new ValidationErrorMessage("La unidad Responsable de Tratamiento debe ser o "
                            + "pertenecer a la del usuario autenticado"));
                }
            }
            if (elemenInput.getRespDevelopmentId() != null) {
                Grupo grupoOrgDesa = this.grupoService.getById(elemenInput.getRespDevelopmentId());
                if (grupoOrgDesa == null) {
                    errorMessageList.add(new ValidationErrorMessage(
                            "Violation constraint: no existe el Responsable de Desarrollo con ID "
                                    + elemenInput.getRespDevelopmentId()));
                } else if (grupoOrgDesa.getDeleted() != null
                        && grupoOrgDesa.getDeleted().intValue() == Constantes.NUMBER_1) {
                    errorMessageList.add(new ValidationErrorMessage("No puede grabar un elemento de catálogo estando"
                            + " su unidad Responsable de Desarrollo de baja ("
                            + (grupoOrgDesa != null ? grupoOrgDesa.getName() : "") + ") en situación de baja"));
                }
                //Buscamos la pertenencia del grupoOrgDesa con el CentroSuperio del usuario: 1o. de debajo del segundo
                if (!this.grupoService.estaContenido(grupoOrgDesa, grupoCentroSupUser)) {
                    errorMessageList.add(new ValidationErrorMessage("La unidad Responsable de Desarrollo debe ser o "
                            + "pertenecer al Centro al que está adscrito el usuario autenticado"));
                }
            }

            if (elemenInput.getRespManagementId() != null) {
                Grupo grupoOrgAdmon = this.grupoService.getById(elemenInput.getRespManagementId());
                if (grupoOrgAdmon == null) {
                    errorMessageList.add(new ValidationErrorMessage(
                            "Violation constraint: no existe el Responsable de Administración con ID "
                                    + elemenInput.getRespManagementId()));
                } else if (grupoOrgAdmon.getDeleted() != null
                        && grupoOrgAdmon.getDeleted().intValue() == Constantes.NUMBER_1) {
                    errorMessageList.add(new ValidationErrorMessage("No puede grabar un elemento de catálogo estando"
                            + " su unidad Responsable de Administración de baja ("
                            + (grupoOrgAdmon != null ? grupoOrgAdmon.getName() : "") + ") en situación de baja"));
                }
                //Buscamos la pertenencia del grupoOrgAdmon con el CentroSuperio del usuario: 1o. de debajo del segundo
                if (!this.grupoService.estaContenido(grupoOrgAdmon, grupoCentroSupUser)) {
                    errorMessageList.add(new ValidationErrorMessage("La unidad Responsable de Administración debe"
                            + "ser o pertenecer al Centro al que está adscrito el usuario autenticado"));
                }
            }
        }
        return errorMessageList;
    }


    @Transactional
    public final Map<ElementoCatalogo, List<ValidationErrorMessage>> insertar(final ElementoCatalogo elemenInput,
                                                                              final Grupo grupoDpto,
                                                                              final Grupo grupoCentroSup) {

        Map<ElementoCatalogo, List<ValidationErrorMessage>> mapRetorno = new HashMap<>();
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        errMsgs.addAll(validarUnidadesOrganizativas(elemenInput, grupoDpto, grupoCentroSup));
        if (!errMsgs.isEmpty()) {
            mapRetorno.put(null, errMsgs);
        } else {
            if (elemenInput.getParentElement() != null && elemenInput.getCatalogElementCollateralId() == null) {
                elemenInput.setCatalogElementCollateralId(elemenInput.getParentElement().getId());
            }
            if (elemenInput.getCatalogElementCollateralId() != null) {
                elemenInput.setParentElement(this.elemenCatalogoRepository.getMinimalInfoOfElement(
                        elemenInput.getCatalogElementCollateralId()));
            }
            if (elemenInput.getCatalogElementCollateralId() != null && elemenInput.getParentElement() == null) {
                errMsgs.add(new ValidationErrorMessage("Error de integridad de datos: El identificador "
                        + elemenInput.getCatalogElementCollateralId() + " del elemento padre no existe en BBDD"));
                mapRetorno.put(null, errMsgs);
            } else if (elemenInput.getCatalogElementTypeId() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE
                    && elemenInput.getParentElement() == null) {
                errMsgs.add(new ValidationErrorMessage("Error integridad de datos: Un EP debe tener padre"));
                mapRetorno.put(null, errMsgs);
            } else {
                if (elemenInput.getCatalogElementTypeId() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE) {
                    elemenInput.setCappCode(elemenInput.getParentElement().getCappCode().
                            concat(elemenInput.getCappCode()));
                }
                errMsgs.addAll(evaluateBusinessRules(elemenInput, true, grupoCentroSup == null/*isAdmin*/));
                if (!errMsgs.isEmpty()) {
                    mapRetorno.put(null, errMsgs);
                } else {
                    Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
                    elemenInput.setCreationDate(timeStamp);
                    elemenInput.setDeliveryCollection(new ArrayList());
                    if (elemenInput.getSubElements() != null && !elemenInput.getSubElements().isEmpty()) {
                        List<ElementoCatalogo> children = new ArrayList<>();
                        elemenInput.getSubElements().forEach((child) -> {
                            ElementoCatalogo childElem = this.elemenCatalogoRepository.findById(child.getId()).get();
                            if (childElem.getId() == null) {
                                errMsgs.add(new ValidationErrorMessage(
                                        "Violation constraint: El ID del subelemento viaja nulo"));
                            } else { //miramos si el subelemento pertenece ya a otro parentId
                                if (childElem.getCatalogElementCollateralId() != null
                                        && childElem.getCatalogElementCollateralId().intValue() > 0) {
                                    String message = "Violation Data Constraint: El subelemento con ID "
                                            + childElem.getCatalogElementCollateralId().intValue()
                                            + " ya pertenece a otro elemento padre en la jerarquía";
                                    errMsgs.add(new ValidationErrorMessage(message));
                                }
                                children.add(childElem);
                            }
                        });
                        elemenInput.getSubElements().clear();
                        elemenInput.setSubElements(children);
                    }
                    if (errMsgs.isEmpty()) {
                        List<ValoresEjesDeElemenCatalogoUsuario> actualvaluesAttrs = new ArrayList<>(
                                elemenInput.getAttributeValuesCollection());
                        elemenInput.setAttributeValuesCollection(new ArrayList<>());
                        ElementoCatalogo elem2Saved = this.elemenCatalogoRepository.save(elemenInput);
                        for (ValoresEjesDeElemenCatalogoUsuario valorUserOrDomainId : actualvaluesAttrs) {
                            valorUserOrDomainId.setCreationDate(timeStamp);
                            valorUserOrDomainId.setCatalogElementId(elem2Saved.getId());
                            if (valorUserOrDomainId.getDomainValues() != null) {
                                for (ValorDominioDeAttrElemCat valDomain : valorUserOrDomainId.getDomainValues()) {
                                    valDomain.setCreationDate(timeStamp);
                                }
                            }
                        }
                        elem2Saved.setAttributeValuesCollection(actualvaluesAttrs);
                        elem2Saved = this.elemenCatalogoRepository.save(elem2Saved);
                        if (elem2Saved.getCatalogElementCollateralId() != null) {
                            elem2Saved.setParentElement(elemenInput.getParentElement());
                        }
                        Grupo grupoTTo = this.grupoService.getById(elem2Saved.getGroupId());
                        String grupoTToLiteral = grupoTTo.getCodigo().concat(" - ").concat(grupoTTo.getName());
                        elem2Saved.setResponsableTto(grupoTToLiteral);
                        mapRetorno.put(elem2Saved, errMsgs);
                    } else {
                        mapRetorno.put(null, errMsgs);
                    }
                }
            }
        }
        return mapRetorno;
    }

    private List<ValidationErrorMessage> protectInmmutableFields(final ElementoCatalogo elemenInput,
                                                                 final ElementoCatalogo elementoCatBBDD,
                                                                 final boolean esRolAdmin) {
        List<ValidationErrorMessage> errMsgList = new ArrayList<>();
        if (elementoCatBBDD == null) {
            errMsgList.add(new ValidationErrorMessage("El ID de este Elemento no existe en la Base de Datos"));
        } else {
            if (elementoCatBBDD.getCatalogElementTypeId() == null
                    || elementoCatBBDD.getCatalogElementTypeId().intValue()
                    != elemenInput.getCatalogElementTypeId().intValue()) {
                errMsgList.add(new ValidationErrorMessage("El ID-Tipo de Catálogo no puede ser modificado"));
            }
            if (elementoCatBBDD.getGroupId() == null) {
                errMsgList.add(
                        new ValidationErrorMessage("El campo Responsable de Tratamiento no puede ser vacío"));
            }
            if (elemenInput.getCappCode() == null
                    || (!esRolAdmin && !elementoCatBBDD.getCappCode().contentEquals(elemenInput.getCappCode()))) {
                errMsgList.add(new ValidationErrorMessage("El campo Código no puede ser vacío"));
            } else if (esRolAdmin && !elementoCatBBDD.getCappCode().contentEquals(elemenInput.getCappCode())) {
                List<ElementoCatalogo> elemsByCappCode = this.elemenCatalogoRepository.
                        getByCappCodeOptimized(elemenInput.getCappCode());
                if (elemsByCappCode != null && elemsByCappCode.size() > 0) {
                    errMsgList.add(new ValidationErrorMessage("El código CAPP <" + elemenInput.getCappCode()
                            + "> ya existe en el Catálogo"));
                }
                if (elemenInput.getCatalogElementTypeId() == TipoElementoCatalogo.APLICACION) {

                }
            }
            if (elemenInput.getCreationDate() != null && (elementoCatBBDD.getCreationDate().
                    before(elemenInput.getCreationDate())
                    || elementoCatBBDD.getCreationDate().after(elemenInput.getCreationDate()))) {
                errMsgList.add(new ValidationErrorMessage("La fecha de creación no puede ser modificada"));
            }
            // control de parent solo para EPs
            if (elementoCatBBDD.getCatalogElementTypeId().intValue() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE) {
                if (elementoCatBBDD.getCatalogElementCollateralId() == null
                        && elemenInput.getCatalogElementCollateralId() != null) {
                    errMsgList.add(
                            new ValidationErrorMessage("El ID del elemento ascendente no puede ser modificado"));
                } else if (elementoCatBBDD.getCatalogElementCollateralId() != null
                        && elemenInput.getCatalogElementCollateralId() == null) {
                    errMsgList.add(
                            new ValidationErrorMessage("El ID del elemento ascendente no puede ser modificado"));
                } else if (elementoCatBBDD.getCatalogElementCollateralId() != null
                        && elemenInput.getCatalogElementCollateralId() != null
                        && elementoCatBBDD.getCatalogElementCollateralId().intValue()
                        != elemenInput.getCatalogElementCollateralId().intValue()) {
                    errMsgList.add(
                            new ValidationErrorMessage("El ID del elemento ascendente no puede ser modificado"));
                }
            }
            // analizamos los elementos hijos, que deben ser inmutables
            if ((elementoCatBBDD.getSubElements() != null && !elementoCatBBDD.getSubElements().isEmpty())
                    && (elemenInput.getSubElements() == null || elemenInput.getSubElements().isEmpty())) {
                errMsgList.add(
                        new ValidationErrorMessage("Los subelementos de este elemento no pueden ser alterados"));
            } else if ((elemenInput.getSubElements() != null && !elemenInput.getSubElements().isEmpty())) {
                elemenInput.getSubElements().forEach((subElement) -> {
                    if (subElement.getId() == null) {
                        new ValidationErrorMessage("Violation constraint: El ID del subelemento viaja nulo");
                    } else if (!elementoCatBBDD.getSubElements().contains(subElement)) {
                        errMsgList.add(new ValidationErrorMessage(
                                "El elemento con ID " + subElement.getId() + " no pertenece a los subelementos "
                                        + "de este elemento"));
                    } else if (subElement.getId().intValue() == elemenInput.getId().intValue()) {
                        errMsgList.add(new ValidationErrorMessage("Violation Data Constraint: Referencia "
                                + "circular, el ID del subelemento coincide con el ID de este elemento"));
                    } else { //miramos si el subelemento pertenece ya a otro parentId
                        ElementoCatalogo subElementObject = this.getById(subElement.getId());
                        if (subElementObject.getCatalogElementCollateralId() != null
                                && subElementObject.getCatalogElementCollateralId().intValue()
                                != elemenInput.getId().intValue()) {
                            errMsgList.add(new ValidationErrorMessage("Violation Data Constraint: El subelemento"
                                    + " con ID " + subElementObject.getCatalogElementCollateralId().intValue()
                                    + " ya pertenece a otro elemento padre en la jerarquía"));
                        }
                    }
                });
            }
        }
        return errMsgList;
    }

    @Transactional
    public final Map<ElementoCatalogo, List<ValidationErrorMessage>> actualizar(final ElementoCatalogo elemenInput,
                                                                                final Grupo grupoDpto,
                                                                                final Grupo grupoCentroSup) {
        Map<ElementoCatalogo, List<ValidationErrorMessage>> mapRetorno = new HashMap<>();
        List<ValidationErrorMessage> errMsgs = new ArrayList<>();
        if (elemenInput.getId() == null) {
            errMsgs.add(new ValidationErrorMessage("Data Integrity Constraint Violation: "
                    + "El ID del elemento no viaja en la petición"));
            mapRetorno.put(null, errMsgs);
        } else {
            errMsgs.addAll(validarUnidadesOrganizativas(elemenInput, grupoDpto, grupoCentroSup));
            if (!errMsgs.isEmpty()) {
                mapRetorno.put(null, errMsgs);
            } else {
                if (elemenInput.getParentElement() != null && elemenInput.getCatalogElementCollateralId() == null) {
                    elemenInput.setCatalogElementCollateralId(elemenInput.getParentElement().getId());
                }
                if (elemenInput.getCatalogElementCollateralId() != null) {
                    elemenInput.setParentElement(this.elemenCatalogoRepository.getMinimalInfoOfElement(
                            elemenInput.getCatalogElementCollateralId()));
                }
                if (elemenInput.getCatalogElementCollateralId() != null && elemenInput.getParentElement() == null) {
                    errMsgs.add(new ValidationErrorMessage("Error de integridad de datos: El identificador "
                            + elemenInput.getCatalogElementCollateralId() + " del elemento padre no existe en BBDD"));
                    mapRetorno.put(null, errMsgs);
                } else if (elemenInput.getCatalogElementTypeId() == TipoElementoCatalogo.ELEMENTO_PROMOCIONABLE
                        && elemenInput.getParentElement() == null) {
                    errMsgs.add(new ValidationErrorMessage("Error integridad de datos: Un EP debe tener padre"));
                    mapRetorno.put(null, errMsgs);
                } else {
                    errMsgs.addAll(evaluateBusinessRules(elemenInput, false, grupoCentroSup == null/*isAdmin*/));
                    if (!errMsgs.isEmpty()) {
                        mapRetorno.put(null, errMsgs);
                    } else {
                        Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
                        ElementoCatalogo elementoCatBBDD = this.elemenCatalogoRepository.
                                findById(elemenInput.getId()).get();
                        if (elementoCatBBDD != null) {
                            errMsgs.addAll(protectInmmutableFields(elemenInput, elementoCatBBDD,
                                    grupoCentroSup == null/*isAdmin*/));
                            if (errMsgs.isEmpty()) {
                                elemenInput.setCatalogElementTypeId(elementoCatBBDD.getCatalogElementTypeId());
                                elemenInput.setCreationDate(elementoCatBBDD.getCreationDate());
                                elemenInput.setUpdateDate(timeStamp);
                                elemenInput.setDeliveryCollection(elementoCatBBDD.getDeliveryCollection());
                                updateClavesOfAttributes(elementoCatBBDD.getId(),
                                        elemenInput.getAttributeValuesCollection(), elementoCatBBDD.
                                                getAttributeValuesCollection());
                                List<ElementoCatalogo> children = new ArrayList<>();
                                if (elemenInput.getSubElements() != null && !elemenInput.getSubElements().isEmpty()) {
                                    elemenInput.getSubElements().forEach((child) -> {
                                        ElementoCatalogo childElem = this.elemenCatalogoRepository.
                                                findById(child.getId()).get();
                                        tratamientoChildOfElement(childElem, elemenInput, errMsgs);
                                        children.add(childElem);
                                    });
                                    elemenInput.getSubElements().clear();
                                    elemenInput.setSubElements(children);
                                }
                                if (errMsgs.isEmpty()) {
                                    ElementoCatalogo elem2Saved = this.elemenCatalogoRepository.save(elemenInput);
                                    Grupo grupoTTo = this.grupoService.getById(elem2Saved.getGroupId());
                                    String grupoTToLiteral = grupoTTo.getCodigo().concat(" - ").
                                            concat(grupoTTo.getName());
                                    elem2Saved.setResponsableTto(grupoTToLiteral);
                                    mapRetorno.put(elem2Saved, errMsgs);
                                } else {
                                    mapRetorno.put(null, errMsgs);
                                }
                            } else {
                                mapRetorno.put(null, errMsgs);
                            }
                        }
                    }
                }
            }
        }
        return mapRetorno;
    }

    public final SimplifiedAttribute getGitLabPath(final String codigo) {
        SimplifiedAttribute ret;
        AtributoEje attr = this.atributoEjeRepository.findByCodeAndDeletedIsNull(Constantes.GITLAB_PATH_CODE);
        if (attr != null) {
            ret = this.elemenCatalogoRepository.getUserValueOfAttr(codigo, attr.getId());
        } else {
            ret = new SimplifiedAttribute();
            ret.setCappCode(codigo);
            ret.setUserValue("");
            ret.setAttrName("GitLabPath");
        }
        return ret;
    }
    private void tratamientoChildOfElement(final ElementoCatalogo childElem, final ElementoCatalogo parent,
                                           final List<ValidationErrorMessage> errMsgs) {
        ElementoCatalogo retorno  = childElem;
        if (childElem.getId() == null) {
            errMsgs.add(new ValidationErrorMessage(
                    "Violation constraint: El ID del subelemento viaja nulo"));
        } else { //miramos si el subelemento pertenece ya a otro parentId
            if (childElem.getCatalogElementCollateralId() != null
                    && childElem.getCatalogElementCollateralId().intValue()
                    != parent.getId().intValue()) {
                String message = "Violation Data Constraint: El subelemento con ID "
                        + childElem.getCatalogElementCollateralId().intValue()
                        + " ya pertenece a otro elemento padre en la jerarquía";
                errMsgs.add(new ValidationErrorMessage(message));
            }
        }
    }

    public final List<SimplifiedElement> getFilteredSimplifiedElements(final ElementoCatalogoFilter filter) {

        List<SimplifiedElement> elements;
        String code = filter.getCode() != null && !"".contentEquals(filter.getCode().trim())
                ? filter.getCode().trim() : null;
        Integer groupId = filter.getGroupId() != null ? filter.getGroupId() : null;
        Integer idTypeElem = filter.getIdOfCatalogueElementType() != null
                ? filter.getIdOfCatalogueElementType() : null;
        Integer computerProcessingId = filter.getComputerProcessingId() != null
                ? filter.getComputerProcessingId() : null;


        if (code == null && groupId == null && idTypeElem == null && computerProcessingId == null) {
            elements = this.elemenCatalogoRepository.findSimplifiedElements();
        } else {
            if (computerProcessingId != null) {
                elements = this.elemenCatalogoRepository.findFilteredSimplifiedElementsCompProcessing(code, groupId,
                        idTypeElem, computerProcessingId);
            } else {
                elements = this.elemenCatalogoRepository.findFilteredSimplifiedElements(groupId,
                        idTypeElem, code);
            }
        }

        return elements;
    }


    private void updateClavesOfAttributes(final Integer idElement,
                                          final List<ValoresEjesDeElemenCatalogoUsuario> atributosNuevos,
                                          final List<ValoresEjesDeElemenCatalogoUsuario> atributosViejosEnBBDD) {

        Timestamp timeStamp = new Timestamp(Calendar.getInstance().getTime().getTime());
        Collections.sort(atributosNuevos, new ValoresAttrComparator());
        Collections.sort(atributosViejosEnBBDD, new ValoresAttrComparator());
        atributosNuevos.forEach((valorAtttrOfElem) -> {
            valorAtttrOfElem.setCatalogElementId(idElement);
            //busco su id si lo tiene la lista de atributos BBDD
            boolean stop = false;
            int i = 0;
            while (!stop && i < atributosViejosEnBBDD.size()) {
                ValoresEjesDeElemenCatalogoUsuario itemInBBDD = atributosViejosEnBBDD.get(i++);
                if (valorAtttrOfElem.getAxisAttributeId().intValue() == itemInBBDD.getAxisAttributeId().intValue()) {
                    stop = true;
                    // actualizo el atributo nuevo con la info del viejo
                    valorAtttrOfElem.setUpdateDate(timeStamp);
                    valorAtttrOfElem.setId(itemInBBDD.getId());
                    valorAtttrOfElem.setCreationDate(itemInBBDD.getCreationDate());
                    if (valorAtttrOfElem.getDomainValues() != null) {
                        // actualizo fecha alta y el valArrId para cada uno de los valoresDomAttr de este atributo
                        valorAtttrOfElem.getDomainValues().forEach((valDomAttr) -> {
                            valDomAttr.setCreationDate(itemInBBDD.getCreationDate());
                            valDomAttr.setUpdateDate(timeStamp);
                            valDomAttr.setValorEjeElemCatId(itemInBBDD.getId());
                        });
                    }
                } else if (valorAtttrOfElem.getAxisAttributeId().intValue()
                        < itemInBBDD.getAxisAttributeId().intValue()) {
                    stop = true;
                }
            }
            if (valorAtttrOfElem.getCreationDate() == null) {
                valorAtttrOfElem.setCreationDate(timeStamp);
                if (valorAtttrOfElem.getDomainValues() != null) {
                    // actualizo fecha alta de los valoresDomAttr de cada atributo
                    valorAtttrOfElem.getDomainValues().forEach((valDomAttr) -> {
                        valDomAttr.setCreationDate(timeStamp);
                    });
                }
                this.valoresEjesDeElemenCatalogoUsuarioRepository.save(valorAtttrOfElem);
            }
        });

        //anyadimos a la lista de atributosNuevos aquellos de la lista atributosViejosEnBBDD que no existan en la 1a
        atributosViejosEnBBDD.forEach((valorAtttrOfBD) -> {
            //busco su id si lo tiene la lista de atributos de entrada
            boolean found = false;
            int i = 0;
            while (!found && i < atributosNuevos.size()) {
                ValoresEjesDeElemenCatalogoUsuario itemInScreen = atributosNuevos.get(i++);
                if (valorAtttrOfBD.getAxisAttributeId().intValue() == itemInScreen.getAxisAttributeId().intValue()) {
                    found = true;
                }
            }
            if (!found) {
                // hemos de incluirlo
                atributosNuevos.add(valorAtttrOfBD);
            }
        });
    }

    @Transactional
    public final Map<ElementoCatalogo, List<ValidationErrorMessage>> borradoLogico(final Integer idElementCat) {
        List<ValidationErrorMessage> errorMessages = new ArrayList<>();
        ElementoCatalogo removedObject = null;
        ElementoCatalogo elementoCat = this.getByIdAndDeletedIsNull(idElementCat);
        if (elementoCat != null) {
            if (elementoCat.getSubElements() != null && !elementoCat.getSubElements().isEmpty()) {
                errorMessages.add(new ValidationErrorMessage("No se puede eliminar <" + elementoCat.getCappCode()
                        + "> porque existen elementos descendientes bajo éste. "
                        + "Elimine previamente sus elementos descendientes"));
            }
            if (errorMessages.isEmpty()) {
                if (elementoCat.getAttributeValuesCollection() != null) {
                    for (ValoresEjesDeElemenCatalogoUsuario valorUserOrDomainId
                            : elementoCat.getAttributeValuesCollection()) {
                        valorUserOrDomainId.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                        valorUserOrDomainId.setDeleted(1);
                        this.valoresEjesDeElemenCatalogoUsuarioRepository.save(valorUserOrDomainId);
                    }
                }
                elementoCat.setDeleted(Constantes.NUMBER_1);
                elementoCat.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
                elementoCat.setCatalogElementCollateralId(null);
                removedObject = this.elemenCatalogoRepository.save(elementoCat);
            }
        }
        Map<ElementoCatalogo, List<ValidationErrorMessage>> retorno = new HashMap<>();
        retorno.put(removedObject, errorMessages);
        return retorno;
    }


    /***
     * EN CUARENTENA
     */

    public final List<ElementoCatalogoMinimal> getPrimerNivelInferiorConAtributosCasosEspeciales(final Integer idPEl) {
        List<ElementoCatalogoMinimal> childrenOf = this.elemenCatalogoRepository.getChildrenOfIdParent(idPEl);
        childrenOf.forEach((child) -> {
            child.setAttributeValuesCollection(getAxisByElementId(child.getId()));
            child.setAttributeValuesCollection(atributosCasosEspeciales(child.getAttributeValuesCollection()));
        });
        return childrenOf;
    }


    public final List<ValoresEjesDeElemenCatalogoUsuario> getAxisByElementId(final Integer idElement) {
        List<ValoresEjesDeElemenCatalogoUsuario> returnedList = new ArrayList<>();
        List<AxisValDomain> l =
                this.valoresEjesDeElemenCatalogoUsuarioRepository.getAxisListByIdOfElement(idElement);
        l.forEach((axisWithDomainValeId) -> {
            ValoresEjesDeElemenCatalogoUsuario axisOfElem = new ValoresEjesDeElemenCatalogoUsuario();
            axisOfElem.setId(axisWithDomainValeId.getId());
            axisOfElem.setCatalogElementId(idElement);
            axisOfElem.setAxisAttributeId(axisWithDomainValeId.getAxisAttributeId());
            ValorDominioDeAttrElemCat valDom = new ValorDominioDeAttrElemCat();
            valDom.setDomainValueId(axisWithDomainValeId.getDomainValueId());
            valDom.setValorEjeElemCatId(axisWithDomainValeId.getId());
            axisOfElem.setDomainValues(List.of(valDom));
            returnedList.add(axisOfElem);
        });
        return returnedList;
    }

    /************** NUEVO METODO FINDBYID OPTIMIZADO **************************/

    public final List<ValoresEjesDeElemenCatalogoUsuario> getAttributesByElementId(final Integer idElement) {
        List<ValoresEjesDeElemenCatalogoUsuario> returnedList = new ArrayList<>();
        Integer[] auxAxis = {0};
        List<AttributeValDomain> l =
                this.valoresEjesDeElemenCatalogoUsuarioRepository.getAttributesListByIdOfElement(idElement);
        l.forEach((attributeMinimalObj) -> {
            ValoresEjesDeElemenCatalogoUsuario axisOfElem;
            if (auxAxis[0].intValue() == attributeMinimalObj.getIdAttr().intValue()) {
                axisOfElem = returnedList.get(returnedList.size() - 1); // cogemos el last grabado
                ValoresEjesDeElemenCatalogoUsuario updatedAxisOfElem = new ValoresEjesDeElemenCatalogoUsuario();
                updatedAxisOfElem.setId(axisOfElem.getId());
                updatedAxisOfElem.setCatalogElementId(idElement);
                updatedAxisOfElem.setAxisAttributeId(axisOfElem.getAxisAttributeId());
                updatedAxisOfElem.setUserValue(axisOfElem.getUserValue());
                updatedAxisOfElem.setCreationDate(axisOfElem.getCreationDate());
                updatedAxisOfElem.setDomainValues(new ArrayList<>());
                updatedAxisOfElem.getDomainValues().addAll(axisOfElem.getDomainValues());
                returnedList.set(returnedList.size() - 1, updatedAxisOfElem);
                axisOfElem = updatedAxisOfElem;
            } else {
                axisOfElem = new ValoresEjesDeElemenCatalogoUsuario();
                axisOfElem.setId(attributeMinimalObj.getIdAttr());
                axisOfElem.setCatalogElementId(idElement);
                axisOfElem.setAxisAttributeId(attributeMinimalObj.getAxisAttributeId());
                axisOfElem.setUserValue(attributeMinimalObj.getUserValue());
                axisOfElem.setCreationDate(attributeMinimalObj.getCreationDateAttr());
            }
            ValorDominioDeAttrElemCat valDom = new ValorDominioDeAttrElemCat();
            valDom.setId(attributeMinimalObj.getIdValDomainAttr());
            valDom.setDomainValueId(attributeMinimalObj.getDomainValueId());
            valDom.setValorEjeElemCatId(attributeMinimalObj.getIdAttr());
            valDom.setCreationDate(attributeMinimalObj.getCreationDateValDomainAttr());
            if (auxAxis[0].intValue() == attributeMinimalObj.getIdAttr().intValue()) {
                axisOfElem.getDomainValues().add(valDom);
            } else {
                axisOfElem.setDomainValues(List.of(valDom));
                returnedList.add(axisOfElem);
            }
            auxAxis[0] = attributeMinimalObj.getIdAttr();
        });
        return returnedList;
    }
    public final ElementoCatalogo getByIdAndDeletedIsNull(final Integer id) {
        ElementoCatalogo ele = this.elemenCatalogoRepository.getByIdAndNotNull(id);
        if (ele != null && ele.getId() != null) {
            ele.setAttributeValuesCollection(getAttributesByElementId(ele.getId()));
            List<ElementoCatalogo> childrenElements = new ArrayList<>();
            List<ElementoCatalogoMinimal> childrenOfMe = this.elemenCatalogoRepository.getChildrenOfIdParent(id);
            childrenOfMe.forEach((child) -> {
                childrenElements.add(getByIdAndDeletedIsNull(child.getId()));
            });
            ele.setSubElements(childrenElements);
        }
        return ele;
    }


    public final ElementoCatalogo getByCappCode(final String cappCode) {
        ElementoCatalogo retorno = null;
        List<ElementoCatalogo> elems = this.elemenCatalogoRepository.getByCappCodeEquals(cappCode);
        if (elems != null && elems.size() > 0) {
            ElementoCatalogo parentEl = elemenCatalogoRepository.
                    getMinimalInfoOfElement(elems.get(0).getCatalogElementCollateralId());
            if (parentEl != null) {
                elems.get(0).setParentElement(parentEl);
            }
            elems.get(0).setDeliveryCollection(null);
            retorno = elems.get(0);
            retorno.setAttributeValuesCollection(getAttributesByElementId(elems.get(0).getId()));
            List<ElementoCatalogo> childrenElements = new ArrayList<>();
            List<ElementoCatalogoMinimal> childrenOfMe = this.elemenCatalogoRepository.
                    getChildrenOfIdParent(elems.get(0).getId());
            childrenOfMe.forEach((child) -> {
                childrenElements.add(getByIdAndDeletedIsNull(child.getId()));
            });
            retorno.setSubElements(childrenElements);
        }
        return retorno;
    }

    public final void generateExcelExtended(final CodigoList elementFilter, final boolean isRelease) {
        List<ElementOrEntregaInterface> elements = new ArrayList<>();
        for (String codigo : elementFilter.getCodigos()) {
            elements.add(getByCappCode(codigo));
        }
        try {
            byte[] excelBytes = ExcelGenerator.generateExcelExtended(elements, this,
                    this.grupoService,
                    this.atributoEjeService.getAllCachedAtributos(elementFilter.getNivelOfCatalogue(), isRelease),
                    this.valorDominioService);
            elementFilter.setExcelExtended(excelBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public final void generateExcelSummarized(final CodigoList elementFilter, final boolean isRelease) {
        List<ElementOrEntregaInterface> elements = new ArrayList<>();
        for (String codigo : elementFilter.getCodigos()) {
            elements.add(getByCappCode(codigo));
        }
        try {
            byte[] excelBytes = ExcelGenerator.generateExcelSummarized(elements, this,
                    this.grupoService,
                    this.atributoEjeService.getAllCachedAtributos(elementFilter.getNivelOfCatalogue(), isRelease),
                    this.valorDominioService);
            elementFilter.setExcelExtended(excelBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public final String getValueOfAttr(final AtributoEje atributoEje,
                                       final ElementOrEntregaInterface item,
                                       final ValorDominioService valorDominioService) {
        String returnedvalue = null;
        for (ValoresEjesDeElemenCatalogoUsuario val : item.getCatalogueAttributeValuesCollection()) {
            if (val.getAxisAttributeId().intValue() == atributoEje.getId().intValue()) {
                if (atributoEje.getValuesInDomain() == Constantes.NUMBER_1
                        && atributoEje.getDomainValues() != null && !atributoEje.getDomainValues().isEmpty()
                        && val.getDomainValues() != null) {
                    StringBuilder listaValores = new StringBuilder("");
                    val.getDomainValues().forEach((domainValue) -> {
                        if (domainValue != null && domainValue.getDomainValueId() != null) {
                            ValorDominio valorDominio = valorDominioService.get(domainValue.getDomainValueId());
                            listaValores.append(valorDominio.getName());
                            listaValores.append(", ");
                        }
                    });
                    returnedvalue = listaValores.toString();
                    if (returnedvalue.endsWith(", ")) {
                        returnedvalue = returnedvalue.substring(0, returnedvalue.indexOf(", "));
                    }

                } else {
                    returnedvalue = val.getUserValue() == null ? "" : val.getUserValue();
                }
                if (returnedvalue == null) {
                    returnedvalue = "";
                }
            }
        }
        if (returnedvalue == null) {
            returnedvalue = "No aplica";
        }
        return returnedvalue;
    }


}
