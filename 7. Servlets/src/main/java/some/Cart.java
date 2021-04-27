/**
 * Класс Cart имитирует корзину в интернет магазине,
 * для демонстрации метода forward() в классе ForwardServlet.
 * Связан с файлом showCart.jsp
 */
package some;

public class Cart {
    private String name;
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
