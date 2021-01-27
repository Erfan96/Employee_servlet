package service;

import entities.Employee;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeDao extends EntityDao<Employee, Integer>{

    public EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }

    public void addEmployee(String fName, String lName, String email) {
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setEmail(email);
        save(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        JpaUtil.Shutdown();
    }

    public List<Employee> getEmployees() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> fromEmployee = criteria.from(Employee.class);

        criteria.select(fromEmployee);
        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }
}
