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
		System.out.println(System.getProperty("user.dir"));
		String testcasefile = ReadProperties.readConfig().getProperty("testcases");
		System.out.println(testcasefile);
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
	public void writeResult(String TcId,int result) throws EncryptedDocumentException, IOException {
		String tcFile=ReadProperties.readConfig().getProperty("testcases");
    	File file=new File(System.getProperty("user.dir")+tcFile);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Testcases");
		int numOfRows = sheet.getLastRowNum();
		for(int i=1;i<=numOfRows;i++) {
			if(sheet.getRow(i).getCell(0).getStringCellValue().equalsIgnoreCase(TcId))
			{	
				switch(result) {
				case 1:
					sheet.getRow(i).createCell(5).setCellValue("Pass");
					//sheet.getRow(i).getCell(5).setCellValue("PASS");
			        break;
				case 2:
					//sheet.getRow(i).getCell(3).setCellValue("FAIL");
					sheet.getRow(i).createCell(5).setCellValue("Fail");
			        break;
				case 3:
					sheet.getRow(i).getCell(5).setCellValue("SKIP");
			        break;
				default :
					break;
			        }
				}
			}
		FileOutputStream fos;
			try{
				 fos = new FileOutputStream(file);
			}catch(FileNotFoundException e) {
				fis.close();
				fos = new FileOutputStream(file);
			}	
			workbook.write(fos);
			fos.close();
			workbook.close();
		}
}
