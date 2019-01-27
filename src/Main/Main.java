package Main;

import Tests.GlobalTests;


/**
 * точка входа
 */
public class Main {


    /**
     * точка входа
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            GlobalTests.Encryptions.PBlock();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

