#include <iostream>
#include <string>
#include <queue>

using namespace std;

// Representa un módulo del proyecto final 
class Nodo {
public:
    string modulo;
    Nodo *izq, *der;
    Nodo(string m) : modulo(m), izq(nullptr), der(nullptr) {}
}; 

class DibujanteArbol {
public:
    //impresion visual del sistema SmartCampus basado en el proyecto final 
    void imprimirEstructura() {
        cout << "\n--- REPRESENTACION VISUAL DEL SISTEMA (SmartCampus) ---" << endl;
        cout << "            [SmartCampus Web]              " << endl; // Raíz
        cout << "                 /      \\                 " << endl;
        cout << "       [Usuarios]        [Academico]       " << endl; // Nivel 1
        cout << "        /     \\           /      \\        " << endl;
        cout << "  [Auth]   [Roles]   [Materias] [Sesiones] " << endl; // Nivel 2
        cout << "                                   /       " << endl;
        cout << "                              [Asistencia] " << endl; // Nivel 3
        cout << "------------------------------------------" << endl;
    }
};

// Gestiona el sistema SmartCampus con sus módulos y recorridos
class GestionSistema {
public:
    Nodo* raiz;

    GestionSistema() {
        // Armamos el SmartCampus con sus 5 nodos nuevos basados en el proyecto final
        raiz = new Nodo("SmartCampus Web");
        raiz->izq = new Nodo("Gestion Usuarios");
        raiz->izq->izq = new Nodo("Auth JWT");         // Nodo Nuevo 1
        raiz->izq->der = new Nodo("Roles Docente/Est"); // Nodo Nuevo 2
        
        raiz->der = new Nodo("Gestion Academica");
        raiz->der->izq = new Nodo("Materias (Vector)");     // Nodo Nuevo 3
        raiz->der->der = new Nodo("Sesiones (L.Circular)"); // Nodo Nuevo 4
        raiz->der->der->izq = new Nodo("Asistencia (Cola)"); // Nodo Nuevo 5
    } 

    // Recorridos del árbol 

    // Inorden: Izquierda -> Raiz -> Derecha
    void recorridoInorden(Nodo* r) {
        if (r == nullptr) return;
        recorridoInorden(r->izq);
        cout << "[" << r->modulo << "] ";
        recorridoInorden(r->der);
    }

    // Preorden: Raiz -> Izquierda -> Derecha
    void recorridoPreorden(Nodo* r) {
        if (r == nullptr) return;
        cout << "[" << r->modulo << "] ";
        recorridoPreorden(r->izq);
        recorridoPreorden(r->der);
    }
 
    // Postorden: Izquierda -> Derecha -> Raiz
    void recorridoPostorden(Nodo* r) {
        if (r == nullptr) return;
        recorridoPostorden(r->izq);
        recorridoPostorden(r->der);
        cout << "[" << r->modulo << "] ";
    } 

    // BFS (Breadth-First Search) o Recorrido por Niveles
    void recorridoBFS() {
        if (raiz == nullptr) return;
        queue<Nodo*> cola;
        cola.push(raiz);
        while (!cola.empty()) {
            Nodo* actual = cola.front();
            cola.pop();
            cout << "[" << actual->modulo << "] ";
            if (actual->izq) cola.push(actual->izq);
            if (actual->der) cola.push(actual->der);
        }
    }
}; 

// Función principal para ejecutar el programa

int main() {
    GestionSistema smart;
    DibujanteArbol dibujo;

    // 1. PRIMERO DIBUJAMOS EL ARBOL
    dibujo.imprimirEstructura();

    // 2. LUEGO LOS RECORRIDOS SEPARADOS

    cout << "\n\nRECORRIDO INORDEN:";
    cout << "\nCodigo: Izquierda -> Raiz -> Derecha\n";
    smart.recorridoInorden(smart.raiz); 
    cout << "\n\n"; // Salto de línea para separar los recorridos

    cout << "\nRECORRIDO PREORDEN:";
    cout << "\nCodigo: Raiz -> Izquierda -> Derecha\n";
    smart.recorridoPreorden(smart.raiz);
    cout << "\n\n"; // Salto de línea para separar los recorridos

    cout << "\n\nRECORRIDO POSTORDEN:";
    cout << "\nCodigo: Izquierda -> Derecha -> Raiz\n";
    smart.recorridoPostorden(smart.raiz);
    cout << "\n\n"; // Salto de línea para separar los recorridos

    cout << "\n\nRECORRIDO BFS (POR NIVELES):";
    cout << "\nCodigo: Uso de Queue (Cola) FIFO\n";
    smart.recorridoBFS();

    cout << "\n\n";
    return 0;
}