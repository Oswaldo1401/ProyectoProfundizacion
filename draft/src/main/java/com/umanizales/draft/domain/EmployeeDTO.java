package com.umanizales.draft.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotNull
    private String id;
    @NotNull
    private String emailAddress;
    @NotNull
    private int phoneNumber;
    @NotNull
    private String post;
}
