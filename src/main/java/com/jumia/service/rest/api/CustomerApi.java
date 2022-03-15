package com.jumia.service.rest.api;

import com.jumia.service.domains.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/api/v1/customers")
public interface CustomerApi {

    @GetMapping("")
    List<Customer> getCustomers(@RequestParam(name = "page_size", required = false) Integer pageSize,
                                @RequestParam(name = "page_index", required = false) Integer pageIndex);
}
