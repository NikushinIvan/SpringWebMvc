package sber.school.model;

import sber.school.model.enums.Department;
import java.util.List;


public class Manager {
    private int id;
    private String firstName;
    private String lastName;
    private Department department;
    private List<Employee> employees;

    public Manager(int id, String firstName, String lastName, Department department, List<Employee> employees) {
        this(firstName, lastName, department, employees);
        this.id = id;
    }

    public Manager(String firstName, String lastName, Department department, List<Employee> employees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.employees = employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
