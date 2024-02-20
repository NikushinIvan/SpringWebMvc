package sber.school.service;

import sber.school.aspect.Logging;
import sber.school.model.Employee;

import java.util.List;

public interface EmployeeService {

    void createEmployee(Employee employee);
    Employee getEmployee(int id);

    List<Employee> getEmployees();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

}
