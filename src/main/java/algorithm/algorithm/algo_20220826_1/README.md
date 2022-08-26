https://leetcode.com/problems/permutations-ii/

---
1. dfs로 해결 
2. 매 시행마다 미사용된 숫자를 list에 삽입하고, 마지막까지 봤을때 (index == nums.length) 해당 list를 결과 list에 넣는다. 
3. 단 전 시행때 사용했던 숫자와 같다면 이미 사용된 숫자로 인식하고 다른 숫자가 나올때까지 찾는다. 
- 이를 위해 받은 list를 소팅한다. 