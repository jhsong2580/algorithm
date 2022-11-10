package algorithm.algorithm.algo_20220924_5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Solution1 {

    private int[] direction = new int[]{0, 1, 0, -1, 0};
    private int BOARD_SIZE = 50;
    private Map<String, GroupInfo> groupLocation = new HashMap();
    private Map<String, String> updateStack = new LinkedHashMap<>();


    public String[] solution(String[] commands) {
        String[][] groupInfo = new String[BOARD_SIZE][BOARD_SIZE];
        String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = "";
                groupInfo[i][j] = "";
            }
        }
        for (String command : commands) {
            String[] commandInfo = command.split(" ");
            String flag = commandInfo[0];
            if (flag.equals("UPDATE")) {
                update(board, groupInfo, commandInfo);
            } else if (flag.equals("MERGE")) {
                merge(board, groupInfo, commandInfo);
            } else if (flag.equals("UNMERGE")) {
            } else if (flag.equals("PRINT")) {
                String value = board[Integer.parseInt(commandInfo[1]) - 1][
                    Integer.parseInt(commandInfo[2]) - 1];
                if (value.equals("")) {
                    value = "EMPTY";
                }
                result.add(value);
            }
        }
        return result.toArray(new String[0]);
    }

    private void merge(String[][] board, String[][] groupInfo, String[] commandInfo) {
        int r1 = Integer.parseInt(commandInfo[1]) - 1;
        int c1 = Integer.parseInt(commandInfo[2]) - 1;
        int r2 = Integer.parseInt(commandInfo[3]) - 1;
        int c2 = Integer.parseInt(commandInfo[4]) - 1;
        String defaultValue = board[r1][c1];
        if (defaultValue.equals("")) {
            defaultValue = board[r2][c2];
        }

        if (groupInfo[r1][c1].equals("") && groupInfo[r2][c2].equals("")) {
            String groupId = UUID.randomUUID().toString();
            for (int i = Math.min(r1, r2); i <= Math.max(r1, r2); i++) {
                for (int j = Math.min(c1, c2); j <= Math.max(c1, c2); j++) {
                    groupInfo[i][j] = groupId;
                }
            }
            GroupInfo add = new GroupInfo(Math.min(r1, r2), Math.min(c1, c2),
                Math.max(r1, r2), Math.max(c1, c2));
            add.setValue(defaultValue);

            groupLocation.put(groupId, add);
            return;
        }
        if (!groupInfo[r1][c1].equals("") && groupInfo[r2][c2].equals("")) {

        }
    }

    private void update(String[][] board, String[][] groupInfo, String[] commandInfo) {
        if (commandInfo.length == 4) {
            int r = Integer.parseInt(commandInfo[1]) - 1;
            int c = Integer.parseInt(commandInfo[2]) - 1;
            //group존재
            if (groupInfo[r][c].equals("")) {
                board[r][c] = commandInfo[3];
            } else {
                String boardId = groupInfo[r][c];
                GroupInfo groupLc = groupLocation.get(boardId);
                for (int i = groupLc.getR1(); i <= groupLc.getR2(); i++) {
                    for (int j = groupLc.getC1(); j <= groupLc.getC2(); j++) {
                        board[i][j] = commandInfo[3];
                    }
                }
            }
        } else if (commandInfo.length == 3) {
            updateStack.put(commandInfo[1], commandInfo[2]);
        }
    }


    private class GroupInfo {

        int r1;
        int c1;
        int r2;
        int c2;
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setR1(int r1) {
            this.r1 = r1;
        }

        public void setC1(int c1) {
            this.c1 = c1;
        }

        public void setR2(int r2) {
            this.r2 = r2;
        }

        public void setC2(int c2) {
            this.c2 = c2;
        }

        public int getR1() {
            return r1;
        }

        public int getC1() {
            return c1;
        }

        public int getR2() {
            return r2;
        }

        public int getC2() {
            return c2;
        }

        public GroupInfo(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }
    }
}
