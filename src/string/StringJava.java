package string;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJava {
    public String jionStringFromList1(String jionWith, String... list) {
        return String.join(jionWith, list);
    }
    
    public String jionStringFromList2(String jionWith, List<String> ds) {
        return String.join(jionWith, ds);
    }
    
    public String jionStringFromList3(String jionWith, String[] a) {
        return String.join(jionWith, a);
    }
    
    public String jionStringFromList4(String jionWith,Iterable<String> s) {
        return String.join(jionWith, s);
    }
    

    public String streamWithString(String string) {
        return string.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.joining());
    }

}
