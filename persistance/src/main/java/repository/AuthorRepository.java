package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Author;
import util.HibernateUtil;

public class AuthorRepository {

    public void save(Author author) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(author);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void cleanUp() {
        HibernateUtil.cleanUp();
    }

}
