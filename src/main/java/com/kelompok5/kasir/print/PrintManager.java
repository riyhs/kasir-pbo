package com.kelompok5.kasir.print;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

public class PrintManager {
    private static PrintManager instance;

    private JasperReport reportPay;
    private JasperReport reportInvoice;

    public static PrintManager getInstance() {
        if (instance == null) {
            instance = new PrintManager();
        }
        return instance;
    }

    private PrintManager() {
    }

    public void compileReport() throws JRException {
        String path = "/print_template.jrxml";
        reportPay = JasperCompileManager.compileReport(getClass().getResourceAsStream(path));
    }

    public void printReportPayment(ParameterReportPayment data) throws JRException {
        Map para = new HashMap();
        para.put("total", data.getTotal());
        para.put("date", data.getDate());

        System.out.println(para.get("total"));
        System.out.println(para.get("date"));

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());

        System.out.println(data.getFields().size());

        JasperPrint print = JasperFillManager.fillReport(reportPay, para, dataSource);
        view(print);
    }

    private void view(JasperPrint print) throws JRException {
        JasperViewer.viewReport(print, false);
    }
}
