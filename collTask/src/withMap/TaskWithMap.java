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
        TreeMap<String, Integer> map = new TreeMap<>();//TreeMap ������������� ���������� �� ������ String � ���������� �������
        while (fileReader.ready()){
            String[] words = fileReader.readLine().split("\\s+");
            for(String word : words){
                if(!map.containsKey(word)) map.put(word, 1);
                else map.put(word, map.get(word)+1);
            }
        }
        fileReader.close();
        System.out.println("����������: ");
        printMap(map);//����� � �������
        System.out.println("����� � ������������ ���-��� ����������:");
        int max = 0;
        TreeMap<String, Integer> mapMax = new TreeMap<>();//���� ���� � ������������ ���-��� ���������� ���������
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            if(pair.getValue() >= max){
                if(pair.getValue() > max) {
                    max = pair.getValue();
                    mapMax.clear();
                }
                mapMax.put(pair.getKey(), pair.getValue());
            }
        }
        printMap(mapMax);//����� � �������
    }

    private static void printMap(Map<String, Integer> map){//��� ������ � �������
        for(Map.Entry<String, Integer> pair : map.entrySet()){
            System.out.println(pair.getKey() + " count: " + pair.getValue());
        }
    }
}
/*���� ������� ���� � ������� ����, ���������� ����� ������
����������:
��������� ����� �� �����.
������������� � ���������� �������.
��������� ������� ��� ������ ����� ����������� � �����.
������� ���������� �� �������
����� ����� � ������������ ����������� ����������.
������� �� ������� ��� ����� � ������� ��� ��� ����������� �
�����*/