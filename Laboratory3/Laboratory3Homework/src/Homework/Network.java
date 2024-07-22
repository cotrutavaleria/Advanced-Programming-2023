package Homework;

import java.util.*;

import static java.util.Collections.sort;

public class Network implements Comparator<Node> {
    private List<Node> nodes;
    private HashMap<String, Boolean> visitedVertices;
    private HashMap<String, List<String>> connectionsPerNode;
    private Map<String, Integer> lowpoint;
    private Map<String, Integer> depth;
    private Map<String, String> parent;
    private List<String> articulationPoints;
    private int currentDepth;

    public Network() {
        this.nodes = new ArrayList<>();
        this.visitedVertices = new HashMap<>();
        this.connectionsPerNode = new HashMap<>();
        this.lowpoint = new HashMap<>();
        this.depth = new HashMap<>();
        this.parent = new HashMap<>();
        this.articulationPoints = new ArrayList<>();
        this.currentDepth = 0;
    }

    public void addNode(Node node) {
        this.nodes.add(node);
        addToConnectionsPerNodeList(node);
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getConnectionNumber() - o2.getConnectionNumber();
    }

    //Create a method that computes the importance of a node in the network, as the number of its connections to other nodes.
    public void computeImportance() {
        Collections.sort(nodes, new Network());
    }

    //Create a network object containing persons, companies and relationships and print it on the screen.
    @Override
    public String toString() {
        return "Network{" +
                "nodes=\n" + nodes +
                "\n}";
    }

    //Transfer the adjacency list from all the nodes in a network to connectionsPerNode HashMap
    public void addToConnectionsPerNodeList(Node node) {
        if (!connectionsPerNode.containsKey(node.getName()))
            connectionsPerNode.put(node.getName(), node.getRelationships().get(node.getName()));
    }

    public List<String> runTarjansAlgorithm() {
        for (String vertex : connectionsPerNode.keySet()) {
            if (!visitedVertices.containsKey(vertex)) {
                DFSAlgorithm(vertex);
            }
        }
        return articulationPoints;//From DFSAlgorithm
    }

    private void DFSAlgorithm(String node) {
        visitedVertices.put(node, true);//The current node is visited
        depth.put(node, currentDepth);//The Discovery time of the node, also called the depth ot the node
        lowpoint.put(node, currentDepth);//The minimum between discoveryTime(node) and discoveryTime(parent), the minimum index of the vertex reachable from the node
        currentDepth++;//discovery time

        int childCount = 0; //Count the children in DFS tree
        boolean isArticulationPoint = false;

        for (String adjacentVertex : connectionsPerNode.get(node)) {
            //If the adjacentVertex haven't been visited, we mark it as parent's child
            if (!visitedVertices.containsKey(adjacentVertex)) {
                parent.put(adjacentVertex, node);
                childCount++;
                DFSAlgorithm(adjacentVertex);
                //Check if there is a back edge to one of the node's ancestors
                lowpoint.put(node, Math.min(lowpoint.get(node), lowpoint.get(adjacentVertex)));
                //If low value of one of node's children <= than node's discoveryTime
                if (depth.get(node) <= lowpoint.get(adjacentVertex)) {
                    isArticulationPoint = true;
                }
                //  Update low value of the node when it is not a parent.
            } else if (!adjacentVertex.equals(parent.get(node))) {
                lowpoint.put(node, Math.min(lowpoint.get(node), depth.get(adjacentVertex)));
            }
        }
        if ((parent.containsKey(node) && isArticulationPoint) || (parent.get(node) == null && childCount > 1)) {
            articulationPoints.add(node);
        }
    }

}
