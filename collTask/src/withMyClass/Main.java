package withMyClass;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


import static java.util.stream.Collectors.toList;


public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("File: ");
        BufferedReader fileReader = new BufferedReader(new FileReader(new File(new BufferedReader(new InputStreamReader(System.in)).readLine())));
        ArrayList<MyClass> list = new ArrayList<>();
        while(fileReader.ready()){
            String[] words = fileReader.readLine().split("\\s+");
            for(String word : words){
                MyClass thing = new MyClass(word);
                if(!list.contains(thing)) list.add(thing);
                else{
                    MyClass old = list.get(list.indexOf(thing));
                    list.set(list.indexOf(thing), new MyClass(old.getString(),old.getCount()+1));
                }
            }
        }
        fileReader.close();

        Collections.sort(list, (o1, o2) -> o1.getString().compareTo(o2.getString()));//сортировка по строкам

        for(MyClass myClass : list){
            System.out.println(myClass);//Вывод отсортированного списка
        }
        System.out.println("Максимальное кол-во повторений: ");
        int max = list.stream().mapToInt(MyClass::getCount).max().getAsInt();//нахождение максимального кол-во повторений слова

        System.out.println(list.stream().filter(s-> s.getCount() == max).collect(toList())); //вывод слов с максимальным кол-вом повторений
    }

}
