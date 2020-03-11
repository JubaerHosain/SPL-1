package ProgrammerCalculator;

public class NumberConverter {
    //converts decimal to binary
    public String DecimalToBinary(String dec){
        String binary = "";
        long decimal = Long.valueOf(dec);
        long reminder;

        while (decimal != 0){
            reminder = decimal % 2;
            binary += reminder;
            decimal /= 2;
        }

        binary = reverse(binary);
        return binary;
    }

    //converts decimal to octal
    public String DecimalToOctal(String dec){
        String octal = "";
        long decimal = Long.valueOf(dec);
        long reminder;

        while (decimal != 0){
            reminder = decimal % 8;
            octal += reminder;
            decimal /= 8;
        }

        octal = reverse(octal);
        return octal;
    }

    //converts decimal to hexadecimal
    public String DecimalToHexadecimal(String dec){
        String hexadecimal = "";
        long decimal = Long.valueOf(dec);
        long reminder;
        char array[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(decimal != 0){                     //convert integer part
            reminder =  decimal % 16;
            hexadecimal += array[(int)reminder];
            decimal /= 16;
        }

        hexadecimal = reverse(hexadecimal);

        return hexadecimal;
    }

    //converts binary to decimal
    public String BinaryToDecimal(String bin){
        char binary[] = bin.toCharArray();
        long sum = 0;
        long pow;

        int exp = binary.length - 1;
        int index = 0;

        while(exp>=0){
            int num = binary[index] - 48;
            pow = (long)Math.pow(2, exp);
            sum += num * pow;
            exp--;
            index++;
        }
        return String.valueOf(sum);
    }

    //converts binary to octal
    public String BinaryToOctal(String bin){
        String decimal = BinaryToDecimal(bin);
        String octal = DecimalToOctal(decimal);

        return octal;
    }

    //converts binary to hexadecimal
    public String BinaryToHexadecimal(String bin){
        String decimal = BinaryToDecimal(bin);
        String Hexadecimal = DecimalToHexadecimal(decimal);

        return Hexadecimal;
    }

    //converts octal to decimal
    public String OctalToDecimal(String oct){
        char octal[] = oct.toCharArray();
        long sum = 0;
        long pow ;

        int exp = octal.length - 1;
        int index = 0;

        while(exp>=0){
            int num = octal[index] - 48;
            pow = (long)Math.pow(8, exp);
            sum += num * pow;
            exp--;
            index++;
        }
        return String.valueOf(sum);
    }

    //converts octal to binary
    public String OctalToBinary(String oct){
        String decimal = OctalToDecimal(oct);
        String binary = DecimalToBinary(decimal);

        return binary;
    }

    //converts octal to hexadecimal
    public String OctalToHexadecimal(String oct){
        String decimal = OctalToDecimal(oct);
        String Hexadecimal = DecimalToHexadecimal(decimal);

        return Hexadecimal;
    }


    //converts hexadecimal to decimal
    public String HexadecimalToDecimal(String hex){
        char hexadecimal[] = hex.toCharArray();
        long sum = 0;
        long pow;

        int exp = hexadecimal.length - 1;
        int index = 0;
        int num;

        while(exp>=0){
            switch(hexadecimal[index]){
                case 'A':
                    num = 10;
                    break;
                case 'B':
                    num = 11;
                    break;
                case 'C':
                    num = 12;
                    break;
                case 'D':
                    num = 13;
                    break;
                case 'E':
                    num = 14;
                    break;
                case 'F':
                    num = 15;
                    break;
                default:
                    num = hexadecimal[index] - 48;
                    break;
            }
            pow = (long)Math.pow(16, exp);
            sum += num * pow;
            exp--;
            index++;
        }
        return String.valueOf(sum);
    }

    //converts hexadecimal to binary
    public String HexadecimalToBinary(String hex){
        String decimal = HexadecimalToDecimal(hex);
        String binary = DecimalToBinary(decimal);

        return binary;
    }

    //converts hexadecimal to octal
    public String HexadecimalToOctal(String hex){
        String decimal = HexadecimalToDecimal(hex);
        String octal = DecimalToOctal(decimal);

        return octal;
    }

    //reverse string
    public String reverse(String s){
        int i, j, l = s.length();
        char array[] = s.toCharArray();

        for(i=0,j=l-1;  i <= l/2;  i++,j--){
            if(i > j){
                break;
            }
            char ch = array[i];
            array[i] = array[j];
            array[j] = ch;
        }
        s = String.valueOf(array);
        return s;
    }

    public static void main(String args[]) throws Exception{
        NumberConverter c = new NumberConverter();
        System.out.println(c.BinaryToDecimal("11111"));
    }
}
