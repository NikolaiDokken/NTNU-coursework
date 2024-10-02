public class Test {
    public static void main(String[] args) {
        Bok harryPotter = new Bok("07-202-34820-H", "Harry Potter", "JK Rowling");
        Database db = new Database();

        if (db.regNyBok(harryPotter)) System.out.println("Test 1 vellykket");

        if (db.regNyttEksemplar("0-201-50998-X") == 2) System.out.println("Test 2 vellykket");

        if (db.regNyttEksemplar("99-898-23423-R") == 0) System.out.println("Test 3 vellykket");

        if (!db.lånUtEksemplar("64-546-45637567-C", "Geir Ove", 4)) System.out.println("Test 4 vellykket");

        if (db.lånUtEksemplar("0-201-50998-X", "Nikolai Dokken", 2)) System.out.println("Test 5 vellykket");
    }
}
