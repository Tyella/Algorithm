package Algorithm;

import java.util.List;
import java.util.ArrayList;

//最小栈
public class MinStack {

    private List<Integer> list;

    public MinStack(){
        list=new ArrayList<>();
    }

    public void push(int x){
        list.add(x);
    }

    public void pop(){
        list.remove(list.size()-1);
    }

    public int top(){
        return list.get(list.size()-1);
    }

    public int getMin(){
        int min=list.get(0);
        for(int temp:list){
            min=min<temp?min:temp;
        }
        return min;
    }
}
