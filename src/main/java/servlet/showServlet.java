package servlet;

import entities.Employee;
import service.EmployeeDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class showServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        List<Employee> list = employeeDao.getEmployees();
        req.setAttribute("list", list);
        req.getRequestDispatcher("show.jsp").forward(req, resp);
    }
}
