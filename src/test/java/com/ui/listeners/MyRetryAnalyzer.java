package com.ui.listeners;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import javax.swing.text.Utilities;

public class MyRetryAnalyzer implements IRetryAnalyzer{
    //from properties file
    //private static final int MAX_NUMBER_OF_ATTEMPT = Integer.parseInt(PropertiesUtil.readProperty(Env.QA,"MAX_NUMBER_OF_ATTEMPT"));

    //from Json file
    private static final int MAX_NUMBER_OF_ATTEMPT = JSONUtility.readJSON(Env.QA).getMax_number_of_attempts();

    private static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentAttempt<=MAX_NUMBER_OF_ATTEMPT){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
