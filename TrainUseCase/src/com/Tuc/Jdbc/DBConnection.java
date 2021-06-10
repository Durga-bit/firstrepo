package com.Tuc.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection implements JDBCProperties{
public static Connection getConnection() throws ClassNotFoundException, SQLException
{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(URL,USERNAME,PASSWORD);
	return con;
}
}
