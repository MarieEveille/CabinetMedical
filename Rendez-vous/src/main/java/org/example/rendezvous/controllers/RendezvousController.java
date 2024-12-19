package org.example.rendezvous.controllers;


import org.example.rendezvous.models.Rendezvous;
import org.example.rendezvous.services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezvousController {

    @Autowired
    private RendezvousService rendezvousService;

    private final List<Rendezvous> rendezvous = new ArrayList<>();

    @GetMapping("/all")
    public List<Rendezvous> getAllRendezvous() {
        return rendezvousService.getAllRendezvous(rendezvous);
    }

    @GetMapping("/getRendezvous/{id}")
    public Rendezvous getRendezvousById(@PathVariable int id) {
        return rendezvousService.getRendezvousById(rendezvous, id);
    }

    @GetMapping("/getRendezvousByPatient/{idPatient}")
    public List<Rendezvous> getRendezvousByPatient(@PathVariable int idPatient) {
        return rendezvousService.getRendezvousByPatient(rendezvous, idPatient);
    }

    @GetMapping("/getRendezvousByPraticien/{idPraticien}")
    public List<Rendezvous> getRendezvousByPraticien(@PathVariable int idPraticien) {
        return rendezvousService.getRendezvousByPraticien(rendezvous, idPraticien);
    }

    @PostMapping("/create")
    public Rendezvous createRendezvous(
            @RequestBody Rendezvous rendezvous1
    ) {
        return rendezvousService.createRendezvous(rendezvous, rendezvous1);
    }

    @PutMapping("/update/{id}")
    public Rendezvous updateRendezvous(
            @PathVariable int id,
            @RequestBody Rendezvous updatedRendezvous
    ) {
        return rendezvousService.updateRendezvous(rendezvous, id, updatedRendezvous);
    }

    @DeleteMapping("/delete/{id}")
    public Boolean deleteRendezvous(@PathVariable int id) {
        rendezvousService.deleteRendezvous(rendezvous, id);
        return true;
    }
}
