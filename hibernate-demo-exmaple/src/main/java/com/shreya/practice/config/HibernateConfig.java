package com.shreya.practice.config;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {

    private static SessionFactory buildSessionFactory(){

        try {
            return new Configuration().configure().buildSessionFactory();
        }
        finally {

        }
    }
}
