package helpers;

import PageObjects.CheckoutPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class excelhelper {
    private static final Logger mylogger = LogManager.getLogger(excelhelper.class);

    public HashMap<String, String> readexcel(String filename) throws IOException {
        FileInputStream file = new FileInputStream(new File(filename));


        XSSFWorkbook wb = new XSSFWorkbook(file);

        XSSFSheet sh = wb.getSheetAt(0);


        // write to hashmap
        HashMap<String, String> map
                = new HashMap<String, String>();
        String value ="";
        for (int r = 0; r <= sh.getLastRowNum(); r++) {
            mylogger.debug("Row Number"+r);
            String key = sh.getRow(r)
                    .getCell(0)
                    .getStringCellValue();
            if (CellType.NUMERIC == sh.getRow(r)
                    .getCell(1).getCellType()){
                value = String.valueOf(sh.getRow(r)
                        .getCell(1).getNumericCellValue());

            }
            else
            {
                value = String.valueOf(sh.getRow(r)
                        .getCell(1).getStringCellValue());
            }

            map.put(key, value);
        }

        // Displaying HashMap
        Iterator<Map.Entry<String, String>> new_Iterator
                = map.entrySet().iterator();

        while (new_Iterator.hasNext()) {
            Map.Entry<String, String> new_Map
                    = (Map.Entry<String, String>)
                    new_Iterator.next();

            mylogger.debug(new_Map.getKey() + "|"
                    + new_Map.getValue());
        }
        wb.close();
        file.close();
        return map;
    }
}
