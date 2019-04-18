package com.kps.service;

import com.kps.entity.Game;

public interface GameService {
	public  boolean     queryAllGames();
	public  boolean     addGame(Game game);
	public  boolean     selectGame(Game game);
	public  boolean     selectGame(String name);
	

}
