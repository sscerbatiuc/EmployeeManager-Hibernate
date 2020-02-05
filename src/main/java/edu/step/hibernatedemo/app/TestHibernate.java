/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.step.hibernatedemo.app;

import edu.step.hibernatedemo.Employee;
import edu.step.hibernatedemo.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author sscerbatiuc
 */
public class TestHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Add new Employee object
        Employee emp = new Employee();
        emp.setName("hibernateUser");
        emp.setAddress("step it");
        emp.setPhoneno("phone no");

        session.save(emp);

        session.getTransaction().commit();
        session.clear();
        session.close();
        HibernateUtil.shutdown();
    }
}
