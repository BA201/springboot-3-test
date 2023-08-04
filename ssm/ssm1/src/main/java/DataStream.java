import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;

public class DataStream {
    public static void main(String[] args) throws IOException {
        DataInputStream file2=null;
        try {
//        数据流更简单
//        创建文件
            File file=new File("D:\\桌面\\java学习笔记\\e.txt");
            if(!file.exists())
            {
                System.out.println("没有找到该文件");
            }
//        创建输入流
            FileInputStream file1 = new FileInputStream(file);
//        创建数据流
             file2 = new DataInputStream(file1);

            String f = file2.readUTF();

            System.out.println(f);
        } catch (IOException e) {
          e.printStackTrace();
        }finally {
                if(file2!=null)
                {
                    file2.close();
                }
        }

    }
    @Test
    public void text1() throws IOException {
        DataOutputStream o1=null;
        try {
//        数据流
            o1 = new DataOutputStream(new FileOutputStream("D:\\桌面\\java学习笔记\\e.txt"));
            o1.writeUTF("数据流真垃圾");
            o1.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(o1!=null)
            {
             o1.close();
            }
        }
    }

    //tcp网络编程发送
    @Test
    public void sent() throws IOException {
        OutputStreamWriter oo=null;
        try {
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            //创建套接字
            Socket so =new Socket(ip,8899);
            //创建输出流
            OutputStream out = so.getOutputStream();
            oo = new OutputStreamWriter(out);
            oo.write("牛逼啊小子");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(oo!=null)
            {
                oo.close();
            }
        }


    }

    //tcp网络编程接受
    @Test
    public void accept() throws IOException {
        Socket s1=null;
        InputStream in=null;
        try {

            ServerSocket so=null;
            so=new ServerSocket(8899);
            s1= so.accept();
             in = s1.getInputStream();
            byte[] c = new byte[8];
            int len;
            ByteArrayOutputStream arr = new ByteArrayOutputStream();
            while((len=in.read(c))!=-1)
            {
                arr.write(c,0,len);
            }

            System.out.println(arr.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(s1!=null)
            {
                s1.close();
            }
            if(in!=null)
            {
                in.close();
            }
        }


    }

    //upd编程，思路，先创建一个datagramscoket负责发送报文，而datagrampacket就是数据报文存储用的，发送接受都需要使用。
    @Test
    public void udpSent()
    {
        DatagramSocket so = null;
        try {
            InetAddress ip =InetAddress.getLocalHost();
            //首先创建报文套接字
            so = new DatagramSocket();
            //然后创建字节
            String w = "你小子真行啊";
            byte[] f = w.getBytes();
            //创建报文包
            DatagramPacket pack = new DatagramPacket(f,0,f.length,ip,3334);
            //发送保温包
            so.send(pack);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        so.close();
    }

    //upd变成接受
    @Test
    public void updAccept()
    {
        DatagramSocket so=null;
        try {
            //创建DataGramSocket用来接受数据包
             so= new DatagramSocket(3334);
            //创建DatagramPacket用来存放接受过来的数据
            DatagramPacket pa=new DatagramPacket(new byte[1024],0,1024);
            //接受数据,将接受的数据存入pa中
            so.receive(pa);
            System.out.println(new String(pa.getData(),0,pa.getLength()));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            so.close();
        }
    }


}
