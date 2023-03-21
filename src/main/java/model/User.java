package model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	private int id;
	private String username;
	private String password;
	private String privilege;
	private Date created_at;
	private Date update_at;
	
	public User() {}
	public User(int id, String username, String password, String privilege, Date created_at, Date update_at) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.privilege = privilege;
		this.created_at = created_at;
		this.update_at = update_at;
	}
	
	public int getId() { return id; }
	public String getUsername() { return username; }
	public String getPassword() { return password; }
	public String getPrivilege() { return privilege; }
	public Date getCreated_at() { return created_at; }
	public Date getUpdate_at() { return update_at; }
	
}
