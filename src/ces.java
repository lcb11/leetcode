import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ces {
    static List<Integer> s=new ArrayList<>();

        public static String toBinary(int x) {
            return String.format("%5s", Integer.toBinaryString(x)).replaceAll(" ", "0");
        }

        public static void main(String[] args)
        {
            //System.out.println(toBinary(7));
            //System.out.println(toBinary(9));
            System.out.println(grayCode(5));
        }


    public static List<Integer> grayCode(int n) {

        List<Integer> res=new ArrayList<Integer>();
        res.add(0);

        dfs(n,res);
        return s;
    }

    public static void dfs(int n,List<Integer> res){

        if(res.size()==Math.pow(2,n)){
            s=new ArrayList<Integer>(res);
            return;
        }
        String pre=twoCode(res.get(res.size()-1));
        for(int i=1;i<Math.pow(2,n);i++){
            if(!res.contains(i)){
                String next=twoCode(i);
                if(compareTwoCode(pre,next)&&res.size()!=Math.pow(2,n)-1){
                    res.add(i);
                    dfs(n,res);
                    res.remove(res.size()-1);
                }
                if(res.size()==Math.pow(2,n)-1){
                    String first=twoCode(0);
                    if(compareTwoCode(pre,next)&&compareTwoCode(first,next)){
                        res.add(i);
                        dfs(n,res);
                        //res.remove(res.size()-1);
                    }
                }
            }

        }


    }

    public  static String twoCode(int n){
        return String.format("%5s", Integer.toBinaryString(n)).replaceAll(" ", "0");
    }

    public static boolean compareTwoCode(String pre,String next){
            int isExit=0;
        for(int i=0;i<pre.length();i++){
            if(pre.charAt(i)!=next.charAt(i)){
                isExit++;
            }
        }
        if(isExit==1){
            return true;
        }
        return false;
    }

}
