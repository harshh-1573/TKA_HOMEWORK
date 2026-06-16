package com.tka.controller;

import java.util.List;
import java.util.Scanner;

import com.tka.service.IPLService;

public class IPLController {

	public static void main(String[] args) {
		IPLService service = new IPLService();
		System.out.println("Enter 1. Show All Player Name    2. Show Player By Team");
		Scanner sc = new Scanner(System.in);
		int choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
		case 1:
			service.getAllPlayer().forEach(n->System.out.println(n.getpName()));
			break;
		case 2:
			System.out.println("Enter the name of Team (RCB,RR,GT,SRH)");
			List<String> validOptions= List.of("RCB","RR","GT","SRH");
			String userInput = sc.nextLine();
			if(validOptions.contains(userInput.toUpperCase())) {
				service.getByTeam(userInput.toUpperCase()).stream().forEach(n->System.out.println(n));
			}else {
				System.out.println("Invalid Team name");
			}
			
		}
		sc.close();
	}
}