https://leetcode.com/problems/trapping-rain-water/submissions/

---
two pointer

water[i] = min(max_left, max_right) - height[i];
- 해당 i에서 max_left와 max_right를 찾아라
- 시작은 left(0), right(length -1)에서 시작한다. 
- height[left] 와 height[right]를 비교하여, 작은쪽을 안쪽으로 이동시킨다. 
  - 만약 height[left] < height[right]라면? 
    - height[left+1] 에 대해서 우측 최대값은 height[right]이므로, 양옆 최대값 찾기가 수월해진다
      - min(max_left, max_right) -> min(max_left)
    - height[left+1] > max_left 라면 water[left+1]에는 물이 들어갈수없다. 
      - max_left = water[left+1]
    - height[left+1] <= max_left 라면 water[left+1]에는 물이 들어갈수 있다.
      - water += (min(max_left, max_right) - height[left+1])
        - min(max_left, max_right) = max_left
          - max_left = (height[left] 이거나, height[left] 보다 큰 수가 들어가있다)
          - max_right = (height[right] 이거나, height[right]보다 큰 수가 들어가있다)
          - 현재 height[left] < height[right]이다. 
          - 고로 min(max_left, max_right) = max_left이다. 
      - water += (max_left - height[left+1])