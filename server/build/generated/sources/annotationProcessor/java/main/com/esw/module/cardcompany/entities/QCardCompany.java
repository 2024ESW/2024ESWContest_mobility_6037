package com.esw.module.cardcompany.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCardCompany is a Querydsl query type for CardCompany
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCardCompany extends EntityPathBase<CardCompany> {

    private static final long serialVersionUID = 1760624465L;

    public static final QCardCompany cardCompany = new QCardCompany("cardCompany");

    public final com.esw.global.database.utils.QEntityTimestamp _super = new com.esw.global.database.utils.QEntityTimestamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QCardCompany(String variable) {
        super(CardCompany.class, forVariable(variable));
    }

    public QCardCompany(Path<? extends CardCompany> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCardCompany(PathMetadata metadata) {
        super(CardCompany.class, metadata);
    }

}

