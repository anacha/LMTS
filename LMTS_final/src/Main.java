public class Main {
    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws java.io.IOException{
        SplashScreen splash = new SplashScreen();
        splash.setVisible(true);

        try{
            Thread.sleep(2000);
        }catch(InterruptedException e){}
        splash.dispose();
        MainWindow mainWin=new MainWindow();
        mainWin.setVisible(true);
       // mainFrame.setSize(210, 420);
    }
}