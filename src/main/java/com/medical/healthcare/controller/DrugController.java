package com.medical.healthcare.controller;

import com.medical.healthcare.model.Drug;
import com.medical.healthcare.service.DrugService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping()
public class DrugController {

//    private final DrugService drugService;
//
//    public DrugController(DrugService drugService) {
//        this.drugService = drugService;
//    }
//
//    @GetMapping("/medicines")
//    public String getAllDrugs(Model model) {
//        List<Drug> drugs = drugService.getAllDrugs();
//        model.addAttribute("drugs", drugs);
//        return "medicines";
//    }
//
//    @GetMapping("/medicines/{id}")
//    public String getDrugById(@PathVariable("id") Long id, Model model) {
//        Drug drug = drugService.getDrugById(id);
//        model.addAttribute("drug", drug);
//        return "medicine";
//    }
//
//    @PostMapping("/medicines")
//    public String createDrug(@ModelAttribute("drug") Drug drug, Model model) {
//        drugService.createDrug(drug);
//        model.addAttribute("message", "Drug created successfully");
//        return "redirect:/medicines";
//    }
//
//    @GetMapping("/medicines/delete/{id}")
//    public String deleteDrug(@PathVariable("id") Long id, Model model) {
//        drugService.deleteDrug(id);
//        model.addAttribute("message", "Drug deleted successfully");
//        return "redirect:/medicines";
//    }
//
//    @GetMapping("/medicines/search")
//    public String searchDrugs(@RequestParam("q") String query, Model model) {
//        List<Drug> drugs = drugService.searchDrugs(query);
//        model.addAttribute("drugs", drugs);
//        return "medicines";
//    }
//
//    // Other controller methods for the remaining requirements

}
