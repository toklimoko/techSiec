package pl.tokl.webapp.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tokl.webapp.webapp.Model.Medicine;

import java.util.Optional;

public interface MedicineRepository extends JpaRepository<Medicine,Long> {

    Optional<Medicine> findByNameIgnoreCase(String name);
}
