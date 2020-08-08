package org.george.singleton;

public enum  LazySingletonWithEnum {
    INSTANCE;

    public static void main(String[] args) {
        LazySingletonWithEnum l1 = LazySingletonWithEnum.INSTANCE;
        LazySingletonWithEnum l2 = LazySingletonWithEnum.INSTANCE;
        System.out.println(l1 == l2);
    }
}
