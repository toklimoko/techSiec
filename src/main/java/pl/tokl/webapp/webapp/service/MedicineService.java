package pl.tokl.webapp.webapp.service;

import org.springframework.stereotype.Service;
import pl.tokl.webapp.webapp.Model.Medicine;
import pl.tokl.webapp.webapp.Repository.MedicineRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MedicineService {


    private MedicineRepository medicineRepository;

    public MedicineService(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @Transactional
    public void update(){
        Optional<Medicine> byId = medicineRepository.findById(2L);
        Medicine polfenon = byId.get();
        polfenon.setName("Polichlor");
    }
}
