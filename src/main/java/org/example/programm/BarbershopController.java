package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/service/")
    public String service(Model model, @Param("keyword")String keyword) {
        List<Service> servicelist = barbershopService.getAllServices(keyword);
        model.addAttribute("serviceList", servicelist);
        model.addAttribute("keyword", keyword);
        return "service";
    }

    @GetMapping("/client/")
    public String client(Model model, @Param("keyword")String keyword) {
        List<Client> clientlist = barbershopService.getAllClient(keyword);
        model.addAttribute("clientList", clientlist);
        model.addAttribute("keyword", keyword);
        return "client";
    }

    @PostMapping("/master/delete/{id}")
    public String deletemaster(@PathVariable Integer id) {
        barbershopService.deleteMaster(id);
        return "redirect:/master/";
    }
}
