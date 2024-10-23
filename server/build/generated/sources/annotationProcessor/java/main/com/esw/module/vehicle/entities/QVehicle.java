package com.esw.module.vehicle.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVehicle is a Querydsl query type for Vehicle
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVehicle extends EntityPathBase<Vehicle> {

    private static final long serialVersionUID = 1428395857L;

    public static final QVehicle vehicle = new QVehicle("vehicle");

    public final com.esw.global.database.utils.QEntityTimestamp _super = new com.esw.global.database.utils.QEntityTimestamp(this);

    public final StringPath color = createString("color");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath model = createString("model");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final BooleanPath supportInternet = createBoolean("supportInternet");

    public final StringPath vehicleNo = createString("vehicleNo");

    public QVehicle(String variable) {
        super(Vehicle.class, forVariable(variable));
    }

    public QVehicle(Path<? extends Vehicle> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVehicle(PathMetadata metadata) {
        super(Vehicle.class, metadata);
    }

}

