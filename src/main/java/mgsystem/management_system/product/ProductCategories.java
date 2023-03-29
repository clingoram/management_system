package mgsystem.management_system.product;

public enum ProductCategories {
    EGGCAKE(2,"蛋餅"),
    HAMBERGER(1,"漢堡");


    private final int displayValue;
    private final String displayName;

    private ProductCategories(int displayValue,String displayName) {
        this.displayValue = displayValue;
        this.displayName = displayName;
    }

    public int getDisplayValue() {
        return displayValue;
    }
    public String getDisplayName(){
        return displayName;
    }
    @Override public String toString() {
        return displayName;
    }
}
