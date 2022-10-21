package algorithm.algorithm.algo_20220924_2;

public class Solution {

    private int n;
    private int[] deliveries;
    private int[] pickups;
    private int cap;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        this.n = n;
        this.deliveries = deliveries;
        this.pickups = pickups;
        this.cap = cap;
        long answer = -1;
        long deliveriesCount = 0;
        long pickUpCount = 0;
        for (int delivery : deliveries) {
            deliveriesCount += delivery;
        }
        for (int pickup : pickups) {
            pickUpCount += pickup;
        }
        return answer;
    }

    private void dfs(int deliveriesCount, int pickUpCount, int curStock, int curPickup,
        int homeIndex, boolean forward, int length) {
        if (homeIndex == n) {
            return;
        }
        if (deliveriesCount == 0 && forward) {
            forward = false;
        }
        if (pickUpCount == 0 && !forward) { //처음으로 돌아간다.
            forward = true;
            length += homeIndex;
            homeIndex = 0;
            curStock = this.cap;
        }
        if (forward) { //앞으로갈때 처리
            if (deliveries[homeIndex] > curStock) {
                dfs(deliveriesCount, pickUpCount, curStock, curPickup, homeIndex + 1, forward,
                    length + 1); //pass
            } else {
                dfs(deliveriesCount, pickUpCount, curStock, curPickup, homeIndex + 1, forward,
                    length + 1); //pass
                dfs(deliveriesCount - deliveries[homeIndex], pickUpCount,
                    curStock - deliveries[homeIndex], curPickup, homeIndex + 1, forward,
                    length + 1);
            }
        }else{//뒤로갈때처리
            if (pickups[homeIndex] > pickUpCount) {
                dfs(deliveriesCount, pickUpCount, curStock, curPickup, homeIndex + 1, forward,
                    length + 1); //pass
            } else {
                dfs(deliveriesCount, pickUpCount, curStock, curPickup, homeIndex + 1, forward,
                    length + 1); //pass
                dfs(deliveriesCount , pickUpCount- pickups[homeIndex],
                    curStock , curPickup- pickups[homeIndex], homeIndex + 1, forward,
                    length + 1);
            }
        }
    }
}
