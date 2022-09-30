package algorithm.algorithm.algo_20220929_1;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> smallHalf, maxHalf;
    boolean isEven ;
    public MedianFinder(){
        smallHalf = new PriorityQueue<>(Collections.reverseOrder());
        maxHalf = new PriorityQueue<>();
        isEven = true;
    }
    public void addNum(int num){
        isEven = !isEven;
        smallHalf.offer(num);
        maxHalf.offer(smallHalf.poll()); // small Half에서 가장 큰 값을 maxHalf로 이동시킨다.
        if (smallHalf.size() < maxHalf.size()) {
            smallHalf.offer(maxHalf.poll());
        }
    }

    public double findMedian(){
        if(isEven){
            return (smallHalf.peek() + maxHalf.peek()) / 2.0;
        }else{
            return smallHalf.peek();
        }
    }


}
