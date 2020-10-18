public class Test {

    public static void main(String[] args){
        /*String text = "mamam";
        System.out.println("Apakah " + text + " merupakan palindrome ? " + apaPalindrome(text));*/

        GenerikStack<String> generikStack = new GenerikStack<>();
        generikStack.push("Ocky");
        generikStack.push("Neni");
        generikStack.push("Love");

        System.out.println(generikStack.poop());
        System.out.println(generikStack.getSize());
    }

    public static  boolean apaPalindrome(String s){
        if(s.length() <= 1){
            return  true;
        }else if (s.charAt(0) != s.charAt(s.length() - 1)){
            return false;
        }else {
            return apaPalindrome(s.substring(1, s.length() - 1));
        }
    }
}
