
package org.nc.entitybeans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="expense_details")
public class ExpensiveDetails
{
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, length=11)
	private int id;
	
	@Column(name="expense_master_id", nullable=false, length=11)
	private int expense_master_id; 
	
	@Column(name="date_of_event", nullable=true, length=255)
	private String date_of_event;
	
	@Column(name="description", nullable=true, length=1000)
	private String description;
	
	@Column(name="amount", nullable=true, length=255)
	private String amount;
	
	@Column(name="total_expense_price", nullable=true, length=20)
	private long total_expense_price;

	@Column(name="is_manager_approval", nullable=true, length=255)
	private String is_manager_approval;
	
	@Column(name="is_cfo_approval", nullable=true, length=255)
	private String is_cfo_approval;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getExpense_master_id() {
		return expense_master_id;
	}

	public void setExpense_master_id(int expense_master_id) {
		this.expense_master_id = expense_master_id;
	}

	public String getDate_of_event() {
		return date_of_event;
	}

	public void setDate_of_event(String date_of_event) {
		this.date_of_event = date_of_event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public long getTotal_expense_price() {
		return total_expense_price;
	}

	public void setTotal_expense_price(long total_expense_price) {
		this.total_expense_price = total_expense_price;
	}

	public String getIs_manager_approval() {
		return is_manager_approval;
	}

	public void setIs_manager_approval(String is_manager_approval) {
		this.is_manager_approval = is_manager_approval;
	}

	public String getIs_cfo_approval() {
		return is_cfo_approval;
	}

	public void setIs_cfo_approval(String is_cfo_approval) {
		this.is_cfo_approval = is_cfo_approval;
	}
	
	
	
}