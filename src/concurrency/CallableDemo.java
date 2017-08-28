package concurrency;
import java.util.ArrayList;
import java.util.concurrent.*;

class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id){
        System.out.println("First constructor + id");
        this.id = id;
    }
    public String call(){
        System.out.println("Then goto call()");
        return "result of TaskWithResult->" + id;
    }
}
public class CallableDemo{
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for(int i = 0; i < 3; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try{
                fs.get();
            }catch (InterruptedException e){
                System.out.println(e);
                return;
            }catch (ExecutionException e){
                System.out.println(e);
            }
            finally {
                exec.shutdown();
            }
        }
    }
}

//the submit() method produces a Future object, parameterized for the particular type of result returned by the Callable
//you can query the Future with isDone() to see if it has completed.
//when the task is completed and has a result,you can call get() to fetch the result
//you can simply call get() without checking isDone(),in which case get() will block until the result it ready.
//you can also call get() with a timeout, or isDone() to see if the task completed.
//before trying to call get() to fetch the result
