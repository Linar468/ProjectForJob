package hibernateTest.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            List<Employee> emps = session.createQuery("from Employee WHERE " +
                    "name = 'Forza' AND salary > 500")
                    .getResultList();
            for (Employee e : emps)
                System.out.println(e);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}
