package Test4_7;

public class RegularPay extends Pay {
    private int type;

    public RegularPay(int type) {
        this.type = type;
    }

    protected double count() {
        if (this.type == 1) {
            this.fee = 18.0;
        } else if (this.type == 3) {
            this.fee = 45.0;
        } else if (this.type == 7) {
            this.fee = 90.0;
        }

        return this.fee;
    }
}
