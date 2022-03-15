package com.jumia.service.rest.controllers;

import com.jumia.service.domains.Customer;
import com.jumia.service.manager.CustomerService;
import com.jumia.service.rest.api.CustomerApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController implements CustomerApi {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Override
    public List<Customer> getCustomers(Integer pageSize, Integer pageIndex) {
        return customerService.getCustomers(pageSize, pageIndex);
    }
}
