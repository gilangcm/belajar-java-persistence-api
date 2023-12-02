package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.util.JpaUtil;

public class ColumnTest {

    @Test
    void column() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("gils");
        customer.setPrimaryEmail("contoh@example.com");


        entityManager.persist(customer);


        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void transientTest() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("4");
        customer.setName("dipdip");
        customer.setPrimaryEmail("contoh@example.com");
        customer.setFullName("diva cahyani maulana");

        entityManager.persist(customer);


        entityTransaction.commit();
        entityManager.close();
    }
}
