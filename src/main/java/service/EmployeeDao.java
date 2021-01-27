package service;

import entities.Employee;
import javax.persistence.EntityManager;

public class EmployeeDao extends EntityDao<Employee, Integer>{

    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
