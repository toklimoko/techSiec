package pl.tokl.webapp.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tokl.webapp.webapp.Model.Medicine;
import pl.tokl.webapp.webapp.Repository.MedicineRepository;
import pl.tokl.webapp.webapp.service.MedicineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    public List<Medicine> medicines;
    private MedicineRepository medicineRepository;
    private MedicineService medicineService;


    @Autowired
    public MainController(MedicineRepository medicineRepository, MedicineService medicineService) {
        this.medicineRepository = medicineRepository;
        this.medicineService = medicineService;
    }



    public MainController() {
        medicines = new ArrayList<>();
        medicines.add(new Medicine((long) 1,"Azycyna","Azithromycinum","500 mg", 3,10));
        medicines.add(new Medicine((long) 2,"Polfenon","Propafenon chlorowodorku","150 mg",60,14));
        medicines.add(new Medicine((long) 3, "Apap","Paracetamolum","500 mg",24,30));
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        System.out.println("Ktoś otworzył stronę główną (main.html)");



//
        medicines = medicineRepository.findAll();
        model.addAttribute("medicines",medicines);
        model.addAttribute("newMedicine",new Medicine());

        return "/main.html";
    }

    @GetMapping("/")
    public String main(Model model) {
        System.out.println("Ktoś otworzył podstronę main");


        return "redirect:/main";
    }

    @GetMapping("/add")
    public String add() {
        return "add";
    }


    @PostMapping("/add")

    public String addSubmit(Medicine newMedicine){

        medicineRepository.save(newMedicine);
//        medicines.add(newMedicine);

        return "redirect:/main";
    }

    @GetMapping("/medicine/{name}")
    public String getMedicine(Model model, @PathVariable String name){
        Optional<Medicine> medicineByName = medicineRepository.findByNameIgnoreCase(name);
        medicineByName.ifPresent(medicine -> model.addAttribute("medicine",medicine));

        return medicineByName.map(medicine -> "singlemedicine").orElse("nomedicine");
    }

//
//    @PostMapping("/edit")
//    public String editSubmit(@RequestParam Long oldID, Long id, String name, String substance, String dose, int units, int packages){
//
//
//        medicines.add(new Medicine(id,name,substance,dose,units,packages));
//
//        return "redirect:/main";
//    }


    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteMedicine(@PathVariable Long id){
        medicineRepository.deleteById(id);
        return "Usunięto lek o id " + id;
    }

    @GetMapping("/update")
    @ResponseBody
    public String update(){
        medicineService.update();
        return "Zaktualizowano lek";
    }



}
