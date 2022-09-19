https://school.programmers.co.kr/learn/courses/30/lessons/72416

---
- dp[x][0] : x node가 회의에 참석하지 않았을때 소모되는 최소 판매량
- dp[x][1] : x node가 회의에 참석했을때 소모되는 최소 판매량

1. dp[x][1] = sales[x] + sum(min(dp[child][0], dp[child[1]]))
2. dp[x][0] = sum(min(dp[child][0], dp[child][1]))
- 만약 모든 min(dp[child][0], dp[child][1])이 dp[child][0]을 반환한다면 child중 한명을 필수 참가시켜야한다. 
- dp[child][1] - dp[child][0]의 최소를 더해주자
- sum(min(dp[child][0], dp[child][1])) + min(dp[child][1] - dp[child[0]])