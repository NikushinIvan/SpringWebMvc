package sber.school.model;

import sber.school.model.enums.Department;
import sber.school.model.enums.Position;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Position position;
    private Department department;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, Position position, Department department) {
        this(firstName, lastName, position, department);
        this.id = id;
    }

    public Employee(String firstName, String lastName, Position position, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.department = department;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
