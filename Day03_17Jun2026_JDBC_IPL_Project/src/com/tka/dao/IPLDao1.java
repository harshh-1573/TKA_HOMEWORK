package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDao1 {

	private String url = "jdbc:mysql://localhost:3306/ipl_db";
	private String username = "root";
	private String password = "password";
	
	private PreparedStatement ps = null;
	private Connection conn = null;
	private ResultSet rs = null;
	List<Player> db_info = new ArrayList<Player>();
	
	private Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public List<Player> getAllPlayers(){
		
		try {
			conn = getConnection();
			ps = conn.prepareStatement("SELECT * FROM player order by player_id asc");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String pName = rs.getString(2);
				int jNo = rs.getInt(3);
				String tName = rs.getString(4);
				int run = rs.getInt(5);
				int wicket = rs.getInt(6);
				String role = rs.getString(7);
				String country = rs.getString(8);
				Double sr = rs.getDouble(9);
				Double ec = rs.getDouble(10);
				
				
				
				Player p = new Player(id,pName,jNo,tName,run,wicket,role,country,sr,ec);
				db_info.add(p);
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return db_info;
	}

	public int updateRuns(int id, int runs) {
		int result=0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement("update player set runs = ? where player_id = ?");
			ps.setInt(1,runs);
			ps.setInt(2, id);
			result = ps.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int updateWickets(int idt, int wicket) {
		int result=0;
		try {
			conn = getConnection();
			ps = conn.prepareStatement("update player set wickets = ? where player_id = ?");
			ps.setInt(1,wicket);
			ps.setInt(2, idt);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int insertPlayer(Player player) {
		int result =0;
		conn = getConnection();
		try {
			ps = conn.prepareStatement("insert into player values (?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, player.getId());
			ps.setString(2, player.getpName());
			ps.setInt(3,player.getJerseyNo());
			ps.setString(4,player.gettName());
			ps.setInt(5, player.getRun());
			ps.setInt(6,player.getWicket());
			ps.setString(7,player.getRole());
			ps.setString(8,player.getCountry());
			ps.setDouble(9,player.getStrikeRate());
			ps.setDouble(10, player.getEconomy());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}

	public int deletePlayer(int idtt) {
		conn= getConnection();
		int output=0;
		try {
			ps = conn.prepareStatement("delete from player where player_id = ?");
			ps.setInt(1, idtt);
			output = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return output;
	}
	
}