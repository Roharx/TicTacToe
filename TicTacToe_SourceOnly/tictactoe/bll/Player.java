package tictactoe.bll;

public class Player {

    private int maxHealth = 5;
    private int health = 5;
    private int damage = 1;
    private int armour = 0;
    private int money = 0;
    private int mana = 0;
    private int attackPower = 0;

    //region getters & setters
    public int getMaxHealth() {return maxHealth;}

    public int getHealth() {return health;}
    public void setHealth(int health){this.health = health;}

    public int getDamage() {return damage;}
    public void setDamage(int damage){this.damage = damage;}

    public int getMoney() {return money;}
    public void setMoney(int money){this.money = money;}

    public int getMana() {return mana;}
    public void setMana(int mana){this.mana = mana;}
    //endregion



    public void receiveDamage(int damage){
        if(armour < damage){
            health -= damage - armour;

            if(armour > 0)
                armour--;
        }

    }

    public void getCoins(int coinAmount){
        money += coinAmount;
    }

    public void heal(int healAmount){
        if(health + healAmount <= maxHealth)
            health += healAmount;
        else
            health = maxHealth;
    }

    public void increaseHealth(int value){
        maxHealth += value;
    }

    public void decreaseHealth(int value){
        if(maxHealth - value < 2)
            maxHealth = 1;
        else
            maxHealth -= value;
    }

    public void increaseArmour(int value){
        armour += value;
    }

    public void decreaseArmour(int value){
        armour -= value; //intentionally can go into negative value
    }

    public void increaseAttackPower(int value){
        attackPower += value;
    }

    public void decreaseAttackPower(int value){
        if(attackPower - value < 2)
            attackPower = 1;
        else
            attackPower -= value;
    }

    public void dealDamageTo(Player enemy){
        enemy.receiveDamage(damage + attackPower);
    }
}
