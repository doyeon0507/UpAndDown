package upAndDown;


public enum Type {

	UP( new Function() {
		
		@Override
		public void updateRange( Range range ) {
			
			int center = range.getCenter();
			int max = range.getMax();
			if( center == max - 1 ) {
				center = max;
			}
			range.setMin( center );
			
		}
		
	} ),
	
	DOWN( new Function() {
		
		@Override
		public void updateRange( Range range ) {
			
			int center = range.getCenter();
			range.setMax( center );
			
		}
		
	} ),
	
	RIGHT( new Function() {
		
		@Override
		public void updateRange( Range range ) {}
		
	} );
	
	
	private Function function;
	
	Type( Function Function ) {
		
		this.function = Function;
		
	}
	
	public void updateRange( Range range ) {
		
		this.function.updateRange( range );
		
	}
	
	public static Type get( String typeName ) {

		return Enum.valueOf( Type.class, typeName.toUpperCase() );
		
	}
	
}