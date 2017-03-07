package Lists;

public class SymbolChecker {
    public static boolean checkBrackets(String input){
        HANStack hanStack = new HANStack();
        char[] chars = input.toCharArray();
        for(Character character : chars){
            if(character ==  '('){
                hanStack.push(character);
            }else if(character == ')'){
                if(hanStack.getSize()>0) {
                    hanStack.pop();
                } else{
                    return false;
                }
            }
        }
        if(hanStack.getSize()>0){
            return false;
        }
        return true;
    }
}
