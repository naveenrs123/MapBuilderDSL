package Helpers;

import java.util.ArrayList;

public class ExecutionOrderContext {

    private final StatementListEnum arrayList;
    private final int index;

    public ExecutionOrderContext(StatementListEnum arrayList, int index) {
        this.arrayList = arrayList;
        this.index = index;
    }

    public StatementListEnum getArrayList() {
        return arrayList;
    }

    public int getIndex() {
        return index;
    }
}
