package ru.aston.step1.homework.module3.decorator;

abstract public class OptionalEquipment  implements Component{
    protected final Component model;

    public OptionalEquipment(Component model) {
        this.model = model;
    }
}
