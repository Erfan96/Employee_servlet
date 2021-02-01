package service;

import entities.Address;
import entities.Detail;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

public class DetailDao extends EntityDao<Detail, Integer>{

    public DetailDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Detail> getEntityClass() {
        return Detail.class;
    }

    public List<Tuple> getDetailOfEmployee(String empId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = cb.createTupleQuery();
        Root<Employee> fromEmployee = criteria.from(Employee.class);

        Join<Employee, Detail> empDetJoin = fromEmployee.join("detail", JoinType.LEFT);
        Join<Employee, Address> empAddJoin = fromEmployee.join("address", JoinType.LEFT);
        criteria.multiselect(fromEmployee.get("firstName"),
                fromEmployee.get("lastName"), fromEmployee.get("email"),
                fromEmployee.get("employeeId"), empDetJoin.get("fatherName"),
                empDetJoin.get("nationalCode"), empDetJoin.get("certificateId"),
                empAddJoin.get("state"), empAddJoin.get("street"),
                empAddJoin.get("postalCode"), empAddJoin.get("phoneNumber"))
                .where(cb.equal(fromEmployee.get("employeeId"), empId));

        return entityManager.createQuery(criteria).getResultList();
    }

    public Detail getDetailWithEmployeeId(String empId) {
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Detail> criteria = cb.createQuery(Detail.class);
            Root<Employee> fromEmployee = criteria.from(Employee.class);

            Join<Employee, Detail> join = fromEmployee.join("detail");
            criteria.select(join).where(cb.equal(fromEmployee.get("employeeId"), empId));
            return entityManager.createQuery(criteria).getSingleResult();
        }catch (Exception e) {
            return new Detail();
        }
    }

    public void updateDetail(Detail detail) {
        entityManager.getTransaction().begin();
        update(detail);
        entityManager.getTransaction().commit();
    }

}
