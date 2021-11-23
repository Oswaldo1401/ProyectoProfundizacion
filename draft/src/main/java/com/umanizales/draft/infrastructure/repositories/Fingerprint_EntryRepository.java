package com.umanizales.draft.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Fingerprint_EntryRepository extends JpaRepository<Fingerprint_Entry,String> {

    @Query("SELECT finderprinten FROM Fingerprint_Entry finderprinten")
    List<Fingerprint_Entry> getFingerprint_Entry();
    @Transactional
    @Modifying
    @Query("UPDATE Fingerprint_Entry d SET d.employee = :#{#Fingerprint_Entry.employee}, " +
            "d.fingerprint_record = :#{#Fingerprint_Entry.fingerprint_record}, " +
            "d.id_entry = :#{#Fingerprint_Entry.id_entry} WHERE d.id_entry LIKE :code")
    public int update(@Param("Fingerprint_Entry") Fingerprint_Entry fingerprint_entry, @Param("code") String code);
}
