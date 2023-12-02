package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Brand;
import programmerzamannow.jpa.entity.Member;
import programmerzamannow.jpa.util.JpaUtil;

import java.util.List;

public class TransactionTest {

    @Test
    void transaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        Assertions.assertNotNull(entityTransaction);

        try {
            entityTransaction.begin();
            // manipulasi database
            entityTransaction.commit();
        }catch (Throwable throwable){
            entityTransaction.rollback();
        }

        entityManager.close();
    }

}
