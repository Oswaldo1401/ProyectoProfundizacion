package com.umanizales.draft.infrastructure.adapter;

import com.umanizales.draft.application.EmployeeAble;
import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.repositories.Employee;
import com.umanizales.draft.infrastructure.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresEmployeeRepository")
@Repository("employeePersistence")
public class PostgresEmployeeRepository implements EmployeeAble {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO) {
        return  employeeRepository.save(new Employee(employeeDTO)).toemployeeDTO();
    }

    @Override
    public boolean update(String code, EmployeeDTO employeeDTO) {
        return employeeRepository.update(new Employee(employeeDTO),code)>=1;
    }

    @Override
    public boolean delete(String code) throws DraftException {
        if (employeeRepository.existsById(code)) {
            try {
                employeeRepository.deleteById(code);
                return true;
            } catch (Exception e) {
                throw  new DraftException("el codigo"+e);
            }


        } else {
            throw new DraftException("El codigo a borrar no existe" + code);
        }
    }

    @Override
    public List<EmployeeDTO> list() {
        List<EmployeeDTO> employeeDTO = new ArrayList<>();
        employeeRepository.getEmployee().forEach(cos -> employeeDTO.add(cos.toemployeeDTO()));
        return employeeDTO;
    }
}
