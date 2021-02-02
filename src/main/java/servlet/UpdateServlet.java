package servlet;

import service.AddressDao;
import service.DetailDao;
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


public class UpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        EmployeeDao employeeDao = new EmployeeDao(entityManager);
        DetailDao detailDao = new DetailDao(entityManager);
        AddressDao addressDao = new AddressDao(entityManager);
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String email = req.getParameter("email");
        String faName = req.getParameter("faName");
        String naCode = req.getParameter("naCode");
        String cerNum = req.getParameter("cerNum");
        String state = req.getParameter("state");
        String street = req.getParameter("street");
        String postCode = req.getParameter("postCode");
        String phoneNum = req.getParameter("phoneNum");

        HttpSession session = req.getSession();
        String id = (String) session.getAttribute("empId");

        employeeDao.updateEmployee(id, fName, lName, email);
        detailDao.updateDetail(id, faName, naCode, cerNum);
        addressDao.updateAddress(id, state, street, postCode, phoneNum);
        try(PrintWriter out = resp.getWriter()) {
            out.println("Updated successfully.");
            req.getRequestDispatcher("index.jsp").include(req, resp);
        }
    }
}
