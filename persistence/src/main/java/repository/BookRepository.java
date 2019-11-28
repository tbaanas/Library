package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Book;
import util.HibernateUtil;

import java.util.List;

public class BookRepository {

    private Session session;

    public BookRepository() {
        this.session = HibernateUtil.openSession();
    }

    Transaction tx = null;

    public void save(Book book) {

        try {
            tx = session.getTransaction();
            tx.begin();
            session.persist(book);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public List<Book> show() {
        session.clear();
        return session.createQuery("from Book", Book.class).list();
    }

    public Book find(long id) {
        session.clear();
        return session.find(Book.class, id);
    }

    public void delete(int bookId) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.delete(find(bookId));
        transaction.commit();
    }

    public void update(Book book) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(book);
        //session.update(book);
       // session.saveOrUpdate(book);
        transaction.commit();

    }

}
