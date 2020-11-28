package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {

        int deleteIndex =0;
        Integer[] duplicates = countElements();
        for(Integer i: duplicates){
            if(i >= maxNumberOfDuplications){
                deleteIndex++;
            }
        }

        String[]outputArr = new String[array.length - deleteIndex];
        if(outputArr.length == 0) return outputArr;
        int j=0;
        for (int i = 0; i < duplicates.length; i++) {
            if(duplicates[i] < maxNumberOfDuplications){
                outputArr[j] = array[i];
                j++;
            }
        }

        return outputArr;


    }



    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {

        int deleteIndex = 0;
        Integer[] duplicates = countElements();
        for (Integer i : duplicates) {
            if (i == exactNumberOfDuplications) {
                deleteIndex++;
            }
        }

        String[] outputArr = new String[array.length - deleteIndex];
        int j = 0;
        for (int i = 0; i < duplicates.length; i++) {
            if (duplicates[i] != exactNumberOfDuplications) {
                outputArr[j] = array[i];
                j++;
            }
        }

        return outputArr;
    }


    public Integer[] countElements() {
        Integer[] dupliCounter = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            int count = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i].equals(array[j])) {
                        count++;
                    }
                }
            }
            dupliCounter[i] = count;
        }
        return dupliCounter;
    }
}