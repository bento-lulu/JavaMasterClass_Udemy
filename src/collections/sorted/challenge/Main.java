package collections.sorted.challenge;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
	    StockItem temp = new StockItem( "laranja", 50.00, 10 );
        stockList.addStock(temp);

        temp = new StockItem( "banana", 20, 10 );
        stockList.addStock(temp);

        temp = new StockItem( "morango", 75.00, 10 );
        stockList.addStock(temp);

        temp = new StockItem("maca", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("goiaba", 25.00 , 10);
        stockList.addStock(temp);

        System.out.println(stockList);
/*
        for(String s: stockList.Items().keySet()) {
            System.out.println(s);
        }
*/

        Basket timsBasket = new Basket("Tim");
        reserve(timsBasket, "banana", 5);
        reserve(timsBasket, "banana", 5);
        reserve(timsBasket, "spanner", 5);
        reserve(timsBasket, "laranja", 5);
        reserve(timsBasket, "morango", 12);
        reserve(timsBasket, "goiaba", 5);
        System.out.println(timsBasket);
        
        Basket benBasket = new Basket("Ben");
        reserve(benBasket, "banana", 5);
        reserve(benBasket, "laranja", 5);
        System.out.println(benBasket);
        
        unreserve(timsBasket, "laranja", 5);
        System.out.println(timsBasket);
        
        reserve(benBasket, "banana", 5);
        reserve(benBasket, "laranja", 5);
        System.out.println(benBasket);
        
        System.out.println(stockList);
        System.out.println(timsBasket);
        System.out.println(benBasket);
        
        checkOut(timsBasket);
        checkOut(benBasket);
        
        System.out.println(stockList);
        System.out.println(timsBasket);
        System.out.println(benBasket);
        
    }

    public static int reserve(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if ( stockItem.reserve( quantity ) == 0 ) {
        	System.out.println("Nao temos stock suficiente para reservar " +quantity+ " " +item);
        	return 0;
        }
        basket.addToBasket(stockItem, quantity);
        return quantity;
    }
    
    public static int unreserve(Basket basket, String item, int quantity) {
    	StockItem stockItem = stockList.get(item);
    	if (stockItem == null ) {
    		System.out.println("We don't sell " + item);
    		return 0;
    	}
    	if ( !basket.Items().containsKey(stockItem) ) {
    		System.out.println("Nao tem este producto no basket");
    		return 0;
    	}
    	if ( ((basket.Items().get(stockItem)-quantity) < 0) ) {
    		System.out.println("Nao tem esta quantidade toda no basket para devolver");
    		return 0;
    	}
    	if ( stockItem.unreserve(quantity) == 0 ) {
    		System.out.println("Nao tem esta quantidade de " +item+ " reservados na loja");
    		return 0;
    	}
    	basket.removeFromBasket(stockItem, quantity);//vai remover se a quantidade for zero
    	return quantity;
    }

    public static void checkOut( Basket basket ) {
    	if ( basket!=null ) {
    		for ( Map.Entry<StockItem, Integer> item : basket.Items().entrySet() ) {
    			sellItem(basket, item.getKey().getName(), item.getValue());
    		}
    		basket.emptyBasket();
    	}
    }
    
    public static int sellItem(Basket basket, String item, int quantity) {
        //retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if(stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.sellStock(item, quantity) != 0) {
            return quantity;
        }
        return 0;
    }
}
