import java.util.Random;

/**
 * Created by 0004 on 2016-06-15.
 */
public class Sort {


    public static void main(String args[]){
        for(int i=0 ; i<100; i++) {
            Integer[] arr = radomArr();
            printArr(arr);
            recursiveInsertSort(arr, 0, arr.length-1);
            printArr(arr);
            Boolean result = checkResult(arr);
            System.out.println(result);

            if(!result){
                System.out.println("run is error!");
                break;
            }
        }
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void printArr(Integer[] arr){
        for(int i=0 ; i<arr.length ; i++){
            System.out.print(arr[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 产生无序数组
     * @return
     */
    public static Integer[] radomArr(){
        Integer[] arr = new Integer[20];
        Random random = new Random();

        for(int i=0 ; i<arr.length ; i++){
            arr[i] = random.nextInt(1000);
        }

        return arr;
    }

    /**
     * 校验数组是否顺序排序
     * @param arr
     * @return
     */
    public static Boolean checkResult(Integer[] arr){
        Boolean result = true;
        for(int i=1 ; i<arr.length ; i++){
            if(arr[i]<arr[i-1]){
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * 递归版插入排序
     * @param arr
     * @param p
     * @param q
     * @return
     */
    public static void recursiveInsertSort(Integer[] arr, int p, int q){
        if(p<q){
            recursiveInsertSort(arr, p, q-1);
            insert(arr, p, q);
        }
    }

    public static void insert(Integer[] arr, int p, int q){
        Integer key = arr[q];
        int i = q - 1;
        while (i>=p && arr[i]>key){
            arr[i+1] = arr[i];
            i--;
        }
        arr[i+1] = key;

    }

    /**
     * 插入排序算法
     * @param arr
     * @return
     */
    public static Integer[] insertSort(Integer[] arr){
        int length = arr.length;
        for (int i = 1 ; i<length ; i++){
            int j = i-1;
            Integer key = arr[i];
            while (j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }


}
