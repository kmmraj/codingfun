package com.test.strings;

public class ExcelTitle2Number {
    public int titleToNumber(String columnTitle) {
        int result =0, carry =0,multiply =1;
        for(int idx=columnTitle.length()-1; idx>=0;idx--){
            int temp = (int)columnTitle.charAt(idx) - 'A' + 1;
            int colVal = temp%26 == 0 ? 26: temp%26;
            // System.out.println(" columnTitle.charAt(idx) is " + columnTitle.charAt(idx) + " temp is " +temp);
            result = result + (multiply * colVal);
            //  System.out.println(" result is "+result);
            multiply = multiply*26;
            //  System.out.println("multiply is "+multiply);
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelTitle2Number excelTitle2Number = new ExcelTitle2Number();
        System.out.println("expected is 1, actual for excelTitle2Number.titleToNumber(\"A\")  = "
                + excelTitle2Number.titleToNumber("A"));
        System.out.println("expected is 28, actual for excelTitle2Number.titleToNumber(\"AB\")  = "
                + excelTitle2Number.titleToNumber("AB"));
        System.out.println("expected is 701, actual for excelTitle2Number.titleToNumber(\"ZY\")  = "
                + excelTitle2Number.titleToNumber("ZY"));
        System.out.println("expected is 2147483647, actual for excelTitle2Number.titleToNumber(\"FXSHRXW\")  = "
                + excelTitle2Number.titleToNumber("FXSHRXW"));
    }
}
