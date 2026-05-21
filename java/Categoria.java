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

        System.out.println();
        System.out.println("Seleccione una categoría:");

        Categoria[] categorias = Categoria.values();

        for (int i = 0; i < categorias.length; i++) {

            System.out.println((i + 1) + ". " + categorias[i]);
        }

        System.out.print("Opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        return categorias[opcion - 1];
    }
}