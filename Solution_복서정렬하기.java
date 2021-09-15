import java.util.Arrays;

class Solution {
    class Boxer implements Comparable<Boxer>{
        int no;
        int weight;
        double winRate;
        int winNum;
        
        public Boxer(int no, int weight, double winRate, int winNum) {
            this.no = no;
            this.weight = weight;
            this.winRate = winRate;
            this.winNum = winNum;
        }
        
        public int compareTo(Boxer b) {
            if (this.winRate > b.winRate) return -1;
            if (this.winRate == b.winRate) {
                if (this.winNum == b.winNum) {
                    if (this.weight == b.weight) {
                        return this.no - b.no;
                    }
                    return b.weight - this.weight;
                }
                return b.winNum - this.winNum;
            }
            return 1;
        }
    }
    
    public int[] solution(int[] weights, String[] head2head) {
        
        int N = weights.length;
        int[] answer = new int[N];
        Boxer[] boxer = new Boxer[N];
        
        for (int i = 0; i < N; i++) {
            int win = 0;
            int total = 0;
            int winNum = 0;
            for (int j = 0; j < N; j++) {
                if (head2head[i].charAt(j) == 'N') continue;
                
                total++;
                if (head2head[i].charAt(j) == 'W') {
                    win++;
                    if (weights[i] < weights[j]) winNum++;
                }
            }
            if (total == 0) total = 1;
            boxer[i] = new Boxer(i+1, weights[i], ((double)win/total)*100, winNum);
        }
        
        Arrays.sort(boxer);
        
        for (int i = 0; i < N; i++) {
            answer[i] = boxer[i].no;
        }
        
        return answer;
    }
}