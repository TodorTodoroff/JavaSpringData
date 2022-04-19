import Exercises.Sales02.Customer;
import Exercises.Sales02.Product;
import Exercises.Sales02.Sale;
import Exercises.Sales02.StoreLocation;
import Exercises.UniversitySystem03.Course;
import Exercises.UniversitySystem03.Student;
import Exercises.UniversitySystem03.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa_related");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

//        Customer customer = new Customer("pesho", "pesho", "123");
//        Product product = new Product("coffee", 2.0, BigDecimal.ONE);
//        StoreLocation storeLocation = new StoreLocation("Sofia");
//        Sale sale = new Sale(product, customer, storeLocation, LocalDateTime.now());
//
//        manager.persist(customer);
//        manager.persist(product);
//        manager.persist(storeLocation);
//        manager.persist(sale);
//
//
//
//        Student student =
//                new Student("Pesho", "Peshov", "088888888888", 4.51
//                        , 1);
//
//
//        Course course =
//                new Course("Maths", "1+2+3", LocalDate.now(), LocalDate.now(), 12);
//
//
//
//        Teacher teacher =
//                new Teacher("Todor", "uchitel", "08888888888"
//                        , "uchitelq@asd.cc", 12.1);
//
//        manager.persist(student);
//        manager.persist(course);
//        manager.persist(teacher);


        manager.getTransaction().commit();
        manager.close();

    }
}
