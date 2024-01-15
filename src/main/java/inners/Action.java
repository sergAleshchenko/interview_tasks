package inners;

public interface Action {
    static void newService() {}
    default void newService2() {}

    class StaticService {
        static void service() {
        }

        void service2() {
        }
    }

    class A {
        void method() {

        }
    }

}
