import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class IncreaseSalaries10 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("SELECT e FROM Employee e " +
                                "WHERE e.department.id IN (1,2,4,11) "
                        , Employee.class)
                .getResultStream()
                .forEach(e -> {
                    BigDecimal salaryIncrease = e.getSalary().multiply(BigDecimal.valueOf(1.12));
                    e.setSalary(salaryIncrease);
                    System.out.printf("%s %s (%.2f)%n", e.getFirstName(), e.getLastName(), e.getSalary());
                });

        //1,2,4,11
        manager.getTransaction().commit();
        manager.close();

    }
}
