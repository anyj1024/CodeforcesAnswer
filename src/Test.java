import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        int n = 10;
        int sLen = Integer.toBinaryString(n).length() - 1;
        System.out.println((1 << sLen) - 1);
    }
}
