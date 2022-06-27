package game.guidebook.repository;

import game.guidebook.domain.Board;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class BoardJpaRepository {

    private final EntityManager em;

    public List<Board> findAll(QueryParam query_param){
        int size = query_param.getPageSize();
        int start = (query_param.getPageNumber() - 1) * size;

        return em.createQuery("select b from Board b", Board.class)
                .setFirstResult(start)
                .setMaxResults(size)
                .getResultList();
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