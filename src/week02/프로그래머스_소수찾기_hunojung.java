package week02;

import java.util.Arrays;
import java.util.HashSet;

public class 프로그래머스_소수찾기_hunojung {
    public static void main(String[] args) {
        소수찾기 s = new 소수찾기();
        int answer = s.solution("0123661");
        System.out.println(answer);
        System.exit(0);
    }
}

class 소수찾기{
    public int answer;
    public int solution(String numbers){
        answer = 0;
        int len = numbers.length();
        boolean[] primes = new boolean[(int)Math.pow(10,len)+1];

        Arrays.fill(primes,true);
        setPrime(primes);

        char[] chars = numbers.toCharArray();
        make_number(chars,primes,new boolean[len],"");
        return answer;
    }

    public void make_number(char[] chars, boolean[] primes,boolean[] used,String num){
        if(num.length()>0){
            int int_num = Integer.parseInt(num);
            if(primes[int_num]){
                answer++;
                primes[int_num]= false;
            }
        }

        if(num.length()==chars.length) return;

        for (int i = 0; i < chars.length; i++) {
            if(!used[i]){
                used[i] = true;
                make_number(chars,primes,used,num+chars[i]);
                used[i] = false;
            }
        }
    }

    public void setPrime(boolean[] primes){
        primes[0] = false;
        primes[1] = false;
        for(long i=2;i<primes.length;i++){
            if(primes[(int)i]) {
                for (long j = i*i; j < primes.length ; j+=i) {
                    primes[(int)j] = false;
                }
            }
        }
    }
}
