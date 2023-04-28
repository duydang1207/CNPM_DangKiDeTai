package Controller.SinhVien;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.IMajorsDao;
import Dao.ISignUpDao;
import Dao.IStudentsDao;
import Dao.ITeachersDao;
import Dao.ITopicDao;
import Dao.ITopicDetailsDao;
import Dao.Impl.MajorsDaoImpl;
import Dao.Impl.SignUpDaoImpl;
import Dao.Impl.StudentsDaoImpl;
import Dao.Impl.TeachersDaoImpl;
import Dao.Impl.TopicDaoImpl;
import Dao.Impl.TopicDetailsDaoImpl;
import Models.SignUpModel;
import Models.StudentsModel;
import Models.TeachersModel;
import Models.TopicDetailsModel;
import Models.TopicModel;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/student/topicdetail-register" })
public class TopicDetailController extends HttpServlet {

	IMajorsDao majorsDao = new MajorsDaoImpl();
	ITopicDao topicDao = new TopicDaoImpl();
	ITopicDetailsDao topicDetailsDao = new TopicDetailsDaoImpl();
	IStudentsDao studentsDao = new StudentsDaoImpl();
	ITeachersDao teachersDao = new TeachersDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			ISignUpDao signUp = new SignUpDaoImpl();
			List<SignUpModel> signs = signUp.getAll();
			req.setAttribute("signs", signs);

			// lấy topicId
			String topicId = req.getParameter("id");
			// tìm dề tài
			TopicModel topic = new TopicModel();
			topic = topicDao.findById(Integer.parseInt(topicId));
			req.setAttribute("topic", topic);

			// tìm topicdetail theo topicId và leader
			List<TopicDetailsModel> topicdetails = new ArrayList<TopicDetailsModel>();
			topicdetails = topicDetailsDao.findTopicDetailByTopicId(Integer.parseInt(topicId));
			if (!topicdetails.isEmpty()) {
				if (topicdetails.get(0).getScores() < 0)
					req.setAttribute("topicdetail", topicdetails.get(0));
			}
			List<StudentsModel> students = new ArrayList<StudentsModel>();

			for (TopicDetailsModel topicDetail : topicdetails) {
				// lấy leader thành viên
				StudentsModel sd = new StudentsModel();
				sd = studentsDao.findById(topicDetail.getStudentId());
				students.add(sd);
			}

			int sl = students.size();
			req.setAttribute("sl", sl);

			req.setAttribute("students", students);

			String majorName = topicDetailsDao.findMajorNameByTopicDetail(Integer.parseInt(topicId));
			req.setAttribute("majorName", majorName);

			// lấy leader thành viên
			StudentsModel leader = new StudentsModel();
			for (TopicDetailsModel tp : topicdetails) {
				if (tp.getLeader()) {
					leader = studentsDao.findById(tp.getStudentId());
					req.setAttribute("leader", leader);

				}
//			List<StudentsModel> students = new ArrayList<StudentsModel>();
//
//			for (TopicDetailsModel topicDetail : topicdetails) {
//				// lấy leader thành viên
//				StudentsModel sd = new StudentsModel();
//				sd = studentsDao.findById(topicDetail.getStudentId());
//				students.add(sd);
//			}
//
//			int sl = students.size();
//			req.setAttribute("sl", sl);
//
//			req.setAttribute("students", students);
//
//			String majorName = topicDetailsDao.findMajorNameByTopicDetail(Integer.parseInt(topicId));
//			req.setAttribute("majorName", majorName);
//
//			// lấy leader thành viên
//			StudentsModel leader = new StudentsModel();
//			for (TopicDetailsModel tp : topicdetails) {
//				if (tp.getLeader()) {
//					leader = studentsDao.findById(tp.getStudentId());
//					req.setAttribute("leader", leader);
//				}
//			}

				// lấy thành viên

				// lấy giảng viên hd
				TeachersModel teacherIn = new TeachersModel();
				teacherIn = teachersDao.findById(topic.getTeacherId());
				req.setAttribute("teacherIn", teacherIn);

				// lay gv phan bien
				List<TeachersModel> teacherPbs = new ArrayList<TeachersModel>();
				teacherPbs = teachersDao.getAllTeacherByTopicId(Integer.parseInt(topicId));
				req.setAttribute("teacherPbs", teacherPbs);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/sinhvien/topic-detail.jsp");
		dispatcher.forward(req, resp);
	}
}
