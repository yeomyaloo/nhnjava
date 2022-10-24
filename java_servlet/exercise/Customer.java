package exercise;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    public Customer(BuyList buyList) {
        this.buyList = buyList;
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    public void pickFoods(FoodStand foodStand) {
        //입력받은 값들 -> buylist에 저장 해당 size만큼 for문을 돌며 가져온다.

        for (int i = 0 ; i > buyList.getItems().size(); i++){
            for(buyList.getItems().get(i)){
                foodStand.getFood(String.valueOf(buyList.getItems().get(1)));
            }


        }



    }


    public void payTox(Object counter) {



    }
}
