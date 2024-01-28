package com.test.strings;

public class ExcelConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber!=0){
            //char charValue = (char)((columnNumber%26) + 'A'-1);// - 1;
            int carry = columnNumber%26;
            columnNumber = columnNumber/26;
            char charValue;
            if(carry!=0 ){
                charValue = (char)(carry + 'A' -1 );// - 1;
            } else{
                charValue = 'Z';
                columnNumber = columnNumber-1;
            }
            // System.out.println("charValue is "+charValue + " columnNumber is " + columnNumber);
            sb.append(charValue);

        }
        // System.out.println("
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        ExcelConvertToTitle excelConvertToTitle = new ExcelConvertToTitle();
        System.out.println("expected is A, actual for excelConvertToTitle.convertToTitle(1)  = "
                + excelConvertToTitle.convertToTitle(1));
        System.out.println("expected is AB, actual for excelConvertToTitle.convertToTitle(28)  = "
                + excelConvertToTitle.convertToTitle(28));
        System.out.println("expected is Z, actual for excelConvertToTitle.convertToTitle(26)  = "
                + excelConvertToTitle.convertToTitle(26));
        System.out.println("expected is AA, actual for excelConvertToTitle.convertToTitle(27)  = "
                + excelConvertToTitle.convertToTitle(27));
        System.out.println("expected is AZ, actual for excelConvertToTitle.convertToTitle(52)  = "
                + excelConvertToTitle.convertToTitle(52));
        System.out.println("expected is BA, actual for excelConvertToTitle.convertToTitle(53)  = "
                + excelConvertToTitle.convertToTitle(53));

    }
}
