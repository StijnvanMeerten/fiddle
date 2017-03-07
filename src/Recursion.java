public class Recursion {
    public static void main( String[] args ) {
        System.out.println(facultyRecursively(6));
        System.out.println(facultyNormally(6));
        System.out.println(sumRecursively(6));
        System.out.println(sumNormally(6));
        System.out.println(calculateOnesInBinaryRepresentationOfNumber(15));
        System.out.println(calculateOnesInBinaryRepresentationOfNumber(16));
        System.out.println(reverseStringRecursively("Recursive"));
    }

    private static int facultyRecursively(int input){
        if(input <= 1) {
            return 1;
        }
        return facultyRecursively(input-1) * input;
    }

    private static int facultyNormally(int input){
        int total = 1;
        for(int i=1; i<=input; i++){
            total = total*i;
        }
        return total;
    }

    private static int sumRecursively(int input){
        if(input <= 1){
            return 1;
        }
        return sumRecursively(input -1) + input;
    }

    private static int sumNormally(int input){
        int total = 0;
        for(int i=1; i<=input; i++){
            total = total + i;
        }

        return total;
    }

    private static int calculateOnesInBinaryRepresentationOfNumber(int input){
        if(input <= 2){
            return 1;
        }else if(input%2 ==1){
            return calculateOnesInBinaryRepresentationOfNumber(input/2)+1;
        }return calculateOnesInBinaryRepresentationOfNumber(input/2);
    }

    private static String reverseStringRecursively(String str){
        if(str.length()<=1){
            return str;
        }
        return str.substring(str.length()-1) +
                reverseStringRecursively(str.substring(0, str.length()-1));
    }
}