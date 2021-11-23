package com.umanizales.draft.infrastructure.repositories;

import com.umanizales.draft.domain.Fingerprint_EntryDTO;
import com.umanizales.draft.domain.Fingerprint_RecordDTO;
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
@Table(name = "fingerprint_Entry", schema = "public", catalog = "proyecto")
public class Fingerprint_Entry {
    @Id
    @Column(name = "id_entry", nullable = false, length = 100)
    private String id_entry;

    @ManyToOne
    @JoinColumn(name = "employee", referencedColumnName = "id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "fingerprint_record", referencedColumnName = "id_record", nullable = false)
    private Fingerprint_Record fingerprint_record;


    public Fingerprint_Entry(Fingerprint_EntryDTO fingerprint_entryDTO) {
        BeanUtils.copyProperties(fingerprint_entryDTO, this);
        this.id_entry = UUID.randomUUID().toString();
    }

    public Fingerprint_EntryDTO tofingerprint_EntryDTO(){
        Fingerprint_EntryDTO fingerprint_entryDTO = new Fingerprint_EntryDTO();
        BeanUtils.copyProperties(this,fingerprint_entryDTO);
        return fingerprint_entryDTO;
    }

}
