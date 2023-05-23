package org.example.BOJ_Algorithm.moonwonki;

import java.io.*;

public class baekjoon_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        int alphabet[] = new int[26];

        //일단 알파벳 전부 -1로 초기화.
        for (int i = 0; i < 26; i++){
            alphabet[i] = -1;
        }

        // 문자열을 character 단위로 읽어가면서 등장하는 알파벳의 인덱스를 배열에 적음.
        // 중요한 점!
        // 만약 aaaaaaaa 같은 경우는 처음 등장한 a의 인덱스를 적어줘야한다!
        // 따라서 -1일 때만 바꾸고 그 뒤에 재등장하더라도 바꿔주지 않도록 if문 구성.
        for (int i = 0; i < str.length(); i++){
            if (alphabet[str.charAt(i) - 'a'] == -1) alphabet[str.charAt(i) - 'a'] = i;
        }

        // 출력.
        for (int i = 0 ; i < 26; i++){
            bw.write(Integer.toString(alphabet[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
