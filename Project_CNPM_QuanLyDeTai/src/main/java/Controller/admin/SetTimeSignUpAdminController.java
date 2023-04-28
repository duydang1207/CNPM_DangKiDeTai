package Controller.admin;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ISignUpDao;
import Dao.Impl.SignUpDaoImpl;
import Models.SignUpModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/singUp/add"})
public class SetTimeSignUpAdminController extends HttpServlet{

	ISignUpDao signUpDao = new SignUpDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/Add-SignUp.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			req.setCharacterEncoding("UTF-8");
			
			SignUpModel signUpModel = signUpDao.getLast();
			
			Date start = (Date.valueOf(req.getParameter("start")));
			Date now = Date.valueOf(LocalDate.now());
			
			if(signUpModel==null)
			{		
				SignUpModel signUp = new SignUpModel();
				signUp.setStartTime(Date.valueOf(req.getParameter("start")));
				signUp.setEndTime(Date.valueOf(req.getParameter("end")));
				signUp.setRole(Boolean.parseBoolean(req.getParameter("role")));
				signUpDao.insert(signUp);
			}
			else if((start.compareTo(signUpModel.getEndTime())>0)) {
				
				SignUpModel signUp = new SignUpModel();
				signUp.setStartTime(Date.valueOf(req.getParameter("start")));
				signUp.setEndTime(Date.valueOf(req.getParameter("end")));
				signUp.setRole(Boolean.parseBoolean(req.getParameter("role")));
				signUpDao.insert(signUp);
			}else {
				System.out.println("Không nằm trong thời gian đăng ký");
			}
			
			
			
			
			resp.sendRedirect(req.getContextPath() + "/admin/singUp/add");
		} catch (Exception e) {
			resp.sendRedirect(req.getContextPath() + "/admin/singUp/add");
		}
	}
}
