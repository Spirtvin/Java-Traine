package DataStructures.Stack.Dynamic;

import DataStructures.DataStructure;
import DataStructures.Test;

import java.util.ArrayList;

public class Tests extends DataStructures.Stack.Static.Tests {

    //<editor-fold desc="Constructors">
    public Tests(DataStructure _structure) {
        super(_structure);
    }
    //</editor-fold>

    //<editor-fold desc="Methods">

    /**
     * Проверка на то что не полный
     *
     * @return
     */
    @Override
    public boolean IsFull() {
        try{
            structure.IsFull();
            return false;
        }
        catch (Exception ex){
            return ex.getClass() == UnsupportedOperationException.class;
        }
    }
    //</editor-fold>
}
