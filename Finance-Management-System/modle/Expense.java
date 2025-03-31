//Expense class representing individual expenses

public class Expense {
    private int expenseId;
    private int userId;
    private BigDecimal amount;
    private int categoryId;
    private ExpenseCategory category;
    private Date date;
    private String description;
    
    public Expense() {}
    
    public Expense(int expenseId, int userId, BigDecimal amount, int categoryId, Date date, String description) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.amount = amount;
        this.categoryId = categoryId;
        this.date = date;
        this.description = description;
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
        this.categoryId = category.getCategoryId();
    }
    
    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", amount=" + amount +
                ", category=" + (category != null ? category.getCategoryName() : "categoryId=" + categoryId) +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }
}