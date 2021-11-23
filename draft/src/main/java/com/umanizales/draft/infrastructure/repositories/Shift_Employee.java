package com.umanizales.draft.infrastructure.repositories;

import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
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
@Table(name = "Shift_Employee", schema = "public", catalog = "proyecto")
public class Shift_Employee {

    @Id
    @Column(name = "id_shift", nullable = false, length = 100)
    private String id_shift;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @Basic
    @Column(name = "shift", nullable = false, length = 150)
    private String shift;

    public Shift_Employee(Shift_EmployeeDTO shift_employeeDTO) {
        BeanUtils.copyProperties(shift_employeeDTO, this);
        this.id_shift = UUID.randomUUID().toString();
    }

    public Shift_EmployeeDTO toshift_EmployeeDTO(){
        Shift_EmployeeDTO shift_employeeDTO = new Shift_EmployeeDTO();
        BeanUtils.copyProperties(this,shift_employeeDTO);
        return shift_employeeDTO;
    }
}
