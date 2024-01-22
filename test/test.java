package test;

import javax.swing.UIManager;

import view.Login;
import view.ViewQLVT;

public class test {
	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Login();
			} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}
}
