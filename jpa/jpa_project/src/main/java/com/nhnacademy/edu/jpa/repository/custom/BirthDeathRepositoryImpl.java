package com.nhnacademy.edu.jpa.repository.custom;


import com.nhnacademy.edu.jpa.domain.entity.BirthDeathReportResident;
import com.nhnacademy.edu.jpa.domain.entity.QBirthDeathReportResident;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

public class BirthDeathRepositoryImpl extends QuerydslRepositorySupport implements BirthDeathRepositoryCustom {
    public BirthDeathRepositoryImpl() {
        super(BirthDeathReportResident.class);
    }


    @Override
    @Transactional
    public long updateByPk(Integer residentSerialNumber, String birthDeathTypeCode, String emailAddress, String phoneNumber) {

        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(birthDeathTypeCode, residentSerialNumber);

        return update(birthDeathReportResident)
                .set(birthDeathReportResident.emailAddress, emailAddress)
                .set(birthDeathReportResident.phoneNumber, phoneNumber)
                .where(birthDeathReportResident.pk.eq(pk)).execute();

    }


    @Override
    @Transactional
    public boolean deleteBirthDeathReportResidentPk(Integer residentSerialNumber, String birthDeathTypeCode) {
        QBirthDeathReportResident birthDeathReportResident = QBirthDeathReportResident.birthDeathReportResident;
        BirthDeathReportResident.Pk pk = new BirthDeathReportResident.Pk(birthDeathTypeCode, residentSerialNumber);


        if(Objects.nonNull(pk)){
            delete(birthDeathReportResident).where(birthDeathReportResident.pk.eq(pk)).execute();
            return true;
        }
        return false;
    }


}
