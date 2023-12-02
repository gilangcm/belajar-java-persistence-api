package programmerzamannow.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmerzamannow.jpa.entity.Customer;
import programmerzamannow.jpa.entity.Image;
import programmerzamannow.jpa.util.JpaUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LargeObjectTest {

    @Test
    void largeObject() throws IOException, URISyntaxException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Image image = new Image();
        image.setName("contoh image");
        image.setDescription("contoh description image");

        byte[] bytes = Files.readAllBytes(Path.of(getClass().getResource("/images/sample.jpeg").toURI()));

        image.setImage(bytes);

        entityManager.persist(image);


        entityTransaction.commit();
        entityManager.close();
    }
}
