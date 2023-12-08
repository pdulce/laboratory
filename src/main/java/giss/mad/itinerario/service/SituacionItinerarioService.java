package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.SituacionItinerario;
import giss.mad.itinerario.repository.itinerario.SituacionItinerarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class SituacionItinerarioService {

    @Autowired
    private SituacionItinerarioRepository situacionItinerarioRepository;

    public final void setSituacionItinerarioRepository(final SituacionItinerarioRepository
                                                               situacionItinerarioRepository) {
        this.situacionItinerarioRepository = situacionItinerarioRepository;
    }

    public final List<SituacionItinerario> getAll() {
        return this.situacionItinerarioRepository.findAllByDeletedIsNull();
    }

    public final SituacionItinerario get(final Integer id) {
        return this.situacionItinerarioRepository.findByIdAndDeletedIsNull(id);
    }

    @Transactional
    public final SituacionItinerario insertar(final SituacionItinerario situacion) {
        situacion.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        return this.situacionItinerarioRepository.save(situacion);
    }

    @Transactional
    public final SituacionItinerario actualizar(final SituacionItinerario situacion) {
        SituacionItinerario registroBBDD =
                this.situacionItinerarioRepository.findByIdAndDeletedIsNull(situacion.getId());
        if (registroBBDD != null) {
            registroBBDD.setDescription(situacion.getDescription());
            registroBBDD.setName(situacion.getName());
            registroBBDD.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            registroBBDD = this.situacionItinerarioRepository.save(registroBBDD);
        }
        return registroBBDD;
    }

    @Transactional
    public final SituacionItinerario borradoLogico(final int id) {
        SituacionItinerario deleted = null;
        SituacionItinerario registroBBDD = this.situacionItinerarioRepository.findByIdAndDeletedIsNull(id);
        if (registroBBDD != null) {
            registroBBDD.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
            registroBBDD.setDeleted(1);
            deleted = this.situacionItinerarioRepository.save(registroBBDD);
        }
        return deleted;
    }

}
