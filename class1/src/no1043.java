import java.io.*;
import java.util.*;


/**
 * 1. 총 인원 수 만큼 boolean형 배열을 만듦 (전부 false)
 * 2. 그 중 진실을아는사람은 true로 변경
 * 3. 모든 파티를 돌면서, 해당 파티에 true인 인원이 있으면, 해당 파티의 모든 인원을 true로 변경
 * 4. 모든 파티를 돌면서, 해당 파티에 true인 인원이 없으면, count++
 * 5. count 출력
 */
public class no1043 {
    private static int people;
    private static int partys;
    private static int known;
    private static int cnt = 0;
    private static boolean[] knowns;
    private static boolean[][] partyTable;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 줄 : 사람의 수와 파티의 수
        StringTokenizer firstLine = new StringTokenizer(br.readLine(), " ");
        people = Integer.parseInt(firstLine.nextToken());
        partys = Integer.parseInt(firstLine.nextToken());
        knowns = new boolean[people+1];

        // 두 번째 줄 : 진실을 아는 사람 수, 만약 있으면 진실을 아는 사람 수만큼 리스트에 추가
        StringTokenizer secondLine = new StringTokenizer(br.readLine(), " ");
        known = Integer.parseInt(secondLine.nextToken());
        for(int i=0; i<known ; i++) knowns[Integer.parseInt(secondLine.nextToken())] = true;

        partyTable = new boolean[partys][people+1];

        //
        for(int i=0 ; i<partys ; i++) {
            StringTokenizer partyLine = new StringTokenizer(br.readLine(), " ");

            // 각 파티당 참석 인원수
            int partyMember = Integer.parseInt(partyLine.nextToken());

            // 만약 이번 파티에 진실을 아는 사람이 있는 경우 true 체크하여 이번 파티에 모인 사람들을 전부 진실을 알게 해주기위함
            boolean check = false;

            // 각 파티당 멤버가 누구였는지 체크
            for(int j=0 ; j<partyMember ; j++) {
                int nowMember = Integer.parseInt(partyLine.nextToken());
                partyTable[i][nowMember] = true;
                if(knowns[nowMember]) check = true;
            }

            // 이번 파티에 진실을 아는 사람이 있을 경우, 참석자 전원 진실을 알게됨
            if(check) {
                for(int j=1 ; j<=people ; j++) {
                    if(partyTable[i][j]) knowns[j] = true;
                }
            }
        }

        // 각 파티 테이블을 돌면서, 해당 파티의 참석자 전원이 진실을 모를 경우 cnt++
        for(int i=0 ; i<partys ; i++) {
            for(int j=1 ; j<=people ; j++) {
                if(partyTable[i][j] && knowns[j]) break;  // j번의 사람이 참석했고, 진실을 알 경우 이 파티는 조진거
                if(j==people) cnt++; // 끝까지 확인해봤는데 아무도 모르면 야부리 터는거
            }
        }

        System.out.println(cnt);
    }
}