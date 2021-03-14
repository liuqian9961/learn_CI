import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Poly {
    private String poly;
    private TreeMap<BigInteger,Item> items;
    private ArrayList<Item> diffs;

    public Poly(String poly) {
        this.poly = poly;
        this.items = new TreeMap<BigInteger,Item>();
        this.diffs = new ArrayList<Item>();
    }

    public void getItem() {
        String reg1 = "(?<coef>" + "[\\+-]?[0-9]+" + ")" + "\\*x\\*\\*" +
                "(?<index>" + "[\\+-]?[0-9]+" + ")";
        String reg2 = "|" + "(?<coef1>" + "[\\+-]?[0-9]+" + ")" + "([\\*]x)?";
        String reg3 = "|" + "[\\+-]?x" + "\\*\\*" + "(?<index1>" + "[\\+-]?[0-9]+" + ")";
        String reg4 = "|" + "[\\+-]?x";
        Pattern p = Pattern.compile(reg1 + reg2 + reg3 + reg4);
        Matcher m = p.matcher(poly);
        while (m.find()) {
            String item = poly.substring(m.start(),m.end());
            String strCoef = "";
            String strIndex = "";
            if (item.matches(reg1)) {
                strCoef = m.group("coef");
                strIndex = m.group("index");
            } else if (item.matches(reg2)) {
                strCoef = m.group("coef1");
                if (item.endsWith("x")) {
                    strIndex = "1";
                } else {
                    strIndex = "0";
                }
            } else if (item.matches(reg3)) {
                if (item.substring(0,1).equals("-")) {
                    strCoef = "-1";
                } else {
                    strCoef = "1";
                }
                strIndex = m.group("index1");
            } else {
                if (item.substring(0,1).equals("-")) {
                    strCoef = "-1";
                } else {
                    strCoef = "1";
                }
                strIndex = "1";
            }
            BigInteger newCoef = new BigInteger(strCoef);
            BigInteger newIndex = new BigInteger(strIndex);
            if (items.containsKey(newIndex)) {
                BigInteger a = items.get(newIndex).getCoef();
                items.put(newIndex,new Item(newCoef.add(a),newIndex));
            } else {
                items.put(newIndex,new Item(newCoef,newIndex));
            }
        }
    }

    public void diffOfpoly() {
        Collection keyset = items.values();
        Iterator list = keyset.iterator();
        while (list.hasNext()) {
            Item item = (Item) list.next();
            diffs.add(item.Derivative());
        }
    }

    public void print() {
        int flag = 0;
        String positive = "";
        String negative = "";
        for (Item item: diffs) {
            BigInteger coef = item.getCoef();
            BigInteger index = item.getIndex();
            BigInteger zero = new BigInteger("0");
            //String output = "";
            if (coef.equals(zero)) {
                continue;
            } else if (coef.compareTo(zero) == 1) {
                flag = 1;
                positive = positive + "+" + String.valueOf(coef);
                if (index.equals("1")) {
                    positive = positive + "*" + "x";
                } else if (!index.equals(zero)) {
                    positive = positive + "*x**" + String.valueOf(index);
                }
            } else {
                flag = 1;
                negative = negative + String.valueOf(coef);
                if (index.equals("1")) {
                    negative = negative + "*" + "x";
                } else if (!index.equals(zero)) {
                    negative = negative + "*x**" + String.valueOf(index);
                }
            }
        }
        if (flag == 0) {
            System.out.println("0");
        } else {
            if (positive.equals("")) {
                System.out.println(negative);
            } else {
                System.out.println(positive.substring(1,positive.length()) + negative);
            }
        }
    }
}
