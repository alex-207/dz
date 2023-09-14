import java.io.FileWriter;
import java.io.IOException;

public class CreateOrder {

    public void inputFromConsole(){
        order.setClientName(scaner.prompt("Client name: "));
        order.setProduct(scaner.prompt("Product: "));
        order.setQnt(Integer.parseInt(scaner.prompt("Quantity: ")));
        order.setPrice(Integer.parseInt(scaner.prompt("Price: ")));
        
    }

    public void toTxt() {
        String fileName = "myOrder.txt";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void toJson() {
        String fileName = "myOrder.json";
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write("{\n");
            writer.write("\"clientName\":\"" + order.getClientName() + "\",\n");
            writer.write("\"product\":\"" + order.getProduct() + "\",\n");
            writer.write("\"qnt\":" + order.getQnt() + ",\n");
            writer.write("\"price\":" + order.getPrice() + "\n");
            writer.write("}\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    Scaner scaner = new Scaner();
    Order order = new Order();
}
