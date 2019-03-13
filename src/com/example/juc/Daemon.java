package com.example.juc;

public class Daemon {

	public static void main(String[] args) {
		Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
		thread.setDaemon(true);
		thread.start();
	}

	static class DaemonRunner implements Runnable {
		@Override
		public void run() {
			try {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} finally {
				System.out.println("DaemonThread finally run.");
			}
		}
	}
}
