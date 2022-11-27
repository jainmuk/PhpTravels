package objects;

public class Login {

	
	private String userID;
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}
	public Login(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [userID=" + userID + ", password=" + password + "]";
	}
	
	
	
	
	
	
}
