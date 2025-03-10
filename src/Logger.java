import java.util.ArrayList;

public class Logger {
    // 기록 저장 / 호출 / 관리

    // 솔직히 단순한 기능이라 굳이 private 걸어놔야 할까 싶긴 한데. 연습이니까.
    private static ArrayList<String> logs = new ArrayList<>();


    public static void add(String log) {
        logs.add(log);
    }

    public static void add(int index, String log) {
        logs.add(index, log);
    }

    public static String getAll() {
        String r = "";

        for(int i=0; i < logs.size(); i++){
            r += i + ": " + logs.get(i) + "\n";
        }

        return r;
    }

    public static void remove(){
        logs.removeLast();
    }

    public static void clear(){
        logs.clear();
    }

    public static String getLast(){
        return logs.getLast();
    }

}
