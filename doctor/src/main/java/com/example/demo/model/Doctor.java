package com.example.demo.model;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Doctor {
	@Autowired
	public Doctor() {
		super();
	}
	@Id
	Long id;
	String Name;
	String Speaclist;
	int phno;
         public Doctor(Long id, String name, String speaclist,int phno) {
		super();
		this.id = id;
		Name = name;
		Speaclist = speaclist;
		this.phno=phno;
	}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public int getPhno() {
			return phno;
		}
		public void setPhno(int phno) {
			this.phno = phno;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getSpeaclist() {
			return Speaclist;
		}
		public void setSpeaclist(String speaclist) {
			Speaclist = speaclist;
		}
}
