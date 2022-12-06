package com.nhnacademy.edu.jpa.controller.restApi;


import com.nhnacademy.edu.jpa.domain.dto.BirthDeathModifyRequestDTO;
import com.nhnacademy.edu.jpa.domain.dto.BirthDeathRegisterRequestDTO;
import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import com.nhnacademy.edu.jpa.request_response.BaseResponseBody;
import com.nhnacademy.edu.jpa.service.BirthDeathService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BirthRestController {

    private final BirthDeathService birthDeathService;

    public BirthRestController(BirthDeathService birthDeathService) {
        this.birthDeathService = birthDeathService;
    }



    //NOTE: 해당 entity를 DTO 객체로 변환해서 넘겨주는데 이때는 정적 팩토리 메소드를 사용한다.
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/residents/{serialNumber}/birth")
    public BirthDeathRegisterRequestDTO registerBirthController(@RequestBody @Valid BirthDeathRegisterRequestDTO dto,
                                                                @PathVariable("serialNumber") Integer serialNumber){

        BirthDeathReportResident birthDeathReportResident = birthDeathService.registerBirthDeath(dto, serialNumber);
        return BirthDeathRegisterRequestDTO.of(birthDeathReportResident);
    }




    @PutMapping("/residents/{serialNumber}/birth/{code}")
    public void modifyBirthController(@Valid @RequestBody BirthDeathModifyRequestDTO dto,
                                                                @PathVariable("serialNumber") Integer serialNumber,
                                                                @PathVariable String code){
        birthDeathService.modifyBirthDeath(serialNumber,code,dto);

    }

    @DeleteMapping("/residents/{serialNumber}/birth/{code}")
    public ResponseEntity<? extends BaseResponseBody> deleteBirthController(@PathVariable Integer serialNumber, @PathVariable String code){
        if(birthDeathService.deleteBirthDeath(serialNumber,code)){
            return ResponseEntity.status(HttpStatus.OK).body(BaseResponseBody.of(HttpStatus.OK, "삭제 완료 되었습니다."));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponseBody.of(HttpStatus.BAD_REQUEST, "삭제에 실패했습니다."));

    }
}
