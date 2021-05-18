/**
 Обработка данных с использованием регулярных выражений.
 Использование классов Pattern, Matcher
 */
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example {
    public static void main(String[] args) {
        String a = "1234";
        System.out.println(a.matches("1234"));

        String aa = "+1234";
        String b = "-1234";
        System.out.println(aa.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));

        String d = "gf111djf3333hjdtd852856285";
        System.out.println(d.matches("[a-zA-Z31]+\\d+"));

        String e = "hello";
        System.out.println(e.matches("[^abc]*"));

        String url = "http://www.google.com";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));

        String f = "123453875";
        System.out.println(f.matches("\\d{2,}"));

        String aaa = "Hello there hey";
        String[] words = aaa.split(" ");
        System.out.println(Arrays.toString(words));
        String bbb = "Hello.there.hey";
        String[] words2 = bbb.split("\\.");
        System.out.println(Arrays.toString(words2));

        String c = "Hello423623636there4363263hey346363463346dgdgdfgfg";
        String b3 = c.replaceAll("\\d+", "_");
        System.out.println(b3);
        String[] words3 = c.split("\\d+");
        System.out.println(Arrays.toString(words3));

        String c1 = "Hello there hey";
        String b1 = c1.replace(" ", ".");
        System.out.println(b1);

        String a1 = "klshshdslhg khfd@yandex.ru oiigysp pdouf podu dpohgdf" +
                "dflghdfh dlfhd ldh gdlfh dlfhgdl hgldhfg dl kvjhsoh@gmail.com lksjdha;lsodg" +
                "sd;lghs hd sdh sdjhsdjhsd skdjhg ohd@mail.ru sigvsk sdjgsk skdfksdgf";

        Pattern email = Pattern.compile("\\w+@(yandex|gmail|mail)\\.(ru|com)");
        Matcher matcher = email.matcher(a1);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
