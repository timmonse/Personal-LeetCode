/*
* @author Evan Timmons
* 10-1-2018
*/

class Solution {
    public String toLowerCase(String str) {
        // Simple built in solution
        //str = str.toLowerCase();
        
        int conversionFactor = 'a' - 'A';
        
        String lowerStr = new String();
        
        // Iterate through the string
        for(int i = 0; i < str.length(); i++){
            // Checks if the char is uppercase
            if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
                // Adds the new lower case character to lowerStr
                lowerStr += (char)(str.charAt(i) + conversionFactor);
            }
            else{
                // Adds the original lower case character to lowerStr
                lowerStr += str.charAt(i);
            }
        }
        
        return lowerStr;
    }
}