import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class SortAlgorithms {


    /**
     * @param arr
     */
    public static void selSort(String[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j].compareTo(arr[min]) > 0){
                    min=j;
                }
            }
            String aux=arr[i];
            arr[i]=arr[min];
            arr[min]=aux;
        }
    }


    /**
     * @param arr
     */
    public static void substitutionSort(String[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].compareTo(arr[j])>0){
                    String aux=arr[i];
                    arr[i]=arr[j];
                    arr[j]=aux;
                }
            }
        }
    }
    

    /**
     * @param arr
     */
    public static void bubbleSort(String[] arr){
        boolean scambio=true;
        int limit=arr.length-1;
        String thispos, nextpos;
        while(scambio){
            scambio=false;
            for(int i=0;i<limit;i++){
                thispos=arr[i];
                nextpos=arr[i+1];
                if(thispos.compareTo(nextpos) > 0){
                    String aux=thispos;
                    thispos=nextpos;
                    nextpos=aux;
                    scambio=true;
                }
            }
            limit--;
        }
    }


    /**
     * @param arr
     */
    public static void insertionSort(String[] arr){
        for(int i=1;i<arr.length-1;i++){
           String e=arr[i];
           int j=i;
           while(j>0&&arr[j-1].compareTo(e)>0){
                arr[j]=arr[j-1];
           }    arr[j]=e;   
        }
    }


    /**
     * @param arr
     */
    public static void mergeSort(String[] arr){
        if(arr.length==1) return ;
        String[] sx= new String[arr.length/2];
        String[] dx=new String[arr.length-sx.length];

        for(int i=0;i<arr.length/2;i++){
            sx[i]=arr[i];
        }
        for(int i=0;i<dx.length;i++){
            dx[i]=arr[i+sx.length];
        }
        mergeSort(sx);
        mergeSort(dx);
        int isx=0;
        int idx=0;
        for(int k=0;k<arr.length;k++){
            if(isx<sx.length&&idx<dx.length){
                if(sx[isx].compareTo(dx[idx]) < 0){
                    arr[k]=sx[isx];
                    isx++;
                }else{
                    arr[k]=dx[idx];
                    idx++;
                }
            }else if(isx<sx.length){
                arr[k]=sx[isx];
                isx++;
            }else{
                arr[k]=dx[idx];
                idx++;
            }
        }
    }


    /**
     * @param arr
     * @param from
     * @param to
     */
    public static void quickSort(String[] arr, int from, int to){
        if(from<to){
            String pivot=arr[from];
            int i=from;
            int j=to;
            while(i<j){
                while(arr[i].compareTo(pivot) < 0 &&i<j){
                    i++;
                }
                while(arr[j].compareTo(pivot) > 0 &&i<j){
                    j--;
                }
                if(i<j){
                    String aux=arr[i];
                    arr[i]=arr[j];
                    arr[j]=aux;
                }
            }
            arr[from]=arr[j];
            arr[j]=pivot;
            quickSort(arr,from,j-1);
            quickSort(arr,j+1,to);
        }

    }

    public static String generateRandomString() {
 
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;

            Random random = new Random();

            StringBuilder buffer = new StringBuilder(targetStringLength);
                for (int i = 0; i < targetStringLength; i++) {

                    int randomLimitedInt = leftLimit + (int)(random.nextFloat() * (rightLimit - leftLimit + 1));
                    buffer.append((char) randomLimitedInt);

                }

            String generatedString = buffer.toString();

            return generatedString;
    }

    public static String tester(String[] words){
        long tStartSelection = System.currentTimeMillis();
            selSort(words);
            long tFinishSelection = System.currentTimeMillis();
            long tSelection = tFinishSelection - tStartSelection;


            long tStartSostitution = System.currentTimeMillis();
            substitutionSort(words);
            long tFinishSostitution = System.currentTimeMillis();
            long tSostitution = tFinishSostitution - tStartSostitution;


            long tStartBubble = System.currentTimeMillis();
            bubbleSort(words);
            long tFinishBubble = System.currentTimeMillis();
            long tBubble = tFinishBubble - tStartBubble;


            long tStartInsertion = System.currentTimeMillis();
            insertionSort(words);
            long tFinishInsertion = System.currentTimeMillis();
            long tInsertion = tFinishInsertion - tStartInsertion;


            long tStartMerge = System.currentTimeMillis();
            mergeSort(words);
            long tFinishMerge = System.currentTimeMillis();
            long tMerge = tFinishMerge - tStartMerge;

            return (tSelection + "," + tSostitution + "," + tBubble + "," + tInsertion + "," + tMerge);
    }
    public static void main(String[] args){ 
        String[] words = new String[50];

        for(int i = 0; i<words.length; i++){
            String randomWord = generateRandomString();
            words[i] = randomWord;
        }

        try(PrintWriter pw = new PrintWriter("2_PERIODO\\Sorting_Algorithms\\SortTimes.csv")){

            for(int i = 500; i<1000; i+=10){
                System.out.println(tester(words));

                String result = tester(words);
                pw.println(result);
            }

        }catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }
}