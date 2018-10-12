package DataStructures.Stack.Static;

import DataStructures.DataStructure;
import DataStructures.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Tests extends Test {

    //<editor-fold desc="Constructors">
    public Tests(DataStructure _structure) {
        super(_structure);
    }

    Tests() {
    }
    //</editor-fold>

    //<editor-fold desc="Methods">

    /**
     * @return
     */
    @Override
    public boolean PushFront() {
        try {
            structure.PushFront(1);
            return false;
        } catch (Exception ex) {
            return ex.getClass() == UnsupportedOperationException.class;
        }
    }

    /**
     * @return
     */
    @Override
    public boolean PushBack() {
        int count = 10;
        ArrayList<Integer> testItems = GetAsc(count - 1);
        for (Integer item : testItems)
            structure.PushBack(item);
        return structure.items.size() == count;
    }

    /**
     * @return
     */
    @Override
    public boolean PopFront() {
        try {
            structure.PopFront();
            return false;
        } catch (Exception ex) {
           return  ex.getClass() == (new UnsupportedOperationException()).getClass();
        }
    }

    /**
     * @return
     */
    @Override
    public boolean PopBack() {
        try{
            structure.items.clear();
            structure.PushBack(1);
            int result= (int)structure.PopBack();
            return  structure.items.size()==0 && result==1;
        }
        catch (Exception ex){
            return false;
        }
    }

    /**
     * @return
     */
    @Override
    public boolean IsEmpty() {
        structure.Clear();
        return structure.IsEmpty()==true;
    }

    /**
     * Проверка на то что не полный
     *
     * @return
     */
    @Override
    public boolean IsFull() {
        structure.Clear();
        int count = 10;
        ArrayList<Integer> testItems = GetAsc(count - 1);
        for (Integer item : testItems)
            structure.PushBack(item);
        return structure.IsFull()==true;
    }

    /**
     * @return
     */
    @Override
    public boolean Clear() {
        structure.items.clear();
        structure.PushBack(1);
        structure.PushBack(2);
        structure.Clear();
        return structure.items.size()==0;
    }

    /**
     * проеврка поиска в структуре
     *
     * @return
     */
    @Override
    public boolean Search() {
        structure.Clear();
        structure.PushBack(-999);
        structure.PushBack(1);
        structure.PushBack(-1);
        return structure.Search(-999)==true;
    }
    //</editor-fold>
}
