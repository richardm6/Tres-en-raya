/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author PCFICA-200
 */
// no se necesiota constructor porq ya inicializamos los valores de las constantes y variables
public class Tres {

    private int[][] matriz = new int[3][3];
    // LAS DOS VARIALBLES DEL JUEGO CRUZ Y CIRCULO Y EL final ES XQ SU VALOR N CAMBIARA
    public static final int CRUZ = 1;
    public static final int CIRCULO = 2;
    public int turno = CRUZ;
    
    // CONDICIONES DE LA JUGADA
    
    public static final int ERROR = 1;
    public static final int GANADOR_X =2;
    public static final int GANADOR_O= 3;
    public static final int NADIE = 4;
    public static final int NORMAL = 5;
    
    
    

    public boolean estaVacia(int fila, int columna) {
        if (matriz[fila][columna] == 0) {
            return true;
        }
        return false;
    }
// comprobar si hay casillas del turno actual
    public boolean ganador(){
        for (int i=0; i<3; i++ ){
            int contadorH =0;
            int contadorV=0;
            for (int j =0 ; j<3; j++){
                if (matriz [i][j]==turno){
                     contadorH++;                   
                }
                         
            if (matriz [j][i]==turno){
                contadorV++;
            }
                
            }
                 if (contadorH==3 || contadorV==3){
                return true;
                
            }
                        
          
            }
            
        
        int contador = 0;
        int contador2 = 0;
        for (int i = 0; i <= 2; i++) {
            if (matriz[i][i] == turno) {
                contador++;
            }
            if (matriz[2 - i][i] == turno) {
                contador2++;
            }
            if (contador == 3 || contador2 == 3) {
                return true;
            }
        }

        return false;
    }
    
    
    
    public boolean tablaLLena(){
        for (int i=0; i <3; i++ ){
            for (int j=0; j <3; j++ ){
                if (matriz[i][j]==0)
                    return false;
            
        }
        }
        return true;
    }
    
    
    
    public int marcar(int fila, int columna) {
        if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3) {
            if (estaVacia(fila, columna)) {
                matriz[fila][columna] = turno;
                
                if (ganador ()&&turno==CRUZ)
                    return GANADOR_X;
                
                else if (ganador()&&turno==CIRCULO)
                    return GANADOR_O;
                
                else if (tablaLLena())
                    return NADIE;
                

                if (turno == CRUZ) {
                    turno = CIRCULO;
                } else {
                    turno = CRUZ;
                }
             return NORMAL;
            }
        }
          return ERROR;
    }
}