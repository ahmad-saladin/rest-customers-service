package com.jumia.service.manager.impl;

import com.jumia.service.domains.Customer;
import com.jumia.service.manager.CustomerService;
import com.jumia.service.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers(Integer pageSize, Integer pageIndex) {
            if (ObjectUtils.isEmpty(pageSize) && ObjectUtils.isEmpty(pageIndex)) {
                return customerRepository.findAll();
            } else if (!(ObjectUtils.isEmpty(pageSize) || ObjectUtils.isEmpty(pageIndex))) {
                Pageable page = PageRequest.of(pageIndex, pageSize);
                Page<Customer> customersPage = customerRepository.findAll(page);
                if (Optional.ofNullable(customersPage).isPresent()) {
                    return customersPage.getContent();
                }
            }

            return new ArrayList<>();
    }
}
