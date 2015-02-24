package base;

public class User {
	private int ID;
	private String name;
	private String email;
	
	
	public User(int iD, String name, String email) {
		super();
		ID = iD;
		this.name = name;
		this.email = email;
		System.out.println("User [userId="+this.ID+", "+"userName="+this.name+", "+"userEmail="+this.email+"]");
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
}
