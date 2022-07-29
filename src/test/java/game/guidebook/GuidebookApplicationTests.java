package game.guidebook;

import com.querydsl.jpa.impl.JPAQueryFactory;
import game.guidebook.domain.QReply;
import game.guidebook.domain.Reply;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class GuidebookApplicationTests {

	@PersistenceContext
	EntityManager em;

	@Test
	void contextLoads() throws Exception {
		Reply reply = new Reply();
		em.persist(reply);

		JPAQueryFactory query = new JPAQueryFactory(em);
		QReply qReply = QReply.reply;

		Reply result = query
				.selectFrom(qReply)
				.fetchOne();

		assertThat(result).isEqualTo(reply);

	}

}
