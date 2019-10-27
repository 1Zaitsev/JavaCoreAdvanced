package lesson5;

public class MyThreadDemo {
    static final int SIZE = 1000000;

    public static void runSingleThread(int size){
        float[] array = createArray(size);

        long time = System.currentTimeMillis();

        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void runMultiThread(int size, int parts){
        float[] array = createArray(size);
        float[][] arrays = new float[parts][];
        int partSize = size/parts;

        long time = System.currentTimeMillis();

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = new float[partSize];
            System.arraycopy(array, i * partSize, arrays[i], 0, partSize);
        }

        MyThread[] mt = new MyThread[parts];

        for (int i = 0; i < mt.length; i++) {
            mt[i] = new MyThread(arrays[i]);
            mt[i].start();
        }

        for (MyThread thread: mt) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < arrays.length; i++) {
            System.arraycopy(arrays[i], 0, array, i * partSize, partSize);
        }

        System.out.println(System.currentTimeMillis() - time);
    }

    private static float[] createArray(int size) {
        float[] array = new float[size];

        for (float f: array) {
            f = 1;
        }

        return array;
    }

    public static void main(String[] args) {
        runSingleThread(SIZE);
        runMultiThread(SIZE, 2);
        runMultiThread(SIZE, 4);
        runMultiThread(SIZE, 8);
    }
}
