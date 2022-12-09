
// 注解的测试
public class AnnotationTest {

    // @Override 重写的注解
    @Override
    public String toString() {
        return super.toString();
    }
    
    @Deprecated
    public static void test(){
        System.out.println("Deprecated");
    }

    public static void main(String[] args) {
        test();
    }
}
