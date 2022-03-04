import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Given a csv file of cookies and timestamps, this program will display the most active cookie for a specified day.
 */
public class most_active_cookie {
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> cookieCount = cookieCount(args[0], args[2]);
        int maxCount = maxCount(cookieCount);

        for(String key : cookieCount.keySet()) {
            if(cookieCount.get(key) == maxCount) {
                System.out.println(key);
            }
        }
    }

    /**
     * Gets the count of the occurrence of each cookie on the specified input date
     * @param fileName The file to be read. Expecting a file in .csv format
     * @param inputDate The date provided from the command line in format (YYYY-MM-DD)
     * @return A hashmap containing the count of each cookie on the specified input date
     * @throws FileNotFoundException
     */
    public static Map<String, Integer> cookieCount(String fileName, String inputDate) throws FileNotFoundException {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);
        sc.nextLine();

        Map<String, Integer> cookieCount = new HashMap<>();
        while(sc.hasNext()) {
            String line = sc.nextLine();
            if(most_active_cookie.getDate(line).equals(inputDate)) {
                cookieCount.put(most_active_cookie.getCookie(line), cookieCount.getOrDefault(most_active_cookie.getCookie(line), 0) + 1);
            }
            // Since cookies are sorted in descending fashion, we do not need to check anymore dates
            else if(most_active_cookie.getDate(line).compareTo(inputDate) < 0) {
                return cookieCount;
            }
        }
        return cookieCount;
    }

    public static int maxCount(Map<String, Integer> map) {
        int maxCount = Integer.MIN_VALUE;
        for(Integer val : map.values()) {
            maxCount = Math.max(maxCount, val);
        }
        return maxCount;
    }

    public static String getDate(String line) {
        if(line.length() != 43) {
            return null;
        }
        return line.substring(17,27);
    }

    public static String getCookie(String line) {
        if(line.length() != 43) {
            return null;
        }
        return line.substring(0,16);
    }
}

