public class person {
    public enum AccountType {
    ADMIN,
    GUEST,
    RECEPTION
}
    private String name;
    private String email;
    private String phone;
    private AccountType accountType;

    public person(String name, String email, String phone, AccountType accountType) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accountType = accountType;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}