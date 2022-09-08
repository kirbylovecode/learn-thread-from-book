package org.example;

import org.example.第一章java多线程技能.Interrupt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: joe
 * @date: 2022-09-02 10:45
 * @desc:
 */
public class Test {
    public static void main(String[] args) {
        //2*17=2*2^4-1
        Integer[] arr = {18,13,50,15,4,17,18};

        System.out.println("arr的各个元素是：18  13  50  15  4  17  18 ");

        int temp  = 0 ;
//        for(int i = 0 ;i< arr.length -1; i++){
//            for(int j = 0; j<arr.length-1-i; j++){
//                if(arr[j]>arr[j+1]){
//                    temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//
//        }



        List<Integer> ints = new ArrayList<>(Arrays.asList(arr)) ;
//        Collections.sort(ints);
        Collections.reverse(ints);

        ints.stream().forEach(System.out::println);
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = 0; j < arr.length-1-i ; j++) {
//                if(arr[j]<arr[j+1]){
//                    temp=arr[j];
//                    arr[j]=arr[j+1];
//                    arr[j+1]=temp;
//
//                }
//            }
//        }
        System.out.println("arr排序后：");

        for(int i = 0; i<arr.length; i++){

            System.out.print(arr[i]+"\t");
        }




    }
}
