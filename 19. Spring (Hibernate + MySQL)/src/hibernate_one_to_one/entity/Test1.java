package hibernate_one_to_one.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        //Session session = null;

        try {

            /*Session session = factory.getCurrentSession();
            Employee employee = new Employee("Linarchik", "Latypov", "IT", 1000);
            Detail detail = new Detail("Neftekamsk", "123456789", "ironman523@mail.ru");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done!");*/

            /*Session session = factory.getCurrentSession();
            Employee employee = new Employee("Betty", "Burger", "IT", 1500);
            Detail detail = new Detail("Moskow", "987654321", "bettyBurger@gmail.com");
            employee.setEmpDetail(detail);
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Done!");*/

            Session session = factory.getCurrentSession();

            //session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 10);
            System.out.println(emp.getEmpDetail());
            session.getTransaction().commit();
            System.out.println("Done!");

            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);
            session.getTransaction().commit();
            System.out.println("Done!");*/

        }
        finally {
            //session.close();
            factory.close();
        }
    }
}
