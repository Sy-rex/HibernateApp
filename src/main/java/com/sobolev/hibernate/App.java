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

            Person person = new Person("Test1",30);
            Person person2 = new Person("Test2",40);
            Person person3 = new Person("Test3",50);

            session.save(person);
            session.save(person2);
            session.save(person3);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
