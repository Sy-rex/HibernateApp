package com.sobolev.hibernate;


import com.sobolev.hibernate.model.Item;
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
                .addAnnotatedClass(Item.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

//            Person person = session.get(Person.class, 3);
//            System.out.println(person);
//
//            List<Item> items =  person.getItems();
//
//            System.out.println(items);

//            Item item = session.get(Item.class, 5);
//
//            System.out.println(item);
//
//            Person person = item.getOwner();
//
//            System.out.println(person);

//            Person person = session.get(Person.class, 2);
//
//            Item item = new Item("Item from Hibernate", person);
//
//            session.save(item);
//
//            person.getItems().add(item);

//            Person person = new Person("Test person",34);
//
//            Item newItem = new Item("Item from Hibernate 2",person);
//
//            person.setItems(new ArrayList<>(Collections.singletonList(newItem)));
//
//            session.save(person);
//            session.save(newItem);

//            Person person = session.get(Person.class, 3);
//
//            List<Item> items = person.getItems();
//
//            for (Item item : items) {
//                session.remove(item);
//            }
//
//            person.getItems().clear();

//            Person person = session.get(Person.class, 2);
//
//            session.remove(person);
//
//            person.getItems().forEach(i -> i.setOwner(null));

            Person person = session.get(Person.class, 4);

            Item item = session.get(Item.class, 1);

            item.getOwner().getItems().remove(item);

            item.setOwner(person);
            person.getItems().add(item);

            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
