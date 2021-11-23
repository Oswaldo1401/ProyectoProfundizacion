package com.umanizales.draft.infrastructure.controllers;

import com.umanizales.draft.application.Fingerprint_EntryAble;
import com.umanizales.draft.application.Fingerprint_EntryImp;
import com.umanizales.draft.application.Fingerprint_RecordImp;
import com.umanizales.draft.domain.Fingerprint_EntryDTO;
import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/fingerprint_Entry")
public class Fingerprint_entryController {
    @Autowired
    private Fingerprint_EntryImp fingerprint_entryImp;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid Fingerprint_EntryDTO fingerprint_entryDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",fingerprint_entryImp.save(fingerprint_entryDTO),null),
                HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", fingerprint_entryImp. list(),null),
                HttpStatus.OK);
    }
    //update
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateEntry(@PathVariable String code
            ,@RequestBody @Valid Fingerprint_EntryDTO fingerprint_entryDTO)throws DraftException {
        return new ResponseEntity<>(new ResponseDTO("Success",fingerprint_entryImp.update(code,fingerprint_entryDTO),null),
                HttpStatus.OK);
    }
    // delete
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteEntry(@PathVariable String code)throws DraftException {
        return  new ResponseEntity<>(new ResponseDTO("success",fingerprint_entryImp.delete(code),null),
                HttpStatus.OK);
    }
}
