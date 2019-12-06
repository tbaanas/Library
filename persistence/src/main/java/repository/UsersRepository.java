package repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.entities.Users;
import util.HibernateUtil;

import java.util.List;

public class UsersRepository {


    private Session session;

    public UsersRepository() {

        this.session = HibernateUtil.openSession();
    }

    private Transaction tx = null;

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

    public List<Users> uid(String login, String password) {
       return  session.createQuery("from Users where username='"+login +"' AND  password='"+password+"'", Users.class).list();
    }


    public List<Users> findAll(String login, String password) {

        return session.createQuery("from Users where username="+login+" and password="+password,Users.class).list();
    }




    public Users login(Long id) {
        return session.find(Users.class,id);
    }
}
