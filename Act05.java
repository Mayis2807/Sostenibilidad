import java.io.*;
import java.util.*;

public class Act05 {

public static void main (String []args) throws IOException {

    try {

        File f = new File ("viviendas-por-intensidad-de-uso-a-partir-del-consumo-electrico.-mediana-consumo-anual.csv");
        FileReader csv = new FileReader (f);
        
        BufferedReader br = new BufferedReader (csv);
        
        String linea;
        br.readLine();
        
        ArrayList<Municipio> Municipios = new ArrayList<>();
        
        while ((linea = br.readLine()) != null ) {
            String [] datos = linea.split (";");
            String Año = datos[0];
            String TipoTer = datos[1];
            String CodTer = datos[2];
            String Terrritorio = datos[3];
            String Valor = datos[4];
            String EstadoDato = datos[5];
            
            if (Valor.isEmpty() || Valor.equals("-")) continue;

            int ValorInt = Integer.parseInt(Valor);
                        
            Municipio m = new Municipio (Terrritorio ,ValorInt, CodTer);
            
            System.out.println( linea );
            Municipios.add(m);
        }
    
        // Ordenar los municipios por valor descendente
        Collections.sort(Municipios, new Comparator<Municipio>() {
                @Override
                public int compare(Municipio m1, Municipio m2) {
                    return Double.compare(m2.getValor(), m1.getValor());
                }
        });

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
