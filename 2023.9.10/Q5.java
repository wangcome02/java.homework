//用java编写程序，测试字符串”你好，欢迎来到Java世界“的长度，将字符串的长度转换成字符串进行输出
//对其中的“Java”四个字母进行截取，输出截取字母以及它在字符串中的位置
public class Q5 {
    public static void main(String[] args) {
        String input_string = "你好，欢迎来到Java世界";
        int len = input_string.length();        //获取字符串长度
        String len_to_string = Integer.toString(len);

        System.out.println("字符串长度为：" + len_to_string);

        //截取Java找位置
        int goal = input_string.indexOf("Java");
        System.out.println(goal);
        if(goal != -1){
            for(int i = 0; i < 4; i++) {
                String str = input_string.substring(goal+i, goal+i+1);
                System.out.println("输出的字符为：" + str);
                System.out.println("字符位置为："+ (goal + i));       //Java输出函数中+表连接含义，
                                                                    // 因此数据相加需要添加括号
            }
        }else{
            System.out.println("不存在目标字符串");
        }

    }
}
