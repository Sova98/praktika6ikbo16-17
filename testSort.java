import java.util.Random;

public class testSort {

    public static void quickSort(Student[] array, int startIndex, int endIndex) {
        if (array.length == 0)
            return;

        if (startIndex >= endIndex)
            return;

        int middle = (startIndex + endIndex) / 2;
        int divideNum = array[middle].IDNumber;

        int i = startIndex, j = endIndex;
        while (i <= j) {
            while (array[i].IDNumber < divideNum) {
                i++;
            }

            while (array[j].IDNumber > divideNum) {
                j--;
            }

            if (i <= j) {
                int temp = array[i].IDNumber;
                array[i].IDNumber = array[j].IDNumber;
                array[j].IDNumber = temp;
                i++;
                j--;
            }
        }

        if (startIndex < j)
            quickSort(array, startIndex, j);

        if (endIndex > i)
            quickSort(array, i, endIndex);
    }

    public static void printArr(Student[] arr){
        System.out.println();
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i].IDNumber + " ");
        }
    }

    public static void main(String[] args){
        Random rand = new Random();
        Student[] students = new Student[5];
        for(int i = 0; i < students.length; i ++){
            students[i] = new Student(rand.nextInt(100));
            System.out.print( students[i].IDNumber + " ");
        }

        quickSort(students, 0, students.length - 1);

        printArr(students);
    }
}
