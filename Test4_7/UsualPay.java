
package Test4_7;

public class UsualPay extends Pay {
    public UsualPay(double d) {
        this.distance = d;
    }

    protected double count() {
        if (this.distance >= 0.0 && this.distance <= 9.0) {
            this.fee = 2.0;
        } else if (this.distance <= 14.0) {
            this.fee = 3.0;
        } else if (this.distance <= 21.0) {
            this.fee = 5.0;
        } else if (this.distance <= 30.0) {
            this.fee = 5.0;
        } else if (this.distance <= 41.0) {
            this.fee = 6.0;
        }

        return this.fee;
    }
}
