import java.util.Arrays;

public class MathOpsTest {
    private static void near(double actual, double expected, String name) {
        if (!Double.isFinite(actual) || Math.abs(actual - expected) > 1e-8) {
            throw new AssertionError(name + " : " + actual + " au lieu de " + expected);
        }
    }
    public static void main(String[] args) {
        double[] p = MathOps.softmax(new double[]{2, 1, 0});
        near(Arrays.stream(p).sum(), 1, "Somme");
        near(p[0], 0.6652409557748218, "Premiere probabilite");
        near(MathOps.crossEntropy(new double[]{2, 1, 0}, 0), 0.4076059644443806, "Loss");
        double[] big = MathOps.softmax(new double[]{1002, 1001, 1000});
        near(big[0], p[0], "Stabilite");
        near(MathOps.crossEntropy(new double[]{0, 0, 0}, 0), Math.log(3), "Uniforme");
        System.out.println("OK : softmax et cross-entropy.");
        System.out.printf(java.util.Locale.ROOT, "p(a)=%.4f ; loss=%.4f%n", p[0],
            MathOps.crossEntropy(new double[]{2, 1, 0}, 0));
    }
}
