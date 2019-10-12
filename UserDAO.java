package three_layers;

import java.sql.ResultSet;

public class UserDAO {
	//���ݿ���ʲ㣨DAO�����ڴ�ҵ���߼�����յ��Ĳ���������ѯ������
    //����ִ�е�dbconnection�ࡣ�򵥵ش�dbconnection�෵�ص�ҵ���߼��㡣
	private dbConnection conn;
	
	public UserDAO() {
		conn = new dbConnection();
	}
	
	public ResultSet searchByName(String username) {
		String query = String.format("select * from [t01_user] "
				+ "where t01_firstname like @t01_firstname or t01_lastname"
				+"like @t01_lastname ");
		String[] sqlParameters = new String[2];
		sqlParameters[0] = username;
		sqlParameters[1] = username;
		return conn.executeSelectQuery(query, sqlParameters);
	}
	
	public ResultSet searchById(String id) {
		String query = "select * from [t01_id] where t01_id = @t01_id";
		String[] sqlParameters = new String[1];
		sqlParameters[0] = id;
		return conn.executeSelectQuery(query, sqlParameters);
	}
	
}
