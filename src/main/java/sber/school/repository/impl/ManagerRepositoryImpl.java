package sber.school.repository.impl;

import org.springframework.stereotype.Repository;
import sber.school.model.Employee;
import sber.school.model.Manager;
import sber.school.repository.EmployeeRepository;
import sber.school.repository.ManagerRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static sber.school.model.enums.Department.*;

@Repository
public class ManagerRepositoryImpl implements ManagerRepository {

    private final EmployeeRepository employeeRepository;

    private final List<Manager> managers = new ArrayList<>();
    private int managerId = 0;

    public ManagerRepositoryImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    void init() {
        managers.add(new Manager(managerId++, "Dima", "Repin", DEVELOPMENT, new ArrayList<>()));
        managers.add(new Manager(managerId++, "Vitaliy", "Lobov", DESIGN, new ArrayList<>()));
        managers.add(new Manager(managerId++, "Elena", "Popova", TESTING, new ArrayList<>()));
        updateEmployees();
    }


    @Override
    public void createManager(Manager manager) {
        manager.setId(managerId++);
        managers.add(manager);
        updateEmployees();
    }

    @Override
    public Manager getManager(int id) {
        updateEmployees();
        return managers.stream()
                .filter((m) -> m.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Manager> getManagers() {
        updateEmployees();
        return managers;
    }

    @Override
    public void updateManager(int id, Manager updatedManager) {
        Manager oldManager = getManager(id);
        oldManager.setFirstName(updatedManager.getFirstName());
        oldManager.setLastName(updatedManager.getLastName());
        oldManager.setDepartment(updatedManager.getDepartment());
        updateEmployees();
    }

    @Override
    public void deleteManager(int id) {
        managers.removeIf((m) -> m.getId() == id);
    }

    private void updateEmployees() {
        List<Employee> employees = employeeRepository.getEmployees();
        managers.forEach(
                (m) -> employees.forEach(
                        (e) -> {
                            if (m.getDepartment() == e.getDepartment()) {
                                if (!m.getEmployees().contains(e)) m.addEmployee(e);
                            } else {
                                if (m.getEmployees().contains(e)) m.removeEmployee(e.getId());
                            }
                        }
                )
        );
    }
}
