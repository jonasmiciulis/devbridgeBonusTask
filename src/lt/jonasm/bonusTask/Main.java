package lt.jonasm.bonusTask;

public class Main {

    static int MAX_VALID_YEAR = 9999;
    static int MIN_VALID_YEAR = 1000;

    static boolean checkIfLeapYear(int year)
    {
        return (((year % 4 == 0)
                && (year % 100 != 0))
                || (year % 400 == 0));
    }

    static boolean isDateValid(int y, int m, int d)
    {
        if (y < MIN_VALID_YEAR || y > MAX_VALID_YEAR)
            return false;
        if (m < 1 || m > 12)
            return false;
        if (d < 1 || d > 31)
            return false;

        if (m == 4 || m == 6 || m == 9 || m == 11)
            return (d <= 30);

        if (m == 2)
        {
            if (checkIfLeapYear(y))
                return (d <= 29);
            else
                return (d <= 28);
        }

        return true;
    }

    static void printBonusDatesBetween(int fromYear, int toYear)
    {
        for (int y = fromYear; y < toYear; y++)
        {
            String year = String.valueOf(y);
            String rev = reverseYear(year);

            int m = Integer.parseInt(rev.substring(0, 2));
            int d = Integer.parseInt(rev.substring(2, 4));

            if (isDateValid(y, m, d))
            {
                String month;
                String day;

                if (String.valueOf(m).length() == 1) {
                    month = "0" + m;
                } else {
                    month = String.valueOf(m);
                }

                if (String.valueOf(d).length() == 1) {
                    day = "0" + d;
                } else {
                    day = String.valueOf(d);
                }

                String palindromeDate = year + "-" + month + "-" + day;
                System.out.print(palindromeDate + "\n");
            }
        }
    }

    static String reverseYear(String year)
    {
        char[] a = year.toCharArray();
        int l, r = a.length - 1;
        for (l = 0; l < r; l++, r--)
        {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    public static void main(String[] args)
    {
        printBonusDatesBetween(2010, 2015);
    }
}
