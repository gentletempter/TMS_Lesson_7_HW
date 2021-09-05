package handler;

public class Validator {
    public static String checkNumber(String docNumber) {
        if (docNumber.length() != 15) {
            return " -->>Document number length does not consist of 15 characters";
        }
        if (!docNumber.startsWith("docnum") && !docNumber.startsWith("kontract")) {
            return " -->>The document number does not starts with \"docnum\" or \"kontract\"";
        }
        return null;
    }
}
