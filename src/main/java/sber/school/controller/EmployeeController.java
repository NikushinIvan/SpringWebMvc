package sber.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sber.school.model.Employee;
import sber.school.model.enums.Department;
import sber.school.model.enums.Position;
import sber.school.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ModelAndView getAll(ModelAndView model) {
        List<Employee> employees = employeeService.getEmployees();
        model.addObject("employees", employees);
        model.setViewName("employee");

        return model;
    }

    @PostMapping
    public String create(@ModelAttribute Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employee";
    }

    @GetMapping("/{id}")
    public ModelAndView getEmployee(ModelAndView model, @PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        model.addObject("employee", employee);
        model.setViewName("profile");
        return model;
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employee";
    }

    @GetMapping("/create")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("createEmployee");
        Employee employee = new Employee();
        modelAndView.addObject(employee);
        modelAndView.addObject("positions", Position.values());
        modelAndView.addObject("departments", Department.values());
        return modelAndView;
    }
}