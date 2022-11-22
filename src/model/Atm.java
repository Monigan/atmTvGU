package model;

public class Atm {
    private final String name;
    private boolean isEnabled;
    private boolean isOnline;

    private boolean hasCard;

    public Atm(String name) {
        this.name = name;
        this.isOnline = true;
        this.isEnabled = true;
        this.hasCard = false;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean isHasCard() {
        return hasCard;
    }

    public void setHasCard(boolean hasCard) {
        this.hasCard = hasCard;
    }
}
