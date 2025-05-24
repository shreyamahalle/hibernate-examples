package com.shreya.hibernate.service;

import com.shreya.hibernate.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> getAllCustomers();
    CustomerModel getCustomerById(Long id);
    CustomerModel saveCustomer(CustomerModel customerModel);
    CustomerModel updateCustomer(Long id, CustomerModel customerModel);
    boolean deleteCustomer(Long id);
}
