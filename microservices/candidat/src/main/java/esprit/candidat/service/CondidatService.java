package esprit.candidat.service;

import esprit.candidat.condidatRepo.CondidatRepo;
import esprit.candidat.entity.Condidat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CondidatService {
    @Autowired
    private CondidatRepo condidatRepo;

    public List<Condidat> findAll() {
        return condidatRepo.findAll();
    }

    public Optional<Condidat> findById(int id) {
        return condidatRepo.findById(id);
    }

    public Condidat save(Condidat condidat) {
        return condidatRepo.save(condidat);
    }

    public Condidat update(int id, Condidat condidatDetails) {
        return condidatRepo.findById(id).map(condidat -> {
            condidat.setFirstName(condidatDetails.getFirstName());
            condidat.setLastName(condidatDetails.getLastName());
            condidat.setEmail(condidatDetails.getEmail());
            return condidatRepo.save(condidat);
        }).orElseThrow(() -> new RuntimeException("Condidat not found with id " + id));
    }

    public void delete(int id) {
        condidatRepo.deleteById(id);
    }
}
