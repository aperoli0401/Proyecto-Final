public abstract  class Movimiento {
    private int id;
    private double cantidad;
    private String descripcion;
    private String fecha;
    private Categoria categoria;

    public double getCantidad(){
        return cantidad;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
