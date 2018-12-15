package Algorithm;

import java.util.Stack;

//简化路径
public class simplifyPath {
    public String simplifyPath(String path){
        Stack<String> stack=new Stack<>();
        String[] list=path.split("/");
        for(String str:list){
            if(!stack.isEmpty() && str.equals(".."))
                stack.pop();
            else if(!str.equals(".") && !str.equals("") && !str.equals(".."))
                stack.push(str);
        }
        return "/"+String.join("/",stack);  //JDK8新增的join()方法
    }
}
