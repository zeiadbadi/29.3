public class dijkstra {

    int find_min(int dist_arr[], boolean[] included, int no_of_nodes){

        int minm = Integer.MAX_VALUE,min_idx = -1;

        for(int i =0; i<no_of_nodes; i++){

            if(dist_arr[i]<= minm && included[i] == false){

                minm = dist_arr[i];
                min_idx =i;
            }
        }

        return min_idx;


    }

    void print_sol(int dist_arr[], int n){

        System.out.println("Vertex no." + "\tDistance from source: ");

        for(int i=0; i<n; i++){

            System.out.println(i + "\t\t\t" + dist_arr[i]);
        }
    }

    void find_shortest_path(int[][] graph, int root, int no_of_nodes){

        int[] dist_arr = new int [ no_of_nodes];

        boolean[] included = new boolean[no_of_nodes];

        for(int i=0;i<no_of_nodes; i++){
            dist_arr[i] = Integer.MAX_VALUE;
            included[i] = false;

        }

        dist_arr[root] = 0;

        for(int i=0;i<no_of_nodes; i++){

            int min_dist_vertex = find_min(dist_arr, included, no_of_nodes);
            included[i]= true;

            for(int j=0;j<no_of_nodes; j++){

                if(!included[j] && graph[i][j] != 0 && dist_arr[i]!=Integer.MAX_VALUE && dist_arr[i] + graph[i][j]<dist_arr[j]){

                    dist_arr[j] = dist_arr[i]+ graph[i][j];
                }
            }
        }

        print_sol(dist_arr, no_of_nodes);
    }

    public static void main(String[] args){

        int graph[][] = new int[][]{

                {0,5,0,0,1},
                {5,0,4,1,3},
                {0,4,0,2,1},
                {0,1,2,0,6},
                {1,3,0,6,1}
        };


        dijkstra path = new dijkstra();

        path.find_shortest_path(graph,0,5);


    }
}
