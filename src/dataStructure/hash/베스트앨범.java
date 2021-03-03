package dataStructure.hash;

import java.util.*;

/**
 * 문제 설명
 * 스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
 *
 * 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
 * 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
 * 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
 * 노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
 *
 * 제한사항
 * genres[i]는 고유번호가 i인 노래의 장르입니다.
 * plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
 * genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
 * 장르 종류는 100개 미만입니다.
 * 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
 * 모든 장르는 재생된 횟수가 다릅니다.
 * 입출력 예
 * genres	plays	return
 * ["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 * 입출력 예 설명
 * classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.
 *
 * 고유 번호 3: 800회 재생
 * 고유 번호 0: 500회 재생
 * 고유 번호 2: 150회 재생
 * pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.
 *
 * 고유 번호 4: 2,500회 재생
 * 고유 번호 1: 600회 재생
 * 따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.
 */
public class 베스트앨범 {
    public static void main(String[] args) {
        베스트앨범 o = new 베스트앨범();
        System.out.println(Arrays.toString(o.solution(new String[]{"classic", "pop", "classic", "classic", "pop","one"}, new int[]{500, 600, 150, 800, 2500, 1})));
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Album> albumsMap = new HashMap<>();
        List<Album> albumList = new ArrayList<>();

        for (int i=0; i<genres.length; i++) {
            if(albumsMap.containsKey(genres[i])) {
                albumsMap.get(genres[i]).update(i, plays[i]);
            } else {
                Album album = new Album();
                album.update(i, plays[i]);
                albumsMap.put(genres[i], album);
                albumList.add(album);
            }
        }

        Collections.sort(albumList);
        Collections.reverse(albumList);

        List<Integer> results = new ArrayList<>();
        for(Album album : albumList) {
            if(album.firstIndex != -1) {
                results.add(album.firstIndex);
            }
            if(album.secondIndex != -1) {
                results.add(album.secondIndex);
            }
        }

        return results.stream().mapToInt(i->i).toArray();
    }

    private class Album implements Comparable<Album>{
        private int firstIndex;
        private int secondIndex;
        private int firstPlay;
        private int secondPlay;
        private Long totalPlay;

        public Album() {
            firstIndex = -1;
            secondIndex = -1;
            firstPlay = -1;
            secondPlay = -1;
            totalPlay = 0L;
        }

        public void update(int index, int play) {
            if((play > firstPlay) || (play == firstPlay && index < firstIndex)) {
                setSecond(firstIndex, firstPlay);
                setFirst(index, play);
            } else if((play > secondPlay) || (play == secondPlay && index < secondIndex)) {
                setSecond(index, play);
            }
            totalPlay += play;
        }

        private void setFirst(int index, int play) {
            firstIndex = index;
            firstPlay = play;
        }

        private void setSecond(int index, int play) {
            secondIndex = index;
            secondPlay = play;
        }

        @Override
        public int compareTo(Album o) {
            return (int)(this.totalPlay - o.totalPlay);
        }
    }
}
