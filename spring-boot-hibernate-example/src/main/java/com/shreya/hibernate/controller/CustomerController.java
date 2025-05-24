package com.shreya.hibernate.controller;

import com.shreya.hibernate.exception.CustomerNotFoundException;
import com.shreya.hibernate.model.CustomerModel;
import com.shreya.hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customerManagement")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerModel>> getCustomers() {
        List<CustomerModel> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerModel> getCustomer(@PathVariable Long id) {
        CustomerModel customer = customerService.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer not found with id: " + id);
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerModel> saveCustomer( @RequestBody CustomerModel customerModel) {
        CustomerModel savedCustomer = customerService.saveCustomer(customerModel);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<CustomerModel> updateCustomer(@PathVariable Long id,  @RequestBody CustomerModel customerModel) {
        CustomerModel updatedCustomer = customerService.updateCustomer(id, customerModel);
        if (updatedCustomer == null) {
            throw new CustomerNotFoundException("Cannot update. Customer not found with id: " + id);
        }
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        boolean deleted = customerService.deleteCustomer(id);
        if (!deleted) {
            throw new CustomerNotFoundException("Cannot delete. Customer not found with id: " + id);
        }
        return ResponseEntity.ok(true);
    }
}
