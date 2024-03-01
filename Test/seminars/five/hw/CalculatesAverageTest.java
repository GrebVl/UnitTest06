package seminars.five.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatesAverageTest {

    CalculatesAverage calculatesAverage;

    @BeforeEach
    void setUp(){
        calculatesAverage = new CalculatesAverage(createList(10), createList(5));
    }


    public static List<Integer> createList(int size){
        List<Integer> list = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            list.add(r.nextInt(100) + 1);
        }

        return list;
    }

    @Test
    void averageFirstTest(){
        List<Integer> firstList = calculatesAverage.getFirstList();
        double averageFirstList = calculatesAverage.calculatesAverageList(firstList);

        assertEquals(calculatesAverage.averageFirst(), averageFirstList);
    }

    @Test
    void averageSecondTest(){
        List<Integer> secondList = calculatesAverage.getSecondList();
        double averageSecondList = calculatesAverage.calculatesAverageList(secondList);

        assertEquals(calculatesAverage.averageSecond(), averageSecondList);
    }

    @Test
    void calculatesAverageListTset(){
        List<Integer> list = createList(2);

        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        double result = sum/list.size();
        double averageList = calculatesAverage.calculatesAverageList(list);

        assertEquals(result, averageList);
    }

    @Test
    void comparesAveragesTestReturnFirstBigSecond(){
        String result = calculatesAverage.comparesAverages(5, 2);

        assertEquals("Первый список имеет большее среднее значение", result);
    }

    @Test
    void comparesAveragesTestReturnSecondBigFirst(){
        String result = calculatesAverage.comparesAverages(3, 7);

        assertEquals("Второй список имеет большее среднее значение", result);
    }

    @Test
    void comparesAveragesTestReturnSecondEqualFirst(){
        String result = calculatesAverage.comparesAverages(3, 3);

        assertEquals("Средние значения равны", result);
    }

    @Test
    void comparesAveragesListTest(){
        String result1 = calculatesAverage.comparesAveragesList();
        String result2 = calculatesAverage.comparesAverages(calculatesAverage.averageFirst(), calculatesAverage.averageSecond());

        assertEquals(result1, result2);
    }


}
