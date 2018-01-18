package com.assignment.service.impl;

import com.assignment.model.Customer;
import com.assignment.repository.CustomerRepository;
import com.assignment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sai Vichet
 * Date     : 1/18/2018, 9:39 AM
 * Email    : v.sai@gl-f.com
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> all() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getByID(Long id) {
        return customerRepository.findOne(id);
    }
}
