public class Municipio {
    
    private String Territorio;
    private Integer Valor;
    private String Codigo;

    public Municipio() {
    }
    
    public Municipio(String territorio, Integer valor, String codigo) {
        Territorio = territorio;
        Valor = valor;
        Codigo = codigo;
        
        System.out.println(" Se ha creado el municipio con "+ territorio+" "+ valor + " " + codigo+".");
    }
    
    public String getTerritorio() {
        return Territorio;
    }
    public void setTerritorio(String territorio) {
        Territorio = territorio;
    }
    public Integer getValor() {
        return Valor;
    }
    public void setValor(Integer valor) {
        Valor = valor;
    }
    public String getCodigo() {
        return Codigo;
    }
    public void setCodigo(String codigo) {
        Codigo = codigo;
    }

    @Override
    public String toString() {
        return "Municipio: " + Territorio + ", Valor: " + Valor;
    }
}
