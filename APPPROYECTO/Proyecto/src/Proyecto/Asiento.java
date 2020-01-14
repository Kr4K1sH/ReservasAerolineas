package Proyecto;

import javax.swing.JOptionPane;

public class Asiento {

    private String ubicacion;//ventana o pasillo
    private boolean ocupado_;//si esta ocupado o no
    private final int fil =5;
    private final int colum =4;
    private String claseboleto;
    private  int matriz[][]; 
    private int asiento;
    public Asiento() {
     int matriz [][]=new int [fil][colum]; 
    this.asiento=0;
    }
    public void llenar(){
int num=0;
        for(int x=0; x< matriz.length; x++){
            for(int y=0; y<matriz[x].length; y++){
                matriz[x][y]= num++;
                
            }
        }
            
            
            }
           
            
    
    public int llenar(int fila ,int columna){
        int cont =0;
        
        for(int i=0; i<matriz.length;i++){
            for(int y =0; y<matriz[i].length; y++){
                if(i == fila && columna == y){
                    cont = this.matriz[fila][columna];
                break;
                }
            }
        }
        
        return asiento = cont; 
    }
    
    
   
    public String ubicacion(int fila ,int columna){
    String ubicacion="";
        for(int f=0;f<matriz.length;f++){
            for(int c =0; c<matriz[c].length;c++){
                if(matriz[fila][columna]==1||matriz[fila][columna]==2||matriz[fila][columna]==3||matriz[fila][columna]==4||matriz[fila][columna]==17||matriz[fila][columna]==18||matriz[fila][columna]==19||matriz[fila][columna]==20){
              
              
              ubicacion = "Su asiento se ubicara en la Ventana ";
              
                }else{
                
                ubicacion= "Su asiento se ubicara en el pasillo ";
                
                }
            }
        }
    return ubicacion;
    }
            
   
   
    public String consultaAsiento(int claseboleto){
    String hilera="";
    for(int f=0;f<this.fil;f++){
        for(int c=0;c<this.colum;c++){
            if(claseboleto==3){
                hilera += this.matriz[0][c]+"   ";}
            else{
                if(claseboleto==2){
                    hilera += this.matriz[1][c]+"  ";
                }else{
                    if(claseboleto==1){
                        hilera +=this.matriz[2][c]+"  "+this.matriz[3][c];    
        }
    }
        }
        }
    }
        return hilera;}
    public String consulltaocupado (){
    String ocup="";
    String hilera="";
    for(int f=0;f<fil;f++){
         for(int c=0;c<colum;c++){
             if(this.matriz[f][c]==0){
                 ocup+= "ocupado";
             }else{
                 ocup+= " desocupado";
             }
    }
    }
    return ocup; }
    
    public int [][] setNumasiento(int matriz[][] ) {
        return  this.matriz =matriz;
    }

    public int[][] getNumasiento() {
        return matriz;
    }

    public String setUbicacion(String ubicacion) {
     return    this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }


    public boolean setOcupado_(boolean ocupado_) {
        return this.ocupado_ = ocupado_;
    }

    public boolean isOcupado_() {
        return ocupado_;
    }
    public String setClaseBoleto(String claseboleto){
        return this.claseboleto= claseboleto;
    }
    
    public String toString(){
        String hilera="";
        
        hilera += " Matriz de asientos: ";
        
        for(int f=0; f<5; f++){
            for(int c=0; c<4; c++){
                hilera+=  this.matriz[f][c];
            }
            hilera +="\n";
        }
        
        
        
        return hilera.toString();
    }
    
    
    
    
    
    
}

