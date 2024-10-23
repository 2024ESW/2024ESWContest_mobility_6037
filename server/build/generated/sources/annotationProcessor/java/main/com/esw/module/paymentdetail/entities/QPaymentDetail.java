package com.esw.module.paymentdetail.entities;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentDetail is a Querydsl query type for PaymentDetail
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPaymentDetail extends EntityPathBase<PaymentDetail> {

    private static final long serialVersionUID = 1168625489L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPaymentDetail paymentDetail = new QPaymentDetail("paymentDetail");

    public final com.esw.global.database.utils.QEntityTimestamp _super = new com.esw.global.database.utils.QEntityTimestamp(this);

    public final NumberPath<Integer> amount = createNumber("amount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final com.esw.module.product.entities.QProduct product;

    public QPaymentDetail(String variable) {
        this(PaymentDetail.class, forVariable(variable), INITS);
    }

    public QPaymentDetail(Path<? extends PaymentDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPaymentDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPaymentDetail(PathMetadata metadata, PathInits inits) {
        this(PaymentDetail.class, metadata, inits);
    }

    public QPaymentDetail(Class<? extends PaymentDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.esw.module.product.entities.QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

