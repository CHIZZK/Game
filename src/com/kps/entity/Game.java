package com.kps.entity;

public class Game {
		private  int  id;
		private  String  name;
		private  String  type;
		private  String  company;
		private  int      year;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public Game(int id, String name, String type, String company, int year) {
		
			this.id = id;
			this.name = name;
			this.type = type;
			this.company = company;
			this.year = year;
		}
		public Game(String name, String type, String company, int year) {
			this.name = name;
			this.type = type;
			this.company = company;
			this.year = year;
		}
		public Game(String name) {
			this.name = name;
		}
		public Game() {
		
		}
		
		

	


}
