public abstract  class Movimiento {
    private int id;
    private double cantidad;
    private String descripcion;
    private String fecha;
    private Categoria categoria;

    public Movimiento(int id, double cantidad, String descripcion,
                       String fecha, Categoria categoria) {

        this.id = id;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public abstract void aplicarMovimiento();

    public double getCantidad(){
        return cantidad;
    }
    public String getDescripcion(){
        return descripcion;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                " | Cantidad: " + cantidad + "€" +
                " | Descripción: " + descripcion +
                " | Fecha: " + fecha +
                " | Categoría: " + categoria;
    }
}
