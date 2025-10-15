import java.io.*;
import java.util.*;

public class Act05 {

public static void main (String []args) throws IOException {

    try {

        // Abrir el archivo CSV
        File f = new File ("viviendas-por-intensidad-de-uso-a-partir-del-consumo-electrico.-mediana-consumo-anual.csv");
        FileReader csv = new FileReader (f);
        
        // Leer el archivo CSV
        BufferedReader br = new BufferedReader (csv);
        
        // Leer línea por línea
        String linea;
        br.readLine();
        
        // Crear una lista para almacenar los municipios
        ArrayList<Municipio> Municipios = new ArrayList<>();
        
        // Procesar cada línea del archivo
        while ((linea = br.readLine()) != null ) {
            // Dividir la línea en campos
            String [] datos = linea.split (";");
            String Año = datos[0];
            String TipoTer = datos[1];
            String CodTer = datos[2];
            String Territorio = datos[3];
            String Valor = datos[4];
            String EstadoDato = datos[5];
            
            // Omitir líneas con valores no numéricos o vacíos
            if (Valor.isEmpty() || Valor.equals("-")) continue;

            // Convertir el valor en entero
            int ValorInt = Integer.parseInt(Valor);
                        
            // Crear un objeto Municipio y agregarlo a la lista
            Municipio m = new Municipio (Territorio ,ValorInt, CodTer);
            System.out.println( linea );
            Municipios.add(m);
            System.out.println();

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

        System.out.println();

        System.out.println("Los tres municipios con mayor valor son:");

        // Imprimir los tres municipios con mayor valor
        int limite = Math.min(3, Municipios.size());
        for (int i = 0; i < limite; i++) {
            Municipio m = Municipios.get(i);
            System.out.println("Territorio: " + m.getTerritorio());
            System.out.println("Valor: " + m.getValor());
            System.out.println("Código: " + m.getCodigo());
            if (i < limite - 1) System.out.println();
        }
    
    } catch (EOFException e){
    
    }
    
}

}
