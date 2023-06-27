package testDataClasses;

import browser.DriverFactory;
import com.github.javafaker.Faker;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelWriter {


   static int rowCount;
   static int cellCount;
    static Object [][] obj;
    public static void write() {

        FileInputStream fileStream;
        FileOutputStream outputStream;
        Workbook usersData;
        Sheet sheet1;
        Faker faker= new Faker();
        ArrayList<String> value=new ArrayList<String>();
        try {
            fileStream = new FileInputStream(DriverFactory.propsConfig().getProperty("dataPath"));
            usersData = new XSSFWorkbook(fileStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        sheet1=usersData.getSheet("regestration");
        int cellCount = sheet1.getRow(0).getLastCellNum();
        for(int i=2;i<5;i++){
            sheet1.createRow(i);
            Row newRow=sheet1.getRow(i);
            for(int j=0;j<cellCount;j++){
                newRow.createCell(j).setCellValue(faker.name().title());
            }
        }
        try {
            outputStream = new FileOutputStream(DriverFactory.propsConfig().getProperty("dataPath"));
            usersData.write(outputStream);
            usersData.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        write();
    }

}
