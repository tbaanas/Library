package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Borrow;
import pl.sda.entities.Borrower;
import util.HibernateUtil;

import java.util.List;

public class BorrowerRepository {
    private Session session;
    public BorrowerRepository() {
        this.session = HibernateUtil.openSession();
    }

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

    public Borrower find(long id) {

        return session.find(Borrower.class,id);
    }

    public Borrower findBorrow(long id) {

        return (Borrower) session.createQuery("select borowerId from Borrower,Borrow where Borrow.borowerId=Borrower.id");
    }

    public List<Borrower> findAll() {

        return session.createQuery("from Borrower",Borrower.class).list();
    }

}
