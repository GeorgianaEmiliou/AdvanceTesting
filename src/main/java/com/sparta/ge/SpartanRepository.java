package com.sparta.ge;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;


public class SpartanRepository {
    private static final ArrayList<Spartan> spartans = new ArrayList<>();

    public static void addSpartan(Spartan spartan) {
        spartans.add(spartan);
    }

    public static Optional<Spartan> findSpartan(int id) {
        Spartan returnedSpartan = null;
        for (Spartan spartan : spartans) {
            if (spartan.getId() == id) {
                returnedSpartan = spartan;
            }
        }
        return Optional.ofNullable(returnedSpartan);
    }


    public static String getAllSpartans() {
        StringBuilder SpartansInArray = new StringBuilder();
        for (Spartan spartan : spartans) {
            SpartansInArray.append(spartan.toString()).append("\n");
        }
        return SpartansInArray.toString();
    }


    public static boolean removeSpartan(int id) {
        return spartans.removeIf(spartan -> spartan.getId() == id);
    }


    public static void main(String[] args) {
        addSpartan(new Spartan(1, "Manish", "Java", LocalDate.of(2022, 10, 10)));
        addSpartan(new Spartan(2, "Stephen", "Java", LocalDate.of(2022, 10, 10)));
        addSpartan(new Spartan(3, "David", "Java", LocalDate.of(2022, 10, 10)));
        addSpartan(new Spartan(4, "Danny", "Java", LocalDate.of(2022, 10, 10)));

        /*if(findSpartan(3).isPresent()){ //if (something != null)
            System.out.println(findSpartan(3).get().getName());
        }*/

    }
}
