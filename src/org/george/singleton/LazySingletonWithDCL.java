package org.george.singleton;

public class LazySingletonWithDCL {
    private static volatile LazySingletonWithDCL instance = null;

    private LazySingletonWithDCL(){}

    public static LazySingletonWithDCL getInstance(){
        if(instance == null){
            synchronized(LazySingletonWithDCL.class){
                if(instance == null){
                    instance = new LazySingletonWithDCL();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        LazySingletonWithDCL l1 = LazySingletonWithDCL.getInstance();
        LazySingletonWithDCL l2 = LazySingletonWithDCL.getInstance();
        System.out.println(l1 == l2);
    }
}
