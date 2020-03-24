public class Store {
    public void __Test(String product, int SellIn){
      
      // get product quality
      Dict Quality = self.Quality[product]
      
      assert Quality[SellIn] <= 50
      assert Quality[SellIn] >= 0

      if (product == "Aged Brie") {
        assert Quality[SellIn] > Quality[SellIn+1]
      } else if (product == "Sulfuras") {
        assert Quality[SellIn] == Quality[SellIn+1]
      } else if (product == "Backstage pass") { 
	      if (SellIn < 0) { 
          assert Quality[SellIn] == 0
        } else if (SellIn < 5) {
          assert Quality[SellIn] == Quality[SellIn+1] + 3 
	      } else if (SellIn < 10) {
          assert Quality[SellIn] == Quality[SellIn+1] + 2
	      } else { Quality[SellIn] == Quality[SellIn+1] }
      } else {
        if (SellIn < 0) {  // 价值双倍下降
          assert Quality[SellIn] == Quality[SellIn+1] / 2
        }
      }
    }
}
