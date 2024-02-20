package sber.school.service.impl;

import org.springframework.stereotype.Service;
import sber.school.aspect.Logging;
import sber.school.model.Employee;
import sber.school.repository.EmployeeRepository;
import sber.school.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Logging
    public void createEmployee(Employee employee) {
        employeeRepository.createEmployee(employee);
    }

    @Override
    @Logging
    public Employee getEmployee(int id) {
        return employeeRepository.getEmployee(id);
    }

    @Override
    @Logging
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @Override
    @Logging
    public void updateEmployee(int id, Employee employee) {
        employeeRepository.updateEmployee(id, employee);
    }

    @Override
    @Logging
    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }
}
