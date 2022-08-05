https://leetcode.com/problems/jump-game-ii/

---
과제 개요
1. 0이상, 1000이하의 숫자로 이루어진 배열이 주어진다. 
2. 각 배열 값의 의미는, 이 칸으로부터 해당 숫자까지 index이동할수가 있다.
- index : 2, x[2] = 3 -> 이동가능 위치 x[3~5]

---
풀이내용
- check[i] = i ~ 마지막 까지 갈수있는 최소 step

1. nums[i] 가 0일때는, index i 에선 더이상 갈수 없다는 의미로 1001(최대 nums +1)를 삽입한다.
2. 현재 index + nums[i] 가 최종 index보다 크거나 같다면(도달한다면) check[i] = 1(해당 인덱스에선 바로 갈수 있음)을 삽입한다.
3. 현재 index + nums[i] 가 최종 index보다 작다면 갈수있는 최소 index를 선출한다.
   1. check[index+1 ~ lastIndex-1] 내에 최소 거리를 탐색 후, check[index] = 최소거리 + 1 을 삽입한다. 
4. check[0] 을 반환한다.
