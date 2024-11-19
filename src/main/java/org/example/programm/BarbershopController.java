package org.example.programm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class BarbershopController {
    @Autowired
    private BarbershopService barbershopService;

    @GetMapping("/")
    public String index(Model model, @Param("keyword")String keyword) {
        List<Master> masterlist = barbershopService.getAllMasters(keyword);
        model.addAttribute("masterList", masterlist);
        model.addAttribute("keyword", keyword);
        List<Service> servicelist = barbershopService.getAllServices(keyword);
        model.addAttribute("serviceList", servicelist);
        model.addAttribute("keyword", keyword);
        return "index";
    }
}