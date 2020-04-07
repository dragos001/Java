import  java.util.ArrayList;
public class DFS {
    static ArrayList<Node> nodes = new ArrayList<>();

    static class Node {
        int data;
        boolean visited;


        Node(int data) {
            this.data = data;
        }
    }
    public ArrayList<Node> findNeighbours(boolean matrix[][], Node x){

        int nodeIndex = -1;
        ArrayList<Node> neighbours = new ArrayList<>();

        for(int i = 0; i < nodes.size(); i++){
            if(nodes.get(i).equals(x)){
                nodeIndex = i;
            }
        }
        if(nodeIndex != -1){
            for(int j = 0; j< matrix[nodeIndex].length; j++){
                if(matrix[nodeIndex][j] == true){
                    neighbours.add(nodes.get(j));
                }
            }
        }
        return neighbours;
    }
    public void  depthFirstSearch(boolean matrix[][], Node node){
        System.out.println(node.data + "\t");
        ArrayList<Node> neighbours = findNeighbours(matrix, node);
        for(int i = 0; i<neighbours.size(); i++){
            Node n = neighbours.get(i);
            if(n != null && !n.visited){
                n.visited = true;
            }
        }
    }
    public static void clearVisitedFlags() {
        for(int i = 0; i < nodes.size(); i++ ){
            nodes.get(i).visited = false;
        }
    }

}
