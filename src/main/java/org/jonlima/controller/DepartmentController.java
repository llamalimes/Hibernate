package org.jonlima.controller;
import org.jonlima.model.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class DepartmentController {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        //addDepartment(sf, s);
        //findDepartment(sf, s, 2);
        //updateDepartment(s,3);
        //deleteDepartment(s,4);
    }

    public static void addDepartment(SessionFactory sf, Session s){
        Transaction tx = s.beginTransaction();
        Department dOne = new Department();
        dOne.setName("Finance");
        dOne.setState("Alabama");

        Department dTwo = new Department();
        dTwo.setName("Accounting");
        dTwo.setState("Alaska");

        Department dThree = new Department("HR","Arizona");
        Department dFour = new Department("Sales","Arkansas");
        Department dFive = new Department("Shipping","California");

        s.persist(dOne);
        s.persist(dTwo);
        s.persist(dThree);
        s.persist(dFour);
        s.persist(dFive);

        tx.commit();
        System.out.println("successfully saved");
        sf.close();
        s.close();
    }
    public static void findDepartment(SessionFactory sf, Session s, int dId){
        Transaction tx = s.beginTransaction();

        Department d = s.get(Department.class, dId);
        System.out.println("name: " + d.getName());
        System.out.println("state: " + d.getState());

        tx.commit();
        sf.close();
        s.close();
    }
    public static void updateDepartment(Session s, int dId){
        Transaction tx = s.beginTransaction();
        Department d = new Department("Human Resources", "Connecticut");
        d.setDid(dId);
        s.merge(d);
        s.getTransaction().commit();
        s.close();
    }
    public static void deleteDepartment(Session s, int dId){
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Transaction tx = s.beginTransaction();
        Department d = new Department();
        d.setDid(dId);
        s.remove(d);
        tx.commit();
        s.close();
        sf.close();
    }
}
