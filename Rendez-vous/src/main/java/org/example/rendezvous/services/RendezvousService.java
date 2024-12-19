package org.example.rendezvous.services;


import org.example.rendezvous.models.Rendezvous;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RendezvousService {


    private final ExternalServiceClient externalServiceClient;

    public RendezvousService(ExternalServiceClient externalServiceClient) {
        this.externalServiceClient = externalServiceClient;
    }

    public Rendezvous createRendezvous(List<Rendezvous> rendezvous, Rendezvous rendezvous1) {
        if (!externalServiceClient.isPatientExists(rendezvous1.getIdPatient())) {
            throw new IllegalArgumentException("Patient with ID " + rendezvous1.getIdPatient() + " does not exist");
        }

        if (!externalServiceClient.isPraticienExists(rendezvous1.getIdPraticien())) {
            throw new IllegalArgumentException("Praticien with ID " + rendezvous1.getIdPraticien() + " does not exist");
        }

        rendezvous.add(rendezvous1);
        return rendezvous1;
    }

    public List<Rendezvous> getAllRendezvous(List<Rendezvous> rendezvous) {
        return  rendezvous;
    }

    public Rendezvous getRendezvousById(List<Rendezvous> rendezvous, int id) {
        return rendezvous.stream()
                .filter(rendezvous1 -> rendezvous1.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rendez-vous introuvable avec l'ID : " + id));
    }

    public List<Rendezvous> getRendezvousByPatient(List<Rendezvous> rendezvous, int idPatient) {
        return rendezvous.stream()
                .filter(r -> r.getIdPatient() == idPatient)
                .collect(Collectors.toList());
    }


    public List<Rendezvous> getRendezvousByPraticien(List<Rendezvous> rendezvous, int idPraticien) {
        return rendezvous.stream()
                .filter(r -> r.getIdPraticien() == idPraticien)
                .collect(Collectors.toList());
         }



    public Rendezvous updateRendezvous(List<Rendezvous> rendezvous, int id, Rendezvous updatedRendezvous) {
        Rendezvous rendezvous1 = getRendezvousById(rendezvous, id);
        rendezvous1.setDate(updatedRendezvous.getDate());
        rendezvous1.setHeure(updatedRendezvous.getHeure());
        return rendezvous1;
    }

    public Rendezvous deleteRendezvous(List<Rendezvous> rendezvous, int id) {
        Rendezvous rendezvous1 = getRendezvousById(rendezvous, id);
        rendezvous.remove(rendezvous1);
        return rendezvous1;
    }
}
