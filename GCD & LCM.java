public int[] getGCDnLCM(int a, int b){
  int min = (a < b) ? a : b;  // min : a와 b 중 작은 수
  int gcd = 0;
  for (int i = 1; i <= min; i++) {
    if (a % i == 0 && b % i == 0)
      gcd = i;
  }

  return new int[] { gcd, a * b / gcd };
}