package servlet;

import service.EmployeeDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class saveServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String email = req.getParameter("email");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        employeeDao.addEmployee(fName, lName, email);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
