package servlet;

import service.EmployeeDao;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DeleteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("empId");

        try(PrintWriter out = resp.getWriter()) {
            employeeDao.deleteEmployeeDetailAndAddress(id);
            out.println("Deleted successfully.");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }
    }
}
