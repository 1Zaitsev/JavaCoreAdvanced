package lesson2.myException;

import java.util.Random;

public class MyExceptionDemo {

    static String[][] createArray(int row, int cell){
        Random random = new Random();
        String[][] result = new String[row][cell];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = String.valueOf(random.nextInt(10));
            }
        }
        return result;
    }

    static void printArray(String [][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int arrayAmount(String[][] array, int validSize) throws MyArrayDataException, MyArraySizeException {
        int result = 0;
        if(array.length > validSize)
            throw new MyArraySizeException("Invalid main array size: " + array.length);
        for (int i = 0; i < array.length; i++) {
            if(array[i].length > validSize)
                throw new MyArraySizeException("Invalid secondary array size. Array[" + i + "] is " + array[i].length);
            for (int j = 0; j < array[i].length; j++) {
                try {
                    result += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i ,j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        final int VALID_SIZE = 4;

        String[][] test1 = createArray(VALID_SIZE, VALID_SIZE);
        printArray(test1);
        try{
            System.out.println("Array amount = " + arrayAmount(test1, VALID_SIZE));
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("_____________________________");

        String[][] test2 = createArray(4, 5);
        printArray(test2);
        try{
            System.out.println("Array amount = " + arrayAmount(test2, VALID_SIZE));
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("_____________________________");

        String[][] test3 = createArray(VALID_SIZE, VALID_SIZE);
        Random random = new Random();
        test3[random.nextInt(VALID_SIZE)][random.nextInt(VALID_SIZE)] = "A";
        printArray(test3);
        try{
            System.out.println("Array amount = " + arrayAmount(test3, VALID_SIZE));
        }catch (MyArrayDataException e){
            e.printStackTrace();
        }catch (MyArraySizeException e){
            e.printStackTrace();
        }
        System.out.println("_____________________________");
    }

}
