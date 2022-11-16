package seleniumcourse;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static  String[][] fetchData(String filename, int sheetno) throws IOException {
		
		XSSFWorkbook book=new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheetAt = book.getSheetAt(sheetno);
		XSSFRow row = sheetAt.getRow(0);
		int rowcount = sheetAt.getLastRowNum();	
		int columncount = row.getLastCellNum();
		
		String[][] data=new String[rowcount][columncount];
		
		for(int i=1; i<=rowcount; i++ ) {
			for(int j=0; j<columncount; j++) {
				String allvalues = sheetAt.getRow(i).getCell(j).getStringCellValue();
				data[i-1][j]=allvalues;
			}
		}
		
		book.close();
		return data;
	}
}