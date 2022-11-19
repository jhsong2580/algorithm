package algorithm.algorithm.algo_20221119_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    private int maxIncome;
    public int solution(int[][] part_time){
        maxIncome = Integer.MIN_VALUE;
        List<Job> jobs = new ArrayList<>();
        for (int[] ints : part_time) {
            jobs.add(new Job(ints[0], ints[1], ints[2]));
        }
        Collections.sort(jobs);

        dfs(jobs, 0, 0, 0);

        return maxIncome;
    }

    private void dfs(List<Job> jobs, int curIncome, int canWork, int index){
        if(jobs.size() == index){
            if(maxIncome < curIncome){
                maxIncome = curIncome;
            }
            return;
        }
        Job job = jobs.get(index);
        if(job.getStartDate() >= canWork){
            dfs(jobs, curIncome+job.getIncome(), job.getEndDate(), index+1);
        }
        dfs(jobs,curIncome, canWork, index+1);
    }

    class Job implements Comparable {
        final int startDate;
        final int endDate;
        final int income;

        public Job(int startDate, int endDate, int income) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.income = income;
        }

        public int getStartDate() {
            return startDate;
        }

        public int getEndDate() {
            return endDate;
        }

        public int getIncome() {
            return income;
        }

        @Override
        public int compareTo(Object o) {
            Job target = (Job) o;
            if(this.startDate < target.getStartDate()){
                return -1;
            }else{
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Job{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", income=" + income +
                '}';
        }
    }
}
