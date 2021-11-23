package com.umanizales.draft.application;

import com.umanizales.draft.domain.Fingerprint_EntryDTO;
import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fingerprint_EntryImp implements Fingerprint_EntryAble{
    @Autowired
    @Qualifier("PostgresFingerp_EntryRepository")
    private Fingerprint_EntryAble fingerprint_EntryPersistence;
    @Override
    public Fingerprint_EntryDTO save(Fingerprint_EntryDTO fingerprint_entryDTO) {
        return fingerprint_EntryPersistence.save(fingerprint_entryDTO);
    }

    @Override
    public boolean update(String code, Fingerprint_EntryDTO fingerprint_entryDTO) {
        return fingerprint_EntryPersistence.update(code,fingerprint_entryDTO);
    }

    @Override
    public boolean delete(String code) throws DraftException {
        return  fingerprint_EntryPersistence.delete(code);
    }

    @Override
    public List<Fingerprint_EntryDTO> list() {
        return fingerprint_EntryPersistence.list();
    }
}
