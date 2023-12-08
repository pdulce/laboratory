package giss.mad.itinerario.service;

import giss.mad.itinerario.model.itinerario.UmbralPactado;
import giss.mad.itinerario.repository.itinerario.UmbralPactadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
public class UmbralPactadoService {

    @Autowired
    private UmbralPactadoRepository umbralPactadoRepository;

    public final void setUmbralPactadoRepository(final UmbralPactadoRepository umbralPactadoRepository) {
        this.umbralPactadoRepository = umbralPactadoRepository;
    }

    public final List<UmbralPactado> getAllByActividadItinerarioId(final Integer activityItineraryId) {
        return this.umbralPactadoRepository.findByActivityItineraryIdAndDeletedIsNull(activityItineraryId);
    }

    @Transactional
    public final void actualizarUmbralPactado(final Integer activityItineraryId, final Double newValue) {
        Timestamp currentDate = new Timestamp(Calendar.getInstance().getTime().getTime());

        Optional<UmbralPactado> registroUmbralBBDDOpt = this.umbralPactadoRepository.
                findByActivityItineraryIdAndDischargeDateIsNullAndDeletedIsNull(activityItineraryId);

        if (registroUmbralBBDDOpt.isPresent()) {
            UmbralPactado registroUmbralBBDD = registroUmbralBBDDOpt.get();
            if (!registroUmbralBBDD.getValue().equals(newValue)
                    && registroUmbralBBDD.getValue() < newValue) {
                registroUmbralBBDD.setDischargeDate(currentDate);
                registroUmbralBBDD.setUpdateDate(currentDate);
                this.umbralPactadoRepository.save(registroUmbralBBDD);

                guardarNuevoRegistroUmbralPactado(activityItineraryId, newValue, currentDate);
            }

        } else {
            guardarNuevoRegistroUmbralPactado(activityItineraryId, newValue, currentDate);
        }
    }

    @Transactional
    private void guardarNuevoRegistroUmbralPactado(final Integer activityItineraryId,
                                                   final Double newValue, final Timestamp currentDate) {
        UmbralPactado newRegistroUmbral = new UmbralPactado();
        newRegistroUmbral.setActivityItineraryId(activityItineraryId);
        newRegistroUmbral.setValue(newValue);
        newRegistroUmbral.setCreationDate(currentDate);
        this.umbralPactadoRepository.save(newRegistroUmbral);

    }

}
