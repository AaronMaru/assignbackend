package com.assignment.service;

import com.assignment.model.Customer;

import java.util.List;

/**
 * Created by Sai Vichet
 * Date     : 1/18/2018, 9:37 AM
 * Email    : v.sai@gl-f.com
 */
public interface CustomerService {
    List<Customer> all();

    void create(Customer customer);

    Customer getByID(Long id);
}
