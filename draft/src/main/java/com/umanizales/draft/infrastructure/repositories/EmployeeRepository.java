package com.umanizales.draft.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
    @Query("SELECT employee FROM Employee employee")
    List<Employee> getEmployee();
    @Transactional
    @Modifying
    @Query("UPDATE Employee d SET d.id = :#{#Employee.id}, " +
            "d.emailAddress = :#{Employee.emailAddress}, " +
            "d.phoneNumber = :#{Employee.phoneNumber}, " +
            "d.post = :#{Employee.post} WHERE d.id LIKE :code")
    public int update(@Param("Employee") Employee employee, @Param("code") String code);

}
