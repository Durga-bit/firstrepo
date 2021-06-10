package com.Tuc.Jdbc;

import java.io.*;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.*;
import java.util.TreeMap;

public class Ticket {
	static int inc=100;
	static String PNR;
	static ResultSet rs;
	static String generatePNR(int trainNo,LocalDate d) 
	{
		try 
		{
			Connection con=DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select *from Trains where trainNo=?");
			ps.setInt(1,trainNo);
			rs=ps.executeQuery();
			rs.next();
			String sc=rs.getString(3).substring(0,1);
			String dc=rs.getString(4).substring(0,1);
			PNR=sc+dc+"_"+d.getYear();
			PNR=PNR+d.getMonth();
			PNR=PNR+d.getDayOfMonth();
			inc++;
			PNR=PNR+"_"+inc;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return PNR;
	}
	static int price=0;
	static TreeMap<Passenger,Integer> map=new TreeMap<Passenger,Integer>();
	static void calcPassengerFare(ArrayList<Passenger> plist,int passengers) 
	{
		int a=0;
		try {
			for(a=0;a<passengers;a++) 
			{
				if(plist.get(a).age<=12) 
				{
					price=price+rs.getInt(5)/2;
					map.put(plist.get(a),rs.getInt(5)/2);
					plist.get(a).fare=rs.getInt(5)/2;
				}
				else
					if(plist.get(a).age>=60) 
					{
						price=price+(rs.getInt(5)*6)/10;
						map.put(plist.get(a),(rs.getInt(5)*6)/10);
						plist.get(a).fare=(rs.getInt(5)*6)/10;
					}
					else
						if(plist.get(a).Gender.equals("F")) 
						{
							price=price+rs.getInt(5)/4;
							map.put(plist.get(a),rs.getInt(5)/4);
							plist.get(a).fare=rs.getInt(5)/4;
						}
						else 
						{
							price=price+rs.getInt(5);
							plist.get(a).fare=rs.getInt(5);
						}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	static void writeTicket(LocalDate d,ArrayList<Passenger> plist) 
	{
	    try{
	    	
	    FileOutputStream fos=new FileOutputStream(new File("ticket.txt"));
	    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
	    bw.write("PNR    :"+PNR);
	    bw.newLine();
	    bw.write("trainNo    :"+rs.getInt(1));
	    bw.newLine();
	    bw.write("trainName   :"+rs.getString(2));
	    bw.newLine();
	    bw.write("From   :"+rs.getString(3));
	    bw.newLine();
	    bw.write("To   :"+rs.getString(4));
	    bw.newLine();
	    bw.write("Travel Date   :"+d.getDayOfMonth()+"/"+d.getMonth()+"/"+d.getYear());
	    bw.newLine();
	    bw.newLine();
	    bw.write("Passengers :");
	    Collections.sort(plist,new Comparator<Passenger>()
	    {
	    	public int compare(Passenger p,Passenger q)
	    	{
	    		return (p.name).compareTo(q.name);
	    	}
	    });
	    int a=0;
	    	bw.write("Name   "+"Age   "+"Gender   "+"Fare");
	    	for(a=0;a<plist.size();a++)
	    	{
	    	bw.newLine();
	    	bw.write(plist.get(a).name+"   "+plist.get(a).age+"   "+plist.get(a).Gender+"   "+plist.get(a).fare);
	    }
	    	bw.newLine();
	    	bw.write(price);
	    	bw.flush();
	    	bw.close();
	        System.out.println("ticket written");
	    }
	    catch(Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}
	
}
