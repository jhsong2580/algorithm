class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] firstLessIndexFromLeft = new int[height.length];
        int[] firstLessIndexFromRight = new int[height.length];
        firstLessIndexFromLeft[0] = -1; //0번째 값보다 더 작은 값은 왼쪽에 없다
        firstLessIndexFromRight[height.length - 1] = height.length; // 마지막 값보다 더작은값은 우측에 없다.

        for(int i = 1; i< height.length; i++){
            int p = i-1;
            while (p >= 0 && height[p] >= height[i]) { //내 값보다 크다면
                p = firstLessIndexFromLeft[p];      //다음에 비교할 대상은 해당 값 기준 처음으로 작은 값 인덱스이다
            }
            firstLessIndexFromLeft[i] = p;
        }

        for(int i = height.length-2; i>=0; i--){
            int p = i +1;
            while (p < height.length && height[p] >= height[i]) { //내값보다 크다면
                p = firstLessIndexFromRight[p];                //다음에 비교할 대상은 해당 값 기준 청므으로 작은 인덱스
            }
            firstLessIndexFromRight[i] = p;
        }

        int maxArea = 0;
        for(int i=0;i<height.length; i++){
            maxArea = Math.max(maxArea,
                height[i] * (firstLessIndexFromRight[i] - firstLessIndexFromLeft[i] - 1));
        }
        return maxArea;
    }
}