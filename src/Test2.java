public class Test2 {
    static {
        System.out.println("1");
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                System.out.println("asd");
            }
        });
        System.out.println("2");
    }

    public void biz()
    {
        System.out.println("biz");
    }
}
