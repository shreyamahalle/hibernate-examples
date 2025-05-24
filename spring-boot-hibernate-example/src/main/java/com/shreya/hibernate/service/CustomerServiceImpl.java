package com.shreya.hibernate.service;

import com.shreya.hibernate.domain.Customer;
import com.shreya.hibernate.model.CustomerModel;
import com.shreya.hibernate.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // Convert entity to model
    private CustomerModel toModel(Customer entity) {
        CustomerModel model = new CustomerModel();
        model.setId(entity.getId());
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setEmail(entity.getEmail());
        return model;
    }

    // Convert model to entity
    private Customer toEntity(CustomerModel model) {
        Customer entity = new Customer();
        entity.setId(model.getId());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setEmail(model.getEmail());
        return entity;
    }

    @Override
    public List<CustomerModel> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerModel getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public CustomerModel saveCustomer(CustomerModel customerModel) {
        Customer saved = customerRepository.save(toEntity(customerModel));
        return toModel(saved);
    }

    @Override
    public CustomerModel updateCustomer(Long id, CustomerModel customerModel) {
        return customerRepository.findById(id).map(existing -> {
            existing.setFirstName(customerModel.getFirstName());
            existing.setLastName(customerModel.getLastName());
            existing.setEmail(customerModel.getEmail());
            Customer updated = customerRepository.save(existing);
            return toModel(updated);
        }).orElse(null);
    }

    @Override
    public boolean deleteCustomer(Long id) {
        return customerRepository.findById(id).map(customer -> {
            customerRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
