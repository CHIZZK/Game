package com.kps.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.kps.dao.GameDao;
import com.kps.dao.impl.GameDaoImpl;
import com.kps.entity.Game;
import com.kps.service.GameService;

public class GameServiceImpl implements GameService {
	GameDao gameDao = new GameDaoImpl();
	Game game = new Game();

	@Override
	public boolean queryAllGames() {
		if (gameDao.queryAllGames() != null) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean addGame(Game game) {
		boolean flag = gameDao.addGame(game);
		if (flag) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean selectGame(Game game) {

		if (gameDao.selectGameByName(game)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean selectGame(String name) {
		if (gameDao.selectGameByName(name)) {
			return true;
		} else {
			return false;
		}
	}

}
