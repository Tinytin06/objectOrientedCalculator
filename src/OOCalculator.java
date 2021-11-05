import java.util.Scanner;
/**
 * Austin Luu
 * Dincer
 * Programming assignment 1 making a binary/hex calculator
 * started 10/21/21
 * <p>
 * code is supposed to calculate binary and hexadecimal numbers and return them in both decimal
 * and in whatever base system it started in
 **/
public class OOCalculator {
    /**
     *
     * @param Intege the integer being put in the function
     * @return the binary version of the decimal
     */
    public static String deciToBit(int Intege) {
        boolean flag=false;
        if (Intege<0){
            flag=true;
            Intege=Intege*-1;
        }
            String x = Integer.toBinaryString(Intege);//this is to switch from decimal to binary
        if(flag==true){
            x="0"+x;
        }
            return x;
    }

    /**
     *
     * @param Intege the integer being put in the function
     * @return the hexadecimal version of the decimal
     */
    public static String deciToHex(int Intege) {
        boolean flag=false;
        if (Intege<0){
            flag=true;
            Intege=Intege*-1;
        }
        String x = Integer.toHexString(Intege);//this is to switch from decimal to Hexadecimal
        if(flag==true){
            x="-"+x;
        }
        return x;
    }

    /**
     *
     * @param x first value in decimal form
     * @param y second value in decimal form
     * @param operation what the sys.in gets as the operation i.e. Subtraction
     * @return the completed answer to the operation
     */
    public static int calculation(int x, int y, String operation) {
        int sum = 0;
        if (operation.equals("Division")) {//had to break up division from ternary operator because of remainders
            if (x % y != 0) {
                System.out.println("The remainder is " + x % y + ". And ");
            }
            sum = x / y;
        } else {
            sum = operation.equals("Multiplication") ? x * y : operation.equals("Addition") ? x + y : operation.equals("Subtraction") ? x - y : 0;
            //line above checks which operation, does the operation and returns the result as sum
        }
        return sum;
    }

    /**
     *
     * @param number takes input of either binary or hex
     * @param type this tells the function whether it is binary or hex
     * @return a decimal number
     */
    public static int otherToDeci(String number, int type) {
        int y=1;
        if(number.contains("-")){//checks if there is a negative in the number takes it out and puts it in after parseUnassignedInt is done cus that function does not like negatives
            y=-1;
            String replace=number.replace("-","");
            return (Integer.parseUnsignedInt(replace, type)) * y;
        }else {
            String replace = number;
            return (Integer.parseUnsignedInt(replace, type)) * y;
        }
    }

    /**
     *
     * @param n the input of weather it is binary or hex
     * @return the base of the number whether it is 2(binary) or 16(Hex)
     */
    public static int hexOrBit(String n) {
        int x = n.equals("Binary") ? 2 : n.equals("Hexadecimal") ? 16 : 0;
        return x;
    }

    public static void main(String[] args) {
        System.out.println("Please type in Hexadecimal or Binary (Should look like the prompt. spelling and case counts)");
        Scanner h = new Scanner(System.in);
        String n = h.nextLine();
        System.out.println("Please type in the First value. Please use no spaces and use capitals for any letters.");
        String number = h.nextLine();
        int x = otherToDeci(number, hexOrBit(n));
        System.out.println("Please type in the Second value. Please use no spaces and use capitals for any letters.");
        String number2 = h.nextLine();
        int y = otherToDeci(number2, hexOrBit(n));
        System.out.println("Please type Division, Multiplication, Addition, or Subtraction (Please write with correct Spelling and Capitalization as the prompt)");
        String operator = h.nextLine();
        int z = calculation(x, y, operator);
        System.out.println("The Decimal Answer is, " +z+ " the Binary Answer is "+deciToBit(z)+" and the Hexadecimal Answer is "+deciToHex(z)+".");
    }
}
