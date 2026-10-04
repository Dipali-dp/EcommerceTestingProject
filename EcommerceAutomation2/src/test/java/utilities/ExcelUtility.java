package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file
    public static void loadExcel(String filePath, String sheetName)
            throws IOException {

        FileInputStream file =
                new FileInputStream(filePath);

        workbook = new XSSFWorkbook(file);

        sheet = workbook.getSheet(sheetName);

        file.close();
    }

    // Read cell data
    public static String getCellData(
            int rowNumber,
            int columnNumber) {

        Row row = sheet.getRow(rowNumber);

        Cell cell = row.getCell(columnNumber);

        return cell.toString();
    }

    // Get total rows
    public static int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }

    // Get total columns
    public static int getColumnCount() {

        return sheet
                .getRow(0)
                .getPhysicalNumberOfCells();
    }

    // Close Excel
    public static void closeExcel()
            throws IOException {

        if (workbook != null) {
            workbook.close();
        }
    }
}