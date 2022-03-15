package com.jumia.manager.impl;

import com.jumia.service.domains.Customer;
import com.jumia.service.manager.impl.CustomerServiceImpl;
import com.jumia.service.repositories.CustomerRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;
    private Page<Customer> customerPage;
    private List<Customer> customers;
    @InjectMocks
    private CustomerServiceImpl service;

    @Before
    public void setUp(){
        //Given:
        customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("Test");
        customer.setPhone("1234");
        customers.add(customer);
        customerPage = new PageImpl<>(Arrays.asList(customer));
    }
    @Test
    public void GetCustomers_EmptyParams_ReturnAll(){
        //When:
        Mockito.when(repository.findAll()).thenReturn(customers);
        //Then:
        List<Customer> response = service.getCustomers(null, null);
        Assert.assertFalse(response.isEmpty());
    }

    @Test
    public void GetCustomers_ValidParams_ReturnPage(){
        //When:
        Mockito.when(repository.findAll(any(Pageable.class))).thenReturn(customerPage);
        //Then:
        List<Customer> response = service.getCustomers(1, 0);
        Assert.assertFalse(response.isEmpty());
        Assert.assertSame(response.get(0).getId(), 1);
    }

    @Test
    public void GetCustomers_InValidParams_ReturnEmpty(){
        List<Customer> response = service.getCustomers(null, 0);
        Assert.assertEquals(response.size(), 0);
    }
}
