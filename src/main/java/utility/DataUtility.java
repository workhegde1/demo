package main.java.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class DataUtility {
	public DataUtility() {
	}
	public String getData(String testCase) throws EncryptedDocumentException, IOException {
		String testcasefile = ReadProperties.readConfig().getProperty("testcases");
		File file = new File(System.getProperty("user.dir")+testcasefile);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("Testcases");
		int rowNum = sheet.getLastRowNum();
		for (int i = 0; i < rowNum; i++) {
			if (sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(testCase)) {
				return sheet.getRow(i).getCell(2).getStringCellValue();
			}
		}
		workbook.close();
		return null;
	}
}
