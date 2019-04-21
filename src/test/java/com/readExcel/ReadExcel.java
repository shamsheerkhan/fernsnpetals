package com.readExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static File file;

	// ********************************************************************************//
	/*
	 * Method Name 		:= loadexcelfile()
	 * 
	 * Input Parameter 	:= FILE NAME
	 * 
	 * OutPut Parameter := NA
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	//**************************************************************************************//
	public static void loadexcelfile(String fileName) {
		System.out.println("Loading Excel File");
		String path = System.getProperty("user.dir") + "\\TestData\\" + fileName + ".xlsx";
		boolean status = verifyFileExist(path);
		if (status) {
			try {
				FileInputStream finput = new FileInputStream(file);
				try {
					book = new XSSFWorkbook(finput);
				} catch (IOException e) {

					System.out.println("Work book can't opened");
				}
				System.out.println("File Loaded Successfully");

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		} else {
			System.out.println("No file available under specified path " + path);
		}
	}

	// ***********************************************************************************//
	/*
	 * Method Name 		:= verifyFileExist()
	 * 
	 * Input Parameter 	:= FILE PATH
	 * 
	 * OutPut Parameter := status
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	//***********************************************************************************//
	public static boolean verifyFileExist(String path) {
		boolean status = false;
		try {
			file = new File(path);
			status = true;
		} catch (Exception e) {
			System.out.println("File not Existed in path " + path);
		}

		return status;

	}

	// *********************************************************************************//
	/*
	 * Method Name 		:= getRowCountt()
	 * 
	 * Input Parameter 	:= sheetName
	 * 
	 * OutPut Parameter := Total Row count
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	public static int getRowCountt(String sheetname) {
		int rowcount = 0;
		try {
			sheet = book.getSheet(sheetname);
			rowcount = sheet.getPhysicalNumberOfRows();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return rowcount;

	}

	// ***************************************************************************************//
	/*
	 * Method Name 		:= getColumnCountt()
	 * 
	 * Input Parameter 	:= sheetName
	 * 
	 * OutPut Parameter := Total Column count
	 * 
	 * Designer #		:= SHAMSHEER
	 * 
	 * Sprint #			:=
	 */
	public static int getColumnCountt(String sheetname) {
		int columncount = 0;
		try {

			columncount = sheet.getRow(0).getPhysicalNumberOfCells();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return columncount;

	}

	// *******************************************************************************//
	public static ArrayList getTestData(String filepath, String sheetName, int rowindex, int parameters) {
		int rowcount;
		int colcount;
		String BirthDay_xpath = "";
		String Flowers_child_path = "";
		String text_element_path = "";
		String exp_text = "";
		ArrayList<String> input = new ArrayList<String>();

		try {

			loadexcelfile(filepath);
			rowcount = getRowCountt(sheetName);
			colcount = getColumnCountt(sheetName);

			boolean bTag = false;

			int i = rowindex;
			Row r = sheet.getRow(i);
			for (int j = 0; j < parameters; j++) {
				if (j == 0) {
					BirthDay_xpath = r.getCell(j).getStringCellValue().toString();
					input.add(BirthDay_xpath);

				}
				if (j == 1) {
					Flowers_child_path = r.getCell(j).getStringCellValue().toString();
					input.add(Flowers_child_path);
				}
				if (j == 2) {
					text_element_path = r.getCell(j).getStringCellValue().toString();
					input.add(text_element_path);
				}
				if (j == 3) {
					exp_text = r.getCell(j).getStringCellValue().toString();
					input.add(exp_text);
				}

				bTag = true;
			}
			if (bTag == false) {
				System.out.println("Can't get Data from Test Data file");
			}
			book.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return input;
	}
	// ***********************************************************************************************************

	
}
