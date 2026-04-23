package ru.aston.step1.homework.module3.decorator;

public class ModelClassA extends OptionalEquipment{
    public ModelClassA(Component model) {
        super(model);
    }

    @Override
    public String getDescription() {
        return model.getDescription() + " + дополнения класса А";
    }
}
