package service;

import entities.Address;
import entities.Detail;
import entities.Employee;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.UUID;

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
        employee.setEmployeeId(String.valueOf(UUID.randomUUID()));
        DetailDao detailDao = new DetailDao(entityManager);
        Detail detail = new Detail();
        detailDao.save(detail);

        AddressDao addressDao = new AddressDao(entityManager);
        Address address = new Address();
        addressDao.save(address);

        employee.setDetail(detail);
        employee.setAddress(address);

        save(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Employee> getEmployees() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> fromEmployee = criteria.from(Employee.class);

        criteria.select(fromEmployee);
        TypedQuery<Employee> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    public void updateEmployee(String id, String fName, String lName, String email) {
        entityManager.getTransaction().begin();
        Employee employee = getEmployeeWithEmployeeId(id);
        employee.setFirstName(fName);
        employee.setLastName(lName);
        employee.setEmail(email);
        update(employee);
    }

    public Employee getEmployeeWithEmployeeId(String empId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
        Root<Employee> fromEmployee = criteria.from(Employee.class);

        criteria.select(fromEmployee).where(cb.equal(fromEmployee.get("employeeId"), empId));
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
