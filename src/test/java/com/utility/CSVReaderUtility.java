package com.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CSVReaderUtility {
    public static Iterator<User> readCSVFile(String fileName)  {
        File csvFile = new File(System.getProperty("user.dir") + "\\testData\\" + fileName);
        FileReader fileReader;
        CSVReader csvReader;
        String[] csvLine;
        List<User> userList=null;
        User userData;
        try {
            fileReader = new FileReader(csvFile);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();   // row1 - reading column names, added to just skip the first line which is column names

            userList = new ArrayList<User>();
            while((csvLine = csvReader.readNext())!=null){
                userData = new User(csvLine[0],csvLine[1]);
                 userList.add(userData);
            }
            for(User user:userList){
                System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
         catch (CsvValidationException | IOException e) {
            e.printStackTrace();
        }
        return userList.iterator();
    }
}