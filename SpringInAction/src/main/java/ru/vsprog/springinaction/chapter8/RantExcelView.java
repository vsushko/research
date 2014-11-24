package ru.vsprog.springinaction.chapter8;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import java.util.Collection;
import java.util.Map;

/**
 * Created by vsa
 * Date: 24.11.14.
 */
public class RantExcelView extends AbstractExcelView {

    @Override
    protected void buildExcelDocument(Map<String,
            Object> stringObjectMap, HSSFWorkbook hssfWorkbook,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) throws Exception {

        Collection rants = (Collection) model.get("rants");
//        Vehicle


    }
}
