package com.jumia.rest.controllers;

import com.jumia.service.domains.Customer;
import com.jumia.service.manager.CustomerService;
import com.jumia.service.rest.controllers.CustomerController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService service;
    @InjectMocks
    private CustomerController controller;
    private List<Customer> customers;

    @Before
    public void setUp() {
        //Given:
        customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test");
        customer.setPhone("1234");
        customers.add(customer);
    }
    @Test
    public  void GetCustomers_ValidParams_returnCustomerList(){
        //When:
       Mockito.when(service.getCustomers(anyInt(), anyInt())).thenReturn(customers);
        //Then:
        List<Customer> response = controller.getCustomers(1, 1);
        Assert.assertFalse(response.isEmpty());
    }
}
