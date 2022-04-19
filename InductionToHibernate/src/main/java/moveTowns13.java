import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class moveTowns13 {
    static int counter = 0;

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String townToDelete = scanner.nextLine();

        manager.getTransaction().begin();

        manager.createQuery("SELECT a FROM Address a " +
                                "WHERE a.town.name = :townDelete"
                        , Address.class)
                .setParameter("townDelete", townToDelete)
                .getResultStream()
                .forEach(a -> {
                    a.setText(null);
                    counter++;
                });

        manager.createQuery("SELECT t FROM Town t WHERE t.name = :townDelete "
                ,Town.class)
                .setParameter("townDelete", townToDelete)
                .getResultStream()
                .forEach(manager::remove);

        manager.getTransaction().commit();

        System.out.println(counter > 1 ? counter + " addresses in " + townToDelete + " deleted"
                : counter + " address in " + townToDelete + " deleted");

        manager.close();
    }
}

