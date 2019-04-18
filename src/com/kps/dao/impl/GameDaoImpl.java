package com.kps.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kps.dao.GameDao;
import com.kps.entity.Game;
import com.kps.util.DBUtil;

public class GameDaoImpl extends DBUtil implements GameDao {
	Connection conn = null;
	PreparedStatement pre = null;
	ResultSet rs = null;
	Game game = null;
	int result = 0;

	@Override
	public List<Game> queryAllGames() {
		List<Game> games = new ArrayList<Game>();
		conn = DBUtil.getConnection();
		String sql = "select * from  games";
		try {
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Game game = new Game();
				game.setId(rs.getInt(1));
				game.setName(rs.getString(2));
				game.setType(rs.getString(3));
				game.setCompany(rs.getString(4));
				game.setYear(rs.getInt(5));
				games.add(game);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pre, rs);
		}

		return games;

	}

	@Override
	public boolean addGame(Game game) {
		conn = DBUtil.getConnection();
		String sql = "insert into  games values(?,?,?,?,?)";
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, game.getId());
			pre.setString(2, game.getName());
			pre.setString(3, game.getType());
			pre.setString(4, game.getCompany());
			pre.setInt(5, game.getYear());
			int result = pre.executeUpdate();
			if (result > 0) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			closeAll(conn, pre, rs);
		}

	}

//	@Override
//	public List<Game> selectGameByName( String name) {
//		   List<Game> games  =new ArrayList<>();
//		try {
//			conn=DBUtil.getConnection();
//		    String  sql="select * from games where name=?";
//			pre=conn.prepareStatement(sql);
//			pre.setString(1, name);
//			rs=pre.executeQuery();
//			while(rs.next()) {
//				Game game =new Game();
//				game.setId(rs.getInt(1));
//				game.setName(rs.getString(2));
//				game.setType(rs.getString(3));
//				game.setCompany(rs.getString(4));
//				game.setYear(rs.getInt(5));
//				games.add(game);
//			}
//				
//		
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}finally {
//			closeAll(conn, pre, rs);
//		}
//		return games;
//	
//		
//	}
//	@Override
//	public List<Game> selectGameByName() {
//		String sql="select * from  games ";
//		return getPetStoreInfosBySql(sql, null);
//		
//	}
//	
//	public   List<Game>   getPetStoreInfosBySql(String sql,Object...params){
//
//		Connection  connection=null;
//		PreparedStatement  preparedStatement=null;
//		ResultSet    resultSet=null;
//		List<Game>  games=new ArrayList<Game>();
//		try {
//			connection=DBUtil.getConnection();
//			preparedStatement=connection.prepareStatement(sql);
//			if (params!=null) {
//				for (int i = 0; i < params.length; i++) {
//					Object object = params[i];
//					preparedStatement.setObject(i+1, params[i]);
//				}
//			}
//			resultSet=preparedStatement.executeQuery();
//		   while (resultSet.next()) {
//			  Game   game=new Game();
//			   game.setId(resultSet.getInt(1));
//			   game.setName(resultSet.getString(2));
//			   game.setType(resultSet.getString(3));
//			   game.setCompany(resultSet.getString(4));
//			   game.setYear(resultSet.getInt(5));
//			   games.add(game);
//	}}catch (Exception e) {
//		// TODO: handle exception
//	
//		   }
//		finally {
//			closeAll(connection, preparedStatement, resultSet);		
//		}
//		return games;
//
//}
	@Override
	public boolean selectGameByName(Game game) {
		try {

			conn = DBUtil.getConnection();
			String sql = "select * from games where  name=?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, game.getName());

			rs = pre.executeQuery();

			int count = 0;
			while (rs.next()) {
				count = rs.getInt(1);

			}
			if (count > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean selectGameByName(String name) {
		try {

			conn = DBUtil.getConnection();
			String sql = "select * from games where  name=?";
			pre = conn.prepareStatement(sql);
			pre.setString(1, name);

			int count=0;
			rs = pre.executeQuery();
			while (rs.next()) {
				count++;
			}

			System.out.println("******************");
			System.out.println(count);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
