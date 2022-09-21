class Solution {
        public String getPermutation(int n, int k) {
        LinkedList<Integer> sources = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        boolean reverse = false;
        for (int i = 1; i <= n; i++) {
            sources.add(i);
        }
        for (int i = 0; i < n && k != 1; i++) {
            int count = factorial(n - 1 - i);
            int index = k / count;
            k = k % count;
            if (k == 0) {
                result.add(sources.get(index - 1));
                sources.remove(index - 1);
                reverse = true;
                break;
            }
            result.add(sources.get(index));
            sources.remove(index);
        }

        if(reverse){
            while(sources.size() != 0){
                result.add(sources.removeLast());
            }
        }else{
            while(sources.size() != 0){
                result.add(sources.pop());
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : result) {
            stringBuilder.append(integer);
        }

        return stringBuilder.toString();
    }

    private int factorial(int n) {
        int result = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        return result;
    }
}