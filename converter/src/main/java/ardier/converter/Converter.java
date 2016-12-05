package ardier.converter;

/**
 * Created by Максим on 02.12.2016.
 */

public class Converter {

    public Converter() {

    }

    public String ConvertToDec(String num, int sys) {
        double res = 0;
        num = num.toLowerCase();

        if (num.contains("."))
        {
            String[] arr = num.split("\\.");

            for (int i = 0; i < arr[0].length(); i++)
            {
                res += (long)(GetHexNum(String.valueOf(arr[0].charAt(arr[0].length() - i - 1))) * Math.pow(sys, i));
            }

            for (int i = 0; i < arr[1].length(); i++)
            {
                res += (GetHexNum(String.valueOf(arr[1].charAt(i))) * Math.pow(sys, -1 - i));
            }
        }
        else
        {
            for (int i = 0; i < num.length(); i++)
            {
                res += (long)(GetHexNum(String.valueOf(num.charAt(num.length() - i - 1))) * Math.pow(sys, i));
            }
        }

        return String.valueOf(res);
    }

    public String ConvertFromDec(String num, int sys) {
        double n = Double.parseDouble(num);
        String res = "";

        if (num.contains("."))
        {
            String[] arr = num.split("\\.");
            int m = (int)n;
            n = n - m;

            while (m > 0)
            {
                res += String.valueOf(SetHexNum(m % sys));
                m = (m - m % sys) / sys;
            }

            if (res == "")
                res += "0";

            res = ReverseString(res) + ".";

            for (int i = 0; i < 8; i++)
            {
                double t = n * sys;
                res += String.valueOf(SetHexNum((int)t));
                n = t - (long)t;

                if (n == 0)
                    break;
            }

        }
        else
        {
            while (n > 0)
            {
                res += SetHexNum((int)n % sys);
                n = (n - n % sys) / sys;
            }

            String s = ReverseString(res);

            if (s.endsWith(".0"))
                s = s.substring(0, s.length() - 2);

            return s;
        }

        if (res.endsWith(".0"))
            res = res.substring(0, res.length() - 2);

        return res;
    }

    public long GetHexNum(String c) {
        try
        {
            switch (c)
            {
                case "a": return 10;
                case "b": return 11;
                case "c": return 12;
                case "d": return 13;
                case "e": return 14;
                case "f": return 15;
                default: return Integer.parseInt(c);
            }
        }
        catch(Exception ex)
        {
            return -1;
        }
    }

    public String SetHexNum(int c) {
        switch (c)
        {
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            default: return String.valueOf(c);
        }
    }

    public String ReverseString(String s) {
        String res = "";

        for (int i = 0; i < s.length(); i++)
        {
            res += s.charAt(s.length() - i - 1);
        }

        return res;
    }
}
