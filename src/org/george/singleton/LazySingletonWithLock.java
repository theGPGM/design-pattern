package org.george.singleton;

public class LazySingletonWithLock {
    private static LazySingletonWithLock instance = null;

    private LazySingletonWithLock(){}

    public synchronized static LazySingletonWithLock getInstance(){
        if(instance == null){
            instance = new LazySingletonWithLock();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingletonWithLock l1 = LazySingletonWithLock.getInstance();
        LazySingletonWithLock l2 = LazySingletonWithLock.getInstance();
        System.out.println(l1 == l2);
    }
}
