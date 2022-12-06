package com.nhnacademy.edu.jpa.controller.restApi;


import com.nhnacademy.edu.jpa.domain.dto.ResidentModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.ResidentRequestDTO;
import com.nhnacademy.edu.jpa.domain.entity.Resident;
import com.nhnacademy.edu.jpa.exception.ValidationFailedException;
import com.nhnacademy.edu.jpa.service.ResidentService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/residents")
public class ResidentRestController {

    private final ResidentService residentService;

    public ResidentRestController(ResidentService residentService) {
        this.residentService = residentService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Resident residentRegisterController(@Valid @RequestBody ResidentRequestDTO dto,
                                               BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }

        return residentService.residentRegister(dto);


    }

    @PutMapping("/{serialNumber}")
    public Resident residentModifyController(@Valid @RequestBody ResidentModifyRequestDTO dto,
                                             @PathVariable("serialNumber") Integer serialNumber,
                                             BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }

        Resident resident = residentService.residentModify(dto,serialNumber);
        return resident;
    }

}
