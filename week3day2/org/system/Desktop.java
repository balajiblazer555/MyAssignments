package org.system;

public class Desktop extends Computer {
	public void desktopSize() {
		System.out.println("Desktop size : 22inch");
	}
	
	public static void main(String[] args) {
		
		Desktop call=new Desktop();
		call.computerModel();
		call.desktopSize();
	}

}
