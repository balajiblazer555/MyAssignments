package week1.day1;

public class Mobile1 {
	
	public void makeCall() {
		
		String name="mobileModel";						
		float mobileWeight=150.75f;
		System.out.println(name);
		System.out.println(mobileWeight);
		
	}
	
    public void sendMsg() {
    	
    	boolean isFullCharged=true;
    	int mobileCost=10000;
    	System.out.println(isFullCharged);
    	System.out.println(mobileCost);
    	
		
	}

	public static void main(String[] args) {
		
		Mobile1 a=new Mobile1();
		a.makeCall();
		a.sendMsg();
		System.out.println("This is my new mobile");

	}

}
