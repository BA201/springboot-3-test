import org.junit.jupiter.api.Test;
import Annotation.hi;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;

public class reflect {
    /**反射**/
    public static void main(String[] args) {

    }


    //使用反射创建对象
    @Test
    public void reflect1() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> cls = person.class;
        Constructor<?> con = cls.getConstructor(String.class, int.class);
        person pe = (person)con.newInstance("zhang", 44);
        int age = pe.getAge();
        System.out.println(age);
        Field na = cls.getDeclaredField("name");
        na.setAccessible(true);
        na.set(pe,"傻狗");
        System.out.println(pe);
        Field aa = cls.getField("age");
        aa.set(pe,77);
        System.out.println(pe);
        Method me = cls.getMethod("getName");
        String fang =(String) me.invoke(pe);
        System.out.println(fang);

        person pp = new person();
        Class<?> pr = pp.getClass();
        //这个只能获取公有的属性
        Field[] f = pr.getFields();
        for(Field a : f)
        {
            System.out.println(a);
        }
        //这个可以获取私有属性;
        Field[] f1 = pr.getDeclaredFields();
        for(Field b: f1)
        {
            System.out.println(b);
        }

        //获取方法上的注解
        Method[] m1 = pr.getDeclaredMethods();



        for(Method b: m1)
        {
            //获取修饰符和返回值和参数。
            String modifi = Modifier.toString(b.getModifiers());
            Annotation[] anno = b.getAnnotations();
            Class<?> ret = b.getReturnType();
            Parameter[] para = b.getParameters();
            if(anno!=null)
            {
                for(Annotation a: anno)
                {
                    System.out.println("注解："+a.toString());
                }
            }else{
                System.out.println("没有注解");
            }
            System.out.println("权限修饰符："+modifi);
            System.out.println("返回值类型："+ret);
            System.out.println("方法名："+b.getName());
            for(Parameter c : para)
            {
                System.out.println("参数："+c);
            }
        }

    }

}
