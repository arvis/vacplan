package com.supercorp.vacplan;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VacationController {

    private final VacationService service = new VacationService();
//    @Autowired private VacationService service;

    @RequestMapping("/")
    public String index() {
        return "There will be main page";
    }

    @GetMapping("/all")
    @ResponseBody
    public List allVacations() {
        User user = new User(0, "user");
        return service.allVacations();
    }


    @GetMapping("/vacation")
    @ResponseBody
    public Vacation getEmployerVacations(
            @RequestParam(name = "employeeId", required = false, defaultValue = "1") long employeeId
    ) {
        User user = new User(employeeId, "user");
        return new Vacation(employeeId, user);
    }

    @PostMapping("/vacation/add")
    public ResponseEntity<String> addEmployerVacations(@RequestBody VacationInput vacationInput) {
        System.out.println(vacationInput.getStartDate());
        service.addVacationFromRequest(vacationInput);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping("/vacation/delete")
    public String deleteEmployerVacations() {
        return "Delete";
    }

    @RequestMapping("/admin/employee/add")
    public String addEmployer() {
        return "add employee";
    }

}
