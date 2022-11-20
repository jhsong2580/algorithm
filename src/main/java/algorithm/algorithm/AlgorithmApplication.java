package algorithm.algorithm;


import algorithm.algorithm.algo_20220906_1.ListNode;
import algorithm.algorithm.algo_20221119_2.Solution;
import java.util.List;

public class AlgorithmApplication {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int solution1 = solution.solution(
//            new int[][]{{3, 6, 3}, {2, 4, 2}, {10, 12, 8}, {11, 15, 5}, {1, 8, 10}, {12, 13, 1}});

        int solution1 = solution.solution(
            new int[][]{{1, 2, 1}, {1, 2, 2}, {2, 3, 1}, {3, 4, 1}, {1, 4, 2}}
        );
        print(solution1);


    }

    private static String test(String a) {
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[i] < chars[j]) {
                    char temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return String.valueOf(chars);
    }

    private static void print(Object[][] ints) {
        for (Object[] anInt : ints) {
            for (Object i : anInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void print(Object[] a) {
        for (Object i : a) {
            System.out.print(i + " ");
        }
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void print(List<List> lists) {
        for (List list : lists) {
            for (Object o : list) {
                System.out.print(o + " ");
            }
            System.out.println();
        }
    }

    private static void print(Object a) {
        System.out.println(a);
    }


    public static ListNode getNodes(int[] arr) {

        ListNode node = new ListNode(arr[0]);
        ListNode head = node;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            node.next = listNode;
            node = listNode;
        }
        return head;
    }

    private static String getListString(String src) {
        System.out.println(src.replace('[', '{').replace(']', '}'));
        return src.replace('[', '{').replace(']', '}');
    }

    private static void insertionSort(int[] a, int size) {

        for (int i = 1; i < size; i++) {
            // 타겟 넘버
            int target = a[i];

            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while (j >= 0 && target < a[j]) {
                a[j + 1] = a[j];    // 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }

            a[j + 1] = target;
        }
    }
}