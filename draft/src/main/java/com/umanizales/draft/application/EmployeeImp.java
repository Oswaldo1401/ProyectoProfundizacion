package com.umanizales.draft.application;

import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EmployeeImp implements EmployeeAble{

    @Autowired
    @Qualifier("PostgresEmployeeRepository")
    private EmployeeAble employeePersistence;
    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return employeePersistence.save(employeeDTO);
    }

    @Override
    public boolean update(String code, EmployeeDTO employeeDTO) {
        return employeePersistence.update(code,employeeDTO);
    }

    @Override
    public boolean delete(String code) throws DraftException {
        return  employeePersistence.delete(code);
    }

    @Override
    public List<EmployeeDTO> list() {
        return employeePersistence.list();
    }
}
