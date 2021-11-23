package com.umanizales.draft.infrastructure.adapter;

import com.umanizales.draft.application.Fingerprint_EntryAble;
import com.umanizales.draft.domain.Fingerprint_EntryDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_Entry;
import com.umanizales.draft.infrastructure.repositories.Fingerprint_EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresFingerp_EntryRepository")
@Repository("fingerprint_EntryPersistence")
public class PostgresFingerp_EntryRepository implements Fingerprint_EntryAble {
    @Autowired
    private Fingerprint_EntryRepository fingerprint_entryRepository;

    @Override
    public Fingerprint_EntryDTO save(Fingerprint_EntryDTO fingerprint_entryDTO) {
        return  fingerprint_entryRepository.save(new Fingerprint_Entry(fingerprint_entryDTO)).tofingerprint_EntryDTO();
    }

    @Override
    public boolean update(String code, Fingerprint_EntryDTO fingerprint_entryDTO) {
        return fingerprint_entryRepository.update(new Fingerprint_Entry(fingerprint_entryDTO),code)>=1;
    }

    @Override
    public boolean delete(String code) throws DraftException {
        if (fingerprint_entryRepository.existsById(code)) {
            try {
                fingerprint_entryRepository.deleteById(code);
                return true;
            } catch (Exception e) {
                throw  new DraftException("el codigo"+e);
            }


        } else {
            throw new DraftException("El codigo a borrar no existe" + code);
        }
    }

    @Override
    public List<Fingerprint_EntryDTO> list() {
        List<Fingerprint_EntryDTO> fingerprint_entryDTO = new ArrayList<>();
        fingerprint_entryRepository.getFingerprint_Entry().forEach(cos -> fingerprint_entryDTO.add(cos.tofingerprint_EntryDTO()));
        return fingerprint_entryDTO;
    }
}
