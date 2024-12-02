package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

@Controller
public class BarbershopController {
    @Autowired
    private BarbershopService barbershopService;

    @GetMapping("/")
    public String home(Model model) {
        try {
            model.addAttribute("message", "Добро пожаловать в барбершоп!");
            return "index";
        } catch (Exception e) {
            return "error";
        }
    }
    @GetMapping("/master/")
    public String master(Model model, @Param("keyword") String keyword) {
        try {
            List<Master> masterlist = barbershopService.getAllMasters(keyword);
            model.addAttribute("masterList", masterlist);
            model.addAttribute("keyword", keyword);
            return "master";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/master/delete/{id}")
    public String deleteMaster(@PathVariable Integer id) {
        try {
            barbershopService.deleteMaster(id);
            return "redirect:/master/";
        } catch (DataIntegrityViolationException e) {
            return "data_error";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/master/new")
    public String newmaster(Model model) {
        try {
            Master master = new Master();
            model.addAttribute("master", new Master());
            return "newmaster";
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/master/save")
    public String save(@ModelAttribute("master") Master master) {
        try {
            barbershopService.saveMaster(master);
            return "redirect:/master/";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/master/edit/{id}")
    public ModelAndView editMaster(@PathVariable Integer id) {
        try {
            ModelAndView mav = new ModelAndView("editmaster");
            Master master = barbershopService.getMaster(id);
            mav.addObject("master", master);
            return mav;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/service/")
    public String service(Model model, @Param("keyword") String keyword) {
        try {
            List<Service> servicelist = barbershopService.getAllServices(keyword);
            model.addAttribute("serviceList", servicelist);
            model.addAttribute("keyword", keyword);
            return "service";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/service/delete/{id}")
    public String deleteService(@PathVariable Integer id) {
        try {
            barbershopService.deleteService(id);
            return "redirect:/service/";
        } catch (DataIntegrityViolationException e) {
            return "data_error";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/service/new")
    public String newService(Model model) {
        try {
            Service service = new Service();
            model.addAttribute("service", service);
            return "newservice"; // Шаблон для создания новой услуги
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/service/save")
    public String saveService(@ModelAttribute("service") Service service) {
        try {
            barbershopService.saveService(service);
            return "redirect:/service/";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/service/edit/{id}")
    public ModelAndView editService(@PathVariable Integer id) {
        try {
            ModelAndView mav = new ModelAndView("editservice");
            Service service = barbershopService.getService(id);
            mav.addObject("service", service);
            return mav;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/client/")
    public String client(Model model, @Param("keyword") String keyword) {
        try {
            List<Client> clientlist = barbershopService.getAllClient(keyword);
            model.addAttribute("clientList", clientlist);
            model.addAttribute("keyword", keyword);
            return "client";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        try {
            barbershopService.deleteClient(id);
            return "redirect:/client/";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/client/new")
    public String newClient(Model model) {
        try {
            Client client = new Client();
            model.addAttribute("client", client);
            return "newclient"; // Шаблон для создания нового клиента
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        try {
            barbershopService.saveClient(client);
            return "redirect:/client/";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/client/edit/{id}")
    public ModelAndView editClient(@PathVariable Integer id) {
        try {
            ModelAndView mav = new ModelAndView("editclient");
            Client client = barbershopService.getClient(id);
            mav.addObject("client", client);
            return mav;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/master_service/")
    public String masterservice(Model model, @Param("keyword") String keyword) {
        try {
            List<MasterService> masterServiceList = barbershopService.getAllMasterService(keyword);
            model.addAttribute("masterServiceList", masterServiceList);
            model.addAttribute("keyword", keyword);
            return "master_service";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/master_service/delete/{id}")
    public String deleteMasterService(@PathVariable Integer id) {
        try {
            barbershopService.deleteMasterService(id);
            return "redirect:/master_service/";
        } catch (Exception e) {
            return "error";
        }
    }

    @RequestMapping("/master_service/new")
    public String newMasterService(Model model) {
        try {
            MasterService MasterService = new MasterService();
            model.addAttribute("MasterService", MasterService);
            return "newmaster_service"; // Шаблон для создания нового клиента
        } catch (Exception e) {
            return "error";
        }
    }

    @PostMapping("/master_service/save")
    public String saveMasterService(@ModelAttribute("MasterService") MasterService MasterService) {
        try {
            barbershopService.saveMasterService(MasterService);
            return "redirect:/master_service/";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/master_service/edit/{id}")
    public ModelAndView editMasterService(@PathVariable Integer id) {
        try {
            ModelAndView mav = new ModelAndView("editMasterService");
            MasterService MasterService = barbershopService.getMasterService(id);
            mav.addObject("MasterService", MasterService);
            return mav;
        } catch (Exception e) {
            return new ModelAndView("error");
        }
    }

    @GetMapping("/category/")
    public String category(Model model, @Param("keyword") String keyword) {
        try {
            List<Category> categoryList = barbershopService.getAllCategory(keyword);
            model.addAttribute("categoryList", categoryList);
            model.addAttribute("keyword", keyword);
            return "category";
        } catch (Exception e) {
            return "error";
        }
    }
}
