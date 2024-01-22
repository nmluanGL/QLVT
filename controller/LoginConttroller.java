package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import view.Login;
import view.ViewQLVT;

public class LoginConttroller implements ActionListener{
	private Login login;
	private ViewQLVT qlvt;
	public LoginConttroller(Login login) {
		this.login = login;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String st = e.getActionCommand();
		String tentk = login.jTextField_dangnhap.getText();
		String mk = login.jTextField_matkhau.getText();
		
		if(st.equals("Login"))
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
				PreparedStatement pr = conn.prepareStatement("SELECT * FROM dangnhap");
				ResultSet kq = pr.executeQuery();
				boolean giatri = false;
				while(kq.next()) {
					String tk = kq.getString("Tên đăng nhập");
					String mk1 = kq.getString("mat khau");
					if (tentk.equals(tk)&&mk.equals(mk1)) {
						
						JOptionPane.showMessageDialog(login,
							    "Đăng nhập thành công"
							    );
						this.qlvt = new ViewQLVT();
						this.login.setVisible(false);
						giatri = true;
						break;
					}
				}if (!giatri) {
					JOptionPane.showMessageDialog(login,
						    "Bạn đã nhập sai tài khoản",
						    "Thông báo",
						    JOptionPane.WARNING_MESSAGE);
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}

}
