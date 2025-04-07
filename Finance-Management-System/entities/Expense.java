import java.math.*;
import java.sql.Date;


//Expense class representing individual expenses

public class Expense {
    private int expenseId;
    private int userId;
    private BigDecimal amount;
    private int categoryId;
    private ExpenseCategory category;
    private Date expense_date;
    private String expense_description;
    
    public Expense() {}
    
    public Expense(int expenseId, int userId, BigDecimal amount, int categoryId, Date expense_date, String expense_description) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.categoryId = categoryId;
        this.expense_date = expense_date;
        this.expense_description = expense_description;
    }
    
    // Getters and setters
    public int getExpenseId() { return expenseId; }
    public void setExpenseId(int expenseId) { this.expenseId = expenseId; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    
    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }
    
    public ExpenseCategory getCategory() { return category; }
    public void setCategory(ExpenseCategory category) { 
        this.category = category;
    }
    
    public Date getExpense_date() { return expense_date; }
    public void setExpense_date(Date date) { this.expense_date = date; }
    
    public String getExpense_description() { return expense_description; }
    public void setExpense_description(String description) { this.expense_description = description; }
    
    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", amount=" + amount +
                ", category=" + category +
                ", categoryId=" + categoryId +
                ", date=" + expense_date +
                ", description='" + expense_description + '\'' +
                '}';
    }
}