package tests;/*
Сделайте сценарий для добавления товаров в корзину и удаления товаров из корзины.
Сценарий должен состоять из следующих частей:
1) открыть страницу какого-нибудь товара
2) добавить его в корзину
3) подождать, пока счётчик товаров в корзине обновится
4) вернуться на главную страницу, повторить предыдущие шаги ещё два раза, чтобы в общей сложности в корзине было 3 единицы товара
5) открыть корзину (в правом верхнем углу кликнуть по ссылке Checkout)
6) удалить все товары из корзины один за другим, после каждого удаления подождать, пока внизу обновится таблица
*/

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AddProductAndDelete extends TestBase {

  @Test
  public void test() {
    int productCount = 3;
    app.addProductsToCart(productCount);
    app.goToCart();
    app.deleteProductsFromCart(productCount);
    String check = app.getTextEmptyCart();

    assertTrue(check.equals("There are no items in your cart."));
  }

}
