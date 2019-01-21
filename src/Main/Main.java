package Main;

import Helpers.IO;
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
            IO<Exception> io = new IO();
            io.Print(ex);
        }


    }
}

