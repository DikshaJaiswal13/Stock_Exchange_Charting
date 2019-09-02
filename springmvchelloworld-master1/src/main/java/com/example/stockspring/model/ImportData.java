package com.example.stockspring.model;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportData {

	private String companyName;
	private String stockExchange;
	private int records;
	@Override
	public String toString() {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		
		return "ImportData [companyName=" + companyName + ", stockExchange=" + stockExchange + ", records=" + records
				+ ", fromDate=" + sdf.format(fromDate) + ", toDate=" + sdf.format(toDate) + "]";
	}
	public ImportData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ImportData(String companyName, String stockExchange, int records, Date fromDate, Date toDate) {
		super();
		this.companyName = companyName;
		this.stockExchange = stockExchange;
		this.records = records;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}
	private Date fromDate;
	private Date toDate;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getStockExchange() {
		return stockExchange;
	}
	public void setStockExchange(String stockExchange) {
		this.stockExchange = stockExchange;
	}
	public int getRecords() {
		return records;
	}
	public void setRecords(int records) {
		this.records = records;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
}
