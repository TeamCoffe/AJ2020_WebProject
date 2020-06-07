package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.UserDataBean;

public class UserDataTableDAO {
	private UserDataTableDAO() { 
	}
	
	private static UserDataTableDAO instance = new UserDataTableDAO();
	public static UserDataTableDAO getInstance(){
		return instance;
	} 

	// insert
	public int insert(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into userdata_tb values (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pe.getId());
			pstmt.setString(2, pe.getPassword());
			pstmt.setInt(3, pe.getMoney());
			pstmt.setInt(4, pe.getScheduledMoney());
			pstmt.setInt(4, pe.getIsAdmin());
			return pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}

	// delete
	public int delete(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from userdata_tb where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			return pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	// edit
	public int edit(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update userdata_tb set user_password=? user_money=? user_scheduledMoney=? isAdmin=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pe.getPassword());
			pstmt.setInt(2, pe.getMoney());
			pstmt.setInt(3, pe.getScheduledMoney());
			pstmt.setInt(4, pe.getIsAdmin());
			pstmt.setString(5, pe.getId());
			return pstmt.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	// edit Password
	public int editPassword(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update userdata_tb set user_password=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pe.getPassword());
			pstmt.setString(2, pe.getId());
			return pstmt.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	
	// edit Money
	public int editMoney(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update userdata_tb set user_money=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pe.getMoney());
			pstmt.setString(2, pe.getId());
			return pstmt.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	public int applyMoney(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update userdata_tb set user_scheduledMoney=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pe.getScheduledMoney());
			pstmt.setString(2, pe.getId());
			return pstmt.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	// edit Author
	public int editIsAdmin(Connection conn, UserDataBean pe) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "update userdata_tb set isAdmin=? where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pe.getIsAdmin());
			pstmt.setString(2, pe.getId());
			return pstmt.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	// select(find/get)
	public UserDataBean select(Connection conn, String id) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from userdata_tb where user_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return createFromResultSet(rs);
			}
			else {
				return null;
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
	
	public UserDataBean createFromResultSet(ResultSet rs) throws SQLException {
		String id = rs.getString("user_id");
		String password = rs.getString("user_password");
		int money = rs.getInt("user_money");
		int schMoney=rs.getInt("user_scheduledMoney");
		int isAdmin = rs.getInt("user_isAdmin");
		
		UserDataBean pe = new UserDataBean(id, password, money,schMoney, isAdmin);
		return pe;
	}
	
	// selectList
	public List<UserDataBean> selectList(Connection conn) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from userdata_tb";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<UserDataBean> pList = new ArrayList<>();
			while (rs.next()) {
				pList.add(createFromResultSet(rs));
			}
			return pList;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
		}
	}
}
