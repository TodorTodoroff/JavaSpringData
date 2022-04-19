import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AddressesWithEmployeeCount07 {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager manager = factory.createEntityManager();
manager.getTransaction().begin();

        manager
                .createQuery("FROM Address a" +
                                " ORDER BY a.employees.size DESC",
                        Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(System.out::println);

        manager.getTransaction().commit();
        manager.close();


    }
}
