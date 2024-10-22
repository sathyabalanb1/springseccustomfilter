package com.eazybytes.model;


import java.sql.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int id;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;

    private String role;

    @Column(name = "create_dt")
    @JsonIgnore
    private Date createDt;
    
    @OneToMany(mappedBy="customer", fetch=FetchType.EAGER)
    @JsonIgnore
    private Set<Authority> authorities;
    
    /*
     * @OneToMany
    So one record of customer can have many records

    inside the authorities table.
    */
    
    /*
     * mappedBy
    To this mappedBy parameter, we need

    to mention what is the field name of customer

    inside the Authority entity class.
    */
    
    /*
     * fetch=FetchType.EAGER
    With this eager configuration, what I'm telling

    to the Spring JP framework is,

    whenever you are trying to load a parent record,

    which is customer,

    please also load all the children records which are

    from the authorities.
    */

}