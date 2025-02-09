package esprit.candidat.controller;

import esprit.candidat.entity.Condidat;
import esprit.candidat.service.CondidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidats")
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Condidat>> listCandidats() {
        return ResponseEntity.ok(condidatService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Condidat> getCandidatById(@PathVariable int id) {
        Optional<Condidat> condidat = condidatService.findById(id);
        return condidat.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Condidat> createCandidat(@RequestBody Condidat condidat) {
        return new ResponseEntity<>(condidatService.save(condidat), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Condidat> updateCandidat(@PathVariable int id, @RequestBody Condidat condidatDetails) {
        return ResponseEntity.ok(condidatService.update(id, condidatDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidat(@PathVariable int id) {
        condidatService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
