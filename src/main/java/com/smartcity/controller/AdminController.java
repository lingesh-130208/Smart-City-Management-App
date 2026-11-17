package com.smartcity.controller;

import com.smartcity.model.ComplaintStatus;
import com.smartcity.service.ComplaintService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final ComplaintService service;

    public AdminController(ComplaintService service){
        this.service = service;
    }

    @GetMapping
    public String dashboard(Model m){
        m.addAttribute("complaints", service.all());
        m.addAttribute("statuses", ComplaintStatus.values());
        return "admin";
    }

    @PostMapping("/complaints/{id}/update")
    public String update(@PathVariable Long id, @RequestParam String department, @RequestParam ComplaintStatus status){
        service.update(id, department, status);
        return "redirect:/admin";
    }
}
