package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import bean.TrainManage;
import util.JDBCConnect;

public class TrainManageDAO {
	
	//插入车次
	public static int insert(TrainManage train) throws Exception {

		String sql = "INSERT INTO TrainManage (trainid,start,end,time,yzprice,rzprice,ywprice,rwprice,root) " +
				"VALUES ('" + train.getTrainid() +"','"+ train.getStart() +"','"+ train.getEnd() +
				"','"+ train.getTime() +"','"+ train.getYzprice() +"','"+ train.getRzprice() +
				"','"+ train.getYwprice() +"','"+ train.getRwprice() +"','"+ train.getRoot()  +"');";
		System.out.println(sql);
		return JDBCConnect.executeUpdate(sql);
		
		/**
		 * 总是报错  No value specified for parameter 5
		 * 很多原因是 insert into train (?,?,?) values (?,?,?) 前面不应该是问号 
		 * 但我的怀疑是参数过多使用executeUpdate(sql,?,?,?...)方法是错误
		 * 
		 * String sql = "INSERT INTO TrainManage (trainid,start,end,time,yzprice,rzprice,ywprice,rwprice,root) VALUES (?,?,?,?,?,?,?,?,?);";
		 * System.out.println(sql);
		 * return JDBCConnect.executeUpdate(sql, train.getTrainid(), train.getStart(), train.getEnd(),
		 *		train.getTime(), train.getYzprice(), train.getRzprice(), train.getYwprice(), 
		 *		train.getRwprice(), train.getRoot());
		 */
	}
	
	
	//更新车次
	public static int update(TrainManage train) throws Exception {

		/**
		 * String sql = "UPDATE TrainManage SET start = ?, end = ? WHERE trainid = ? ";
		 * return JDBCConnect.executeUpdate(sql, train.getStart(), train.getEnd(), train.getTrainid());
		 */
		/*
		String sql = "UPDATE TrainManage SET start = '"+ train.getStart() +
				"', end = '" + train.getEnd() + "' WHERE trainid = '" +
				train.getTrainid() +"';";
		System.out.println(sql);
		return JDBCConnect.executeUpdate(sql);
		*/
		String sql = "UPDATE TrainManage SET start = ?, end = ? WHERE trainid = ? ";
		return JDBCConnect.executeUpdate(sql, train.getStart(), train.getEnd(), train.getTrainid());
	}


	//删除操作
	public static int delete(String id) throws Exception {

		String sql = "DELETE FROM TrainManage WHERE trainid = ? ";
		return JDBCConnect.executeUpdate(sql, id);
	}
	
	//查找记录 某车次
	public static TrainManage find(String id) throws Exception {
		
		String sql = "SELECT * FROM TrainManage WHERE trainid = ? ";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			//链接数据库执行SQL语句
			conn = JDBCConnect.getConnection(); //连接默认数据库
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, id);
			rs = preStmt.executeQuery();
			//获取查询结果
			if (rs.next()) {
				TrainManage train = new TrainManage();
				train.setTrainid(rs.getString("trainid"));
				train.setStart(rs.getString("start"));
				train.setEnd(rs.getString("end"));
				train.setTime(rs.getString("time"));
				train.setYzprice(rs.getFloat("yzprice"));
				train.setYwprice(rs.getFloat("ywprice"));
				train.setRzprice(rs.getFloat("rzprice"));
				train.setRwprice(rs.getFloat("rwprice"));
				train.setRoot(rs.getString("root"));
				return train;
			} else {
				return null;
			}

		} finally { //依次关闭 记录集 声明 连接对象
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
	}
	
	//查找记录 某车次
	public static List<TrainManage> findStartEnd(String start,String end) throws Exception {
		List<TrainManage> list = new ArrayList<TrainManage>();
		String sql = null; 
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		//判断SQL语句
		if(start==""&&end=="") {
			sql = "SELECT * FROM TrainManage;";
		} else if(end=="") {
			sql = "SELECT * FROM TrainManage WHERE start = '"+ start + "';";
		} else if(start=="") {
			sql = "SELECT * FROM TrainManage WHERE end = '"+ end + "';";
		} else {
			sql = "SELECT * FROM TrainManage WHERE start = '" 
					+ start + "' and end = '"+ end +"';"; 
		}
		//执行
		try {
			//链接数据库执行SQL语句
			conn = JDBCConnect.getConnection(); //连接默认数据库
			statement = conn.createStatement();
			System.out.println(start+" "+end);
			System.out.println(sql);
			rs = statement.executeQuery(sql);
			
			//获取查询结果
			while(rs.next()) {
				TrainManage train = new TrainManage();
				train.setTrainid(rs.getString("trainid"));
				train.setStart(rs.getString("start"));
				train.setEnd(rs.getString("end"));
				train.setTime(rs.getString("time"));
				train.setYzprice(rs.getFloat("yzprice"));
				train.setYwprice(rs.getFloat("ywprice"));
				train.setRzprice(rs.getFloat("rzprice"));
				train.setRwprice(rs.getFloat("rwprice"));
				train.setRoot(rs.getString("root"));
				list.add(train);
			}

		} catch (Exception e) {
			System.out.println("错误："+e.getMessage());  
		}
		finally { //依次关闭 记录集 声明 连接对象
			if (rs != null)
				rs.close();
			if (statement != null)
				statement.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}
	
	//查询所有车次信息
	public static List<TrainManage> listStudents() throws Exception {

		List<TrainManage> list = new ArrayList<TrainManage>();
		String sql = "SELECT * FROM TrainManage";
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = JDBCConnect.getConnection();
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				//设置数据库中表参数 否则报错java.sql.SQLException: Column 'id' not found.
				TrainManage train = new TrainManage();
				train.setTrainid(rs.getString("trainid"));      
				train.setStart(rs.getString("start"));
				train.setEnd(rs.getString("end"));
				train.setTime(rs.getString("time"));
				train.setYzprice(rs.getFloat("yzprice"));
				train.setYwprice(rs.getFloat("ywprice"));
				train.setRzprice(rs.getFloat("rzprice"));
				train.setRwprice(rs.getFloat("rwprice"));
				train.setRoot(rs.getString("root"));
				list.add(train);
			}
			
		} finally {
			if (rs != null)
				rs.close();
			if (preStmt != null)
				preStmt.close();
			if (conn != null)
				conn.close();
		}
		return list;
	}
	
}
