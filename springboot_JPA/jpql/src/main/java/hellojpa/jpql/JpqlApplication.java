package hellojpa.jpql;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpqlApplication {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPQL");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Team teamA = new Team();
			teamA.setName("팀A");
			em.persist(teamA);

			Team teamB = new Team();
			teamB.setName("팀B");
			em.persist(teamB);

			Member member1 = new Member();
			member1.setUsername("회원1");
			member1.setTeam(teamA);
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("회원2");
			member2.setTeam(teamA);
			em.persist(member2);

			Member member3 = new Member();
			member3.setUsername("회원3");
			member3.setTeam(teamB);
			em.persist(member3);

			// FLUSH 자동 호출
			int resultCount = em.createQuery("update Member m set m.age = 20").executeUpdate();

			em.clear();

			Member findMember = em.find(Member.class, member1.getId());

			System.out.println("findMember.getAge() = " + findMember.getAge());

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();

		SpringApplication.run(JpqlApplication.class, args);
	}
}
