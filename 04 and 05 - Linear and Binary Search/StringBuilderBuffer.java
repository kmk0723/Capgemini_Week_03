public class StringBuilderBuffer {
    public static void main(String[] args) {
        double starttime;
        double endtime;

        starttime=System.nanoTime();
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<1000000;i++){
            sb1.append("java");
        }
        endtime=System.nanoTime();
        double performanceTime=starttime-endtime;
        System.out.println("Performance Time for StringgBuilder "+performanceTime);

        starttime=System.nanoTime();
        StringBuffer sb2=new StringBuffer();
        for(int i=0;i<1000000;i++){
            sb1.append("java");
        }
        endtime=System.nanoTime();
        performanceTime=starttime-endtime;
        System.out.println("Performance Time for StringgBuilder "+performanceTime);
    }

}
