import java.util.LinkedList;
import java.util.Queue;

// Representa un módulo del proyecto final de la UTA
class Nodo {
    String modulo;
    Nodo izq, der;

    public Nodo(String m) {
        this.modulo = m;
        this.izq = null;
        this.der = null;
    }
}

class DibujanteArbol {
    // Impresión visual del sistema SmartCampus basado en el proyecto final de la UTA
    public void imprimirEstructura() {
        System.out.println("\n--- REPRESENTACION VISUAL DEL SISTEMA (SmartCampus) ---");
        System.out.println("            [SmartCampus Web]              "); // Raíz
        System.out.println("                 /      \\                 ");
        System.out.println("       [Usuarios]        [Academico]       "); // Nivel 1
        System.out.println("        /     \\           /      \\        ");
        System.out.println("  [Auth]   [Roles]   [Materias] [Sesiones] "); // Nivel 2
        System.out.println("                                   /       ");
        System.out.println("                              [Asistencia] "); // Nivel 3
        System.out.println("------------------------------------------");
    }
}

// Gestiona el sistema SmartCampus con sus módulos y recorridos
class GestionSistema {
    public Nodo raiz;

    public GestionSistema() {
        // Armamos el SmartCampus con sus 5 nodos nuevos basados en el proyecto final
        raiz = new Nodo("SmartCampus Web");
        raiz.izq = new Nodo("Gestion Usuarios");
        raiz.izq.izq = new Nodo("Auth JWT");         // Nodo Nuevo 1
        raiz.izq.der = new Nodo("Roles Docente/Est"); // Nodo Nuevo 2
        
        raiz.der = new Nodo("Gestion Academica");
        raiz.der.izq = new Nodo("Materias (Vector)");     // Nodo Nuevo 3
        raiz.der.der = new Nodo("Sesiones (L.Circular)"); // Nodo Nuevo 4
        raiz.der.der.izq = new Nodo("Asistencia (Cola)"); // Nodo Nuevo 5
    }

    // --- RECORRIDOS DEL ÁRBOL ---

    // Inorden: Izquierda -> Raiz -> Derecha
    public void recorridoInorden(Nodo r) {
        if (r == null) return;
        recorridoInorden(r.izq);
        System.out.print("[" + r.modulo + "] ");
        recorridoInorden(r.der);
    }

    // Preorden: Raiz -> Izquierda -> Derecha
    public void recorridoPreorden(Nodo r) {
        if (r == null) return;
        System.out.print("[" + r.modulo + "] ");
        recorridoPreorden(r.izq);
        recorridoPreorden(r.der);
    }

    // Postorden: Izquierda -> Derecha -> Raiz
    public void recorridoPostorden(Nodo r) {
        if (r == null) return;
        recorridoPostorden(r.izq);
        recorridoPostorden(r.der);
        System.out.print("[" + r.modulo + "] ");
    }

    // BFS (Breadth-First Search) o Recorrido por Niveles
    public void recorridoBFS() {
        if (raiz == null) return;
        // En Java usamos LinkedList como implementación de la interfaz Queue
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll(); // Saca el primero de la cola
            System.out.print("[" + actual.modulo + "] ");
            if (actual.izq != null) cola.add(actual.izq);
            if (actual.der != null) cola.add(actual.der);
        }
    }
}

// Clase principal para ejecutar el programa en Java
public class Main {
    public static void main(String[] args) {
        GestionSistema smart = new GestionSistema();
        DibujanteArbol dibujo = new DibujanteArbol();

        // 1. PRIMERO DIBUJAMOS EL ARBOL
        dibujo.imprimirEstructura();

        // 2. LUEGO LOS RECORRIDOS SEPARADOS

        System.out.println("\nRECORRIDO INORDEN:");
        System.out.println("Codigo: Izquierda -> Raiz -> Derecha");
        smart.recorridoInorden(smart.raiz);
        System.out.println("\n"); // Espacio para separar

        System.out.println("RECORRIDO PREORDEN:");
        System.out.println("Codigo: Raiz -> Izquierda -> Derecha");
        smart.recorridoPreorden(smart.raiz);
        System.out.println("\n");

        System.out.println("RECORRIDO POSTORDEN:");
        System.out.println("Codigo: Izquierda -> Derecha -> Raiz");
        smart.recorridoPostorden(smart.raiz);
        System.out.println("\n");

        System.out.println("RECORRIDO BFS (POR NIVELES):");
        System.out.println("Codigo: Uso de Queue (Cola) FIFO");
        smart.recorridoBFS();

        System.out.println("\n");
    }
}