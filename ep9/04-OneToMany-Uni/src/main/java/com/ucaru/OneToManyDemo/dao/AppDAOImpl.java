package com.ucaru.OneToManyDemo.dao;

import ch.qos.logback.core.CoreConstants;
import com.ucaru.OneToManyDemo.entity.Course;
import com.ucaru.OneToManyDemo.entity.Instructor;
import com.ucaru.OneToManyDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id)
    {
        Instructor instructor = entityManager.find(Instructor.class, id);
         for(Course course : instructor.getCourses())
        {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInsDetailById(int id) {
        InstructorDetail detail = findInstructorDetailById(id);

        //break bi-directional link
        detail.getInstructor().setInstructorDetail(null);

        entityManager.remove(detail);
    }

    @Override
    public List<Course> findCoursesByInsId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);
        return query.getResultList();
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public Instructor findInstructorByIDJoinFetch(int id) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "from Instructor i "
                + "JOIN FETCH i.courses "
                + "JOIN FETCH i.instructorDetail "
                + "where i.id = :data", Instructor.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByID(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c from Course c JOIN FETCH c.reviews WHERE c.id = :data",
                Course.class);

        query.setParameter("data",id);

        return query.getSingleResult();
    }

}
