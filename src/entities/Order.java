package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private LocalDateTime now;
	private OrderStatus status;
	
	private Client client;
	List<OrderItem> items = new ArrayList<>();
	
	public Order(LocalDateTime localDateTime, OrderStatus status, Client client) {
		super();
		this.now = localDateTime;
		this.status = status;
		this.client = client;
	}
	

	public LocalDateTime getNow() {
		return now;
	}


	public void setNow(LocalDateTime now) {
		this.now = now;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public List<OrderItem> getItems() {
		return items;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	} 
	
	public double total() {
		double tot = 0;
		for (OrderItem i: items) {
			tot += i.subTotal();
		}
		return tot; 
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(now.format(fmt) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items: " + "\n");
		for (OrderItem i: items) {
			sb.append(i + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f%n", total()));
		return sb.toString();
	}
	
}
