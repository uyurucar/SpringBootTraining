package com.ucaru.cruddemo.dao;

import com.ucaru.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager manager)
    {
        this.entityManager = manager;
        System.out.println("i am studentdaoimpl");
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create query
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName= :theData",Student.class);
        //set parameter
        query.setParameter("theData",lastName);
        //return result
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void updateId(Integer oldID, Integer newID) {
        var query = entityManager.createQuery("UPDATE Student u SET u.id = :newID WHERE u.id = :oldID");
        query.setParameter("newID", newID);
        query.setParameter("oldID",oldID);
        query.executeUpdate();
        System.out.println("done");
    }


    @Override
    @Transactional
    public void delete(Integer id) {
        //get the student
        Student student = findById(id);
        //delete student
        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
