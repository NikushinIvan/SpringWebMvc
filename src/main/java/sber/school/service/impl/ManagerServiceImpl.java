package sber.school.service.impl;

import org.springframework.stereotype.Service;
import sber.school.model.Manager;
import sber.school.repository.ManagerRepository;
import sber.school.service.ManagerService;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void createManager(Manager manager) {
        managerRepository.createManager(manager);
    }

    @Override
    public Manager getManager(int id) {
        return managerRepository.getManager(id);
    }

    @Override
    public List<Manager> getManagers() {
        return managerRepository.getManagers();
    }

    @Override
    public void updateManager(int id, Manager manager) {
        managerRepository.updateManager(id, manager);
    }

    @Override
    public void deleteManager(int id) {
        managerRepository.deleteManager(id);
    }
}
