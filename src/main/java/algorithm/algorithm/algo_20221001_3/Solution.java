package algorithm.algorithm.algo_20221001_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public String solution(String[] registered_list, String new_id) {
        String answer = "";

        if (noRegistered(registered_list, new_id)) {
            return new_id;
        }

        int firstNonCharacterIndex = 0;
        for (firstNonCharacterIndex = 0; firstNonCharacterIndex < new_id.length();
            firstNonCharacterIndex++) {
            if (new_id.charAt(firstNonCharacterIndex) >= (int) 'a'
                && new_id.charAt(firstNonCharacterIndex) <= (int) 'z') {
                continue;
            }
            break;
        }
        String S = parseS(new_id, firstNonCharacterIndex);
        int N = parseN(new_id, firstNonCharacterIndex);

        final int index = firstNonCharacterIndex;

        List<Integer> Ns = Arrays.stream(registered_list).filter(s -> isValid(s, S, index))
            .map(s -> parseN(s, index)).collect(Collectors.toList());
        Collections.sort(Ns);

        int next_N = 0;
        int NsIndex = 0;
        for(next_N=N+1; next_N < 1000000; next_N++){
            if(NsIndex == Ns.size()){
                break;
            }
            if(Ns.get(NsIndex) < next_N){
                NsIndex++;
                next_N--;
                continue;
            }
            if(Ns.get(NsIndex) == next_N){
                NsIndex++;
                continue;
            }
            break;
        }
        return S+next_N;
    }

    private boolean isValid(String source, String target, int firstNonCharacterIndex) {
        String S = parseS(source, firstNonCharacterIndex);
        if (!S.equals(target)) {
            return false;
        }
        try {
            int N = parseN(source, firstNonCharacterIndex);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private String parseS(String source, int firstNonCharacterIndex) {
        return source.substring(0, firstNonCharacterIndex);
    }

    private int parseN(String source, int firstNonCharacterIndex) {
        String N_str = source.substring(firstNonCharacterIndex, source.length());
        return N_str.equals("") ? 0 : Integer.parseInt(N_str);
    }

    private boolean noRegistered(String[] ids, String id){
        int index = 0;
        for(index =0; index < ids.length; index++){
            if (ids[index].equals(id)) {
                break;
            }
        }
        if(index == ids.length)
            return true;
        return false;
    }
}
