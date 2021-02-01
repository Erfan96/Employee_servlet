package service;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class AddressDao extends EntityDao<Address, Integer> {

    public AddressDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }

    public Address getAddressWithEmployeeId(String empId) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Address> criteria = cb.createQuery(Address.class);
            Root<Employee> fromEmployee = criteria.from(Employee.class);

            Join<Employee, Address> join = fromEmployee.join("address");
            criteria.select(join).where(cb.equal(fromEmployee.get("employeeId"), empId));
            return entityManager.createQuery(criteria).getSingleResult();
        }catch (Exception e) {
            return new Address();
        }
    }

    public void updateAddress(Address address) {
        entityManager.getTransaction().begin();
        update(address);
        entityManager.getTransaction().commit();
    }
}
