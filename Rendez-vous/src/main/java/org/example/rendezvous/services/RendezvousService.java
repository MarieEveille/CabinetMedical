package org.example.rendezvous.services;


import org.example.rendezvous.models.Rendezvous;
import org.example.rendezvous.services.CalendarificService;
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

        String holidays = CalendarificService.getHolidays("FR", "2024"); // Pays et année dynamiques
        //System.out.printf("Holidays : %s\n", holidays);
        if (rendezvous1 == null || rendezvous1.getDateHeure() == null) {
            return null;
        }
        System.out.printf("Date : %s\n", rendezvous1.getDateHeure().toLocalDate().toString());
        if (holidays.contains(rendezvous1.getDateHeure().toLocalDate().toString())) {
            System.out.printf("Le rendez-vous ne peut pas être pris un jour férié\n %s\n", holidays);
            return null;
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
//        Rendezvous rendezvous1 = getRendezvousById(rendezvous, id);
//        rendezvous1.setDate(updatedRendezvous.getDate());
//        rendezvous1.setHeure(updatedRendezvous.getHeure());
       // return rendezvous1;
        return updatedRendezvous;
    }

    public Rendezvous deleteRendezvous(List<Rendezvous> rendezvous, int id) {
        Rendezvous rendezvous1 = getRendezvousById(rendezvous, id);
        rendezvous.remove(rendezvous1);
        return rendezvous1;
    }
}
