package com.txz.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 连接到C3p0工具类 使用xml不需要在设置读取参数的配置
 * 
 * @author txz
 *
 */
public class JDBCUtil {
	static DataSource datasource = null;
	static {
		datasource = new ComboPooledDataSource();
	}

	/**
	 * 获取连接对象
	 * 
	 * @return
	 */
	public static DataSource getDataSource() {

		return datasource;
	}

	/**
	 * 释放资源
	 * 
	 * @param conn
	 * @param rs
	 * @param st
	 */
	public static void release(Connection conn, ResultSet rs, Statement st) {
		closeRs(rs);
		closeSt(st);
		closeConn(conn);
	}

	public static void release(Connection conn, Statement st) {
		closeSt(st);
		closeConn(conn);
	}

	public static void release(Connection conn) {
		closeConn(conn);
	}

	private static void closeRs(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
	}

	private static void closeSt(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				st = null;
			}
		}
	}

	private static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
