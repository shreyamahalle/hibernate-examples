package com.shreya.hibernate.repository;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.domain.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("customerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    private final SessionFactory sessionFactory;

    public CustomerRepositoryImpl() throws HibernateException {
        this.sessionFactory = HibernateConfig.getSessionFactory();
    }

    @Override
    public Customer save(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
            return customer;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }

    @Override
    public List<Customer> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Customer> query = session.createQuery("from Customer", Customer.class);
            return query.list();
        }
    }

    @Override
    public Optional<Customer> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Customer customer = session.get(Customer.class, id);
            return Optional.ofNullable(customer);
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.delete(customer);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            throw e;
        }
    }
}
