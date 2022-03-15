package com.jumia.service.manager;

import com.jumia.service.domains.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * returns all customers if pagination params not provided
     * returns paginated customers
     * @param pageIndex
     * @param pageSize
     * @return List<Customer>
     * */
    List<Customer> getCustomers(Integer pageSize, Integer pageIndex);
}
