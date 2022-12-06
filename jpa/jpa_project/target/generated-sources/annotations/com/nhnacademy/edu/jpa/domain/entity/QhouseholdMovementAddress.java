package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QhouseholdMovementAddress is a Querydsl query type for householdMovementAddress
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QhouseholdMovementAddress extends EntityPathBase<householdMovementAddress> {

    private static final long serialVersionUID = -807665765L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QhouseholdMovementAddress householdMovementAddress = new QhouseholdMovementAddress("householdMovementAddress");

    public final QHousehold household;

    public final StringPath houseMovementAddress = createString("houseMovementAddress");

    public final ComparablePath<Character> lastAddressYN = createComparable("lastAddressYN", Character.class);

    public final QhouseholdMovementAddress_Pk pk;

    public QhouseholdMovementAddress(String variable) {
        this(householdMovementAddress.class, forVariable(variable), INITS);
    }

    public QhouseholdMovementAddress(Path<? extends householdMovementAddress> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QhouseholdMovementAddress(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QhouseholdMovementAddress(PathMetadata metadata, PathInits inits) {
        this(householdMovementAddress.class, metadata, inits);
    }

    public QhouseholdMovementAddress(Class<? extends householdMovementAddress> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.household = inits.isInitialized("household") ? new QHousehold(forProperty("household"), inits.get("household")) : null;
        this.pk = inits.isInitialized("pk") ? new QhouseholdMovementAddress_Pk(forProperty("pk")) : null;
    }

}

