package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Lab;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lab")
public class LabController {

    ArrayList<Lab> labs= new ArrayList<>();

    @PostMapping("/addLab")
    public Lab addLabPost(@RequestBody Lab lab) {
        labs.add(lab);
        return lab;
    }

    @GetMapping("/getLabs")
    public ArrayList<Lab> getLabs(){
        return labs;
    } 

    @GetMapping("/getLabByName")
    public Lab getLabByName(@RequestParam String name) {
        Lab resLab = null;
        for(Lab lab : labs){
            if(lab.getName().equalsIgnoreCase(name)) {
            resLab=lab;
            }
        }
        return resLab;

    }

    
}
