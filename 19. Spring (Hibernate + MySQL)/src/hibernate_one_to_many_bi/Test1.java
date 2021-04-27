package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.security.spec.ECParameterSpec;

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
            Department dep = new Department("Sales", 1500, 800);
            Employee emp1 = new Employee("Linar", "Latypov", 900);
            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
            Employee emp3 = new Employee("Melissa", "Blake", 1200);
            dep.addEmployeeToDepartment(emp1);
            dep.addEmployeeToDepartment(emp2);
            dep.addEmployeeToDepartment(emp3);
            session.beginTransaction();
            session.save(dep);
            session.getTransaction().commit();
            System.out.println("Done!");*/

//***************************************************************


            /*session = factory.getCurrentSession();
            session.beginTransaction();

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show employees of Department");
            System.out.println(department.getEmps());
            session.getTransaction().commit();
            System.out.println("Done!");*/


            //Fetch Lazy
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Get department");
            Department department = session.get(Department.class, 4);
            System.out.println("Show department");
            System.out.println(department);

            System.out.println("Подгрузим работников до закрытия сессии");
            department.getEmps().get(0);

            session.getTransaction().commit();
            System.out.println("Done!");

            System.out.println("Show employees of Department");
            System.out.println(department.getEmps());


//***************************************************************

            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();
            System.out.println("Done!");*/


//***************************************************************

            /*session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 4);
            session.delete(employee);
            session.getTransaction().commit();
            System.out.println("Done!");*/


        }
        finally {
            session.close();
            factory.close();
        }
    }
}
