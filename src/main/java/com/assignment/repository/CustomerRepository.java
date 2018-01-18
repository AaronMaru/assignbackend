package com.assignment.repository;

import com.assignment.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sai Vichet
 * Date     : 1/18/2018, 9:22 AM
 * Email    : v.sai@gl-f.com
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
