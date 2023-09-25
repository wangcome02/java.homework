//用Java测试1~50阶乘消耗的毫秒级时间
public class Q7 {
    //阶乘函数
    public  static long fac(int n) {    //Java中调用非static方法必须通过对象实现
        if(n == 1)
            return 1;
        else
            return n*fac(n-1);
    }

    public static void main(String[] args){
        long startTime = System.nanoTime();
        fac(50);
        long endTime = System.nanoTime();
        double escapeTime= (endTime-startTime)/1000000.0;
        System.out.println("运行时间为："+ escapeTime);
    }
}
