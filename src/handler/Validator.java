package handler;

public class Validator {
    public static boolean checkNumber(String docNumber) {
        if (docNumber.length() != 15) {
            return false;
        }
        return docNumber.startsWith("docnum") || docNumber.startsWith("kontract");
    }
}
