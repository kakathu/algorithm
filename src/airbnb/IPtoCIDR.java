package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IPtoCIDR {
    public static void main(String[] args) {
        // 192.168.1.0, 5
        String ip = "192.168.1.0";
        int n = 5;
        long start = ipToLong(ip);
        List<String> result = new ArrayList<>();
        while(n > 0) {
            long count = start & -start;
            while(count > n)
                count /= 2;
            result.add(longToIP2(start, count));
            n -= count;
            start += count;
        }
        for(String res : result) {
            System.out.println(res);
        }
    }

    private static String longToIP(long ipLong, long count) {
        String[] ips = new String[4];
        for(int i = 3; i >= 0; i--) {
            ips[i] = String.valueOf(ipLong % 256);
            ipLong = ipLong / 256;
        }
        String result = String.join(".", ips);
        int mask = 32;
        while(count/2 > 0) {
            mask--;
            count /= 2;
        }
        return result + '/' + mask;
    }

    private static String longToIP2(long l, long count) {
        long[] ips = new long[4];
        for(int i = 0; i < 4; i++) {
            int offset = 8 * (3 - i);
            ips[i] = (l >> offset) & 255;
        }
        int bitCount = 0;
        while(count / 2 > 0) {
            bitCount++;
            count = count / 2;
        }
        return ips[0] + "." + ips[1] + "." + ips[2] + "." + ips[3] + "/" + (32 - bitCount);
    }

    // 192.168.1.0 -> 192*256*256*256+168*256*256+1*256+0
    private static long ipToLong(String ip) {
        long ret = 0;
        String[] segments = ip.split("\\.");
        for(String seg : segments) {
            ret = ret * 256 + Long.parseLong(seg);
        }
        return ret;
    }

}
