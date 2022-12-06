package com.nhnacademy.edu.jpa.controller.restApi;


import com.nhnacademy.edu.jpa.domain.dto.FamilyRelationshipRegisterDTO;
import com.nhnacademy.edu.jpa.domain.entity.FamilyRelationship;
import com.nhnacademy.edu.jpa.exception.ValidationFailedException;
import com.nhnacademy.edu.jpa.repository.FamilyRelationshipRepository;
import com.nhnacademy.edu.jpa.repository.ResidentRepository;
import com.nhnacademy.edu.jpa.request_response.BaseResponseBody;
import com.nhnacademy.edu.jpa.service.FamilyRelationshipService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FamilyRelationshipRestController {

    private final FamilyRelationshipService familyRelationshipService;
    private final FamilyRelationshipRepository familyRelationshipRepository;

    private final ResidentRepository residentRepository;

    public FamilyRelationshipRestController(FamilyRelationshipService familyRelationshipService, FamilyRelationshipRepository familyRelationshipRepository, ResidentRepository residentRepository) {
        this.familyRelationshipService = familyRelationshipService;
        this.familyRelationshipRepository = familyRelationshipRepository;
        this.residentRepository = residentRepository;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/residents/{serialNumber}/relationship")
    public FamilyRelationship registerFamilyRelationshipController(@Valid @RequestBody FamilyRelationshipRegisterDTO dto,
                                                                   @PathVariable("serialNumber")Integer serialNumber,
                                                                   BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationFailedException(bindingResult);
        }
        return familyRelationshipService.registerFamilyRelationship(serialNumber, dto);

    }

    @GetMapping("/residents/{serialNumber}/relationship")
    public List<FamilyRelationship> familyRelationshipViewController(){
        List<FamilyRelationship> list = familyRelationshipRepository.getAllBy();
        return list;
    }

    @PutMapping("/residents/{serialNumber}/relationship/{familySerialNumber}")
    public void familyRelationshipModifyController(@RequestBody String familyRelationshipCode,
                                                                 @PathVariable("serialNumber")Integer serialNumber,
                                                                 @PathVariable("familySerialNumber")Integer familySerialNumber){
        familyRelationshipService.modifyFamilyRelationship(serialNumber, familySerialNumber,familyRelationshipCode);
    }


    @DeleteMapping("/residents/{serialNumber}/relationship/{familySerialNumber}")
    public ResponseEntity<? extends BaseResponseBody> familyRelationshipDeleteController(@PathVariable("serialNumber")Integer serialNumber,
                                                                                         @PathVariable("familySerialNumber")Integer familySerialNumber){
       if(familyRelationshipService.deleteFamilyRelationship(serialNumber, familySerialNumber)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(BaseResponseBody.of(HttpStatus.ACCEPTED, "familyRelationship success delete!"));
       }
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponseBody.of(HttpStatus.BAD_REQUEST, "bad request!"));
    }

}
