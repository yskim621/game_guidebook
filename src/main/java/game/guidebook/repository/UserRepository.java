package game.guidebook.repository;

import game.guidebook.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

//    @Override
//    <S extends User> S saveAndFlush(S entity);
//
//    @Override
//    User getById(Long id);

    // select u from User u where u.name =
    List<User> findByName(String name);

    List<User> findByMobile(String mobile);

    List<User> findByEmail(String email);

    Optional<User> findUserByName(String name);


}
