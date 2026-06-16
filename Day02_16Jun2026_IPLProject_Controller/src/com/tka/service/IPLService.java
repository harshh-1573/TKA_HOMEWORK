package com.tka.service;

import java.util.List;
//import java.util.stream.*;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

	private IPLDao iplDao= null;
	private List<Player> playerNames;
	
	public List<Player> getAllPlayer(){
		iplDao = new IPLDao();
		playerNames= iplDao.getAllPlayer();
		return playerNames;
	}
	
	public List<Player> getByTeam(String tName){
		
		iplDao = new IPLDao();
		return iplDao.getAllPlayer().stream()
					.filter(n->n.gettName().equals(tName))
					.toList();
	}
}