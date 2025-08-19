package com.location.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.location.project.entity.Info;
import com.location.project.service.InfoService;

@Controller
public class HomeController {
	
	 @Autowired
	    private InfoService infoService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    
    @GetMapping("/aboutus")
    public String aboutus() {
        return "aboutus";
    }
    
    @GetMapping("/contactus")
    public String contactus() {
        return "contactus";
    }
    
   

    @GetMapping("/updateinfo")
    public String showUpdateInfoForm() {
        return "updateinfo";
    }
    
    @PostMapping("/saveinfo")
    public String saveInfo(Info info, Model model) {
        // Assuming Info is an entity class with fields for email, location, and issue
        infoService.saveInfo(info);
        model.addAttribute("success", "Information saved successfully!");
        return "updateinfo"; // Redirect back to the updateinfo page with a success message
    }
}
