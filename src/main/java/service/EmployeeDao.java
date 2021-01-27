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

    public void addEmployee(String fName, String lName, String email) {
        entityManager.getTransaction().begin();
        Employee employee = new Employee();
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setEmail(email);
        save(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
