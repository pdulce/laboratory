package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.Configuracion;
import giss.mad.itinerario.repository.itinerario.ConfiguracionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Service
public class ConfiguracionService {

    @Autowired
    private ConfiguracionRepository configuracionRepository;

    public final void setConfiguracionRepository(final ConfiguracionRepository configuracionRepository) {
        this.configuracionRepository = configuracionRepository;
    }

    public final List<Configuracion> getAll() {
        return this.configuracionRepository.findAllByDeletedIsNull();
    }

    public final Configuracion getById(final Integer id) {
        return this.configuracionRepository.findByIdAndDeletedIsNull(id);
    }

    public final Configuracion getByKey(final String name) {
        return this.configuracionRepository.findByKeyAndDeletedIsNull(name);
    }

    @Transactional
    public final Configuracion insertar(final Configuracion configuracion) {
        configuracion.setCreationDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        configuracion.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        return this.configuracionRepository.save(configuracion);
    }

    @Transactional
    public final Configuracion actualizar(final Configuracion configuracion) {
        configuracion.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        return this.configuracionRepository.save(configuracion);
    }

    @Transactional
    public final Configuracion borradoLogico(final int idConfigkey) {
        Configuracion config = getById(idConfigkey);
        config.setUpdateDate(new Timestamp(Calendar.getInstance().getTime().getTime()));
        config.setDeleted(1);
        return this.configuracionRepository.save(config);
    }

}
