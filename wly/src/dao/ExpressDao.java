package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Express;
import util.DBUtil;

public class ExpressDao {

	/**
	 * 根据快递编号查询快递信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Express> searchByCode(String text) {
		Connection conn = DBUtil.getConn();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Express> list = new ArrayList<Express>();
		String sql = "select * from express where code like '%" + text + "%'";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String code = resultSet.getString("code");
				String sender = resultSet.getString("sender");
				String senderPhone = resultSet.getString("sender_phone");
				String senderAddr = resultSet.getString("sender_addr");
				String receiver = resultSet.getString("receiver");
				String receiverPhone = resultSet.getString("receiver_phone");
				String receiverAddr = resultSet.getString("receiver_addr");
				String state = resultSet.getString("state");
				list.add(new Express(id, code, sender, senderPhone, senderAddr, receiver, receiverPhone, receiverAddr,
						state));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, statement, resultSet);
		}
		return list;
	}

	/**
	 * 签收
	 * 
	 * @param id
	 * @return
	 */
	public int update(int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement statement = null;
		String sql = "update express set state='已签收' where id=?";
		try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, statement);
		}
		return 0;
	}

	/**
	 * 取得快递集合
	 * 
	 * @return
	 */
	public List<Express> getList() {
		Connection conn = DBUtil.getConn();
		Statement statement = null;
		ResultSet resultSet = null;
		List<Express> list = new ArrayList<Express>();
		String sql = "select * from express";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String code = resultSet.getString("code");
				String sender = resultSet.getString("sender");
				String senderPhone = resultSet.getString("sender_phone");
				String senderAddr = resultSet.getString("sender_addr");
				String receiver = resultSet.getString("receiver");
				String receiverPhone = resultSet.getString("receiver_phone");
				String receiverAddr = resultSet.getString("receiver_addr");
				String state = resultSet.getString("state");
				list.add(new Express(id, code, sender, senderPhone, senderAddr, receiver, receiverPhone, receiverAddr,
						state));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, statement, resultSet);
		}
		return list;
	}

}
