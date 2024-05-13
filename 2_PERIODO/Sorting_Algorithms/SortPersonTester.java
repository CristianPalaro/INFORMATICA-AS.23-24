import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class SortPersonTester {

    /**
     * @param arr
     */
    public static void selSort(Person[] arr){
        for(int i=0;i<arr.length;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j].compareTo(arr[min]) > 0){
                    min=j;
                }
            }
            Person aux=arr[i];
            arr[i]=arr[min];
            arr[min]=aux;
        }
    }


    /**
     * @param arr
     */
    public static void substitutionSort(Person[] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].compareTo(arr[j])>0){
                    Person aux=arr[i];
                    arr[i]=arr[j];
                    arr[j]=aux;
                }
            }
        }
    }
    

    /**
     * @param arr
     */
    public static void bubbleSort(Person[] arr){
        boolean scambio=true;
        int limit=arr.length-1;
        Person thispos, nextpos;
        while(scambio){
            scambio=false;
            for(int i=0;i<limit;i++){
                thispos=arr[i];
                nextpos=arr[i+1];
                if(thispos.compareTo(nextpos) > 0){
                    Person aux=thispos;
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
    public static void insertionSort(Person[] arr){
        for(int i=1;i<arr.length-1;i++){
           Person e=arr[i];
           int j=i;
           while(j>0&&arr[j-1].compareTo(e)>0){
                arr[j]=arr[j-1];
           }    arr[j]=e;   
        }
    }


    /**
     * @param arr
     */
    public static void mergeSort(Person[] arr){
        if(arr.length==1) return ;
        Person[] sx= new Person[arr.length/2];
        Person[] dx=new Person[arr.length-sx.length];

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

    public static String tester(Person[] people){

            long tStartSelection = System.currentTimeMillis();
            selSort(people);
            long tFinishSelection = System.currentTimeMillis();
            long tSelection = tFinishSelection - tStartSelection;


            long tStartSostitution = System.currentTimeMillis();
            substitutionSort(people);
            long tFinishSostitution = System.currentTimeMillis();
            long tSostitution = tFinishSostitution - tStartSostitution;


            long tStartBubble = System.currentTimeMillis();
            bubbleSort(people);
            long tFinishBubble = System.currentTimeMillis();
            long tBubble = tFinishBubble - tStartBubble;


            long tStartInsertion = System.currentTimeMillis();
            insertionSort(people);
            long tFinishInsertion = System.currentTimeMillis();
            long tInsertion = tFinishInsertion - tStartInsertion;


            long tStartMerge = System.currentTimeMillis();
            mergeSort(people);
            long tFinishMerge = System.currentTimeMillis();
            long tMerge = tFinishMerge - tStartMerge;

            return (tSelection + "," + tSostitution + "," + tBubble + "," + tInsertion + "," + tMerge);
    }

    public static void main(String[] args){

        Person[] people5 = new Person[5];
        Person[] people50 = new Person[50];
        Person[] people500 = new Person[500];

        for(int i = 0; i<people5.length; i++){
            Random gen = new Random();
            Person randomPerson = new Person(generateRandomString(), gen.nextInt(100));
            people5[i] = randomPerson;
        }
        for(int i = 0; i<people50.length; i++){
            Random gen = new Random();
            Person randomPerson = new Person(generateRandomString(), gen.nextInt(100));
            people50[i] = randomPerson;
        }
        for(int i = 0; i<people500.length; i++){
            Random gen = new Random();
            Person randomPerson = new Person(generateRandomString(), gen.nextInt(100));
            people500[i] = randomPerson;
        }


        try(PrintWriter pw = new PrintWriter("Z:\\INFO\\2_PERIODO\\Sorting_Algorithms\\SortTimes.csv")){
            int increment = 50;
            for(int i = 0; i<1000; i+=increment){
                String result5 = tester(people5);
                System.out.println(result5);
                pw.println(result5);
            }
            System.out.println();
            for(int i = 0; i<1000; i+=50){
                String result50 = tester(people50);
                System.out.println(result50);
                pw.println(result50);
            }
            System.out.println();
            for(int i = 0; i<1000; i+=50){
                String result500 = tester(people500);
                System.out.println(result500);
                pw.println(result500);
            }

        }catch (FileNotFoundException e) {
            System.out.println("File non trovato");
        }
    }
}
