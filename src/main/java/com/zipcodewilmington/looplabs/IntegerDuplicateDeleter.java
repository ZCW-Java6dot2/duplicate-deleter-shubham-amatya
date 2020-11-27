package com.zipcodewilmington.looplabs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 1/29/18.
 *
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {
    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
//List<String> list = new LinkedList<String>(Arrays.asList(split));

        int count = 0;
        Integer[] finalArr;
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(array));
        String strArr = "";
        for (int i = 0; i < list.size(); i++) {
            for(int j=1; j<list.size(); j++){
                if(list.get(i) == list.get(j)){
                    count++;
                    if(count == maxNumberOfDuplications){
                        list.remove(list.get(i));
                    }
                }
            }
        }
        for(Integer i: list) {
            strArr += i;
        }

        finalArr = new Integer[strArr.length()];

        for(int i= 0; i<strArr.length(); i++){
           finalArr[i] = strArr.charAt(i)- '0';
        }

        return finalArr;

    }

    public Integer[] removeElementAtIndex(Integer[] arrayToBeCloned, int index) {
        Integer[] clonedArray = arrayToBeCloned.clone();
        Integer[] leftArray = Arrays.copyOfRange(clonedArray, 0, index);
        Integer[] rightArray = Arrays.copyOfRange(clonedArray, index + 1, arrayToBeCloned.length);
        Integer[] mergedArray = merge(leftArray,rightArray);
        return mergedArray;
    }

    public Integer[] merge(Integer[] array1, Integer[] array2) {
        Integer[] concate = new Integer[array1.length + array2.length];
        System.arraycopy(array1, 0, concate, 0, array1.length);
        System.arraycopy(array2, 0, concate, array1.length, array2.length);
        return concate;
    }


    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {


        return new Integer[0];
    }

    public int getNumOfOccurance(Integer currentValue){
        int count =0;
        for(int i=0; i<array.length; i++){
            Integer integer = array[i];
            if(integer.equals(currentValue)){
                count++;
            }
        } return count;
    }


}

