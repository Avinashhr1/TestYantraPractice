package com.Ty.crm.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Avinash
 *
 */
public class ExcellLib {
	String path ="C:\\Users\\admin\\Desktop\\TY Training\\SampleWorkBook.xlsx";
	
	/**
	 * This method provides the data inside the excel sheet based on
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readData(String sheetname, int rownum, int colnum) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(colnum).getStringCellValue();
		wb.close();
		return data;	
	}
	
	
	/**
	 * This method Helps to write the data into the excel sheet based on
	 * @param sheetname
	 * @param rownum
	 * @param colnum
	 * @param data
	 * @throws Throwable
	 */
	public void writeData(String sheetname, int rownum, int colnum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Row row = wb.getSheet(sheetname).getRow(rownum);
		row.createCell(colnum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		wb.close();
			
	}
	
	
	
	
	
	
	
//	
//	public  String readExcell() throws Exception {
//		String cellValue = null;
//		FileInputStream fis = new FileInputStream(path);
//		 Workbook wb = WorkbookFactory.create(fis);
//		 System.out.println(wb.getNumberOfSheets()+" present in workbook");
//		 
//		 for (Sheet sheet : wb) {
//		 //  sheet = wb.getSheetAt(0);
//		 DataFormatter dataformat = new DataFormatter();
//		 
//		 for (Row row : sheet) {
//			for (Cell cel : row) {
//				
//				cellValue= dataformat.formatCellValue(cel);
//				System.out.print(cellValue+"\t");
//				return cellValue;
//				} 
//			System.out.println();
//		 	}	
//		 }
//		 return cellValue;	
//	}
//
//	public String readExcell(String path,String sheetname, int row,int cell ) throws Exception {
//		
//		String cellValue="";
//		FileInputStream fis = new FileInputStream(path);
//		 Workbook wb = WorkbookFactory.create(fis);
//		// System.out.println(wb.getNumberOfSheets()+" present in workbook");
//		 
//		  Sheet sheet = wb.getSheet(sheetname);
//		  int rowcount = sheet.getLastRowNum();
//		
//		  for (int i = 0; i < rowcount+1; i++) {
//			for (int j = 0; j < sheet.getRow(j).getLastCellNum(); j++) {
//				cellValue = sheet.getRow(row).getCell(cell).getStringCellValue();
//				System.out.print(cellValue+"\t");
//				return cellValue;
//			}
//		System.out.println();	  
//			  
//		}
//		return cellValue;
//		
//	}
//	
	
	
}
