package com.Tuc.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrainDao {
	public static boolean findTrain(int trainNo) throws ClassNotFoundException, SQLException{
		Connection con=DBConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("select *from Trains where trainNo=?");
		ps.setInt(1,trainNo);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
}
