package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Connector {
    final StandardServiceRegistry registry;
    SessionFactory sessionFactory;

    public Connector() {
        // объект содержит механизмы для связи с сервером БД и менеджером передачи запросов
        // работает по файлу конфигурации hibernate.cfg.xml
        registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        // объект используется для получения объектов сессии, которые использ. для операций с БД
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }
    public Session getSession() {
        // объект используется для операций с БД
        return sessionFactory.openSession();
    }
}
