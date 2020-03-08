import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CSVParseV2 {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner in = new Scanner(System.in);
        List<String> lines = new ArrayList<String>();
        while(in.hasNextLine()) {
            lines.add(in.nextLine());
        }
        in.close();
        List<List<String>> result = CSVParserSolution.parse(lines);
        String template = "%s, %s years old, is from %s and is interested in %s.";
        for(List<String> li : result) {
            //index: first_name:0, age:6, city:5, interests:3
            System.out.println(String.format(template, li.get(0), li.get(6), li.get(5), li.get(3)));
        }
    }
}

class CSVParserSolution {
    private static char quote = '"';
    private static char comma = ',';
    public static List<List<String>> parse(List<String> lines) {
        List<List<String>> result = new ArrayList<List<String>>();
        for(String line : lines) {
            result.add(parseLine(line));
        }
        return result;
    }

    private static List<String> parseLine(String line) {
        List<String> result = new ArrayList<String>();
        char[] chars = line.toCharArray();
        int count = 0;
        int start = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == quote) {
                quote++;
            } else if(count%2 == 0 && chars[i] == comma) {
                result.add(getField(line.substring(start, i)));
                start = i+1;
            }
        }
        return result;
    }

    private static String getField(String field) {
        if(field.length() == 0 || field.charAt(0) == quote) {
            return field;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = field.toCharArray();
        int count = 0;
        for(int i = 1; i < chars.length-1; i++) {
            if(chars[i] == quote) {
                count++;
            }
            //skip the second quote
            if(count%2 == 1) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}