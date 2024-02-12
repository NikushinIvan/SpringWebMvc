package sber.school.model;

import sber.school.model.enums.Department;
import java.util.List;


public class Manager {
    private String firstName;
    private String lastName;
    private Department department;
    private List<Employee> employees;

    public Manager(String firstName, String lastName, Department department, List<Employee> employees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employees = employees;
    }
}
