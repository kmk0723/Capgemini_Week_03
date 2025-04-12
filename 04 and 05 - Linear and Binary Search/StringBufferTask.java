class StringBufferTask extends Thread {
    StringBuffer sb;

    StringBufferTask(StringBuffer sb) {
        this.sb = sb;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            sb.append(i).append(" ");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuffer sb = new StringBuffer("Numbers: ");

        Thread t1 = new StringBufferTask(sb);
        Thread t2 = new StringBufferTask(sb);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sb);
    }
}
