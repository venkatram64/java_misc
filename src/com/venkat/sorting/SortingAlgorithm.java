package com.venkat.sorting;

/**
 * Created by Venkatram on 3/2/2017.
 */
public class SortingAlgorithm {

    public static int[] insertionSort(int[] numbers){
        //17  87  6  22  41  2  13  54  5
        //1. index = 0, element is already sorted b/c there is no elements to the left of the index = 0;
        int i,j,key,temp;
        for(i= 1; i < numbers.length; i++ ){
            key = numbers[i];
            j = i - 1;
            while(j>=0 && key < numbers[j]){
                temp = numbers[j];
                numbers[j] = numbers[j+1];
                numbers[j+1] = temp;
                j--;
            }
        }
        return numbers;
    }

    public static void selectionSort(int[] numbers){
        // 1. iterate and find the min value
        int i,j,minValue,minIndex,temp = 0;
        for(i = 0; i < numbers.length; i++){
            minValue = numbers[i];
            minIndex = i;
            for(j=i; j<numbers.length; j++){
                if(numbers[j] < minValue){
                    minValue = numbers[j];
                    minIndex = j;
                }
            }
            //swap min value with numbers[i]
            if(minValue < numbers[i]){
                temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
        }

    }

    public static void bubbleSort(int[] list){
        int i, j, temp = 0;
        for(i = 0; i < list.length - 1; i++){
            for(j = 0; j < list.length - 1 - i; j++){
                if(list[j] > list[j + 1]){
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] list){
        if(list.length < 2){
            return;
        }
        int mid = list.length/2;
        int size = list.length;
        int[] left = new int[mid];
        int[] right = new int[size - mid];
        //populate left and right array
        for(int i = 0; i < mid; i++){
            left[i] = list[i];
        }
        for(int i = 0; i < right.length; i++){
            right[i] = list[mid + i];
        }
        //again divide until the list is not divisible
        mergeSort(left);
        /*System.out.println("Left");
        print(left);*/

        mergeSort(right);
        /*System.out.println("Right");
        print(right);*/

        merge(left,right,list);
    }

    private static void merge(int[] left, int[] right, int[] list){
        int l = 0;//left index
        int r = 0;//right index
        int result = 0;

        while( l < left.length && r < right.length){
            if(left[l] < right[r]){
                list[result] = left[l];
                l++;
            }else{
                list[result] = right[r];
                r++;
            }
            result++;
        }

        //copy what's left
        /*System.arraycopy(left,l,list,result,left.length - l);
        System.arraycopy(right,r,list,result,right.length - r);*/

        while(l<left.length){ //left remaining
            list[result++] = left[l++];
        }
        while(r<right.length){ //right remaining
            list[result++] = right[r++];
        }
    }

    public static void quickSort(int[] list){
        quickSork(list,0,list.length);
    }


    public static void quickSork(int[] arr, int low, int high){
        int i = low;
        int j = high;
        int temp;

        //pivot is middle index
        int pivot = arr[(high + low)/2];

        // Divide into two arrays
        while( i <= j) {
            /**
             In each iteration, we will identify a
             number from left side which is greater then the pivot value, and
             a number from right side which is less then the pivot value.
             Once search is complete, we can swap both numbers. */
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if( i <= j){
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if(low < j){
            quickSork(arr, low, j);
        }

        if(i < high){
            quickSork(arr, i, high);
        }
    }
    //other way for merge sort
    public static void mergeSort1(int[] array){
        //create temp array of original array of same size
        int[] temp = new int[array.length];
        mergeSort1(array, temp, 0, array.length - 1);
    }

    public static void mergeSort1(int[] array, int[] temp, int leftStart, int rightEnd){

        if(leftStart >= rightEnd){
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergeSort1(array, temp, leftStart, middle);
        mergeSort1(array, temp, middle + 1, rightEnd);
        mergeHalves(array, temp, leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;  // this is for temp array

        while(left <= leftEnd && right <= rightEnd){
            if(array[left] <= array[right]) {
                temp[index] = array[left];
                left++;
            }else{
                temp[index] = array[right];
                right++;
            }
            index++;
        }

        System.arraycopy(array, left, temp, index, leftEnd - left + 1);
        System.arraycopy(array, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
    //other way is for quick sort
    public static void quickSort1(int[] array){
        quickSort2(array, 0, array.length - 1);
    }
    //17,41,5,22,54,6,29,3,13
    public static void quickSort2(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = array[(left + right)/2]; //finding pivot
        int index = partition2(array, left, right, pivot);
        quickSort2(array, left, index - 1);//index will become partitioned array boundary of end index
        quickSort2(array, index, right); //index will become partitioned array boundary of starting index
    }

    public static int partition2(int[] array, int left, int right, int pivot){

        while(left <= right){
            while(array[left] < pivot){  // always lesser values to the left of the pivot
                left++;
            }
            while(array[right] > pivot){  // always bigger values to the right of the pivot
                right--;
            }
            if(left <= right){
                swap2(array, left, right);
                left++;
                right--;
            }
        }
        return left;  //left index of the array, on the basis of this index, again pivot is calculated.
    }

    public static void swap2(int[] array, int left, int right){
        if(array[left] > array[right]){
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
    }
    public static void main(String[] args){
        //insertion sort
      /*  int[] numbers = {5,8,1,3,9,6};
        System.out.println("Before sort: " );
        print(numbers);
        System.out.println("\nAfter sort: " );
        numbers = insertionSort(numbers);
        print(numbers);*/

        //selection sort
        /*int[] list = {7,8,5,4,9,2};
        System.out.println("Before sort: " );
        print(list);
        System.out.println("\nAfter sort: " );
        selectionSort(list);
        print(list);*/

        //bubble sort
       /* int[] blist = {5,8,1,6,9,2};
        System.out.println("Before sort: " );
        print(blist);
        bubbleSort(blist);
        System.out.println("\nAfter sort: " );
        print(blist);*/

        //merge sort
        int[] mlist = {17,87,6,22,41,2,13,54,5};
        System.out.println("Before sort: " );
        print(mlist);
        mergeSort(mlist);
        System.out.println("\nAfter sort: " );
        print(mlist);

        //quick sork
       /* int[] qlist = {17,41,5,22,54,6,29,3,13};
        System.out.println("Before sort: " );
        print(qlist);
        quickSort1(qlist);
        System.out.println("\nAfter sort: " );
        print(qlist);*/

    }

    public static void print(int[] num){
        for(int i = 0; i<num.length; i++){
            System.out.print(num[i] + "  ");
        }
    }
}
