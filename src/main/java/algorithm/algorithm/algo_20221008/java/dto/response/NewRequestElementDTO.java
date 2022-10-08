package algorithm.algorithm.algo_20221008.java.dto.response;

public class NewRequestElementDTO implements Comparable{

    private int id;
    private int amount;
    private int check_in_date;
    private int check_out_date;


    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getCheck_in_date() {
        return check_in_date;
    }

    public int getCheck_out_date() {
        return check_out_date;
    }

    @Override
    public int compareTo(Object o) {
        NewRequestElementDTO target = (NewRequestElementDTO) o;
        if(this.getAmount() > target.getAmount()){
            return -1;
        }

        return 1;
    }

    @Override
    public String toString() {
        return "NewRequestElementDTO{" +
            "id=" + id +
            ", amount=" + amount +
            ", check_in_date=" + check_in_date +
            ", check_out_date=" + check_out_date +
            '}';
    }
}
