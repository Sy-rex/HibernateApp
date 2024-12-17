package com.sobolev.hibernate;


import com.sobolev.hibernate.model.Item;
import com.sobolev.hibernate.model.Passport;
import com.sobolev.hibernate.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class).addAnnotatedClass(Passport.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

//            Person person = session.get(Person.class, 7);
//
//            System.out.println(person.getPassport().getPassportNumber());

//            Passport passport = session.get(Passport.class, 7);
//            System.out.println(passport.getPerson().getName());

//            Person person = session.get(Person.class, 7);
//            person.getPassport().setPassportNumber(77777);

            Person person = session.get(Person.class, 8);
            session.remove(person);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
