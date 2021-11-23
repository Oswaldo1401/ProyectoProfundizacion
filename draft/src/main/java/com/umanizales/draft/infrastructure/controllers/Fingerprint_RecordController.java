package com.umanizales.draft.infrastructure.controllers;

import com.umanizales.draft.application.Fingerprint_RecordImp;
import com.umanizales.draft.application.Shift_EmployeeImp;
import com.umanizales.draft.domain.Fingerprint_RecordDTO;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/fingerprint_Record")
public class Fingerprint_RecordController {
    @Autowired
    private Fingerprint_RecordImp fingerprint_recordImp;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid Fingerprint_RecordDTO fingerprint_recordDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",fingerprint_recordImp.save(fingerprint_recordDTO),null),
                HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", fingerprint_recordImp. list(),null),
                HttpStatus.OK);
    }
    //update
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateRecord(@PathVariable String code
            ,@RequestBody @Valid Fingerprint_RecordDTO fingerprint_recordDTO)throws DraftException {
        return new ResponseEntity<>(new ResponseDTO("Success",fingerprint_recordImp.update(code,fingerprint_recordDTO),null),
                HttpStatus.OK);
    }
    // delete
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteRecord(@PathVariable String code)throws DraftException {
        return  new ResponseEntity<>(new ResponseDTO("success",fingerprint_recordImp.delete(code),null),
                HttpStatus.OK);
    }
}
