package com.crud.h2console.controllers;

import com.crud.h2console.exceptions.DataNotFoundException;
import com.crud.h2console.exceptions.ServicesRuntimeException;
import com.crud.h2console.models.Customer;
import com.crud.h2console.models.CustomerDTO;
import com.crud.h2console.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<?> getAllCustomers() {
        HashMap hashMapGetAllCustomer = null;
        try{
            hashMapGetAllCustomer = customerService.getAllCustomers();
            if (hashMapGetAllCustomer.isEmpty() || hashMapGetAllCustomer.containsKey("Error")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMapGetAllCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(hashMapGetAllCustomer);
            }
        } catch(Exception e){
            hashMapGetAllCustomer.put("Error", new ServicesRuntimeException("Error get all customers! Details Error: " + e.getMessage()).getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMapGetAllCustomer);
        }
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO customerDTO) {
        HashMap hashMapSaveCustomer = null;
        try{
            hashMapSaveCustomer = customerService.saveCustomer(customerDTO);
            if (hashMapSaveCustomer.isEmpty() || hashMapSaveCustomer.containsKey("Error")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMapSaveCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(hashMapSaveCustomer);
            }
        } catch(Exception e){
            hashMapSaveCustomer.put("Error", new ServicesRuntimeException("Error save customer! Details Error: " + e.getMessage()).getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMapSaveCustomer);
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<?> remove(@RequestParam Integer customerId) {
        HashMap hashMapDeleteCustomer = null;
        try{
            hashMapDeleteCustomer = customerService.removeCustomer(customerId);
            if (hashMapDeleteCustomer.isEmpty() || hashMapDeleteCustomer.containsKey("Error")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMapDeleteCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(hashMapDeleteCustomer);
            }
        } catch(Exception e){
            hashMapDeleteCustomer.put("Error", new ServicesRuntimeException("Error remove customer! Details Error: " + e.getMessage()).getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMapDeleteCustomer);
        }
    }

    @PatchMapping(value = "/update")
    public ResponseEntity<?> updateCustomer(@RequestParam Integer customerId, @RequestBody CustomerDTO customerDTO) {
        HashMap hashMapUpdateCustomer = null;
        try{
            hashMapUpdateCustomer = customerService.updateCustomer(customerId, customerDTO);
            if (hashMapUpdateCustomer.isEmpty() || hashMapUpdateCustomer.containsKey("Error")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMapUpdateCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(hashMapUpdateCustomer);
            }
        } catch(Exception e){
            hashMapUpdateCustomer.put("Error", new ServicesRuntimeException("Error update customer! Details Error: " + e.getMessage()).getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMapUpdateCustomer);
        }
    }

    @GetMapping("/getByUserName")
    public ResponseEntity<?> getCustomerByUserName(@RequestParam String customerUserName) {
        HashMap hashMapGetUserNameCustomer = null;
        try{
            hashMapGetUserNameCustomer = customerService.getCustomerByUserName(customerUserName);
            if (hashMapGetUserNameCustomer.isEmpty() || hashMapGetUserNameCustomer.containsKey("Error")) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(hashMapGetUserNameCustomer);
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(hashMapGetUserNameCustomer);
            }
        } catch(Exception e){
            hashMapGetUserNameCustomer.put("Error", new ServicesRuntimeException("Error find by username of costumer! Details Error: " + e.getMessage()).getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hashMapGetUserNameCustomer);
        }
    }

}
