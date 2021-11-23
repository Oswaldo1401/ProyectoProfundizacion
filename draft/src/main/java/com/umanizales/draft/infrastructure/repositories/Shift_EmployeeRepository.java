package com.umanizales.draft.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Shift_EmployeeRepository extends JpaRepository<Shift_Employee,String> {
    @Query("SELECT shiftemployee FROM Shift_Employee shiftemployee")
    List<Shift_Employee> getShift_Employee();
    @Transactional
    @Modifying
    @Query("UPDATE Shift_Employee d SET d.employee = :#{#Shift_Employee.employee}, " +
            "d.id_shift = :#{#Shift_Employee.id_shift}, " +
            "d.shift = :#{#Shift_Employee.shift} WHERE d.id_shift LIKE :code")
    public int update(@Param("Shift_Employee") Shift_Employee shift_employee, @Param("code") String code);
}
