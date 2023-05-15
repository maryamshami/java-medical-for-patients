package com.medical.healthcare.controller;

import com.medical.healthcare.controller.dto.PrescriptionDto;
import com.medical.healthcare.controller.dto.UserRegistrationDto;
import com.medical.healthcare.model.Drug;
import com.medical.healthcare.model.Prescription;
import com.medical.healthcare.model.User;
import com.medical.healthcare.repository.PrescriptionRepository;
import com.medical.healthcare.repository.UserRepository;
import com.medical.healthcare.service.DrugService;
import com.medical.healthcare.service.PrescriptionService;
import com.medical.healthcare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
//@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    public PrescriptionRepository prescriptionRepository;

    private final UserService userService;
    private final PrescriptionService prescriptionService;
    private final DrugService drugService;

    public DoctorController(UserService userService, PrescriptionService prescriptionService, DrugService drugService) {
        this.userService = userService;
        this.prescriptionService = prescriptionService;
        this.drugService = drugService;
    }
    @GetMapping("/doctor")
    public String showUserList(Model model) {
        List<User> userList = userService.getAllUsers();
        model.addAttribute("users", userList);

        PrescriptionDto prescriptionDto = new PrescriptionDto();
        model.addAttribute("prescriptionDto", prescriptionDto);
        return "doctor";
    }

    //doctor/delete/user/{id}
//    @PostMapping("/doctor/delete/user/{id}")
//    public String deleteItem(@PathVariable("id") Long id) {
//        // Delete the item by ID using the itemService or repository
//        prescriptionRepository.deleteId(id);
//        userService.deleteById(id);
//
//        // Redirect the user to the item list page or any other page
//        return "doctor";
//    }

    @PostMapping("/doctor/delete/user/{id}")
    public String deleteItem(@PathVariable("id") Long id) {
        // Delete related prescriptions
        prescriptionRepository.deleteByUserId(id);

        // Delete the user
        userService.deleteById(id);

        // Redirect the user to the item list page or any other page
        return "redirect:/doctor";
    }
    @PostMapping("/doctor")
    public String createPrescriptionNew( @ModelAttribute("prescriptionDto")PrescriptionDto prescriptionDto,
                                      BindingResult result
    ){
        User existingUser= userService.findByIdentificationNumber(prescriptionDto.getIdentificationNumber());
        Drug existingDrug= drugService.getDrugByName(prescriptionDto.getDrugName());

        if(existingUser!=null&& existingDrug!=null){
            Prescription prescription=new Prescription();
            prescription.setUser(existingUser);
            prescription.setDate(new Date());

            prescription.setDrug(existingDrug);
            prescriptionService.createPrescription(prescription);

        }

        return "doctor";

    }








//    @GetMapping("/new")
//    public String showCreateForm(Model model) {
//        model.addAttribute("prescription", new Prescription());
//        model.addAttribute("drugs", drugService.getAllDrugs());
//        model.addAttribute("users", userService.getAllUsers());
//        return "doctor";
//    }
//
//    @PostMapping("/prescriptions")
//    public String createPrescription(@ModelAttribute Prescription prescription) {
//        prescriptionService.savePrescription(prescription);
//        return "redirect:/doctor/new";
//    }



//    @GetMapping()
//    public String showUserList(Model model) {
//        List<User> userList = userService.getAllUsers();
//        model.addAttribute("users", userList);
//        return "doctor";
//    }

    ///create-prescription

    @GetMapping("/doctor/create-prescription")
    public String showCreatePrescriptionForm(Model model) {
        PrescriptionDto prescriptionDto = new PrescriptionDto();
        model.addAttribute("prescriptionDto", prescriptionDto);
        return "create-prescription";
    }

    @PostMapping("/doctor/create-prescription")
    public String createPrescription( @ModelAttribute("prescriptionDto")PrescriptionDto prescriptionDto,
                                      BindingResult result
            ){
          User existingUser= userService.findByIdentificationNumber(prescriptionDto.getIdentificationNumber());
          Drug existingDrug= drugService.getDrugByName(prescriptionDto.getDrugName());

          if(existingUser!=null&& existingDrug!=null){
              Prescription prescription=new Prescription();
              prescription.setUser(existingUser);
              prescription.setDate(prescriptionDto.getDate());
              prescription.setDrug(existingDrug);
              prescriptionService.createPrescription(prescription);

        }

              return "create-prescription";

    }

//    @PostMapping("/doctor/create-prescription")
//    public String showUserList(Model model) {
//        model.addAttribute("users", userRepository.findAll());
//        return "create-prescription";
//    }




//    @RequestMapping("/new")
//    public String newEmployeePage(Model model) {
//        Employee employee = new Employee();
//        PrescriptionDto prescriptionDto=new P
//        model.addAttribute("employee",employee);
//        return "new_employee";
//    }
//
//    @RequestMapping(value="/save", method = RequestMethod.POST )
//    public String saveEmployee(@ModelAttribute("employee") Employee stu) {
//        service.save(stu);
//        return "redirect:/";
//    }


}
