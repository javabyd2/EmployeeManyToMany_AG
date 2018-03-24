package com.sdabyd2.manytomany;

import com.sdabyd2.manytomany.entity.Employee;
import com.sdabyd2.manytomany.entity.Project;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class Main {


    private static final SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
    }


    public static void main(String[] args) {

        Project project1 = new Project();
        project1.setTitle("Java od podstaw");

        Project project2 = new Project();
        project2.setTitle("Bazy danych");

        Project project3 = new Project();
        project3.setTitle("Wstęp do HTTP");

        Project project4 = new Project();
        project4.setTitle("Projekt grupowy");

        Project project5 = new Project();
        project5.setTitle("SPRING w praktyce");


        Employee employee1 = new Employee();
        employee1.setFirstName("Jan");
        employee1.setLastName("Kowalski");
        Set<Project> projects1 = new HashSet<>();
        projects1.add(project1);
        projects1.add(project3);
        employee1.setProjects(projects1);


        Employee employee2 = new Employee();
        employee2.setFirstName("Marcin");
        employee2.setLastName("Warzocha");
        Set<Project> projects2 = new HashSet<>();
        projects2.add(project1);
        projects2.add(project3);
        projects2.add(project5);
        employee2.setProjects(projects2);

        Employee employee3 = new Employee();
        employee3.setFirstName("Robert");
        employee3.setLastName("Lewandowski");
        Set<Project> projects3 = new HashSet<>();
        projects3.add(project2);
        projects3.add(project3);
        projects3.add(project4);
        employee3.setProjects(projects3);

        Employee employee4 = new Employee();
        employee4.setFirstName("Marcin");
        employee4.setLastName("Gortat");
        Set<Project> projects4 = new HashSet<>();
        projects4.add(project4);
        projects4.add(project5);
        employee4.setProjects(projects4);

        Employee employee5 = new Employee();
        employee5.setFirstName("Tomasz");
        employee5.setLastName("Adamek");
        Set<Project> projects5 = new HashSet<>();

        Employee employee6 = new Employee();
        employee6.setFirstName("Leon");
        employee6.setLastName("Drewek");
        Set<Project> projects6 = new HashSet<>();

        Employee employee7 = new Employee();
        employee7.setFirstName("Adrianna");
        employee7.setLastName("Piękna");
        Set<Project> projects7 = new HashSet<>();

        Employee employee8 = new Employee();
        employee8.setFirstName("Kamil");
        employee8.setLastName("Niewiadomy");
        Set<Project> projects8 = new HashSet<>();

        Employee employee9 = new Employee();
        employee9.setFirstName("Łukasz");
        employee9.setLastName("Łukaszowski");
        Set<Project> projects9 = new HashSet<>();



        Transaction transaction = null;
        Session session = getSession();


        transaction = session.beginTransaction();
        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
//        session.save(employee5);
//        session.save(employee6);
//        session.save(employee7);
//        session.save(employee8);
//        session.save(employee9);

        transaction.commit();







    }
}