package three_layers;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBUS {
	private UserDAO _userDAO;
	
	/// Constructor UserBUS
	public UserBUS()
	{
		_userDAO = new UserDAO();
	}
	
	///Get User Email By Firstname or Lastname and return VO
	public UserVO getUserEmailByName(String name) throws SQLException {
		UserVO userVO = new UserVO();
		ResultSet rs = null;
		rs = _userDAO.searchByName(name);
		while(rs.next()) {
			userVO.idUser = rs.getInt(1);
			userVO.firstname = rs.getString(2);
			userVO.lastname = rs.getString(3);
			userVO.email =rs.getString(4);
		}
		return userVO;
	}
	
	/// Get User Email By Id and return DataTable
	public UserVO getUserById(String id) throws SQLException{
		UserVO userVO = new UserVO();
		ResultSet rs = null;
		rs = _userDAO.searchByName(id);
		while(rs.next()) {
			userVO.idUser = rs.getInt(1);
			userVO.firstname = rs.getString(2);
			userVO.lastname = rs.getString(3);
			userVO.email =rs.getString(4);
		}
		return userVO;
	}
	
	
}
