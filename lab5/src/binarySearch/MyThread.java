package binarySearch;

/**
 * Created by andra on 04.11.2016.
 */
public class MyThread implements Runnable {

    int v[];
    int start;
    int end;
    int threadID;
    int value;


    MyThread (int v[], int start, int end, int threadID, int value) {
        this.v = v;
        this.start = start;
        this.end = end;
        this.threadID = threadID;
        this.value = value;
    }

    public void search(){

        //int mid = (start + end) / 2;

        if(v[start] == value){

            BinarySearch.result[threadID] = start;
            BinarySearch.found = true;

        } else if (v[start] < value){

            BinarySearch.result[threadID] = -1;
        } else {

            BinarySearch.result[threadID] = 1;
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        search();
    }
}
