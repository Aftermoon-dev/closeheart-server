package kr.ac.gachon.sw.closeheart.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB�� ������ �� �ִ� �⺻���� �Լ����� ��� �ִ� Class
 * @author Minjae Seon
 * @date 2020.11.08
 */
public class DBManager {
	/*
	 * DB Connection�� ������ �Լ�
	 * @author Minjae Seon
	 * @return Connection
	 * @throw ClassNotFoundException
	 * @throw SQLException
	 */
	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DBInfo.jdbcDriver);
		return DriverManager.getConnection(DBInfo.url, DBInfo.id, DBInfo.password);
	}
	
	/* DB�� Query�� �����ϴ� �Լ� (���� ���� ����)
	 * @author Minjae Seon
	 * @return Boolean
	 * @throw SQLException
	 */
	public static boolean sendQuery(Connection connection, String query) throws SQLException {
		Statement sm = connection.createStatement();
		return sm.execute(query);
	}
	
	/*
	 * DB�� Query�� �����ϴ� �Լ� (����� ����)
	 * @author Minjae Seon
	 * @return ResultSet 
	 * @throw SQLException
	 */
	public static ResultSet sendQuery_result(Connection connection, String query) throws SQLException {
		Statement sm = connection.createStatement();
		return sm.executeQuery(query);
	}
}
