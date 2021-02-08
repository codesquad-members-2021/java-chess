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
- [ ] PawnTest Class 생성
    - [ ] JUnit으로 실행
        - 테스트 메소드를 구현하지 않았기 때문에 실패하는 것을 확인한다.
- [ ] create() Method 생성
    - [ ] JUnit 테스트 메소드를 생성 • 실행
        - 테스트 메소드 구현 후 실행하여 성공하는 것을 확인

### create() Method
- [ ] @DisplayName 활용
- [ ] "white" Pawn & "black" Pawn
    -  인스턴스 생성
        - new Pawn("white");
        - new Pawn("black");
    - 테스트 작성
        - assertThat(whitePawn.getColor()).isEqualTo("white");
        - assertThat(blackPawn.getColor()).isEqualTo("black");
- [ ] 테스트 실행
    - 실패 확인

### Pawn Class
- [ field ]
    - [ ] String 타입 color
- [ constructor ]
    - [ ] "white" / "black" 값만 인자로 받기
- [ method ]
    - [ ] getColor() 
    

    
