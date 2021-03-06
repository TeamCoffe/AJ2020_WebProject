package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProjectDataTableDAO;
import dto.ProjectDataBean;
import jdbc.ConnectionProvider;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class AddProjectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("AddProjectAction execute");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String newWriter = request.getParameter("writer");
		String newTitle = request.getParameter("title");
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		Date deadline = Date.valueOf(request.getParameter("deadline"));
		int newGoal = Integer.parseInt(request.getParameter("goal"));
		String newContent = request.getParameter("content");
		String newImage = request.getParameter("imageURL");
		int cat = Integer.parseInt(request.getParameter("category"));
		ProjectDataBean pe = new ProjectDataBean(0, newWriter, newTitle, now, newContent, newImage, deadline, newGoal, 0, 0, cat, false, null);
	
		Connection conn = null;
		try{
			conn = ConnectionProvider.getConnection();
			ProjectDataTableDAO dao = ProjectDataTableDAO.getInstance(); // getInstance
			dao.insert(conn, pe); //insert
		} catch(SQLException e){
			e.printStackTrace();
		} finally{
			try{
				if(conn != null)
			conn.close();
			} catch(SQLException se){
				se.printStackTrace();
			}
		}
	}
}
