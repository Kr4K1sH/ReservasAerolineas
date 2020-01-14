package Proyecto;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import org.omg.CORBA.Object;

public class PrincipalMain {
    public static void main(String[] args) {
        int contraseña = 54321;
        String ADMIN = "ADMIN";
        int opcion;
        int claseboleto = 0;
        int consulta;
        String nombre = "";
        int cedula = 0;
        int telefono = 0;
        String correo = "";
        String nacionalidad="";
        String destino ="";
double tot2=0;
double desc2=0;
Icon icono = new ImageIcon( "Imagenes/java1.jpg");
         String ubicacion="";
        int submenu;
        Calendar calendario = Calendar.getInstance();
        int ano = calendario.get(Calendar.YEAR);
        int diasalida = calendario.get(Calendar.DAY_OF_WEEK);
        int mes = calendario.get(Calendar.MONTH);
        int diames = calendario.get(Calendar.DAY_OF_MONTH);
        Pasajero[] pasajero;
        pasajero = new Pasajero[20];
        int preciobase = 0;
        int intentos = 3; //contraseña
        int fila = 0;
        int columna = 0;


        
        Asiento asiento1 = new Asiento();
        Pasajero pasajero1 = new Pasajero();
        Vuelo vuelo1 = new Vuelo();

        String pass = "";
        Scanner sc = new Scanner(System.in);
        //comienzaq el menu
        
       
        do {
            String name =
          (String) JOptionPane.showInputDialog(null, "\n Digite su nombre de usuario: ", "BIENVENIDO", JOptionPane.PLAIN_MESSAGE,icono,null,null);
            if (name.equalsIgnoreCase(ADMIN)) {
                pass =(String)
JOptionPane.showInputDialog(null, "\n Digite su contraseña " + name + ":", "CONTRASEÑA", JOptionPane.PLAIN_MESSAGE,icono,null,null);
            } else {
                JOptionPane.showMessageDialog(null, "\n Usuario incorrecto", "WARNING", JOptionPane.WARNING_MESSAGE,icono);
            }

            if (pass.equalsIgnoreCase(Integer.toString(contraseña))) {

                preciobase +=
                        Integer.parseInt(JOptionPane.showInputDialog(null, "\n Digite el precio base de los vuelos en dolares: ",
                                                                     "PRECIO", JOptionPane.PLAIN_MESSAGE));
                break;
            } else {
                --intentos;
                JOptionPane.showMessageDialog(null,
                                              "Te quedan " + intentos + " intentos para iniciar nuevamente sesion",
                                              "WARNING", JOptionPane.WARNING_MESSAGE,icono);
            }
            if (intentos == 0) {
                JOptionPane.showMessageDialog(null,
                                              "Lo sentimos:" + "\n Ah sobrepasado la cantidad de intentos" + "\n Contacte a su proveedor",
                                              "WARNING", JOptionPane.WARNING_MESSAGE,icono);
                System.exit(0);
            }
        } while (intentos != 0);
        ///interfaz entrada///////////////////////////////////////////////////////////////////////////
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "\n" +
                            "\n 1- Consultar precio de vuelo: " + "\n 2- Realizar reservacion " +
                            " \n  3- Modificar la resevacion " + "\n 4- Cancelar la reservacion " +
                            "\n 5- Reporte del boleto " + "\n 6- Salir del sistema", "MENU",
                            JOptionPane.PLAIN_MESSAGE));
            switch (opcion) {
            case 1:
                  boolean one;
                do{  
                    one = false;
                try{
                claseboleto = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Clase Economica " + "\n" +
                                "2- Clase Ejecutiva " + "\n" +
                                "3- Primera Clase " + "\n" +
                                " Digite el boleto deseado: ","ELIJA LA CLASE DE BOLETO",JOptionPane.QUESTION_MESSAGE));
                }catch(Exception e){
                    one = true;
                    JOptionPane.showMessageDialog(null," Digite numeros menores al 3","ERROR",JOptionPane.WARNING_MESSAGE);
                    }if(claseboleto >3||claseboleto ==0){one = true;
                             JOptionPane.showMessageDialog(null," Digite numeros menores al 3","ERROR",JOptionPane.WARNING_MESSAGE);
                         }
                     
                }while(one == true);
                JOptionPane.showMessageDialog(null," El precio de el boleto sera de: "+vuelo1.Boleto(preciobase, claseboleto)+
                    "\n"+ " El precio por viajar ahora sera: "+vuelo1.descuento(preciobase, diames, diasalida, claseboleto),"PRECIO",JOptionPane.PLAIN_MESSAGE,icono);
                 
                break;
            case 2:///case menu
          
             boolean ub=false;
                boolean h= false;
                boolean lel = false;
                 boolean indError;
                boolean ad = false;
                boolean ed = false;
                boolean col=false;
                if (opcion == 2) {
                    Pasajero pasaj1 = new Pasajero();
                    do{
                        indError=false;
                        try{
                    claseboleto = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Clase Economica " + "\n" +
                                    "2- Clase Ejecutiva " + "\n" +
                                    "3- Primera Clase " + "\n" +
                                    " Digite el boleto deseado: "));
                    }catch(Exception e){ indError=true;
                    JOptionPane.showMessageDialog(null," DIGITE SOLO LOS VALORES NUMERICOS QUE APARECEN"," Error" ,JOptionPane.WARNING_MESSAGE); 
                    }
                        if(claseboleto>3 || claseboleto==0){indError= true;
                            JOptionPane.showMessageDialog(null," DIGITE SOLO LOS VALORES NUMERICOS QUE APARECEN"," Error" ,JOptionPane.WARNING_MESSAGE);
                        }
                    }while(indError == true);
                    JOptionPane.showMessageDialog(null, vuelo1.mostrarmatriz(claseboleto,pasajero1)+"\n\n\n ATENCION \n" +
                        "EJMP:" +"\n"+
                        "Para escojer su  fila  en el avion digite 4" +"\n"+
                        "EJMP:" +"\n"+
                        "Para escojer su columna en el avion digite  0",
                                                  "Estos son  los asientos disponibles", JOptionPane.PLAIN_MESSAGE,icono );
                   
                   
                    do {
                        do{
                            ed = false;
                        try{ fila =
                                 Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la fila en la que desee estar: "));
                        }catch(Exception p){
                        ed = true;
                        JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y el 4","ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                        if(fila > 4){
                            ed = true;
                            JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y 4","ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                    }while(ed == true);
                        do{ col = false;
                            try{ columna =
                                Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la columna en la que desea estar: "));}
                        catch(Exception e){ed = true;
                            JOptionPane.showMessageDialog(null," Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                            if(columna>3){col =true;
                            JOptionPane.showMessageDialog(null,"Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                            }
                        }while(col == true);
                        
                        
                        do{
                        ub=false;
                            try{
                        if( vuelo1.llenaAsientoB(fila, columna, asiento1)==false ){
                            JOptionPane.showMessageDialog(null," El asiento ya esta ocupado");
                        ub =true;
                        try{fila =
                                       Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la fila en la que desee estar: "));
                            }catch(Exception p){
                            ed = true;
                            JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y el 4","ERROR",JOptionPane.WARNING_MESSAGE);
                            }
                            if(fila > 4){
                                ed = true;
                                JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y 4","ERROR",JOptionPane.WARNING_MESSAGE);
                            }       
                            col = false;
                                                        try{ columna =
                                                            Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la columna en la que desea estar: "));}
                                                    catch(Exception e){ed = true;
                                                        JOptionPane.showMessageDialog(null," Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                                                    }
                                                        if(columna>3){col =true;
                                                        JOptionPane.showMessageDialog(null,"Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                                                        }   
                                   
                        }else{
                        vuelo1.llenaAsientoB(fila, columna, asiento1);
                            }}catch(Exception u){
                                
                            }
                        }while(ub==true);
                        
                        
                        
                        switch (claseboleto) {
                        case 1:
                            if (columna == 0 || columna == 1) {
                                JOptionPane.showMessageDialog(null,
                                                              " Esta clase de Boleto no permite esta columna solo permite las columnas 2 y 3",
                                                              "ERROR", JOptionPane.WARNING_MESSAGE);
                        vuelo1.cancelarreserv(fila, columna);    
                                ad = true;
                            } else {
                                ad = false;
                            }
                            break;
                        case 2:
                            if (columna == 0 || columna == 2 || columna == 3) {
                                JOptionPane.showMessageDialog(null,
                                                              " Esta clase de Boleto no permite esta columna solo permite la columna 1",
                                                              "ERROR", JOptionPane.WARNING_MESSAGE);
                                vuelo1.cancelarreserv(fila, columna);
                                ad = true;
                            } else {
                                ad = false;
                            }
                            break;
                        case 3:
                            if (columna == 1 || columna == 2 || columna == 3) {
                                JOptionPane.showMessageDialog(null,
                                                              " Esta clase de Boleto no permite esta columna solo permite la columna 0",
                                                              "ERROR", JOptionPane.WARNING_MESSAGE);
                                vuelo1.cancelarreserv(fila, columna);
                                ad = true;
                            } else {
                                ad = false;
                            }
                            break;

                        }
                    } while (ad == true);

                    JOptionPane.showMessageDialog(null,
                                                  "SU POSICION EN EL AVION VA A SER LA FILA: " + fila + " Y EN LA COLUMNA: " +
                                                  columna + "\n" +
                            vuelo1.mostrarmatriz(claseboleto,pasajero1),"SU POSICION EN EL AVION",JOptionPane.PLAIN_MESSAGE,icono);
                    
                               
                JOptionPane.showMessageDialog(null, vuelo1.ubicacion(fila, columna,asiento1),"UBICACION",JOptionPane.PLAIN_MESSAGE,icono );        
                    
                    
                    do{lel = false;
                    try{
                    nombre =
                            JOptionPane.showInputDialog(null, "Digite el nombre completo del Pasajero: ","NOMBRE COMPLETO",JOptionPane.PLAIN_MESSAGE);
                    correo =
                            JOptionPane.showInputDialog(null, " Digite la direccion de correo electronico: ","CORREO ELECTRONICO",JOptionPane.PLAIN_MESSAGE );
                    nacionalidad =
                            JOptionPane.showInputDialog(null, " Digite la nacionaildad del pasajero: ","NACIONALIDAD",JOptionPane.PLAIN_MESSAGE);
                    }catch(Exception p){
                        lel = true;
                        JOptionPane.showMessageDialog(null," Digite solo letras","ERROR",JOptionPane.WARNING_MESSAGE);
                    }
                    }while(lel == true);
                    do{h=false;
                        try{    
                            cedula =
                            Integer.parseInt(JOptionPane.showInputDialog(null, " Digite el numero de cedula: ","CEDULA",JOptionPane.PLAIN_MESSAGE));
                            telefono =
                            Integer.parseInt(JOptionPane.showInputDialog(null, " Digite el numero de  telefono: ","TELEFONO",JOptionPane.PLAIN_MESSAGE ));
                            
                        }catch(Exception p){
                            h=true;
                            JOptionPane.showMessageDialog(null," Digite solo valores numericos","ERROR",JOptionPane.WARNING_MESSAGE);
                        }
                    }while(h == true);
                    String destinos[] = {" Argentina"};
                    int l = 
                        JOptionPane.showOptionDialog(null," Escoja el destino que desea "," ELIJA",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono, destinos, destinos[0] ) ;
                    if(l == 0 ){
                        destino = destinos[l];
                    }




                     
                    pasaj1.setNombre(nombre); 
                    pasaj1.setCedula(cedula);
                    pasaj1.setTelefono(telefono);
                    pasaj1.setCorreo(correo);
                    pasaj1.setNacionalidad(nacionalidad);
                    



                    
                    
                  int fac =0;
                  if(opcion == 2){
                      fac=+1;
                  }
                    
                    String hilera = "";
                    String bolet ="";
                    if(claseboleto == 1){
                        bolet = " Clase Economica";
                    }else{
                        if(claseboleto==2){
                            bolet= " Clase Ejecutiva";
                        }else{
                            bolet = " Primera Clase";
                        }
                    }
                    desc2 = (double) vuelo1.descuento(preciobase, diames, diasalida, claseboleto);
                   tot2 =  (double) vuelo1.descuento(preciobase, diames, diasalida, claseboleto);
                     hilera +=
                            " CLIENTE: " + pasajero1.setNombre(nombre) + "                        FECHA: " + diames + "/" + mes +
                            "/" + ano + "\n" +
                            " CEDULA: " + pasajero1.setCedula(cedula) + "                        N FACTURA: " + fac + "\n" +
                            " TELEFONO: " + pasajero1.setTelefono(telefono) + "\n" +
                            " CORREO: " + pasajero1.setCorreo(correo) + "\n" +
                            "  NACIONALIDAD: " + pasajero1.setNacionalidad(nacionalidad) + "\n" +
                            "----------------------------------------------------------------------------------------------" +
                            "\n" +
                            "                                       DESCRIPCION                                       " + "\n" +
                            "-----------------------------------------------------------------------------------------------" +
                            "\n" +
                            "LA CLASE DE BOLETO ES:                " + bolet + "        CANTIDAD: " +
                             vuelo1.Boleto(preciobase, claseboleto) + "\n" +
                            "VALOR POR VIAJAR AHORA: " + desc2    + "\n" +"\n CON DESTINO HACIA: "+destino+"\n"+
                            "TOTAL " + tot2 + "\n" +
                 
                            "----------------------------------------------------------------------------------------------------" +
                            "--" + "\n" +
                            "             GRACIAS POR PREFERIRNOS                                               ";

                    JOptionPane.showMessageDialog(null, hilera,"",JOptionPane.PLAIN_MESSAGE,icono);
                     
                     
                    if( vuelo1.revisaPasajeros(pasajero1)==true){
                        JOptionPane.showMessageDialog(null," El pasajero ya se encuentra registrado","WARNING", JOptionPane.WARNING_MESSAGE,icono);
                        
                    }else{
                        if(vuelo1.revisaPasajeros(pasajero1)!=true){
                            JOptionPane.showMessageDialog(null," El pasajero ah sido registrado correctamente","CONGRATULATIONS",JOptionPane.WARNING_MESSAGE,icono);
                            
                        }
                    }
                        
                     
                }
                 
                 
                break;








            case 3: //menu principal
               

                String op[] = {" SI","NO"};
                int p= JOptionPane.showOptionDialog(null," ¿Desea cambiar su reservacion? "," Cambiar Reservacion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,icono,
                                                    op,op[0]);
                if(p == 0){
                    vuelo1.cancelarreserv(fila, columna);
                    boolean atd = false;
                    
                        Pasajero pasaj1 = new Pasajero();

                    do{
                        indError=false;
                        try{
                    claseboleto = Integer.parseInt(JOptionPane.showInputDialog(null, "1-Clase Economica " + "\n" +
                                    "2- Clase Ejecutiva " + "\n" +
                                    "3- Primera Clase " + "\n" +
                                    " Digite el boleto deseado: "));
                    }catch(Exception e){ indError=true;
                    JOptionPane.showMessageDialog(null," DIGITE SOLO LOS VALORES NUMERICOS QUE APARECEN"," Error" ,JOptionPane.WARNING_MESSAGE); 
                    }
                        if(claseboleto>3 || claseboleto==0){indError= true;
                            JOptionPane.showMessageDialog(null," DIGITE SOLO LOS VALORES NUMERICOS QUE APARECEN"," Error" ,JOptionPane.WARNING_MESSAGE);
                        }
                    }while(indError == true);
                        JOptionPane.showMessageDialog(null, vuelo1.mostrarmatriz(claseboleto,pasajero1)+"\n\n\n ATENCION \n" +
                            "EJMP:" +"\n"+
                            "Para escojer su  fila  en el avion digite 4" +"\n"+
                            "EJMP:" +"\n"+
                            "Para escojer su columna en el avion digite  0",
                                                      "Estos son  los asientos disponibles", JOptionPane.PLAIN_MESSAGE );
                       
                       
                            do{
                            ub=false;
                                try{
                            if( vuelo1.llenaAsientoB(fila, columna, asiento1)==false ){
                                JOptionPane.showMessageDialog(null," El asiento ya esta ocupado");
                            ub =true;
                            try{fila =
                                           Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la fila en la que desee estar: "));
                                }catch(Exception m){
                                ed = true;
                                JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y el 4","ERROR",JOptionPane.WARNING_MESSAGE);
                                }
                                if(fila > 4){
                                    ed = true;
                                    JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y 4","ERROR",JOptionPane.WARNING_MESSAGE);
                                }       
                                col = false;
                                                            try{ columna =
                                                                Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la columna en la que desea estar: "));}
                                                        catch(Exception e){ed = true;
                                                            JOptionPane.showMessageDialog(null," Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                                                        }
                                                            if(columna>3){col =true;
                                                            JOptionPane.showMessageDialog(null,"Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                                                            }   
                                       
                            }else{
                            vuelo1.llenaAsientoB(fila, columna, asiento1);
                                }}catch(Exception u){
                                    
                                }
                            }while(ub==true);
                            
                        
                        
                        
                        
                        
                            switch (claseboleto) {
                            case 1:
                                if (columna == 0 || columna == 1) {
                                    JOptionPane.showMessageDialog(null,
                                                                  " Esta clase de Boleto no permite esta columna solo permite las columnas 2 y 3",
                                                                  "ERROR", JOptionPane.WARNING_MESSAGE);
                            vuelo1.cancelarreserv(fila, columna);    
                                    atd = true;
                                } else {
                                    atd = false;
                                }
                                break;
                            case 2:
                                if (columna == 0 || columna == 2 || columna == 3) {
                                    JOptionPane.showMessageDialog(null,
                                                                  " Esta clase de Boleto no permite esta columna solo permite la columna 1",
                                                                  "ERROR", JOptionPane.WARNING_MESSAGE);
                                    vuelo1.cancelarreserv(fila, columna);
                                    atd = true;
                                } else {
                                    atd = false;
                                }
                                break;
                            case 3:
                                if (columna == 1 || columna == 2 || columna == 3) {
                                    JOptionPane.showMessageDialog(null,
                                                                  " Esta clase de Boleto no permite esta columna solo permite la columna 0",
                                                                  "ERROR", JOptionPane.WARNING_MESSAGE);
                                    vuelo1.cancelarreserv(fila, columna);
                                    atd = true;
                                } else {
                                    atd = false;
                                }
                                break;

                            
                        } while (atd == true);
vuelo1.llenaAsientoB(fila, columna, asiento1);
                        JOptionPane.showMessageDialog(null,
                                                      "SU POSICION EN EL ASIENTO VA A SER LA FILA: " + fila + " Y EN LA COLUMNA: " +
                                                      columna + "\n" +
                                vuelo1.mostrarmatriz(claseboleto,pasajero1));
 
                    vuelo1.llenar(fila, columna);  
                    JOptionPane.showMessageDialog(null, vuelo1.ubicacion(fila, columna,asiento1),"UBICACION",JOptionPane.PLAIN_MESSAGE,icono );        
                        
                    double desc3=(double) vuelo1.descuento(preciobase, diames, diasalida, claseboleto);
                    double tot3= (double)((vuelo1.Boleto(preciobase, claseboleto)) - desc3 );
                        JOptionPane.showMessageDialog(null," El nuevo precio a pagar era de:   "+tot2+"\n"+
                                                      "Pero ahora sera de:   "+vuelo1.Boleto(preciobase, claseboleto)+"\n"+
                                                      "Con un descuento de:   "+desc3+"\n"+
                                                      " El nuevo total sera:   "+tot3,"Nuevo precio a pagar",JOptionPane.PLAIN_MESSAGE,icono);
                        
                      
                
                        
                

                }


                break;
            case 4: //el menu principal
boolean nu;
                
                boolean ju;
                    String options[] = { "Si", "No" }; //Respuestas
                    int k =
                        JOptionPane.showOptionDialog(null, "¿ DESEA CANCELAR LA RESERVACION ? ", " CANCELAR RESERVACION",
                                                     JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono,
                                                     options, options[1]);
                    if (k == 0) {
                            do{
                             nu = false;   
                            try{ fila =
                                     Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la fila en la que estaba su asiento: "));
                            }catch(Exception o){
                            nu = true;
                            JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y el 4","ERROR",JOptionPane.WARNING_MESSAGE);
                            }
                            if(fila > 4){
                                nu = true;
                                JOptionPane.showMessageDialog(null," Digite numeros entre el 0 y 4","ERROR",JOptionPane.WARNING_MESSAGE);
                            }
                        }while(nu == true);
                            do{ ju = false;
                                try{ columna =
                                    Integer.parseInt(JOptionPane.showInputDialog(null, " Digite la columna en la que estaba su asiento: "));}
                            catch(Exception e){ju = true;
                                JOptionPane.showMessageDialog(null," Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                            }
                                if(columna>3){ju =true;
                                JOptionPane.showMessageDialog(null,"Digite solo numeros entre 0 y 3","ERROR",JOptionPane.WARNING_MESSAGE);
                                }
                            }while(ju == true);
                     vuelo1.cancelarreserv(fila, columna);
                   JOptionPane.showMessageDialog(null," SU RESERVACION AH SIDO CANCELADA","GRACIAS POR PREFERINOS",JOptionPane.PLAIN_MESSAGE,icono);
                        }
                            else{
                                 if (k == 1) {
                            JOptionPane.showMessageDialog(null, " GRACIAS POR PREFERIRNOS ", " GRACIAS POR PREFERIRNOS",
                                                     JOptionPane.PLAIN_MESSAGE,icono);
                            }
                        }
                
               
               
               
               
               
               
                break;
            
            
            case 5:///menu principal
            int cont=0;
             if(opcion==5){
                 
               
               
                     cont=+1;
                
           
                
                String hilera="";
                
                String []vuelo ={"AD","2D","3D","4D","5D","6D","7D","8D","9D","0D"
                                 ,"JD","JK","QD","KD","AB","2B","3B","6B","8B","9D","0H","AC","2C"
                                 ,"KC","LM","ML","4C","6C","7V","8C","9C","0C",
                                 "JC","9F","0F","KF","QF","0F","QC","DC","AC","KK"};
                int num= (int) (Math.random()*51);
                Calendar kalen = Calendar.getInstance();
             
                
                int mes5 = kalen.get(Calendar.MONTH)+2;
                int  hora = kalen.get(Calendar.HOUR);
                int dia5= kalen.get(Calendar.DAY_OF_MONTH)+2;
                int ano5= kalen.get(Calendar.YEAR);
                String f = dia5+"/"+mes5+"/"+ano5;
                int  boleto = (int) Math.random()*30;
                    String vlo=vuelo[boleto]+num;
                String bolt="";
                if(claseboleto==1){
                    bolt = "Economica";
                }else{
                    if(claseboleto==2){
                        bolt= "Ejecutiva";
                    }else{if(claseboleto == 3){
                        bolt= "Primera";
                    }}
                }
             int as =vuelo1.llenar(fila, columna);
             
             
             
                
                
                    hilera+= "***********************************************************************************"+"\n"+
                             "                                                                                "+"N°Boleto:"+cont+"\n"+
                        "\n"+
                        "N°VUELO"+"      "+"DESTINO"+"     "+"CLASE"+"            "+"  FECHA"+"                 "+" HORA"+"   "+"  ASIENTO"+"\n"+
                          vlo+"           "+destino+"       "+ bolt+"        "+dia5+"/"+mes5+"/"+ano5+"          "+hora+"   "+"      "+as+
                     " "+                                                                                                     
                        "\n"+
                        "*****************************************************************************************";
                                 
                    
                JOptionPane.showMessageDialog(null,hilera,"",JOptionPane.PLAIN_MESSAGE,icono);
                
                
                
                
                
                
                
                
                
                
            }
                break;
            case 6:

               
                    JOptionPane.showMessageDialog(null," !!GRACIAS POR PREFERIRNOS!!"," ADIOS",JOptionPane.PLAIN_MESSAGE);
                    
            
                
                
                
                break;


            }

        } while (opcion != 6);


        ////////////////////////////////Fin del menu/////////////////////////////////////////////////////////////////////


    }


}////fin de la clase main  