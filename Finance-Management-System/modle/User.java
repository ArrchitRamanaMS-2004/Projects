import java.math.*;
import java.sql.*;
import java.util.*;

// User class representing a system user
public class User {
    private int userId;
    private String username;
    private String password;
    private String email;
    private List<Expense> expenses;
    
    public User() {
        this.expenses = new ArrayList<>();
    }
    
    public User(int userId, String username, String password, String email) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.expenses = new ArrayList<>();
    }
    
    // Getters and setters
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    public List<Expense> getExpenses() { return expenses; }
    public void setExpenses(List<Expense> expenses) { this.expenses = expenses; }
    
    public void addExpense(Expense expense) {
        this.expenses.add(expense);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
