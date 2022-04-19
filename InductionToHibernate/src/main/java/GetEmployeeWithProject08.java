import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class GetEmployeeWithProject08 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        int providedId = Integer.parseInt(scanner.nextLine());

        manager.getTransaction().begin();

        manager.createQuery("SELECT e FROM Employee e " +
                                "WHERE e.id = :provided_id "
                        , Employee.class)
                .setParameter("provided_id", providedId)
                .getResultStream()
                .forEach(x -> {
                    System.out.println(x);
                    x.getProjects().stream().map(Project::getName).sorted().forEach(System.out::println);
                });
        manager.getTransaction().commit();
        manager.close();
    }
}
