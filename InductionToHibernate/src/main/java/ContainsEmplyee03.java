import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class ContainsEmplyee03 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String[] name = scanner.nextLine().split("\\s+");

        manager.getTransaction().begin();

//        Query employee = manager.createQuery("SELECT t FROM Employee t", Employee.class);
//        List<Employee> employeeResultList = employee.getResultList();
//
//        boolean doesContainName = false;
//
//        for (Employee employee1 : employeeResultList) {
//            if (employee1.getFirstName().equals(name[0])
//                    && employee1.getLastName().equals(name[1]) ){
//                doesContainName = true;
//            }
//        }
//        System.out.println(doesContainName ? "Yes" : "No");

        Long employee = manager
                .createQuery("SELECT COUNT(t) FROM Employee t " +
                "WHERE t.firstName = :first_name " +
                "AND t.lastName = :last_name", Long.class)
                .setParameter("first_name", name[0])
                .setParameter("last_name", name[1])
                .getSingleResult();

        System.out.println(employee > 0 ? "Yes" : "No");

       manager.getTransaction().commit();

    }
}
