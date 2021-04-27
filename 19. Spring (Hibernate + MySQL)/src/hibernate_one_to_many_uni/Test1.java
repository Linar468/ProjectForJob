package hibernate_one_to_many_uni;


import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;
        try {
            /*session = factory.getCurrentSession();
            Department dep = new Department("HR", 1500, 200);
            Employee emp1 = new Employee("Oleg", "Ivanov", 500);
            Employee emp2 = new Employee("Elena", "Smirnova", 800);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
            System.out.println("Done!");*/


            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 2);
            System.out.println(department);
            System.out.println(department.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");*/

            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();
            System.out.println("Done!");*/


//***************************************************************

            session = factory.getCurrentSession();
            session.beginTransaction();
            Department dep = session.get(Department.class, 2);
            session.delete(dep);
            session.getTransaction().commit();
            System.out.println("Done!");


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
