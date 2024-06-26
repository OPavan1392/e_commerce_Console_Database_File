package User_Management_Database;

public class User {
	int ID;
	String Fname;
	String Lname;
	String gender;
	int age;
	String email;
	String password;
	String ConfirmPass;
	
	public void printinformation()
	{
		System.out.println("Added Information of User :"+Fname+","+Lname+" ,"+gender+", "+age+", "+email+"," +password);
	}

}
//User_ID INT, User_Fname VARCHAR(20), User_Lname VARCHAR(20), User_Gender VARCHAR(10), User_age int,User_Email Varchar(30), 
//User_pass Varchar(20), User_conpas Varchar(40) 