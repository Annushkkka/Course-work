package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    //Сохранение мастера
    public void saveMaster(@ModelAttribute("master") Master master) {
        repoMaster.save(master);
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
    //Сохранение услуг
    public void saveService(@ModelAttribute("service") org.example.programm.Service service) {
        repoService.save(service);
    }


    // Методы для класса Client
    // Вывод всех клиентов
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
    //Сохранение клиентов
    public void saveClient(@ModelAttribute("client") Client client) {
        repoClient.save(client);
    }

    // Методы для класса MasterService
    // Вывод всего списка
    public List<MasterService> getAllMasterService(String keyword) {
        if (keyword != null) {
            return repoMasterService.search(keyword);
        }
        return repoMasterService.findAll();
    }
    // Получение информации по услуге
    public MasterService getMasterService(Integer id) {
        return repoMasterService.findById(id).get();
    }
    // Удаление услуги
    public void deleteMasterService(Integer id) {
        repoMasterService.deleteById(id);
    }
    //Сохранение клиентов
    public void saveMasterService(@ModelAttribute("master_service") MasterService MasterService) {
        repoMasterService.save(MasterService);
    }

    // Методы для класса Категрий
    // Вывод всего списка
    public List<Category> getAllCategory(String keyword) {
        if (keyword != null) {
            return repoCategory.search(keyword);
        }
        return repoCategory.findAll();
    }

}
