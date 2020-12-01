package threads;

import ui.DatabaseManagementGUI;

import java.util.ArrayList;

public class ThreadProgress extends Thread{

	private DatabaseManagementGUI gui;
	
	public ThreadProgress(DatabaseManagementGUI dt, ArrayList<Long> n) {
		gui = dt;
	}
	
	public void run() {
		
		for(int i=0; i<=1000;i++) {
			gui.progressBar(i);
		}try {
			sleep(1000);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
