package kr.ac.gachon.sw.closeheart.server.db;
import java.sql.*;
public class DBConnect {

	public static void main(String[] args) {
		try {
			// DB connection
			Connection con = DBManager.getDBConnection();
			
			// select ����
			// ���̺� �ҷ�����
			String query = "select * from userAccount";
			// ���� execute, ��ü ����
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			// ResultSet rs = DBManager.sendQuery_result(con, query);
			
			while(rs.next()) {
				String name = rs.getString("user_name");
				String id = rs.getString("user_id");
				String pw = rs.getString("user_pw");
				String email = rs.getString("user_email");
				System.out.format("%s, %s, %s, %s\n",name,id,pw,email);
			}
			st.close();
			
		}catch(Exception e) {
			System.out.println("Exception!");
			System.out.println(e.getMessage());
		}
		
	}

}