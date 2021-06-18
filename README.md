# Calculator

## 개요
- sin, cos, tan, C, (), %, ←, 1/x, x², √, = 그 외 숫자, 사칙연산이 가능한 계산기

## 관련 지식
- 삼각함수(sin, cos, tan)와 루트(√)를 계산하기 위하여 java.lang.Math를 import 해야 한다.
- 정수형이 실수로 표기되지 않도록 DecimalFormat 메소드를 활용해야 한다.
- 형 변환을 위하여 Double.parseDouble(실수형)과 String.valueOf(문자형)를 사용한다.

## 실행 결과
![image](https://user-images.githubusercontent.com/73567158/122508708-5c984e80-d03d-11eb-9820-7b19255b2a0d.png)

## 아쉬운 점
- +/-, (), C, = 등 덜 구현된 부분이 있고, 공학 계산 후 사칙연산은 되나 그 반대는 안된다.
