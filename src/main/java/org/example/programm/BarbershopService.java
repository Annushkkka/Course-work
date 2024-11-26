package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarbershopService {
    @Autowired
    private MasterRepository repoMaster;
    @Autowired
    private ServiceRepository repoService;
    @Autowired
    private ClientRepository repoClient;
    @Autowired
    private CategoryRepository repoCategory;
    @Autowired
    private MasterServiceRepository repoMasterService;

    // Методы для класса Master
    //Вывод мастеров
    public List<Master> getAllMasters(String keyword) {
        if (keyword != null) {
            return repoMaster.search(keyword);
        }
        return repoMaster.findAll();
    }
    //Получение информации по мастеру
    public Master getMaster(Integer id) {
        return repoMaster.findById(id).get();
    }
    //Удаление мастера
    public void deleteMaster(Integer id) {
        repoMaster.deleteById(id);
    }

    // Методы для класса Service
    // Вывод всех услуг
    public List<org.example.programm.Service> getAllServices(String keyword) {
        if (keyword != null) {
            return repoService.search(keyword);
        }
        return repoService.findAll();
    }
    // Получение информации по услуге
    public org.example.programm.Service getService(Integer id) {
        return repoService.findById(id).get();
    }
    // Удаление услуги
    public void deleteService(Integer id) {
        repoService.deleteById(id);
    }

    // Методы для класса Client
    // Вывод всех услуг
    public List<Client> getAllClient(String keyword) {
        if (keyword != null) {
            return repoClient.search(keyword);
        }
        return repoClient.findAll();
    }
    // Получение информации по услуге
    public Client getClient(Integer id) {
        return repoClient.findById(id).get();
    }
    // Удаление услуги
    public void deleteClient(Integer id) {
        repoClient.deleteById(id);
    }


}
