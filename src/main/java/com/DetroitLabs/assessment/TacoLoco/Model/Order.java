/**
 * 
 */
package com.DetroitLabs.assessment.TacoLoco.Model;

import javax.validation.constraints.Min;

/**
 * @author kavyamahakala
 *
 */
public class Order {
	@Min(value=0, message="Item count should be 0 or more")
	private final int veggieTacoCount;
	
	@Min(value=0, message="Item count should be 0 or more")
	private final int chickenTacoCount;
	
	@Min(value=0, message="Item count should be 0 or more")
	private final int beefTacoCount;
	
	@Min(value=0, message="Item count should be 0 or more")
	private final int chorizoTacoCount;
	
	public final int totalItemsOrdered;
	
	public final int veggieTacoPrice = 250;
	public final int chickenTacoPrice = 300;
	public final int beefTacePrice = 300;
	public final int chorizoTacoPrice = 350;
	
	public Order(int veggieTacoCount, int chickenTacoCount, int beefTacoCount, int chorizoTacoCount) {
		this.veggieTacoCount = veggieTacoCount;
		this.chickenTacoCount = chickenTacoCount;
		this.beefTacoCount = beefTacoCount;
		this.chorizoTacoCount = chorizoTacoCount;
		this.totalItemsOrdered = this.getVeggieTacoCount() + this.getChickenTacoCount() + this.getBeefTacoCount() + this.getChorizoTacoCount();
	}

	/**
	 * @return the veggieTacoCount
	 */
	public int getVeggieTacoCount() {
		return veggieTacoCount;
	}

	/**
	 * @return the chickenTacoCount
	 */
	public int getChickenTacoCount() {
		return chickenTacoCount;
	}

	/**
	 * @return the beefTacoCount
	 */
	public int getBeefTacoCount() {
		return beefTacoCount;
	}

	/**
	 * @return the chorizoTacoCount
	 */
	public int getChorizoTacoCount() {
		return chorizoTacoCount;
	}
}
