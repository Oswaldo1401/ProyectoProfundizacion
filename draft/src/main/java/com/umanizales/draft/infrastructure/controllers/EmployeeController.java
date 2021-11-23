package com.umanizales.draft.infrastructure.controllers;

import com.umanizales.draft.application.EmployeeImp;
import com.umanizales.draft.domain.EmployeeDTO;
import com.umanizales.draft.exception.DraftException;
import com.umanizales.draft.infrastructure.controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
    @Autowired
    private EmployeeImp employeeImp;

    @PostMapping
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid EmployeeDTO employeeDTO){
        return new ResponseEntity<>(new ResponseDTO("Success",employeeImp.save(employeeDTO),null),
                HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list(){
        return  new ResponseEntity<>(new ResponseDTO("success", employeeImp. list(),null),
                HttpStatus.OK);
    }
    //update
    @PutMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>updateEmployee(@PathVariable String code
            ,@RequestBody @Valid EmployeeDTO employeeDTO)throws DraftException {
        return new ResponseEntity<>(new ResponseDTO("Success",employeeImp.update(code,employeeDTO),null),
                HttpStatus.OK);
    }
    // delete
    @DeleteMapping("{code}")
    public @ResponseBody ResponseEntity<ResponseDTO>deleteemployee(@PathVariable String code)throws DraftException {
        return  new ResponseEntity<>(new ResponseDTO("success",employeeImp.delete(code),null),
                HttpStatus.OK);
    }
}
