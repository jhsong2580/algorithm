https://leetcode.com/problems/valid-sudoku/submissions/

---
현재 수도쿠 문제가 정상 문제인지 검증한다. 

---
1. HashSet<String> row = new HashSet<>()
   1. 각 row에 존재하는 숫자
      1. 1_1 : 1번째 row에 1이 있다. 
2. HashSet<String> col = new HashSet<>()
   1. 각 column에 존재하는 숫자
      1. 1_1 : 1번째 column에 1이 있다. 
3. HashSet<String> rec = new HashSet<>()
   1. 각 Rectangle에 존재하는 숫자
      1. 0_0_1 : 위에서 첫번째, 왼쪽에서 첫번째 Rectangle에 1이 존재한다. 
4. 집계된 모든 값을 더해서, 적혀진 숫자갯수*3과 같으면 정상 수도쿠 맵이다.
   1. 각 숫자는 row, column, rectangle 집계를 위해 각각 3번씩 읽히기 때문이다. 
