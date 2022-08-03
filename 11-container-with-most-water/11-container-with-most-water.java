class Solution {
    public int maxArea(int[] height) {
        int verticalCount = height.length;
        int max = Integer.MIN_VALUE;
        int frontIndex = 0;
        int lastIndex = verticalCount -1;

        while(lastIndex - frontIndex != 0){
            int curHeight = Math.min(height[frontIndex], height[lastIndex]);
            max = Math.max(curHeight * (lastIndex - frontIndex), max);
            if(height[frontIndex] >= height[lastIndex]){
                lastIndex--;
            }else{
                frontIndex++;
            }
        }
        return max;
    }
}