/*package com.example.stockspring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Repository;

import com.example.stockspring.model.Stock;

@Repository
public class StockDaoImpl implements StockDao{

	@Override
	public boolean insertStock(Stock stock) throws SQLException {
		boolean i=true; 
		  try {
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diksha","root","pass@word1");
			  PreparedStatement ps=conn.prepareStatement("insert into stockexchange(stockexchange_id,stockExchange_name, brief, contactaddress, remarks) values(?,?,?,?,?)");
			  Random r=new Random();
			  int no=r.nextInt(9000)+1000;
			  ps.setInt(1, no);
			  ps.setString(2,stock.getStockExchangeName());
			  ps.setString(3,stock.getBrief());
		  ps.setString(4,stock.getContactAddress());
		  ps.setString(5,stock.getRemarks());
			
		  
		  i=ps.execute(); 
		  System.out.println(i); //returns false 
		  ps.close();
		  conn.close();
		  } 
		  catch(SQLException e) {
		   e.printStackTrace();
		    } 
		  return false;

	}

	@Override
	public List<Stock> getStockList() throws SQLException {
		List <Stock> stockList=new ArrayList<Stock>();
		try{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/diksha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from stockexchange");
		ResultSet rs=	ps.executeQuery();
		Stock stock=null;
		while(rs.next()){
			 stock=new Stock();
			 int stockExchangeId=rs.getInt("stockexchange_id");
			stock.setStockExchangeId(stockExchangeId);
			
			String stockExchangeName=rs.getString("stockExchange_name");
			stock.setStockExchangeName(stockExchangeName);
			
			String brief=rs.getString("brief");
			stock.setBrief(brief);
			
			stock.setContactAddress(rs.getString("contactaddress"));
			
			stock.setRemarks(rs.getString("remarks"));
				
				
			stockList.add(stock);
		}
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}
		return stockList;
		
	}

}*/
