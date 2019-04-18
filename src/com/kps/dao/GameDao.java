package com.kps.dao;

import java.util.List;

import com.kps.entity.Game;

public interface GameDao  {
	//查询所有游戏
	public  List<Game>  queryAllGames();
	//添加新游戏
	public  boolean     addGame(Game  game);
	//根据游戏名称查询
//	public List<Game>     selectGameByName(String name);
	public boolean     selectGameByName(Game game);
	public boolean     selectGameByName(String name);

}
