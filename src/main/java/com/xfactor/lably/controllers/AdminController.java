package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    ArrayList<Admin> admins = new ArrayList<>();

    
    @PostMapping("/addAdmin")
    public Admin addAdminPost(@RequestBody Admin admin) {
       // Admin admin = new Admin();
        // admin.setName(name);
        // admin.setUsername(username);
        // admin.setPassword(password);

        admins.add(admin);
        return admin;
    }

    @GetMapping("/getAdmins")
    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    
    @GetMapping("/getAdminByUserName")
    public Admin getAdminByUserName(@RequestParam String username) {
        Admin resAdmin = null;
        for (Admin admin : admins) {
            if (admin.getUsername().equalsIgnoreCase(username)) {
                resAdmin = admin;
            }
        }
        return resAdmin;
    }

    
}
