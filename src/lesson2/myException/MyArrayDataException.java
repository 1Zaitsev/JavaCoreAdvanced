package lesson2.myException;

public class MyArrayDataException extends NumberFormatException {
    int row, cell;

    public MyArrayDataException(int row, int cell){
        super("Invalid data type in cell: " + row + ", " + cell + ".");
    }
}
