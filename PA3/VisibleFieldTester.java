// Name: Jene (Hojin) Choi
// USC NetID: hojincho
// CS 455 PA3
// Fall 2022

public class VisibleFieldTester {
   public static void main(String[] args) {
      boolean[][] mineData = new boolean[8][9];
      mineData[4][2] = true;
      mineData[3][8] = true;
      mineData[0][0] = true;
      mineData[2][2] = true;
      MineField mineField = new MineField(mineData);

      VisibleField visibleField = new VisibleField(mineField);
   }
}