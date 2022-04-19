import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeesFromDepartment05 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        String department = "Research and Development";


        manager
                .createQuery(" SELECT e FROM Employee e  " +
                                "  WHERE e.department.name = :departmentName  " +
                                "  ORDER BY e.salary ASC , e.id ASC  "
                        , Employee.class)
                .setParameter("departmentName", department)
                .getResultStream()
                .forEach(x -> {
                 String output = String.format("%s %s from %s - $%f"
                            , x.getFirstName()
                            , x.getLastName()
                            , department
                            , x.getSalary());
                    System.out.println(output);
                });

manager.getTransaction().commit();
manager.close();
    }
}
