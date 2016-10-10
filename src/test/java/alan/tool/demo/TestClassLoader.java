/**
 * 
 */
package alan.tool.demo;

/**
 * @author WangHui
 *
 * 2016年9月27日
 */
public class TestClassLoader {
	   public static void main(String[] args) throws ClassNotFoundException { 
           ClassLoader loader = TestClassLoader.class.getClassLoader(); 
           System.out.println(loader); 
           //使用ClassLoader.loadClass()来加载类，不会执行初始化块 
//           loader.loadClass("alan.tool.demo.Test2"); 
           
           //使用Class.forName()来加载类，默认会执行初始化块 
//           Class.forName("alan.tool.demo.Test2"); 
           
           //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块 
           Class.forName("alan.tool.demo.Test2", false, loader); 
   } 
}
