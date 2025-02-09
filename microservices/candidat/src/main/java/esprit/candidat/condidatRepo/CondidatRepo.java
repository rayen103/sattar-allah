package esprit.candidat.condidatRepo;

import esprit.candidat.entity.Condidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CondidatRepo extends JpaRepository<Condidat, Integer> {
}
