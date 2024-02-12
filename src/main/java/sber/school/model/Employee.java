package sber.school.model;

import sber.school.model.enums.Position;

public class Employee {
    private String firstName;
    private String lastName;
    private Position position;

    public Employee(String firstName, String lastName, Position position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }
}
