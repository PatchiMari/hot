//Интерфейс QueueBehaviour

public interface QueueBehaviour {
    void enqueue(Person person);
    Person dequeue();
}

//Интерфейс MarketBehaviour

public interface MarketBehaviour {
    void addPerson(Person person);
    void removePerson(Person person);
    void update();
}

//Класс Person (для имитации поведения в очереди):

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
//Класс Market:

import java.util.LinkedList;
import java.util.Queue;

public class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<Person> queue;

    public Market() {
        this.queue = new LinkedList<>();
    }

    @Override
    public void enqueue(Person person) {
        queue.add(person);
    }

    @Override
    public Person dequeue() {
        return queue.poll();
    }

    @Override
    public void addPerson(Person person) {
        enqueue(person);
    }

    @Override
    public void removePerson(Person person) {
        queue.remove(person);
    }

    @Override
    public void update() {
        // Обновление состояния магазина
        // Пример: обработка заказов, обслуживание клиентов
        if (!queue.isEmpty()) {
            Person servedPerson = dequeue();
            System.out.println("Serving: " + servedPerson.getName());
        }
    }
}
//Основной класс для тестирования:
public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        Person buyer1 = new Person("Alice");
        Person buyer2 = new Person("Bob");

        market.addPerson(buyer1);
        market.addPerson(buyer2);

        market.update(); // Обслуживание первого клиента
        market.update(); // Обслуживание второго клиента
    }
}