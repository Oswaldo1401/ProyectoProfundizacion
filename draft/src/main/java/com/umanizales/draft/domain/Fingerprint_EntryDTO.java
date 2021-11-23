package com.umanizales.draft.domain;

import com.umanizales.draft.infrastructure.repositories.Employee;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_Record;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fingerprint_EntryDTO {
    @NotNull
    private String id_entry;
    @NotNull
    private Employee employee;
    @NotNull
    private Fingerprint_Record fingerprint_record;
}
