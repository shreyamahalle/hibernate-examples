package com.shreya.hibernate.repository;
import com.shreya.hibernate.model.Clazz;

import java.util.Optional;
import java.util.Set;

public interface ClazzRepository {
    Clazz save(Clazz clazz);
    Set<Clazz> findAll();
    Optional<Clazz> findById(int id);
    Clazz deleteById(int id);
    Set<Clazz> findClazzWithPagination(int page, int size);
}