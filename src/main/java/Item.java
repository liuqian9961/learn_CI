<<<<<<< HEAD
import java.math.BigInteger;

public class Item {
    private BigInteger coef;
    private BigInteger index;

    public Item(BigInteger coef,BigInteger index) {
        this.coef = coef;
        this.index = index;
    }

    public void setCoef(BigInteger coef) {
        this.coef = coef;
    }

    public void setIndex(BigInteger index) {
        this.index = index;
    }

    public BigInteger getCoef() {
        return coef;
    }

    public BigInteger getIndex() {
        return index;
    }

    public Item Derivative() {
        Item diff = new Item(new BigInteger("0"),new BigInteger("0"));
        BigInteger num = new BigInteger("1");
        if (index.equals(0)) {
            diff.setCoef(new BigInteger("0"));
        } else {
            diff.setCoef(coef.multiply(index));
            diff.setIndex(index.subtract(num));
        }

        return diff;
    }
}
=======
import java.math.BigInteger;

public class Item {
    private BigInteger coef;
    private BigInteger index;

    public Item(BigInteger coef,BigInteger index) {
        this.coef = coef;
        this.index = index;
    }

    public void setCoef(BigInteger coef) {
        this.coef = coef;
    }

    public void setIndex(BigInteger index) {
        this.index = index;
    }

    public BigInteger getCoef() {
        return coef;
    }

    public BigInteger getIndex() {
        return index;
    }

    public Item Derivative() {
        Item diff = new Item(new BigInteger("0"),new BigInteger("0"));
        BigInteger num = new BigInteger("1");
        if (index.equals(0)) {
            diff.setCoef(new BigInteger("0"));
        } else {
            diff.setCoef(coef.multiply(index));
            diff.setIndex(index.subtract(num));
        }

        return diff;
    }
}
>>>>>>> 1e0423318553dc49f6ca51ec74532739015e2b17
