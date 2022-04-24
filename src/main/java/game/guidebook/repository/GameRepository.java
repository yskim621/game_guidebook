package game.guidebook.repository;

import game.guidebook.domain.Board;
import game.guidebook.domain.Game;
import game.guidebook.service.dto.QueryParam;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameRepository {

    private final EntityManager em;
    private SessionFactory sessionFactory;

    public Game findOne(String gameCode) {
        return em.find(Game.class, gameCode);
    }

    public Game findByGame(String gameCode){
        return em.createQuery("select g from Game g where g.gameCode= :gameCode", Game.class)
                .setParameter("gameCode", gameCode)
                .getSingleResult();
    }

}
