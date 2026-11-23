import java.util.Arrays;

public final class MathOps {
    private MathOps() {}

    private static void validate(double[] logits) {
        if (logits.length == 0) throw new IllegalArgumentException("Logits vides.");
        for (double value : logits) {
            if (!Double.isFinite(value)) throw new IllegalArgumentException("Logit non fini.");
        }
    }

    public static double[] softmax(double[] logits) {
        validate(logits);
        double max = Arrays.stream(logits).max().orElseThrow();
        double[] probabilities = new double[logits.length];
        double sum = 0;
        for (int i = 0; i < logits.length; i++) {
            probabilities[i] = Math.exp(logits[i] - max);
            sum += probabilities[i];
        }
        for (int i = 0; i < probabilities.length; i++) probabilities[i] /= sum;
        return probabilities;
    }

    public static double crossEntropy(double[] logits, int target) {
        validate(logits);
        if (target < 0 || target >= logits.length) {
            throw new IllegalArgumentException("Cible hors vocabulaire.");
        }
        double max = Arrays.stream(logits).max().orElseThrow();
        double sum = 0;
        for (double logit : logits) sum += Math.exp(logit - max);
        return Math.log(sum) + max - logits[target];
    }
}
