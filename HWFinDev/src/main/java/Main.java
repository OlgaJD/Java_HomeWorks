import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class node {
    int x, y, distance;

    node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.distance = dist;
    }
}

public class Main {
    public static int M = 5;
    public static int N = 5;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[][] field = MapGenerator();
        System.out.println("Поле для поиска пути:");
        System.out.println(rawData(field));
        int i = getNumber("Введите координату старта по оси x: ");
        int j = getNumber("Введите координаты старта по оси y: ");
        int x = getNumber("Введите координаты финиша по оси x: ");
        int y = getNumber("Введите координаты финиша по оси y: ");
        road(field, i, j, x, y);
    }

    public static int[][] MapGenerator() {
        int[][] map = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
        };
        return map;
    }

    public static int getNumber(String text) {
        System.out.printf(text);
        while (true) {
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число, попробуйте еще раз");
                scanner.next();
            }
            int number = scanner.nextInt();
            if (number < 0) {
                System.out.println("Число должно быть больше 0, попробуйте еще раз");
            } else {
                return number;
            }
        }
    }

    public static String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return ((row >= 0) && (row < M)) && ((col >= 0) && (col < N)) && (mat[row][col] == 1) && (!visited[row][col]);
    }

    static void road(int[][] array, int i, int j, int x, int y) {
        int[] row =
                {-1, 0, 0, 1};
        int[] col =
                {0, -1, 1, 0};
        boolean[][] visited = new boolean[M][N];
        Queue<node> q = new LinkedList<>();
        visited[i][j] = true;
        q.add(new node(i, j, 0));
        int minDist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            node node = q.poll();
            i = node.x;
            j = node.y;
            int dist = node.distance;
            if (i == x && j == y) {
                minDist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(array, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    node n = new node(i + row[k], j + col[k], dist + 1);
                    q.add(n);
                }
            }
        }

        if (minDist == Integer.MAX_VALUE) {
            System.out.print("Пути для выхода нет");
        } else {
            System.out.print("Длина пути " + minDist);
        }
    }
}