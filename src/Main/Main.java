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

            //GlobalTests.Encryptions.Feistel();
            GlobalTests.Encryptions.Binary();
            //GlobalTests.Encryptions.DES();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

