package rsvier;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Baas baas1 = new Baas("testbaas1");
        Hond hond1 = new Hond();
        Hond hond2 = new Hond();
        hond1.setBaas(baas1); // Hibernate persisteert alleen via de owning entity (nu dus hond)!
        hond2.setBaas(baas1);
//        baas1.addHond(hond1); // 
//        baas1.addHond(hond2);
        
        et.begin();
        em.persist(hond1);
        em.persist(hond2);
        em.persist(baas1);
        et.commit();
        em.clear();
        
//        Baas b = em.find(Baas.class, 1L);
//        // Hondlist bevat de twee honden ondanks dat ze niet expliciet zijn toegevoegd
//        System.out.println(b);
        
        Hond h = em.find(Hond.class, 1L);
        // Baas wordt opgehaald met join by default (ManyToOne is standaard Eager fetched)
        System.out.println(h);
        
    }
}
