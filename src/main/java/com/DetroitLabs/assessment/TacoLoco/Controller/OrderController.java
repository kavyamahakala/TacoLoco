/**
 * 
 */
package com.DetroitLabs.assessment.TacoLoco.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DetroitLabs.assessment.TacoLoco.Model.Bill;
import com.DetroitLabs.assessment.TacoLoco.Model.Order;

/**
 * @author kavyamahakala
 *
 */
@RestController
public class OrderController {
	
	private final int itemNeededForDiscount = 4;

	private Bill calculateBill(Order order) {
		double totalBillInCents = order.getVeggieTacoCount() * order.veggieTacoPrice + order.getChickenTacoCount() * order.chickenTacoPrice + order.getBeefTacoCount() * order.beefTacePrice + order.getChorizoTacoCount() * order.chorizoTacoPrice;
		
		if(order.totalItemsOrdered >= itemNeededForDiscount) {
			totalBillInCents -= totalBillInCents * 0.2;
		}
				
		return new Bill(totalBillInCents/100);
	}
	
	@PostMapping(path = "/placeOrder")
	public @ResponseBody Bill calculateOrderTotal(@Valid @RequestBody Order order) {
		return calculateBill(order);
	}
	
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ex.getMessage();
    }
}
