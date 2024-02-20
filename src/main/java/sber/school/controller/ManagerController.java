package sber.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sber.school.model.Manager;
import sber.school.model.enums.Department;
import sber.school.service.ManagerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public ModelAndView getAll(ModelAndView model) {
        List<Manager> managers = managerService.getManagers();
        model.addObject("managers", managers);
        model.setViewName("manager/manager");

        return model;
    }

    @PostMapping
    public String create(@ModelAttribute Manager manager) {
        manager.setEmployees(new ArrayList<>());
        managerService.createManager(manager);
        return "redirect:/manager";
    }

    @GetMapping("/{id}")
    public ModelAndView getManager(ModelAndView model, @PathVariable int id) {
        Manager manager = managerService.getManager(id);
        model.addObject("manager", manager);
        model.setViewName("manager/profile");
        return model;
    }

    @DeleteMapping("/{id}")
    public String deleteManager(@PathVariable int id) {
        managerService.deleteManager(id);
        return "redirect:/manager";
    }

    @PutMapping("/{id}")
    public String putEmployee(@PathVariable int id, @ModelAttribute Manager manager) {
        managerService.updateManager(id, manager);
        return "redirect:/manager/" + id;
    }

    @GetMapping("/create")
    public ModelAndView showCreate(ModelAndView modelAndView) {
        modelAndView.setViewName("manager/createManager");
        Manager manager = new Manager();
        modelAndView.addObject(manager);
        modelAndView.addObject("departments", Department.values());
        return modelAndView;
    }

    @GetMapping("/{id}/update")
    public ModelAndView showUpdate(@PathVariable int id, ModelAndView modelAndView) {
        modelAndView.setViewName("/manager/updateManager");
        Manager manager = managerService.getManager(id);
        modelAndView.addObject(manager);
        modelAndView.addObject("departments", Department.values());
        return modelAndView;
    }
}
