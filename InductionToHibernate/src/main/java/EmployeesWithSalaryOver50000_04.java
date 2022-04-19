import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

public class EmployeesWithSalaryOver50000_04 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        List<String> getEmployees = manager.createQuery("SELECT e.firstName FROM Employee e" +
                " WHERE e.salary > 50000", String.class).getResultList();

//        getEmployees.forEach(System.out::println);

        String output = String.join("\n",getEmployees);
        System.out.println(output);

        manager.getTransaction().commit();
    }
}
