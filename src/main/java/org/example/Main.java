package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector();

        try(Session session = connector.getSession()) {
            Transaction t = session.beginTransaction();
            Person person = new Person("Anna", 22);
            session.save(person);
            System.out.println("Object student save successfully");
            person = new Person("Andrew", 25);
            session.save(person);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}