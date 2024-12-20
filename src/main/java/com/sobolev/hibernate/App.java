package com.sobolev.hibernate;


import com.sobolev.hibernate.model.*;
import org.hibernate.Hibernate;
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

        try(sessionFactory){
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = session.get(Person.class, 6);
//            System.out.println("Получили человека");
//
//            // Получим связанные сущности(Lazy)
//            System.out.println(person.getItems());


//            // Сразу получаем неленивую загрузку(Eager)
//            Item item = session.get(Item.class, 1);
//            System.out.println("Получили товар");
//
//            System.out.println(item.getOwner());

//            Person person = session.get(Person.class, 6);
//            System.out.println("Получили человека из таблицы");
//            System.out.println(person);
//
//            Hibernate.initialize(person.getItems()); // подгружаем связанные ленивые сущности
////            System.out.println(person.getItems());

            Person person = session.get(Person.class, 6);
            System.out.println("Получили человека из таблицы");

            session.getTransaction().commit();
            // session.close()
            System.out.println("Сессия закончилась");

            // открываем сессию и транзакцию ещё раз
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            person = (Person) session.merge(person);

            Hibernate.initialize(person.getItems());

            session.getTransaction().commit();

            // Вне сессии можно получать товары при EAGER
            System.out.println("Вне 2 сессии");
            System.out.println(person.getItems());

        }
    }
}
