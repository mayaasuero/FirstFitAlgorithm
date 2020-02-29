/**
 * TITLE: FFGraphColoring
 * DESCRIPTION: This class implements a graph coloring algorithm following first fit.
 */
import java.io.File;
import java.util.Scanner;
public class FFGraphColoring {
    public static void main(String[]args){
        ReadFromDatabase rfd = new ReadFromDatabase();
        for(int i = 0; i < rfd.getFilesSize(); i++){
            Graph graph = rfd.readFile(i);
            if(graph == null){
                break;
            }
            FirstFit ff = new FirstFit(graph);
            ff.solve();
            //graph.printGraph(graph);
            //graph.printSolution();
            System.out.println("Minimum number of Colors: " + graph.getMaxColors());
        }
    }
}
