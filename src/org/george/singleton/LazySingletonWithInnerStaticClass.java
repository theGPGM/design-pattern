package org.george.singleton;

public class LazySingletonWithInnerStaticClass {
    private LazySingletonWithInnerStaticClass(){}

    private static class LazySingletonHolder {
        private static final LazySingletonWithInnerStaticClass instance = new LazySingletonWithInnerStaticClass();
    }

    public static LazySingletonWithInnerStaticClass getInstance(){
        return LazySingletonHolder.instance;
    }

    public static void main(String[] args) {
        LazySingletonWithInnerStaticClass l1 = LazySingletonWithInnerStaticClass.getInstance();
        LazySingletonWithInnerStaticClass l2 = LazySingletonWithInnerStaticClass.getInstance();
        System.out.println(l1 == l2);
    }
}
