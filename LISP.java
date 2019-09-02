import java.util.Stack;

public class LISP {

    public static void main(String[] args){
        String testVal = "(I am a(test)(test23)$#())";
        System.out.println(verifyLISPCode(testVal) ? "Good" : "Bad");
        System.out.println(verifyLISPCode("") ? "Good" : "Bad");
        System.out.println(verifyLISPCode(")") ? "Good" : "Bad");
        System.out.println(verifyLISPCode("()()") ? "Good" : "Bad");
        System.out.println(verifyLISPCode("()(()") ? "Good" : "Bad");
    }

   public static boolean verifyLISPCode(String code) 
    {
        if (code == null || code.length() == 0) return true;
        String value = code.replaceAll("[^()]","");
        Stack lispStack = new Stack();
        
        for (char c : value.toCharArray()) {
            switch(c){
                case('('):
                    lispStack.push("(");
                    break;
                case(')'):
                    if (lispStack.empty() || lispStack.peek() != "(") return false;
                    lispStack.pop();
                    break;
            }
        }
    
        return lispStack.empty();
    }
}