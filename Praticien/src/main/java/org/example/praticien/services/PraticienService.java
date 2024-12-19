package org.example.praticien.services;

import org.example.praticien.models.Praticien;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PraticienService {

    public List<Praticien> getAllPraticiens(List<Praticien> praticiens) {
        return praticiens;
    }

    public String getPraticienById(List<Praticien> praticiens, int id) {
        for (Praticien praticien : praticiens) {
            if (praticien.getId() == id) {
                return praticien.toString();
            }
        }
        return "Praticien not found";
    }

    public Praticien createPraticien(List<Praticien> praticiens, Praticien praticien) {
        praticiens.add(praticien);
        return praticien;
    }

    public Praticien updatePraticien(List<Praticien> praticiens, int id, Praticien updatedPraticien) {
        for (Praticien praticien : praticiens) {
            if (praticien.getId() == id) {
                praticien.setName(updatedPraticien.getName());
                praticien.setFirstName(updatedPraticien.getFirstName());
                praticien.setEmail(updatedPraticien.getEmail());
                praticien.setPhone(updatedPraticien.getPhone());
                praticien.setAddress(updatedPraticien.getAddress());
                return praticien;
            }
        }
        return null;
    }

    public void deletePraticien(List<Praticien> praticiens, int id) {
        for (Praticien praticien : praticiens) {
            if (praticien.getId() == id) {
                praticiens.remove(praticien);
                return;
            }
        }
    }


}
