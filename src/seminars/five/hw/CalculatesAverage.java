package seminars.five.hw;

import java.util.List;

public class CalculatesAverage {
    private List<Integer> firstList;
    private List<Integer> secondList;

    public CalculatesAverage(List<Integer> firstList, List<Integer> secondList){
        this.firstList = firstList;
        this.secondList = secondList;
    }

    public List<Integer> getFirstList() {
        return firstList;
    }

    public List<Integer> getSecondList() {
        return secondList;
    }

    public double averageFirst(){
        return calculatesAverageList(this.firstList);
    }

    public double averageSecond(){
        return calculatesAverageList(this.secondList);
    }

    public String comparesAveragesList(){
        return comparesAverages(averageFirst(), averageSecond());
    }

    public double calculatesAverageList(List<Integer> list){
        int sum = 0;
        for(int number : list){
            sum += number;
        }
        return (double) sum/list.size();
    }


    public String comparesAverages(double first, double second){
        if(first > second){
            return "Первый список имеет большее среднее значение";
        }else if(first < second){
            return "Второй список имеет большее среднее значение";
        }else if(first == second){
            return "Средние значения равны";
        }else{
            return null;
        }
    }
}
