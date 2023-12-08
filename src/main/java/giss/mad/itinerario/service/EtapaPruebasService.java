package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.ActividadQA;
import giss.mad.itinerario.model.itinerario.EtapaPruebas;
import giss.mad.itinerario.repository.itinerario.ActividadQARepository;
import giss.mad.itinerario.repository.itinerario.EtapaPruebasRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class EtapaPruebasService {

    @Autowired
    private EtapaPruebasRepository etapaPruebasRepository;

    @Autowired
    private ActividadQARepository actividadQARepository;

    public final void setEtapaPruebasRepository(final EtapaPruebasRepository etapaPruebasRepository) {
        this.etapaPruebasRepository = etapaPruebasRepository;
    }

    public final void setActividadQARepository(final ActividadQARepository actividadQARepository) {
        this.actividadQARepository = actividadQARepository;
    }

    public final List<EtapaPruebas> getAll() {
        return this.etapaPruebasRepository.findAllByDeletedIsNull(Sort.by("id"));
    }

    public final EtapaPruebas get(final Integer id) {
        EtapaPruebas etapa = this.etapaPruebasRepository.findByIdAndDeletedIsNull(id);
        List<ActividadQA> actividades = this.actividadQARepository.getAllFilteredByStageId(id);
        etapa.setActividadesQA(actividades);
        return etapa;
    }

    @Transactional
    public final EtapaPruebas insertar(final EtapaPruebas etapaPruebas) {
        etapaPruebas.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        return this.etapaPruebasRepository.save(etapaPruebas);
    }

    @Transactional
    public final EtapaPruebas actualizar(final EtapaPruebas etapaPruebas) {
        EtapaPruebas etapaToUpdateBBDD = this.etapaPruebasRepository.findByIdAndDeletedIsNull(etapaPruebas.getId());
        if (etapaToUpdateBBDD != null) {
            etapaToUpdateBBDD.setDescription(etapaPruebas.getDescription());
            etapaToUpdateBBDD.setName(etapaPruebas.getName());
            etapaToUpdateBBDD.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            etapaToUpdateBBDD.setActividadesQA(this.actividadQARepository.
                    findAllByTestingStageIdAndDeletedIsNull(etapaPruebas.getId()));
            etapaToUpdateBBDD = this.etapaPruebasRepository.save(etapaToUpdateBBDD);
        }
        return etapaToUpdateBBDD;
    }

    @Transactional
    public final EtapaPruebas borradoLogico(final int idEtapaPruebas) {
        EtapaPruebas deleted = this.etapaPruebasRepository.findByIdAndDeletedIsNull(idEtapaPruebas);
        List<ActividadQA> actividades = this.actividadQARepository.
                getAllFilteredByStageId(deleted.getId());
        if (actividades.isEmpty()) {
            deleted.setDeleted(1);
            deleted.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            this.etapaPruebasRepository.save(deleted);
        } else {
            deleted = null;
        }
        return deleted;
    }

}
