package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Author;
import pl.sda.entities.Users;
import util.HibernateUtil;

import java.util.List;

public class UsersRepository {


    private Session session;

    public UsersRepository() {

        this.session = HibernateUtil.openSession();
    }
    Transaction tx = null;

    public void save(Users user) {

        try {
            tx = session.getTransaction();
            tx.begin();
            session.persist(user);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }
    }

}
