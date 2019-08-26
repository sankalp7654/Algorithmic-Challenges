import java.util.*;
import java.util.concurrent.*;

class ExecutorDemo {
    public static void main(String[] args) {
        
        try{
            ExecutorService es = Executors.newFixedThreadPool(4);

            Callable<String> task1 = () ->  "Task 1 is executed";
            Callable<String> task2 = () ->  "Task 2 is executed";
            Callable<String> task3 = () ->  "Task 3 is executed";
            
            Collection<Callable<String>> tasks = Arrays.asList(task1, task2, task3);

            List<Future<String>> list = es.invokeAll(tasks);

            for(Future<String> object : list) {
                System.out.println(object.get());
            }

        }
        catch(Exception e) {
            System.out.println("Inside an exception block");
        }

    }
}
