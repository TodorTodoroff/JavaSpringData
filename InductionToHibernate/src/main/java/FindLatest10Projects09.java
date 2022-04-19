import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindLatest10Projects09 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC"
                , Project.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(System.out::println);

        manager.getTransaction().commit();
        manager.close();
    }
}
