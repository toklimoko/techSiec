package pl.tokl.webapp.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tokl.webapp.webapp.Model.Medicine;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    public List<Medicine> medicines;

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

        medicines.add(newMedicine);

        return "redirect:/main";
    }


    @PostMapping("/edit")
    public String editSubmit(@RequestParam Long oldID, Long id, String name, String substance, String dose, int units, int packages){


        medicines.add(new Medicine(id,name,substance,dose,units,packages));

        return "redirect:/main";
    }




}
