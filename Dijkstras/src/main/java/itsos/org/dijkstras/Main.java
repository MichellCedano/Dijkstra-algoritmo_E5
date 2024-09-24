/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package itsos.org.dijkstras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author julio
 */
public class Main {

    public static void main(String[] args) {
       // Creamos el grafo como una lista de adyacencia
        int numVertices = 5;
        List<List<Nodo>> graph = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Añadir las aristas (u -> v, peso)
        graph.get(0).add(new Nodo(1, 9));
        graph.get(0).add(new Nodo(2, 6));
        graph.get(0).add(new Nodo(3, 5));
        graph.get(0).add(new Nodo(4, 3));

        graph.get(2).add(new Nodo(1, 2));
        graph.get(2).add(new Nodo(3, 4));

        // Ejecutamos el algoritmo de Dijkstra desde el nodo 0
        dijkstra(graph, 0);
    }
     public static void dijkstra(List<List<Nodo>> graph, int source) {
        // Número de nodos en el grafo
        int numVertices = graph.size();
        
        // Array para almacenar la distancia mínima desde el nodo origen
        int[] distancias = new int[numVertices];
        
        // Inicializamos las distancias a infinito (representado como un número muy grande)
        Arrays.fill(distancias, Integer.MAX_VALUE);
        
        // Cola de prioridad para seleccionar el nodo con la menor distancia
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        
        // Distancia del nodo origen a sí mismo es 0
        distancias[source] = 0;
        
        // Añadimos el nodo origen a la cola
        pq.add(new Nodo(source, 0));
        
        // Procesar los nodos mientras haya elementos en la cola de prioridad
        while (!pq.isEmpty()) {
            // Sacar el nodo con la distancia mínima
            Nodo actual = pq.poll();
            int u = actual.vertice;
            
            // Iterar sobre los vecinos del nodo actual
            for (Nodo vecino : graph.get(u)) {
                int v = vecino.vertice;
                int weight = vecino.distancia;
                
                // Si se encuentra un camino más corto hacia el vecino
                if (distancias[u] + weight < distancias[v]) {
                    distancias[v] = distancias[u] + weight;
                    pq.add(new Nodo(v, distancias[v]));
                }
            }
        }
        
        // Imprimir las distancias mínimas desde el nodo origen
        System.out.println("Distancias desde el nodo " + source + ":");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("Nodo " + i + ": " + distancias[i]);
        }
    }
}



class Nodo implements Comparable<Nodo> {
    int vertice;
    int distancia;

    public Nodo(int vertice, int distancia) {
        this.vertice = vertice;
        this.distancia = distancia;
    }

    // Definir cómo se comparan los nodos para la cola de prioridad
    @Override
    public int compareTo(Nodo otroNodo) {
        return this.distancia - otroNodo.distancia;
    }

    
}


    
   



