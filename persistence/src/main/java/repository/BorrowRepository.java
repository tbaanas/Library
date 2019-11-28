package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Book;
import pl.sda.entities.Borrow;
import util.HibernateUtil;

public class BorrowRepository {

    private Session session;

    public BorrowRepository() {

        this.session = HibernateUtil.openSession();
    }
    public void save(Borrow borrow) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(borrow);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public Borrow find(long id) {
        return session.find(Borrow.class, id);
    }


}
