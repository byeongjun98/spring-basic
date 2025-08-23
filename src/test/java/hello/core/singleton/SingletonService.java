package hello.core.singleton;
/*
1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
2. 이 객체 인스턴스가 필요하면 오직 getInstance() 메서드를 통해서만 조회 가능. 이 메서드를 호출하면 항상 같은 인스턴스 반환
3. 딱 1개의 객체 인스턴스만 존재하야 하므로, 생성자를 private 으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.

- private 으로 new 키워드를 막아두었다
- 호출할 때마다 같은 객체 인스턴스를 반환하는 것을 확인
* 참고: 싱글톤 패턴을 구현하는 방법은 여러가지. 여기서는 객체를 미리 생성해두는 가장 단순하고 안전한 방법을 선탟
 */

public class SingletonService {
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {}


    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
