package com.karpunets.excel;

import com.karpunets.excel.elements.Graphics;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author Karpunets
 * @since 24.11.2016
 */

public class Manager {

    /**
     * Method creates xlsx file.
     *
     * @param url      where to create file.
     * @param dataTest object {@link DataTest} with information about testing
     */
    public static void createXML(String url, DataTest dataTest) {
        Graphics graphics;
        XSSFWorkbook workbook = new XSSFWorkbook();
        for (int pages = 0; pages < dataTest.getNamesFillers().size(); pages++) {
            XSSFSheet sheet = workbook.createSheet(dataTest.getNamesFillers().get(pages));
            int rowNum = 0;
            int cellNum = 1;
            XSSFRow row = sheet.createRow(rowNum++);
            for (int i = 0; i < dataTest.getRepetition(); i++) {
                row.createCell(cellNum++).setCellValue(dataTest.getMinArrayLength() + dataTest.getDifference() * i);
            }
            for (int sortNum = 0; sortNum < dataTest.getNamesSortClasses().size(); sortNum++) {
                cellNum = 0;
                row = sheet.createRow(rowNum++);
                row.createCell(cellNum++).setCellValue(dataTest.getNamesSortClasses().get(sortNum));
                for (int timeNum = 0; timeNum < dataTest.getMeterage()[pages][sortNum].length; timeNum++) {
                    row.createCell(cellNum++).setCellValue(dataTest.getMeterage()[pages][sortNum][timeNum]);
                }
            }
            graphics = new Graphics(0, ++rowNum, 15, rowNum + 15);
            graphics.draw(sheet, dataTest.getNamesSortClasses(), dataTest.getRepetition());
        }
        try (FileOutputStream out = new FileOutputStream(new File(url))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

}
