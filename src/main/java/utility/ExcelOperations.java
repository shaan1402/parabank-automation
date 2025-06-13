 package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import path.ConstantPath;

public class ExcelOperations {
	
	private static final String filePath = ConstantPath.EXCELSHEETFILEPATH;
	
	public static Object[][] getDataFromFile() throws IOException {
		
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(inputStream);
		
		Sheet sheet = wb.getSheet("LoginData");
		
		int totalRows = sheet.getLastRowNum() + 1;
		int totalCells = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[totalRows][totalCells];

		for(int rowIndex = 0; rowIndex <totalRows; rowIndex++){
			for(int cellIndex = 0; cellIndex < totalCells; cellIndex++){
			String cellData = sheet.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
			data[rowIndex][cellIndex] = cellData;
			System.out.println(data[rowIndex][cellIndex] + " ");
			}
			System.out.println();
		}
		wb.close();	
		return data;
	}
	
//	public static void clearExcelData(String sheetName)throws IOException {
//		File file = new File(filePath);
//		Workbook workbook;
//		// Use try-with-resources to handle closing automatically
//		if(file.exists()) {
//			try (FileInputStream inputStream = new FileInputStream(file)){
//	        workbook = new XSSFWorkbook(inputStream); 
//	        inputStream.close();
//			}
//		}else {
//			workbook = new XSSFWorkbook();
//		}
//		
//      	// Remove existing sheet if it exists
//        int index = workbook.getSheetIndex(sheetName);
//        if (index != -1) {
//            workbook.removeSheetAt(index);
//            System.out.println("Old data cleared from sheet: " + sheetName);
//        }
//        
//        // Create a new empty sheet
//        workbook.createSheet(sheetName);
//        
//        // Write changes back to the file
//        try (FileOutputStream outputStream = new FileOutputStream(file)) {
//            workbook.write(outputStream); // Write changes to file
//            outputStream.close();
//        }
//        workbook.close();
//    }
	
	public static void clearExcelData(String sheetName) throws IOException {
	    File file = new File(filePath);

	    if (file.exists()) {
	        try (FileInputStream inputStream = new FileInputStream(file);
	             Workbook workbook = new XSSFWorkbook(inputStream)) {

	            int index = workbook.getSheetIndex(sheetName);
	            if (index != -1) {
	                workbook.removeSheetAt(index);
	                System.out.println("Old data cleared from sheet: " + sheetName);
	            }

	            // Create a new empty sheet
	            workbook.createSheet(sheetName);
	            inputStream.close();

	            try (FileOutputStream outputStream = new FileOutputStream(file)) {
	                workbook.write(outputStream);
	            }
	        }
	    } else {
	        try (Workbook workbook = new XSSFWorkbook()) {
	            workbook.createSheet(sheetName);
	            try (FileOutputStream outputStream = new FileOutputStream(file)) {
	                workbook.write(outputStream);
	            }
	        }
	       
	    }
	}


	
//	public static void writeDataToExcel(String sheetName, int rowNum, String username, String password)throws IOException {
//		
//		File file = new File(filePath);
//		Workbook workbook;
//		Sheet sheet;
//		
//		// If file exists, load it; otherwise create a new workbook	
//		if(file.exists()) {
//			try(FileInputStream inputStream = new FileInputStream(file)){
//				workbook = new XSSFWorkbook(inputStream);
//			}
//		}else {
//			workbook = new XSSFWorkbook();
//		}
//		
//		// Create sheet if it doesn't exist
//		sheet = workbook.getSheet(sheetName);
//		if(sheet == null) {
//			sheet = workbook.createSheet();
//		}
//		
//		// Create or update row
//		Row row = sheet.getRow(rowNum);
//		if(row == null) {
//			row = sheet.createRow(rowNum);
//		}
//		
//		// Write username and password to cells	
//		row.createCell(0).setCellValue(username);
//		row.createCell(1).setCellValue(password);
//		
//		 // Write changes back to the file
//		try(FileOutputStream outputStream = new FileOutputStream(file)){
//			workbook.write(outputStream);
//		}
//		workbook.close();
//		System.out.println("Data written to Excel: " + username + " | " + password);
//	}
//
//}
	
	public static void writeDataToExcel(String sheetName, int rowNum, String username, String password) throws IOException {
	    File file = new File(filePath);
	    Workbook workbook;
	    Sheet sheet;

	    if (file.exists()) {
	        try (FileInputStream inputStream = new FileInputStream(file)) {
	            workbook = new XSSFWorkbook(inputStream);
	        }
	    } else {
	        workbook = new XSSFWorkbook();
	    }

	    // Create sheet if it doesn't exist
	    sheet = workbook.getSheet(sheetName);
	    if (sheet == null) {
	        sheet = workbook.createSheet(sheetName); // Ensure sheet name is not null
	    }

	    // Create or update row
	    Row row = sheet.getRow(rowNum);
	    if (row == null) {
	        row = sheet.createRow(rowNum);
	    }

	    // Write username and password to cells
	    row.createCell(0).setCellValue(username);
	    row.createCell(1).setCellValue(password);

	    // Write changes back to the file
	    try (FileOutputStream outputStream = new FileOutputStream(file)) {
	        workbook.write(outputStream);
	    }
	    workbook.close();

	    System.out.println("Data written to Excel: " + username + " | " + password);
	}
}
