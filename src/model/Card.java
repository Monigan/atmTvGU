package model;

public class Card {
    private final long number;
    private final String cardHolder;
    private final String date;
    private final int code;
    private int pinCode;
    private final Money moneyValue;

    /**
     * Создаем новую карточку, где:
     *
     * @param number     - номер карточки
     * @param cardHolder - имя держатетля карты
     * @param date       - месяц и год оканчания поддержки карты
     * @param code       - секретный код
     * @param region     - в каких денежных единицах хранятся деньги (рубли, евро, доллары)
     * @param pinCode    - пин-код карты
     */
    public Card(Long number, String cardHolder, String date, int code, int pinCode, String region) {
        this.number = number;
        this.cardHolder = cardHolder;
        this.date = date;
        this.code = code;
        this.pinCode = pinCode;
        this.moneyValue = new Money(region);
    }

    public long getNumber() {
        return number;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getDate() {
        return date;
    }

    public int getCode() {
        return code;
    }

    public double getMoneyValue() {
        return moneyValue.getValue();
    }

    public void setMoneyValue(double value) {
        moneyValue.setValue(value);
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getPinCode() {
        return pinCode;
    }
}
