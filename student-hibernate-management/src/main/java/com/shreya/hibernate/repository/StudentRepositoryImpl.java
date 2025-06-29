package com.shreya.hibernate.repository;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Clazz;
import com.shreya.hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("studentRepository")
public class StudentRepositoryImpl implements StudentRepository {

    private final SessionFactory sessionFactory;

    public StudentRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
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
        Query<Student> query = session.createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();
        session.close();
        return students;
    }


    @Override
    public Optional<Student> findById(int id) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return Optional.ofNullable(student);
    }

    @Override
    public Student deleteById(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public Student updateStudent(int id) {
        return null;
    }

    @Override
    public Student updateStudent(int id, Student updatedStudent) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Student existingStudent = session.get(Student.class, id);
        if (existingStudent != null) {

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setPercentage(updatedStudent.getPercentage());

            session.update(existingStudent);
        }

        session.getTransaction().commit();
        session.close();

        return existingStudent;
    }

    @Override
    public List<Student> findStudentWithPagination(int page, int size) {
        if (page < 1) {
            throw new IllegalArgumentException("Page number must be >= 1");
        }

        Session session = sessionFactory.openSession();
        List<Student> students = session.createQuery("from Student", Student.class)
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list();
        session.close();
        return students;
    }

}
