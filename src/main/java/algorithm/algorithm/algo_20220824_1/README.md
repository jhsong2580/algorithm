https://leetcode.com/problems/permutations/submissions/

---
1. dfs로 해결 
2. 매 시행마다 미사용된 숫자를 list에 삽입하고, 마지막까지 봤을때 (index == nums.length) 해당 list를 결과 list에 넣는다. 
