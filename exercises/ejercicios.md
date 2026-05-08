# Ejercicios para clase

## Ejercicio 1
Dado el árbol:

```text
        10
       /  \
      5    15
     / \   / \
    2   7 12 20
```

Escriba manualmente:

- Preorden: 10 → 5 → 2 → 7 → 15 → 12 → 20
- Inorden: 2 → 5 → 7 → 10 → 12 → 15 → 20
- Postorden: 2 → 7 → 5 → 12 → 20 → 15 → 10
- BFS: 10 → 5 → 15 → 2 → 7 → 12 → 20

## Ejercicio 2
Modifique el árbol anterior agregando los nodos 1, 3, 18 y 25. Ejecute nuevamente los recorridos.

```text
             10
           /    \
          5      15
        /  \    /  \
       2    7  12   20
      / \          /  \
     1   3        18  25
```
- Preorden: 10 → 5 → 2 → 1 → 3 → 7 → 15 → 12 → 20 → 18 → 25
- Inorden: 1 → 2 → 3 → 5 → 7 → 10 → 12 → 15 → 18 → 20 → 25
- Postorden: 1 → 3 → 2 → 7 → 5 → 12 → 18 → 25 → 20 → 15 → 10
- BFS: 10 → 5 → 15 → 2 → 7 → 12 → 20 → 1 → 3 → 18 → 25

## Ejercicio 3
Implemente una función que cuente la cantidad total de nodos del árbol.

public int contarNodos(Nodo nodo) {

    if (nodo == null) {
        return 0;
    }

    return 1 +
           contarNodos(nodo.izquierda) +
           contarNodos(nodo.derecha);
}

## Ejercicio 4
Implemente una función que cuente las hojas del árbol.

public int contarHojas(Nodo nodo) {

    if (nodo == null) {
        return 0;
    }

    if (nodo.izquierda == null &&
        nodo.derecha == null) {

        return 1;
    }

    return contarHojas(nodo.izquierda) +
           contarHojas(nodo.derecha);
}

## Ejercicio 5 aplicado al proyecto final
Represente los módulos de un sistema web como un árbol binario. Ejemplo:

```text
            Sistema Web
           /           \
     Usuarios        Inventario
      /    \          /      \
 Registrar Buscar  Productos Reportes
```

Explique qué recorrido usaría para:

1. Mostrar el menú principal.
PREORDEN - Porque primero muestra la raíz y luego los submódulos.

2. Procesar primero los módulos internos.
POSTORDEN - Porque primero procesa los hijos y al final el nodo principal.

3. Mostrar módulos nivel por nivel.
BFS - Porque recorre el árbol por niveles usando una cola.