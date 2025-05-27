package com.shreya.practice.repository;

import com.shreya.practice.config.HibernateConfig;
import com.shreya.practice.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Optional;

@Repository("StudentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();

        return student;
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student");
        return query.list();
    }

    @Override
    public Optional<Student> findById(int id) {

        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Student where id =" + id);
        Student student = (Student) query.uniqueResult();
        return Optional.ofNullable(student);
    }

    @Override
    public Student deleteById(int id) {

        Session session = sessionFactory.openSession();

        session.beginTransaction();
        Student tobeDeletedstudent = (Student) session.load(Student.class,id);
        session.delete(tobeDeletedstudent);
        session.getTransaction().commit();
        session.flush();
        session.close();

        return tobeDeletedstudent;
    }

}
