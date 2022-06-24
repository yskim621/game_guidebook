package game.guidebook.repository;

import game.guidebook.domain.Game;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Slf4j
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
