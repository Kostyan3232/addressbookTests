package ru.stqa.pft.addressbook.Test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class HbConnectionTest {
    private SessionFactory sessionFactory;

    @BeforeClass
        protected void setUp() {
            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            try {
                sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
            }

                catch(Exception ex){
                ex.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
                }
            }

       @Test
    public void testHbConnection(){
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            List <GroupData> result = session.createQuery( "from GroupData" ).list();
            for ( GroupData group :  result ) {
                System.out.println( group );
            }
            session.getTransaction().commit();
            session.close();

    }
}

