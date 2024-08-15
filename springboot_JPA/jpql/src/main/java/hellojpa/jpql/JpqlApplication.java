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
			Member member1 = new Member();
			member1.setUsername("관리자1");
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("관리자2");
			em.persist(member2);

			em.flush();
			em.clear();

			String query = "select m From Team t join t.members m";

			List<String> result = em.createQuery(query, String.class).getResultList();

			for (String s : result) {
				System.out.println("s = " + s);
			}
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
