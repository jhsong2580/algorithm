https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

---
1. 이진탐색
- 시행
  1. target index 탐색
     1. index = (start + end) / 2
     2. if nums[index] == target : index 기록 후 탐색 종료 
     3. if nums[index] > target 
        - start ~ index -1 
     4. if nums[index] < target
        - index +1 ~ start 
  2. 값 범위 탐색 
  - index에서 앞으로 target과 다른 인덱스 까지 탐색 (다를시 종료)
  - index에서 뒤로 다른 인덱스까지 탐색(다를시 종료)