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
        int numOfElementsToDelete = 0;
        Integer[] duplicates = countElements();
        for(Integer i: duplicates){
            if(i>= maxNumberOfDuplications){
                numOfElementsToDelete++;
            }
        }

        Integer[] outputArr = new Integer[array.length - numOfElementsToDelete];
        if(outputArr.length==0) return outputArr;
        int j = 0;
        for(int i=0; i<duplicates.length; i++){
            if(duplicates[i]<maxNumberOfDuplications){
                outputArr[j] = array[i];
                j++;
            }
        }
        return outputArr;
    }

      /*  int count = 0;  //(is the .remove() function disabled? )
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

        return finalArr;*/


    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int deleteIndex =0;
        Integer[] duplicates = countElements();
        for(Integer i: duplicates){
            if(i == exactNumberOfDuplications){
                deleteIndex++;
            }
        }

        Integer[]outputArr = new Integer[array.length - deleteIndex];
        int j=0;
        for (int i = 0; i < duplicates.length; i++) {
            if(duplicates[i] != exactNumberOfDuplications){
                outputArr[j] = array[i];
                j++;
            }
        }

        return outputArr;
    }

    public Integer [] countElements(){
        Integer[] dupliCounter = new Integer[array.length];
        for(int i=0; i<array.length; i++){
            int count =1;
            for(int j=0; j<array.length; j++){
                if(i != j) {
                    if (array[i].equals(array[j])) {
                        count++;
                    }
                }
            }dupliCounter[i] = count;
        }
        return dupliCounter;
    }

}

