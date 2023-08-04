import java.io.*;
import java.nio.charset.StandardCharsets;

public class iostream {
    public static void main(String[] args) throws IOException {

        BufferedWriter file3=null;
        try {
            File file1 = new File("D:\\桌面\\java学习笔记\\w.txt");
//        输出流
//创建缓冲流和输入流
            FileWriter file2 = new FileWriter(file1, StandardCharsets.UTF_8);
            file3 = new BufferedWriter(file2);
            file3.write("字符串输出流测试");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
//            关闭缓冲流，就会间接关闭输出流
            if(file3!=null)
            {
                file3.close();
            }
        }

    }
}
