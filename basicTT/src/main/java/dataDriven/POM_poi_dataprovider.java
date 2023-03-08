package dataDriven;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class POM_poi_dataprovider {
	
	@DataProvider(name = "loginData")
	public String[][] getData() throws Exception {
		
		File excelfile = new File("D:\\drive\\selenium excel files\\excelPOI.xlsx");
		FileInputStream fis = new FileInputStream(excelfile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String [noOfRows-1][noOfColumns];
		
		for (int i = 0; i < noOfRows-1; i++) {
		    for (int j = 0; j < noOfColumns ; j++) {
		    	DataFormatter df = new DataFormatter();
		    	data [i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
		         
		    }
		}
		
		workbook.close();
		fis.close();
		
		return data;
		
	}

}
