# Robin
안녕하세요 Java 백엔드 과정의 로빈입니다. 깃허브 아이디는 Malaheaven(마라천국) 입니다
##### 미션주제: 체스 게임 2021
## 진행사항 
### 미션 1 : 체스 구현 시작하기
1. 이미 작성되어있는 Junit 테스트 코드 넣을 test 파일 생성.
   * 파일생성
   * PawnTest 클래스 생성
   * 테스트 메소드를 붙이기 전 (구현하지 않았기 때문에)  실패하는 것을 확인.
2. 테스트 코드 기반으로 Pawn 클래스 생성.
3. Pawn 클래스에 생성자와 getColor 메소드 개발.
4. 테스트 코드가 문제 없이 잘 실행되는지 확인.
5. PawnTest 클래스에서 Create() 메소드에 검은색 폰 검증 코드 작성
6. 흰 폰과 검은색 폰 검증을 위한 코드가 Create() 메소드에서 중복작성 되어있는 것을 발견! -> 리팩토링 진행
   *  verifyPawn 메소드를 추가해 중복 코드 제거
   
### 미션 2 : 체스판 생성

1. 색이 없는 Pawn을 생성하는 경우 기본적으로 흰색 말을 생성하도록 Pawn에 두 번째 생성자를 추가
2. Pawn 클래스에 색깔을 상수로 적용(흰색, 검정색)
3. BoardTest 코드 추가
4. 패키지 분리
   * pieces 패키지를 추가하여 Pawn 클래스 및 PawnTest를 해당 패키지로 이동.
5. 추가테스트
   * 체스판에 Pawn 객체 이외의 객체가 추가되지 않도록 설정
   * Pawn 객체 이외의 다른 객체를 추가하면 컴파일 에러 발생.
6. BoardTest 중복제거
   * @BeforeEach을 이용해 Board객체 각 테스트 마다 모두 생성되게 함.
   * 중복되는 코드 verifyBoard() 메소드를 통해 개선함.

### 미션 3 : 보드 초기화 하기

1. PawnTest에 요구사항 코드 추가 
2. Pawn 클래스
   1. Pawn 색에 따른 표시 문자 부여
      * whitePiece -> 'p'
      * blackPiece -> 'P'
   2. Pawn 생성자 public Pawn(String color, char representation) 로 변경 (기존: public Pawn(String color))
3. BoardTest 요구사항 코드 적용
4. Board Class 
   1. 흰색 Pawn과 검은색 Pawn을 생성해 저장하는 List를 추가
      * List<Pawn> piece = new ArrayList<>();
   2. whitePawnsAdd(Pawn piece): 흰색 폰 리스트에 add 해주는 메소드
   3. whitePawnsAdd(Pawn piece): 검은색 폰 리스트에 add 해주는 메소드
   4. findWhitePawn(int index): 흰색 폰 리스트에서 인덱스 번호로 리스트 안에 들어있는 원소를 찾을 수 있는 메소드
   5. findBlackPawn(int index): 검은색 폰 리스트에서 인덱스 번호로 리스트 안에 들어있는 원소를 찾을 수 있는 메소드
   6. size(): Board에 추가되는 기물 size를 구하는 메소드
   7. initialize(): 흰색 Pawn 열에 보드 사이즈 만큼 pppppppp 추가 검은색 Pawn 열에 PPPPPPPP 추가
   8. getWhitePawnsResult(): 흰색 Pawn 열의 값이 return 될 수 있도록 적용
   9. getBlackPawnsResult(): 검정색 Pawn 열의 값이 return 될 수 있도록 적용
   10. print(): 체스판의 현재 상태를 콘솔 화면에 출력이 가능하게 해주는 메소드 
5. GameMain 클래스 구현
   1. main()메소드에 체스게임을 시작하고 종료하는 기능을 추가
      * `start` 명령을 입력하면 체스게임을 시작하고 체스판의 현재 상태를 콘솔 화면에 출력
      * `end` 명령을 입력하면 체스 게임을 종료하고 `Bye~` 를 출력
   
      <출력 결과>
      ```
      ........
      PPPPPPPP
      ........
      ........
      ........
      ........
      pppppppp
      ........
      ```

#### 미션4 : 모든 기물 배치하기

1. "\n"의 반복 코드 제거
   * Java 패키지 밑에 utils 패키지 생성
   * utils.StringUtils 클래스를 생성
   * 운영체제에 따라 달라질 수 있는 단점을 보완하기 위해 `System.getProperty("line.separator")`으로 구현 및 상수로 만듬
   * `appendNewLine("str")` 로 인자로 전달한 메소드에 newline을 추가하는 기능을 구현
   * 생성자를 `private`으로 선언해서 StringUtils 클래스를 직접 생성할 수 없도록 함

2. Pawn 클래스 이름을 Piece로 rename 및 팩토리 메소드 생성
   * Pawn 클래스를 좀더 일반적인 클래스 이름인 Piece로 바꾼다(Piece는 색상과 이름을 가진다.)
   * Piece는 값 객체여야 해서, private 생성자를 가지도록 함 (인스턴스를 생성한 이후에는 인스턴스의 상태 값을 변경할 수 없어야 한다.)
   * 기물의 종류를  pawn, knight, rook, bishop, queen, king으로 구분
   * 각 기물에 대한 표시 문자 상수로 적용  
   * 기물에 대한 내용은 객체를 생성해서 넘겨주는 팩토리 메소드로 구현: 팩토리를 통해서 객체를 가져오도록 함.
   * piece의 색상을 구분할 수 있는 isWhite 및 isBlack 메소드 생성

3. 전체 기물 상태를 볼 수 있는 체스판 구현(Board 클래스) 
   * Board 클래스를 수정하기 위한 BoardTest 요구사항 코드 작성
   * 각 기물에 대한 List 추가
   * 각 기물List에 대한 add 메소드 추가
   * 보드 초기화 부분 초기화 될 기물들 추가
   * printBoard() 이름 -> showBoard()로 변경 
   * showBoard()에 중복되어 작성되었던 줄바꿈 utils.StringUtils 클래스의 appendNewLine메소드를 활용하여 변경
   
   
