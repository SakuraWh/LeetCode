package main.middle;

/**
 * 双指针，字符串
 */
public class Daily_OneAwayLcci {
    /**
     *
     * 1.判断长度，不符合：+1,-1,0->false
     * 2.0进行替换字符操作判断
     * 3.+1-1进行增加删除字符判断
     *
     * 替换判断：顺序遍历，只允许一个不同的字符
     * 增加，删除判断：顺序遍历，只允许一个缺少字符
     *
     *
     */
    public boolean oneEditAway(String first, String second) {
        int len_f = first.length();
        int len_s = second.length();
        if(Math.abs(len_f-len_s)>=2)
            return false;
        if(len_f-len_s == 0){
            boolean k=true;
            for (int i = 0; i < len_f; i++) {
                if(first.charAt(i)!=second.charAt(i)){
                    if(k)
                        k=false;
                    else
                        return false;
                }
            }
            return true;
        }else {
            if(len_f > len_s)
                return addCheck(second,first);
            else
                return addCheck(first,second);
        }
    }
    private boolean addCheck(String a, String b){
        int k = 0;
        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i+k)){
                if(k==0){
                    k=1;
                    i--;
                }
                else
                    return false;
            }
        }
        return true;
    }
}
