import java.sql.*;

public class DatabaseManager {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/valor_game";
    private static final String USER = "root"; // Update to your username if needed
    private static final String PASS = "sayed12345"; // Your MySQL password

    // ✅ Register the JDBC Driver explicitly for MySQL 9.x+ 
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        }
    }

    public static void saveScore(String name, String enemy, String result) {
        int score = 0;
    
        if (result.equals("Win")) {
            if (enemy.equalsIgnoreCase("Dragon")) {
                score = 100 + (int) (Math.random() * 101); // 100–200
            } else if (enemy.equalsIgnoreCase("Goblin")) {
                score = 50 + (int) (Math.random() * 51);   // 50–100
            } else {
                score = 50 + (int) (Math.random() * 51);
            }
        }
    
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO high_scores (player_name, enemy_name, result, score) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, enemy);
            ps.setString(3, result);
            ps.setInt(4, score);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving score to database:");
            e.printStackTrace();
        }
    }
    

    public static void displayHighScores() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT player_name, enemy_name, result, score FROM high_scores ORDER BY score DESC, id ASC LIMIT 5";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("\n=== High Scores ===");
            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                System.out.println(
                    rs.getString("player_name") + " vs " + rs.getString("enemy_name") +
                    " → " + rs.getString("result") + " (Score: " + rs.getInt("score") + ")"
                );
            }

            if (!hasResults) {
                System.out.println("No scores recorded yet.");
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving high scores:");
            e.printStackTrace();
        }
    }
}
