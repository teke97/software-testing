package cos;
import java.math.BigDecimal;

/**
 * Created by yaros on 12.04.18.
 */
public abstract class Cos {
    public static double cos(double x){
        if (Double.isInfinite(x))
            return Double.NaN;
        x = normalize(x);
        BigDecimal sum = BigDecimal.ZERO;
        for( int n = 0;; n++) {
            BigDecimal term = (new BigDecimal(x).pow(2 * n))
                    .divide(factor(2 * n),BigDecimal.ROUND_HALF_EVEN);
            if (n % 2 == 0){
                sum = sum.add(term);
            } else {
                sum = sum.add(term.negate());
            }
            if (term.abs().doubleValue() <= 1e-15 ){
                break;
            }
        }
        return sum.doubleValue();
    }

    private static BigDecimal factor(int number){
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= number; i++) {
            result = result.multiply(new BigDecimal(i));
        }
        return result;
    }

    private static double normalize(double x){
        return x % (Math.PI * 2);
    }
}
