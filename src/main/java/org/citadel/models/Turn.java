package org.citadel.models;

public class Turn implements Cloneable {

    private int value = 0;

    public Player getPlayer() {
        return Player.values()[value];
    }

    public void change() {
        this.value = (value + 1) % (Player.values().length - 1);
    }

    @Override
    public Turn clone() {
        try {
            return (Turn) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
