// 유클리드 호제법으로 GCD 구하기
// GCD로 LCM 구하기

public int[] getGCDnLCM(int a, int b){
  int min = (a < b) ? a : b;
  int gcd = 0;
  for (int i = 1; i <= min; i++) {
    if (a % i == 0 && b % i == 0)
      gcd = i;
  }

  return new int[] { gcd, a * b / gcd };
}
