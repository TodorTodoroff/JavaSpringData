import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindEmployeesByFirstName11 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String pattern = scanner.nextLine().toLowerCase().concat("%");

        manager.getTransaction().begin();
        manager.createQuery("SELECT e FROM Employee e " +
                                "WHERE lower(e.firstName) LIKE :inputPattern "
                        , Employee.class)
                .setParameter("inputPattern", pattern)
                .getResultStream()
                .forEach(x -> System.out.printf("%s %s - %s - ($%.2f)%n"
                        , x.getFirstName()
                        , x.getLastName()
                        , x.getJobTitle()
                        , x.getSalary()));
        manager.getTransaction().commit();
        manager.close();
    }
}
