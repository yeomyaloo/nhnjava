package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QResident is a Querydsl query type for Resident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QResident extends EntityPathBase<Resident> {

    private static final long serialVersionUID = -1006933851L;

    public static final QResident resident = new QResident("resident");

    public final DateTimePath<java.sql.Timestamp> birthDate = createDateTime("birthDate", java.sql.Timestamp.class);

    public final StringPath birthPlaceCode = createString("birthPlaceCode");

    public final DateTimePath<java.sql.Timestamp> deathDate = createDateTime("deathDate", java.sql.Timestamp.class);

    public final StringPath deathPlaceAddress = createString("deathPlaceAddress");

    public final StringPath deathPlaceCode = createString("deathPlaceCode");

    public final StringPath genderCode = createString("genderCode");

    public final StringPath name = createString("name");

    public final StringPath registrationBaseAddress = createString("registrationBaseAddress");

    public final StringPath residentRegistrationNumber = createString("residentRegistrationNumber");

    public final NumberPath<Integer> residentSerialNumber = createNumber("residentSerialNumber", Integer.class);

    public QResident(String variable) {
        super(Resident.class, forVariable(variable));
    }

    public QResident(Path<? extends Resident> path) {
        super(path.getType(), path.getMetadata());
    }

    public QResident(PathMetadata metadata) {
        super(Resident.class, metadata);
    }

}

