package com.sobolev.hibernate;


import com.sobolev.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Person person = new Person("Some name",45);

            session.save(person);

            session.getTransaction().commit();

            System.out.println(person.getId());
        }finally {
            sessionFactory.close();
        }
    }
}
