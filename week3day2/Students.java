package week3.day2;

public class Students {
	
	public void getStudentInfo(int id) {
		
	}
	
    public void getStudentInfo(int id, String name) {
		
	}
    
    public void getStudentInfo(String email, String phoneNumber) {
		
	}
    
    public static void main(String[] args) {
		
    	Students call=new Students();
    	call.getStudentInfo(12345);
    	call.getStudentInfo(12345, "Balaji");
    	call.getStudentInfo("balajiblazer555@gmail.com", "9876543210");
	}
}
