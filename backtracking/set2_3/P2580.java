package set2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2580 {

	static int size = 9;
	static int sudoku[][] = new int[size][size];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for(int i=0; i<size; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<size; j++)
				sudoku[i][j] = Integer.parseInt(st.nextToken());
		}

		// 구현 
		bfs(0, 0);
	}

	static void bfs(int row, int col) {
		// return 안해줘서 런타임 에러 2
		if(col == size) {
			bfs(row+1, 0);
			return;
		}
		
		if(row == size) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) 
					sb.append(sudoku[i][j]+" ");


				sb.append(" \n");	
			}

			System.out.println(sb.toString());
			System.exit(0);
		}

		// 0이 아닌 경우를 먼저 넣어서 틀림 1 
		if(sudoku[row][col] == 0) {
			for(int i=1; i<=size; i++) {
				if(possible(row, col, i)) {
					sudoku[row][col] = i;
					bfs(row, col+1);
				}
			}

			sudoku[row][col] = 0;
			return;
		}
		
		bfs(row, col+1);
	}

	static boolean possible(int row, int col, int num) {
		// 가로 - 세로 확인
		for(int i=0; i<size; i++) {
			if(sudoku[row][i] == num || sudoku[i][col] == num)
				return false;
		}

		// 3x3 정사각형 확인 
		int rowStart = row/3*3;
		int colStart = col/3*3;
		
		for(int i=rowStart; i<rowStart+3; i++) {
			for(int j=colStart; j<colStart+3; j++) {
				if(sudoku[i][j] == num)
					return false;
			}
		}

		return true;
	}
}
