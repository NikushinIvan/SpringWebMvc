package sber.school.repository.impl;

import org.springframework.stereotype.Repository;
import sber.school.model.Employee;
import sber.school.model.enums.Department;
import sber.school.repository.EmployeeRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static sber.school.model.enums.Department.*;
import static sber.school.model.enums.Position.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final List<Employee> employees = new ArrayList<>();
    private int employeeId = 0;

    @PostConstruct
    void init() {
        employees.add(new Employee(employeeId++, "Ivan", "Romanov", JUNIOR, DESIGN));
        employees.add(new Employee(employeeId++, "Kirill", "Titov", MIDDLE, DEVELOPMENT));
        employees.add(new Employee(employeeId++, "Maria", "Lipatova", SENIOR, TESTING));
    }

    @Override
    public void createEmployee(Employee employee) {
        employee.setId(employeeId++);
        employees.add(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        return employees.stream()
                .filter((e) -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Employee> getEmployees() {
        return employees;
    }

    @Override
    public void updateEmployee(int id, Employee updatedEmployee) {
        Employee oldEmployee = getEmployee(id);
        oldEmployee.setFirstName(updatedEmployee.getFirstName());
        oldEmployee.setLastName(updatedEmployee.getLastName());
        oldEmployee.setPosition(updatedEmployee.getPosition());
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf((e) -> e.getId() == id);
    }
}
