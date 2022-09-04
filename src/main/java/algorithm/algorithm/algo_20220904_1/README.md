https://leetcode.com/problems/spiral-matrix-ii/submissions/

---

1. 변수
- top : 0 (현재 시행에서 비어있는 가장 위 행 )
- left : 0 (현재 시행에서 비어있는 가장 왼쪽 열 )
- bottom : length -1 (n -1) (현재 시행에서 비어있는 가장 아래 행)
- right : length -1 (n-1) (현재 시행에서 비어있는 가장 오른쪽 열)

2. 시행 
   1. 현재 시행에서 가장 윗 행을 채운다 
      1. i = left; i<= right; i++ => arr[top][i] = number;
   2. 가장 윗 행이 채워졌으니, top변수를 1 증가시킨다
      1. top++;
   3. 현재 시행에서 가장 우측 열을 채운다
      1. i = top; i<=bottom; i++ => arr[i][right] = number;
   4. 가장 우측 열이 채워졌으니, right변수를 1 감소시킨다. 
      1. right--
   5. 현재 시행에서 가장 아래 행을 채운다. 
      1. i = right; i>=left; i-- => arr[bottom][i] = number;
   6. 가장 아래 행이 채워졌으니 bottom변수를1 감소시킨다 
      1. bottom--
   7. 현재 시행에서 가장 좌측 열을 채운다. 
      1. i = bottom; i>= top; i-- => arr[i][left] = number;
   8. 가장 왼쪽 행이 채워졌으니 left변수를 1 증가시킨다. 
   9. 만약 left < right; top < bottom 이면 처음부터 다시시행한다. 
   10. 시행이 끝난 후, n이 홀수라면 가장 큰 수를 가운데 칸에 넣는다. 
