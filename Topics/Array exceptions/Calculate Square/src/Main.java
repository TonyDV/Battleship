
class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        if (array != null && index >= 0 && index < array.length - 1) {
            System.out.println(array[index] * array[index]);
        } else {
            System.out.println("Exception!");
        }

    }
}