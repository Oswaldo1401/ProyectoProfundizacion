package com.umanizales.draft.domain;

import com.umanizales.draft.infrastructure.repositories.Employee;
import com.umanizales.draft.infrastructure.repositories.Shift_Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fingerprint_RecordDTO {

    @NotNull
    private String id_record;
    @NotNull
    private Employee employee;
    @NotNull
    private Shift_Employee shift_employee;
    @NotNull
    private String fingerprint;
}
