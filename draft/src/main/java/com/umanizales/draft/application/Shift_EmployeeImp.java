package com.umanizales.draft.application;

import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Shift_EmployeeImp implements Shift_EmployeeAble{


    @Autowired
    @Qualifier("PostgresShift_employeeRepository")
    private Shift_EmployeeAble shift_EmployeePersistence;
    @Override
    public Shift_EmployeeDTO save(Shift_EmployeeDTO shift_employeeDTO) {
        return shift_EmployeePersistence.save(shift_employeeDTO);
    }

    @Override
    public boolean update(String code, Shift_EmployeeDTO shift_employeeDTO) {
        return shift_EmployeePersistence.update(code,shift_employeeDTO);
    }

    @Override
    public boolean delete(String code) throws DraftException {
        return  shift_EmployeePersistence.delete(code);
    }

    @Override
    public List<Shift_EmployeeDTO> list() {
        return shift_EmployeePersistence.list();
    }
}
