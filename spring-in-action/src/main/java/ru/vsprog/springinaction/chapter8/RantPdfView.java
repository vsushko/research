package ru.vsprog.springinaction.chapter8;

import com.lowagie.text.Table;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by vsa
 * Date: 25.11.2014.
 */
public class RantPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    com.lowagie.text.Document document,
                                    com.lowagie.text.pdf.PdfWriter pdfWriter,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {
        List rants = (List) model.get("rants");
        Table rantTable = new Table(4);
        rantTable.setWidth(90);
        rantTable.setBorderWidth(1);

        rantTable.addCell("State");
        rantTable.addCell("Plate");
        rantTable.addCell("Date Posted");
        rantTable.addCell("Text");

        for (Iterator iter = rants.iterator(); iter.hasNext(); ) {
            Rant rant = (Rant) iter.next();

            rantTable.addCell(rant.getVehicle().getState());
            rantTable.addCell(rant.getVehicle().getPlateNumber);
            rantTable.addCell(String.valueOf(rant.getPostedDate()));
            rantTable.addCell(rant.getVehicle().getState());
            rantTable.addCell(rant.getRantText());
        }

        document.add(rantTable);
    }
}
