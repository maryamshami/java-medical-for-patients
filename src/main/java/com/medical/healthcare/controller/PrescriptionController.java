package com.medical.healthcare.controller;

import com.medical.healthcare.model.Drug;
import com.medical.healthcare.model.Prescription;
import com.medical.healthcare.service.DrugService;
import com.medical.healthcare.service.PrescriptionService;
import com.medical.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping()
public class PrescriptionController {

//    private final UserService userService;
//    private final PrescriptionService prescriptionService;
//    private final DrugService drugService;
//
//    public PrescriptionController(PrescriptionService prescriptionService, DrugService drugService , UserService userService) {
//        this.prescriptionService = prescriptionService;
//        this.drugService = drugService;
//        this.userService=userService;
//    }
//
//    @GetMapping("/prescriptions")
//    public String getAllPrescriptions(Model model) {
//        List<Prescription> prescriptions = prescriptionService.getAllPrescriptions();
//        model.addAttribute("prescriptions", prescriptions);
//        return "prescriptions";
//    }
//
//    @GetMapping("/prescriptions/{id}")
//    public String getPrescriptionById(@PathVariable("id") Long id, Model model) {
//        Prescription prescription = prescriptionService.getPrescriptionById(id);
//        model.addAttribute("prescription", prescription);
//        return "prescription";
//    }
//
//    @PostMapping("/prescriptions")
//    public String createPrescription(@ModelAttribute("prescription") Prescription prescription, Model model) {
//        prescriptionService.createPrescription(prescription);
//        model.addAttribute("message", "Prescription created successfully");
//        return "redirect:/prescriptions";
//    }

//    @GetMapping("/prescriptions/new")
//    public String showCreateForm(Model model) {
//        model.addAttribute("prescription", new Prescription());
//        model.addAttribute("drugs", drugService.getAllDrugs());
//        model.addAttribute("users", userService.getAllUsers());
//        return "create-prescription";
//    }
//    @GetMapping("/prescriptions/delete/{id}")
//    public String deletePrescription(@PathVariable("id") Long id, Model model) {
//        prescriptionService.deletePrescription(id);
//        model.addAttribute("message", "Prescription deleted successfully");
//        return "redirect:/prescriptions";
//    }
//
//    @GetMapping("/prescriptions/search")
//    public String searchPrescriptions(@RequestParam("q") String query, Model model) {
//        List<Prescription> prescriptions = prescriptionService.searchPrescriptions(query);
//        model.addAttribute("prescriptions", prescriptions);
//        return "prescriptions";
//    }
//
//    @GetMapping("/medicines/search1")
//    public String searchMedicines(@RequestParam("q") String query, Model model) {
//        List<Drug> drugs = drugService.searchDrugs(query);
//        model.addAttribute("drugs", drugs);
//        return "medicines";
//    }

    // Other controller methods for the remaining requirements

}
