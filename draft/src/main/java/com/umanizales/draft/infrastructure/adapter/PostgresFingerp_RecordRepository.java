package com.umanizales.draft.infrastructure.adapter;

import com.umanizales.draft.application.Fingerprint_RecordAble;
import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_Record;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresFingerp_RecordRepository")
@Repository("Fingerprint_RecordPersistence")
public class PostgresFingerp_RecordRepository implements Fingerprint_RecordAble {
    @Autowired
    private Fingerprint_RecordRepository fingerprint_recordRepository;

    @Override
    public Fingerprint_RecordDTO save(Fingerprint_RecordDTO fingerprint_recordDTO) {
        return  fingerprint_recordRepository.save(new Fingerprint_Record(fingerprint_recordDTO)).tofingerprint_recordDTO();
    }

    @Override
    public boolean update(String code, Fingerprint_RecordDTO fingerprint_recordDTO) {
        return fingerprint_recordRepository.update(new Fingerprint_Record(fingerprint_recordDTO),code)>=1;
    }

    @Override
    public boolean delete(String code) throws DraftException {
        if (fingerprint_recordRepository.existsById(code)) {
            try {
                fingerprint_recordRepository.deleteById(code);
                return true;
            } catch (Exception e) {
                throw  new DraftException("el codigo"+e);
            }


        } else {
            throw new DraftException("El codigo a borrar no existe" + code);
        }
    }

    @Override
    public List<Fingerprint_RecordDTO> list() {
        List<Fingerprint_RecordDTO> fingerprint_recordDTO = new ArrayList<>();
        fingerprint_recordRepository.getFingerprint_Record().forEach(cos -> fingerprint_recordDTO.add(cos.tofingerprint_recordDTO()));
        return fingerprint_recordDTO;
    }
}
