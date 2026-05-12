public class Usuario {
    private String nombre;
    private String contraseña;
    private Cuenta cuenta;

    public Usuario (String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.cuenta = new Cuenta();
    }

    public String getNombre() {
        return nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre;
    }
    
}
