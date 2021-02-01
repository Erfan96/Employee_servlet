package servlet;

import service.DetailDao;
import util.JpaUtil;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class DetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String empId = req.getParameter("value");
        EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
        DetailDao detailDao = new DetailDao(entityManager);
        List<Tuple> list = detailDao.getDetailOfEmployee(empId);
        req.setAttribute("list", list);

        HttpSession session = req.getSession();
        session.setAttribute("empId", empId);

        req.getRequestDispatcher("detail.jsp").forward(req, resp);
    }
}
