public class T {

    public static int  aa(){
        int c = 0;
        try {
            System.out.println("你呀");
             c=1/0;
            System.out.println("你后");
        }catch (Exception a){
            System.out.println(a+"你");
        }


        return c ;
    }

    public static void main(String[] args){
        System.out.println(T.aa());
    }
}
