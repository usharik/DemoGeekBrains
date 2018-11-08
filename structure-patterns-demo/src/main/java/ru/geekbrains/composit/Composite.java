package ru.geekbrains.composit;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Operation {

    List<Operation> operations = new ArrayList<>();

    public void addOperation(Operation op) {
        operations.add(op);
    }

    @Override
    public void perform() {
        for (Operation op : operations) {
            op.perform();
        }
    }
}
