package exception;

public class ShowException {
    public static void showNotice(Exception e) {
        System.out.println("Исключение: " + e);
    }

    public static void companyNotFound(Exception e) {
        System.out.println("Компания не найдена \nИсключение: " + e);
    }
}
