package interview.lesson4.hw4;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.*;
public class HandlerRequest {
    public static ResultSet resultSet;
    public void requestError(Connection connection) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement("SELECT title, lasting, time_start FROM " +
                "film LEFT JOIN lasting ON film.lasting_id = lasting.id " +
                "LEFT JOIN seance ON film.id = seance.film_id ORDER BY time_start");
        resultSet = statement.executeQuery();
        System.out.println("Название фильма     " + "Длительность   " + " Время начала");
        int valuationBetweenSeance = 510;
        while(resultSet.next()) {
            String title = resultSet.getString("title");
            int lasting = resultSet.getInt("lasting");
            Time timeStart = resultSet.getTime("time_start");
            int numberFromTime = getNumberFromTime(timeStart);
            int NormTimeBetweenSeance = (numberFromTime - valuationBetweenSeance) - 30;
            if (NormTimeBetweenSeance < lasting){
                System.out.println("Error schedules! Ошибка в росписании! Error!");
            }else
            System.out.println("Фильм:    " + title + "            " + lasting + "           " + timeStart + " " + NormTimeBetweenSeance);
            valuationBetweenSeance = numberFromTime;
        }
        System.out.println("1 request done");
    }

    public List<Seance> getListSeance(ResultSet resultSet) throws SQLException {
        List<Seance> seanceList = new ArrayList<>();
        while (resultSet.next()){
            String title = resultSet.getString("title");
            int lasting = resultSet.getInt("lasting");
            Time time_start = resultSet.getTime("time_start");
            Seance build = Seance.builder().title(title)
                    .lasting(lasting)
                    .timeStart(time_start).build();
            seanceList.add(build);
        }
        return seanceList;
    }
    public void requestPause(Connection connection) throws SQLException
    {
        PreparedStatement statement = connection.prepareStatement("SELECT title, lasting, time_start FROM " +
                "film LEFT JOIN lasting ON film.lasting_id = lasting.id " +
                "LEFT JOIN seance ON film.id = seance.film_id ORDER BY time_start");
        resultSet = statement.executeQuery();
        List<Seance> seanceList = getListSeance(resultSet);
        System.out.println("Sort by time start");
        System.out.println("Название фильма      Время начала       Длительность    Время начала next фильма    Длительность перерыва");
        Time lastElement = seanceList.get(0).getTimeStart();
        int pauseLast = 600;
        for (int i = 0; i < seanceList.size() - 1; i++) {
            Seance seance = seanceList.get(i);
            String title = seance.getTitle();
            int lasting = seance.getLasting();
            Time timeStart = seance.getTimeStart();
            Seance seance1 = seanceList.get(i + 1);
            Time timeStartNext = seance1.getTimeStart();
            int numberFromTime = getNumberFromTime(timeStart);;
            String numberTimeStartNext = timeStartNext.toString();
            String[] splitForPause = numberTimeStartNext.split(":");
            int pause = ((Integer.parseInt(splitForPause[0]) * 60 + Integer.parseInt(splitForPause[1]) - numberFromTime - lasting));
            int NormTimeBetweenSeance = (Integer.parseInt(splitForPause[0]) * 60 + Integer.parseInt(splitForPause[1]) - numberFromTime);
            seance.setPause(pause);
            seance.setTimeStartNext(timeStartNext);
            if (NormTimeBetweenSeance < lasting + 30){
                System.out.println("Error schedules! Ошибка в росписании! Error!");
            }else

            System.out.println("Фильм:    " + title + "          " +  timeStart + "                 " + lasting + "              " + timeStartNext + "                     "
                    + pause);
        }
        System.out.println("Фильм:    " + seanceList.get(seanceList.size()-1).getTitle() + "          "
                +  seanceList.get(seanceList.size()-1).getTimeStart() + "                 "
                + seanceList.get(seanceList.size()-1).getLasting() + "              \"no more seance\"");
        System.out.println("Sort by pause");
        System.out.println("Название фильма      Время начала       Длительность    Время начала next фильма    Длительность перерыва");
        seanceList.get(seanceList.size() - 1).setTimeStartNext(lastElement);
        seanceList.get(seanceList.size() - 1).setPause(pauseLast);
        seanceList.sort(comparing(Seance::getLasting));
        printSortListSeance(seanceList);
        System.out.println("2 request done");
    }
    public void printSortListSeance(List<Seance> seanceList){
        for (Seance s : seanceList) {
            if (s.getPause() < 30) {
            }
            else System.out.println("Фильм:    " + s.getTitle() + "          " +  s.getTimeStart() + "                 " + s.getLasting() + "              " + s.getTimeStartNext() + "                     "
                    + s.getPause());
        }
    }

    public int getNumberFromTime(Time time) {
        String number = time.toString();
        String[] split = number.split(":");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        return (a * 60) + b;
    }

    public void requestStat(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT title, avg(AMOUNT_TICKETS) as avg_ticket, \n" +
                "sum(AMOUNT_TICKETS) as sum_ticket, \n" +
                "sum(amount_tickets * cost) as total\n" +
                "FROM seance JOIN price on seance.price_id = price.id\n" +
                "JOIN film on seance.film_id = film.id  group by film.title \n" +
                "order by total;");
        resultSet = statement.executeQuery();
        System.out.println("Фильм   *  Среднее число зрителей за сеанс  *  Число посетителей за все время   *  Сумма сборов");

        while(resultSet.next()) {
            String title = resultSet.getString("title");
            int avgTicket = resultSet.getInt("avg_ticket");
            int sumTicket = resultSet.getInt("sum_ticket");
            int total = resultSet.getInt("total");
            System.out.println(title + "                   " +
                    avgTicket + "                                    " +
                    sumTicket + "                          " + total);
        }
    }
    public void getTotal (Connection connection) throws SQLException {
        PreparedStatement statementNew = connection.prepareStatement("SELECT sum(amount_tickets * cost) as total\n" +
                "FROM seance\n" +
                "JOIN price on seance.price_id = price.id\n" +
                "JOIN film on seance.film_id = film.id ;");
//        PreparedStatement ps = connection.prepareStatement("select * from film");
        resultSet = statementNew.executeQuery();
        if(resultSet.next()) {
            System.out.println("Всего сборов: " + resultSet.getInt("total"));
            System.out.println("3 request done");
        }
    }

    public void requestStatTimeStart(Connection connection) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT TIME_START, sum(AMOUNT_TICKETS) as sum_ticket, sum(amount_tickets * cost) as total \n" +
                "FROM seance\n" +
                "JOIN price on seance.price_id = price.id\n" +
                "JOIN film on seance.film_id = film.id  group by seance.TIME_START order by TIME_START");
        resultSet = statement.executeQuery();
        System.out.println("Начало сеанса * Число зрителей за сеанс * Сумма сборов");

        while(resultSet.next()) {
            Date timeStart = resultSet.getDate("time_start");
            int sumTicket = resultSet.getInt("sum_ticket");
            int total = resultSet.getInt("total");
            System.out.println(timeStart + "               " +
                    sumTicket + "                  " +
                    total);
        }
        System.out.println("4 request done");
    }

}

