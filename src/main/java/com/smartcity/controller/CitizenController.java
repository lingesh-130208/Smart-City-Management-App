package com.smartcity.controller;

import com.smartcity.model.Complaint;
import com.smartcity.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CitizenController {
    private final ComplaintService service;

    public CitizenController(ComplaintService service){
        this.service = service;
    }

 @GetMapping("/")
    public String home(){
        return "index";
    }

 @GetMapping("/complaints/new")
    public String form(Model m){
 m.addAttribute("complaint", new Complaint());
        return "complaint-form";
    }

 @PostMapping("/complaints")
    public String submit(@ModelAttribute Complaint c, Model m){
        try {
 m.addAttribute("complaint", service.submit(c));
            return "submitted";
        } catch (Exception e) {
 m.addAttribute("error", "Unable to submit complaint. Check the details.");
 m.addAttribute("complaint", c);
            return "complaint-form";
        }
    }

 @GetMapping("/track")
    public String trackForm(){
        return "track-form";
    }

 @PostMapping("/track")
    public String track(@RequestParam String trackingCode, Model m){
        try {
 m.addAttribute("complaint", service.track(trackingCode));
            return "tracking-result";
        } catch (IllegalArgumentException e) {
 m.addAttribute("error", e.getMessage());
            return "track-form";
        }
    }
}
