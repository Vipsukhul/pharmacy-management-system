package com.pharmacy.pms.controller;

import com.pharmacy.pms.model.Employee;
import com.pharmacy.pms.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("employee", new Employee());
        return "employee/list";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @PostMapping("/{id}/deactivate")
    public String deactivate(@PathVariable Long id) {
        employeeService.deactivate(id);
        return "redirect:/employees";
    }
}
