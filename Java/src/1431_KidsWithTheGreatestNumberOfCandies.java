class Solution {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    ArrayList<Boolean> booleanList = new ArrayList<>();
    int max = 0;
    for (int candy : candies) {
      if(candy > max) {
        max = candy;
      }
    }

    for (int candy : candies) {
      if(candy + extraCandies >= max){
        booleanList.add(true);
      }
      else{
        booleanList.add(false);
      }
    } 

    return booleanList;
  }
}
