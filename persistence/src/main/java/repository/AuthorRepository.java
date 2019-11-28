package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Author;
import pl.sda.entities.Book;
import util.HibernateUtil;

import java.util.List;

public class AuthorRepository {

    private Session session;

    public AuthorRepository() {
        this.session = HibernateUtil.openSession();
    }
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

    public List<Author> show() {
        return session.createQuery("from Author",Author.class).list();
    }

    public Author find(Long idAuthor) {
        return session.find(Author.class,idAuthor);
    }
}
