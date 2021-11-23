package com.umanizales.draft.application;

import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.exception.DraftException;

import java.util.List;

public interface Fingerprint_RecordAble {
    Fingerprint_RecordDTO save(Fingerprint_RecordDTO fingerprint_recordDTO);
    boolean update(String code,Fingerprint_RecordDTO fingerprint_recordDTO);
    boolean delete(String code) throws DraftException;
    List<Fingerprint_RecordDTO> list();
}
