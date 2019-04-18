package com.kps.test;

import java.util.Scanner;

import com.kps.entity.Game;
import com.kps.service.GameService;
import com.kps.service.impl.GameServiceImpl;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner  scanner=new Scanner(System.in);
		System.out.println("name");
		String name=scanner.next();
		System.out.println("type");
		String type=scanner.next();
		System.out.println("company");
		String company=scanner.next();
		System.out.println("year");
		int   year=scanner.nextInt();
		GameService   gameService=new GameServiceImpl();
		Game  game=new Game(name,type,company,year);
		boolean flag=gameService.addGame(game);
		if (flag=true) {
			System.out.println(game.getId()+"\t"+game.getName()+"\t"+game.getType()+"\t"+game.getCompany()+"\t"+game.getYear());
		
		}
		

	}

}
