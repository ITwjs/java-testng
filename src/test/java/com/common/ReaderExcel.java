package com.common;

public class ReaderExcel {
    private static String excelName = "testcase.xlsx" ;
    private static String sheetName = "login";

    public String getSheetName() {
        return sheetName;
    }
    public void setSheetName(String sheetName) {
        this.sheetName = sheetName;
    }
    public String getExcelName() {
        return excelName;
    }
    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public static void main(String[] args) {

    }
}
