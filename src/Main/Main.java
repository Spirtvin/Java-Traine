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
            //GlobalTests.Encryptions.DES();
            //GlobalTests.Encryptions.Feistel();
            //TODO: в 56 битном ключе добавить биты контроля четности!!!!!!
            //TODO: добавить в Binary проверку на четность
            GlobalTests.Encryptions.Binary();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

