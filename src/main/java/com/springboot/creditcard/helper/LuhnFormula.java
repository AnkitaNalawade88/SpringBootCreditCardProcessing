package com.springboot.creditcard.helper;

import javax.persistence.Entity;
import java.util.Arrays;

public class LuhnFormula {

    public boolean validate(String input) {
        char[] chars = convertToArrayOfValidChars(input.trim());
        return getSum(chars) % 10 == 0;
    }

    private char[] convertToArrayOfValidChars(String input) {
        String sanitized = input.replaceAll("[^\\d]", "");
        return sanitized.toCharArray();
    }

    private int getSum(char[] chars) {
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            int number = getInReverseOrder(chars, i);
            sum += getElementValue(i, number);
        }
        return sum;
    }


    private int getInReverseOrder(char[] chars, int i) {
        int indexInReverseOrder = chars.length - 1 - i;
        char character = chars[indexInReverseOrder];
        return Character.getNumericValue(character);
    }

    private int getElementValue(int i, int number) {
        if (i % 2 != 0) {
            return getOddElementValue(number);
        } else {
            return number;
        }
    }

    private int getOddElementValue(int element) {
        int value = element * 2;
        if (value <= 9) {
            return value;
        }
        return value - 9;
    }



    //-------------------------------------------------------------------

   /*
    public boolean isValidCCNumber(String cardNumber)
    {

        // int array for processing the cardNumber
        int[] cardIntArray=new int[cardNumber.length()];

        for(int i=0;i<cardNumber.length();i++)
        {
            char c= cardNumber.charAt(i);
            cardIntArray[i]=  Integer.parseInt(""+c);
        }

        for(int i=cardIntArray.length-2;i>=0;i=i-2)
        {
            int num = cardIntArray[i];
            num = num * 2;  // step 1
            if(num>9)
            {
                num = num%10 + num/10;  // step 2
            }
            cardIntArray[i]=num;
        }

        int sum = sumDigits(cardIntArray);  // step 3

        System.out.println(sum);

        if(sum%10==0)  // step 4
        {
            return true;
        }
        return false;
    }

    private static int sumDigits(int[] arr)
    {
        return Arrays.stream(arr).sum();
    }

*/


}
