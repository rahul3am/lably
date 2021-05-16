package com.xfactor.lably.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.xfactor.lably.entity.Customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  ArrayList<Customer> customers = new ArrayList<>();
    
  @PostMapping("/addCustomer")
  public Customer addCustomerPost(@RequestBody Customer customer){
      customers.add(customer);
      return customer;
  }

  @GetMapping("/getCustomers")
  public ArrayList<Customer> getCustomers(){
      return customers;
  }

  @GetMapping("/getCustomerByName")
  public Customer getCustomerByName(@RequestParam String name)
  {
      Customer resCustomer=null;
      for(Customer customer : customers)
      {
          if(customer.getName().equalsIgnoreCase(name)){
              resCustomer=customer;
          }
      }
      return resCustomer;

  }

}
