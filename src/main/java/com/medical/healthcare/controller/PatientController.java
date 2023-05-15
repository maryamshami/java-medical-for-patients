package com.medical.healthcare.controller;

import com.medical.healthcare.model.User;
import com.medical.healthcare.service.DrugService;
import com.medical.healthcare.service.PrescriptionService;
import com.medical.healthcare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping()
public class PatientController {

    private final UserService userService;
    private final PrescriptionService prescriptionService;
    private final DrugService drugService;

    public PatientController(UserService userService, PrescriptionService prescriptionService, DrugService drugService) {
        this.userService = userService;
        this.prescriptionService = prescriptionService;
        this.drugService = drugService;
    }

    @GetMapping("/patient")
    public String patient(Model model){
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        return "patient";
    }


//    @GetMapping("/get")
//    public String showCreateForm(Model model) {
////        model.addAttribute("prescription", new Prescription());
//        model.addAttribute("drugs", drugService.getAllDrugs());
//        model.addAttribute("users", userService.getAllUsers());
//        return "patient";
//    }
//
//    @PostMapping("/prescriptions")
//    public String createPrescription(@ModelAttribute Prescription prescription) {
//        prescriptionService.savePrescription(prescription);
//        return "redirect:/doctor/new";
//    }
}
