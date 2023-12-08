package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.Peso;
import giss.mad.itinerario.model.volatilentities.PesoGraph;
import giss.mad.itinerario.repository.itinerario.EjeHeredableRepository;
import giss.mad.itinerario.repository.itinerario.PesoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PesoService {

    @Autowired
    private PesoRepository pesoRepository;

    @Autowired
    private EjeHeredableRepository ejeHeredableRepository;

    public final void setPesoRepository(final PesoRepository pesoRepository) {
        this.pesoRepository = pesoRepository;
    }

    public final void setEjeHeredableRepository(final EjeHeredableRepository ejeHeredableRepository) {

        this.ejeHeredableRepository = ejeHeredableRepository;
    }

    public final Collection<Peso> getAll() {
        return this.pesoRepository.findAllByDeletedIsNull();
    }

    public final Collection<PesoGraph> getAllByElement(final Integer idElement, final Integer isDelivery) {
        /*Collection<Peso> c = this.pesoRepository.findAllByDeletedIsNullAndElementTypeIdAndForDelivery(idElement,
            isDelivery, Sort.by(Sort.Order.desc("axisAttributeId")));
        if (c == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Collection<PesoGraph> pesos = new ArrayList<>();
        for (Peso peso : c) {
            PesoGraph pesoGraph = new PesoGraph();
            pesoGraph.setActivityId(peso.getActivityId());
            pesoGraph.setAxisAttributeId(peso.getAxisAttributeId());
            pesoGraph.setWeightValue(peso.getWeightValue());
            pesos.add(pesoGraph);
        }*/
        Collection<PesoGraph>  pesos = this.pesoRepository.filtrarPorTipoCatalogoYEntrega(idElement, isDelivery);
        return pesos;
    }

    public final Peso get(final Integer idPeso) {
        return this.pesoRepository.findByIdAndDeletedIsNull(idPeso);
    }

    /*@Transactional
    public final Peso removePhysical(final Integer idPeso) {
        Peso peso = this.get(idPeso);
        this.pesoRepository.delete(peso);
        return peso;
    }*/

    @Transactional
    public final Peso save(final Peso peso) {
        return this.pesoRepository.save(peso);
    }

    @Transactional
    public final Peso update(final Peso peso) {
        Peso updatedObject = null;
        if (this.pesoRepository.findById(peso.getId()).isPresent()) {
            updatedObject = this.pesoRepository.save(peso);
        }
        return updatedObject;
    }

}

