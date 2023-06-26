# [Bronze I] 3단 초콜릿 아이스크림 - 28255 

[문제 링크](https://www.acmicpc.net/problem/28255) 

### 성능 요약

메모리: 18824 KB, 시간: 260 ms

### 분류

구현, 문자열

### 문제 설명

<p>코코는 초콜릿 아이스크림을 쌓아서 먹는 것을 좋아한다. 초콜릿 아이스크림 탑은 알파벳 대문자로 이루어진 문자열로 나타낼 수 있다. 예를 들면 벨기에, 민트, 오리지널 맛을 순서대로 쌓은 것은 <code>BMO</code>라고 쓸 수 있다.</p>

<p>코코는 “2단 아이스크림”의 정의를 다음과 같이 내리기로 했다.</p>

<ul>
	<li>길이 $n$인 아이스크림 문자열 $S$가 주어졌을 때, 길이가 $\left\lceil \frac{n}{2} \right\rceil$인 $S$의 접두사 $S'$를 생각한다. $\left\lceil x \right\rceil$은 $x$보다 크거나 같은 최소의 정수이다.</li>
	<li>$S=S'+\operatorname{rev}(S')$ 또는 $S=S'+\operatorname{tail}(\operatorname{rev}(S'))$를 만족하면 $S$는 2단 아이스크림이다. 여기서 $S_1+S_2$는 두 문자열을 순서대로 이어붙인 것, $\operatorname{rev}(S)$는 $S$의 글자의 순서를 뒤집은 것이고, $\operatorname{tail}(S)$는 $S$의 첫 글자를 제거한 것을 의미한다.</li>
</ul>

<p>하지만 이 정의가 평범한 팰린드롬의 정의와 같다는 것에 실망한 코코는 한 단계 더 나아간 “3단 아이스크림”을 정의하였다.</p>

<ul>
	<li>길이 $n$인 아이스크림 문자열 $S$가 주어졌을 때, 길이가 $\left\lceil \frac{n}{3} \right\rceil$인 $S$의 접두사 $S'$를 생각한다.</li>
	<li>다음 중 적어도 하나를 만족하면 $S$는 3단 아이스크림이다.
	<ul>
		<li>$S=S'+\operatorname{rev}(S') +S'$</li>
		<li>$S=S'+\operatorname{tail}(\operatorname{rev}(S')) +S'$</li>
		<li>$S=S'+\operatorname{rev}(S') +\operatorname{tail}(S')$</li>
		<li>$S=S'+\operatorname{tail}(\operatorname{rev}(S')) +\operatorname{tail}(S')$</li>
	</ul>
	</li>
</ul>

<p>예를 들어, <code>DOTTODOT</code>은 <code>DOTTODOT</code> =<code>DOT</code> + <code>TOD</code> + <code>OT</code>이므로 3단 아이스크림이다.</p>

<p>각각의 문자열이 3단 아이스크림 문자열인지 판별해보자.</p>

### 입력 

 <p>첫 줄에는 테스트 케이스의 수 $T$가 주어진다. ($1\le T\le 1000$)</p>

<p>다음 $T$개의 줄 각각에는 알파벳 대문자로 이루어진 문자열이 주어진다. 문자열의 길이는 $6$ 이상 $30$ 이하이다.</p>

### 출력 

 <p>각각의 테스트 케이스에 대해, 주어진 문자열이 3단 아이스크림 문자열이면 <code>1</code>, 아니면 <code>0</code>을 출력한다.</p>

