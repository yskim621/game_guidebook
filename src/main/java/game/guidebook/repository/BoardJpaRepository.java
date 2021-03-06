package game.guidebook.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import game.guidebook.domain.Board;
import game.guidebook.domain.QBoard;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static game.guidebook.domain.QBoard.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardJpaRepository {

    private final EntityManager em;
    private final JPAQueryFactory queryFactory;


    public List<Board> findAll(QueryParam query_param){
        BooleanBuilder builder = new BooleanBuilder();
        int size = query_param.getPageSize();
        int start = (query_param.getPageNumber() - 1) * size;

        if (StringUtils.hasText(query_param.getValue())) {
            if (query_param.getSearchType().equals("nickname")) {
                builder.and(board.userNickname.eq(query_param.getValue()));
            } else {
                builder.and(board.title.like("%" + query_param.getValue() + "%"));
            }
        }
//        return em.createQuery("select b from Board b", Board.class)
//                .setFirstResult(start)
//                .setMaxResults(size)
//                .getResultList();

        // QueryDSL 적용
        return queryFactory
                .selectFrom(board)
                .where(builder)
                .orderBy(board.id.desc())
                .offset(start)
                .limit(size)
                .fetch();
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }

    public void create(Board board){
        em.persist(board);
    }


    @Transactional
    public Long delete(Long id) {
        Board board = findOne(id);
        em.remove(board);
        return board.getId();
    }

}
