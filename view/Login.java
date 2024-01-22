package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;

import controller.LoginConttroller;

public class Login extends JFrame {
	private ViewQLVT qlvt;
	private JTextField jTextField_thongtin;
	public JTextField jTextField_dangnhap;
	public JTextField jTextField_matkhau;
	public JButton jButton_dangnhap;
	public Login() {
		this.setTitle("CÔNG TY TNHH MTV XÂY DỰNG ");
		this.setSize(1080,500 );
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font = new Font("Arial", Font.CENTER_BASELINE, 50);
		
		JPanel jPanel_hinhanh = new JPanel();
		jPanel_hinhanh.setLayout(new BorderLayout());
		JLabel jLabel_hinhanh = new JLabel (" ");
		jLabel_hinhanh.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("hinhnen.png"))));
		
		
		JPanel jPanel_tieude = new JPanel();
		jPanel_tieude.setLayout(new BorderLayout());
		JLabel jLabel_tieude = new JLabel("CÔNG TY QUẢN LÝ VẬT TƯ",SwingConstants.CENTER);
		jLabel_tieude.setBackground(Color.WHITE);
		jLabel_tieude.setForeground(Color.BLUE);
		jLabel_tieude.setFont(font);
        LoginConttroller conttroller = new LoginConttroller(this);
         
        Font font_c = new Font("", Font.PLAIN, 18);
        Font font_cn = new Font("", Font.PLAIN, 15);
           jTextField_dangnhap = new JTextField(10);
           jTextField_dangnhap.setFont(font_cn);
		   jTextField_matkhau = new JTextField(10);
		   jTextField_matkhau.setFont(font_cn);
		    
		   
		   JPanel jPanel_nhapthongtin = new JPanel();
//		JLabel jLabel_thongtin = new JLabel("STT ");
//			jLabel_thongtin.setForeground(Color.BLUE);
			JLabel jLabel_dangnhap = new JLabel("Tên đăng nhập ");
			jLabel_dangnhap.setFont(font_c);
			jLabel_dangnhap.setForeground(Color.BLUE);
			JLabel jLabel_matkhau = new JLabel("Mật khẩu ");
			jLabel_matkhau.setFont(font_c);
			jLabel_matkhau.setForeground(Color.BLUE);
			
			jButton_dangnhap = new JButton("Login");
			jButton_dangnhap.setFont(font_c);
			jButton_dangnhap.setForeground(Color.BLUE);
			jButton_dangnhap.addActionListener(conttroller);
			
			jPanel_nhapthongtin.setLayout(new GridBagLayout());
			GridBagConstraints gdc = new GridBagConstraints();
			gdc.insets = new Insets(5, 5, 5, 5);
			gdc.gridx =0;
			gdc.gridy = 0;
			jPanel_nhapthongtin.add(jLabel_dangnhap,gdc);
			gdc.gridx =1;
			gdc.gridy = 0;
			jPanel_nhapthongtin.add(jTextField_dangnhap,gdc);
			gdc.gridx =0;
			gdc.gridy = 1;
			jPanel_nhapthongtin.add(jLabel_matkhau,gdc);
			gdc.gridx =1;
			gdc.gridy = 1;
			jPanel_nhapthongtin.add(jTextField_matkhau,gdc);
			gdc.gridx =1;
			gdc.gridy = 2;
			jPanel_nhapthongtin.add(jButton_dangnhap,gdc);
			
			
			
			
			
			JPanel jPanel_tong = new JPanel();
			jPanel_tong.setLayout(new BoxLayout(jPanel_tong, BoxLayout.X_AXIS));
			jPanel_tong.add(jPanel_nhapthongtin);
			jPanel_tong.add(jLabel_hinhanh);
			

	       
	        
			 this.setVisible(true);
		     this.setLayout(new BorderLayout());
		     this.add(jLabel_tieude,BorderLayout.NORTH);
		     this.add(jPanel_tong,BorderLayout.CENTER);
			
			
	}
}

