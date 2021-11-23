package com.umanizales.draft.infrastructure.controllers;

import com.umanizales.draft.application.EmployeeImp;
import com.umanizales.draft.application.Shift_EmployeeImp;
import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.domain.Shift_EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/shift_employee")
public class Shift_employeeController {
    @Autowired
    private Shift_EmployeeImp shift_employeeImp;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid Shift_EmployeeDTO shift_employeeDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",shift_employeeImp.save(shift_employeeDTO),null),
                HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", shift_employeeImp. list(),null),
                HttpStatus.OK);
    }
    //update
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateShift(@PathVariable String code
            ,@RequestBody @Valid Shift_EmployeeDTO shift_employeeDTO)throws DraftException {
        return new ResponseEntity<>(new ResponseDTO("Success",shift_employeeImp.update(code,shift_employeeDTO),null),
                HttpStatus.OK);
    }
    // delete
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteShift(@PathVariable String code)throws DraftException {
        return  new ResponseEntity<>(new ResponseDTO("success",shift_employeeImp.delete(code),null),
                HttpStatus.OK);
    }
}
