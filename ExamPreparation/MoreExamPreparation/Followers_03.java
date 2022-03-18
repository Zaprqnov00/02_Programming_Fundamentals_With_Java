package Programming_f.BasicSyntax.PracticalExam05122021;

import java.util.*;
import java.util.stream.Collectors;

public class Followers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String,Integer> likesMap = new TreeMap<>();
        Map<String,Integer> commentsMap = new TreeMap<>();

        while (!command.equals("Log out")){
            List<String> input = Arrays
                    .stream(command.split(": "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            String username = input.get(1);

            switch (firstCommand){
                case "New follower":
                    if (!likesMap.containsKey(username) && !commentsMap.containsKey(username)){
                        likesMap.put(username,0);
                        commentsMap.put(username,0);
                    }
                    break;
                case "Like":
                    int count = Integer.parseInt(input.get(2));
                    if (!likesMap.containsKey(username)){
                        likesMap.put(username,count);
                    }else {
                        int currentLikes = likesMap.get(username);
                        likesMap.put(username,currentLikes + count);
                    }
                    break;
                case "Comment":
                    if (!commentsMap.containsKey(username)){
                        commentsMap.put(username,1);
                    }else {
                        int currentComments = commentsMap.get(username);
                        commentsMap.put(username,currentComments + 1);
                    }
                    break;
                case "Blocked":
                    if (likesMap.containsKey(username) && commentsMap.containsKey(username)){
                        likesMap.remove(username);
                        commentsMap.remove(username);
                    }else {
                        System.out.printf("%s doesn't exist.\n",username);
                    }
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("%d followers\n",likesMap.size());

        Map<String,Integer> sortedMap = new TreeMap<>();

        for (Map.Entry<String, Integer> entry : likesMap.entrySet()) {
            int totalLikesComments;
            int likes = entry.getValue();
            int comments = commentsMap.get(entry.getKey());
            totalLikesComments = likes + comments;
            sortedMap.put(entry.getKey(),totalLikesComments);
        }

        sortedMap.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(user -> System.out.printf("%s: %d\n",user.getKey(),user.getValue()));

    }
}
