package ru.vsprog.springinaction.chapter8;

import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by vsa
 * Date: 24.11.14.
 */
public class RantExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String,
            Object> model, HSSFWorkbook workbook,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        Collection rants = (Collection) model.get("rants");
        Vehicle vehicle = (Vehicle) model.get("vehicle");

        HSSFSheet sheet = createSheet(workbook, vehicle.getPlateNumber());

        HSSFCellStyle cellStyle = workbook.createCellStyle();
        // Установка формата даты
        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));

        int rowNum = 1;
        for (Iterator iter = rants.iterator(); iter.hasNext(); ) {
            Rant rant = (Rant) iter.next();
            rowNum = addRantRow(sheet, cellStyle, rowNum, rant);
        }
    }

    private int addRantRow(HSSFSheet sheet, HSSFCellStyle cellStyle, int rowNum, Rant rant) {
        HSSFRow row = sheet.createRow(rowNum++);
        row.createCell((short) 0).setCellValue(rant.getPostedDate());
        row.createCell((short) 1).setCellValue(rant.getPostedDate());
        row.getCell((short) 1).setCellStyle(cellStyle);
        return rowNum;
    }

    private HSSFSheet createSheet(HSSFWorkbook workbook, String plateNumber) {
        HSSFSheet sheet = workbook.createSheet("Rants for " + plateNumber);

        // добавление строки
        HSSFRow header = sheet.createRow(0);
        // создание заголовка
        header.createCell((short) 0).setCellValue("Date");
        header.createCell((short) 1).setCellValue("Text");

        return sheet;
    }
}
