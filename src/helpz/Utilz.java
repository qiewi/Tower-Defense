package helpz;

import java.util.ArrayList;

public class Utilz {

    public static int[][] ArrayListTo2Dint(ArrayList<Integer> list, int ySize, int xSize){
        int[][] newArr = new int[ySize][xSize];

        for (int y = 0; y < newArr.length; y++) {
            for (int x = 0; x < newArr[y].length; x++) {
                int index = y * ySize + x;
                newArr[y][x] = list.get(index);
            }
        }
        return newArr;
    }
    
    public static int[] TwoDto1Dint(int[][] twoArr) {
        int[] oneArr = new int[twoArr.length * twoArr[0].length];
        
        for (int y = 0; y < twoArr.length; y++) {
            for (int x = 0; x < twoArr[y].length; x++) {
                int index = y * twoArr.length + x;
                oneArr[index] = twoArr[y][x];
            }
        }
        return oneArr;
    }
}
