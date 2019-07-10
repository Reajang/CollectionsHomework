package withMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class TaskWithMap {
    public static void main(String[] args) throws IOException {
        System.out.println("File: ");
        BufferedReader fileReader = new BufferedReader(new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        TreeMap<String, Integer> map = new TreeMap<>();//TreeMap автоматически упорядочит по ключам String в алфавитном порядке
        while (fileReader.ready()){
            String[] words = fileReader.readLine().split("\\s+");
            for(String word : words){
                if(!map.containsKey(word)) map.put(word, 1);
                else map.put(word, map.get(word)+1);
            }
        }
        fileReader.close();
        System.out.println("Статистика: ");
        printMap(map);//Вывод в консоль
        System.out.println("Слова с максимальным кол-вом повторений:");
        int max = 0;
        TreeMap<String, Integer> mapMax = new TreeMap<>();//Если слов с максимальным кол-вом повторений несколько
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            if(pair.getValue() >= max){
                if(pair.getValue() > max) {
                    max = pair.getValue();
                    mapMax.clear();
                }
                mapMax.put(pair.getKey(), pair.getValue());
            }
        }
        printMap(mapMax);//Вывод в консоль
    }

    private static void printMap(Map<String, Integer> map){//для вывода в консоль
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey() + " count: " + pair.getValue());
        }
    }
}
/*Есть входной файл с набором слов, написанных через пробел
Необходимо:
Прочитать слова из файла.
Отсортировать в алфавитном порядке.
Посчитать сколько раз каждое слово встречается в файле.
Вывести статистику на консоль
Найти слово с максимальным количеством повторений.
Вывести на консоль это слово и сколько раз оно встречается в
файле*/