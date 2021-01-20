package Compiler;

import java.util.Arrays;

class Program {
    String name;
    int len,freq;

    public Program(String name, int len, int freq) {
        this.name = name;
        this.len = len;
        this.freq = freq;
    }
    @Override
    public String toString() {
        return "[" + name + " ," + len + " ," + freq + "]";
    }
}

public class CompilerProblem {
    public static void main(String[] args) {
        Program[] programs= new Program[6];
        programs[0]=new Program("Yaara", 22, 6);
        programs[1]=new Program("Orya", 22, 2);
        programs[2]=new Program("Asahel", 24, 1);
        programs[3]=new Program("Matan", 26,17);
        programs[4]=new Program("Roei",24,4);
        programs[5]=new Program("Reut",21, 11);
        getOptimalOrder(programs);
        Arrays.sort(programs, (o1, o2) -> (o1.freq/o1.len)-(o2.freq/o2.len));
        System.out.println(Arrays.toString(programs));
        int totalTime = 0;
        int totallen = 0;
        for (int i = 0; i < programs.length; i++) {
            totalTime += (totallen+programs[i].len)*programs[i].freq;
            totallen += programs[i].len;
        }
        System.out.println("Total time: " + totalTime);

    }

    //gill not necessary
    public static void getOptimalOrder(Program[] programs) {
        mergeSort(programs,0,programs.length);
        int totalTime = 0;int totallen = 0;
        for (int i = 0; i < programs.length; i++) {
            System.out.println(programs[i]);
            totalTime += (totallen+programs[i].len)*programs[i].freq;
            totallen += programs[i].len;
        }
        System.out.println("Total time: " + totalTime);
    }
    private static void mergeSort(Program[] p, int low, int high) {
        int n = high - low;
        if(n <= 1) return;
        int mid = (low + high)/2;

        mergeSort(p,low,mid);

        mergeSort(p,mid,high);

        int i = low, j = mid, k = 0;

        Program[] temp = new Program[n];

        while(i<mid && j<high) {
            double t1 = (double)p[i].len/p[i].freq;
            double t2 = (double)p[j].len/p[j].freq;
            if(t1 < t2) temp[k++] = p[i++];
            else temp[k++] = p[j++];
        }

        while(i<mid) temp[k++] = p[i++];

        while(j<high) temp[k++] = p[j++];

        for (int l = 0; l < n; l++) {
            p[low + l] = temp[l];
        }
    }
}
