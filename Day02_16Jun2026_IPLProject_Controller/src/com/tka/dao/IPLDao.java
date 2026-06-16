package com.tka.dao;

import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDao {

	private List<Player> db_info = null;
	
	public List<Player> getAllPlayer(){
		db_info = new ArrayList<Player>(List.of(
			    new Player("Virat Kohli", 18, "RCB", 8000, 4),
			    new Player("Faf du Plessis", 13, "RCB", 4500, 0),
			    new Player("Rajat Patidar", 28, "RCB", 1200, 0),
			    new Player("Glenn Maxwell", 32, "RCB", 2800, 31),
			    new Player("Cameron Green", 42, "RCB", 600, 12),
			    new Player("Dinesh Karthik", 21, "RCB", 4800, 0),
			    new Player("Mahipal Lomror", 9, "RCB", 500, 1),
			    new Player("Mohammed Siraj", 73, "RCB", 100, 95),
			    new Player("Yash Dayal", 57, "RCB", 15, 25),
			    new Player("Reece Topley", 10, "RCB", 20, 18),
			    new Player("Karn Sharma", 11, "RCB", 150, 70),
			    new Player("Shubman Gill", 7, "GT", 3200, 0),
			    new Player("Sai Sudharsan", 23, "GT", 1000, 0),
			    new Player("David Miller", 33, "GT", 2900, 0),
			    new Player("Azmatullah Omarzai", 56, "GT", 250, 10),
			    new Player("Rahul Tewatia", 20, "GT", 900, 32),
			    new Player("Shahrukh Khan", 99, "GT", 400, 2),
			    new Player("Rashid Khan", 19, "GT", 500, 150),
			    new Player("R Sai Kishore", 46, "GT", 50, 15),
			    new Player("Umesh Yadav", 14, "GT", 180, 140),
			    new Player("Spencer Johnson", 45, "GT", 10, 12),
			    new Player("Mohit Sharma", 18, "GT", 80, 130),
			    new Player("Yashasvi Jaiswal", 64, "RR", 1400, 0),
			    new Player("Jos Buttler", 63, "RR", 3600, 0),
			    new Player("Sanju Samson", 11, "RR", 4200, 0),
			    new Player("Riyan Parag", 27, "RR", 1100, 6),
			    new Player("Shimron Hetmyer", 18, "RR", 1200, 0),
			    new Player("Dhruv Jurel", 21, "RR", 350, 0),
			    new Player("Ravichandran Ashwin", 99, "RR", 800, 175),
			    new Player("Trent Boult", 18, "RR", 50, 110),
			    new Player("Avesh Khan", 8, "RR", 40, 65),
			    new Player("Sandeep Sharma", 34, "RR", 30, 125),
			    new Player("Yuzvendra Chahal", 3, "RR", 50, 205),
			    new Player("Travis Head", 62, "SRH", 900, 1),
			    new Player("Abhishek Sharma", 4, "SRH", 1100, 9),
			    new Player("Aiden Markram", 94, "SRH", 1000, 5),
			    new Player("Heinrich Klaasen", 45, "SRH", 1200, 0),
			    new Player("Nitish Kumar Reddy", 67, "SRH", 300, 5),
			    new Player("Abdul Samad", 1, "SRH", 600, 1),
			    new Player("Shahbaz Ahmed", 26, "SRH", 450, 18),
			    new Player("Pat Cummins", 30, "SRH", 400, 60),
			    new Player("Bhuvneshwar Kumar", 15, "SRH", 300, 180),
			    new Player("Jaydev Unadkat", 73, "SRH", 120, 95),
			    new Player("T Natarajan", 44, "SRH", 20, 65)
			));		
		return db_info;
	}
	
}