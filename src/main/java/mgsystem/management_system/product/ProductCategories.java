package mgsystem.management_system.product;

public enum ProductCategories {
    EGGCAKE("蛋餅"),
    HAMBERGER("漢堡");

    private final String displayValue;

    private ProductCategories(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
