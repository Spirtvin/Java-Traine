package Main;

import Evklid.EuclidAdv;
import Helpers.IO;

//TODO:проверить на ошибки Hill - DecryptFunction

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
            IO<Integer> io = new IO();
            //GlobalTests.Encryption();
            //GlobalTests.Matrix();

            EuclidAdv euclidAdv = new EuclidAdv();
            //System.out.println(euclidAdv.GCD(180,150));
            //io.Print(euclidAdv.GCD(180,150));
            //GlobalTests.Matrix();
            GlobalTests.Encryption();
        } catch (Exception ex) {
            IO<Exception> io = new IO();
            io.Print(ex);
        }
    }
}

