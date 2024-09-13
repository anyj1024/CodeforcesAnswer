import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Map<Object, Integer> map = new HashMap<>();
        map.put(null, -1);
        map.put(-1, null);
        System.out.println(map.get(-1));

    }
}

