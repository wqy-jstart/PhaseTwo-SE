package exception;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 重写一个含有throws声明异常抛出的的方法,对throws的重写规则
 */
public class ThrowsDemo {//------超类
    public  void  dosome()throws IOException,AWTException {}
}
class SubClass extends ThrowsDemo{//-----子类
    /**
     * 子类在重写超类方法时,方法抛出的异常规范如下：
     * @throws ArithmeticException
     */
//   public void dosome()throws  IOException,AWTException{}
    //允许不在抛出任何异常
//    public void dosome(){}
    //允许仅抛出部分异常
//    public void dosome()throws IOException{}
    //允许抛出超类方法抛出异常的子类型异常
//    public void dosome()throws FileNotFoundException{}
    //不允许抛出额外异常(超类没有抛出的且也不存在继承关系的异常)
//    public void dosome()throws SQLException{}
    //不允许抛出超类方法抛出异常的超类异常
//    public void dosome()throws Exception{}
}
