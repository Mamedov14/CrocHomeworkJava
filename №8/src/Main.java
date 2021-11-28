public class Main {

    public static void main(String[] args) {

        args[0] = "Забыл   Панкрат  Кондратьевич домкрат, \n" +
                "A без домкрату ну  не  поднять на тракте трактор.\n";
        int amWords = 0;
        String[] split = args[0].split(" ");
        for (int i = 0, splitLength = split.length; i < splitLength; i++) {
            String s = split[i];
            if (s.isEmpty()) {
            } else {
                amWords++;
            }
        }
        System.out.format("Всего слов: %d", amWords);
    }
}

