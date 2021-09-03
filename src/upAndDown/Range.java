package upAndDown;


public class Range {

	private int min;
	private int max;
	
	public Range() {}
	public Range( int min, int max ) {
		
		this.set( min, max );
		
	}
	
	public void set( int min, int max ) {
		
		this.setMin( min );
		this.setMax( max );
		
	}
	
	public void setMin( int min ) {
		
		this.min = min;
		
	}
	
	public void setMax( int max ) {
		
		this.max = max;
		
	}
	public int getMin() {
		
		return this.min;
		
	}
	public int getMax() {
		
		return this.max;
		
	}
	public int getCenter() {
		
		return ( this.min + this.max ) / 2;
		
	}
	public boolean isWrong() {
		
		return this.max < this.min;
		
	}
	@Override
	public String toString() {
		return "Range [min=" + min + ", max=" + max + "]";
	}
	
	
	
}
