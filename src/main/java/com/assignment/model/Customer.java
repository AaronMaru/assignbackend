package com.assignment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Sai Vichet
 * Date     : 1/18/2018, 9:08 AM
 * Email    : v.sai@gl-f.com
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdDate", "modifiedDate"},allowGetters = true)
public class Customer {
    @Id
    @GeneratedValue
    private Long customerId;

    @NotEmpty
    private String customerName;

    @NotEmpty
    private String phone;

    private String email;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    private Date createdDate;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public Customer() {
    }

    public Customer(String customerName, String phone, String email) {
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }
}
