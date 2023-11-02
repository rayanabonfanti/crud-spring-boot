package com.crud.mysql.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {

    @JsonProperty
    private String customerFullName;

    @JsonProperty
    private String customerEmail;

    @JsonProperty
    private String customerUserName;

    @JsonProperty
    private String customerPassword;

    public Customer toConverterCustomerDTO() {
        Customer customer = new Customer();
        customer.setCustomerFullName(this.customerFullName);
        customer.setCustomerEmail(this.customerEmail);
        customer.setCustomerUserName(this.customerUserName);
        customer.setCustomerPassword(this.customerPassword);
        return customer;
    }

}
