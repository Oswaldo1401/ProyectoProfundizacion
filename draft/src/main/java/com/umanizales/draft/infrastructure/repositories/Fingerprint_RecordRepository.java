package com.umanizales.draft.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Fingerprint_RecordRepository extends JpaRepository<Fingerprint_Record,String> {
    @Query("SELECT finderprint FROM Fingerprint_Record finderprint")
    List<Fingerprint_Record> getFingerprint_Record();
    @Transactional
    @Modifying
    @Query("UPDATE Fingerprint_Record d SET d.employee = :#{#Fingerprint_Record.employee}, " +
            "d.shift_employee = :#{#Fingerprint_Record.shift_employee}, " +
            "d.id_record = :#{#Fingerprint_Record.id_record}, " +
            "d.fingerprint = :#{#Fingerprint_Record.fingerprint} WHERE d.id_record LIKE :code")
    public int update(@Param("Fingerprint_Record") Fingerprint_Record fingerprint_record, @Param("code") String code);
}
