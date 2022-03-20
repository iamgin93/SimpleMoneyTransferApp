package java.moneytransfer;

import java.util.*;

public class TestMoneyTransfer {
    public static void main(String[] args) {

        //BufferedReader
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String name = br.readLine();                // Reading input from STDIN
//        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        List<String> strings = new ArrayList<>();
        int counter = 0;

        while (s.hasNextLine()) {
            // Reading input from STDIN

            String input = s.nextLine();
//            System.out.println(input);
            strings.add(input);
            if (input.isEmpty())
                break;
        }
        String firstLine = strings.get(0);
        int numberOfUsers = Integer.parseInt(firstLine.split(" ")[0]);
        int numberOfTxns = Integer.parseInt(firstLine.split(" ")[1]);
        Map<String, Integer> balanceMap = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i <= numberOfUsers; i++) {
            balanceMap.put(strings.get(i).split(" ")[0], Integer.parseInt(strings.get(i).split(" ")[1]));
        }

        for (int i = numberOfUsers + 1; i <= numberOfUsers + numberOfTxns; i++) {
            Transaction transaction = new Transaction();
            transaction.setDeliverer(strings.get(i).split(" ")[0]);
            transaction.setReceiver(strings.get(i).split(" ")[1]);
            transaction.setTransactionAmount(Integer.parseInt(strings.get(i).split(" ")[2]));
            transactions.add(transaction);
        }

        balance(balanceMap, transactions);
//        for (String user : balanceMap.keySet()) {
//            System.out.println(user + " " + balanceMap.get(user));
//        }
    }

    @SuppressWarnings("boxing")
    private static void balance(Map<String, Integer> balanceMap, List<Transaction> transactions) {

        for (Transaction transaction : transactions) {
            if (transaction.getTransactionAmount() < balanceMap.get(transaction.getDeliverer())) {
                String deliverer = transaction.getDeliverer();
                String receiver = transaction.getReceiver();
                balanceMap.put(deliverer, balanceMap.get(deliverer) - transaction.getTransactionAmount());
                balanceMap.put(receiver, balanceMap.get(receiver) + transaction.getTransactionAmount());
            }
        }

        for (String user : balanceMap.keySet()) {
            System.out.println(user + " " + balanceMap.get(user));
        }
    }

    public static class Transaction {
        String receiver; // receiver
        String deliverer; // first person in line (deliverer)
        Integer transactionAmount;

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getDeliverer() {
            return deliverer;
        }

        public void setDeliverer(String deliverer) {
            this.deliverer = deliverer;
        }

        public Integer getTransactionAmount() {
            return transactionAmount;
        }

        public void setTransactionAmount(Integer transactionAmount) {
            this.transactionAmount = transactionAmount;
        }

    }

}
