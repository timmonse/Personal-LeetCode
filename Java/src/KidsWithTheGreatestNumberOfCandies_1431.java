import java.util.ArrayList;
import java.util.List;

class KidsWithTheGreatestNumberOfCandies_1431 {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

    ArrayList<Boolean> booleanList = new ArrayList<>();
    int max = 0;
    for (int candy : candies) {
      if(candy > max) {
        max = candy;
      }
    }

    for (int candy : candies) {
      booleanList.add(candy + extraCandies >= max);
    } 

    return booleanList;
  }
}
