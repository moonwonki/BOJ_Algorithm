#include <iostream>
#include <cstdio>
#include <cstring>
#include <algorithm>
using namespace std;


int main()
{
    int N, M;
    cin >> N >> M;

    int card[N];
    memset(card, 0, sizeof(int));
    for (int i = 0; i < N; i++){
        cin >> card[i];
    }

    int sumOfThree = 0;

    for (int first = 0; first< N - 2; first++){
        for (int second = first + 1; second < N - 1; second++){
            for (int third = second + 1; third < N; third++){
                int temp = card[first] + card[second] + card[third];
                if (temp > sumOfThree && temp <= M){
                    sumOfThree = card[first] + card[second] + card[third];
                }
            }
        }
    }

    cout << sumOfThree;

 

}