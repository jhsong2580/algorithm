https://leetcode.com/problems/sudoku-solver/submissions/
---
수도쿠 정답을 board에 저장한다. 
수도쿠 rule을 따른다. 
---
1. dfs로 구현했다. 
2. board[x][y]에 1~9 숫자를 집어넣으며, 각 시행마다 row/column/rectangle 검증이 시행되고 입력이 가능하면 삽입 후 다음 시행를 진행한다.
   - 시행 
    1. 해당 칸이 이미 채워져 있다면 matchCount를 증가시키고 다음 시행을 처리한다. 
    2. 해당칸이 비워져있다면 1~9를 한개씩 집어넣는다. 
       1. 집어 넣은 후 row/column/rectangle 검증을 진행한다. 
       2. 해당 숫자를 집어넣을수 있다면 삽입하고 다음 시행을 처리한다. 
       3. 만약 1~9까지 삽입후에도 넣을수 있는 숫자가 없다면 전 시행 시점으로 돌아간다. 
3. 문제 case들은 모두 수도쿠 칸이 채워질수 있게 되어있으므로, 최종 답 추출 불가 처리에 대해선 하지 않는다.