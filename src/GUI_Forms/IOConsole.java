package GUI_Forms;

import Interfaces.IO;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * упрощает ввод/вывод информации
 */
public class IOConsole implements IO {

    /**
     * считать данные из контрола на форме
     *
     * @param component элемент управления на форме
     * @return
     */
    @Override
    public Object In(JComponent component) {
        throw new NotImplementedException();
    }

    /**
     * считать данные из консоли
     *
     * @param message инструкция по вводу
     * @return
     */
    @Override
    public Object In(String message) {
        if (message.length() > 0)
            Out(message, "");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * вывести данные в элемент на форме
     *
     * @param object    объект для вывода
     * @param component элемент на форме
     */
    @Override
    public void Out(Object object, JComponent component) {
        throw new NotImplementedException();
    }

    /**
     * вывести данные в консоль
     *
     * @param object  объект для вывода
     * @param message подпись(выводится над объектом)
     */
    @Override
    public void Out(Object object, String message) {
        if (message.length() > 0)
            System.out.println(message);
        if (object != null) {
            if (object.getClass().isArray()) {
                Object[] list = (Object[]) object;
                for (int i = 0; i < list.length; i++)
                    Out(list[i], "");
            } else if (object instanceof List<?>) {
                ArrayList<Object> list = (ArrayList) object;
                for (int i = 0; i < list.size(); i++)
                    Out(list.get(i), "");
            } else {
                System.out.println(object);
            }
        }
    }
}
