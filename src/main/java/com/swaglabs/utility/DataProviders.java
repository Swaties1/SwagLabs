package com.swaglabs.utility;
import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return ExcelReader.getSheetData("Login");
    }
}