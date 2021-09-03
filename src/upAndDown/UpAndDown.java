package upAndDown;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UpAndDown {

	private Scanner scanner = new Scanner(System.in); 
	private Range range = new Range();
	private List<Integer> questionHistory = new ArrayList<>();
	private boolean debug = true;
	
	public UpAndDown() {

		try {
			
			this.setRange( 0, 100 );
			
		} catch (Exception e) {
			// no exception
		}
		
	}
	
	public UpAndDown( int minValue, int maxValue ) throws Exception {
		
		this.setRange( minValue, maxValue );
		
	}
	
	public void setRange( int minValue, int maxValue ) throws Exception {
		
		if( maxValue <= minValue ) {
			
			throw new Exception( "minValue는 반드시 maxValue보다 작아야합니다." );
			
		}
		
		this.range.set( 0, 100 );
		
	}
	
	private void debugConsole() {
		
		if( this.debug == false ) {
			return;
		}
		
		System.out.println( this.range );
		
	}
	
	private void clearConsole() {
		
		for( int i=0; i<100; ++i ) {
			System.out.println("");
		}
		
	}
	
	private void showWrongMessage() {
		
		System.out.println( "플레이어는 잘못된 정보를 입력했었습니다." );
		System.out.println( "게임이 종료됩니다." );
		
	}
	
	private void showPlayerCommand() {
		
		System.out.println( "플레이어가 입력할 수 있는 값: " + Arrays.toString( Type.values() ) );
		
	}
	
	private void needsAnyCommand() {
		System.out.println( "계속하려면, 아무키나 눌르세요." );
		scanner.nextLine();
	}
	
	public void start() {
		
		System.out.println( "UpAndDown 게임을 시작합니다." );
		System.out.println("");
		System.out.println("");
		System.out.println( "[ 규칙 ]" );
		System.out.println( this.range.getMin() + " <= { 플레이어가 생각해야하는 숫자 } <= " + this.range.getMax()  );
		System.out.println("");
		this.showPlayerCommand();
		System.out.println("");
		System.out.println("");
		this.needsAnyCommand();
		
		while( true ) {
			
			this.clearConsole();
			
			// 범위가 말이 안되게 변경된 경우? -> 사용자가 잘못답변함
			if( this.range.getMax() < this.range.getMin() ) {
				showWrongMessage();
				System.exit(0);
			}

			int center = this.range.getCenter();
			
			// 이미 답변을 한적이 있는데, 또 같은 값을 말하게 되는경우? -> 사용자가 잘못답변함
			if( this.questionHistory.contains( center )  ) {
				showWrongMessage();
				System.exit(0);
			}
			
			this.debugConsole();
			System.out.println( "플레이어가 생각하는 숫자는 " + center + "입니까?" );
			this.questionHistory.add( center );
			
			String answer = scanner.nextLine();
			
			try {
				
				Type type = Type.get( answer );
				
				if( type == Type.RIGHT ) {

					System.out.println("컴퓨터가 숫자를 맞췄습니다.");
					break;
					
				}
				
				type.updateRange( this.range );
				
				
			}catch (Exception e) {
				
				System.out.println( "값을 잘못 입력하셨습니다." );
				this.showPlayerCommand();
				this.needsAnyCommand();
				
			}
			
		}
		
	}
	
}
