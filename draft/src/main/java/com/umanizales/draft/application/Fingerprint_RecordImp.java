package com.umanizales.draft.application;

import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.exception.DraftException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fingerprint_RecordImp implements Fingerprint_RecordAble{

    @Autowired
    @Qualifier("PostgresFingerp_RecordRepository")
    private Fingerprint_RecordAble Fingerprint_RecordPersistence;
    @Override
    public Fingerprint_RecordDTO save(Fingerprint_RecordDTO fingerprint_recordDTO) {
        return Fingerprint_RecordPersistence.save(fingerprint_recordDTO);
    }

    @Override
    public boolean update(String code, Fingerprint_RecordDTO fingerprint_recordDTO) {
        return Fingerprint_RecordPersistence.update(code,fingerprint_recordDTO);
    }

    @Override
    public boolean delete(String code) throws DraftException {
        return  Fingerprint_RecordPersistence.delete(code);
    }

    @Override
    public List<Fingerprint_RecordDTO> list() {
        return Fingerprint_RecordPersistence.list();
    }
}
