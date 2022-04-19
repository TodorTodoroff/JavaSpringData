import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Scanner;

public class AddingNewAddressAndUpdatingEmployee06 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        manager.getTransaction().begin();

        manager
                .createQuery("SELECT e FROM Employee e " +
                                " WHERE e.lastName = :last_name"
                        , Employee.class)
                .setParameter("last_name", name)
                .getResultStream()
                .forEach( a -> {
                    a.getAddress().setText("Vitoshka 15");

                });

        manager.getTransaction().commit();
        manager.close();

    }
}
