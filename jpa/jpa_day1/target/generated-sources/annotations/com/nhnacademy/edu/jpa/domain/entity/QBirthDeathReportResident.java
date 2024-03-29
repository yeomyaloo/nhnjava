package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBirthDeathReportResident is a Querydsl query type for BirthDeathReportResident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBirthDeathReportResident extends EntityPathBase<BirthDeathReportResident> {

    private static final long serialVersionUID = 233843790L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBirthDeathReportResident birthDeathReportResident = new QBirthDeathReportResident("birthDeathReportResident");

    public final DatePath<java.sql.Date> birthDeathReportDate = createDate("birthDeathReportDate", java.sql.Date.class);

    public final StringPath birthReportQualificationsCode = createString("birthReportQualificationsCode");

    public final StringPath deathReportQualificationsCode = createString("deathReportQualificationsCode");

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final QBirthDeathReportResident_Pk pk;

    public final NumberPath<Integer> reportResidentSerialNumber = createNumber("reportResidentSerialNumber", Integer.class);

    public final QResident resident;

    public QBirthDeathReportResident(String variable) {
        this(BirthDeathReportResident.class, forVariable(variable), INITS);
    }

    public QBirthDeathReportResident(Path<? extends BirthDeathReportResident> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBirthDeathReportResident(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBirthDeathReportResident(PathMetadata metadata, PathInits inits) {
        this(BirthDeathReportResident.class, metadata, inits);
    }

    public QBirthDeathReportResident(Class<? extends BirthDeathReportResident> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pk = inits.isInitialized("pk") ? new QBirthDeathReportResident_Pk(forProperty("pk")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

