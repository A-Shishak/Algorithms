/**
 * Hackerrank
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 *
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 *
 * Inputs are in correct format
 *
 * Example
 * s = 12:01:00PM
 * Return '12:01:00'.
 * s = 12:01:00AM
 * Return '00:01:00'.
 */


package com.shishakalex;

import java.io.*;

public class TimeConversion {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String s = bufferedReader.readLine();

        String result = TimeConversion.timeConversion(s);

        System.out.println(result);

        bufferedReader.close();
    }

        public static String timeConversion(String s) {
            String[] temps = s.split(":");
            int hh, mm, ss;
            hh = Integer.parseInt(temps[0]);
            mm = Integer.parseInt(temps[1]);
            ss = Integer.parseInt(temps[2].substring(0, 2));

            String aMPM = temps[2].substring(2, 4);
            if (aMPM.equals("AM") && hh == 12){
                hh = 0;
            }
            else if (aMPM.equals("PM") && hh != 12){
                hh += 12;
            }
            return String.format("%02d:%02d:%02d",hh, mm, ss);
        }
}

