package PaqC01;

import java.io.Serializable;

public class Hotel implements Serializable{

    private Cliente[][] habitaciones;

    public Hotel(){

        habitaciones=new Cliente[8][6];
    }

    public String toString(){

        String s="";

        for(int i=0;i<8;i++){
            for(int j=0;j<6;j++){
                if(habitaciones[i][j]==null){
                    s=s+" [ L ] ";
                }
                else{
                    s=s+" [ R ] ";
                }
            }
            s=s+"\n";
        }
        return s;
    }

    public void anularReserva(Cliente cliente){

        for(int i=7;i>=0;i--){
            for(int j=0;j<6;j++){
                if(habitaciones[i][j]==cliente){
                    habitaciones[i][j]=null;
                    System.out.println("Se ha anulado su reserva");
                    return;
                }
            }
        }
        System.out.println("No se ha encontrado la reserva a los datos de su cliente, pruebe con otro cliente");
    }

    public void reservar(Cliente cliente){

        for(int i=7;i>=0;i--){
            for(int j=0;j<6;j++){
                if(habitaciones[i][j]==null){
                    habitaciones[i][j]=cliente;
                    System.out.println("Su reserva se ha confirmado en la planta "+(7-(i-1))+", habitación "+(j+1)+"\n");
                    return;
                }
            }
        }
        System.out.println("El hotel se encuentra lleno, no se ha podido realizar la reserva.");
    }

}
