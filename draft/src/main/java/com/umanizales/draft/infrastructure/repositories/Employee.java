package com.umanizales.draft.infrastructure.repositories;


import com.umanizales.draft.domain.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "employee", schema = "public", catalog = "proyecto")
public class Employee {
    @Id
    @Column(name = "id", nullable = false, length = 100)
    private String id;

    @Basic
    @Column(name = "email_address", nullable = false, length = 150)
    private String emailAddress;

    @Basic
    @Column(name = "phone_number", nullable = false)
    private int phoneNumber;

    @Basic
    @Column(name = "post", nullable = false, length = 50)
    private String post;

    public Employee(EmployeeDTO employeeDTO) {
        BeanUtils.copyProperties(employeeDTO, this);
        this.id = UUID.randomUUID().toString();
    }

    public EmployeeDTO toemployeeDTO(){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        BeanUtils.copyProperties(this,employeeDTO);
        return employeeDTO;
    }

}
