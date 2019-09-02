package com.example.stockspring;
import java.io.File;  
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;  
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.stockspring.model.ExcelModel;
import com.example.stockspring.model.ImportData;  
public class XLSXReaderExample  
{  
	public ImportData readExcel(String fileName)  { 
	 
		System.out.println("inside read excel ++++++++++++++++++++++++++");
		int x=0;
		ImportData importData=new ImportData();
		try  
		{  
			
			String a="C:\\Users\\Admin\\Documents\\springmvchelloworld-master1\\src\\main\\webapp\\temp\\"+fileName;
			File file = new File(a);   //creating a new file instance  
			FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
			Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next();  
					switch (cell.getCellType())               
					{  
					case Cell.CELL_TYPE_STRING:    //field that represents string cell type
						if(x==0) {
							importData.setCompanyName(cell.getStringCellValue());
							//System.out.print("\t\t\t");  
						}
						if(x==1) {
							importData.setStockExchange(cell.getStringCellValue());
							//System.out.print("\t\t\t");  
						}
						System.out.print(cell.getStringCellValue()+ "\t\t\t");
						break;  
					case Cell.CELL_TYPE_NUMERIC:    //field that represents number cell type  
						if(DateUtil.isCellDateFormatted(cell))
						{
							SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
							
							//sdf.format(cell.getNumericCellValue()+ "\t\t\t");
							
							if(x==3) {
								String str=sdf.format(cell.getDateCellValue());
								importData.setFromDate(sdf.parse(str));
								//System.out.print("\t\t\t");  
							}
							
							if(x==4) {
								String str=sdf.format(cell.getDateCellValue());
								importData.setToDate(sdf.parse(str));
							}
							
							System.out.print(sdf.format(cell.getDateCellValue())+ "\t\t\t");
						}
						else {
							if(x==2) {
								importData.setRecords((int)cell.getNumericCellValue());
								//System.out.print("\t\t\t");  
							}
							System.out.print((int)cell.getNumericCellValue()+ "\t\t\t");
						}
						break;  
					default:  
					}
					x++;
				}  
				System.out.println();
				System.out.println(importData);  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
		return importData;
	}  
}  