package com.shishakalex;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Дана строка (возможно, пустая), состоящая из букв A-Z:
 * AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
 * Нужно написать функцию RLE, которая на выходе даст строку вида:
 * A4B3C2XYZD4E3F3A6B28
 *
 * Пояснения:
 * Если символ встречается 1 раз, он остается без изменений;
 * Если символ повторяется более 1 раза, к нему добавляется количество повторений.
 */

public class LettersConsecutiveCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();

        System.out.println(transformString(inputString));
    }

    public static String transformString(String inputString){
        if(inputString == null || !inputString.matches("[A-Z]*")){
            throw new IllegalArgumentException("Not valid input string");
        }
        if(inputString.isEmpty()){
            return inputString;
        }

        int counter = 1;

        StringBuilder strBuilder = new StringBuilder();

        char[] letters = inputString.toCharArray();
        if(inputString.length() <= 1){
            return inputString;
        }
        char currentLetter = letters[0];

        for(int i = 1; i < letters.length; i++){
            if(i == letters.length - 2){
                if(letters[i] == letters[i+1]){
                    counter += 2;
                    strBuilder.append(currentLetter);
                    strBuilder.append(counter);
                    break;
                }
                else{
                    counter++;
                    strBuilder.append(currentLetter);
                    strBuilder.append(counter);
                    strBuilder.append(letters[i+1]);
                    break;
                }
            }
            if(letters[i] == currentLetter){
                counter++;
                continue;
            }
            else{
                strBuilder.append(currentLetter);
                if(counter > 1){
                    strBuilder.append(counter);
                }
                currentLetter = letters[i];
                counter = 1;
            }

        }
        return strBuilder.toString();
    }
}
