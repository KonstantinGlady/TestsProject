package chapter10.sync;

public class ClassOLL2 {

   public void method() {

       //lock on object , for class use ClassOLL2.class (for static)
       synchronized(this) {
           System.out.println("synchronized block");
       }
   }
}
