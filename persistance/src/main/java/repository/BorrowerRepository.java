package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Borrow;
import pl.sda.entities.Borrower;
import util.HibernateUtil;

public class BorrowerRepository {

    public void save(Borrower borrower) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(borrower);
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
