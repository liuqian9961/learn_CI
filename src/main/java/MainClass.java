
import java.util.Scanner;

public class MainClass {
    public static String init(String poly) {
        String sp = "[ \\t]*";
        String str0 = "\\+\\+";
        String str1 = "--";
        String str2 = "\\+-";
        String str3 = "-\\+";
        String poly0 = poly.replaceAll(sp,"");
        String poly1 = poly0.replaceAll(str0,"+");
        String poly2 = poly1.replaceAll(str1,"+");
        String poly3 = poly2.replaceAll(str2,"-");
        String poly4 = poly3.replaceAll(str3,"-");
        return poly4;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String poly = init(line);
        Poly tobe = new Poly(poly);
        tobe.getItem();
        tobe.diffOfpoly();
        tobe.print();
    }
}

