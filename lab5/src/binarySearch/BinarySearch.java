package binarySearch;

/**
 * Created by andra on 04.11.2016.
 */
public class BinarySearch {

    static int[] result = new int[4];
    static boolean found = false;

    public static void main(String[] args) {

        int N = 84;
        int v[] = new int[N];

        for(int i=0;i<N;i++)
            v[i]=i;

        int value = 48;

        //trebuie impartit in
        Thread threads[] = new Thread[3];

        int size = N/4; // dimensiunea unui interval

        while(!found){

            threads[0] = new Thread(new MyThread(v, size+1, 2 * size, 0, 48));
            threads[1] = new Thread(new MyThread(v, 2*size + 1, 3 * size, 1, 48));
            threads[2] = new Thread(new MyThread(v, 3*size, N-1, 2, 48));

            for(int i=0; i<3; i++){
                threads[i].start();
            }

            for(int i=0; i<3; i++){

                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            for(int i=0; i<3; i++){
                if (i == 0 && result[i+1] == -1) {
                    //modific end si start
                }

                if (result[i]==1 && result[i+1] == -1) {
                    //
                }

                }
            }
        }


        //threads[0] = new Thread(new MyThread(v, 0, size, 0));




        for (int i = 0; i < N; i++) {
            System.out.println(v[i]);
            if(v[i]!= i*2) {
                System.out.println("Wrong answer");
                System.exit(1);
            }
        }
        System.out.println("Correct");
    }

}
