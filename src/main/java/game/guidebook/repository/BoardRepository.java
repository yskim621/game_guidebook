package game.guidebook.repository;

import game.guidebook.domain.Board;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final EntityManager em;

    public List<Board> findAll(QueryParam query_param, int offset, int limit){
        query_param.setPageNumber(query_param.getPageNumber());
        return em.createQuery("select b from Board b", Board.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }

    public Board findOne(Long id) {
        return em.find(Board.class, id);
    }
}
