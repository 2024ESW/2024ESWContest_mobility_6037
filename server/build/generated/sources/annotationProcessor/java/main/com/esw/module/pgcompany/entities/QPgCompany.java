package com.esw.module.pgcompany.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPgCompany is a Querydsl query type for PgCompany
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPgCompany extends EntityPathBase<PgCompany> {

    private static final long serialVersionUID = -1369569359L;

    public static final QPgCompany pgCompany = new QPgCompany("pgCompany");

    public final com.esw.global.database.utils.QEntityTimestamp _super = new com.esw.global.database.utils.QEntityTimestamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath name = createString("name");

    public QPgCompany(String variable) {
        super(PgCompany.class, forVariable(variable));
    }

    public QPgCompany(Path<? extends PgCompany> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPgCompany(PathMetadata metadata) {
        super(PgCompany.class, metadata);
    }

}

