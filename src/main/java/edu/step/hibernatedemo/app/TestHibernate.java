/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.step.hibernatedemo.app;

import edu.step.hibernatedemo.Employee;
import edu.step.hibernatedemo.util.HibernateUtil;
import java.util.List;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author sscerbatiuc
 */
public class TestHibernate {

    public static void main(String[] args) {
        Random rand = new Random();
        int randNum = rand.nextInt();
        create("Address" + randNum, "Name" + randNum, "PhoneNo" + randNum);
        update(1, "NewAddress", "NewName", "NewPhoneNo");
        delete(2);

        HibernateUtil.shutdown();
    }

    /**
     * Create a new Employee.
     *
     * @param address
     * @param name
     * @param phoneNo
     */
    public static void create(String address, String name, String phoneNo) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            Employee stu = new Employee();
            stu.setName(name);
            stu.setAddress(address);
            stu.setPhoneno(phoneNo);
            // Save the student
            session.save(stu);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

    /**
     * Read all the Employees.
     *
     * @return a List of Employees
     */
    public static List<Employee> readAll() {
        List<Employee> students = null;
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            students = session.createQuery("FROM Employee").list();
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
        return students;
    }

    /**
     * Delete the existing Employee.
     *
     * @param id
     */
    public static void delete(int id) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Get the Employee from the database.
            Employee stu = (Employee) session.get(Employee.class, id);
            // Delete the student
            session.delete(stu);
            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }

    /**
     * Update the existing Employee.
     *
     * @param id
     * @param name
     * @param phoneNo
     */
    public static void update(Integer id, String address, String name, String phoneNo) {
        // Create a session
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            // Begin a transaction
            transaction = session.beginTransaction();
            // Get the Employee from the database.
            Employee stu = (Employee) session.get(Employee.class, id);
            // Change the values
            stu.setName(name);
            stu.setAddress(address);
            stu.setPhoneno(phoneNo);
            // Update the student
            session.update(stu);

            // Commit the transaction
            transaction.commit();
        } catch (HibernateException ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }
    }
}
