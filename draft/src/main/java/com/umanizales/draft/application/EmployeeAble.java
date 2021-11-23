package com.umanizales.draft.application;

import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.exception.DraftException;

import java.util.List;

public interface EmployeeAble {
    EmployeeDTO save(EmployeeDTO employeeDTO);
    boolean update(String code,EmployeeDTO employeeDTO);
    boolean delete(String code) throws DraftException;
    List<EmployeeDTO> list();
}
