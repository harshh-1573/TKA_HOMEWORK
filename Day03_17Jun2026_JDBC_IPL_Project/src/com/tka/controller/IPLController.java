package com.tka.controller;

import java.util.List;
import java.util.Scanner;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

	public static void main(String[] args) {
		IPLService service = new IPLService();
		System.out.println("Enter 1. Show All Player Name    2. Show Player By Team     3. Update Runs      4. Update Wickets    5. Add A Player   6. Delete A Player");
		try (Scanner sc = new Scanner(System.in)) {
			int choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
			case 1:
				service.getAllPlayer().forEach(n->System.out.println(n));
				break;
			case 2:
				System.out.println("Enter the name of Team (RCB,RR,GT,SRH)");
				List<String> validOptions= List.of("RCB","RR","GT","SRH");
				String userInput = sc.nextLine();
				if(validOptions.contains(userInput.toUpperCase())) {
					service.getByTeam(userInput.toUpperCase()).stream().forEach(n->System.out.println(n.getpName()+" | "+n.gettName()));
				}else {
					System.out.println("Invalid Team name");
				}
				break;
			case 3:
				System.out.println("Select the player id from following : ");
				service.getAllPlayer().forEach(n->System.out.println(n.getId()+" -> "+n.getpName()+" | Runs: "+n.getRun()+""));
				int id = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the new runs ");
				int runs = Integer.parseInt(sc.nextLine());
				int result = service.updateRuns(id,runs);
				if(result==1) {
					System.out.println("runs are updated successfully");
				}else {
					System.out.println("runs are not updated");
				}
				break;
			case 4: 
				System.out.println("Select the player id from following : ");
				service.getAllPlayer().forEach(n->System.out.println(n.getId()+" -> "+n.getpName()+" | Wicket: "+n.getWicket()+""));
				int idt = Integer.parseInt(sc.nextLine());
				System.out.println("Enter the new wickets ");
				int wicket = Integer.parseInt(sc.nextLine());
				int r = service.updateWickets(idt,wicket);
				if(r==1) {
					System.out.println("wickets are updated successfully");
				}else {
					System.out.println("wickets are not updated");
				}
				break;
			case 5:
				System.out.println("Enter player id : ");
				int id1 = Integer.parseInt(sc.nextLine());

				System.out.println("Enter player name : ");
				String pName = sc.nextLine();

				System.out.println("Enter player jersey no : ");
				int jerseyNo = Integer.parseInt(sc.nextLine());

				System.out.println("Enter player team name : ");
				String tName = sc.nextLine();

				System.out.println("Enter player runs : ");
				int run = Integer.parseInt(sc.nextLine());

				System.out.println("Enter player wickets : ");
				int wicket1 = Integer.parseInt(sc.nextLine());

				System.out.println("Enter player role : ");
				String role = sc.nextLine();

				System.out.println("Enter player country : ");
				String country = sc.nextLine();

				System.out.println("Enter player strike rate : ");
				double strikeRate = Double.parseDouble(sc.nextLine());

				System.out.println("Enter player economy : ");
				double economy = Double.parseDouble(sc.nextLine());

				int output = service.insertPlayer(
				    new Player(id1, pName, jerseyNo, tName, run, wicket1,
				               role, country, strikeRate, economy)
				);

				if(output == 1) {
				    System.out.println("Player added successfully");
				} else {
				    System.out.println("Player not added");
				}
				break;
			case 6:
				System.out.println("Select the player id from following : ");
				service.getAllPlayer().forEach(n->System.out.println(n.getId()+" -> "+n.getpName()));
				int idtt = Integer.parseInt(sc.nextLine());
				int rr = service.deletePlayer(idtt);
				if(rr==1) {
					System.out.println("Player deleted  successfully");
				}else {
					System.out.println("Player not deleted");
				}
				break;
				
			default:
				System.out.println("Please enter a valid choice");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}