package com.vjia.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class SQLiteUtil {

	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:/F:/gitrepo/solr_javas/database/solr_javas.db");
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			conn.commit();
		} catch (SQLException sqle) {
			System.out.println("SQLException :" + sqle.getMessage());
			System.exit(-1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate("create table id_sequence(id number, name varchar(32))");
			System.out.println("建表table001成功!");
		}catch (SQLException sqle) {
			System.out.println(" !! ID TABLE ALREADY EXIST !! SKIP.");
			System.out.println("SQLException :" + sqle.getMessage());
		}
	}
	public static Integer getUniqueIncrementId() {
		// TODO Auto-generated method stub
		try {
			rs = stmt.executeQuery("select max(id) mid from id_sequence");
			int mid = rs.getInt("mid");
			mid += 1;
			//TODO later, change this log to : when insert an INDEXED row into DB, update id_sequence too.
			stmt.executeUpdate(String.format("insert into id_sequence values (%d, %s)", mid, "'"+mid + " at " + Calendar.getInstance().getTime()+"'"));
			conn.commit();
			return mid;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
