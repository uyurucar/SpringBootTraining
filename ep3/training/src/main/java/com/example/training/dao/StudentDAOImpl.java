package com.example.training.dao;

import com.example.training.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{

    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public int newLastName(String oldName, String newName) {
        int rumsAffected = entityManager.createQuery("UPDATE Student SET lastName = :newName WHERE lastName = :oldName")
                        .setParameter("oldName", oldName)
                        .setParameter("newName", newName)
                        .executeUpdate();
        return rumsAffected;
    }

    @Override
    public List<Student> getAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName = :data", Student.class);
        query.setParameter("data",lastName);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void deleteById(int id) {
        //get student
        Student student = findById(id);

        //delete
        entityManager.remove(student);
    }
}
