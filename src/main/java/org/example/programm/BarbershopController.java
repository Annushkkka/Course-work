package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BarbershopController {
    @Autowired
    private BarbershopService barbershopService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Добро пожаловать в барбершоп!");
        return "index";
    }
    @GetMapping("/master/")
    public String master(Model model, @Param("keyword")String keyword) {
        List<Master> masterlist = barbershopService.getAllMasters(keyword);
        model.addAttribute("masterList", masterlist);
        model.addAttribute("keyword", keyword);
        return "master";
    }

    @GetMapping("/master/delete/{id}")
    public String deletemaster(@PathVariable Integer id) {
        barbershopService.deleteMaster(id);
        return "redirect:/master/";
    }

    @RequestMapping("/master/new")
    public String newmaster(Model model) {
        Master master = new Master();
        model.addAttribute("master", new Master());
        return "newmaster";
    }

    @PostMapping("/master/save")
    public String save(@ModelAttribute("master") Master master) {
        barbershopService.saveMaster(master);
        return "redirect:/master/";
    }

    @GetMapping("/master/edit/{id}")
    public ModelAndView editMaster(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("editmaster");
        Master master = barbershopService.getMaster(id);
        mav.addObject("master", master);
        return mav;
    }

    @GetMapping("/service/")
    public String service(Model model, @Param("keyword")String keyword) {
        List<Service> servicelist = barbershopService.getAllServices(keyword);
        model.addAttribute("serviceList", servicelist);
        model.addAttribute("keyword", keyword);
        return "service";
    }

    @GetMapping("/service/delete/{id}")
    public String deleteService(@PathVariable Integer id) {
        barbershopService.deleteService(id);
        return "redirect:/service/";
    }

    @RequestMapping("/service/new")
    public String newService(Model model) {
        Service service = new Service();
        model.addAttribute("service", service);
        return "newservice"; // Шаблон для создания новой услуги
    }

    @PostMapping("/service/save")
    public String saveService(@ModelAttribute("service") Service service) {
        barbershopService.saveService(service);
        return "redirect:/service/";
    }

    @GetMapping("/service/edit/{id}")
    public ModelAndView editService(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("editservice");
        Service service = barbershopService.getService(id);
        mav.addObject("service", service);
        return mav;
    }

    @GetMapping("/client/")
    public String client(Model model, @Param("keyword")String keyword) {
        List<Client> clientlist = barbershopService.getAllClient(keyword);
        model.addAttribute("clientList", clientlist);
        model.addAttribute("keyword", keyword);
        return "client";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable Integer id) {
        barbershopService.deleteClient(id);
        return "redirect:/client/";
    }

    @RequestMapping("/client/new")
    public String newClient(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "newclient"; // Шаблон для создания нового клиента
    }

    @PostMapping("/client/save")
    public String saveClient(@ModelAttribute("client") Client client) {
        barbershopService.saveClient(client);
        return "redirect:/client/";
    }

    @GetMapping("/client/edit/{id}")
    public ModelAndView editClient(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("editclient");
        Client client = barbershopService.getClient(id);
        mav.addObject("client", client);
        return mav;
    }
}
