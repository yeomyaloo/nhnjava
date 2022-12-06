package com.nhnacademy.edu.jpa.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "certificate_issue")
@Getter
@RequiredArgsConstructor
public class CertificateIssue {

    @Id
    @Column(name = "certificate_confirmation_number")
    private Long certificateConfirmationNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;

    @Column(name = "certificate_issue_date")
    private Date certificateIssueDate;





}
