package LambdaExpressions_05.Lesson_33;

interface Executable {
    void execute();
}

class Runner {
    public void run(Executable e) {
        e.execute();
    }
}

//class ExecutbleImplemetation implements Executable {
//
//    @Override
//    public void execute() {
//        System.out.println("Hello");
//    }
//}

public class Test {
    public static void main(String[] args) {
/*        Thread thread = new Thread(() -> {

        });
//          без лямды
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        });  */


        Runner runner = new Runner();
        //способ 1
//        runner.run(new ExecutbleImplemetation());

        //способ 2
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("Hello");
            }
        });

        //способ 3(с лямбда)
        runner.run(() -> {
            System.out.println("Hello");
        });
    }
}
