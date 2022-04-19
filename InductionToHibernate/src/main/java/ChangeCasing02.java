import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ChangeCasing02 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Query from_town = em.createQuery("SELECT t FROM Town t", Town.class);


        List<Town> townsList = from_town.getResultList();

        for (Town town : townsList) {
            if (town.getName().length() > 5) {
                em.detach(town);
            } else {
                town.setName(town.getName().toUpperCase());
                em.persist(town);
            }
        }
        em.getTransaction().commit();
    }
}
