package sber.school.service;

import sber.school.aspect.Logging;
import sber.school.model.Manager;

import java.util.List;

public interface ManagerService {

    @Logging
    void createManager(Manager manager);

    @Logging
    Manager getManager(int id);

    @Logging
    List<Manager> getManagers();

    @Logging
    void updateManager(int id, Manager manager);

    @Logging
    void deleteManager(int id);

}
