package testDataClasses;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataProviderClass {


    @DataProvider (name = "dataprovider")
    public static Object[][] dpMethod() {
        Workbook workbook;
        try {
            FileInputStream filePath = new FileInputStream("C:\\Bilal\\paraBankDemo\\xlFiles\\Book1.xlsx");
            workbook=new XSSFWorkbook(filePath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Sheet sheet=workbook.getSheet("regestration");
        Row row =sheet.getRow(1);
        int rowCount = sheet.getPhysicalNumberOfRows();
        int columCount = row.getLastCellNum();
        Object[][] data=new Object[rowCount-1][columCount];
        for(int i=0; i<rowCount-1; i++){
            for (int j=0;j<columCount;j++){
                data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
            }
        }

        return data;
    }

    public static void main(String[] args) {
       Object[][] obj= dpMethod();
        System.out.println(obj[0][0]);
    }

}
