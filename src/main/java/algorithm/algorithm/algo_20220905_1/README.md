https://leetcode.com/problems/spiral-matrix-iii/

---
1. 우측,하단으로 갈때는 length 
2. 좌측, 상단으로 갈때는 length +1
3. 다시 우측, 하단으로 갈때는 (length +1) +1
4. 이 로직을 계속 돌며, OutOfIndex가 발생하는 위치에는 별다른 처리를 하지 않는다.