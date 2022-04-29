package game.guidebook.repository;

import game.guidebook.domain.Board;
import game.guidebook.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    /**
     * @return 유저 이름 중복 검사
     */
    public boolean existUserName(String name) throws NoResultException {
        return em.createQuery("select u from User u where u.name= :name", User.class)
                .setParameter("name", name)
                .getSingleResult() != null;
    };

    /**
     *
     * @return 유저 휴대폰 번호 중복 검사
     */
    public boolean existMobile(String mobile) throws NoResultException {
        return em.createQuery("select u from User u where u.mobile= :mobile", User.class)
                .setParameter("mobile", mobile)
                .getSingleResult() != null;
    };

    /**
     *
     * @return 유저 이메일 중복 검사
     */
    public boolean existEmail(String email) throws NoResultException {
        return em.createQuery("select u from User u where u.email= :email", User.class)
                .setParameter("email", email)
                .getSingleResult() != null;
    };
}
