package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class ExcelTest {

    @Test
    public void readExcelData() throws IOException {

        ExcelUtility.loadExcel(
                "src/resources/testdata.xlsx",
                "Sheet1"
        );

        String email =
                ExcelUtility.getCellData(1, 0);

        String password =
                ExcelUtility.getCellData(1, 1);

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        ExcelUtility.closeExcel();
    }
}