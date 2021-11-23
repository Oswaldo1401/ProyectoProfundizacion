package com.umanizales.draft.application;

import com.umanizales.draft.domain.Shift_EmployeeDTO;
import com.umanizales.draft.exception.DraftException;

import java.util.List;

public interface Shift_EmployeeAble {
    Shift_EmployeeDTO save(Shift_EmployeeDTO shift_employeeDTO);
    boolean update(String code,Shift_EmployeeDTO shift_employeeDTO);
    boolean delete(String code) throws DraftException;
    List<Shift_EmployeeDTO> list();
}
