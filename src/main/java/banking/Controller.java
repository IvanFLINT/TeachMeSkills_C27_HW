package banking;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private ObjectMapper objectMapper;

    private CardService cardService = new CardService();
    private Map<Integer, Card> cardDatabase = new HashMap<>();

    public Controller() {
        cardDatabase.put(1, new Card(1, "BEL", 213123121, 5000));
        cardDatabase.put(2, new Card(2, "USA", 123456789, 3000));
    }

    @PostMapping("/api/getcard")
    public String getCard(@RequestBody Map<String, Integer> request) {
        int id = request.get("id");
        Card card = cardDatabase.get(id);
        if (card == null) {
            return "Карта не найдена";
        }
        try {
            return objectMapper.writeValueAsString(card);
        } catch (JsonProcessingException e) {
            return "Ошибка";
        }
    }

    @PostMapping("/api/postcard")
    public String updateCard(@RequestParam String name) {
        Card card = new Card(1, name, 234564231, 23423);
        String json = null;
        try {
            json = objectMapper.writeValueAsString(card);
        } catch (JsonProcessingException e) {
            System.out.println("Ошибка");
        }
        return json;
    }

    @PostMapping("/api/transfer")
    public String transferMoney(@RequestBody TransferRequest transferRequest) {
        Card fromCard = cardDatabase.get(transferRequest.getFromCardId());
        Card toCard = cardDatabase.get(transferRequest.getToCardId());

        if (fromCard == null || toCard == null) {
            return "Карта не найдена";
        }

        try {
            cardService.debit(fromCard, transferRequest.getAmount());
            cardService.credit(toCard, transferRequest.getAmount());
        } catch (IllegalArgumentException e) {
            return "Недостаточно средств";
        }

        try {
            return objectMapper.writeValueAsString(Arrays.asList(fromCard, toCard));
        } catch (JsonProcessingException e) {
            return "Ошибка";
        }
    }
}