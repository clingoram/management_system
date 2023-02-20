package mgsystem.management_system.error;

public class HandleError {

    /**
     * Inputs 輸入框內值錯誤
     * @throws ArithmeticException
     */
    public static void throwInputsError() throws ArithmeticException {
        System.out.println("Input值錯誤");
        // 程式處理過程假設發生例外
        throw new ArithmeticException();
    }

    /**
     * 資料庫內沒有欲搜尋的ID
     * @throws ArithmeticException
     */
    public static void throwIdError() throws ArithmeticException {
        System.out.println("ID錯誤");
        throw new ArithmeticException();
    }

}
