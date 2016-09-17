//邏輯類
package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class userbeanC {
	
	private Connection con = null;
	private PreparedStatement pr = null;
	private ResultSet rs = null;
	private int pageCoint = 0; //共有幾頁
//=====================================================================================================
	/**
	 * 搜尋用戶方法
	 * @author 
	 * 華暘
	 * @param id
	 * 用戶ID
	 * @return true
	 * 表示成功
	 */
public ArrayList searchuser(String id){
		
	ArrayList al = new ArrayList();
		
		try {
			connet cn = new connet();
			con = cn.getConn();
			pr = con.prepareStatement("SELECT * FROM test.testform where id = '"+id+"' or name='"+id+"' or psw='"+id+"' ");
			rs = pr.executeQuery();
				
			//rs封裝到userbean
			while (rs.next()) {
				userbean ub = new userbean();
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setPsw(rs.getString(3));
				ub.setTime(rs.getString(4));

				al.add(ub);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return al;
	}
	
//===================================================================================================
/**
 * 新增用戶方法
 * @author 
 * 華暘
 * @param id
 * 用戶ID
 * @param name
 * 用戶名
 * @param psw
 * 密碼
 * @return true
 * 表示成功
 */
public boolean adduser(String id,String name,String psw){
		
		boolean b = false;
		
		try {
			connet cn = new connet();
			con = cn.getConn();
			pr = con.prepareStatement("INSERT INTO testform(id,name,psw) VALUES('"+id+"','"+name+"','"+psw+"')");
			int num = pr.executeUpdate();
			
			if(num == 1){
				b = true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return b;
	}
//====================================================================================================
	/**
	 * 修改用戶方法
	 * @author 
	 * 華暘
	 * @param id
	 * 用戶ID
	 * @param name
	 * 用戶名
	 * @param psw
	 * 密碼
	 * @return true
	 * 表示成功
	 */
public boolean edituser(String id,String name,String psw){
		
		boolean b = false;
		
		try {
			connet cn = new connet();
			con = cn.getConn();
			pr = con.prepareStatement("UPDATE testform SET name ='"+name+"',psw='"+psw+"' WHERE id ='"+id+"' ");
			int num = pr.executeUpdate();
			
			if(num == 1){
				b = true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return b;
	}
//================================================================================================
/**
 * 刪除用戶方法
 * @author 
 * 華暘
 * @param id
 * 用戶ID
 * @return true
 * 表示成功
 */
	public boolean deleteuser(String id){
		
		boolean b = false;
		
		try {
			connet cn = new connet();
			con = cn.getConn();
			pr = con.prepareStatement("DELETE FROM testform where id="+id+" ");
			int num = pr.executeUpdate();
			
			if(num == 1){
				b = true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return b;
	}
	
//===============================================================================================
	/**
	 * 取得pageCoint方法
	 * @return
	 */
	public int getpageCoint(){
		return this.pageCoint;
	}
//==================================================================================================
	/**
	 * 顯示分頁方法
	 * @author 
	 * 華暘
	 * @param pageSize
	 * 顯示筆數
	 * @param pageNow
	 * 目前的分頁
	 * @return true
	 * 表示成功
	 */
	public ArrayList getresult(int pageSize , int pageNow){
		
		int rowCount = 0; //共有幾條記錄
		
		ArrayList al = new ArrayList();
		
			try {
				connet cn = new connet();
				con = cn.getConn();
				pr = con.prepareStatement("select count(*) from test.testform");
				rs = pr.executeQuery("select count(*) from test.testform");
				//得到rowCount
				if (rs.next()) {
					rowCount = rs.getInt(1);
				}
				//計算pageCoint
				if (rowCount % pageSize != 0) {
					pageCoint = rowCount / pageSize + 1;
				} else {
					pageCoint = rowCount / pageSize;
				}
				pr = con.prepareStatement("select * from test.testform limit " + (pageNow - 1) * pageSize + "," + pageSize + " ");
				rs = pr.executeQuery();
				//rs封裝到userbean
				while (rs.next()) {
					userbean ub = new userbean();
					ub.setId(rs.getInt(1));
					ub.setName(rs.getString(2));
					ub.setPsw(rs.getString(3));
					ub.setTime(rs.getString(4));

					al.add(ub);
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally{
				this.close();
			}
			return al;
	}
		
	
	
//===========================================================================================================
	/**
	 * 用戶登入驗證方法
	 * @author 
	 * 華暘
	 * @param u
	 * 得到的用戶名
	 * @param p
	 * 得到的密碼
	 * @return true
	 * 表示成功
	 */
	public boolean checkUser(String u,String p){
		
		boolean b = false;
		
		try {
			connet cd = new connet();
			con = cd.getConn();
			pr = con.prepareStatement("select psw from test.testform where name=? limit 1 ");
			pr.setString(1, u);
			rs = pr.executeQuery();
			
			if(rs.next()){
				String dbpass = rs.getString(1);
				if(dbpass.equals(p)){
					b = true;
				}
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//關閉數據庫
		finally{		
				try {
					this.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		return b;
	}
	
//==============================================================================================================
	/**
	 * 關閉數據庫方法
	 */
	public void close(){
		try {
			if(rs != null){
			rs.close();
			}
			if(pr != null){
			pr.close();
			}
			if(con != null){
			con.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
