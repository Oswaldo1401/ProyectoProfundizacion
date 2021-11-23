package com.umanizales.draft.application;

import com.umanizales.draft.domain.Fingerprint_EntryDTO;
import com.umanizales.draft.exception.DraftException;

import java.util.List;

public interface Fingerprint_EntryAble {
    Fingerprint_EntryDTO save(Fingerprint_EntryDTO fingerprint_entryDTO);
    boolean update(String code,Fingerprint_EntryDTO fingerprint_entryDTO);
    boolean delete(String code) throws DraftException;
    List<Fingerprint_EntryDTO> list();
}
