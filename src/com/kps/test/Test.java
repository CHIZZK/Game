package com.kps.test;

import java.util.List;
import java.util.Scanner;

import com.kps.dao.GameDao;
import com.kps.dao.impl.GameDaoImpl;
import com.kps.entity.Game;
import com.kps.service.GameService;
import com.kps.service.impl.GameServiceImpl;

public class Test {

	public static void main(String[] args) {
		
		GameDao  gameDao=new GameDaoImpl();
		GameService   gameService=new GameServiceImpl();
		while(true) {
		System.out.println("欢迎使用游戏管理系统");
		System.out.println("***************************");
		System.out.println("1.查看所有游戏");
		System.out.println("2.添加新游戏");
		System.out.println("3.根据游戏名称查询");
		System.out.println("请选择：");
		Scanner  sc=new Scanner(System.in);
		int  choice=sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("游戏管理->查看所有游戏");
			boolean  flag=gameService.queryAllGames();
			
			if (flag=true) {
				List<Game> games=gameDao.queryAllGames();
				for (Game game : games) {
					System.out.println(game.getId()+"\t"+game.getName()+"\t"+game.getType()+"\t"+game.getCompany()+"\t"+game.getYear());
				}
			}
			break;
		case 2:
			System.out.println("请输入游戏名称");
			String gname=sc.next();
			System.out.println("请输入游戏类型");
			String gtype=sc.next();
			System.out.println("请输入游戏的发行公司");
			String gcompany=sc.next();
			System.out.println("请输入游戏的发行年份");
			int  gyear=sc.nextInt();
			Game  game=new Game(gname,gtype,gcompany,gyear);
			boolean flag1=gameService.addGame(game);
			if (flag1=true) {
				System.out.println(game.getName()+"\t"+game.getType()+"\t"+game.getCompany()+"\t"+game.getYear());
			    System.out.println("游戏添加成功");
			}else {
				System.out.println("添加失败");
			}
			break;
		case 3:	
			System.out.println("请输入要查询的游戏名称：");
			String name=sc.next();
			game =new Game(name);
//			boolean flag2=gameService.selectGame(game );

			boolean flag2=gameService.selectGame(name );
			if (flag2==true) {
				System.out.println("成功");
				
			}else {
				System.out.println("失败");
			}
		}
		
		}  
	}

}
