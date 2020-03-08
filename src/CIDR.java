import java.util.ArrayList;
import java.util.List;

class CIDRSolution {
    public List<String> ipToCIDR(String ip, int range) {
        long x = ipToLong(ip);
        List<String> list = new ArrayList<>();
        while (range > 0) {
            long count = x & -x;
            while(count > range) {
                count = count / 2;
            }
            list.add(longToIP(x, count));
            x += count;
            range -= count;
        }
        return list;
    }

    // 10.1.5.9
    public long ipToLong(String ip) {
        String[] ips = ip.split("\\.");
        long sum = 0;
        for(int i = 0; i < ips.length; i++) {
            sum = sum*256 + Integer.parseInt(ips[i]);
        }
        return sum;
    }

    public String longToIP(long l, long count) {
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
}

public class CIDR {
    public static void main(String[] args) {
        CIDRSolution solution = new CIDRSolution();
        long sum = solution.ipToLong("192.168.1.0");
        System.out.println(sum);
//        System.out.println(solution.longToIP(sum, 2));
//        List<String> list = solution.ipToCIDR("10.1.5.9", 4);
//        System.out.println(list);
//        String a = "";
//        System.out.println(a.substring(2, 3));
//        List<String> l = new ArrayList<>(5);
    }
}
