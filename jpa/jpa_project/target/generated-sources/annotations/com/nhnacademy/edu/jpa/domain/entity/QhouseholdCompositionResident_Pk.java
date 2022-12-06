package com.nhnacademy.edu.jpa.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QhouseholdCompositionResident_Pk is a Querydsl query type for Pk
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QhouseholdCompositionResident_Pk extends BeanPath<householdCompositionResident.Pk> {

    private static final long serialVersionUID = 1747815257L;

    public static final QhouseholdCompositionResident_Pk pk = new QhouseholdCompositionResident_Pk("pk");

    public final NumberPath<Integer> householdSerialNumber = createNumber("householdSerialNumber", Integer.class);

    public final NumberPath<Integer> residentSerialNumber = createNumber("residentSerialNumber", Integer.class);

    public QhouseholdCompositionResident_Pk(String variable) {
        super(householdCompositionResident.Pk.class, forVariable(variable));
    }

    public QhouseholdCompositionResident_Pk(Path<? extends householdCompositionResident.Pk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QhouseholdCompositionResident_Pk(PathMetadata metadata) {
        super(householdCompositionResident.Pk.class, metadata);
    }

}

