package banking;

public class CardService {

    public void debit(Card card, int amount) {
        if (card.getBalance() >= amount) {
            card.setBalance(card.getBalance() - amount);
        } else {
            throw new IllegalArgumentException("Недостаточно средств");
        }
    }

    public void credit(Card card, int amount) {
        card.setBalance(card.getBalance() + amount);
    }
}
