import java.io.*;
import java.util.*;

public class Act05 {

public static void main (String []args) throws IOException {

    try {

        // Leer archivo
        File f = new File ("viviendas-por-intensidad-de-uso-a-partir-del-consumo-electrico.-mediana-consumo-anual.csv");
        FileReader csv = new FileReader (f);
        
        BufferedReader br = new BufferedReader (csv);
        
        String linea;
        br.readLine();
        
        // Crear lista de municipios 
        ArrayList<Municipio> Municipios = new ArrayList<>();
        
        // Leer linea por linea
        while ((linea = br.readLine()) != null ) {
            // Separar con split
            String [] datos = linea.split (";");
            String Año = datos[0];
            String TipoTer = datos[1];
            String CodTer = datos[2];
            String Territorio = datos[3];
            String Valor = datos[4];
            String EstadoDato = datos[5];
            
            // Saltar valores vacios
            if (Valor.isEmpty() || Valor.equals("-")) continue;

            // Convertir el valor en entero
            int ValorInt = Integer.parseInt(Valor);
                        
            // Crear municipio
            Municipio m = new Municipio (Territorio ,ValorInt, CodTer);
            
            System.out.println( linea );
            // Agregar municipio a la lista de municipios
            Municipios.add(m);
            System.out.println( );
        }

        // Verificar que hay municipios
        if (Municipios.isEmpty()) {
            System.out.println("No se encontraron municipios.");
            return;
        }
    
        // Ordenar los municipios por valor descendente
        Collections.sort(Municipios, new Comparator<Municipio>() {
                @Override
                public int compare(Municipio m1, Municipio m2) {
                    return Integer.compare(m2.getValor(), m1.getValor());
                }
        });

        // Imprimir la lista ordenada
        System.out.println("Lista de municipios ordenados por valor (descendente):");
        for (Municipio munici : Municipios) {
            System.out.println(munici);
        }

        System.out.println( );

        // Calcular la posición del medio
        int size = Municipios.size();
        int medio = size / 2;
        
        // Determinar el rango de municipios a mostrar
        int inicio, fin;
        
        if (size < 3) {
            // Si hay menos de 3 municipios, mostrar todos
            inicio = 0;
            fin = size;
        } else {
            // Calcular para obtener 3 municipios del medio
            inicio = medio - 1;
            fin = medio + 2;
        }
        
        for (int i = inicio; i < fin; i++) {
            Municipio m = Municipios.get(i);
            System.out.println("Territorio: " + m.getTerritorio());
            System.out.println("Valor: " + m.getValor());
            System.out.println("Código: " + m.getCodigo());
            if (i < fin - 1) System.out.println();
        }

    } catch (EOFException e){
        System.err.println("Error al leer el archivo.");
    }
     
}

}
