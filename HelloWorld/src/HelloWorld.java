public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        /*
        primitive data types in java:
            int is an integer (a whole number)
            double is a decimal
            float is also a decimal (but worse)
            boolean is true or false
            char is a single thing (inside of '')
        non primitive data types
            String is a sequence of chars (inside of "")
            Array is a container for things of the same type
        */

        int intNumber = 15;
        double decimalNumber = 3.14;
        float floatNumber = 5.7f;
        boolean booleanVariable = true;
        char character = '6';
        String stringVariable = "This is a String!";
        System.out.println(stringVariable);

        /*
        arithmetic operators in java: +, -, /, *, and % (modulus, gives the remainder of division)
        relational operators: >, <, >=, <=, ==, !=
         */

        System.out.println( decimalNumber != intNumber );

        int[] integerArray = {1, 2, 8, 4, 6};
        boolean[] booleanArray = {true, false, true, true};

        // note: index 0 is the first element

        System.out.println(integerArray[2]);

        for(int i=0; i < integerArray.length; i++){
            System.out.println(integerArray[i]);
        }
    }
}