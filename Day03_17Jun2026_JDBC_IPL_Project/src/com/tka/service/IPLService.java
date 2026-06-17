package com.tka.service;

import java.util.List;

import com.tka.dao.IPLDao1;
import com.tka.entity.Player;

public class IPLService {

	private IPLDao1 iplDao= null;
	private List<Player> playerNames;
	
	public List<Player> getAllPlayer(){
		iplDao = new IPLDao1();
		playerNames= iplDao.getAllPlayers();
		return playerNames;
	}
	
	public List<Player> getByTeam(String tName){
		
		iplDao = new IPLDao1();
		return iplDao.getAllPlayers().stream()
					.filter(n->n.gettName().equals(tName))
					.toList();
	}

	public int updateRuns(int id,int runs) {
		iplDao = new IPLDao1();
		return iplDao.updateRuns(id, runs);
	}

	public int updateWickets(int idt, int wicket) {
		iplDao = new IPLDao1();
		return iplDao.updateWickets(idt,wicket);
	}

	public int insertPlayer(Player player) {
		iplDao = new IPLDao1();
		return iplDao.insertPlayer(player);
		
	}

	public int deletePlayer(int idtt) {
		iplDao = new IPLDao1();
		return iplDao.deletePlayer(idtt);
	}

	
	
	
}