package sber.school.repository;

import sber.school.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void createEmployee(Employee employee);

    Employee getEmployee(int id);

    List<Employee> getEmployees();

    void updateEmployee(int id, Employee employee);

    void deleteEmployee(int id);

}
