package sber.school.repository;

import sber.school.model.Manager;

import java.util.List;

public interface ManagerRepository {

    void createManager(Manager manager);

    Manager getManager(int id);

    List<Manager> getManagers();

    void updateManager(int id, Manager manager);

    void deleteManager(int id);
}
