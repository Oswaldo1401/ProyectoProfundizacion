package com.umanizales.draft.infrastructure.adapter;

import com.umanizales.draft.application.Shift_EmployeeAble;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.repositories.Shift_Employee;
import com.umanizales.draft.infrastructure.repositories.Shift_EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresShift_employeeRepository")
@Repository("shift_EmployeePersistence")
public class PostgresShift_employeeRepository implements Shift_EmployeeAble {

    @Autowired
    private Shift_EmployeeRepository shift_employeeRepository;

    @Override
    public Shift_EmployeeDTO save(Shift_EmployeeDTO shift_employeeDTO) {
        return  shift_employeeRepository.save(new Shift_Employee(shift_employeeDTO)).toshift_EmployeeDTO();
    }

    @Override
    public boolean update(String code, Shift_EmployeeDTO shift_employeeDTO) {
        return shift_employeeRepository.update(new Shift_Employee(shift_employeeDTO),code)>=1;
    }

    @Override
    public boolean delete(String code) throws DraftException {
        if (shift_employeeRepository.existsById(code)) {
            try {
                shift_employeeRepository.deleteById(code);
                return true;
            } catch (Exception e) {
                throw  new DraftException("el codigo"+e);
            }


        } else {
            throw new DraftException("El codigo a borrar no existe" + code);
        }
    }

    @Override
    public List<Shift_EmployeeDTO> list() {
        List<Shift_EmployeeDTO> shift_employeeDTO = new ArrayList<>();
        shift_employeeRepository.getShift_Employee().forEach(cos -> shift_employeeDTO.add(cos.toshift_EmployeeDTO()));
        return shift_employeeDTO;
    }
}
