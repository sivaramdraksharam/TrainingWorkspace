package librarypackage;

public class Loginuser {
	public static Object DoVerification;
	private String Userid;
	private String Password;
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	public void getLogin()
	{
		System.out.println("User ID:"+getUserid());
		System.out.println("Password:"+getPassword());
	}
	public boolean DoVerification(String userid)
	{
		//System.out.println(getUserid());
		if(userid.trim().equals("asahi"))
			return true;
		else
			return false;
	}

}
