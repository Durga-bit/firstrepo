package com.Tuc.Jdbc;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TicketApplication {
	public static void main(String[] args)
	{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter The Train Number");
			Train train=new Train();
			int trainNo=sc.nextInt();
			try {
			if(TrainDao.findTrain(trainNo))
			{
                    
					System.out.println("Enter travel Date");
					String tdate=sc.next();
					String[] traveldate=tdate.split("/");
					LocalDate date=LocalDate.of(Integer.parseInt(traveldate[2]),Integer.parseInt(traveldate[1]),Integer.parseInt(traveldate[0]));
					System.out.println(traveldate.length);
					LocalDate today=LocalDate.now();
					if(today.isBefore(date))
					{
						Ticket.generatePNR(trainNo,date);
						System.out.println("Enter no of Passengers");
						int passengers=sc.nextInt();
						int a=0;
						ArrayList<Passenger> passengerlist=new ArrayList<Passenger>(); 
						for(a=0;a<passengers;a++){
							System.out.println("Enter name");
							String name=sc.next()
									;
							System.out.print("Enter age");
							int age=sc.nextInt();
							System.out.print("Enter Gender");
							String gender=sc.next();
							passengerlist.add(new Passenger(age,name,gender));
							
						}
						Ticket.calcPassengerFare(passengerlist,passengers);
						Ticket.writeTicket(date,passengerlist);
					}
					else
					{
					      System.out.println("TravelDate is before CurrentDate");
					}
				}
			else
			{
				System.out.println("Train with given number does not exist");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	}
}
			
			
	



