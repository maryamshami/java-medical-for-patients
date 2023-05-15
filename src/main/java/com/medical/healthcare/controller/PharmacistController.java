package com.medical.healthcare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class PharmacistController {
//    @GetMapping("/pharmacist")
//    public String showPharmacist(Model model) {
////        List<User> userList = userService.getAllUsers();
////        model.addAttribute("users", userList);
//
////        PrescriptionDto prescriptionDto = new PrescriptionDto();
////        model.addAttribute("prescriptionDto", prescriptionDto);
//        return "pharmacist";
//    }

    @GetMapping("/pharmacist")
    public String pharmacist(){
        return "pharmacist";
    }
}
