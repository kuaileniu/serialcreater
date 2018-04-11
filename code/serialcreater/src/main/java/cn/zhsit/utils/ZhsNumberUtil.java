package cn.zhsit.utils;

public class ZhsNumberUtil {

    /**
     * @param bitNum 位数，不足的前面补零
     * @param n
     * @return
     */
    public static String getBitNum(int bitNum, long n) {
        String nStr = Long.toString(n);
        int sStrLen = nStr.length();
        if (sStrLen >= bitNum) {
            return nStr;
        }
        int cha = bitNum - sStrLen;
        String zr = "";
        for (int i = 0; i < cha; i++) {
            zr += "0";
        }
        return zr + nStr;
    }

    /**
     * @param bitNum 位数，不足的前面补零
     * @return
     */
    public static String getBitNum(int bitNum, String num) {
        int numLen = num.length();
        if (numLen >= bitNum) {
            return num;
        }
        int cha = bitNum - numLen;
        String zr = "";
        for (int i = 0; i < cha; i++) {
            zr += "0";
        }
        return zr + num;
    }

    /**
     * 不多于比较的位数
     *
     * @param bitNum
     * @param n
     * @return true, 不多于bitNum位；
     */
    public static boolean noMoreThanBitNum(int bitNum, long n) {
        return Long.toString(n).length() <= bitNum ? true : false;
    }

    public static boolean noMoreThanBitNum(int bitNum, String num) {
        return num.length() <= bitNum ? true : false;
    }
}
