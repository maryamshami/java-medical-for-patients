package com.medical.healthcare.controller;

import com.medical.healthcare.controller.dto.PrescriptionDto;
import com.medical.healthcare.model.Drug;
import com.medical.healthcare.model.Prescription;
import com.medical.healthcare.model.User;
import com.medical.healthcare.repository.PrescriptionRepository;
import com.medical.healthcare.service.DrugService;
import com.medical.healthcare.service.PrescriptionService;
import com.medical.healthcare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class PharmacistController {

    private final PrescriptionRepository prescriptionRepository;
    private final UserService userService;
    private final PrescriptionService prescriptionService;
    private final DrugService drugService;

    public PharmacistController(PrescriptionRepository prescriptionRepository,
                                UserService userService, PrescriptionService prescriptionService,
                                DrugService drugService) {
        this.prescriptionRepository = prescriptionRepository;
        this.userService = userService;
        this.prescriptionService = prescriptionService;
        this.drugService = drugService;
    }

    @GetMapping("/pharmacist")
    public String pharmacist(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);
        List<Prescription> prescriptionList = prescriptionService.getAllPrescriptions();
        model.addAttribute("prescriptions", prescriptionList);
        return "pharmacist";
    }


    @GetMapping("/pharmacist/delete/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
//        prescriptionRepository.deleteByUserId(id);
        prescriptionService.deletePrescription(id);
        return "redirect:/pharmacist"; // Redirect to the pharmacist page after deletion
    }



}
