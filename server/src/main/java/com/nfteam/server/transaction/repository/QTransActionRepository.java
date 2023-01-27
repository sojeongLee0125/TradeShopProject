package com.nfteam.server.transaction.repository;

import com.nfteam.server.dto.response.item.ItemTradeHistoryResponse;
import com.querydsl.core.types.ConstructorExpression;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.nfteam.server.transaction.entity.QTransAction.transAction;

@Repository
public class QTransActionRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public QTransActionRepository(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public List<ItemTradeHistoryResponse> findHistory(Long itemId) {
        return jpaQueryFactory
                .select(getItemTradeResponseConstructor())
                .from(transAction)
                .leftJoin(transAction.seller)
                .leftJoin(transAction.buyer)
                .leftJoin(transAction.coin)
                .where(transAction.item.itemId.eq(itemId))
                .orderBy(transAction.createdDate.desc())
                .limit(10)
                .fetch();
    }

    private ConstructorExpression<ItemTradeHistoryResponse> getItemTradeResponseConstructor() {
        return Projections.constructor(ItemTradeHistoryResponse.class,
                transAction.seller.memberId,
                transAction.seller.nickname,
                transAction.buyer.memberId,
                transAction.buyer.nickname,
                transAction.transPrice,
                transAction.coin.coinName,
                transAction.createdDate);
    }

}