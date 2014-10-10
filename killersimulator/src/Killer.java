import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Created by konstantindovzikov on 19.09.14.
 */
public class Killer {
    public static void main(String arg[]) {
        System.out.print("***Симулятор наемного убийцы***\n");
        new Killer().awake();
    }

    private Reader reader;
    
    public Killer() {
//        try {
//            reader = new Reader(new FileInputStream("src/input.txt"));
//        } catch (FileNotFoundException e) {
            reader = new Reader(System.in);
//        }
    }
//    private boolean reader.readAnswer() {
//        System.out.println("");
//        Scanner in = new Scanner(System.in);
//        String a = in.nextLine();
//        if ( a.equals("n")) return false;
//        return (a.equals("y"));
//    }

    private void awake() {
        System.out.print("*******************************\nТы проснулся.\n");
        hungry();
        System.out.print("Есть заказы на сегодня?\n");
        if (reader.readAnswer()) order();
        else day();
    }

    private void day() {
        weapon();
        dept1();
        hungry();
        recreation();
        watchnews();
        hungry();
        sleep();
    }

    private void watchnews() {
        System.out.print("Включи телевизор и посмотри вечерние новости, чтобы убедиться,\n " +
                "что нигде нет следов твоей деятельности и ты работаешь чисто..\n" +
                "Все чисто?\n");
        if (!reader.readAnswer())
            System.out.print("Позвони адвокату, объясни ситуацию, заплати денег, потребуй разрулить ситуацию\n");
    }

    private void recreation() {
        System.out.print("Хочешь потренироваться и пострелять белочек в лесу?\n");
        if (reader.readAnswer()) {
            System.out.print("Возьми винтовку и в путь...\nКогда закончишь, возвращайся домой безлюдными местами(у тебя нет лицензии на оружие)\n");
            ambash();
        }
    }

    private void dept1() {
        System.out.println("У тебя есть должники?");
        if (reader.readAnswer())
            System.out.println("Напомни ему об этом");
    }

    private void dept () { //допилить!!!
        System.out.print("У тебя есть должники?\n");
        if (reader.readAnswer()){
            System.out.print("Должник отвечает на звонки?\n");
            if (reader.readAnswer()) {
                System.out.print("Он готов вернуть долг?\n");
                if (reader.readAnswer())
                    System.out.print("Забери долг\n");
            } else  {
                System.out.print("Повышай процент, если отказывается, угрожай\n");
            }
        } else {
            System.out.print("Найди его и поговори с ним. Напомни ему, что долги нужно возвращать\n");
        }
    }

    private void hungry() {
        System.out.print("Ты голоден?\n");
        if (reader.readAnswer())
            System.out.print("Приготовь себе и перекуси.\n");
    }

    private void sleep() {
        System.out.print("Хочешь спать?\n");
        if (reader.readAnswer())
            System.out.print("Ляг, поспи.\n");
    }

    private void weapon() {
        System.out.print("Оружие в порядке?\n");
        if (!reader.readAnswer())
            System.out.print("Проведи диагностику, если нужны запчасти, необходимо сходить на черный рынок и приобрести их.\n");
    }

    private void ambash() {
        System.out.println("За тобой ведется слежка?");
        if (reader.readAnswer())
            System.out.print("Постарайся не паниковать. Попробуй оторваться, не выделяйся из толпы\nСлежка продолжается?\n");
        if (reader.readAnswer())
            System.out.print("Устрани слежку. Любыми методами и возвращайся в убежище\n");
    }

    private void order() {
        System.out.print("Ты уточнил условия заказа у заказчика?\n");
        if (!reader.readAnswer()) {
            System.out.print("Тебе нужно с ним встериться и обсудить заказ\n");
        }
        weapon();
        System.out.print("Ты построил план убийства?\n");
        if (!reader.readAnswer())
            System.out.print("Изучи место, цель, сопоставь факты.\nМожешь заранее осмотреть местность лично, чтобы выбрать удачную позицию для убийства\n");
        hungry();
        System.out.print("Немного отдохнув, отправляйся на работу\nНе забудь захватить свою винтовку\nЖди появления своей цели из места, которое заранее подобрал\n" +
                "Как только цель в зоне поражения - выстрел. Уходи, заметая следы.\n");
        ambash();
        System.out.print("По прибытию в убежище спрячь оружие, переоденься.\nСообщи заказчику о выполнении работы.\n");
        hungry();
        watchnews();
        sleep();
        awake();
    }
}
