package Esercitazione3;

import java.util.LinkedList;

public class User implements Comparable<User> {
    private String id;
    private String name;
    private LinkedList<BankAccount> accounts;

    public User(String id, String name, LinkedList<BankAccount> accounts) {
        try{
            if (id.startsWith("U"))
                this.id = id;
            else{ //In questo modo noteremo un'anomalia, e facendo in questo modo cercheremo un catch che la gestisca
                throw new InvalidUserIdException("ID must start with U");
            }
        }catch(InvalidUserIdException e){
            System.out.println(e);
        }
        this.name = name;
        this.accounts = new LinkedList<>(accounts);
    }

    public void addAccount(BankAccount account){
        try {
            if (!accounts.contains(account))
            this.accounts.add(account);
            else throw new BankAccountException("Account already exists");
        }catch(BankAccountException e){
            System.out.println(e);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public int compareTo(User o) {
        return CharSequence.compare(this.getId(), o.getId());
    }
}
