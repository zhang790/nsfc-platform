package com.nsfc.practice.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author zhangjiayu zhangjiayu
 * @create 2018/5/10
 */
public class SortOne {

    /**
     * 冒泡排序
     * @param arrays
     */
    private static void sortMethodOne(int[] arrays){

        for (int i=0; i<arrays.length; i++){
            for(int j=0; j<arrays.length -1 -i; j++){
                if (arrays[j] > arrays[j+1]){  //如果改为 >=，则变成不稳定算法
                    int temp = arrays[j+1];
                    arrays[j+1] = arrays[j];
                    arrays[j] = temp;
                }
            }
        }
    }

    /**
     * 鸡尾酒排序 冒泡排序的优化  性能强于冒泡
     * @param arrays
     */
    private static void sortMethodTwo(int[] arrays){

        int left =0;
        int right=arrays.length -1;

        while (left < right){

            for (int i=left; i<right; i++){
                if (arrays[i] > arrays[i+1]){
                    int temp = arrays[i+1];
                    arrays[i+1] = arrays[i];
                    arrays[i] = temp;
                }
            }
            right--;

            for (int j=right; j>left; j--){
                if (arrays[j] < arrays[j-1]){
                    int temp = arrays[j-1];
                    arrays[j-1] = arrays[j];
                    arrays[j] = temp;
                }
            }
            left++;

        }
    }

    /**
     * 选择排序
     * @param arrays
     */
    private static void sortMethodThree(int[] arrays){

        for (int i=0; i<arrays.length; i++){
            for(int j=i+1; j<arrays.length -1; j++){
                if (arrays[i] > arrays[j]){  //如果改为 >=，则变成不稳定算法
                    int temp = arrays[j];
                    arrays[j] = arrays[i];
                    arrays[i] = temp;
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arrays
     */
    private static void sortMethodFour(int[] arrays){

        int[] newArray = new int[arrays.length];

        for (int i=0; i<arrays.length; i++){
            newArray[i] = arrays[i];

        }

    }


    public static void main(String[] args) {

        int[] arrays = new int[]{2,5,3,6,4,8,7,1,0,9};
//        sortMethodOne(arrays);
//        sortMethodTwo(arrays);
        sortMethodThree(arrays);
        System.out.println(Arrays.toString(arrays));
    }

}
