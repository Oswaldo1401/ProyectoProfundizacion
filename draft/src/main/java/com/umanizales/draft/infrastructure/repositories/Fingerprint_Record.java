package com.umanizales.draft.infrastructure.repositories;

import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "fingerprint_Record", schema = "public", catalog = "proyecto")
public class Fingerprint_Record {
    @Id
    @Column(name = "id_record", nullable = false, length = 100)
    private String id_record;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "shift_Employee", referencedColumnName = "id_shift", nullable = false)
    private Shift_Employee shift_employee;

    @Basic
    @Column(name = "fingerprint", nullable = false, length = 150)
    private String fingerprint;

    public Fingerprint_Record(Fingerprint_RecordDTO fingerprint_recordDTO) {
        BeanUtils.copyProperties(fingerprint_recordDTO, this);
        this.id_record = UUID.randomUUID().toString();
    }

    public Fingerprint_RecordDTO tofingerprint_recordDTO(){
        Fingerprint_RecordDTO fingerprint_recordDTO = new Fingerprint_RecordDTO();
        BeanUtils.copyProperties(this,fingerprint_recordDTO);
        return fingerprint_recordDTO;
    }
}
