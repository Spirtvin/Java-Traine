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
            //TODO: проверить EncryptFunction
            //TODO: проверить почеу ключ состоит из нулей
            //TODO: проверить работу S блока
            GlobalTests.Encryptions.DES();
            //GlobalTests.Encryptions.Feistel();
            //GlobalTests.Encryptions.Binary();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

