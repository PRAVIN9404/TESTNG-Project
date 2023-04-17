package Firest.TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 ExcelFile e=new  ExcelFile();
		 e.file();
	}
	@Test
	public void file() throws IOException
	{
		File f=new File("C:\\Users\\LA PC MASTER\\Desktop\\Book1.xlsx");
		
		FileInputStream fread=new FileInputStream(f);
		
		try (XSSFWorkbook e = new XSSFWorkbook(fread)) {
			XSSFSheet sheet=e.getSheet("TEST");
			
			int totalrow=sheet.getPhysicalNumberOfRows();
			System.out.println(totalrow);
			XSSFRow cell=sheet.getRow(0);
			int totalcell=cell.getPhysicalNumberOfCells();
			System.out.println(totalcell);
			DataFormatter d=new DataFormatter();
			
			 String testdata[][]=new String[totalrow][totalcell];
			 for(int i=0;i<totalrow;i++)
			 {
				 for(int j=0;j<totalcell;j++)
				 {
					testdata[i][j]=d.formatCellValue(sheet.getRow(i).getCell(j));
					System.out.println(testdata);
				 }
			 }
		}
		
	}

}
