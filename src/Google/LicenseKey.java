package Google;

/**
 * Created by shiyanch on 11/21/16.
 */
public class LicenseKey {
    public String licenseKey(String str, int k) {
        str = str.toUpperCase().replaceAll("-", "");
        if (str.length() == 0) {
            return str;
        }
        int start = str.length() % k;
        StringBuilder sb = new StringBuilder();
        if (start != 0) {
            sb.append(str.substring(0, start)+"-");
        }
        while (start <= str.length() - k) {
            sb.append(str.substring(start, start + k));
            sb.append("-");

            start += k;
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new LicenseKey().licenseKey("---", 3));
    }
}
