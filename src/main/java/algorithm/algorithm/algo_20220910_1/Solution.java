package algorithm.algorithm.algo_20220910_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int plusTime = fees[2];
        int plusCost = fees[3];
        Map<String, Integer> parkingLot = new HashMap<>();
        SortedMap<String, Integer> parkingTimePerCar = new TreeMap<>();

        for (String record : records) {
            String[] info = record.split(" ");
            if (parkingLot.containsKey(info[1])) {
                int inTime = parkingLot.get(info[1]);
                int outTime = timeToMinute(info[0]);

                if(parkingTimePerCar.containsKey(info[1])){
                    parkingTimePerCar.put(info[1], parkingTimePerCar.get(info[1]) + outTime - inTime);
                }else{
                    parkingTimePerCar.put(info[1], outTime - inTime);
                }
                parkingLot.remove(info[1]);
            }else{
                parkingLot.put(info[1], timeToMinute(info[0]));
            }
        }
        for (Entry<String, Integer> parkingInfo : parkingLot.entrySet()) {
            int inTime = parkingInfo.getValue();
            int outTime = timeToMinute("23:59");
            if(parkingTimePerCar.containsKey(parkingInfo.getKey())){
                parkingTimePerCar.put(parkingInfo.getKey(), parkingTimePerCar.get(parkingInfo.getKey()) + outTime - inTime);
            }else{
                parkingTimePerCar.put(parkingInfo.getKey(), outTime - inTime);
            }
        }

        return parkingTimePerCar.values().stream().map(
                time -> getFee(time, defaultCost, defaultTime, plusCost, plusTime)
            ).mapToInt(Long::intValue)
            .toArray();
    }

    private int timeToMinute(String time){
        String[] timeInfo = time.split(":");
        return Integer.parseInt(timeInfo[0]) * 60 + Integer.parseInt(timeInfo[1]);
    }

    private Long getFee(int totalTime, int defaultFee, int defaultTime, int plusFee, int plusTime){
        if (totalTime <= defaultTime) {
            return (long)defaultFee;
        }
        return defaultFee + (long)Math.ceil((double)(totalTime - defaultTime) / plusTime) * plusFee;
    }
}
