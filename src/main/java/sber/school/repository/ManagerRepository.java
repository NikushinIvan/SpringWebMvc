package sber.school.repository;

import sber.school.model.Employee;

import java.util.List;

public interface ManagerRepository {

    void createManager(Employee employee);

    Employee getManager(int id);

    List<Employee> getManager();

    void updateManager(int id, Employee employee);

    void deleteManager(int id);
}
