package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QhouseholdMovementAddress_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QhouseholdMovementAddress_Pk extends BeanPath<householdMovementAddress.Pk> {

    private static final long serialVersionUID = -763966130L;

    public static final QhouseholdMovementAddress_Pk pk = new QhouseholdMovementAddress_Pk("pk");

    public final NumberPath<Integer> householdSerialNumber = createNumber("householdSerialNumber", Integer.class);

    public final DatePath<java.sql.Date> houseMovementReportDate = createDate("houseMovementReportDate", java.sql.Date.class);

    public QhouseholdMovementAddress_Pk(String variable) {
        super(householdMovementAddress.Pk.class, forVariable(variable));
    }

    public QhouseholdMovementAddress_Pk(Path<? extends householdMovementAddress.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QhouseholdMovementAddress_Pk(PathMetadata metadata) {
        super(householdMovementAddress.Pk.class, metadata);
    }

}

