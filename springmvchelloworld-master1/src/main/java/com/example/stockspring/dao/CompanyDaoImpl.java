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

import com.example.stockspring.model.Company;
import com.example.stockspring.model.Sector;

@Repository
public class CompanyDaoImpl implements CompanyDao{

	public boolean insertCompany(Company company) throws SQLException  {
				
		boolean i=true; 
		  try {
			  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/diksha","root","pass@word1");
			  PreparedStatement ps=conn.prepareStatement("insert into company(company_code,company_Name, turnover, ceo, boardofdirectors, sector_id, breifwriteup, stock_Code) values(?,?,?,?,?,?,?,?)");
			  Random r=new Random();
			  int no=r.nextInt(9000)+1000;
			  ps.setInt(1, no);
			  ps.setString(2,company.getCompanyName());
			  ps.setDouble(3,company.getTurnover());
		  ps.setString(4,company.getCeo());
		  ps.setString(5,company.getBoardOfDirectors());
			 ps.setInt(6,company.getSectorId()); 
		  ps.setInt(6, company.getSectorId());
		  ps.setString(7,company.getBrief());
		 
		  ps.setInt(8, no);
		  
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

	
	public List<Company> getCompanyList() throws SQLException {
		List <Company> companyList=new ArrayList<Company>();
		try{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/diksha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from company");
		ResultSet rs=	ps.executeQuery();
		Company company=null;
		while(rs.next()){
			 company=new Company();
			 int companyId=rs.getInt("company_code");
			company.setCompanyId(companyId);
			
			String companyName=rs.getString("company_name");
			company.setCompanyName(companyName);
			
			Double turnover=rs.getDouble("turnover");
			company.setTurnover(turnover);
			
			company.setCeo(rs.getString("ceo"));
			
			company.setBoardOfDirectors(rs.getString("boardofdirectors"));
				
				  //Sector sector=new Sector(); 
				 company.setSectorId(rs.getInt("sector_id"));
				 company.setBrief(rs.getString("breifWriteUp"));
				 company.setStockCode(rs.getInt("stock_code"));
				  //company.setSector(sector);
				 
			
			
			companyList.add(company);
		}
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}
		return companyList;
	}

	
	
	
	public List<Sector> getSectorList() throws SQLException {
		List <Sector> sectorList=new ArrayList<Sector>();
		try{
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/diksha","root","pass@word1");
		PreparedStatement ps=conn.prepareStatement("select * from sectors");
		ResultSet rs=	ps.executeQuery();
		Sector sector=null;
		while(rs.next()){
			 sector=new Sector();
			 int sectorId=rs.getInt("id");
			sector.setSectorId(sectorId);
			
			String sectorName=rs.getString("sector_name");
			sector.setSectorName(sectorName);
			
			
			
			sector.setBrief(rs.getString("brief"));
			
				
				// company.setBoardOfDirectors(rs.getString("boardofdirectors"));
				 
				 //Sector sector=new Sector(); 
				// company.setSectorId(rs.getInt("sector_id"));
				 //company.setBrief(rs.getString("breifWriteUp"));
				// company.setStockCode(rs.getInt("stock_code")); //company.setSector(sector);
				 				 
			
			
			sectorList.add(sector);
		}
		}catch(SQLException e){
			System.out.println(e);
			throw e;
		}
		return sectorList;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Company updateCompany(Company company) {
		// TODO Auto-generated method stub
		return null;
	}


	


	
	public static void main(String []args) throws Exception{
		CompanyDaoImpl dao=new CompanyDaoImpl();
		//Company compnay=new Company();
		//compnay.setCompanyId(1001);
		//dao.insertCompany(compnay);
		
		System.out.println(dao.getCompanyList());
		Company company=new Company();
		company.getCompanyName();
		company.getTurnover();
		company.getCeo();
		company.getBoardOfDirectors();
		company.getBrief();
		
		boolean b=dao.insertCompany(company);
		if(b==false)
			System.out.println("Insertion successful");
		else
			System.out.println("Error in insertion");
	}

}*/
