
package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.ResultsetRow;

import controller.AdminDAO;
import controller.QLVTController;
import model.AdminModel;


public class ViewQLVT extends JFrame {
	CardLayout cardlayout;
	DefaultTableModel ds;
	
	public AdminModel model;
	private JTextField jTextField_stt;
	private JTextField jTextField_gianhap;
	private JTextField jTextField_sltonkho;
	private JTextField jTextField_donvi;
	private JTextField jTextField_mavt;
	private JTextField jTextField_giaban;
	private JTextField jTextField_timkiem;
	private JTextField jTextFiel_mavt;
	private JTextField jTextFiel_gianhap;
	private JTextField jTextFiel_donvi;
	private JTextField jTextFiel_sltonkho;
	private JTextField jTextFiel_giaban;
	private JTextField jTextFiel_timkiem;
	private DefaultTableModel bangql;
	private JTextField jTextField_hoten;
	private JTextField jTextField_tk;
	private JTextField jTextField_mk;
	private JTextField jTexField_id;

	
	public  ViewQLVT() {
		
        
        
		this.setTitle("Quản lý vật tư");
		this.setSize(950, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setIcon JFrame
		URL urlIconNotepad = ViewQLVT.class.getResource("Notepad-Bloc-notes-2-icon.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotepad);
		this.setIconImage(img);
		Action action = new QLVTController(this);
		Font font = new Font("Arial", Font.BOLD, 40);
		
		
		
		
        
        
		JPanel jPanel_nhapan = new JPanel();
		jPanel_nhapan.setLayout(new BorderLayout());
		JLabel jLabel_title = new JLabel("Quản Lý Vật Tư",SwingConstants.CENTER);
		jLabel_title.setBackground(Color.CYAN);
		jLabel_title.setForeground(new Color(0,191,255));
		jLabel_title.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("quanlynho.png"))));
		jLabel_title.setFont(font);
		jLabel_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		
         jTextField_stt = new JTextField(20);
         jTextField_stt = new JTextField(20);
 		 jTextField_stt.setEnabled(false);
 		 jTextField_mavt = new JTextField(20);
		 jTextField_gianhap = new JTextField(20);
		 jTextField_donvi = new JTextField(20);
		 jTextField_sltonkho = new JTextField(20);
	     jTextField_giaban = new JTextField(10);
		 jTextField_timkiem = new JTextField(10);
		
		
		JPanel jPanel_nhapthongtin = new JPanel();
		JLabel jLabel_stt = new JLabel("STT ");
		jLabel_stt.setForeground(Color.BLUE);
		JLabel jLabel_mavt = new JLabel("Mã Vật Tư ");
		jLabel_mavt.setForeground(Color.BLUE);
		JLabel jLabel_donvi = new JLabel("Đơn Vị ");
		jLabel_donvi.setForeground(Color.BLUE);
		JLabel jLabel_gianhap = new JLabel("Giá nhập ");
		jLabel_gianhap.setForeground(Color.BLUE);
		JLabel jLabel_giaban = new JLabel("Giá Bán ");
		jLabel_giaban.setForeground(Color.BLUE);
		JLabel jLabel_sltonkho = new JLabel("Số Lượng Tồn Kho ");
		jLabel_sltonkho.setForeground(Color.BLUE);
		
		
		
		jPanel_nhapthongtin.setLayout(new GridLayout(5, 3, 20, 10));
		jPanel_nhapthongtin.setBackground(new Color(176,224,230));
		
		jPanel_nhapthongtin.add(jLabel_stt);
		jPanel_nhapthongtin.add(jTextField_stt);
		
		jPanel_nhapthongtin.add(jLabel_gianhap);
		jPanel_nhapthongtin.add(jTextField_gianhap);
		jPanel_nhapthongtin.add(jLabel_mavt);
		jPanel_nhapthongtin.add(jTextField_mavt);
		jPanel_nhapthongtin.add(jLabel_giaban);
		jPanel_nhapthongtin.add(jTextField_giaban);
		jPanel_nhapthongtin.add(jLabel_donvi);
		jPanel_nhapthongtin.add(jTextField_donvi);
	
		jPanel_nhapthongtin.add(jLabel_sltonkho);
		jPanel_nhapthongtin.add(jTextField_sltonkho);
		
		
		
		jPanel_nhapan.add(jPanel_nhapthongtin,BorderLayout.CENTER);
		
		JPanel jPanel_button = new JPanel();
		jPanel_button.setLayout(new BoxLayout(jPanel_button, BoxLayout.Y_AXIS));
		
		
		JButton jButton_them = new JButton("Thêm");
		jButton_them.setForeground(Color.BLUE);
		jButton_them.setBackground(Color.WHITE);
		jButton_them.setOpaque(true);
		jButton_them.addActionListener(action);
		jButton_them.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("them.png"))));
		
		
		JButton jButton_capnhat = new JButton("Cập nhật");
		jButton_capnhat.setForeground(Color.BLUE);
		jButton_capnhat.setBackground(Color.WHITE);
		jButton_capnhat.setOpaque(true);
		jButton_capnhat.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("update.png"))));
		jButton_capnhat.addActionListener(action);
		
		
		JButton jButton_xoa = new JButton("Xóa");
		jButton_xoa.setForeground(Color.BLUE);
		jButton_xoa.setBackground(Color.WHITE);
		jButton_xoa.setOpaque(true);
		jButton_xoa.addActionListener(action);
		jButton_xoa.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("delete.png"))));
		
		
		JButton jButton_timkiem = new JButton("Tìm Kiếm");
		jButton_timkiem.setForeground(Color.BLUE);
		jButton_timkiem.setBackground(Color.WHITE);
		jButton_timkiem.setOpaque(true);
		jButton_timkiem.addActionListener(action);
		//URL Icon timkiem
		jButton_timkiem.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("timkiem.png"))));
		
		JButton jButton_reset = new JButton("Reset");
		jButton_reset.setForeground(Color.BLUE);
		jButton_reset.setBackground(Color.WHITE);
		jButton_reset.setOpaque(true);
		jButton_reset.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("reset.png"))));
		
		JButton jButton_sort = new JButton("Sắp Xếp");
		jButton_sort.setForeground(Color.BLUE);
		jButton_sort.setBackground(Color.WHITE);
		jButton_sort.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("sort_asc.png"))));
		
		
		
		jPanel_nhapthongtin.add(jButton_them);
		jPanel_nhapthongtin.add(jButton_capnhat);
		jPanel_nhapthongtin.add(jButton_timkiem);
		jPanel_nhapthongtin.add(jTextField_timkiem);
		jPanel_nhapthongtin.add(jButton_xoa);
		jPanel_nhapthongtin.add(jButton_reset);
		jPanel_nhapthongtin.add(jButton_sort);
		
		//bang
		ds = new DefaultTableModel();
		ds.addColumn("STT");
		ds.addColumn("Số Lượng Tồn Kho");
		ds.addColumn("Mã Vật Tư");
		ds.addColumn("Giá Nhập");
		ds.addColumn("Đơn Vị");
		ds.addColumn("Giá Bán");
		
		
		inDuLieuRaBang();
		

		
		JTable bang = new JTable(ds);
		JScrollPane vattu = new JScrollPane(bang);
		jPanel_button.add(vattu,BorderLayout.CENTER);
		
		//bảng
		vattu.getViewport().add(bang);
		bang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    @Override
		    public void valueChanged(ListSelectionEvent e) {
		        if (e.getValueIsAdjusting()) {
		            return;
		        }

		        int selectedRow = bang.getSelectedRow();
		        if (selectedRow >= 0 && selectedRow < bang.getRowCount()) {
		            String stt = bang.getValueAt(selectedRow, 0).toString();
		            String sltonkho = bang.getValueAt(selectedRow, 1).toString();
		            String mavt = bang.getValueAt(selectedRow, 2).toString();
		            String gianhap = bang.getValueAt(selectedRow, 3).toString();
		            String donvi = bang.getValueAt(selectedRow, 4).toString();
		            String giaban = bang.getValueAt(selectedRow, 5).toString();
		            jTextField_stt.setText(stt);
		            jTextField_sltonkho.setText(sltonkho);
		            jTextField_mavt.setText(mavt);
		            jTextField_gianhap.setText(gianhap);
		            jTextField_donvi.setText(donvi);
		            jTextField_giaban.setText(giaban);
		        }
		    }
		});
		
		JPanel titledsql = new JPanel();
		JLabel jLabel_titlee = new JLabel("Danh sách quản lí ",SwingConstants.CENTER);
		jLabel_titlee.setBackground(Color.CYAN);
		jLabel_titlee.setForeground(new Color(0,191,255));
		jLabel_titlee.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("quanlynho.png"))));
		jLabel_titlee.setFont(font);
		titledsql.setLayout(new FlowLayout());
		titledsql.add(jLabel_titlee);

		JPanel jPanel_nhapnguoiql = new JPanel();
		JLabel jLabel_id = new JLabel("ID ");
		jLabel_id.setForeground(Color.BLUE);
		JLabel jLabel_hoten = new JLabel("Họ Tên ");
		jLabel_hoten.setForeground(Color.BLUE);
		JLabel jLabel_tk = new JLabel("Tài Khoản ");
		jLabel_tk.setForeground(Color.BLUE);
		JLabel jLabel_mk = new JLabel("Mật Khẩu ");
		jLabel_mk.setForeground(Color.BLUE);
		

		jTexField_id = new JTextField();
		jTextField_hoten = new JTextField(20);
		jTextField_tk = new JTextField(20);
		jTextField_mk = new JTextField(20);

		jPanel_nhapnguoiql.setLayout(new GridLayout(3, 4, 10, 10));

		jPanel_nhapnguoiql.add(jLabel_id);
		jPanel_nhapnguoiql.add(jTexField_id);
		

		jPanel_nhapnguoiql.add(jLabel_hoten);
		jPanel_nhapnguoiql.add(jTextField_hoten);

		jPanel_nhapnguoiql.add(jLabel_tk);
		jPanel_nhapnguoiql.add(jTextField_tk);

		jPanel_nhapnguoiql.add(jLabel_mk);
		jPanel_nhapnguoiql.add(jTextField_mk);
		
		
		jPanel_nhapnguoiql.setBackground(new Color(176,224,230));
		
		
		
		JButton jButton_adds = new JButton("Thêm");
		jButton_adds.setForeground(Color.BLUE);
		jButton_adds.setBackground(Color.WHITE);
		jButton_adds.setOpaque(true);
		jButton_adds.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("them.png"))));
		
		
		JButton jButton_delete = new JButton("Xóa");
		jButton_delete.setForeground(Color.BLUE);
		jButton_delete.setBackground(Color.WHITE);
		jButton_delete.setOpaque(true);
		jButton_delete.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("delete.png"))));

		JButton jButton_lammoi = new JButton("Reset");
		jButton_lammoi.setForeground(Color.BLUE);
		jButton_lammoi.setBackground(Color.WHITE);
		jButton_lammoi.setOpaque(true);
		jButton_lammoi.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(ViewQLVT.class.getResource("reset.png"))));
		
		jPanel_nhapnguoiql.add(jButton_adds);
		jPanel_nhapnguoiql.add(jButton_delete);
		jPanel_nhapnguoiql.add(jButton_lammoi);
		
		
		JPanel bangs =new JPanel();
				bangql = new DefaultTableModel();
				bangql.addColumn("ID");
				bangql.addColumn("Họ tên");
				bangql.addColumn("Tài khoản");
				bangql.addColumn("Mật khẩu");
				Danhsachbang();
				
				JTable bangss = new JTable(bangql);
				JScrollPane taikhoans = new JScrollPane(bangss);
				bangs.add(taikhoans,BorderLayout.CENTER);
				
				//bảng
				taikhoans.getViewport().add(bangss);
				bangss.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				    @Override
				    public void valueChanged(ListSelectionEvent e) {
				        if (e.getValueIsAdjusting()) {
				            return;
				        }

				        int selectedRow = bangss.getSelectedRow();
				        if (selectedRow >= 0 && selectedRow < bangss.getRowCount()) {
				            String id = bangss.getValueAt(selectedRow, 0).toString();
				            String hoten = bangss.getValueAt(selectedRow, 1).toString();
				            String tk = bangss.getValueAt(selectedRow, 2).toString();
				            String mk = bangss.getValueAt(selectedRow, 3).toString();
				            
				            jTexField_id.setText(id);
				            jTextField_hoten.setText(hoten);
				            jTextField_tk.setText(tk);
				            jTextField_mk.setText(mk);
				            
				        }
				    }
				});
		

		JTabbedPane jTabbedPane_vattu = new JTabbedPane();
		JPanel jPanel_tong = new JPanel();
		jPanel_tong.setLayout(new BoxLayout(jPanel_tong, BoxLayout.Y_AXIS));
		jPanel_tong.add(jLabel_title);
		jPanel_tong.add(jPanel_button);
		jPanel_tong.add(jPanel_nhapthongtin);
		ImageIcon iconvattu = new ImageIcon(ViewQLVT.class.getResource("vattu.png"));
		jTabbedPane_vattu.addTab("Vật tư", iconvattu,jPanel_tong);
		

		JPanel jPanel_dsnguoiquanli = new JPanel();
		jPanel_dsnguoiquanli.setLayout(new BoxLayout(jPanel_dsnguoiquanli, BoxLayout.Y_AXIS));
		ImageIcon icondsquanli = new ImageIcon(ViewQLVT.class.getResource("dsql.png"));
		jTabbedPane_vattu.addTab("Danh sách người quản lí",icondsquanli, jPanel_dsnguoiquanli);
		jPanel_dsnguoiquanli.add(titledsql);
		jPanel_dsnguoiquanli.add(bangs);
		jPanel_dsnguoiquanli.add(jPanel_nhapnguoiql);
		

        
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(jTabbedPane_vattu);
        
        
        jButton_reset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			 jTextField_stt.setText(" ");
			 jTextField_sltonkho.setText(" ");
			 jTextField_donvi.setText(" ");
			 jTextField_giaban.setText(" ");
			 jTextField_gianhap.setText(" ");
			 jTextField_mavt.setText(" ");
			 inDuLieuRaBang();
			}
		});
        
       
jButton_them.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminModel qlvt = new AdminModel();
				AdminDAO adminDAO = new AdminDAO();
				
				
			    int intsltonkho = Integer.parseInt(jTextField_sltonkho.getText());
				String mavt = jTextField_mavt.getText();
				float floatgianhap = Float.parseFloat(jTextField_gianhap.getText());
				String donvi = jTextField_donvi.getText();
				float floatgiaban = Float.parseFloat(jTextField_giaban.getText());
				
			  
			    
			
				
			  
               qlvt.setSl_tonkho(intsltonkho);
               qlvt.setMavt(jTextField_mavt.getText());
               qlvt.setGianhap(floatgianhap);
               qlvt.setDonvi(jTextField_donvi.getText());
               qlvt.setGiaban(floatgiaban);
				
				adminDAO.Add(qlvt);
				inDuLieuRaBang();
			}
		});
       jButton_xoa.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			AdminModel qlvt = new AdminModel();
			AdminDAO admindao = new AdminDAO();
			
			int intstt = Integer.parseInt(jTextField_stt.getText());
			qlvt.setStt(intstt);
			admindao.DeleteQLVT(qlvt);
			inDuLieuRaBang();
		}
	});
       jButton_sort.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				inDuLieuRaBang();
				 Class.forName("com.mysql.cj.jdbc.Driver");
			     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlvt.db", "root", "root");
			     String sql = "SELECT * FROM qlvt ORDER BY `Số Lượng Tồn Kho` DESC";
			     PreparedStatement stmt = conn.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					ds.setRowCount(0);
					while (rs.next()) {
						String stt = rs.getString("STT");
						String sltonkho = rs.getString("Số Lượng Tồn Kho");
						String mavt = rs.getString("Mã Vật Tư");
						String gianhap = rs.getString("Giá nhập");
						String donvi = rs.getString("Đơn Vị");
						String giaban = rs.getString("Giá Bán");
						ds.addRow(new String[] { stt, sltonkho, mavt, gianhap, donvi, giaban });
					}
					stmt.close();
					conn.close();
			 	System.out.println("Câu lệnh sắp xếp đã chạy ");
			  
			} catch (Exception e2) {
				e2.printStackTrace();
				// TODO: handle exception
			}
			}
		
	});
       
       
       
       jButton_capnhat.addActionListener(new ActionListener() {

    	    @Override
    	    public void actionPerformed(ActionEvent e) {
    	        try {
    	            ds.setRowCount(0);
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlvt.db", "root", "root");
    	            String sql = "UPDATE qlvt SET `Số Lượng Tồn Kho`=?, `Mã Vật Tư`=?, `Giá Nhập`=?, `Đơn Vị`=?, `Giá Bán`=? WHERE STT=?";
    	            PreparedStatement stmt = conn.prepareStatement(sql);
    	            stmt.setString(1, jTextField_sltonkho.getText());
    	            stmt.setString(2, jTextField_mavt.getText());
    	            stmt.setString(3, jTextField_gianhap.getText());
    	            stmt.setString(4, jTextField_donvi.getText());
    	            stmt.setString(5, jTextField_giaban.getText());
    	            stmt.setString(6, jTextField_stt.getText()); 

    	            int rowsUpdated = stmt.executeUpdate();
    	            if (rowsUpdated > 0) {
    	                System.out.println("Cập nhật thành công");
    	            } else {
    	                System.out.println("Không tìm thấy bản ghi để cập nhật");
    	            }
    	            inDuLieuRaBang();
    	            

    	            stmt.close();
    	            conn.close();

    	        } catch (Exception e2) {
    	            e2.printStackTrace();
    	        }
    	    }

    	});
   
   
       
       jButton_timkiem.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
         try {
	    Class.forName("com.mysql.cj.jdbc.Driver");
	     Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlvt.db", "root", "root");
	     String sql = "SELECT * FROM `qlvt.db`.qlvt Where "
	     		+ "`STT` LIKE ? OR "
	     		+ "`Số Lượng Tồn Kho` LIKE ? OR "
	     		+ "`Mã Vật Tư` LIKE ? OR " 
	     		+ "`Giá nhập` LIKE ? OR "
	     		+ "`Đơn Vị` LIKE ? OR "
	     		+ "`Giá Bán` LIKE ?";
	          PreparedStatement stmt = conn.prepareStatement(sql);
	          stmt.setString(1, jTextField_timkiem.getText());
	          stmt.setString(2, jTextField_timkiem.getText());
	          stmt.setString(3, jTextField_timkiem.getText());
	          stmt.setString(4, jTextField_timkiem.getText());
	          stmt.setString(5, jTextField_timkiem.getText());
	          stmt.setString(6, jTextField_timkiem.getText());
	            ResultSet rs = stmt.executeQuery();
		     	ds.setRowCount(0);
	         while (rs.next()) {
		    String stt = rs.getString("STT");
		    String sltonkho = rs.getString("Số Lượng Tồn Kho");
		    String mavt = rs.getString("Mã Vật Tư");
		    String gianhap = rs.getString("Giá nhập");
		    String donvi = rs.getString("Đơn Vị");
	     	String giaban = rs.getString("Giá Bán");
	     
		    ds.addRow(new String[] { stt, sltonkho, mavt, gianhap, donvi, giaban });
	         }
	         
	stmt.close();
	conn.close();
	
	System.out.println("Câu lệnh tìm kiếm đã chạy ");
	
} catch (Exception e2) {
	// TODO: handle exception
}
			
		}
	});
       jButton_lammoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			 jTextField_mk.setText(" ");
			 jTextField_hoten.setText(" ");
			 jTextField_tk.setText(" ");
			 
			 Danhsachbang();
			}
		});
       
       
       jButton_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//tao doi tuong connection
					    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsql.db","root","root");
	    	            java.sql.Statement stmt = conn.createStatement();
	    	            String sql = "DELETE FROM dsql WHERE `ID`=" + jTexField_id.getText();
			            
			            int results = stmt.executeUpdate(sql);
			            System.out.println("Dòng lệnh sẽ bị xóa: " + results);
			            
			            stmt.close();
			            conn.close();
			            Danhsachbang();
			            
			            
			        
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
	
	

       jButton_adds.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//nap driver
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					//tao doi tuong connection
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsql.db","root","root");
					java.sql.Statement stmt = conn.createStatement();
					String sql = "INSERT INTO dsql (`ID`,`Họ Tên`,`Tài Khoản`,`Mật Khẩu`) VALUES (0,'"+jTextField_hoten.getText()+"', '"+jTextField_tk.getText()+"','"+jTextField_mk.getText()+"')";
					int result = stmt.executeUpdate(sql);
					
					stmt.close();
					conn.close();
					Danhsachbang();
					
					JOptionPane.showMessageDialog(null, "Success");
					System.out.println("Câu lệnh sql đã chạy: " + sql + "\nCó " + result + " hàng được cập nhật.");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		
		});
	}
	
	
       
//bang tab2
	public void Danhsachbang() {
		bangql.setRowCount(0);
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dsql.db", "root", "root");
			String sql = "SELECT * FROM `dsql.db`.dsql ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("ID");
				String hoten = rs.getString("Họ Tên");
				String tk = rs.getString("Tài Khoản");
				String mk = rs.getString("Mật Khẩu");
				
				bangql.addRow(new String[] { id, hoten, tk, mk });
			}
			stmt.close();
			conn.close();
			System.out.println("Câu lệnh sql đã chạy: ");
		} catch (Exception e2) {
			e2.printStackTrace(); 
		}
	}
	
	//bảng tab1
		public void inDuLieuRaBang() {
			ds.setRowCount(0);
			
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlvt.db", "root", "root");
				String sql = "SELECT * FROM `qlvt.db`.qlvt ";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					String stt = rs.getString("STT");
					String sltonkho = rs.getString("Số Lượng Tồn Kho");
					String mavt = rs.getString("Mã Vật Tư");
					String gianhap = rs.getString("Giá nhập");
					String donvi = rs.getString("Đơn Vị");
					String giaban = rs.getString("Giá Bán");
					ds.addRow(new String[] { stt, sltonkho, mavt, gianhap, donvi, giaban });
				}
				stmt.close();
				conn.close();
				System.out.println("Câu lệnh sql đã chạy: ");
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
		
		}
}

	

