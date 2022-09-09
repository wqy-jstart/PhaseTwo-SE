package exception;

/**
 * JAVA 异常处理机制
 * java.lang.Throwable是所有异常的超类,下面派生了两个子类型:
 * Exception:一般表示程序出现的异常,是可恢复的异常。
 * Error:一般表示系统级别的错误，不可恢复。
 * 异常处理机制通常不关心Error
 *
 * 异常处理机制:
 * try{
 *     代码片段
 * }catch(XXXException e){
 *     try中出现XXXException后处理代码
 * }
 *
 */
public class TryCatchDemo {
    public static void main(String[] args) {
        //1)
        System.out.println("程序开始了！");
        try {
//            String line =null;----NullPointerException,空指针异常
            String line = "a";
            System.out.println(line.length());
            System.out.println(line.charAt(0));

            //NumberFormatException: For input string: "a"--类型转换错误
            System.out.println(Integer.parseInt(line));//a不能转成数字

            //若try某个语句发生错误,则后面语句不再执行
            System.out.println("!!!!!!!!!!!!!!!!!!!");

            //try中代码不出现下标异常时,catch不会执行
//        }catch (NullPointerException e){
//            System.out.println("出现了空指针异常并且解决了！");
//        }catch (StringIndexOutOfBoundsException e){
//            System.out.println("出现了字符串下标越界异常并且解决了！");
//        }

            //当多个异常具有相同解决办法时可以合并一个catch中解决
        }catch (NullPointerException | StringIndexOutOfBoundsException e){
            System.out.println("出现了空指针或下标越界异常并解决了！");
//使用超类异常可以捕获所有它的子类型异常。如果子类和超类分别有catch的话先先捕获子类型。
        }catch (Exception e){ //用超类来捕获异常,(范围捕获)
            System.out.println("反正就是出了一个错！");
        }
        System.out.println("程序结束了！");

        //2)New异常
        int a=5;
        try{
            //ArithmeticException,运算异常
            System.out.println(a/0);
        }catch (ArithmeticException e) {
            System.out.println("出现了运算异常并且解决了！");
        }
    }
}
