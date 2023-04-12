package com.unizik.schoolunizik.util;

public class Verification {

    // private static final Pattern emailRegex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public  static boolean validPhone_no(final String number) {
        String trimmedNumber = number.trim();
        String formattedNumber = null;
        if (trimmedNumber.startsWith("0"))
            formattedNumber = "+234" + trimmedNumber.substring(1);
        else if (trimmedNumber.startsWith("234"))
            formattedNumber = "+" + number;
        else if (!number.startsWith("+")
                && Integer.parseInt(String.valueOf(number.charAt(0))) > 0) {
            formattedNumber = "+234" + number;
        }
        return Boolean.parseBoolean(formattedNumber);

    }
}

