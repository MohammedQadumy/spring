package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO{


    // define field for entityManager
    private EntityManager entityManager;


    @Autowired
    public EmployeeDAOJpaImp(EntityManager theEntityMnager){
        entityManager = theEntityMnager;
    }
    // setup constructor injection

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee" , Employee.class);

        // excute query and get result list

        List<Employee> employees = theQuery.getResultList();

        return  employees;
        // return results
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee  dbEmployee = entityManager.merge(theEmployee);// if id is 0 then its save , otherwise its update

        return dbEmployee; // we returned this employee because it has updated id from the database (in case of insert)

    }

    @Override
    public void delete(int theId) {
        Employee targetEmployee = entityManager.find(Employee.class, theId);

        entityManager.remove(targetEmployee);

    }
}
