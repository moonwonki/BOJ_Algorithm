#include <iostream>
#include <algorithm>
#include <cstring>
#include <vector>

#define CASE_MAX 15
using namespace std;

int num;
int board[CASE_MAX] = {0,};
int sum = 0;


bool boardCheck(int cnt){
    int tmp = board[cnt] - cnt;
    for (int i = 0; i < cnt; i++){
        if (board[i] == board[cnt]) return false;
        if (cnt - i == abs(board[cnt] - board[i])) return false;
    }
    return true;
}



void queenSet(int cnt){
    if (cnt == num){
        sum++;
        return;
    }
    for (int i = 0; i < num; i++){
        board[cnt] = i;
        if (boardCheck(cnt)){
            queenSet(cnt + 1);
        }
    }
}
int main()
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


    cin >> num;
    queenSet(0);

    cout << sum;
}