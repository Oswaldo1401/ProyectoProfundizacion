package com.umanizales.draft.domain;

import com.umanizales.draft.infrastructure.repositories.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shift_EmployeeDTO {

    @NotNull
    private String id_shift;
    @NotNull
    private Employee employee;
    @NotNull
    private String shift;
}
