/*
* @author Evan Timmons
*/

class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        
        int gridLength = grid.length;
            
        int[] tallestX = new int[gridLength];
        int[] tallestY = new int[gridLength];
        int currentHeight = 0;
        int maxHeight = 0;
        int totalHeightChange = 0;
        
        // Iterates through the 2d array to set highest buildings in the x and y direction
        for(int x = 0; x < gridLength; x++){
            for(int y = 0; y < gridLength; y++){
                currentHeight = grid[x][y];
                
                //  Sets the height for the newest tallest X building
                if(currentHeight > tallestX[x]){
                    tallestX[x] = currentHeight;
                }
                
                //  Sets the height for the newest tallest Y building
                if(currentHeight > tallestY[y]){
                    tallestY[y] = currentHeight;
                }
            }
        }
        
        // Iterates through the 2d array to compute max height change for buildings
        for(int x = 0; x < gridLength; x++){
            for(int y = 0; y < gridLength; y++){
                currentHeight = grid[x][y];
                
                // Finds the shorter of the x and y skyline buildings for the given coordinates
                if(tallestX[x] < tallestY[y]){
                    maxHeight = tallestX[x];
                }
                else{
                    maxHeight = tallestY[y];
                }
                
                // Adds the change in height to the height counter
                totalHeightChange += maxHeight - currentHeight;
            }
        }
        
        return totalHeightChange;
        
    }
}