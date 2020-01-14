package Proyecto;

import java.text.SimpleDateFormat;

import java.util.*;

import javax.swing.JOptionPane;

public class Vuelo {
   private int numerovuelo;
   private String destino;
   private Date fecha = new Date();
   
   private Pasajero [] pasajeros;
   private  Asiento [][] matriz;
   private int [][] matrizentera;
   
    Calendar calendario = Calendar.getInstance();
    int diasalida = calendario.get(Calendar.DAY_OF_WEEK);
    int mes = calendario.get(Calendar.MONTH);  
    int diames= calendario.get(Calendar.DAY_OF_MONTH);
   
   
    private final int filas=5;
    private final int colum=4;
    
    public Vuelo() {
          numerovuelo =0;
          String destino="";
          this.pasajeros= new Pasajero[20];
          this.matriz = new Asiento[filas][colum];
          this.matrizentera = new int [filas][colum];
    }
   
        public int Boleto(int preciobase,int claseboleto){
            
            double costo=0;
            if(claseboleto ==1){
             costo = (double) preciobase;}
            else{
                if(claseboleto ==2){
                costo= (double) preciobase*(1+0.50);
                }else{
                    costo = (double) preciobase * (1+1);
                }
                }
                    
                    return(int) costo;
         
        }
        public double descuento(int preciobase,int diames,int diasalida,int claseboleto){
            double descuento1=0;
            double aux=0;
            double costo=0;
            if (claseboleto ==1){
                costo = preciobase;
            }else{
                if(claseboleto ==2){
                    costo = (double) preciobase*(1+0.50);
                }else{
                    if(claseboleto ==3){
                        costo = (double) preciobase *(1+1);
                    }
                }
            }
            
            switch(mes){
            case 1: //enero
            case 2://febrero
            case 3://marzo
                   descuento1 = costo/2;
            break;
            case 4://abril
            case 5://may
            case 6://jun
            if(mes == 6 && diames < 21){
            descuento1=(double)costo/2;
            }else{
                if(mes ==6 && diames >21)
                descuento1=(double)costo;
            }
            break;
            case 7:
            case 8://ago
            case 9://sept
            if(mes ==9&& diames < 20||diames==20){
            descuento1=(double)costo;
            }else{if(mes==9 && diames >21){
            descuento1 =(double) costo/2;}
            }
            break;
            case 10://oct
            case 11://nov
            case 12://dic
                descuento1 =(double)costo/2;
            break;
                
            default: descuento1 +=0;
                     break;
            }
            if (diasalida == 2||diasalida==5){
                aux=(descuento1/100)*15;
                descuento1-=aux;
            }
               
            return (double)costo-descuento1;
        
        }
        public void llenaPasajeros(Pasajero pasajero1){
    
            for(int i =0; i<21;i++){
                if(this.pasajeros[i]==null){
                this.pasajeros[i] = pasajero1;
                }
                }
                    }
                
        public String MuestraPasajeros(Pasajero pasajero1){
            String hilera="";
            
            for(int i=0; i<21; i++){
                if(this.pasajeros[i]!= null){
                    hilera += "\n"+ this.pasajeros[i];
                }
            }
            return hilera;
            
            
        }
        
        public boolean revisaPasajeros(Pasajero pasajero1){
            
            
            for(int f=0; f<this.pasajeros.length; f++){
                if(this.pasajeros[f]== pasajero1 ){
                   
               return true;    
                }
                else{
                    if(this.pasajeros[f]!= pasajero1){
                       
                    return false;
                    }
                }
            }
            return false;
        }
       
            
        
        public String mostrarmatriz(int claseboleto,Pasajero pasajero1){
            String hilera="";
            hilera+="                 "+"                        COLUMNAS                       "+"\n";
            hilera+="                " +"                  0          1           2            3  "+"\n";
            char []Let = {'0','1','2','3', '4'};
            int num=0;
            for(int i=0; i <this.filas; i++){
                hilera+="     "+"FILA          "+Let[i] +"  ";
                if(i==2){
                    hilera+="";
                }
                for(int c=0; c<this.colum; c++){
                    if(matriz[i][c]==null){
                    hilera +="   "+"  "+   ++num +"  ";
                    
                                    
                                if(num > 20){
                                    break;
                                }
                                if(num<10){
                                    hilera += "   ";
                                }
                                    hilera += "   ";
                                
                            }else{
                        if(matriz[i][c]!=null){
                    num= num+1;
                    hilera +="  ";
                            hilera +="    "+"    "+    "0"+"  " ;
                        }
                    }
                }
                
                hilera+= "\n";
            }
            
            hilera+= "\n"+"\n";
            hilera+= "#: Desocupado. "+"\n 0: Ocupado. "+"\n"+"\n" +
                "Primera clase Columna 0"+"\n"+"Clase Ejecutiva Columna 1"+"\n"+"Clase Economica Columna 2  y 3";
            
            return hilera;
        }
        
        
        
        
        
        public boolean AgregarPasajero(int fila, int columna,Asiento asiento1){
            int num=0;
            
            for(int f=0; f<matriz.length; f++){
                for(int c=0; c<matriz[f].length; c++){
                    if(matrizentera[f][c]==num){
                        if(matriz[f][c]==null){
                            matriz[f][c]=asiento1;
                        return true;
                        }
                    }
                }
 
            }
            return false;           
            
        }
        
        
        public boolean llenaAsientoB( int fila, int columna, Asiento asiento1){
            //A1=00 B1=10 C1=20   D1=30  E1=40 
            //A2=01 B2=11 C2=21   D2=31  E2=41
            //A3=02 B3=12 C3=22   D3=32  E3=42
            //A4=03 B4=13 C4=23   D4=33  E4=43
        
            for(int f=0;f<this.filas;f++){
                for(int c=0;c<this.colum;c++){
                    if(this.matriz[fila][columna]==null){
                    this.matriz[fila][columna]= asiento1;
        return true;
                    }else{
                        if(this.matriz[fila][columna]!= asiento1  ){
                          
                    return true;
                        } 
                            
                        }
                    }
                }
            
            
            return false;
        }
        
        public void cancelarreserv(int fila, int columna){
         String hilera="";
            for(int i=0; i<filas; i++){
                for(int c=0; c<colum; c++){
                    if(this.matriz[fila][columna]== this.matriz[i][c]){
                        matriz[i][c]= null;
                    }else{
                        if(this.matriz[fila][columna]!= this.matriz[i][c]){
                            matriz[i][c]=matriz[i][c];
                        }
                    }
                }}}
            
         
         
            
        
               
        
    public String ubicacion(int fila ,int columna,Asiento asiento1){
String ubicacion="";
        for(int f=0;f<matriz.length;f++){
            for(int c =0; c<matriz[c].length;c++){
                if(fila == 0 || fila ==4){
              
              
              ubicacion = "Su asiento se ubicara en la Ventana ";
              
                }else{
                
                ubicacion= "Su asiento se ubicara en el pasillo ";
                
                }
            }
        }
return ubicacion;
    }
     
     
     
     
    
           
            
    
    public int llenar(int fila ,int columna){
        int cont =0;
        int num=0;
    int matriz[][] = new int [5][4];    
        for(int i=0; i<5;i++){
            for(int y =0; y<4; y++){
                    matriz[i][y] += ++num;
                    if( (i == fila) && (columna == y) ){    
                    cont = matriz[fila][columna];
                break;
                }
            }
        }
        
        return cont; 
    }
    
     
     
     
     
     
     
     
            
        
        
        
        
    public int setNumerovuelo(int numerovuelo) {
    return  this.numerovuelo = numerovuelo;
    }

    public int getNumerovuelo() {
        return numerovuelo;
    }

    public Date getFecha() {
        return fecha;
    }


    
    
    
    
    
    

}
