https://leetcode.com/problems/search-in-rotated-sorted-array/
(못품)
---
1. sorting된 배열이 있다. 
2. 해당 배열을 random index 기준 rotate 한다.
   - [x1, x2, x3, x4, x5, x6, x7] 이 있을때, index4 기준 rotate
     - [x4, x5, x6, x7, x1, x2, x3]
3. rotate 결과 배열과 찾아야할 값이 주어졌을때, 그 값의 인덱스를 찾아라. 
   - 만약 없을시 -1를 반환한다
   - O(logn)으로 구현해라

---
(풀이)
1. 이진탐색으로 구현한다.
   (Discuss 내 자바 풀이 참조)
2. 먼저 계산된 x(mid)가 x(start)와 같은 범위인지 아닌지 체크
   1. 같은 범위라면, target해당 범위에 속해있고 x(mid)보다 작을때 좌측으로 간다
      - target > x[start] : target이 해당 범위에 속해있고
      - target < x[mid] : 중간값보다 target이 작다면 
      - endIndex = midIndex -1 : 좌측으로 간다. 
      - 그 외에는 우측으로 간다.
        - target이 start와 같은 범위 내에 있고, target > x[start], target > x[mid]
          - x[start] -> x[mid] -> target 순서이니 우측으로 간다. 
        - target이 start와 같은 범위 내에 있고, target < x[start], target < x[mid]
          - x[start] -> x[mid] -> x[rotate] -> target 순서이니 우측으로 간다. 
        - target이 start와 같은 범위 내에 있고, target < x[start], target > x[mid]
          - 존재할수 없다. 
   2. 다른 범위라면, target이 해당 범위에 속해있고, x(mid)보다 클때 우측으로 간다. 
      - target < x[end] : target이 해당 범위 내에 속해있고 
      - target > x[mid] : 중간값보다 target이 크면 
      - startIndex = midIndex +1 : 우측으로 간다. 