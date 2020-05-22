package util;

import java.sql.*;
import com.mysql.jdbc.Driver;

public class JDBCConnect {
	
	//获取默认数据库连接
	public static Connection getConnection() throws SQLException {
		return getConnection("ManageTrain", "root", "123456"); //数据库名 默认用户 密码
	}
	
	//连接数据库   参数:数据库名 root登录名 密码
	public static Connection getConnection(String dbName, String userName,
			String password) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/" + dbName 
				+ "?useUnicode=true&characterEncoding=utf-8";
		
		//连接MySQL"com.mysql.jdbc.Driver"
		DriverManager.registerDriver(new Driver());
		return DriverManager.getConnection(url, userName, password);
	}

	//设置 PreparedStatement 参数 
	public static void setParams(PreparedStatement preStmt, Object... params)
			throws SQLException {

		if (params == null || params.length == 0)
			return;

		for (int i = 1; i <= params.length; i++) {
			Object param = params[i - 1];
			if (param == null) {
				preStmt.setNull(i, Types.NULL);
			} else if (param instanceof Integer) {
				preStmt.setInt(i, (Integer) param);
			} else if (param instanceof String) {
				preStmt.setString(i, (String) param);
			} else if (param instanceof Double) {
				preStmt.setDouble(i, (Double) param);
			} else if (param instanceof Long) {
				preStmt.setDouble(i, (Long) param);
			} else if (param instanceof Timestamp) {
				preStmt.setTimestamp(i, (Timestamp) param);
			} else if (param instanceof Boolean) {
				preStmt.setBoolean(i, (Boolean) param);
			} else if (param instanceof Date) {
				preStmt.setDate(i, (Date) param);
			}
		}
	}

	//执行 SQL，返回影响的行数 异常处理
	public static int executeUpdate(String sql) throws SQLException {
		return executeUpdate(sql, new Object[] {});
	}

	//带参数执行SQL，返回影响的行数 异常处理
	public static int executeUpdate(String sql, Object... params)
			throws SQLException {

		Connection conn = null;
		PreparedStatement preStmt = null;

		try {
			conn = getConnection();
			preStmt = conn.prepareStatement(sql);
			setParams(preStmt, params);
			return preStmt.executeUpdate(); //执行SQL操作
		} finally {
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}

}
