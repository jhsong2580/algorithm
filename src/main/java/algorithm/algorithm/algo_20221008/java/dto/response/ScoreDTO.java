package algorithm.algorithm.algo_20221008.java.dto.response;

public class ScoreDTO {
    private float accuracy_score;
    private float efficiency_score;
    private float penalty_score;
    private float score;

    public float getAccuracy_score() {
        return accuracy_score;
    }

    public float getEfficiency_score() {
        return efficiency_score;
    }

    public float getPenalty_score() {
        return penalty_score;
    }

    public float getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "ScoreDTO{" +
            "accuracy_score=" + accuracy_score +
            ", efficiency_score=" + efficiency_score +
            ", penalty_score=" + penalty_score +
            ", score=" + score +
            '}';
    }
}
