package kr.or.ddit.basic;

public class T04_ThreadTest {
   
	/*
	    1~20억까지의 합계를 구하는데 걸린 시간 체크하기
	        전체 합계를 구하는 작업을 단독으로 했을 때 (1개의 스레드를 사용했을 때)와
	        여러 스레드를 분할해서 작업할 때의 시간을 확인해 보자.
	 */
	
	    public static void main(String[] args) {
			
	    	// 단독으로 처리할 때...
	    	SumThread sm = new SumThread(1L, 2000000000L);
	    	
	    	long startTime = System.currentTimeMillis();
	    	
	    	sm.start();
	    	
	    	try {
	    		sm.join();
	    	} catch(InterruptedException ex) {
	    		ex.printStackTrace();
	    	}
	    	
	    	long endTime = System.currentTimeMillis();
	    	
	    	System.out.println("단독으로 처리할 때의 처리시간 : " + (endTime - startTime));
	    	
	    	System.out.println("\n\n");
	    	
	    	// 여러 스레드가 협력해서 처리 했을 때
	    	SumThread[] sumThs = new SumThread[] {
	    			new SumThread(         1L,  500000000L),
	    			new SumThread( 500000001L, 1000000000L),
	    			new SumThread(1000000001L, 1500000000L),
	    			new SumThread(1500000001L, 2000000000L)
	    	};
	    	
	    	startTime = System.currentTimeMillis();
	    	for (Thread th : sumThs) {
				th.start();
			}
	    	
	    	for (Thread th : sumThs) {
				try {
					th.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				endTime = System.currentTimeMillis();
				
				System.out.println("협력 처리 했을 때의 처리시간 : " + (endTime - startTime));
			}
	    	
		}
	
}

class SumThread extends Thread {
	private long max, min;
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i=min; i<=max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + "까지의 합: " + sum);
	}
	
}
