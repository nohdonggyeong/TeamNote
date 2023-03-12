// 에라토스테네스의 체로 소수 개수 구하기

public int solution(int n){

    int[] prime = new int[n + 1];
    int answer = 0;

    //소수가 아니라면 0, 0과 1은 소수가 아니므로 0
    prime[0] = prime[1] = 0;

    for(int i = 2; i <=n; i++) prime[i] = i; //2부터 소수를 구하고자 하는 구간의 모든 수 나열

    for(int i = 2; i < n;i++){
        if(prime[i] == 0) continue; //소수가 아니라면 continue
        for(int j = 2*i; j <=n; j+=i) prime[j] = 0; //소수의 배수는 소수를 약수로 가지므로 제외
    }

    //소수 개수 구하기
    for(int i = 0; i <prime.length; i++)
        if (prime[i] != 0) answer++;

    return answer;
}