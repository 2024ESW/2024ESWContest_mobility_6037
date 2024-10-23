package com.esw.module.storescore.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStoreScore is a Querydsl query type for StoreScore
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreScore extends EntityPathBase<StoreScore> {

    private static final long serialVersionUID = 2019621489L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStoreScore storeScore = new QStoreScore("storeScore");

    public final com.esw.global.database.utils.QEntityTimestamp _super = new com.esw.global.database.utils.QEntityTimestamp(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath detail = createString("detail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.esw.module.member.entities.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final com.esw.module.store.entities.QStore store;

    public QStoreScore(String variable) {
        this(StoreScore.class, forVariable(variable), INITS);
    }

    public QStoreScore(Path<? extends StoreScore> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStoreScore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStoreScore(PathMetadata metadata, PathInits inits) {
        this(StoreScore.class, metadata, inits);
    }

    public QStoreScore(Class<? extends StoreScore> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new com.esw.module.member.entities.QMember(forProperty("member")) : null;
        this.store = inits.isInitialized("store") ? new com.esw.module.store.entities.QStore(forProperty("store")) : null;
    }

}

