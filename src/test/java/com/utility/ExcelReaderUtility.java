package com.utility;

import com.ui.pojo.User;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReaderUtility {
    public static Iterator<User> readExcelFile(String fileName) {
        File xlsxfile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
        //to read xlsx file use XSSWorkbook class
        XSSFWorkbook xssfWorkbook = null;
        XSSFSheet xssfSheet = null;
        List<User> userList = null;
        Iterator<Row> rowIterator;
        Row row;
        Cell emailAddressCell;
        Cell passwordCell;
        User user;
        try {
            xssfWorkbook = new XSSFWorkbook(xlsxfile);
            xssfSheet = xssfWorkbook.getSheet("LoginTestData");
            userList = new ArrayList<User>();
            rowIterator = xssfSheet.iterator();
            rowIterator.next();     //Skipping the column , as it contains column headers and data starts from next row
            while (rowIterator.hasNext()) {
                row = rowIterator.next();
                /* Code to loop through columns
                int i = 0;
                while (i <= row.getLastCellNum()) {
                    Cell celli = row.getCell(i);
                    System.out.println(celli);
                    i++;
                }*/
                emailAddressCell = row.getCell(0);
                passwordCell = row.getCell(1);
                user = new User(emailAddressCell.toString(), passwordCell.toString());
                userList.add(user);
            }
            xssfWorkbook.close();
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }
        return userList.iterator();
    }
}
