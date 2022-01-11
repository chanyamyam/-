## 문제설명

![image](https://user-images.githubusercontent.com/69902747/148994073-5c677820-fcd3-492a-be63-2c9463fa0214.png)

#### play -> 장르별로 총 재생수를 저장한 hashMap 
#### hashMap -> 같은 장르의 노래들을 고유번호와 재생수를 저장한 hashMap

#### play로 총 재생수가 가장 많은 장르를 선택하고 hashMap에서 해당 장르의 1, 2번째로 많은 재생수의 곡의 고유번호 answer에 저장
#### play에서 해당 장르 삭제 후 play가 빌 때까지 반복
