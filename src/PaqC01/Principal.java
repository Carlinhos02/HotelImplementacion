package PaqC01;

import java.io.*;

public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cliente a=new Cliente("Carlos","Sánchez","11234142D",2342356,78857,10,20);

        Hotel h=new Hotel();
        System.out.println(h);

        h.reservar(a);
        System.out.println(h);

        Cliente c=new Cliente();
        c.introducirDatos();

        h.reservar(c);
        System.out.println(h);

        h.anularReserva(c);
        System.out.println("Despues de anular la reserva");
        System.out.println(h);

        FileOutputStream fos = null;
        ObjectOutputStream salida = null;
        fos = new FileOutputStream("HotelSerializar.dat");
        salida = new ObjectOutputStream(fos);
        salida.writeObject(h);
        fos.close();
        salida.close();
        FileInputStream fis = null;
        ObjectInputStream entrada = null;
        fis = new FileInputStream("HotelSerializar.dat");
        entrada = new ObjectInputStream(fis);

        System.out.println("\n\n");

        h= (Hotel) entrada.readObject();
        fis.close();
        entrada.close();
        System.out.println(h);


    }

}
