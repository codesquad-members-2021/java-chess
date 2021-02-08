# 체스 게임
## 진행 방법
* 체스 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)
* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtu.be/a5c9ku-_fok)

## 요구 사항 정리

### PawnTest Class
- [X] PawnTest Class 생성
    - [X] JUnit으로 실행 
        - 테스트 메소드를 구현하지 않았기 때문에 실패하는 것을 확인한다.
        - ⁕ 테스트 메소드를 구현하지 않은 상태로 실행 시 ClassNotFoundException 발생.
- [X] create() Method 생성
    - [X] JUnit 테스트 메소드를 생성 • 실행
        - 테스트 메소드 구현 후 실행하여 성공하는 것을 확인
        - ⁕ Test passed

### create() Method
- [X] @DisplayName 활용
- [X] "white" Pawn
    -  인스턴스 생성
        - new Pawn("white");
    - 테스트 작성
        - assertThat(whitePawn.getColor()).isEqualTo("white");
- [X] 테스트 실행
    - 실패 확인

### Pawn Class
- [X] "black" Pawn
    -  인스턴스 생성
        - new Pawn("black");
    - 테스트 작성
        - assertThat(blackPawn.getColor()).isEqualTo("black");
    - @DisplayName 내용 변경
- [X] 테스트 실행
  - 성공 확인

- [ field ]
    - [X] String 타입 color
- [ constructor ]
    - [X] String 타입 color 파라미터
- [ method ]
    - [X] getColor() 제대로 구현
    
### 리팩토링
- Pawn class 
  - [ ] "white" / "black" 값만 인자로 받기
    
- PawnTest class
  - [X] local variable 추가
    - "white" / "black" 값 변수로 관리
    - ⁕ 클래스 변수였어도 좋았을 것 같다 
        - Pawn을 생성해서 사용해야하는 다른 테스트 메소드들이 추가되면 기본적으로 color 변수는 필요하지 않을까
  - [X] verifyPawn() 추가
    - Pawn 생성과 결과 값 확인 부분 중복 제거
    
### 겪었던 문제
1. 테스트 클래스 생성 불가
   - **내용**
     - 빈 Pawn class에 대해 PawnTest.java가 인식되지 않음 
   - **해결** 
     - MainTest.java라는 이름의 테스트 클래스는 인식 → MainTest.java를 생성하고 그 아래 public이 아닌 PawnTest class 생성
     - (-) 요구사항에 있는 테스트 코드는 public class PawnTest
    
2. No tasks available
    - **내용** 
      - 테스트 클래스 혹은 특정 메소드를 run 할 시 아무 것도 실행이 되지 않음
      - 'no tasks availabe' 메세지 발생
    - **해결**
        -  Settings > Build, Execution, Deployment > Build Tools > Gradle 에서 Run tests using: `IntelliJ IDEA`로 수정
        - [참조](https://stackoverflow.com/questions/57908805/no-tasks-available-when-executing-junit-runner-class)
    


    
