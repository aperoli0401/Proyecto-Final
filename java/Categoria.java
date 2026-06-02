import java.util.Scanner;

public enum Categoria {
    COMIDA,
    TRANSPORTE,
    OCIO,
    SALARIO,
    EDUCACION,
    SALUD,
    HOGAR,
    OTROS;
    
    public static Categoria elegirCategoria(Scanner sc) {
    	
    	Categoria[] categorias = Categoria.values();
    	int opcion;
    	
    	
    	do {
    		System.out.println();
            System.out.println("Seleccione una categoría:");
            

            for (int i = 0; i < categorias.length; i++) {

                System.out.println((i + 1) + ". " + categorias[i]);
            }

            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();
            
            // Para que la opcion sea de 1 en adelante
            // Si la opcion es menor que 1 o la opcion es mayor que el numero de categorias
            if (opcion < 1 || opcion > categorias.length) {
                System.out.println("Categoría no válida. Inténtelo de nuevo.");
            }
                
    	} while (opcion < 1 || opcion > categorias.length);
        
    	// Devuelve la categoría segun la posicion en el array
        return categorias[opcion - 1];
    	
    }
}