import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class SchoolGradingSystem {
    int j,k,l,t, insuf;
    int counterb, counterg, counterl;
    double armando, nicolas, daniel, maria, marcela,alexandra, total;
    double armando1, nicolas1, daniel1, maria1, marcela1,alexandra1;
    double literatura, biologia, geografia;
    String estudiante, materia;
    private String cantdata;
    private double [][] matriz;

    public String getCo(){
        return this.cantdata;
    }

    public void readData() {
        Scanner read = new Scanner(System.in);
        if (read.hasNextLine()) {
            String cantdata = read.nextLine();
            this.cantdata = cantdata;
        }
        int column = 4;
        int cant_data = Integer.parseInt(this.cantdata);
        matriz = new double[cant_data][column];

        for (int i = 0; i < cant_data; i++) {
            cantdata = read.nextLine();
            String[] m = cantdata.split(" ");

            double x = Double.parseDouble(m[0]);
            double y = Double.parseDouble(m[1]);
            double z = Double.parseDouble(m[2]);
            double w = Double.parseDouble(m[3]);

            matriz[i][0] = x;
            matriz[i][1] = y;
            matriz[i][2] = z;
            matriz[i][3] = w;
        }
    }
    public double question1(){
        for (l=0; l < matriz.length; l++) {
            if (matriz[l][0] == 1) armando += matriz[l][3];
            else if (matriz[l][0] == 2) nicolas += matriz[l][0];
            else if (matriz[l][0] == 3) daniel += matriz[l][0];
            else if (matriz[l][0] == 4) maria += matriz[l][0];
            else if (matriz[l][0] == 5) marcela += matriz[l][0];
            else if (matriz[l][0] == 6) alexandra += matriz[l][0];
        }
        for (j=0; j < matriz.length; j++){
            total += matriz[j][3];
        }
        double promedio = (total/matriz.length);
        BigDecimal bd = new BigDecimal(promedio).setScale(2, RoundingMode.HALF_UP);
        double newInput = bd.doubleValue();

        return newInput;
    }
    public int question2(){
        for (j=0; j < matriz.length; j++){
            if ((matriz[j][3] <=6) && (matriz[j][3] >3)) insuf += 1;
        }
        return insuf;
    }
    public String question3(){
        for (k=0; k < matriz.length; k++){
            if (matriz[k][1] == 1){
                if (matriz[k][2] == 1){
                    literatura += matriz[k][3];
                    counterl += 1;
                }
                else if (matriz[k][2] == 2){
                    biologia += matriz[k][3];
                    counterb += 1;
                }
                else if (matriz[k][2] == 3){
                    geografia += matriz[k][3];
                    counterg += 1;
                }
            }
        }
        double lite = literatura/counterl;
        double bio = biologia/counterb;
        double geo = geografia/counterg;

        if ((lite > bio) && (lite > geo)){
            materia = "literatura";
        }
        else if ((geo > bio) && (geo > lite)){
            materia = "geografia";
        }
        else if ((bio > lite) && (bio > geo)){
            materia = "biologia";
        }
        return materia;
    }
    public String question4(){
        for (t = 0; t < matriz.length; t++){
            if (matriz[t][2] == 1){
                if (matriz[t][0] == 1) armando1 += matriz[t][3];
                else if (matriz[t][0] == 2) nicolas1 += matriz[t][3];
                else if (matriz[t][0] == 3) daniel1 += matriz[t][3];
                else if (matriz[t][0] == 4) maria1 += matriz[t][3];
                else if (matriz[t][0] == 5) marcela1 += matriz[t][3];
                else if (matriz[t][0] == 6) alexandra1 += matriz[t][3];
            }
        }

        if ((armando1 > nicolas1) && (armando1 > daniel1) && (armando1 > marcela1) && (armando1 > maria1) && (armando1 > alexandra1))
            estudiante = "armando";
        else if ((nicolas1 > armando1) && (nicolas1 > daniel1) && (nicolas1 > marcela1) && (nicolas1 > maria1) && (nicolas1 > alexandra1))
            estudiante = "nicolas";
        else if ((daniel1 > nicolas1) && (armando1 < daniel1) && (daniel1 > marcela1) && (daniel1 > maria1) && (daniel1 > alexandra1))
            estudiante = "daniel";
        else if ((maria1 > nicolas1) && (maria1 > daniel1) && (maria1> marcela1) && (armando1 < maria1) && (maria1 > alexandra1))
            estudiante = "maria";
        if ((marcela1 > nicolas1) && (marcela1> daniel1) && (armando1 < marcela1) && (marcela1 > maria1) && (marcela1 > alexandra1))
            estudiante = "marcela";
        if ((alexandra1 > nicolas1) && (alexandra1 > daniel1) && (alexandra1 > marcela1) && (alexandra1 > maria1) && (armando1 < alexandra1))
            estudiante = "alexandra";
        return estudiante; 
    }
}
