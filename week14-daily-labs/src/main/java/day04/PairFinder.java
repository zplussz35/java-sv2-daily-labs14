package day04;

import java.util.Map;
import java.util.TreeMap;

public class PairFinder {
    public int findPairs(int[] arr){
        Map<Integer,Integer> nums=new TreeMap<>();
        for (int n:arr) {
            if(!nums.containsKey(n)){
                nums.put(n,0);
            }
            nums.put(n,nums.get(n)+1);
        }

        return nums.values().stream()
                .mapToInt(v->v/2).sum();
    }
}
