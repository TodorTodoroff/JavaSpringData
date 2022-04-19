import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Optional;

public class EmployeesMaximumSalaries12 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("SELECT d FROM Department d " +
                                "JOIN Employee e ON e.department.id = d.id " +
                                "GROUP BY d.id " +
                                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000"
                        , Department.class)
                .getResultStream()
                .forEach(d -> {
                    double sum = d.getEmployees().stream().map(Employee::getSalary)
                            .mapToDouble(BigDecimal::doubleValue).max().getAsDouble();

                    System.out.printf("%s %.2f%n", d.getName(), sum);
                });

        manager.getTransaction().commit();
        manager.close();
    }
}
