package algorithm.algorithm.algo_20220912_1;

public class Solution {
    public String solution(String new_id) {
        new_id = new_id.replaceAll("[^A-Za-z0-9\\.\\_\\-]","");
        new_id = dotProcess(new_id);

        if(new_id.length() == 0){ // 빈문자일때 a추가(5)
            new_id = "a";
        }
        if(new_id.length() <= 2){ //2자 이하일때 마지막 문자 append(7)
            String addString = new_id.substring(new_id.length() - 1, new_id.length());
            for(int i = new_id.length(); i <= 2; i++){
                new_id += addString;
            }
        }
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            new_id = dotProcess(new_id);
        }
        new_id = new_id.toLowerCase(); // 모든 대문자를 숫자로 치환(1)


        return new_id;


    }

    private String dotProcess(String new_id) {
        String[] split = new_id.split("\\.");  // . 는 연속으로 오면 안되고, 앞뒤로 오면 안된다.
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            if(s.equals(""))
                continue;
            stringBuilder.append(s);
            stringBuilder.append('.');
        }
        String s = stringBuilder.toString();
        if (s.length() >= 1) {
            new_id = s.substring(0, s.length() - 1);
        }else{
            new_id = "";
        }
        return new_id;
    }
}
