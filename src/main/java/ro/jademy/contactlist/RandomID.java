package ro.jademy.contactlist;

import java.util.Random;

public class RandomID {
    public static Integer generateId() {
        Random rand = new Random();
        int low = 0;
        int high = 100;
        int result =rand.nextInt(high-low) + low ;

        return result;
    }
}
