package game.guidebook.repository;

import game.guidebook.domain.Board;
import game.guidebook.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryOld {

    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public User findOne(Long id) {
        return em.find(User.class, id);
    }

    /**
     * @return 유저 이름 중복 검사
     */
    public boolean existUserName(String name) throws Exception {
        Optional<User> optUserByName = Optional.ofNullable(
                em.createQuery("select u from User u where u.name= :name", User.class)
                .setParameter("name", name)
                .getSingleResult());
        return optUserByName.isPresent();
    };

    /**
     *
     * @return 유저 휴대폰 번호 중복 검사
     */
    public boolean existMobile(String mobile) throws Exception {
        Optional<User> optUserByMobile = Optional.ofNullable(
                em.createQuery("select u from User u where u.mobile= :mobile", User.class)
                .setParameter("mobile", mobile)
                .getSingleResult());
        return optUserByMobile.isPresent();
    };

    /**
     *
     * @return 유저 이메일 중복 검사
     */
    public boolean existEmail(String email) throws Exception {
        Optional<User> optUserByEmail = Optional.ofNullable(
                em.createQuery("select u from User u where u.email= :email", User.class)
                .setParameter("email", email)
                .getSingleResult());
        return optUserByEmail.isPresent();
    };
}
