import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVParser {

    public static void main(String[] args) {
        // input:
        // Weronika,Zaborska,njkfdsv@dsgfk.sn,"running, sci-fi",new,Krakow,25
        // Ryuichi,Akiyama,jkg@ljnsfd.fjn,music,guide,Tokyo,65
        // Elena,Martinez,emrt@lsofnbr.rt,"cooking,traveling",superhost,Valencia,42
        // "John ""Mo""",Smith,sfn@flkaei.km,biking and hiking,,"Seattle, WA",23

        // output:
        // Weronika, 25 years old, is from Krakow and is interested in running,sci-fi.
        // Ryuichi, 65 years old, is from Tokyo and is interested in music.
        // Elena, 42 years old, is from Valencia and is interested in cooking,traveling.
        // John "Mo", 23 years old, is from Seattle, WA and is interested in biking and hiking.

        Scanner in = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while(in.hasNextLine()) {
            list.add(in.nextLine());
        }
        in.close();
        System.out.println(list);
        List<List<String>> result = CSVParserSolution1.parse(list);
        String template = "%s, %s years old, is from %s and is interested in %s.\n";
        for(List<String> li : result) {
            System.out.printf(template, li.get(0), li.get(6), li.get(5), li.get(3));
        }
    }


}

class CSVParserSolution1 {
//    List<String> lines;
//    public CSVParserSolution(List<String> lines) {
//        this.lines = lines;
//    }

    public static List<List<String>> parse(List<String> list) {
        List<List<String>> result = new ArrayList<List<String>>();
        for(String line : list) {
            result.add(parseLine(line));
        }
        return result;
    }

    private static List<String> parseLine(String line) {
        List<String> result = new ArrayList<>();
        char[] chars = line.toCharArray();
        int start = 0;
        int quoteCount = 0;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '"') {
                quoteCount++;
                continue;
            }
            if(quoteCount % 2 == 0 && chars[i]==',') {
                result.add(getField(line.substring(start, i)));
                start = i + 1;
            }
        }
        result.add(getField(line.substring(start)));
        return result;
    }

    private static String getField(String field) {
        if(field.length() == 0)
            return "";
        if(field.charAt(0) != '"')
            return field;
        StringBuilder sb = new StringBuilder();
        char[] chars = field.toCharArray();
        int quoteCount = 0;
        for(int i = 1; i < chars.length-1; i++) {
            if(chars[i] == '"') {
                quoteCount++;
                if(quoteCount%2 == 0)
                    continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
