package com.ningzeta.avatar;

/**
 * Example Class
 *
 * @author Ningthoujam Lokhendro
 * @since 11/9/2016
 */
public class DBConnectionParam {

	String hostname;
	String username;
	String password;
	String sid;
	int port;

	public DBConnectionParam() {
	}

	public DBConnectionParam(String hostname, String username, String password, String sid, int port) {
		this.hostname = hostname;
		this.username = username;
		this.password = password;
		this.sid = sid;
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "{" +
				"hostname='" + hostname + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", sid='" + sid + '\'' +
				", port=" + port +
				'}';
	}
}
