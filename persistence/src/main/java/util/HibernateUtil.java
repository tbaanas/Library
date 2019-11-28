package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY;

    static {
        try {
            StandardServiceRegistry standardRegistry =
                    new StandardServiceRegistryBuilder().configure().build();
            Metadata metaData =
                    new MetadataSources(standardRegistry).getMetadataBuilder().build();
            SESSION_FACTORY = metaData.getSessionFactoryBuilder().build();
        } catch (Exception e) {
            System.err.println("Enitial SessionFactory creation failed");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session openSession() {
        return SESSION_FACTORY.openSession();
    }

    public static void cleanUp(){
        openSession().close();
        SESSION_FACTORY.close();
    }
}
