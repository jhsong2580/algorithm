https://leetcode.com/problems/jump-game-iii/

---
1. dfs로 해결 
2. 풀이방법
- 해당 인덱스가 out of index이면 탐색불가 return false
- 해당 인덱스가 이미 탐색된 인덱스라면 (check[index] == 1) return false
- 해당 인덱스가 0이라면 발견! return true
- 0이 아니라면 dfs 
  - check[index] = 1 <- 이 인덱스는 탐색하였다. 
  - 우측탐색 dfs(index + arr[i])
  - 좌측탐색 dfs(index - arr[i])

