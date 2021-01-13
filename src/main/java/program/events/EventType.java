package program.events;

public enum EventType {
    NEW_CUSTOMER,
    PRICE_FALL,
    ADMISSION,
    DELETE_EXP,
    MOVE_TO_SHOP,
    SERVE_CUSTOMER;

    @Override
    public String toString() {
        if (this.name().equals("NEW_CUSTOMER")) {
            return "Новый посетитель";
        }
        if (this.name().equals("PRICE_FALL")) {
            return "Снижение цен";
        }
        if (this.name().equals("ADMISSION")) {
            return "Поступление товара на склад";
        }
        if (this.name().equals("DELETE_EXP")) {
            return "Списание просроченного товара";
        }
        if (this.name().equals("MOVE_TO_SHOP")) {
            return "Перемещение товара со склада в торговый зал";
        }
        if (this.name().equals("SERVE_CUSTOMER")) {
            return "Обслуживание посетителей";
        }
        return this.name();
    }
}