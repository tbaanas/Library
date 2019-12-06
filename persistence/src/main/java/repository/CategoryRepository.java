package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Author;
import pl.sda.entities.Category;
import util.HibernateUtil;

import java.util.List;

public class CategoryRepository {

    private Session session;

    public CategoryRepository() {

        this.session = HibernateUtil.openSession();
    }
    public void save(Category category) {
        Transaction tx = null;
        try (Session session = HibernateUtil.openSession()) {
            tx = session.getTransaction();
            tx.begin();
            session.persist(category);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }


    public List<Category> show() {

        return  session.createQuery("from Category",Category.class).list();
    }
}
