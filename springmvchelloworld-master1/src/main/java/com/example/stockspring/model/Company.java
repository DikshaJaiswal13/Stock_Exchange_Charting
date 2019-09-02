package com.example.stockspring.model;


import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Company {
	
	@Id
	
	@Column(name="company_code")
	private int companyId;
	
	@Column(name="company_name")
	@NotNull
	private String companyName;
	private BigDecimal turnover;
	private String ceo;
	
	@Column(name="boardofdirectors")
	private String boardOfDirectors;
	
	@Column(name="sector_id")
	private int sectorId;
	
	@Column(name="breifwriteup")
	private String brief;
	
	@Column(name="stock_Code")
	private int stockCode;


	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public int getCompanyId() {
		return companyId;
	}


	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	


	public BigDecimal getTurnover() {
		return turnover;
	}


	public void setTurnover(BigDecimal turnover) {
		this.turnover = turnover;
	}


	public String getCeo() {
		return ceo;
	}


	public void setCeo(String ceo) {
		this.ceo = ceo;
	}


	public String getBoardOfDirectors() {
		return boardOfDirectors;
	}


	public void setBoardOfDirectors(String boardOfDirectors) {
		this.boardOfDirectors = boardOfDirectors;
	}


	public int getSectorId() {
		return sectorId;
	}


	public void setSectorId(int sectorId) {
		this.sectorId = sectorId;
	}


	public String getBrief() {
		return brief;
	}


	public void setBrief(String brief) {
		this.brief = brief;
	}


	public int getStockCode() {
		return stockCode;
	}


	public void setStockCode(int stockCode) {
		this.stockCode = stockCode;
	}


	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", turnover=" + turnover + ", ceo="
				+ ceo + ", boardOfDirectors=" + boardOfDirectors + ", sectorId=" + sectorId + ", brief=" + brief
				+ ", stockCode=" + stockCode + "]";
	}


	public Company(int companyId, String companyName, BigDecimal turnover, String ceo, String boardOfDirectors,
			int sectorId, String brief, int stockCode) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.turnover = turnover;
		this.ceo = ceo;
		this.boardOfDirectors = boardOfDirectors;
		this.sectorId = sectorId;
		this.brief = brief;
		this.stockCode = stockCode;
	}
	
}


