package game.guidebook.repository.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import game.guidebook.domain.QBoard;
import game.guidebook.repository.BoardRepository;
import game.guidebook.repository.BoardRepositoryCustom;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import org.hibernate.SQLQuery;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static game.guidebook.domain.QBoard.*;

@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepositoryCustom {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    @Override
    public int findCountByCondition(QueryParam query_param) {
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.hasText(query_param.getValue())) {
            if (query_param.getSearchType().equals("nickname")) {
                builder.and(board.userNickname.eq(query_param.getValue()));
            } else {
                builder.and(board.title.like("%" + query_param.getValue() + "%"));
            }
        }
        return queryFactory
                .selectFrom(board)
                .where(builder)
                .fetch()
                .size();
    }
}
