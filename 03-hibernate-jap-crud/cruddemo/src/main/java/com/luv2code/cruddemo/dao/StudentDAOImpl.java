package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {


    //define field for entity manager

    private EntityManager entityManager;


    //inject entity manageer using constructor injection

    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    //implment the save method

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findyById(Integer id) {
         Student targetStudent = entityManager.find(Student.class, id);
         return targetStudent;
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName DESC" , Student.class);

        // return query results

        return theQuery.getResultList();

    }



    @Override
    public List<Student> findByLastName(String lastName){

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        theQuery.setParameter("theData",lastName);

        return theQuery.getResultList();

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id){
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }
}
