package com.esw.global.database.utils;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEntityTimestamp is a Querydsl query type for EntityTimestamp
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QEntityTimestamp extends EntityPathBase<EntityTimestamp> {

    private static final long serialVersionUID = -2100571204L;

    public static final QEntityTimestamp entityTimestamp = new QEntityTimestamp("entityTimestamp");

    public final DateTimePath<java.time.LocalDateTime> createdDate = createDateTime("createdDate", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedDate = createDateTime("modifiedDate", java.time.LocalDateTime.class);

    public QEntityTimestamp(String variable) {
        super(EntityTimestamp.class, forVariable(variable));
    }

    public QEntityTimestamp(Path<? extends EntityTimestamp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEntityTimestamp(PathMetadata metadata) {
        super(EntityTimestamp.class, metadata);
    }

}

