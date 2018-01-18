package com.assignment.controller;

import com.assignment.model.Customer;
import com.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Sai Vichet
 * Date     : 1/18/2018, 9:11 AM
 * Email    : v.sai@gl-f.com
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String index(Model model){
        List<Customer> customers= customerService.all();
        model.addAttribute("content_path", "customer/content");
        model.addAttribute("content", "content");
        model.addAttribute("customers", customers);

        return "index";
    }

    @GetMapping("/create")
    public String create(Model model){
        Customer customer = new Customer();
        model.addAttribute("content_path", "customer/create");
        model.addAttribute("content", "content");
        model.addAttribute("button", "Save");
        model.addAttribute("customer", customer);
        return "index";
    }
    @PostMapping("/create")
    public String store(@ModelAttribute @Valid Customer customer, Model model){
        customerService.create(customer);
        return "redirect:/customer";
    }

    @GetMapping("/view")
    public String show(@RequestParam("customerId") Long id, Model model){
        Customer customer = customerService.getByID(id);
        model.addAttribute("content_path", "customer/show");
        model.addAttribute("content", "content");
        model.addAttribute("customer", customer);
        return "index";
    }

    @GetMapping("/update")
    public String edit(@RequestParam("customerId") Long id, Model model){
        Customer customer = customerService.getByID(id);
        model.addAttribute("content_path", "customer/create");
        model.addAttribute("content", "content");
        model.addAttribute("customer", customer);
        model.addAttribute("button", "Update");
        return "index";
    }
}
