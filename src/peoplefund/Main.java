package peoplefund;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        List<String> inputs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputs.add(br.readLine());
        }
        BankOperations opt = new BankOperations();
        for (String item : inputs) {
            pw.println((int) opt.processOperation(item));
        }
        pw.flush();
        pw.close();
    }
}

interface IBankAccountOperation {
    void deposit(double d);

    void withdraw(double d);

    double processOperation(String message);
}

class BankOperations implements IBankAccountOperation {
    private double balance;

    @Override
    public void deposit(double d) {
        balance += d;
    }

    @Override
    public void withdraw(double d) {
        if (balance < d) {
            return;
        }

        balance -= d;
    }

    @Override
    public double processOperation(String operation) {
        AtomicReference<String> keyword = new AtomicReference<>();
        String lowerCaseOperation = operation.toLowerCase();
        Action action = Action.allKeywords().stream()
                .filter(lowerCaseOperation::contains)
                .findFirst()
                .map(findKeyword -> {
                    keyword.set(findKeyword);
                    return Action.findByKeyword(findKeyword);
                })
                .orElseThrow();

        double money;
        switch (action) {
            case SHOW_BALANCE:
                return balance;
            case DEPOSIT_FUNDS:
                money = findMoney(lowerCaseOperation, keyword.get());
                deposit(money);
                return balance;
            case WITHDRAW_FUNDS:
                money = findMoney(lowerCaseOperation, keyword.get());
                withdraw(money);
                return balance;
            default: throw new IllegalArgumentException();
        }
    }

    private double findMoney(String operation, String keyword) {
        String[] text = operation.split(" ");
        for (int i = 0; i < text.length - 1; i++) {
            if (text[i].equals(keyword)) {
                return Double.parseDouble(text[i + 1]);
            }
        }

        throw new IllegalArgumentException();
    }
}

enum Action {
    SHOW_BALANCE(Set.of("see", "show")),
    DEPOSIT_FUNDS(Set.of("deposit", "put", "invest", "transfer")),
    WITHDRAW_FUNDS(Set.of("withdraw", "pull"));

    private final Set<String> keywords;

    Action(Set<String> keywords) {
        this.keywords = keywords;
    }

    public static Set<String> allKeywords() {
        return Arrays.stream(values())
                .flatMap(action -> action.keywords.stream())
                .collect(Collectors.toSet());
    }

    public static Action findByKeyword(String keyword) {
        for (Action action : values()) {
            if (action.keywords.contains(keyword)) {
                return action;
            }
        }

        throw new IllegalArgumentException();
    }
}
