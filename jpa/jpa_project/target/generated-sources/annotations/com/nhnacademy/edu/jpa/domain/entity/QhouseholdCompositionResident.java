package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QhouseholdCompositionResident is a Querydsl query type for householdCompositionResident
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QhouseholdCompositionResident extends EntityPathBase<householdCompositionResident> {

    private static final long serialVersionUID = 1162212720L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QhouseholdCompositionResident householdCompositionResident = new QhouseholdCompositionResident("householdCompositionResident");

    public final QHousehold household;

    public final StringPath householdCompositionChangeReasonCode = createString("householdCompositionChangeReasonCode");

    public final StringPath householdRelationshipCode = createString("householdRelationshipCode");

    public final QhouseholdCompositionResident_Pk pk;

    public final DatePath<java.sql.Date> reportDate = createDate("reportDate", java.sql.Date.class);

    public final QResident resident;

    public QhouseholdCompositionResident(String variable) {
        this(householdCompositionResident.class, forVariable(variable), INITS);
    }

    public QhouseholdCompositionResident(Path<? extends householdCompositionResident> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QhouseholdCompositionResident(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QhouseholdCompositionResident(PathMetadata metadata, PathInits inits) {
        this(householdCompositionResident.class, metadata, inits);
    }

    public QhouseholdCompositionResident(Class<? extends householdCompositionResident> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
        this.pk = inits.isInitialized("pk") ? new QhouseholdCompositionResident_Pk(forProperty("pk")) : null;
        this.resident = inits.isInitialized("resident") ? new QResident(forProperty("resident")) : null;
    }

}

