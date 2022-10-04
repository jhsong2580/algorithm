package algorithm.algorithm.algo_20221001_4;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    private int[] direction = new int[]{-1, 0, 1, 0, -1}; // T, R, D, L


    public int solution(String[] maps) {
        Character[][] map = new Character[maps.length][maps[0].length()];
        boolean[][] checked = new boolean[maps.length][maps[0].length()];
        Map<Character, Integer> landsStatAfterWar = new HashMap<>();

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[0].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }

        for(int i=0; i< map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(checked[i][j]){
                    continue;
                }
                if(map[i][j] == '.'){
                    checked[i][j] = true;
                    continue;
                }
                Map<Character, Integer> stat = new HashMap<>();
                startWar(map, checked, i, j, stat);

                char maxLand = '@';
                int maxLandCount = 0;
                for (Character land : stat.keySet()) {
                    Integer curLandCount = stat.get(land);
                    if(curLandCount > maxLandCount){
                        maxLand = (char)land;
                        maxLandCount = curLandCount;
                    }else if(curLandCount == maxLandCount){
                        maxLand = (char) Math.max((int) land, (int) maxLand);
                    }
                }

                for (Character land : stat.keySet()) {
                    Integer curLandCount = stat.get(land);
                    if(curLandCount < maxLandCount){
                        land = maxLand;
                    }
                    if(landsStatAfterWar.containsKey(land)){
                        landsStatAfterWar.put(land, landsStatAfterWar.get(land) + curLandCount);
                    }else{
                        landsStatAfterWar.put(land, curLandCount);
                    }
                }
            }
        }

        int maxLandCount = 0;
        for (Character land : landsStatAfterWar.keySet()) {
            Integer curLandCount = landsStatAfterWar.get(land);
            if(maxLandCount < curLandCount){
                maxLandCount = curLandCount;
            }
        }
        return maxLandCount;
    }

    private void startWar(Character[][] map, boolean[][] check, int r, int c, Map<Character, Integer> stat) {
        if (r < 0 || c < 0 || r == map.length || c == map[0].length) { //Out Bound Index Exp
            return;
        }
        if (check[r][c]) { // already checked
            return;
        }
        if (map[r][c] == '.') {
            return;
        }
        check[r][c] = true;
        Character curLand = map[r][c];
        if(stat.containsKey(curLand)){
            stat.put(curLand, stat.get(curLand) + 1);
        }else{
            stat.put(curLand, 1);
        }
        for(int i=0; i< direction.length -1; i++){
            startWar(map, check, r + direction[i], c + direction[i+1], stat);
        }
    }
}
