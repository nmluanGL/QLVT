package controller;
import model.AdminModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import com.mysql.cj.xdevapi.Statement;

public class AdminDAO extends BaseController {
	public boolean Add(AdminModel qlvt) {
		String sqlAdd = "Insert into qlvt values(?,?,?,?,?,?)";
		try {
			Connection conn = getConnection();
			CallableStatement stmt = conn.prepareCall(sqlAdd);
			stmt.setInt(1, qlvt.getStt());
			stmt.setInt(2, qlvt.getSl_tonkho());
			stmt.setString(3, qlvt.getMavt());
			stmt.setFloat(4, qlvt.getGianhap());
			stmt.setString(5, qlvt.getDonvi());
			stmt.setFloat(6, qlvt.getGiaban());
			int row = stmt.executeUpdate();
			return row>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return false;
		
		
	}
	public boolean DeleteQLVT(AdminModel qlvt) {
		String sqlUpdate = "Delete FROM qlvt WHERE stt=?";
		try {
			Connection conn = getConnection();
			CallableStatement stmt = conn.prepareCall(sqlUpdate);

			stmt.setInt(1, qlvt.getStt());
			int row = stmt.executeUpdate();
			return row>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean UpdateQLVT(AdminModel qlvt) {
		String sqlUpdate = "UPDATE qlvt SET `Số Lượng Tồn Kho`=?, `Mã Vật Tư`=?, `Giá Nhập`=?, `Đơn Vị`=?, `Giá Bán`=? WHERE `STT`=?";
		try {
			Connection conn = getConnection();
			CallableStatement stmt = conn.prepareCall(sqlUpdate);

			stmt.setInt(1, qlvt.getSl_tonkho());
			stmt.setString(2, qlvt.getMavt());
			stmt.setFloat(3, qlvt.getGianhap());
			stmt.setString(4, qlvt.getDonvi());
			stmt.setFloat(5, qlvt.getGiaban());
			stmt.setInt(6, qlvt.getStt());
			int row = stmt.executeUpdate();
			return row>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public List<AdminModel> getqlvt(){
		Vector<AdminModel> lstqlvt = new Vector<AdminModel>();
		try {
			Connection conn = getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from qlvt");
			while(rs.next()) {
				int stt = rs.getInt("STT");
				int sltonkho = rs.getInt("Số Lượng Tồn Kho");
				String mavt = rs.getString("Mã Vật Tư");
				Float gianhap = rs.getFloat("Giá nhập");
				String donvi = rs.getString("Đơn Vị");
				Float giaban = rs.getFloat("Giá Bán");
				lstqlvt.add(new AdminModel(stt,sltonkho,mavt,gianhap,donvi,giaban));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lstqlvt;	
		
	}
	public List<AdminModel> sortqlvt(){
		Vector<AdminModel> lstqlvt = new Vector<AdminModel>();
		try {
			Connection conn = getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM qlvt ODER BY Sl_tonkho DESC ");
		    while (rs.next()) {
		    	int stt = rs.getInt("STT");
				int sltonkho = rs.getInt("Số Lượng Tồn Kho");
				String mavt = rs.getString("Mã Vật Tư");
				Float gianhap = rs.getFloat("Giá nhập");
				String donvi = rs.getString("Đơn Vị");
				Float giaban = rs.getFloat("Giá Bán");
				lstqlvt.add(new AdminModel(stt,sltonkho,mavt,gianhap,donvi,giaban));
		    }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lstqlvt;
		
	}

	

	

}
