package icsd.dblogic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;




import icsd.model.ProductModel;
import icsd.model.categorymodel;
import oracle.jdbc.pool.OracleDataSource;

public class DBhandler {
	
	public Connection getDBcon()
	{
		Connection con=null;	
		try {
			OracleDataSource ods=new OracleDataSource();
			ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");
			con=ods.getConnection("rohit12","icsd");
			System.out.println("connection set successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	//create table category
	//(
	//  CATEGORYID VARCHAR(20) PRIMARY KEY,
	//  CATEGORYNAME VARCHAR(30),
	//  CATEGORYDESC VARCHAR(50),
	//  CATEGORYIMGURL VARCHAR(50)
	//);
	public LinkedList<categorymodel> getAllCategories()
	{
		LinkedList<categorymodel> lst=new LinkedList<>();
		Connection con=getDBcon();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from category");
			ResultSet rset=stmt.executeQuery();
			while(rset.next())
			{
				int categoryid=rset.getInt("categoryid");
				String categoryname=rset.getString("categoryname");
				String categorydesc=rset.getString("categorydesc");
				String categoryimgurl=rset.getString("categoryimgurl");
				categorymodel obj=new categorymodel(categoryid, categoryname, categorydesc, categoryimgurl);
				lst.add(obj);
				
				
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	//create table products
	//(
	//  categoryid varchAr(20),
	//  prodid varchar(10) primary key,
	//  productname varchar(20),
	//  proddesc varchar(50),
	//  prodimgurl varchar(20),
	//  qty number(20),
	//  PRICE NUMBER(15,2)
	//)
	public LinkedList<ProductModel> getAllProductsByCategoryId(String categoryid)
	{
		LinkedList<ProductModel> lst=new LinkedList<>();
		//select * from products Where categoryid =4;
		Connection con=getDBcon();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from products Where categoryid =?");
			stmt.setString(1, categoryid);
			ResultSet rset=stmt.executeQuery();
			while(rset.next())
			{
				String prodid=rset.getString("prodid"),
						productname=rset.getString("productname"),
						proddesc=rset.getString("proddesc"),
						prodimgurl=rset.getString("prodimgurl");
				int qty=rset.getInt("qty");
				double price=rset.getDouble("price");
				
				ProductModel obj=new ProductModel(categoryid, prodid, productname, proddesc, prodimgurl, qty, price);
				lst.add(obj);
				System.out.println(obj);
				
			}
			System.out.println("----------------------------");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lst;
	}
	public ProductModel getProductByProdId(String prodid)
	{
		ProductModel obj=null;
		//select * from products Where categoryid =4;
		Connection con=getDBcon();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from products Where prodid =?");
			stmt.setString(1, prodid);
			ResultSet rset=stmt.executeQuery();
			while(rset.next())
			{
				String categoryid=rset.getString("categoryid"),
						productname=rset.getString("productname"),
						proddesc=rset.getString("proddesc"),
						prodimgurl=rset.getString("prodimgurl");
				int qty=rset.getInt("qty");
				double price=rset.getDouble("price");
				
				obj=new ProductModel(categoryid, prodid, productname, proddesc, prodimgurl, qty, price);
				
				System.out.println(obj);
				
			}
			System.out.println("----------------------------");
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
	public boolean isValidUser(String strUnm,String strPwd)
	{
		boolean res=false;
		Connection con=getDBcon();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from javauser where username=? and passwrd=?");
			stmt.setString(1, strUnm);
			stmt.setString(2, strPwd);
			ResultSet rset=stmt.executeQuery();
			if(rset.next())
			{
				res=true;
				System.out.println("valid user");
			}
			else
			{
				res=false;
				System.out.println("invalid user");
			}
		
			
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
		
	}
}