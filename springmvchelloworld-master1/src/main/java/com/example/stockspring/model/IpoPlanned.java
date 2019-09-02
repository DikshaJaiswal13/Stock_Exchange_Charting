package com.example.stockspring.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ipo_planned")
public class IpoPlanned {
	
	@Id
	private int id;
	
	@Column(name="Company_code")
	private int companyCode;
	
	@Column(name="Stock_exchange")
	private int stockExchange;
	
	@Column(name="price_per_share")
	private BigDecimal pricePerShare;
	
	@Column(name="total_no_of_shares")
	private int noOfShares;
	
	@Column(name="open_date_time")
	private Date openDateTime;
	private String remarks;
	
	public IpoPlanned() {
		super();
		// TODO Auto-generated constructor stub
	}
	public IpoPlanned(int id, int companyCode, int stockExchange, BigDecimal pricePerShare, int noOfShares,
			Date openDateTime, String remarks) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.stockExchange = stockExchange;
		this.pricePerShare = pricePerShare;
		this.noOfShares = noOfShares;
		this.openDateTime = openDateTime;
		this.remarks = remarks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(int companyCode) {
		this.companyCode = companyCode;
	}
	public int getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(int stockExchange) {
		this.stockExchange = stockExchange;
	}
	public BigDecimal getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(BigDecimal pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public int getNoOfShares() {
		return noOfShares;
	}
	public void setNoOfShares(int noOfShares) {
		this.noOfShares = noOfShares;
	}
	public Date getOpenDateTime() {
		return openDateTime;
	}
	public void setOpenDateTime(Date openDateTime) {
		this.openDateTime = openDateTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
}
