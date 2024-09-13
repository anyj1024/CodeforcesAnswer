import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DrawQuestion {
    static Map<Integer, Pair> map = new HashMap<Integer, Pair>();
    static {
        map.put(1, new Pair("Java基础", 54));
        map.put(2, new Pair("Java集合", 23));
        map.put(3, new Pair("Java并发", 55));
        map.put(4, new Pair("JVM", 41));
        map.put(5, new Pair("MySQL", 68));
        map.put(6, new Pair("Redis", 49));
        map.put(7, new Pair("Spring", 69));
        map.put(8, new Pair("Spring Boot", 26));
        map.put(10, new Pair("操作系统", 21));
        map.put(11, new Pair("计算机网络", 30));
        map.put(12, new Pair("后端系统设计", 17));
        map.put(13, new Pair("后端场景", 21));
        map.put(14, new Pair("消息队列", 39));
        map.put(15, new Pair("设计模式", 34));
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> dailyQuestions = selectDailyQuestions(30);

        // 获取今天的日期并格式化
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dateString = today.format(formatter);

        // 构造文件路径（Windows 11 桌面路径）
        String desktopPath = System.getProperty("user.home") + "\\Desktop";
        String fileName = dateString + ".txt";
        String filePath = desktopPath + "\\" + fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Map.Entry<String, List<Integer>> entry : dailyQuestions.entrySet()) {
                String line = entry.getKey() + "：" +
                        entry.getValue().stream()
                                .map(Object::toString)
                                .collect(Collectors.joining(" "));
                writer.write(line);
                writer.newLine();
            }
            System.out.println("结果已写入文件：" + filePath);
        } catch (IOException e) {
            System.err.println("写入文件时发生错误：" + e.getMessage());
        }
    }

    public static Map<String, List<Integer>> selectDailyQuestions(int count) {
        Map<String, List<Integer>> selectedQuestions = new LinkedHashMap<>();
        List<Integer> allQuestions = new ArrayList<>();

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            int topicId = entry.getKey();
            String topicName = entry.getValue().getName();
            int questionCount = entry.getValue().getCount();

            int randomQuestion = (int)(Math.random() * questionCount) + 1;
            selectedQuestions.put(topicName, new ArrayList<>(Arrays.asList(randomQuestion)));

            for (int i = 1; i <= questionCount; i++) {
                if (i != randomQuestion) {
                    allQuestions.add(topicId * 100 + i);
                }
            }
        }

        int remainingCount = count - map.size();
        Collections.shuffle(allQuestions);
        List<Integer> additionalIds = allQuestions.subList(0, Math.min(remainingCount, allQuestions.size()));

        for (int id : additionalIds) {
            int topicId = id / 100;
            int questionNumber = id % 100;
            String topicName = map.get(topicId).getName();
            selectedQuestions.get(topicName).add(questionNumber);
        }

        for (List<Integer> questions : selectedQuestions.values()) {
            Collections.sort(questions);
        }

        return selectedQuestions;
    }

    static class Pair {
        String name;
        int count;

        public Pair(String name, int count) {
            this.name = name;
            this.count = count;
        }

        public int getCount() {
            return count;
        }

        public String getName() {
            return name;
        }
    }
}
