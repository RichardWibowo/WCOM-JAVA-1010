
public class MUICbook {
private String firstName;
private String lastName;
private String password;
private String email;
private int studentID;


	public String getFirstname() {
		return firstName;
	}public String getLastname() {
		return lastName;
	}public String getEmail() {
		return email;
	}public int getID() {
		return studentID;
	}public String getFullname() {
		return firstName+" "+lastName; 
	}public String getAllDetail() {
		return getFullname() +" "+getID()+" "+getEmail();
	}
	
	public void setFirstName(String name) {
		if(name.length() > 3 || name.length() < 12) {
			firstName = Character.toUpperCase(name.charAt(0)) + name.substring(1);
		}else {
			System.out.println("ERROR");
		}
	}public void setPassword(String pwd) {
		if(pwd.length()<3) {
			pwd= firstName+123;
		}
		password = pwd;
	}public void setEmail(String Email){
		if(!email.contains("@")) {
			email=firstName+"."+lastName+"@students.mq.edu.au";
		}
	}public void setID(int ID) {
		if(ID>9999999||ID<1000000) {
			ID = -1;
		}studentID = ID;
	}public MUICbook(String fName, String mail, int ID){
		setFirstName(fName);
		setEmail(mail);
		setID(ID);
	}
}
