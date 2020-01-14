package Proyecto;

import javax.swing.JOptionPane;

public class Pasajero {
    private int cedula;
    private String nombre;
    private int telefono;
    private String correo;
    private String nacionalidad;
    
    public Pasajero() {
        this.nombre=" ";
        this.cedula=0;
        this.telefono=0;
        this.correo=" ";
        this.nacionalidad=" ";
    }

    public int setCedula(int cedula) {
      return  this.cedula = cedula;
    }

    public int getCedula() {
        return cedula;
    }

    public String setNombre(String nombre) {
         return this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int setTelefono(int telefono) {
         return this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public String setCorreo(String correo) {
        return this.correo = correo;
    }

    public String getCorreo() {
        return correo;
    }

    public String setNacionalidad(String nacionalidad) {
         return this.nacionalidad = nacionalidad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public String toString(){
        String hilera="";
        
        hilera +="El nombre del pasajero es:" +nombre+"\n El numero de cedula: "+cedula+"\n Nacionalidad:"+nacionalidad+"\n Telefono: "+telefono+"\n  Correo Electronico"+correo+"\n";
    return hilera;    }
}
